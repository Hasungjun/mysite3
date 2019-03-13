package com.example.mysite.vo;

public class SiteVo {
	private String title;
	private String welcome;
	private String profilee;
	private String descc;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public String getProfilee() {
		return profilee;
	}
	public void setProfilee(String profilee) {
		this.profilee = profilee;
	}
	public String getDescc() {
		return descc;
	}
	public void setDescc(String descc) {
		this.descc = descc;
	}
	@Override
	public String toString() {
		return "SiteVo [title=" + title + ", welcome=" + welcome + ", profile=" + profilee + ", desc=" + descc + "]";
	}
	
	
}
