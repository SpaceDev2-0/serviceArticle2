package com.esprit.microservice.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Article;
import com.esprit.microservice.Repository.ArticleRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.core.ipc.http.HttpSender.Response;



@Service
public class ArticleService implements IArticleService {

	
	@Autowired
	private ArticleRepository ArticleRepository; 
	@Autowired
    ServletContext context;
	
	@Override
    public ResponseEntity<Response> add(MultipartFile file, String Article) throws JsonParseException, JsonMappingException, Exception
    {

        System.out.println("Ok .............");
        Article s = new ObjectMapper().readValue(Article, Article.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        s.setImage(newFileName);

        Article art = ArticleRepository.save(s);



        if (art != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }



    }

	public Article updateArticle(Article newArticle) {
			 return (ArticleRepository.save(newArticle));
			
	

}
	
	
	public Article AddArticle(Article newArticle) {
		newArticle.setImage("277682697_723058502368584_4787544731777611188_n.png");
		 return (ArticleRepository.save(newArticle));

}
	
	
	public String deleteArticle(int id) {
		if (ArticleRepository.findById(id).isPresent()) {
			ArticleRepository.deleteById(id);
			return "Article supprimé";
} else
return "Article non supprimé";
	}
	
	@Override
	public Article getarticleById(int idarticle) {
		Article Article = ArticleRepository.findById(idarticle).isPresent() ? ArticleRepository.findById(idarticle).get() : null;
        return Article;
    }
	
	
	
	public List<Article> retrieveAllArticles() {

		List<Article> Articles = (List<Article>) ArticleRepository.findAll();
		
		return Articles;
	}
	
	
	
	
	
}
