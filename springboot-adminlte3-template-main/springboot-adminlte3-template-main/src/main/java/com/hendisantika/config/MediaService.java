package com.hendisantika.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.Media;
import com.hendisantika.repository.MediaRepository;

@Service
public class MediaService extends AbstractService<Media, Long> {
	 @Autowired
	 private MediaRepository mediaRepository;

	  @Override
	  protected JpaRepository<Media, Long> getRepository() {
	        return mediaRepository;
	    }
}
