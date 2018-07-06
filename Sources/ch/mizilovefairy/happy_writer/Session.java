package ch.mizilovefairy.happy_writer;

import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Inhalt;
import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	private NSMutableArray<BestellPosition> warenkorb = new NSMutableArray<>();
	/**
	 * Dieses Array speichert den vom Admin bearbeiteten zustand des Inhalte tables
	 */
	private NSMutableArray<Inhalt> inhalte;
	/**
	 * Dieses Array speichert den vom Admin bearbeiteten zustand des artikel tables.
	 */
	private NSMutableArray<Artikel> artikel;

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
