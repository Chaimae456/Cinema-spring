package com.hendisantika.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film extends AbstractModel<Long>{
	
	private static final long serialVersionUID = 2996009286487492970L;

	@Column(nullable = false, length = 50)
    private String titre;
	
	@Column(nullable = false)
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date duree;
	
	
	 @Column(nullable = true, length = 100)
	    private String poster;
	 
	 
	    @ManyToMany
	    @JoinTable(
	      name="FILM_ACTEUR",
	      joinColumns=@JoinColumn(name="ACTOR_ID", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="FILM_ID", referencedColumnName="ID"))
	    private List<Personne> acteur;

	@Column(nullable = false)
    private int annee;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="GENRE_ID")
    private Genre genre;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="NATIONALITE_ID")
	@JsonProperty
    private Nationalite nationalite;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DIRECTOR_ID")
    private Personne realisateur;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
      name="FILM_ACTEUR",
      joinColumns=@JoinColumn(name="ACTOR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="FILM_ID", referencedColumnName="ID"))
    private List<Personne> acteurs;
    
    @OneToMany(mappedBy = "film")
    @JsonIgnore
	private List<Seance> seances;
    
    @Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date addedDate;
    
}
