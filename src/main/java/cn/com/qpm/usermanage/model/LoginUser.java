package cn.com.qpm.usermanage.model;

public class LoginUser {
    private String id;

    private String name;

    private String email;

    private String password;

    private String authority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", authority=" + authority + "]";
	}
    
    
}