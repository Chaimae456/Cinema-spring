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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public String index() {
        return "redirect:/movies/1";
    }

    @GetMapping("/list/1")
    public String showMovies() {

        return "/movies/list";

    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film> page = movieService.getList(pageNumber);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        model.addAttribute("listPersonnes", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        return "movies/list";

    }



    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("movie", new Salle());
        return "movies/form";

    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.get(id));
        return "movies/form";
    }

    @PostMapping(value = "/save")
    public String save(Film movie, final RedirectAttributes ra) {

        Film save = movieService.save(movie);
        ra.addFlashAttribute("successFlash", "Salle Ajoutée avec succès");
        return "redirect:/movies";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        movieService.delete(id);
        return "redirect:/salle";

    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.get(id));
        return "movies/details";

    }

    @GetMapping("/show/list")
    public String showPersons() {
        return "/movies/list";
    }
}
