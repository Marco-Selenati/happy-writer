package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;

public class PAdmin extends BaseComponent {
	private static final long serialVersionUID = -116767444479334545L;

	public PAdmin(WOContext context) {
		super(context);
		session().setPageTitle("Admin");
	}
}
