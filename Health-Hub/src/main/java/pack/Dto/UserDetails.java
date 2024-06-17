package pack.Dto;

public class UserDetails {
   private  int id;
   private String fullName;
   private  String email;
   private String password;
   
   
public UserDetails() {
	super();
	// TODO Auto-generated constructor stub
}


public UserDetails(String fullName, String email, String password) {
	super();
	this.fullName = fullName;
	this.email = email;
	this.password = password;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
    
}
