package com.example.news.service;

import com.example.news.pojo.News;

import java.util.List;

public interface NewsService {
    List<News> getAll();
    List<News> getAllBySport(String sport);
    List<News> getAllBySportAndLeague(String sport,String league);
    void deleteNews(String hash);
    News findOne(String hash);
}
