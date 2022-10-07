package com.hendisantika.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genre extends AbstractModel<Long>{
	private static final long serialVersionUID = -5754835234259566904L;

	@Column(nullable = false, length = 50)
    private String libelle;
	
	@OneToMany(mappedBy = "genre")
	@JsonIgnore
	 private List<Film> films;
}
