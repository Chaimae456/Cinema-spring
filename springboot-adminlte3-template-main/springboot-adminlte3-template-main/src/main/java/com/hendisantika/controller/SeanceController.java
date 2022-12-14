package com.hendisantika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hendisantika.config.MovieService;
import com.hendisantika.config.SalleService;
import com.hendisantika.config.SeanceService;
import com.hendisantika.entity.Film;
import com.hendisantika.entity.Seance;

@Controller
@RequestMapping("seance")
public class SeanceController {
	
	private SalleService salleservice;
	private MovieService movieservice;
	private SeanceService seanceservice;
	
	@Autowired
	public void setSalleService(SalleService salleService) {
		this.salleservice = salleService;
	}
	
	@Autowired
	public void setMovieService(MovieService movieservice) {
		this.movieservice = movieservice;
	}
	
	@Autowired
	public void setSeanceService(SeanceService seanceservice) {
		this.seanceservice = seanceservice;
	}
	
	@GetMapping
    public String index() {
        return "redirect:/seance/1";
    }
	

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Seance> page = seanceservice.getList(pageNumber);
        System.out.println(page.getContent().get(0).getFilm().getAnnee()+"11111111111111111111111111111                 111111111111111111111111111111111111111111111111");
        System.out.println("Taille de la page :  dsqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
       
        model.addAttribute("listSeance", page);
        System.out.println();
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        
        return "seance/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("seance", new Seance());
        System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
      model.addAttribute("listeFilms", movieservice.getListAll());
      model.addAttribute("listeSalle", salleservice.getListAll());
        return "seance/form";

    }
    
    @PostMapping(value = "/save")
    public String save(Seance seance, final RedirectAttributes ra) {
      System.out.println("ffffffffffffffffffffffffffffffffffffffffffffff");
        Seance save = seanceservice.save(seance);
        ra.addFlashAttribute("successFlash", "Movie Ajout??e avec succ??s");
        return "redirect:/seance";

    }
    
    
    
    
    @GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		seanceservice.delete(id);
		return "redirect:/seance/1";
	}
    

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("seance", seanceservice.get(id));
		model.addAttribute("films",movieservice.getListAll());
		model.addAttribute("salles",salleservice.getListAll());
		 return "seance/form";
	}
	
    
    
}
