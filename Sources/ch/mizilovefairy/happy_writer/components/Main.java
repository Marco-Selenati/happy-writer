package ch.mizilovefairy.happy_writer.components;

import java.math.BigDecimal;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Inhalt;

/**
 * Die Hauptseite, hier werden alle benutzer geschickt wenn Sie in die
 * Applikation kommen.
 * 
 * @author Marco Selenati
 *
 */
public class Main extends BaseComponent {
	private static final long serialVersionUID = 4288351211711722265L;
	private BestellPosition wareLoopVar;
	private Inhalt inhaltLoopVar;

	public Main(WOContext context) {
		super(context);
	}

	/**
	 * Rechnet die summe aller dinge im Warenkorb aus.
	 * 
	 * Dafür schaut die methode welche Artikel im Warenkorb sind und welche Inhalte
	 * der User für diese Artiel ausgewählt hat.
	 * 
	 * @return Die summe des Preises der Dinge im Warenkorb.
	 */
	public final String gesamtPreis() {
		BigDecimal summe = new BigDecimal(0);
		for (BestellPosition bp : session().getWarenkorb()) {
			summe = summe.add(bp.artikel().preis());
			for (Inhalt inhalt : bp.inhalte()) {
				summe = summe.add(inhalt.preis());
			}
		}
		return summe.toString();
	}

	/**
	 * Gibt die Produktseite des artikels welcher die bezeichnung hat.
	 * 
	 * @param bezeichnung
	 *            Die Artikel bezeichnung aus der Datenbank.
	 * @return Die Produkt seite mit dem spezifizierten Artikel.
	 */
	private final WOComponent getPageWithArticle(String bezeichnung) {
		PArtikel page = pageWithName(PArtikel.class);
		Artikel artikel = Artikel.fetchArtikel(session().defaultEditingContext(),
				Artikel.BEZEICHNUNG.like(bezeichnung));
		page.setArtikel(artikel);
		return page;
	}

	/**
	 * Entfernt den Artikel aus dem Warenkorb.
	 * 
	 * Da der Artikel jetzt nicht mehr im Warenkorb ist, wenn wir die jetzige Seite
	 * nochmals zurückgeben wird die änderungen im Warenkorb dem User angezeigt.
	 * 
	 * @return Die jetzige Seite.
	 */
	public WOComponent artikelEntfernen() {
		// entferne artikel
		System.out.println(wareLoopVar.artikel().bezeichnung());
		NSMutableArray<BestellPosition> warenkorb = session().getWarenkorb();
		wareLoopVar.delete();
		warenkorb.remove(wareLoopVar);
		return null;
	}

	/**
	 * Verlinkt zum Check Out.
	 * 
	 * Dort kann der User seine Daten eingeben.
	 * 
	 * @return Die Check Out Seite.
	 */
	public WOComponent checkOut() {
		return pageWithName(PCheckOut.class);

	}

	/**
	 * Wenn der User ausserhalb der definierten Bereiche des Bildes klickt soll er
	 * auf der gleichen Seite bleiben.
	 * 
	 * @return Die gleiche Seite.
	 */
	public WOComponent clickOutSide() {
		return null;
	}

	/**
	 * Wenn der User auf das Etui click soll er auf die Etui produktseite gelangen.
	 * 
	 * @return Die Etui produktseite.
	 */
	public WOComponent etuiBestellen() {
		return (getPageWithArticle("Etui"));
	}

	/**
	 * Wenn der User auf die Holzschachtel clickt soll er auf die Holozschachtel
	 * produktseite gelangen.
	 * 
	 * @return Die Holzschachtel produktseite.
	 */
	public WOComponent schachtelBestellen() {
		return (getPageWithArticle("Holzschachtel"));
	}

	public final BestellPosition getWareLoopVar() {
		return wareLoopVar;
	}

	public final void setWareLoopVar(BestellPosition wareLoopVar) {
		this.wareLoopVar = wareLoopVar;
	}

	public final Inhalt getInhaltLoopVar() {
		return inhaltLoopVar;
	}

	public final void setInhaltLoopVar(Inhalt inhaltLoopVar) {
		this.inhaltLoopVar = inhaltLoopVar;
	}

	public final boolean isWarenkorbEmpty() {
		return session().getWarenkorb().size() == 0;
	}

}
