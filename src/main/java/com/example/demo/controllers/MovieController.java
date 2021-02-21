package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import com.example.demo.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    private final String goBack = "<br><a href=http://localhost:8080/movieAnalyzer>Go to front page</a>";


    @GetMapping("/movieAnalyzer")
    public String hello() {
        return "movieAnalyzer";
    }

    @GetMapping("/movieAnalyzer/getFirst")
    public String getFirst(Model model) {
        model.addAttribute("getFirst", movieService.getAllMovies());
        //Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return "getFirst";
    }

    @GetMapping("/movieAnalyzer/getRandom")
    public String getRandom() {
        Movie randomMovie = movieService.getRandomMovie();
        return randomMovie.getInfo() + goBack;
    }

    @GetMapping("/movieAnalyzer/getTenRandom")
    public String getTenRandom() {
        return movieService.getTenSortByPopularity() + goBack;
    }


    @GetMapping("/movieAnalyzer/howManyWonAnAward")
    public String howManyWonAnAward() {
        return movieService.howManyWonAnAward() + goBack;
    }


}
