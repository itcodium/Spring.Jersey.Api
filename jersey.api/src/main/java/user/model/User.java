package user.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
//  @FormParam("IdUser")
    int IdUser;
//	@FormParam("Name")
	String Name;
//	@FormParam("Email")
	String Email;
	
	public User(){}
	
	 public User(int pIdUser, String pName) {
		IdUser=pIdUser;
		Name=pName;
	}
	 
	public void setIdUser(int pIdUser){
		this.IdUser=pIdUser;
	} 
	
	public int getIdUser(){
		return this.IdUser;
	} 
	
	public void setEmail(String pEmail){
		this.Email=pEmail;
	} 
	
	public String getEmail(){
		return this.Email;
	}

	public void setName(String pName){
		this.Name=pName;
	}

	public String getName(){
		return  this.Name;
	}
	
	@Override
	public String toString() {
		return "Customer [IdUser=" + this.IdUser+ ", Name=" + this.Name+ ", Email=" + Email
				+ "]";
	}
	 
}
