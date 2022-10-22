package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.esprit.microservice.Entity.Article;
import com.esprit.microservice.Entity.Article;
import com.esprit.microservice.Repository.ArticleRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient

@ComponentScan(basePackages = {"com.esprit.microservice"})
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	
	@Bean
	 ApplicationRunner init(ArticleRepository repository){
		return args ->{
			Stream.of("Eskander","Samir","hamma").forEach(titre ->{
				repository.save(new Article(titre));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
