package com.teko.commercial.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.teko.commercial.Entities.User;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ImageUtil {

	private FileUtils fileUtils = new FileUtils();
	
    public String resize(User thisUser, String imagePath, int height, int width,String folder) {
    	String time = System.currentTimeMillis() + "";
    	String uploadDir = "";
    	try {
    	File input = new File(imagePath);
        BufferedImage image = ImageIO.read(input);

        
        Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        
        if(folder == "lectures")
        	uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/lectures";
        if(folder == "uploads")
        	uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads";
        
        String outPath = uploadDir + "/" + thisUser.getUsername()+"-resized-"+height + "x" + width +"-" + time + ".png";;
        File output = new File(outPath);
        
		ImageIO.write(resized, "png", output);
		
		System.out.println("FROM RESIZE METHOD : " + outPath + " WAS WRITTEN");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisUser.getUsername()+"-resized-"+height + "x" + width +"-" + time + ".png";
        
        
    }

}
