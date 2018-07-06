// DO NOT EDIT.  Make changes to Bestellung.java instead.
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
public abstract class _Bestellung extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bestellung";

  // Attribute Keys
  public static final ERXKey<String> BEMERKUNGEN = new ERXKey<String>("bemerkungen", Type.Attribute);
  public static final ERXKey<NSTimestamp> DATUM = new ERXKey<NSTimestamp>("datum", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition> BESTELL_POSITIONEN = new ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition>("bestellPositionen", Type.ToManyRelationship);
  public static final ERXKey<ch.mizilovefairy.happy_writer.db.Kunde> KUNDEN = new ERXKey<ch.mizilovefairy.happy_writer.db.Kunde>("kunden", Type.ToOneRelationship);

  // Attributes
  public static final String BEMERKUNGEN_KEY = BEMERKUNGEN.key();
  public static final String DATUM_KEY = DATUM.key();

  // Relationships
  public static final String BESTELL_POSITIONEN_KEY = BESTELL_POSITIONEN.key();
  public static final String KUNDEN_KEY = KUNDEN.key();

  private static final Logger log = LoggerFactory.getLogger(_Bestellung.class);

  public Bestellung localInstanceIn(EOEditingContext editingContext) {
    Bestellung localInstance = (Bestellung)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bemerkungen() {
    return (String) storedValueForKey(_Bestellung.BEMERKUNGEN_KEY);
  }

  public void setBemerkungen(String value) {
    log.debug( "updating bemerkungen from {} to {}", bemerkungen(), value);
    takeStoredValueForKey(value, _Bestellung.BEMERKUNGEN_KEY);
  }

  public NSTimestamp datum() {
    return (NSTimestamp) storedValueForKey(_Bestellung.DATUM_KEY);
  }

  public void setDatum(NSTimestamp value) {
    log.debug( "updating datum from {} to {}", datum(), value);
    takeStoredValueForKey(value, _Bestellung.DATUM_KEY);
  }

  public ch.mizilovefairy.happy_writer.db.Kunde kunden() {
    return (ch.mizilovefairy.happy_writer.db.Kunde)storedValueForKey(_Bestellung.KUNDEN_KEY);
  }

  public void setKunden(ch.mizilovefairy.happy_writer.db.Kunde value) {
    takeStoredValueForKey(value, _Bestellung.KUNDEN_KEY);
  }

  public void setKundenRelationship(ch.mizilovefairy.happy_writer.db.Kunde value) {
    log.debug("updating kunden from {} to {}", kunden(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setKunden(value);
    }
    else if (value == null) {
      ch.mizilovefairy.happy_writer.db.Kunde oldValue = kunden();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellung.KUNDEN_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellung.KUNDEN_KEY);
    }
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen() {
    return (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)storedValueForKey(_Bestellung.BESTELL_POSITIONEN_KEY);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier) {
    return bestellPositionen(qualifier, null, false);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier, boolean fetch) {
    return bestellPositionen(qualifier, null, fetch);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.mizilovefairy.happy_writer.db.BestellPosition.BESTELLUNG_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.mizilovefairy.happy_writer.db.BestellPosition.fetchBestellPositions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestellPositionen();
      if (qualifier != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    includeObjectIntoPropertyWithKey(object, _Bestellung.BESTELL_POSITIONEN_KEY);
  }

  public void removeFromBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    excludeObjectFromPropertyWithKey(object, _Bestellung.BESTELL_POSITIONEN_KEY);
  }

  public void addToBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    log.debug("adding {} to bestellPositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellPositionen(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONEN_KEY);
    }
  }

  public void removeFromBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    log.debug("removing {} from bestellPositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellPositionen(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONEN_KEY);
    }
  }

  public ch.mizilovefairy.happy_writer.db.BestellPosition createBestellPositionenRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.mizilovefairy.happy_writer.db.BestellPosition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bestellung.BESTELL_POSITIONEN_KEY);
    return (ch.mizilovefairy.happy_writer.db.BestellPosition) eo;
  }

  public void deleteBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONEN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellPositionenRelationships() {
    Enumeration<ch.mizilovefairy.happy_writer.db.BestellPosition> objects = bestellPositionen().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellPositionenRelationship(objects.nextElement());
    }
  }


  public static Bestellung createBestellung(EOEditingContext editingContext, NSTimestamp datum
, ch.mizilovefairy.happy_writer.db.Kunde kunden) {
    Bestellung eo = (Bestellung) EOUtilities.createAndInsertInstance(editingContext, _Bestellung.ENTITY_NAME);
    eo.setDatum(datum);
    eo.setKundenRelationship(kunden);
    return eo;
  }

  public static ERXFetchSpecification<Bestellung> fetchSpec() {
    return new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext) {
    return _Bestellung.fetchAllBestellungs(editingContext, null);
  }

  public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bestellung.fetchBestellungs(editingContext, null, sortOrderings);
  }

  public static NSArray<Bestellung> fetchBestellungs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bestellung> fetchSpec = new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Bestellung> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bestellung fetchBestellung(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellung.fetchBestellung(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellung fetchBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bestellung> eoObjects = _Bestellung.fetchBestellungs(editingContext, qualifier, null);
    Bestellung eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bestellung that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellung.fetchRequiredBestellung(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
    Bestellung eoObject = _Bestellung.fetchBestellung(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bestellung that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellung localInstanceIn(EOEditingContext editingContext, Bestellung eo) {
    Bestellung localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
