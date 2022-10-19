package com.hendisantika.controller;


import com.hendisantika.config.MovieService;
import com.hendisantika.entity.Film;
import com.hendisantika.entity.Salle;
import com.hendisantika.repository.IMovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public String index() {
        return "redirect:/salle/show/list";
    }

    @GetMapping("/list/1")
    public String showMovies() {

        return "/movies/list";

    }

}
