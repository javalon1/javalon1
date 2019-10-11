package com.tbar.sda.pokemonAndChuckNorris.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieDatabaseController {
    private final MoviesProvider moviesProvider;
    public MovieDatabaseController(@Autowired MoviesProvider moviesProvider) {
        this.moviesProvider = moviesProvider;
    }
    @GetMapping
    @RequestMapping("/showMoviesPage")
    public String showMoviesPage(Model model){
        String searchQuery = "Star";
        List<Movie> movies = moviesProvider.getMovies(searchQuery);
        model.addAttribute("movies", movies);
        return "showMoviesPage";
    }

}
