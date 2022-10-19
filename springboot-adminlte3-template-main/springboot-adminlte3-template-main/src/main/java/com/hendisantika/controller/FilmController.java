package com.hendisantika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendisantika.config.FilmService;
import com.hendisantika.config.GenreService;
import com.hendisantika.config.NationaliteService;
import com.hendisantika.config.PersonneService;
import com.hendisantika.entity.Film;
import com.hendisantika.entity.Personne;

@Controller
@RequestMapping("film")
public class FilmController {
	
	private FilmService filmservice;
	private GenreService genreservice;
    private NationaliteService nationaliteService;
    private PersonneService personneservice;
    
  
    @Autowired
	public void setPersonneservice(PersonneService personneservice) {
		this.personneservice = personneservice;
	}

	@Autowired
    public void setFilmService(FilmService filmservice) {
        this.filmservice = filmservice;
    }
    
    @Autowired
    public void setGenreService(GenreService genreservice) {
        this.genreservice = genreservice;
    }
    
    @Autowired
    public void setNationaliteService(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }

    
    @GetMapping
    public String index() {
        return "redirect:/film/1";
    }
    
    
    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film> page = filmservice.getList(pageNumber);
        
        
        System.out.println("Taille de la page : ");
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("listFilm", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "Film/list";

    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("listeGenres", genreservice.getListAll());
        model.addAttribute("listeNationalite", nationaliteService.getListAll());
        model.addAttribute("listeRealisateur", personneservice.getListAll().stream());
        return "personne/form";

    }
    
    
    
}
