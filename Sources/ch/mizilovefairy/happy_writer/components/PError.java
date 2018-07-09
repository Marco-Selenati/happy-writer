package ch.mizilovefairy.happy_writer.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

/**
 * Hier wird der User weitergeleitet falls etwas schief geht.
 * 
 * @author Marco Selenati
 *
 */
public class PError extends WOComponent {
	private static final long serialVersionUID = -3124141555778059307L;

	public PError(WOContext context) {
		super(context);
	}
}