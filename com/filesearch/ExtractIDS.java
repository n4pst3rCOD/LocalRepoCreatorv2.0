package com.filesearch;

import java.util.ArrayList;

public class ExtractIDS {
	
	public static ArrayList<ArrayList<String>> fileNameExtraction(ArrayList<String> filename){
	
		ArrayList<ArrayList<String>> delimitedNames = new ArrayList<ArrayList<String>>();
		
		
		for(String name:Files.availFiles){
		
		String[] delimited = name.split("-");
		
		if(delimited.length == 3){
			ArrayList<String> extractedNames = new ArrayList<String>();
			extractedNames.add(name);
			
			for(String s:delimited){
				if(s.contains(".jar")){
	
					int lengthOfName = s.length();
					s = s.substring(0,lengthOfName-4); 
					extractedNames.add(s);
				}
				else{
					extractedNames.add(s);
				}
			}
			
			delimitedNames.add(extractedNames);
		}

		else if(delimited.length == 2){
			ArrayList<String> extractedNames = new ArrayList<String>();
			extractedNames.add(name);
			for(String s:delimited){
				if(s.contains(".jar")){
	
					int lengthOfName = s.length();
					s = s.substring(0,lengthOfName-4);
					extractedNames.add(s);
				}
				else{
					extractedNames.add(s);
				}
			}
			
			delimitedNames.add(extractedNames);
			
			
		}
		else if(delimited.length == 1){
			ArrayList<String> extractedNames = new ArrayList<String>();
			extractedNames.add(name);
			for(String s:delimited){
				if(s.contains(".jar")){
	
					int lengthOfName = s.length();
					s = s.substring(0,lengthOfName-4);
					extractedNames.add(s);
				}
				else{
					extractedNames.add(s);
				}
			}
			
			delimitedNames.add(extractedNames);
		}
		else{
			ArrayList<String> extractedNames = new ArrayList<String>();
			delimitedNames.add(extractedNames);
		}
			
			
		
		}
		return delimitedNames;
	}

	
}
