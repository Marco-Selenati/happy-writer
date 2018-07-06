package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;

public class BaseLayout extends BaseComponent {
	private static final long serialVersionUID = -4703138291072601139L;
	private String pageTitle;

	public BaseLayout(WOContext context) {
		super(context);
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
