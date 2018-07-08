package ch.mizilovefairy.happy_writer.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Artikel extends _Artikel {
	private static final long serialVersionUID = -5821139984767216103L;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Artikel.class);

	/**
	 * Generiert den Icon lokation aus der bezeichnung.
	 * 
	 * @return Die icon lokation.
	 */
	public final String icon() {
		return "assets/artikel/" + bezeichnung() + ".jpg";
	}
}
