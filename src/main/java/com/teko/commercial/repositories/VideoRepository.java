package com.teko.commercial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video , Integer> {

	Video findById(int id); 
	List<Video> findByExtension(String extension);
	List<Video> findByUser(User user); 
	List<Video> findByOriginalName(String name); 
}