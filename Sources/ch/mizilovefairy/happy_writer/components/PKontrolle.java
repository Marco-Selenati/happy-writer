package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Bestellung;
import ch.mizilovefairy.happy_writer.db.Kunde;

public class PKontrolle extends BaseComponent {
	private static final long serialVersionUID = 999080953184221504L;
	private Kunde kunde;
	private Bestellung bestellung;

	public PKontrolle(WOContext context) {
		super(context);
	}

	public final WOComponent commit() {
		// verbinde bestellung mit den waren im warenkorb
		NSMutableArray<BestellPosition> warenkorb = session().getWarenkorb();
		warenkorb.forEach(ware -> ware.setBestellung(bestellung));
		// speichere es auf die datenbank
		NSTimestamp now = new NSTimestamp();
		System.out.println("new" + now);
		kunde.setKundeSeit(now);
		bestellung.setDatum(now);
		System.out.println("datum" + bestellung.datum());
		session().defaultEditingContext().saveChanges();
		return pageWithName(PDanke.class);
	}

	public final WOComponent back() {
		kunde.delete();
		bestellung.delete();
		return pageWithName(Main.class);
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
