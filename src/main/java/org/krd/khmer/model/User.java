package org.krd.khmer.model;

public class User {

    private int id;
    private String username;
    private String email;
    private String gender ;
    private String phonenumber;
    private String status;
    private String user_hash;
    private String created_date;
    
    public User(){}
	public User(int id, String username, String email, String gender, String phonenumber, String status,
			String user_hash, String date) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.status = status;
		this.user_hash = user_hash;
		this.created_date = created_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_hash() {
		return user_hash;
	}
	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}
	public String getcreated_date() {
		return created_date;
	}
	public void setDate(String date) {
		this.created_date = created_date;
	}

    

}