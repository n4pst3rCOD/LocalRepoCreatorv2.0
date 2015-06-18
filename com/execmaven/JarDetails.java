package com.execmaven;

import java.util.ArrayList;


public class JarDetails {
	
	private String fileName = null;
	private String groupID = null;
	private String artifactID = null;
	private String version = null;

	public String getGroupID() {
		return groupID;
	}
	
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getArtifactID() {
		return artifactID;
	}
	
	public String getfileName() {
		return fileName;
	}
	
	public void setArtifactID(String artifactID) {
		
		this.artifactID = artifactID;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		
		this.version = version;
	}
	

	public JarDetails(ArrayList<String> extractedName){
		
//		int len =0 ;
		
//		for(String filePartName: extractedName){
//			
//			len++;
//		}
//		
			this.fileName = extractedName.get(0);
		
			System.out.println("File: " + this.fileName);
			System.out.println("Group ID fetched as \"" + extractedName.get(1).toString()+ "\"  ");
			this.setGroupID(extractedName.get(1));
			System.out.println("Artifact ID fetched as \"" + extractedName.get(2).toString() + "\"  ");
			this.setArtifactID(extractedName.get(2));
			System.out.println("Version ID fetched as \"" + extractedName.get(3).toString() + "\"  ");
			this.setVersion(extractedName.get(3));
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
//			if(len == 4){
//
//				System.out.println("Group ID auto fetched as \"" + extractedName.get(1).toString()+ "\"  ");
//				this.setGroupID(extractedName.get(1));
//				System.out.println("Artifact ID auto fetched as \"" + extractedName.get(2).toString() + "\"  ");
//				this.setArtifactID(extractedName.get(2));
//				System.out.println("Version ID auto fetched as \"" + extractedName.get(3).toString() + "\"  ");
//				this.setVersion(extractedName.get(3));
//
//			}
//			
//			else if(len == 3){
//				
//				System.out.println("Group ID auto fetched as \"" + extractedName.get(1).toString()+ "\"  ");
//				this.setGroupID(extractedName.get(1));
//				System.out.println("Artifact ID auto fetched as \"" + extractedName.get(2).toString() + "\"  ");
//				this.setArtifactID(extractedName.get(2));
//				System.out.print("Using Version id as \"1.0.0\" for " + fileName.toString() + ".");
//				this.setVersion("1.0.0");
//			}
//			
//			else if(len == 2){
//				
//				System.out.println("Group ID auto fetched as \"" + extractedName.get(1).toString()+ "\"  ");
//				this.setGroupID(extractedName.get(1));
//				System.out.print("Enter the Artifact id for " + fileName.toString() + ": ");
//				this.setArtifactID(input.next());
//				System.out.print("Using Version id as \"1.0.0\" for " + fileName.toString() + ".");
//				this.setVersion("1.0.0");
//			}
//			
//			else{
//				
//				System.out.print("Enter the Group id for " + fileName.toString() + ": ");
//				this.setGroupID(input.next());
//				System.out.print("Enter the Artifact id for " + fileName.toString() + ": ");
//				this.setArtifactID(input.next());
//				System.out.print("Enter the Version id for " + fileName.toString() + ": ");
//				this.setVersion(input.next());
//			}
//				
			System.out.println("");
	}
	
	public void pause(){
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	
}
