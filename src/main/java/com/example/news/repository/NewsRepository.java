package com.example.news.repository;

import com.example.news.pojo.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News,String> {
    List<News> findAll();
    List<News> findAllBySport(String sport);
    List<News> findAllBySportAndLeague(String sport, String league);
    void delete(News news);
    News findOneByHash(String hash);
}
