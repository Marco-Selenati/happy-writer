// DO NOT EDIT.  Make changes to BestellPosition.java instead.
package ch.mizilovefairy.happy_writer.db;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;
import er.extensions.eof.ERXKey.Type;
import er.extensions.eof.ERXQ;

@SuppressWarnings("all")
public abstract class _BestellPosition extends ERXGenericRecord {
	public static final String ENTITY_NAME = "BestellPosition";

	// Attribute Keys

	// Relationship Keys
	public static final ERXKey<ch.mizilovefairy.happy_writer.db.Artikel> ARTIKEL = new ERXKey<ch.mizilovefairy.happy_writer.db.Artikel>(
			"artikel", Type.ToOneRelationship);
	public static final ERXKey<ch.mizilovefairy.happy_writer.db.Bestellung> BESTELLUNG = new ERXKey<ch.mizilovefairy.happy_writer.db.Bestellung>(
			"bestellung", Type.ToOneRelationship);
	public static final ERXKey<ch.mizilovefairy.happy_writer.db.Inhalt> INHALTE = new ERXKey<ch.mizilovefairy.happy_writer.db.Inhalt>(
			"inhalte", Type.ToManyRelationship);

	// Attributes

	// Relationships
	public static final String ARTIKEL_KEY = ARTIKEL.key();
	public static final String BESTELLUNG_KEY = BESTELLUNG.key();
	public static final String INHALTE_KEY = INHALTE.key();

	private static final Logger log = LoggerFactory.getLogger(_BestellPosition.class);

	public BestellPosition localInstanceIn(EOEditingContext editingContext) {
		BestellPosition localInstance = (BestellPosition) EOUtilities.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public ch.mizilovefairy.happy_writer.db.Artikel artikel() {
		return (ch.mizilovefairy.happy_writer.db.Artikel) storedValueForKey(_BestellPosition.ARTIKEL_KEY);
	}

	public void setArtikel(ch.mizilovefairy.happy_writer.db.Artikel value) {
		takeStoredValueForKey(value, _BestellPosition.ARTIKEL_KEY);
	}

	public void setArtikelRelationship(ch.mizilovefairy.happy_writer.db.Artikel value) {
		log.debug("updating artikel from {} to {}", artikel(), value);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			setArtikel(value);
		} else if (value == null) {
			ch.mizilovefairy.happy_writer.db.Artikel oldValue = artikel();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BestellPosition.ARTIKEL_KEY);
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, _BestellPosition.ARTIKEL_KEY);
		}
	}

	public ch.mizilovefairy.happy_writer.db.Bestellung bestellung() {
		return (ch.mizilovefairy.happy_writer.db.Bestellung) storedValueForKey(_BestellPosition.BESTELLUNG_KEY);
	}

	public void setBestellung(ch.mizilovefairy.happy_writer.db.Bestellung value) {
		takeStoredValueForKey(value, _BestellPosition.BESTELLUNG_KEY);
	}

	public void setBestellungRelationship(ch.mizilovefairy.happy_writer.db.Bestellung value) {
		log.debug("updating bestellung from {} to {}", bestellung(), value);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			setBestellung(value);
		} else if (value == null) {
			ch.mizilovefairy.happy_writer.db.Bestellung oldValue = bestellung();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BestellPosition.BESTELLUNG_KEY);
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, _BestellPosition.BESTELLUNG_KEY);
		}
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.Inhalt> inhalte() {
		return (NSArray<ch.mizilovefairy.happy_writer.db.Inhalt>) storedValueForKey(_BestellPosition.INHALTE_KEY);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.Inhalt> inhalte(EOQualifier qualifier) {
		return inhalte(qualifier, null);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.Inhalt> inhalte(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		NSArray<ch.mizilovefairy.happy_writer.db.Inhalt> results;
		results = inhalte();
		if (qualifier != null) {
			results = (NSArray<ch.mizilovefairy.happy_writer.db.Inhalt>) EOQualifier.filteredArrayWithQualifier(results,
					qualifier);
		}
		if (sortOrderings != null) {
			results = (NSArray<ch.mizilovefairy.happy_writer.db.Inhalt>) EOSortOrdering
					.sortedArrayUsingKeyOrderArray(results, sortOrderings);
		}
		return results;
	}

	public void addToInhalte(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		includeObjectIntoPropertyWithKey(object, _BestellPosition.INHALTE_KEY);
	}

	public void removeFromInhalte(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		excludeObjectFromPropertyWithKey(object, _BestellPosition.INHALTE_KEY);
	}

	public void addToInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		log.debug("adding {} to inhalte relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToInhalte(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTE_KEY);
		}
	}

	public void removeFromInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		log.debug("removing {} from inhalte relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromInhalte(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTE_KEY);
		}
	}

	public ch.mizilovefairy.happy_writer.db.Inhalt createInhalteRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.mizilovefairy.happy_writer.db.Inhalt.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _BestellPosition.INHALTE_KEY);
		return (ch.mizilovefairy.happy_writer.db.Inhalt) eo;
	}

	public void deleteInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTE_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllInhalteRelationships() {
		Enumeration<ch.mizilovefairy.happy_writer.db.Inhalt> objects = inhalte().immutableClone().objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteInhalteRelationship(objects.nextElement());
		}
	}

	public static BestellPosition createBestellPosition(EOEditingContext editingContext,
			ch.mizilovefairy.happy_writer.db.Artikel artikel, ch.mizilovefairy.happy_writer.db.Bestellung bestellung) {
		BestellPosition eo = (BestellPosition) EOUtilities.createAndInsertInstance(editingContext,
				_BestellPosition.ENTITY_NAME);
		eo.setArtikelRelationship(artikel);
		eo.setBestellungRelationship(bestellung);
		return eo;
	}

	public static ERXFetchSpecification<BestellPosition> fetchSpec() {
		return new ERXFetchSpecification<BestellPosition>(_BestellPosition.ENTITY_NAME, null, null, false, true, null);
	}

	public static NSArray<BestellPosition> fetchAllBestellPositions(EOEditingContext editingContext) {
		return _BestellPosition.fetchAllBestellPositions(editingContext, null);
	}

	public static NSArray<BestellPosition> fetchAllBestellPositions(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _BestellPosition.fetchBestellPositions(editingContext, null, sortOrderings);
	}

	public static NSArray<BestellPosition> fetchBestellPositions(EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<BestellPosition> fetchSpec = new ERXFetchSpecification<BestellPosition>(
				_BestellPosition.ENTITY_NAME, qualifier, sortOrderings);
		NSArray<BestellPosition> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static BestellPosition fetchBestellPosition(EOEditingContext editingContext, String keyName, Object value) {
		return _BestellPosition.fetchBestellPosition(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellPosition fetchBestellPosition(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<BestellPosition> eoObjects = _BestellPosition.fetchBestellPositions(editingContext, qualifier, null);
		BestellPosition eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one BestellPosition that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellPosition fetchRequiredBestellPosition(EOEditingContext editingContext, String keyName,
			Object value) {
		return _BestellPosition.fetchRequiredBestellPosition(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellPosition fetchRequiredBestellPosition(EOEditingContext editingContext, EOQualifier qualifier) {
		BestellPosition eoObject = _BestellPosition.fetchBestellPosition(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException(
					"There was no BestellPosition that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellPosition localInstanceIn(EOEditingContext editingContext, BestellPosition eo) {
		BestellPosition localInstance = (eo == null) ? null
				: ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
