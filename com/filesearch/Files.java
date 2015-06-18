package com.filesearch;

import java.io.File;
import java.util.ArrayList;

public class Files {
	
	static ArrayList<String> availFiles = new ArrayList<String>();
	
	public static ArrayList<String> fileSearch(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		
		    for(File file:listOfFiles){
		    if (file.isFile() && file.getName().contains(".") && file.getName().substring(file.getName().lastIndexOf('.')).equals(".jar")) {
		        
		        availFiles.add(file.getName());
		        }
		    }
		    ExtractIDS.fileNameExtraction(availFiles);
		return availFiles;    	   
	}

}
