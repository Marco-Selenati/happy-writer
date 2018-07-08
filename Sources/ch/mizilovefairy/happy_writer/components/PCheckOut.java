package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Bestellung;
import ch.mizilovefairy.happy_writer.db.Kunde;
import er.extensions.eof.ERXEOControlUtilities;

/**
 * Hier kann der nutzer sein daten eingeben für die Bestellung.
 * 
 * @author Marco Selenati
 *
 */
public class PCheckOut extends BaseComponent {
	private static final long serialVersionUID = -549163271548909228L;
	/**
	 * Das Kunde Model welches wir mit den Daten füllen.
	 */
	private Kunde kunde;
	/**
	 * Das Bestellungs Model welches wir mit den Daten füllen.
	 */
	private Bestellung bestellung;

	/**
	 * Erstellen der datensätze die der User im form bearbeiten wird.
	 * 
	 * @param context
	 *            der context.
	 */
	public PCheckOut(WOContext context) {
		super(context);
		kunde = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Kunde.class);
		bestellung = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Bestellung.class);
	}

	/**
	 * Verlinkt den user auf die Bestätigungs Seite.
	 * 
	 * Die Daten welche hier eingegeben wurden werden der nächsten Seite gegeben.
	 * 
	 * @return Die user Daten kontrollier Seite.
	 */
	public final WOComponent submit() {
		PKontrolle kontrolle = pageWithName(PKontrolle.class);
		// session kunde/ bestellung setzen
		// falls der kunde etwas falsch eingegeben hat nehmen wir die aus der session
		kontrolle.setKunde(kunde);
		kontrolle.setBestellung(bestellung);
		return kontrolle;
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
