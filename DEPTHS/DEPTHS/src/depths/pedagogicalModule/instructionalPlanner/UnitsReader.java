package depths.pedagogicalModule.instructionalPlanner;


import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class UnitsReader
    extends DefaultHandler {

  private DiscoursePlanner discoursePlanner;
  private CharArrayWriter contents = new CharArrayWriter();
  private SAXParser parser;
  private String uri;

  private boolean inConceptGeneralInformation = false;
  private boolean inUnitGeneralInformation = false;
  private boolean inQuestions = false;
  private boolean inFragment = false;
  private boolean inTestGeneralInformation = false;
  private LOM_reader_Mgr lomReaderMgr;
  private String requestedID;
  private boolean inRequestedConcept = false;
  private LessonSelector lSel;

  public UnitsReader(SAXParser parser, DiscoursePlanner dp, LessonSelector ls,
                     String uri, String rID,
                     LOM_reader_Mgr lp) {
    this.parser = parser;
    this.uri = uri;
    discoursePlanner = dp;
    lSel = ls;
    lomReaderMgr = lp;
    requestedID = rID;
  }

  public void startDocument() throws SAXException {
  }

  public void endDocument() throws SAXException {
  }

  public void startElement(String namespaceURI,
                           String localName,
                           String qName,
                           Attributes attr) throws SAXException {
    contents.reset();
    if (qName.equals("LOM")) {
    }
    if (qName.equals("Concept")) {
    }
    if (qName.equals("Unit")){
      if (inRequestedConcept){
        lSel.readNewUnit();

      }
    }
    if (qName.equals("conceptGeneralInformation")) {
      inConceptGeneralInformation = true;
    }
    if (qName.equals("unitGeneralInformation")) {
      inUnitGeneralInformation = true;
    }
    if (qName.equals("Questions")) {
      inQuestions = true;
    }
    if (qName.equals("Fragment")) {
      inFragment = true;
    }
  }

  public void endElement(String namespaceURI,
                         String localName,
                         String qName) throws SAXException {
    if (qName.equals("Concept")) {
      if (inRequestedConcept) {
        lSel.endOfReadingCurrentConcept();
            inRequestedConcept = false;

      }
    }
    if (qName.equals("identifier")) {
      if (inConceptGeneralInformation) {
        if (contents.toString().equals(requestedID) ) {
          inRequestedConcept = true;
          lSel.setCurrConceptID(contents.toString());

        }
      }
      else if (inUnitGeneralInformation) {
        if (inRequestedConcept) {
          lSel.setUnitInfo("ID", contents.toString());

        }
      }
      else if (inFragment) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("title")) {
      if (inConceptGeneralInformation) {
        if (inRequestedConcept) {
        }
      }
      else if (inUnitGeneralInformation) {
        if (inRequestedConcept) {

        }
      }
      else if (inFragment) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("type")) {
      if (inFragment) {
        if (inRequestedConcept) {
        }
      }
    }
    if (qName.equals("difficultyLevel")) {
      if (inUnitGeneralInformation) {
        if (inRequestedConcept) {
          lSel.setUnitInfo("difficultyLevel",
                           Integer.parseInt(contents.toString()));

        }
      }
      else if (inFragment) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("detailLevel")) {
      if (inUnitGeneralInformation) {
        if (inRequestedConcept) {
        }
      }
      else if (inFragment) {
        if (inRequestedConcept) {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("ordinalNumber")) {
      if (inUnitGeneralInformation) {
        if (inRequestedConcept) {
          lSel.setUnitInfo("ordinalNumber", Integer.parseInt(contents.toString()));

        }
      }
    }
    if (qName.equals("related-to")) {
      // ubaciti kod
    }
    if (qName.equals("Unit")){
      if (inRequestedConcept){
        lSel.endOfReadingUnit();

      }
    }
    ///////////////////////////
    if (qName.equals("conceptGeneralInformation")) {
      inConceptGeneralInformation = false;
    }
    if (qName.equals("unitGeneralInformation")) {
      inUnitGeneralInformation = false;
    }
    if (qName.equals("inQuestions")) {
      inQuestions = false;
    }
    if (qName.equals("Fragment")) {
      inFragment = false;
    }
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    contents.write(ch, start, length);
  }
}
