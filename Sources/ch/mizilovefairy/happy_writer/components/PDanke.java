package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;

/**
 * Die Dankes Seite.
 * 
 * Wenn der User den kauf erfolgreich abgeschlossen hat wird Ihm diese Seite
 * angezeigt.
 * 
 * @author Marco Selenati
 *
 */
public class PDanke extends BaseComponent {
	private static final long serialVersionUID = 7315599828186878742L;

	/**
	 * Wir terminieren die Session.
	 * 
	 * Hier ist der Kauf abgeschlossen. Der warenkorb wird geleert durch die Session
	 * terminierung.
	 * 
	 * @param context
	 *            Der context.
	 */
	public PDanke(WOContext context) {
		super(context);
		session().terminate();
	}
}
