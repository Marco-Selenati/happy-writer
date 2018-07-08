package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.Inhalt;

/**
 * Hier kann der Admin den Artikeln Inhaltsartikel hinzufügen und entfernen.
 * 
 * @author Marco Selenati
 *
 */
public class PAdminArtikel extends BaseComponent {
	private static final long serialVersionUID = -2482648544055929591L;
	/**
	 * Der Artikel dem wir die Inhaltsartikel bearbeiten.
	 */
	private Artikel artikel = null;
	private Inhalt inhaltLoopVar;
	/**
	 * Die Inhaltsartikel welche dieser Artikel beinhalten kann.
	 */
	private NSMutableArray<Inhalt> inhalte;
	/**
	 * Die Inhaltsartikel welche dieser Artikel nicht beinhalten kann.
	 */
	private NSMutableArray<Inhalt> inhalteNichtInArtikel;

	public PAdminArtikel(WOContext context) {
		super(context);
	}

	/**
	 * Entfernt den Inhaltsartikel vom Artikel.
	 * 
	 * @return Die jetzige Seite.
	 */
	public final WOComponent removeInhaltFromArtikel() {
		artikel.removeFromInhalteRelationship(inhaltLoopVar);
		inhalte.remove(inhaltLoopVar);
		inhalteNichtInArtikel.add(inhaltLoopVar);
		return null;
	}

	/**
	 * Speichert die änderungen in die Datenbank.
	 * 
	 * @return Die jetzige Seite.
	 */
	public final WOComponent commit() {
		session().defaultEditingContext().saveChanges();
		init();
		return null;
	}

	/**
	 * Stellt den zustand der letzten Speicherung wieder her.
	 * 
	 * @return Die jetzige Seite.
	 */
	public final WOComponent abort() {
		revertChanges();
		return null;
	}

	/**
	 * Stellt den zustand der letzten Speicherung wieder her und geht zur Admin
	 * Seite.
	 * 
	 * @return Die Admin Seite.
	 */
	public final WOComponent back() {
		revertChanges();
		return pageWithName(PAdmin.class);
	}

	/**
	 * Fügt dem Artikel den Inhaltsartikel hinzu.
	 * 
	 * @return Die jetzige Seite.
	 */
	public final WOComponent addInhaltToArticle() {
		inhalteNichtInArtikel.remove(inhaltLoopVar);
		inhalte.add(inhaltLoopVar);
		inhaltLoopVar.addToArtikel(artikel);
		return null;
	}

	/**
	 * Stellt den letzten gespeicherten Zustand wieder her.
	 */
	private final void revertChanges() {
		// revert transaction state
		session().defaultEditingContext().revert();
		// revert Admin editing state
		session().setInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone());
		init();
	}

	/**
	 * Stellt einen validen start Zustand her.
	 */
	private final void init() {
		inhalte = artikel.inhalte().mutableClone();
		inhalteNichtInArtikel = Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone();
		inhalteNichtInArtikel.removeAll(inhalte);
	}

	public final Artikel getArtikel() {
		return artikel;
	}

	public final void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public final Inhalt getInhaltLoopVar() {
		return inhaltLoopVar;
	}

	public final void setInhaltLoopVar(Inhalt inhaltLoopVar) {
		this.inhaltLoopVar = inhaltLoopVar;
	}

	public final NSMutableArray<Inhalt> getInhalte() {
		if (inhalte == null)
			init();
		return inhalte;
	}

	public final void setInhalte(NSMutableArray<Inhalt> inhalte) {
		this.inhalte = inhalte;
	}

	public final NSMutableArray<Inhalt> getInhalteNichtInArtikel() {
		if (inhalte == null)
			init();
		return inhalteNichtInArtikel;
	}

	public final void setInhalteNichtInArtikel(NSMutableArray<Inhalt> inhalteNichtInArtikel) {
		this.inhalteNichtInArtikel = inhalteNichtInArtikel;
	}

}