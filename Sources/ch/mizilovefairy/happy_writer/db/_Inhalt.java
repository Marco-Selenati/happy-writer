// DO NOT EDIT.  Make changes to Inhalt.java instead.
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
public abstract class _Inhalt extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Inhalt";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name", Type.Attribute);
  public static final ERXKey<java.math.BigDecimal> PREIS = new ERXKey<java.math.BigDecimal>("preis", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<ch.mizilovefairy.happy_writer.db.Artikel> ARTIKEL = new ERXKey<ch.mizilovefairy.happy_writer.db.Artikel>("artikel", Type.ToManyRelationship);
  public static final ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition> BESTELL_POSITIONEN = new ERXKey<ch.mizilovefairy.happy_writer.db.BestellPosition>("bestellPositionen", Type.ToManyRelationship);

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String PREIS_KEY = PREIS.key();

  // Relationships
  public static final String ARTIKEL_KEY = ARTIKEL.key();
  public static final String BESTELL_POSITIONEN_KEY = BESTELL_POSITIONEN.key();

  private static final Logger log = LoggerFactory.getLogger(_Inhalt.class);

  public Inhalt localInstanceIn(EOEditingContext editingContext) {
    Inhalt localInstance = (Inhalt)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Inhalt.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _Inhalt.NAME_KEY);
  }

  public java.math.BigDecimal preis() {
    return (java.math.BigDecimal) storedValueForKey(_Inhalt.PREIS_KEY);
  }

  public void setPreis(java.math.BigDecimal value) {
    log.debug( "updating preis from {} to {}", preis(), value);
    takeStoredValueForKey(value, _Inhalt.PREIS_KEY);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.Artikel> artikel() {
    return (NSArray<ch.mizilovefairy.happy_writer.db.Artikel>)storedValueForKey(_Inhalt.ARTIKEL_KEY);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.Artikel> artikel(EOQualifier qualifier) {
    return artikel(qualifier, null);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.Artikel> artikel(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<ch.mizilovefairy.happy_writer.db.Artikel> results;
      results = artikel();
      if (qualifier != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.Artikel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.Artikel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToArtikel(ch.mizilovefairy.happy_writer.db.Artikel object) {
    includeObjectIntoPropertyWithKey(object, _Inhalt.ARTIKEL_KEY);
  }

  public void removeFromArtikel(ch.mizilovefairy.happy_writer.db.Artikel object) {
    excludeObjectFromPropertyWithKey(object, _Inhalt.ARTIKEL_KEY);
  }

  public void addToArtikelRelationship(ch.mizilovefairy.happy_writer.db.Artikel object) {
    log.debug("adding {} to artikel relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToArtikel(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKEL_KEY);
    }
  }

  public void removeFromArtikelRelationship(ch.mizilovefairy.happy_writer.db.Artikel object) {
    log.debug("removing {} from artikel relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromArtikel(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKEL_KEY);
    }
  }

  public ch.mizilovefairy.happy_writer.db.Artikel createArtikelRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.mizilovefairy.happy_writer.db.Artikel.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.ARTIKEL_KEY);
    return (ch.mizilovefairy.happy_writer.db.Artikel) eo;
  }

  public void deleteArtikelRelationship(ch.mizilovefairy.happy_writer.db.Artikel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKEL_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllArtikelRelationships() {
    Enumeration<ch.mizilovefairy.happy_writer.db.Artikel> objects = artikel().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteArtikelRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen() {
    return (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)storedValueForKey(_Inhalt.BESTELL_POSITIONEN_KEY);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier) {
    return bestellPositionen(qualifier, null);
  }

  public NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> bestellPositionen(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition> results;
      results = bestellPositionen();
      if (qualifier != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.mizilovefairy.happy_writer.db.BestellPosition>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    includeObjectIntoPropertyWithKey(object, _Inhalt.BESTELL_POSITIONEN_KEY);
  }

  public void removeFromBestellPositionen(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    excludeObjectFromPropertyWithKey(object, _Inhalt.BESTELL_POSITIONEN_KEY);
  }

  public void addToBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    log.debug("adding {} to bestellPositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellPositionen(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONEN_KEY);
    }
  }

  public void removeFromBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    log.debug("removing {} from bestellPositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellPositionen(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONEN_KEY);
    }
  }

  public ch.mizilovefairy.happy_writer.db.BestellPosition createBestellPositionenRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.mizilovefairy.happy_writer.db.BestellPosition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.BESTELL_POSITIONEN_KEY);
    return (ch.mizilovefairy.happy_writer.db.BestellPosition) eo;
  }

  public void deleteBestellPositionenRelationship(ch.mizilovefairy.happy_writer.db.BestellPosition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONEN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellPositionenRelationships() {
    Enumeration<ch.mizilovefairy.happy_writer.db.BestellPosition> objects = bestellPositionen().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellPositionenRelationship(objects.nextElement());
    }
  }


  public static Inhalt createInhalt(EOEditingContext editingContext, String name
, java.math.BigDecimal preis
) {
    Inhalt eo = (Inhalt) EOUtilities.createAndInsertInstance(editingContext, _Inhalt.ENTITY_NAME);
    eo.setName(name);
    eo.setPreis(preis);
    return eo;
  }

  public static ERXFetchSpecification<Inhalt> fetchSpec() {
    return new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext) {
    return _Inhalt.fetchAllInhalts(editingContext, null);
  }

  public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Inhalt.fetchInhalts(editingContext, null, sortOrderings);
  }

  public static NSArray<Inhalt> fetchInhalts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Inhalt> fetchSpec = new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Inhalt> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Inhalt fetchInhalt(EOEditingContext editingContext, String keyName, Object value) {
    return _Inhalt.fetchInhalt(editingContext, ERXQ.equals(keyName, value));
  }

  public static Inhalt fetchInhalt(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Inhalt> eoObjects = _Inhalt.fetchInhalts(editingContext, qualifier, null);
    Inhalt eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Inhalt that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Inhalt fetchRequiredInhalt(EOEditingContext editingContext, String keyName, Object value) {
    return _Inhalt.fetchRequiredInhalt(editingContext, ERXQ.equals(keyName, value));
  }

  public static Inhalt fetchRequiredInhalt(EOEditingContext editingContext, EOQualifier qualifier) {
    Inhalt eoObject = _Inhalt.fetchInhalt(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Inhalt that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Inhalt localInstanceIn(EOEditingContext editingContext, Inhalt eo) {
    Inhalt localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
