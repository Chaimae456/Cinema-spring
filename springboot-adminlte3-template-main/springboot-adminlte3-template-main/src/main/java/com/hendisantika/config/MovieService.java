package com.hendisantika.config;

import com.hendisantika.entity.Film;
import com.hendisantika.repository.IMovieRepository;
import com.hendisantika.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractService<Film,Long> {

    @Autowired
    private IMovieRepository movieRepository;
    @Override
    protected JpaRepository<Film, Long> getRepository() {
        return movieRepository;
    }
}
