package com.example.news.service;

import com.example.news.input.NewsInput;
import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    List<News> getAll(Pageable pageable);
    List<News> getAllBySport(String sport, Pageable pageable);
    List<News> getAllBySportAndLeague(String sport, String league, Pageable pageable);
    void deleteNews(String hash);
    News findOne(String hash);
    List<News> findByUsername(Admin admin, Pageable pageable);
    News create(NewsInput newsInput, Admin admin);
    News update(NewsInput newsInput, Admin admin, String hash);
}
