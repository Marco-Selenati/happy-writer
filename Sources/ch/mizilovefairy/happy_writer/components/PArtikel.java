package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.Inhalt;

public class PArtikel extends BaseComponent {
	private static final long serialVersionUID = 3760272183591908893L;
	private Artikel artikel;
	private Inhalt inhaltLoopVar;
	private NSArray<Boolean> inhalteSelections;

	public PArtikel(WOContext context) {
		super(context);
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

	public final NSArray<Boolean> getInhalteSelections() {
		return inhalteSelections;
	}

	public final void setInhalteSelections(NSArray<Boolean> inhalteSelections) {
		this.inhalteSelections = inhalteSelections;
	}
	
	public final WOComponent submit() {
		return null;
	}
}
