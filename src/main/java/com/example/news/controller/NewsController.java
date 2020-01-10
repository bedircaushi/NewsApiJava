package com.example.news.controller;

import com.example.news.pojo.Message;
import com.example.news.pojo.News;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

   @Autowired
   private NewsService newsService;

   @GetMapping("/news")
    public List<News> getAllNews(){
           return newsService.getAll();
   }

    @GetMapping("/news/{sport}")
    public List<News> getAllNewsBySport(@PathVariable(value = "sport") String sport){
        return newsService.getAllBySport(sport);
    }

    @GetMapping("/news/{sport}/{league}")
    public List<News> getAllNewsBySportAndLeague(@PathVariable(value = "sport") String sport,
                                                 @PathVariable(value = "league") String league){
       return newsService.getAllBySportAndLeague(sport,league);
    }

    @DeleteMapping("/news/{hash}")
    public void delete(@PathVariable(value = "hash") String hash){
       newsService.deleteNews(hash);
    }
}
