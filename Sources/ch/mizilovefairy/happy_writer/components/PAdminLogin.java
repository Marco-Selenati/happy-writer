package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class PAdminLogin extends BaseComponent {
	private static final long serialVersionUID = 2696297665284254446L;
	private String username;
	private String password;

	public PAdminLogin(WOContext context) {
		super(context);
		session().setPageTitle("Admin");
	}

	public final WOComponent login() {
		if (username.equals("admin") && password.equals("klapp42stuhl")) {
			return pageWithName(PAdmin.class);
		}

		return null;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

}
