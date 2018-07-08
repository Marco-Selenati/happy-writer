package ch.mizilovefairy.happy_writer;

import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Inhalt;
import er.extensions.appserver.ERXSession;

/**
 * Die OO repräsentation einer Session.
 * 
 * Hier können wir unsere Applikations spezifische session Methoden
 * reinschreiben.
 * 
 * @author Marco Selenati
 *
 */
public class Session extends ERXSession {
	private static final long serialVersionUID = 5874995826373810920L;
	/**
	 * Der Warenkorb des Benutzers.
	 * 
	 * Hier werden die Artikel und die Inhaltsartikel gespeicher die der Benutzer
	 * kaufen will.
	 * 
	 */
	private NSMutableArray<BestellPosition> warenkorb = new NSMutableArray<>();
	/**
	 * Dieses Array speichert den vom Admin bearbeiteten zustand des Inhalte tables
	 */
	private NSMutableArray<Inhalt> inhalte;
	/**
	 * Dieses Array speichert den vom Admin bearbeiteten zustand des artikel tables.
	 */
	private NSMutableArray<Artikel> artikel;

	/**
	 * Wir wollen die session id in den cookies.
	 */
	public Session() {
		setStoresIDsInURLs(false);
		setStoresIDsInCookies(true);
	}

	@Override
	public Application application() {
		return (Application) super.application();
	}

	public final NSMutableArray<BestellPosition> getWarenkorb() {
		return warenkorb;
	}

	public final void setWarenkorb(NSMutableArray<BestellPosition> warenkorb) {
		this.warenkorb = warenkorb;
	}

	public final NSMutableArray<Inhalt> getInhalte() {
		return inhalte;
	}

	public final void setInhalte(NSMutableArray<Inhalt> inhalte) {
		this.inhalte = inhalte;
	}

	public final NSMutableArray<Artikel> getArtikel() {
		return artikel;
	}

	public final void setArtikel(NSMutableArray<Artikel> artikel) {
		this.artikel = artikel;
	}

}
