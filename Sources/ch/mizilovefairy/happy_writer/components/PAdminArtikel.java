package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.Inhalt;

public class PAdminArtikel extends BaseComponent {
	private static final long serialVersionUID = -2482648544055929591L;
	private Artikel artikel = null;
	private Inhalt inhaltLoopVar;
	private NSMutableArray<Inhalt> inhalte;
	private NSMutableArray<Inhalt> inhalteNichtInArtikel;

	public PAdminArtikel(WOContext context) {
		super(context);
	}

	public final WOComponent removeInhaltFromArtikel() {
		artikel.removeFromInhalteRelationship(inhaltLoopVar);
		inhalte.remove(inhaltLoopVar);
		inhalteNichtInArtikel.add(inhaltLoopVar);
		return null;
	}

	public final WOComponent commit() {
		session().defaultEditingContext().saveChanges();
		init();
		return null;
	}

	public final WOComponent abort() {
		revertChanges();
		return null;
	}

	public final WOComponent back() {
		revertChanges();
		return pageWithName(PAdmin.class);
	}

	public final WOComponent addInhaltToArticle() {
		inhalteNichtInArtikel.remove(inhaltLoopVar);
		inhalte.add(inhaltLoopVar);
		inhaltLoopVar.addToArtikel(artikel);
		return null;
	}

	private final void revertChanges() {
		// revert transaction state
		session().defaultEditingContext().revert();
		// revert Admin editing state
		session().setInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone());
		init();
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

	private final void init() {
		inhalte = artikel.inhalte().mutableClone();
		inhalteNichtInArtikel = Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone();
		inhalteNichtInArtikel.removeAll(inhalte);
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