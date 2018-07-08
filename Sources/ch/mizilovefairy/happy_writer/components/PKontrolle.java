package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Bestellung;
import ch.mizilovefairy.happy_writer.db.Kunde;

/**
 * Hier kann der User seine Daten kontrollieren.
 * 
 * @author Marco Selenati
 *
 */
public class PKontrolle extends BaseComponent {
	private static final long serialVersionUID = 999080953184221504L;
	/**
	 * Das Kunde Model welches wir mit den Daten füllen.
	 */
	private Kunde kunde;
	/**
	 * Das Bestellungs Model welches wir mit den Daten füllen.
	 */
	private Bestellung bestellung;

	public PKontrolle(WOContext context) {
		super(context);
	}

	/**
	 * Hier werden die Daten noch fertig ausgefüllt und nacher wird alles auf die
	 * Datenbank geschrieben.
	 * 
	 * @return Die Dankes Seite.
	 */
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

	/**
	 * Hier gehen wir eine Seite zurück.
	 * 
	 * Wichtig ist hier das wir die datenbank einträge wieder raus nehmen. Weil die
	 * datenbank einträge weiterhin bestehen würden mit ungültigen daten. Wenn dann
	 * ein saveChanges kommt gibt es einen Error.
	 * 
	 * @return Die Hauptseite.
	 */
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
