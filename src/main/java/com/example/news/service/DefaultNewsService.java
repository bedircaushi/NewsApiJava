package com.example.news.service;

import com.example.news.input.NewsInput;
import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DefaultNewsService implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAll(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public List<News> getAllBySport(String sport, Pageable pageable) {
        return newsRepository.findAllBySport(sport, pageable);
    }

    @Override
    public List<News> getAllBySportAndLeague(String sport, String league, Pageable pageable) {
        return newsRepository.findAllBySportAndLeague(sport, league, pageable);
    }

    @Override
    public News findOne(final String hash) {
        return newsRepository.findOneByHash(hash);
    }

    @Override
    public void deleteNews(final String hash) {
        if(newsRepository.findOneByHash(hash) != null)
            newsRepository.delete(newsRepository.findOneByHash(hash));
    }

    @Override
    public List<News> findByUsername(Admin admin, Pageable pageable){
        return newsRepository.findByUsername(admin.getUsername(), pageable);
    }

    @Override
    public News create(NewsInput in, Admin admin){
        String hash = in.getHash();
        if(newsRepository.findOneByHash(hash) == null){
            News news = new News(in.getHash(), in.getTitle(), in.getDescr(), in.getSport(),
                    in.getTeam_code(), in.getImage(), in.getLeague(), in.getTeam(),
                    in.getLink(), in.getPublishedAt(), admin.getUsername());
            return newsRepository.save(news);
        }
        return null;
    }

    @Override
    public News update(NewsInput in, Admin admin, String hash) {
        News news = newsRepository.findOneByHash(hash);
        if( news != null)
            if (news.getUsername().equals(admin.getUsername())){
                news.setTitle(in.getTitle());
                news.setDescription(in.getDescr());
                news.setSport(in.getSport());
                news.setTeamCode(in.getTeam_code());
                news.setTeam(in.getTeam());
                news.setImage(in.getImage());
                news.setLeague(in.getLeague());
                news.setLink(in.getLink());
                return newsRepository.save(news);
            }

        return null;
    }
}
