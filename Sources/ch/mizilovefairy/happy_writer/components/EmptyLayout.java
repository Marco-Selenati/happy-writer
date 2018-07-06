package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class EmptyLayout extends WOComponent {
	private static final long serialVersionUID = -7564942125165579389L;
	/**
	 * Den Titel der Seite.
	 * 
	 * Dieses field muss im wod gesetzt werden.
	 */
	private String pageTitle;

	public EmptyLayout(WOContext context) {
		super(context);
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}