package com.example.news.service;

import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultNewsService implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getAllBySport(String sport) {
        return newsRepository.findAllBySport(sport);
    }

    @Override
    public List<News> getAllBySportAndLeague(String sport, String league) {
        return newsRepository.findAllBySportAndLeague(sport, league);
    }

    @Override
    public News findOne(final String hash) {
        return newsRepository.findOneByHash(hash);
    }

    @Override
    public void deleteNews(final String hash) {
        if(newsRepository.findOneByHash(hash)!=null){
            newsRepository.delete(newsRepository.findOneByHash(hash));
        }
    }

    @Override
    public List<News> findByUsername(Admin admin){
        return newsRepository.findByUsername(admin.getUsername());
    }
}
