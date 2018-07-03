package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;

import ch.mizilovefairy.happy_writer.db.Artikel;

public class PArtikel extends BaseComponent {
	private static final long serialVersionUID = 3760272183591908893L;
	private Artikel artikel;

	public PArtikel(WOContext context) {
		super(context);
	}

	public final Artikel getArtikel() {
		return artikel;
	}

	public final void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
}
