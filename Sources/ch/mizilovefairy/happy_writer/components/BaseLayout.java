package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

/**
 * Ein Layout welches einen Titel, navbar, Admin login link und ein Logo hat.
 * 
 * Dieses Layout wird für alle nicht Administrationsseiten benutzt.
 * 
 * @author Marco Selenati
 *
 */
public class BaseLayout extends BaseComponent {
	private static final long serialVersionUID = -4703138291072601139L;
	/**
	 * Den Titel der Seite.
	 * 
	 * Dieses field muss im wod gesetzt werden.
	 */
	private String pageTitle;

	public BaseLayout(WOContext context) {
		super(context);
	}

	/**
	 * Verlinkt zur Hauptseite.
	 * 
	 * @return Gibt die Hauptseite zurück.
	 */
	public final WOComponent homepage() {
		return pageWithName(Main.class);
	}


	/**
	 * Verlinkt zur Adminloginseite.
	 * 
	 * @return Gibt die Adminloginseite zurück.
	 */
	public WOComponent adminLogin() {
		return pageWithName(PAdminLogin.class);
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
