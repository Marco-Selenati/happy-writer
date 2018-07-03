package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Artikel;

public class Main extends BaseComponent {
	private static final long serialVersionUID = 4288351211711722265L;

	public Main(WOContext context) {
		super(context);
	}

	public WOComponent checkOut() {
		return pageWithName(PCheckOut.class);

	}
	
	public WOComponent clickOutSide() {
		return null;
	}
	
	public WOComponent etuiBestellen() {
		return(getPageWithArticle("Etui"));
	}
	
	public WOComponent schachtelBestellen() {
		return(getPageWithArticle("Holzschachtel"));
	}
	
	private final WOComponent getPageWithArticle(String bezeichnung) {
		PArtikel page = pageWithName(PArtikel.class);
		Artikel artikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.like(bezeichnung));
		page.setArtikel(artikel);
		return page;
	}
	
}
