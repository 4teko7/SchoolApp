package com.teko.commercial.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {


   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;

   @Column(name = "name")
   private String name;
   
   @Column(name = "mimeType")
   private String mimeType;
   
   @Column(name = "extension")
   private String extension;
   
   @Column(name = "path")
   private String path;
   
   @Column(name = "videoContent")
   private String videoContent;
   
   @Column(name = "videoSubject")
   private String videoSubject;
   
  
   



   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getVideoContent() {
	return videoContent;
}

public void setVideoContent(String videoContent) {
	this.videoContent = videoContent;
}

public String getVideoSubject() {
	return videoSubject;
}

public void setVideoSubject(String videoSubject) {
	this.videoSubject = videoSubject;
}

@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
   
   public Video() {}
   
   	public Video(String name, String mimeType, String extension, String path, User user) {
	super();
	this.name = name;
	this.mimeType = mimeType;
	this.extension = extension;
	this.path = path;
	this.user = user;
}

	public Video(int id, String name, String mimeType, String extension, String path, User user) {
	super();
	this.id = id;
	this.name = name;
	this.mimeType = mimeType;
	this.extension = extension;
	this.path = path;
	this.user = user;
	
}




	public Video(int id, String name, String mimeType, String extension, String path, String videoContent,
			String videoSubject, User user) {
		super();
		this.id = id;
		this.name = name;
		this.mimeType = mimeType;
		this.extension = extension;
		this.path = path;
		this.videoContent = videoContent;
		this.videoSubject = videoSubject;
		this.user = user;
	}

	public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}




public String getMimeType() {
	return mimeType;
}


public void setMimeType(String mimeType) {
	this.mimeType = mimeType;
}


public String getExtension() {
	return extension;
}


public void setExtension(String extension) {
	this.extension = extension;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}
   

	   
//	   @Column("length")
//	   private Long contetLen;


}
