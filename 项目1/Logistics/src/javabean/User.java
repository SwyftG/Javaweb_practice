package javabean;

public class User {
	private String quanxian;
	private String username;
	private String userpwd;
	private int id;
	public void setUserid(int id){
		this.id= id;
	}
	public int getUserid(){
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserquanxian(){
		return quanxian;
	}	
	public void setUserquanxian(String quanxian){
		this.quanxian = quanxian;
	}
}
