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

	
	
    public String resize(User thisUser, String imagePath, int height, int width) {
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
        
        uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads";
        
        String outPath = uploadDir + "/teko-resized-"+height + "x" + width +"-" + time + ".png";
        File output = new File(outPath);
        
		ImageIO.write(resized, "png", output);
		
		try{
            if(input.delete()){
                System.out.println(input.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }
        }catch(Exception e){
            System.out.println("ERROR : " + e.getStackTrace());
        }
		
		return "uploads/teko-resized-"+height + "x" + width +"-" + time + ".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "uploads/"+ thisUser.getUsername()+"-resized-"+height + "x" + width +"-" + time + ".png";
        
        
    }

}
