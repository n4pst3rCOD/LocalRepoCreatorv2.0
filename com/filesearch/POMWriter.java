package com.filesearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class POMWriter {

	public static void pomWriter(String groupID, String artifactID, String version, String path){
		
		String pomData = "<dependency>\r\n\t<groupId>" + groupID.toString() + "</groupId>\r\n\t<artifactId>" + artifactID.toString() + "</artifactId>\r\n\t<version>" + version.toString() + "</version>\r\n</dependency>\r\n";
		File pomFile = new File(path + "\\" + "add_to_pom.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(pomFile, true));
			bw.append(pomData);
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}
	public static void jarLog(String path, ArrayList<String> sucInstalled, ArrayList<String> unsucInstalled){
		
		String suc = null;
		String unsuc = null;
		if(!sucInstalled.isEmpty()){
			suc = "JARS installed: \r\n";
			for(String su:sucInstalled){
				suc = suc +"\r\n" + su;
			}
		}
		
		if(!unsucInstalled.isEmpty()){
			unsuc = "JARS that had some issue: \r\n";
			for(String unsu:unsucInstalled){
				unsuc = unsu + "\r\n";
			}
		}
		File logFile = new File(path + "\\" + "log.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
			if(suc!=null){
			bw.append(suc);
			bw.append("\r\n\r\n");
			}
			
			if(unsuc!=null){
			bw.append(unsuc);
			}
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static void repoAdd(String path){
		
		System.out.print("Enter your repo id: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String repoName = sc.nextLine();
		
		String add = "\r\n\r\n<repositories>\r\n\t<repository>\r\n\t\t<id>" + repoName.toString() + "</id>\r\n\t\t<url>file://${basedir}/repo</url>\r\n\t</repository>\r\n</repositories>";
		
		File pomFile = new File(path + "\\" + "add_to_pom.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(pomFile, true));
			bw.append(add);
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Check for \"add_to_pom.txt\" file. and \"log.txt\"");
	}
}
