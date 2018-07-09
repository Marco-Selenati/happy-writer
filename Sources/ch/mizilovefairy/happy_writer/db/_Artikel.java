// DO NOT EDIT.  Make changes to Artikel.java instead.
package ch.mizilovefairy.happy_writer.db;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.eof.ERXKey.Type;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _Artikel extends ERXGenericRecord {
	public static final String ENTITY_NAME = "Artikel";

	// Attribute Keys
	public static final ERXKey<String> BEZEICHNUNG = new ERXKey<String>("bezeichnung", Type.Attribute);
	public static final ERXKey<java.math.BigDecimal> PREIS = new ERXKey<java.math.BigDecimal>("preis", Type.Attribute);

	// Relationship Keys
	public static final ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition> BESTELL_POSITIONEN = new ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition>(
			"bestellPositionen", Type.ToManyRelationship);
	public static final ERXKey<ch.mizilovefairy.happy_writer.db.Inhalt> INHALTE = new ERXKey<ch.mizilovefairy.happy_writer.db.Inhalt>(
			"inhalte", Type.ToManyRelationship);

	// Attributes
	public static final String BEZEICHNUNG_KEY = BEZEICHNUNG.key();
	public static final String PREIS_KEY = PREIS.key();

	// Relationships
	public static final String BESTELL_POSITIONEN_KEY = BESTELL_POSITIONEN.key();
	public static final String INHALTE_KEY = INHALTE.key();

	private static final Logger log = LoggerFactory.getLogger(_Artikel.class);

	public Artikel localInstanceIn(EOEditingContext editingContext) {
		Artikel localInstance = (Artikel) EOUtilities.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public String bezeichnung() {
		return (String) storedValueForKey(_Artikel.BEZEICHNUNG_KEY);
	}

	public void setBezeichnung(String value) {
		log.debug("updating bezeichnung from {} to {}", bezeichnung(), value);
		takeStoredValueForKey(value, _Artikel.BEZEICHNUNG_KEY);
	}

	public java.math.BigDecimal preis() {
		return (java.math.BigDecimal) storedValueForKey(_Artikel.PREIS_KEY);
	}

	public void setPreis(java.math.BigDecimal value) {
		log.debug("updating preis from {} to {}", preis(), value);
		takeStoredValueForKey(value, _Artikel.PREIS_KEY);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen() {
		return (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>) storedValueForKey(
				_Artikel.BESTELL_POSITIONEN_KEY);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier) {
		return bestellPositionen(qualifier, null, false);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier,
			boolean fetch) {
		return bestellPositionen(qualifier, null, fetch);
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
		NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> results;
		if (fetch) {
			EOQualifier fullQualifier;
			EOQualifier inverseQualifier = ERXQ.equals(ch.mizilovefairy.happy_writer.db.BestellPosition.ARTIKEL_KEY,
					this);

			if (qualifier == null) {
				fullQualifier = inverseQualifier;
			} else {
				fullQualifier = ERXQ.and(qualifier, inverseQualifier);
			}

			results = ch.mizilovefairy.happy_writer.db.BestellPosition.fetchBestellPositions(editingContext(),
					fullQualifier, sortOrderings);
		} else {
			results = bestellPositionen();
			if (qualifier != null) {
				results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>) EOQualifier
						.filteredArrayWithQualifier(results, qualifier);
			}
			if (sortOrderings != null) {
				results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>) EOSortOrdering
						.sortedArrayUsingKeyOrderArray(results, sortOrderings);
			}
		}
		return results;
	}

	public void addToBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
		includeObjectIntoPropertyWithKey(object, _Artikel.BESTELL_POSITIONEN_KEY);
	}

	public void removeFromBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
		excludeObjectFromPropertyWithKey(object, _Artikel.BESTELL_POSITIONEN_KEY);
	}

	public void addToBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
		log.debug("adding {} to bestellPositionen relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToBestellPositionen(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONEN_KEY);
		}
	}

	public void removeFromBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
		log.debug("removing {} from bestellPositionen relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromBestellPositionen(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONEN_KEY);
		}
	}

	public ch.mizilovefairy.happy_writer.db.BestellPosition createBestellPositionenRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.mizilovefairy.happy_writer.db.BestellPosition.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.BESTELL_POSITIONEN_KEY);
		return (ch.mizilovefairy.happy_writer.db.BestellPosition) eo;
	}

	public void deleteBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONEN_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllBestellPositionenRelationships() {
		Enumeration<ch.mizilovefairy.happy_writer.db.BestellPosition> objects = bestellPositionen().immutableClone()
				.objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteBestellPositionenRelationship(objects.nextElement());
		}
	}

	public NSArray<ch.mizilovefairy.happy_writer.db.Inhalt> inhalte() {
		return (NSArray<ch.mizilovefairy.happy_writer.db.Inhalt>) storedValueForKey(_Artikel.INHALTE_KEY);
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
		includeObjectIntoPropertyWithKey(object, _Artikel.INHALTE_KEY);
	}

	public void removeFromInhalte(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		excludeObjectFromPropertyWithKey(object, _Artikel.INHALTE_KEY);
	}

	public void addToInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		log.debug("adding {} to inhalte relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToInhalte(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.INHALTE_KEY);
		}
	}

	public void removeFromInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		log.debug("removing {} from inhalte relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromInhalte(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.INHALTE_KEY);
		}
	}

	public ch.mizilovefairy.happy_writer.db.Inhalt createInhalteRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.mizilovefairy.happy_writer.db.Inhalt.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.INHALTE_KEY);
		return (ch.mizilovefairy.happy_writer.db.Inhalt) eo;
	}

	public void deleteInhalteRelationship(ch.mizilovefairy.happy_writer.db.Inhalt object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.INHALTE_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllInhalteRelationships() {
		Enumeration<ch.mizilovefairy.happy_writer.db.Inhalt> objects = inhalte().immutableClone().objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteInhalteRelationship(objects.nextElement());
		}
	}

	public static Artikel createArtikel(EOEditingContext editingContext, String bezeichnung,
			java.math.BigDecimal preis) {
		Artikel eo = (Artikel) EOUtilities.createAndInsertInstance(editingContext, _Artikel.ENTITY_NAME);
		eo.setBezeichnung(bezeichnung);
		eo.setPreis(preis);
		return eo;
	}

	public static ERXFetchSpecification<Artikel> fetchSpec() {
		return new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, null, null, false, true, null);
	}

	public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext) {
		return _Artikel.fetchAllArtikels(editingContext, null);
	}

	public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _Artikel.fetchArtikels(editingContext, null, sortOrderings);
	}

	public static NSArray<Artikel> fetchArtikels(EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<Artikel> fetchSpec = new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, qualifier,
				sortOrderings);
		NSArray<Artikel> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static Artikel fetchArtikel(EOEditingContext editingContext, String keyName, Object value) {
		return _Artikel.fetchArtikel(editingContext, ERXQ.equals(keyName, value));
	}

	public static Artikel fetchArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Artikel> eoObjects = _Artikel.fetchArtikels(editingContext, qualifier, null);
		Artikel eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one Artikel that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, String keyName, Object value) {
		return _Artikel.fetchRequiredArtikel(editingContext, ERXQ.equals(keyName, value));
	}

	public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
		Artikel eoObject = _Artikel.fetchArtikel(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Artikel that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Artikel localInstanceIn(EOEditingContext editingContext, Artikel eo) {
		Artikel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
