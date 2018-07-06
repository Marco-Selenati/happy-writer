package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

import ch.mizilovefairy.happy_writer.db.Bestellung;
import ch.mizilovefairy.happy_writer.db.Kunde;
import er.extensions.eof.ERXEOControlUtilities;

public class PCheckOut extends BaseComponent {
	private static final long serialVersionUID = -549163271548909228L;
	private Kunde kunde;
	private Bestellung bestellung;

	public PCheckOut(WOContext context) {
		super(context);
		// check ob wir schon kunden und bestellungs objekte erstellt haben
		if(session().getKunde() == null) {
			kunde = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Kunde.class);
			bestellung = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Bestellung.class);
		} else {
			kunde = session().getKunde();
			bestellung = session().getBestellung();
		}
	}

	public final WOComponent submit() {
		kunde.setKundeSeit(new NSTimestamp());
		bestellung.setDatum(new NSTimestamp());
		// speichere die finalen kunden und bestellungs daten
		bestellung.setKundenRelationship(kunde);
		// session kunde/ bestellung setzen
		// falls der kunde etwas falsch eingegeben hat nehmen wir die aus der session
		session().setKunde(kunde);
		session().setBestellung(bestellung);
		return pageWithName(PKontrolle.class);
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
}
