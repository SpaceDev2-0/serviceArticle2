package com.esprit.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.Entity.Article;

public interface ArticleRepository  extends JpaRepository <Article,Integer>{

}
