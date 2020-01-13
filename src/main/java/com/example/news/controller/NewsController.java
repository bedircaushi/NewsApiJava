package com.example.news.controller;

import com.example.news.input.Message;
import com.example.news.input.NewsInput;
import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.List;

@RestController
public class NewsController {

   @Autowired
   private NewsService newsService;


   @GetMapping("/news")
   public ResponseEntity getAllNews(@RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
       
       List<News> news = newsService.getAll(PageRequest
               .of(offset, limit, Sort.by("publishedAt").descending()));

       if(news.isEmpty())
           return new ResponseEntity<>(new Message("No news found" ), HttpStatus.OK);

       return new ResponseEntity<List>(news, HttpStatus.OK);
   }


   @GetMapping("/news/{sport}")
   public ResponseEntity getAllNewsBySport(@PathVariable(value = "sport") String sport,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       @RequestParam(value = "offset", defaultValue = "0") Integer offset) {

        List<News> news = newsService.getAllBySport(sport, PageRequest
                .of(offset, limit, Sort.by("publishedAt").descending()));

        if(news.isEmpty())
            return new ResponseEntity<>(new Message("No news found for " + sport), HttpStatus.OK);

        return new ResponseEntity<List>(news, HttpStatus.OK);
   }


   @GetMapping("/news/{sport}/{league}")
   public ResponseEntity getAllNewsBySportAndLeague(@PathVariable(value = "sport") String sport,
                                                @PathVariable(value = "league") String league,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                @RequestParam(value = "offset", defaultValue = "0") Integer offset) {

       List<News> news = newsService.getAllBySportAndLeague(sport,league,PageRequest
               .of(offset, limit, Sort.by("publishedAt").descending()));

       if(news.isEmpty())
           return new ResponseEntity<>(new Message("No news found for " + league), HttpStatus.OK);

       return new ResponseEntity<List>(news, HttpStatus.OK);
   }


   @PostMapping("/news/add")
   public ResponseEntity addNews(HttpServletRequest request, @RequestBody NewsInput input) {

       Admin admin = (Admin) request.getSession().getAttribute("admin");
       if (admin != null) {
           News news = newsService.create(input, admin);
           if (news != null)
               return new ResponseEntity<>(news, HttpStatus.OK);
           return  new ResponseEntity<>(new Message("News object already registered"), HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(new Message("Not logged in"), HttpStatus.OK);
   }


   @PostMapping("/news/update/{hash}")
   public ResponseEntity updateNews(@PathVariable(value = "hash") String hash, HttpServletRequest request, @RequestBody NewsInput input) {

       Admin admin = (Admin) request.getSession().getAttribute("admin");

       if (admin != null) {
           News news = newsService.update(input, admin, hash);
           if (news != null)
               return new ResponseEntity<>(news, HttpStatus.OK);
           return  new ResponseEntity<>(new Message("News object does not exist or you do not have access to update"), HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(new Message("Not logged in"), HttpStatus.OK);
   }


   @DeleteMapping("/news/{hash}")
   public void delete(@PathVariable(value = "hash") String hash){
       newsService.deleteNews(hash);
   }

}
