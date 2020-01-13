package com.example.news.repository;

import com.example.news.input.NewsInput;
import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, String> {
    List<News> findAllBySport(String sport, Pageable pageable);
    List<News> findAllBySportAndLeague(String sport, String league, Pageable pageable);
    void delete(News news);
    News findOneByHash(String hash);
    List<News> findByUsername(String username, Pageable pageable);
    List<News> findAll(Pageable pageable);
    News save(News news);
}
