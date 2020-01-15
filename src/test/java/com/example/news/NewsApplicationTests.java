package com.example.news;

import com.example.news.input.LogIn;
import com.example.news.input.NewsInput;
import com.example.news.input.SignUp;
import com.example.news.pojo.Admin;
import com.example.news.pojo.News;
import com.example.news.service.AdminService;
import com.example.news.service.NewsService;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;


import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
class NewsApplicationTests {
	private static final String ADMIN_USERNAME="tesstUsernametest";
	private static final String ADMIN_NAME="testName";
	private static final String ADMIN_SURNAME="testSurName";
	private static final String ADMIN_ADDRESS="testAddress";
	private static final String ADMIN_EMAIL="testEmail";
	private static final String ADMIN_PASSWORD="testPassword";
	private static final Integer ADMIN_PASSWORDFAIL=123;

	private static final String HASH_NEWS="testHash";
	private static final String TITLE_NEWS="testTitle";
	private static final String DESCRIPTION_NEWS="testDescription";
	private static final String SPORT_NEWS="testSport";
	private static final String TEAMCODE_NEWS="testTeamCode";
	private static final String IMAGE_NEWS="testImage";
	private static final String LEAGUE_NEWS="testLeague";
	private static final String TEAM_NEWS="testTeam";
	private static final String LINK_NEWS="testLink";
	private static final String USERNAME_NEWS="testUsername";
	private static final String PUBLISHEDAT_NEWS="testPublishedAt";






	//ok
	@Test
	void testAdminClass() {
		Admin admin=new Admin(ADMIN_USERNAME,ADMIN_NAME,ADMIN_SURNAME,ADMIN_ADDRESS,ADMIN_EMAIL,ADMIN_PASSWORD);

		assertEquals(admin.getUsername(),ADMIN_USERNAME);
		assertEquals(admin.getPassword(),ADMIN_PASSWORD);
		assertNotEquals(admin.getPassword(),ADMIN_PASSWORDFAIL);
		assertEquals(admin.getAddress(),ADMIN_ADDRESS);
		assertEquals(admin.getEmail(),ADMIN_EMAIL);

	}
	@Autowired
	private AdminService adminService;

	@Autowired
	private NewsService newsService;

	@Test
	void testAdminServices(){

		LogIn log=new LogIn("bedir@gmail.com","bedir123");
		LogIn log1=new LogIn("ttesttest@gmail","qweqweqwe");

		assertNotNull(adminService.login(log));
		assertNull(adminService.login(log1));
		SignUp newSignUp = new SignUp("testun","ntest",
				"testsn","testadd","email@gmail.com","passtest");
		assertNotNull(adminService.signUp(newSignUp));

	}
	//ok
	@Test
	void testNewsClass(){
		News news=new News(HASH_NEWS,TITLE_NEWS,DESCRIPTION_NEWS,SPORT_NEWS,TEAMCODE_NEWS,IMAGE_NEWS,
				LEAGUE_NEWS,TEAM_NEWS,LINK_NEWS,PUBLISHEDAT_NEWS,USERNAME_NEWS);

		assertEquals(news.getHash(),HASH_NEWS);
		assertEquals(news.getTitle(),TITLE_NEWS);
		assertEquals(news.getDescription(),DESCRIPTION_NEWS);
		assertEquals(news.getSport(),SPORT_NEWS);
		assertEquals(news.getTeamCode(),TEAMCODE_NEWS);
		assertEquals(news.getImage(),IMAGE_NEWS);
		assertEquals(news.getLeague(),LEAGUE_NEWS);
		assertEquals(news.getTeam(),TEAM_NEWS);
		assertEquals(news.getLink(),LINK_NEWS);
		assertEquals(news.getUsername(),USERNAME_NEWS);
		assertEquals(news.getPublishedAt(),PUBLISHEDAT_NEWS);
		assertNotEquals(news.getPublishedAt(),HASH_NEWS);
	}

	@Test
	void testNewsCreateService(){
		NewsInput news=new NewsInput(TITLE_NEWS,DESCRIPTION_NEWS,SPORT_NEWS,TEAMCODE_NEWS,IMAGE_NEWS,
				LEAGUE_NEWS,TEAM_NEWS,LINK_NEWS,PUBLISHEDAT_NEWS);


		LogIn log=new LogIn("bedir@gmail.com","bedir123");

		adminService.login(log);
		assertNotNull(newsService.create(news,new Admin("bedircaushi","Bedir Caushi",
				null,"Tetovo","bedir@gmail.com","bedir123")));
	}

	//OK
	@Test
	void testGetNewsService(){

		assertNotNull(newsService.getAll(Pageable.unpaged()));
		assertNotNull(newsService.getAllBySport("football",Pageable.unpaged()));
		List<News> empty=new ArrayList<>();
		assertEquals(newsService.getAllBySportAndLeague("fail","not",Pageable.unpaged()),empty);

		LogIn log=new LogIn("bedir@gmail.com","bedir123");

		adminService.login(log);
		assertNotNull(newsService.findByUsername(new Admin("bedircaushi","Bedir Caushi",
				null,"Tetovo","bedir@gmail.com","bedir123"),Pageable.unpaged()));
	}
}
