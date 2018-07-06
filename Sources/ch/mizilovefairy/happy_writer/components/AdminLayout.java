package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

public class AdminLayout extends BaseComponent {
	private static final long serialVersionUID = 7008833280104880743L;
	private String pageTitle;

	public AdminLayout(WOContext context) {
		super(context);
	}

	public final WOComponent homepage() {
		return pageWithName(Main.class);
	}

	public WOComponent adminLogin() {
		return pageWithName(PAdminLogin.class);
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}