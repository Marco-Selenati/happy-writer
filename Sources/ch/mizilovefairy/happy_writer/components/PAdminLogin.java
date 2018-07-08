package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

/**
 * Hier kann sich der Admin einloggen.
 * 
 * @author Marco Selenati
 *
 */
public class PAdminLogin extends BaseComponent {
	private static final long serialVersionUID = 2696297665284254446L;
	/**
	 * Der username welcher der Benutzer eingegeben hat.
	 */
	private String username;
	/**
	 * Das passwort welches der Benutzer eingegeben hat.
	 */
	private String password;

	public PAdminLogin(WOContext context) {
		super(context);
	}

	/**
	 * Verifiziert die login Daten, wenn korrekt leiete es zur admin Seite weiter.
	 * 
	 * @return Wenn korrekt die admin Seite sonst bleibt es auf der gleichen Seite.
	 */
	public final WOComponent login() {
		if ("admin".equals(username) && "klapp42stuhl".equals(password)) {
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
