package ch.mizilovefairy.happy_writer;

import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Bestellung;
import ch.mizilovefairy.happy_writer.db.Inhalt;
import ch.mizilovefairy.happy_writer.db.Kunde;
import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	private Kunde kunde = null;
	private Bestellung bestellung;
	private NSMutableArray<BestellPosition> warenkorb = new NSMutableArray<>();
	private String pageTitle;
	private NSMutableArray<Inhalt> inhalte;

	public Session() {
		setStoresIDsInURLs(false);
		setStoresIDsInCookies(true);
	}

	@Override
	public Application application() {
		return (Application) super.application();
	}

	public final Kunde getKunde() {
		return kunde;
	}

	public final void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public final Bestellung getBestellung() {
		return bestellung;
	}

	public final void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public final NSMutableArray<BestellPosition> getWarenkorb() {
		return warenkorb;
	}

	public final void setWarenkorb(NSMutableArray<BestellPosition> warenkorb) {
		this.warenkorb = warenkorb;
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public final NSMutableArray<Inhalt> getInhalte() {
		return inhalte;
	}

	public final void setInhalte(NSMutableArray<Inhalt> inhalte) {
		this.inhalte = inhalte;
	}

}
