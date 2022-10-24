package com.esprit.microservice.Service;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Article;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.micrometer.core.ipc.http.HttpSender.Response;





public interface IArticleService {

//	Article add(MultipartFile file, Article Article)
	ResponseEntity<Response> add(MultipartFile file, String Article) throws JsonParseException, JsonMappingException, Exception;
	
	Article updateArticle(Article newArticle);
	// ResponseEntity<String> deleteHotel(int id);
	String deleteArticle(int id);
	public List<Article> retrieveAllArticles();
	public Article AddArticle(Article newArticle);
	public  Article getarticleById(int idarticle);

}
