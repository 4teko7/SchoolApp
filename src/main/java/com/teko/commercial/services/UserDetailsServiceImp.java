package com.teko.commercial.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.teko.commercial.Entities.Role;
import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.UserDetailsImp;
import com.teko.commercial.Entities.UserRole;
import com.teko.commercial.Entities.Video;
import com.teko.commercial.encryption.EncodeDecode;
import com.teko.commercial.repositories.RoleRepository;
import com.teko.commercial.repositories.UserRepository;
import com.teko.commercial.repositories.UserRoleRepository;
import com.teko.commercial.util.FileUtils;
import com.teko.commercial.util.ImageUtil;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private VideoService videoService;
	
	
	@Autowired
	private UserRoleService userRoleService;
	
	private ImageUtil imageUtil = new ImageUtil();
	
	private FileUtils fileUtils = new FileUtils();
	
//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private EncodeDecode encodeDecode = new EncodeDecode();
	
	@Override
	public UserDetails loadUserByUsername(String username) {return new UserDetailsImp(userRepository.findByUsername(username));}
	
	public void save(User entity) {
		entity.setActive(1);
		if(entity.getPassword().equals(entity.getPasswordConfirm())) {
			entity.setPassword(encodeDecode.encode(entity.getPassword()));
			entity.setPasswordConfirm(encodeDecode.encode(entity.getPasswordConfirm()));
		}
			
		if(entity.getRoles() == null || entity.getRoles().isEmpty()) {
			entity.setRoles(Arrays.asList(roleRepo.findById(2)));
		}
		System.out.println("OUR ENTITY : " + entity);
		userRepository.save(entity);
	}
		
	public List<User> findAll() {return userRepository.findAll();}
	
	public User findById(int id) {return userRepository.findById(id);}
	
	public User findByUsername(String username) {return userRepository.findByUsername(username);}
	
	public void deleteUser(int id) {userRepository.deleteById(id);}
	
	public User findByIdAndUsername(int id, String username) {return userRepository.findByIdAndUsername(id, username);}
	
	public void updateUser(User original, User created) {
		if(created.getFirstname() != null)
			original.setFirstname(created.getFirstname());
		if(created.getLastname() != null)
			original.setLastname(created.getLastname());
		if(created.getUsername() != null)
			original.setUsername(created.getUsername());
		if(created.getPassword() != null)
			original.setPassword(created.getPassword());
		if(created.getPasswordConfirm() != null)
			original.setPasswordConfirm(created.getPasswordConfirm());
		if(created.getEmail() != null)
			original.setEmail(created.getEmail());
		if(created.getPhone() != null)
			original.setPhone(created.getPhone());
		if(created.getSchool() != null)
			original.setSchool(created.getSchool());
		if(created.getClassNumber() != null)
			original.setClassNumber(created.getClassNumber());
		if(created.getPhotoPath() != null)
			original.setPhotoPath(created.getPhotoPath());
		if(created.getRoles() != null && !created.getRoles().isEmpty())
			original.setRoles(created.getRoles());	
	}
	
	
	public void uploadUserImage(User thisUser,MultipartFile file) {
		try {
			final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static";
			if(!file.isEmpty()) {
	//			System.out.println(path.toAbsolutePath().toString());
				String time = System.currentTimeMillis() + "";
				Path fileNameAndPath = Paths.get(uploadDir+"/uploads",file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4) +"-"+ thisUser.getUsername() + "-"+time+".png");
	//			String fileNameAndPath = path.toString() + "/" + file.getOriginalFilename();
				Files.write(fileNameAndPath, file.getBytes());
				String path = imageUtil.resize(thisUser,fileNameAndPath.toString(),300,300);
				
				fileUtils.removeFileFromStorage(fileNameAndPath.toString());
				if(thisUser.getPhotoPath() != null)
					fileUtils.removeFileFromStorage(uploadDir+"/"+thisUser.getPhotoPath());
				
				thisUser.setPhotoPath(path);
				
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	
	public Video uploadVideo(User thisUser,MultipartFile file) {
		try {
			System.out.println("VIDEO PATH : WILL COME ");
			final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/videos";
			if(!file.isEmpty()) {
				String time = System.currentTimeMillis() + "";
				String extension = file.getOriginalFilename().substring(file.getOriginalFilename().length()-4,file.getOriginalFilename().length());
				System.out.println("EXTENSION : " + extension);
				String path = thisUser.getUsername() + "-"+time+extension;
				System.out.println("VIDEO PATH : MIDDLE" + path);
				Path fileNameAndPath = Paths.get(uploadDir,path);
				Files.write(fileNameAndPath, file.getBytes());
				path = "uploads/videos/" + path;
				if(thisUser.getVideos() == null) thisUser.setVideos(new ArrayList<Video>());
				Video video = new Video(file.getOriginalFilename(),file.getContentType(),extension,path,thisUser);
				thisUser.getVideos().add(video);
				return video;
//				videoService.save(video);
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			
		}
		return new Video();
	}
}
