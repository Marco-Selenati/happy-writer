package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.Application;
import ch.mizilovefairy.happy_writer.Session;
import er.extensions.components.ERXComponent;

public class BaseComponent extends ERXComponent {
	private static final long serialVersionUID = 410386748963675317L;

	public BaseComponent(WOContext context) {
		super(context);
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
}
