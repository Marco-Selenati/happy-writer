package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Inhalt;
import er.extensions.eof.ERXEOControlUtilities;

/**
 * Hier kann der Admin neue Inhalte erstellen, die er nachher auf PAdminArtikel
 * zu Artikeln hinzufügen kann.
 * 
 * @author Marco Selenati
 *
 */
public class PAdminInhalt extends BaseComponent {
	private static final long serialVersionUID = 8383706725331830516L;
	private Inhalt inhaltLoopVar;

	public PAdminInhalt(WOContext context) {
		super(context);
	}

	/**
	 * Verlinkt zur Inhaltsartikel erstellungs Seite.
	 * 
	 * @return Die Inhaltsartikel erstellungs Seite.
	 */
	public final WOComponent inhaltNew() {
		PAdminEditCreate editCreate = pageWithName(PAdminEditCreate.class);
		Inhalt inhalt = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Inhalt.class);
		// set for next view
		editCreate.setInhalt(inhalt);
		// set it in the Admin editing state
		NSMutableArray<Inhalt> inhalte = session().getInhalte();
		inhalte.add(inhalt);
		return editCreate;

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
	 * Stellt einen validen start Zustand her.
	 */
	private final void init() {
		NSMutableArray<Inhalt> inhalte = Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone();
		session().setInhalte(inhalte);
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
	 * Löscht den Inhaltsartikel.
	 * 
	 * @return Die jetzige Seite.
	 */
	public final WOComponent inhaltDelete() {
		inhaltLoopVar.delete();
		NSMutableArray<Inhalt> inhalte = session().getInhalte();
		inhalte.remove(inhaltLoopVar);
		return null;
	}

	/**
	 * Verlinkt zur editier Seite.
	 * 
	 * @return Die editier Seite.
	 */
	public final WOComponent inhaltEdit() {
		PAdminEditCreate editCreate = pageWithName(PAdminEditCreate.class);
		editCreate.setInhalt(inhaltLoopVar);
		return editCreate;
	}

	public final Inhalt getInhaltLoopVar() {
		return inhaltLoopVar;
	}

	public final void setInhaltLoopVar(Inhalt inhaltLoopVar) {
		this.inhaltLoopVar = inhaltLoopVar;
	}

}