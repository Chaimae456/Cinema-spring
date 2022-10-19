package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hendisantika.entity.Film;



@CrossOrigin("http://localhost:4200")
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

}
