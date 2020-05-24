package com.teko.commercial.util;

import java.io.File;

public class FileUtils {
	
	
	public void removeFileFromStorage(String path) {
		try{
			File input = new File(path);
            if(input.delete()){
                System.out.println(input.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }
        }catch(Exception e){
            System.out.println("ERROR : " + e.getStackTrace());
        }
	}

}
