package com.hendisantika.config;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.Personne;
import com.hendisantika.repository.PersonneRepository;

@Service
public class PersonneService extends AbstractService<Personne, Long> {

	@Autowired
    private PersonneRepository personneRepository;

    public List<Personne> getAllActeur(){
        System.out.println(personneRepository.findByTypePersonne(Personne.TypePersonne.ACTEUR).size()+"***********************************************************************");
        return personneRepository.findByTypePersonne(Personne.TypePersonne.ACTEUR);
    }
    public List<Personne> getAllRealisateur(){
        return personneRepository.findByTypePersonne(Personne.TypePersonne.REALISATEUR);
    }


    @Override
    protected JpaRepository<Personne, Long> getRepository() {
        return personneRepository;
    }

}
