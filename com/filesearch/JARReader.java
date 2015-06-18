package com.filesearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;



public class JARReader {
	
	public static String versionReader(String file){
		
		String[] name = file.split("-");
		String versionID = null;
    	
    	try{
    		
    		
        		for(String delimitedString:name){
        			//System.out.println(delimitedString);
        			try{
        				if(delimitedString.contains(".jar")){
        					
        					int lengthOfName = delimitedString.length();
        					delimitedString = delimitedString.substring(0,lengthOfName-4);
        				}
        				Long.parseLong(delimitedString.replace(".", ""));
        				versionID = delimitedString;
        				//System.out.println(versionID);
        				break;
        				
        			}catch(NumberFormatException e){
        				continue;
        			}
        		
    		}
    	}catch(ArrayIndexOutOfBoundsException e){
    		e.printStackTrace();
    	}
    	
    	if(versionID == null){
    		
		return "1.0.0";
    	}
    	
    	return versionID;
	}
	
	public static String groupIDReader(String file , Attributes mattr){
		String groupID = null;
		try{
		  if(mattr.getValue("Specification-Title") == null){
       	   
       	   if(mattr.getValue("Implementation-Title") == null){
       		   
       		   groupID = file.toString();
       		   
       	   }
       	   else{
       		   groupID = mattr.getValue("Implementation-Title");
       	   }
          }
          
          else{
       	   
       	  groupID = mattr.getValue("Specification-Title");
          }
		} catch(NullPointerException e){
			
			System.out.println("No manifest file available @ " + file);
			
			groupID = file.toString();
		}
		
		return groupID;
	}

	public static String artifactIDReader(String file, Attributes mattr){
		String artifactID = null;
		
		try{
			
			if(mattr.getValue("Implementation-Title") == null){
     		   
     		   artifactID = file.toString();
     		   
     	   }
     	   else{
     		   artifactID = mattr.getValue("Implementation-Title");
     	   }
			
		} catch(NullPointerException e){
			
			System.out.println("No manifest file available @ " + file);
			
			artifactID = file.toString();
		}
		
		return artifactID;
	}
	
	 public static ArrayList<ArrayList<String>> extracter(String path, ArrayList<String> filenames) {
		 
		 	ArrayList<ArrayList<String>> delimitedNames = new ArrayList<ArrayList<String>>();
		 	
	      	
	        	
	      	for(String file:filenames){
	      		ArrayList<String> extractedNames = new ArrayList<String>();
	      		String versionID = null;
	      		String groupID = null;
	      		String artifactID = null;
	      		JarFile jar = null;
//	      		System.out.println(file);
	      	 	File f = new File(path + "\\" + file);
	      	 	
//	      	 	if(f.isFile()){
//	      	 		System.out.println("yep");
//	      	 	}
	           
	      	 	
				try {
					jar = new JarFile(f);
					Manifest manifest = jar.getManifest();
				
					final Attributes manReader = manifest.getMainAttributes();
                
                // Fetching version id
                   if(manReader.getValue("Implementation-Version") == null){
                	   
                	   versionID = versionReader(file);
                   }
                   else if(manReader.getValue("Implementation-Version").trim() == ""){
                	   
                	   versionID = "1.0.0";
                   }
                   else{
                	   versionID = manReader.getValue("Implementation-Version");
                   }
                  
                   groupID = groupIDReader(file, manReader);
                   artifactID = artifactIDReader(file, manReader);
                  
                  
              
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch(NullPointerException e){
					
					System.out.println("No manifest file available @ " + file);
					versionID = "1.0.0";
					groupID = file.toString();
					artifactID = file.toString();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
				}
				finally{
					try {
						jar.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
				 
				versionID = versionID.replace('_', '.').replaceAll("\"","").replaceAll("[a-zA-Z-/s]", "").trim();
				
                if(versionID.length() == 0 || versionID == null){
                	
                	versionID = "1.0.0";
                }
              
                
                groupID = groupID.trim().replace(" ", ".").toLowerCase().replaceAll(".jar", "").replaceAll("\"","");
                artifactID = artifactID.trim().replace(" ", ".").toLowerCase().replaceAll(".jar", "").replaceAll("\"","");
//                System.out.println("Group id: " + groupID);
//                System.out.println("Artifact id: " + artifactID);
                  System.out.println( file + " : " + versionID.length());
//                
//                System.out.println();
                
                extractedNames.add(file);
                extractedNames.add(groupID);
                extractedNames.add(artifactID);
                extractedNames.add(versionID);
                
                delimitedNames.add(extractedNames);
                
                
	      	//return delimitedNames;
	      	}
	      	
//	      	try {
//				Thread.sleep(100000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return delimitedNames;
	 }
}