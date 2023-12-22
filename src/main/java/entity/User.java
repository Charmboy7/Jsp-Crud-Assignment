package entity;

public class User {
   private int user_id;
   private String username;
   private String password;
   private int age;
   private long phonenumber;
   private String designation;
   
   public User() {
		
		
	}   
public User(int user_id, String username, String password, int age, long phonenumber, String designation) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.age = age;
	this.phonenumber = phonenumber;
	this.designation = designation;
}
public User( String username, String password, int age, long phoneNumber, String designation) {
	
	this.username = username;
	this.password = password;
	this.age = age;
	this.phonenumber = phoneNumber;
	this.designation = designation;
}
public User(int user_id, String username, String password) {
	
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	
}

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
    return (username != null) ? username : "";
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(int phonenumber) {
	this.phonenumber = phonenumber;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
   
   
   
}
