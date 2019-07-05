package org.tfzr.projects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class ObjectSaver implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3814633978804141379L;
	private List<Object> objList;
	private String projectName;
	private String projectDescription; 
	private String projectTag;
	
	public ObjectSaver(String projectName, String projectDescription, String projectTag) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectTag = projectTag;
	}

	public ObjectSaver(List<Object> objList, String projectName, String projectDescription, String projectTag) {
		super();
		this.objList = objList;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectTag = projectTag;
	}

	public boolean save()
	{
	      try {
	          FileOutputStream fos = new FileOutputStream("src/org/tfzr/projects/savedprojects/" + projectName + ".meef");
	          ObjectOutputStream oos = new ObjectOutputStream(fos);
	          oos.writeObject(this);
	          oos.close();
	          fos.close();
	          return true;
	       } catch (IOException i) {
	          i.printStackTrace();
	          return false;
	       }
	}

	public void addObjectToList(Object _obj)
	{
		this.objList.add(_obj);
	}
	
	public List<Object> getObjList() {
		return objList;
	}

	public void setObjList(List<Object> objList) {
		this.objList = objList;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectTag() {
		return projectTag;
	}

	public void setProjectTag(String projectTag) {
		this.projectTag = projectTag;
	}
	
	
}
