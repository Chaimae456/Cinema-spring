package com.hendisantika.repository;

import com.hendisantika.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Film, Long> {
}
