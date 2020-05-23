package com.teko.commercial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.Video;
import com.teko.commercial.repositories.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepo;
	
	public void save(Video video) {videoRepo.save(video);}
	
	public Video findById(int id) {return videoRepo.findById(id);}
	
	public List<Video> findByUser(User user){return videoRepo.findByUser(user);}
	
	public List<Video> findByExtension(String extension){return videoRepo.findByExtension(extension);}
	
	public List<Video> findByName(String name){return videoRepo.findByOriginalName(name);}
}
