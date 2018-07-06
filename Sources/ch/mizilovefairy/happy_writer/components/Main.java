package ch.mizilovefairy.happy_writer.components;

import java.math.BigDecimal;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Inhalt;

public class Main extends BaseComponent {
	private static final long serialVersionUID = 4288351211711722265L;
	private BestellPosition wareLoopVar;
	private Inhalt inhaltLoopVar;

	public Main(WOContext context) {
		super(context);
	}

	public WOComponent checkOut() {
		return pageWithName(PCheckOut.class);

	}
	
	public WOComponent clickOutSide() {
		return null;
	}
	
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
	
	public WOComponent etuiBestellen() {
		return(getPageWithArticle("Etui"));
	}
	
	public WOComponent schachtelBestellen() {
		return(getPageWithArticle("Holzschachtel"));
	}
	
	private final WOComponent getPageWithArticle(String bezeichnung) {
		PArtikel page = pageWithName(PArtikel.class);
		Artikel artikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.like(bezeichnung));
		page.setArtikel(artikel);
		return page;
	}

	public WOComponent artikelEntfernen() {
		// entferne artikel
		System.out.println(wareLoopVar.artikel().bezeichnung());
		NSMutableArray<BestellPosition> warenkorb = session().getWarenkorb();
		wareLoopVar.delete();
		warenkorb.remove(wareLoopVar);
		return null; 
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
