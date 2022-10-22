package com.esprit.microservice.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArticle;
	private String titre;
    private String contenu;
    private String auteur;
    private String image;
    private String DatePublication;
    
    
	public Article(int idArticle, String titre, String contenu, String auteur, String image, String datePublication) {
		super();
		this.idArticle = idArticle;
		this.titre = titre;
		this.contenu = contenu;
		this.auteur = auteur;
		this.image = image;
		this.DatePublication = datePublication;
	}


	public Article() {
		super();
	

	}

	
	public Article(String titre) {
		super();
		// TODO Auto-generated constructor stub
		this.titre = titre;

	}


	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDatePublication() {
		return DatePublication;
	}


	public void setDatePublication(String datePublication) {
		DatePublication = datePublication;
	}


	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur
				+ ", image=" + image + ", DatePublication=" + DatePublication + "]";
	}
    
	
	
    
    
    
	




}
