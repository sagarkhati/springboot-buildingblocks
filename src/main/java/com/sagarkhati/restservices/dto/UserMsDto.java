package com.sagarkhati.restservices.dto;

public class UserMsDto {

	private Long userid;
	private String username;
	private String emailaddress;

	public UserMsDto() {
	}

	public UserMsDto(Long userid, String username, String emailaddress) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailaddress = emailaddress;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

}

