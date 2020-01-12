package com.example.news.input;

import static com.example.news.input.Hash.sha224;

public class NewsInput {
    private String hash;
    private String title;
    private String descr;
    private String sport;
    private String team_code;
    private String image;
    private String league;
    private String team;
    private String link;
    private String publishedAt;
    private String username;

    public NewsInput(String title, String descr, String sport, String team_code, String image, String league, String team, String link, String publishedAt) {
        this.hash = sha224(title + link + team_code);
        this.title = title;
        this.descr = descr;
        this.sport = sport;
        this.team_code = team_code;
        this.image = image;
        this.league = league;
        this.team = team;
        this.link = link;
        this.publishedAt = publishedAt;
    }

    public String getHash() {
        return hash;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr() {
        return descr;
    }

    public String getSport() {
        return sport;
    }

    public String getTeam_code() {
        return team_code;
    }

    public String getImage() {
        return image;
    }

    public String getLeague() {
        return league;
    }

    public String getTeam() {
        return team;
    }

    public String getLink() {
        return link;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
