/**
 * 
 */
package pack.dto;

/**
 * 
 */
public class UserDTO {
 private String userId;
 private String firstName;
 private String lastName;
 private String gender;
 private String age;
 private String userEmail;
 private String mobileNo;
 private String  typeOfDisease;
 private String  doctorName;
 private String  roleOfPerson;
 private String userName;
 private String  passWord;


 public String getUserId() {
		return userId;
	} 
 public void setUserId(String string) {
		this.userId = string;
	}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getTypeOfDisease() {
	return typeOfDisease;
}
public void setTypeOfDisease(String typeOfDisease) {
	this.typeOfDisease = typeOfDisease;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getRoleOfPerson() {
	return roleOfPerson;
}
public void setRoleOfPerson(String roleOfPerson) {
	this.roleOfPerson = roleOfPerson;
}


}
