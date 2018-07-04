package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.mizilovefairy.happy_writer.db.Inhalt;
import er.extensions.eof.ERXEOControlUtilities;

public class PAdmin extends BaseComponent {
	private static final long serialVersionUID = -116767444479334545L;
	private Inhalt inhaltLoopVar;

	public PAdmin(WOContext context) {
		super(context);
		session().setPageTitle("Admin");
		if (session().getInhalte() == null) {
			session().setInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone());
		}
	}

	public final WOComponent commit() {
		session().defaultEditingContext().saveChanges();
		return null;
	}

	public final WOComponent abort() {
		// revert transaction state
		session().defaultEditingContext().revert();
		// revert Admin editing state
		session().setInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).mutableClone());
		return null;
	}

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

	public final WOComponent inhaltDelete() {
		inhaltLoopVar.delete();
		NSMutableArray<Inhalt> inhalte = session().getInhalte();
		inhalte.remove(inhaltLoopVar);
		return null;
	}

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
