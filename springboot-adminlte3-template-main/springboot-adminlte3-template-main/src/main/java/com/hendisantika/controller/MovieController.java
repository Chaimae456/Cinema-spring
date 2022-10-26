package com.hendisantika.controller;


import com.hendisantika.config.GenreService;
import com.hendisantika.config.MovieService;
import com.hendisantika.config.NationaliteService;
import com.hendisantika.config.PersonneService;
import com.hendisantika.entity.Film;
import com.hendisantika.entity.Salle;
import com.hendisantika.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.FileUploadUtil;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("movies")
public class MovieController {


  private final String UPLOAD_DIR = "/src/main/resources/static/videos/movies/";
    private MovieService movieService;
    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
    @Autowired
    public void setNatService(NationaliteService natService) {
        this.natService = natService;
    }
    @Autowired
    public void setPersonneService(PersonneService personneService) {
        this.personneService= personneService;
    }
    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    private PersonneService personneService;
    private NationaliteService natService;
    private GenreService genreService;

//    private SeanceService seanceService;

    @GetMapping
    public String index() {
        return "redirect:/movies/1";
    }

//    @GetMapping("/list/1")
//    public String showMovies() {
//
//        return "/movies/list";
//
//    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film> page = movieService.getList(pageNumber);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        model.addAttribute("listMovies", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        return "movies/list";

    }

    private void parametersToPass(Model model){
        model.addAttribute("listeNationalites", natService.getListAll());
        model.addAttribute("listeGenres", genreService.getListAll());
        model.addAttribute("listeRealisateur", personneService.getAllRealisateur());
        model.addAttribute("listeActeur", personneService.getAllActeur());
//    model.addAttribute("listeSeance", seanceService.getListAll());

    }

    @GetMapping("/add")
    public String add(Model model) {
        parametersToPass(model);
        model.addAttribute("movie", new Film());
        return "movies/form";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        parametersToPass(model);
        model.addAttribute("movie", movieService.get(id));
        return "movies/form";
    }

    @PostMapping(value = "/save")
    public String save(Film movie, final RedirectAttributes ra) {
//        System.out.println(movie.getActeurs().size());
        Film save = movieService.save(movie);
        ra.addFlashAttribute("successFlash", "Movie Ajoutée avec succès");
        
        
        
        
        return "redirect:/movies";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        movieService.delete(id);
        return "redirect:/movies";

    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.get(id));

        
        return "movies/details";

    }
//
//    @GetMapping("/show/list")
//    public String showPersons() {
//        return "/movies/list";
//    }
}