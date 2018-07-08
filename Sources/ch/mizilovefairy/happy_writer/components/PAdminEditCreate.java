package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Inhalt;

/**
 * Hier kann der Admin ein Inhaltsartikel editieren Oder erstellen.
 * 
 * @author Marco Selenati
 *
 */
public class PAdminEditCreate extends BaseComponent {
	private static final long serialVersionUID = -9073693511569071102L;
	/**
	 * Der Inhaltsartikel welcher editiert wird.
	 */
	private Inhalt inhalt;

	public PAdminEditCreate(WOContext context) {
		super(context);
	}

	/**
	 * Speichert die änderungen.
	 * 
	 * @return Die Admin Inhaltsartikel Seite.
	 */
	public final WOComponent submit() {
		return pageWithName(PAdminInhalt.class);

	}

	public final Inhalt getInhalt() {
		return inhalt;
	}

	public final void setInhalt(Inhalt inhalt) {
		this.inhalt = inhalt;
	}

}