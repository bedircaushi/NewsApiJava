package com.example.news.pojo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;

    @Column(name = "hash")
    private String hash;

    @Column(name = "title")
    private String title;

    @Column(name = "descr")
    private String description;

    @Column(name = "sport")
    private String sport;

    @Column(name = "team_code")
    private String teamCode;

    @Column(name = "image")
    private String image;

    @Column(name = "league")
    private String league;

    @Column(name = "team")
    private String team;

    @Column(name = "link")
    private String link;

    @Column(name = "published_at")
    private String publishedAt;

    @Column(name = "username")
    private String username;

    public News() {
    }

    public News(final String hash, final String title, final String description, final String sport, final String teamCode, final String image,
                final String league, final String team, final String link, final String publishedAt, final String username){
        this.hash = hash;
        this.title = title;
        this.description=description;
        this.sport=sport;
        this.teamCode=teamCode;
        this.image=image;
        this.league=league;
        this.team=team;
        this.link=link;
        this.username = username;
        this.publishedAt=publishedAt;
    }

    public News(final String description){
        this.description=description;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
