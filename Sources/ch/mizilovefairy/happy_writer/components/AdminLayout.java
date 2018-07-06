package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

/**
 * Ein Layout welches einen Titel, navbar und Logo hat.
 * 
 * Dieses Layout wird für alle Adminseiten benutzt.
 * 
 * @author Marco Selenati
 *
 */
public class AdminLayout extends BaseComponent {
	private static final long serialVersionUID = 7008833280104880743L;
	/**
	 * Den Titel der Seite.
	 * 
	 * Dieses field muss im wod gesetzt werden.
	 */
	private String pageTitle;

	public AdminLayout(WOContext context) {
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

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
