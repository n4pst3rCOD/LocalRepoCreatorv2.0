	package com.execmaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.execmaven.JarDetails;
import com.filesearch.ExtractIDS;
import com.filesearch.Files;
import com.filesearch.JARReader;
import com.filesearch.POMWriter;
public class ExecRepo {
	
	private static String path = null;
	static ArrayList<JarDetails> objjd = new ArrayList<JarDetails>();
	
	@SuppressWarnings("resource")
	public static String setDetails(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the path of the jar files: ");
		path = input.next();
		
		if(path.lastIndexOf("\\") ==path.length() - 1){
			path = (String) path.subSequence(0, path.length() - 1);
			
			System.out.println(path);
		}
	
		ArrayList<String> files = Files.fileSearch(path);
	    //ArrayList<ArrayList<String>> delimitedNames = ExtractIDS.fileNameExtraction(files);
		ArrayList<ArrayList<String>> delimitedNames = JARReader.extracter(path, files);
		for(ArrayList<String> array:delimitedNames){

		objjd.add(new JarDetails(array));
		
		}
		
		return path;
	}
	
	public static void execRepo(String path){
		
		System.out.println("Enter path for you local repo: ");
		Scanner sc = new Scanner(System.in);
		String repoPath = sc.next();
		
		if(repoPath.lastIndexOf("\\") == repoPath.length() - 1){
			repoPath = (String) repoPath.subSequence(0, repoPath.length() - 1);
			
			System.out.println(repoPath);
		}
		ArrayList<String> sucInstalled = new ArrayList<String>();
		ArrayList<String> unsucInstalled = new ArrayList<String>();
		try
		{
			
		    for(JarDetails file:objjd){
			
				String mvncmd = "mvn install:install-file -Dfile=\"" + path + "\\" + file.getfileName().toString() +"\""  + " -DgroupId=" + file.getGroupID().toString().replaceAll("\\s+","")  + " -DartifactId=" + file.getArtifactID().toString().replaceAll("\\s+","") + " -Dversion=" + file.getVersion().toString().replaceAll("\\s+","") + "  -Dpackaging=jar -DlocalRepositoryPath=" + repoPath + "\\repo"  ;
				
				String[] commands = {"cmd.exe", "/c", mvncmd };
			    Process pr = Runtime.getRuntime().exec(commands);
			    
			    System.out.println(mvncmd);
			   // file.pause();
			    
			    BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));

		    	BufferedReader stdError = new BufferedReader(new InputStreamReader(pr.getErrorStream()));

		    
		    	String s = null;
		    	
		    	while ((s = stdInput.readLine()) != null) {
		    	    System.out.println(s);

		    	    if(s.contains("[INFO] BUILD SUCCESS")){
		    	    	sucInstalled.add(file.getfileName());
		    	    	
		    	    }
		    	    
		    	    if(s.contains("[INFO] BUILD FAILURE")){
		    	    	unsucInstalled.add(file.getfileName());
		    	    	
		    	    }
		    	}

		    	
		    	while ((s = stdError.readLine()) != null) {
		    	    System.out.println(s);
		    	}
		    	
		    	POMWriter.pomWriter( file.getGroupID().toString().replaceAll("\\s+",""), file.getArtifactID().toString().replaceAll("\\s+",""), file.getVersion().toString().replaceAll("\\s+",""), path );
		    }
		} catch (IOException e)
		{
		    e.printStackTrace();
		}
		
		
		
		POMWriter.jarLog(path, sucInstalled, unsucInstalled);
		POMWriter.repoAdd(path);
		
		
	}
}
