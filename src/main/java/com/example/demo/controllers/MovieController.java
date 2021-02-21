package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    private final String goBack = "<br><a href=http://localhost:8080/movieAnalyzer>Go to front page</a>";

    @ResponseBody
    @GetMapping("/movieAnalyzer")
    public ModelAndView hello() {
        return new ModelAndView("movieAnalyzer");
    }

    @ResponseBody
    @GetMapping("/movieAnalyzer/getFirst")
    public String getFirst() {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getInfo() + goBack;
    }

    @ResponseBody
    @GetMapping("/movieAnalyzer/getRandom")
    public String getRandom() {
        Movie randomMovie = movieService.getRandomMovie();
        return randomMovie.getInfo() + goBack;
    }
    @ResponseBody
    @GetMapping("/movieAnalyzer/getTenRandom")
    public String getTenRandom() {
        return movieService.getTenSortByPopularity() + goBack;
    }

    @ResponseBody
    @GetMapping("/movieAnalyzer/howManyWonAnAward")
    public String howManyWonAnAward() {
        return movieService.howManyWonAnAward() + goBack;
    }


}
