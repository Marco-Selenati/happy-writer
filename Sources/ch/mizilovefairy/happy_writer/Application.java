package ch.mizilovefairy.happy_writer;

import er.extensions.appserver.ERXApplication;

/**
 * Unsere Applikation.
 * 
 * @author Marco Selenati
 *
 */
public class Application extends ERXApplication {
	/**
	 * Hier geben wir die Kontrolle über zu WOnder.
	 * 
	 * @param argv
	 *            die kommando zeilen Argumente.
	 */
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	/**
	 * Der constructor wird von WOnder aufgerufen.
	 * 
	 * Hier können wir unsere Applikations status initialisieren.
	 */
	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);
	}
}
