package Pojo;

public class getCourse {
	private String Url ;
	private String services;
	private String expertise;
	private courses Courses; 
	private String  instructor ;
	private String linkedIn;
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getServices() {
		return services;
	} 
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public courses getCourses() {
		return Courses;
	}
	public void setCourses(courses courses) {
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	
	

}
