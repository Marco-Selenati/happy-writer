package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Inhalt;

public class PAdminEditCreate extends BaseComponent {
	private static final long serialVersionUID = -9073693511569071102L;
	private Inhalt inhalt;

	public PAdminEditCreate(WOContext context) {
		super(context);
	}
	
	public final WOComponent submit() {
		return pageWithName(PAdminInhalt.class);
		
	}

	public final Inhalt getInhalt() {
		return inhalt;
	}

	public final void setInhalt(Inhalt inhalt) {
		this.inhalt = inhalt;
	}

}