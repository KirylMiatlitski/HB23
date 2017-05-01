package by.epam.course.basic.beans.users;

public class UserAuth {
	private String login;
	private String password;
	private int user_ID;

	public UserAuth() {
	}

	public UserAuth(String login) {
		this.login = login;
	}

	public UserAuth(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public UserAuth(String login, String password, int user_ID) {
		this.login = login;
		this.password = password;
		this.user_ID = user_ID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuth other = (UserAuth) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User: " + login;
	}

}
