package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Artikel;
import ch.mizilovefairy.happy_writer.db.BestellPosition;
import ch.mizilovefairy.happy_writer.db.Inhalt;
import er.extensions.eof.ERXEOControlUtilities;

/**
 * Die produkte seite eines Artikels.
 * 
 * Hier kann man sich eine konfiguration von Inhalten zusammenstellen welche mit
 * dem Artikel geliefert werden sollen.
 * 
 * @author Marco Selenati
 *
 */
public class PArtikel extends BaseComponent {
	private static final long serialVersionUID = 3760272183591908893L;
	/**
	 * Ist der Artikel auf welcher seite wir uns momentan befinden
	 */
	private Artikel artikel;
	/**
	 * Der inhalt in der jetzigen iteration
	 */
	private Inhalt inhaltLoopVar;
	/**
	 * Die inhalte welche auf der Seite ausgewählt worden sind, sind in diesem array
	 * drinn, bei der submit methode
	 */
	private NSMutableArray<Inhalt> inhalteSelections;

	public PArtikel(WOContext context) {
		super(context);
	}

	/**
	 * Wird aufgerufen wenn der user die form will abschicken.
	 * 
	 * Wir müssen hier den artikel mit der Inhalt konfiguration die der User will
	 * abspeicher in der session.
	 * 
	 * @return
	 */
	public final WOComponent submit() {
		BestellPosition ware = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(),
				BestellPosition.class);
		ware.setArtikel(artikel);
		inhalteSelections.forEach(i -> ware.addToInhalte(i));
		session().getWarenkorb().add(ware);
		return pageWithName(Main.class);
	}

	public final Inhalt getInhaltLoopVar() {
		return inhaltLoopVar;
	}

	public final void setInhaltLoopVar(Inhalt inhaltLoopVar) {
		this.inhaltLoopVar = inhaltLoopVar;
	}

	public final NSMutableArray<Inhalt> getInhalteSelections() {
		return inhalteSelections;
	}

	public final void setInhalteSelections(NSMutableArray<Inhalt> inhalteSelections) {
		this.inhalteSelections = inhalteSelections;
	}

	public final Artikel getArtikel() {
		return artikel;
	}

	public final void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

}
