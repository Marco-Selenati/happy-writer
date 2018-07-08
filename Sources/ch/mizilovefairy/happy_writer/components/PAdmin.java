package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.Inhalt;

/**
 * Die Admin Hauptseite.
 * 
 * Hier kann man auswählen ob man Inhaltsartikel zu Artikeln hinzufügen will,
 * oder neue Inhaltsartikel erstellen will.
 * 
 * @author Marco Selenati
 *
 */
public class PAdmin extends BaseComponent {
	private static final long serialVersionUID = -116767444479334545L;
	private Artikel artikelLoopVar;

	public PAdmin(WOContext context) {
		super(context);
		if (session().getInhalte() == null) {
			session().setInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone());
			session().setArtikel(Artikel.fetchAllArtikels(session().defaultEditingContext()).mutableClone());

		}
	}

	/**
	 * Verlinkt zur Admin Inhaltsartikel verwaltungs Seite.
	 * 
	 * @return Die Admin Inhaltsartikel Seite.
	 */
	public final WOComponent inhalte() {
		return pageWithName(PAdminInhalt.class);
	}

	/**
	 * Verlinkt zur Inhaltsartikel zu Artikeln hinzufügen Seite.
	 * 
	 * @return Die Inhaltsartikel zu Artikel hinzufügen Seite.
	 */
	public final WOComponent artikelInhalte() {
		PAdminArtikel admin = pageWithName(PAdminArtikel.class);
		admin.setArtikel(artikelLoopVar);

		return admin;
	}

	public final Artikel getArtikelLoopVar() {
		return artikelLoopVar;
	}

	public final void setArtikelLoopVar(Artikel artikelLoopVar) {
		this.artikelLoopVar = artikelLoopVar;
	}

}
