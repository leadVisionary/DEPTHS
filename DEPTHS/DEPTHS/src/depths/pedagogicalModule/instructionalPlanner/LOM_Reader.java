package depths.pedagogicalModule.instructionalPlanner;


import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class LOM_Reader
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
  private int counter = 1; //brojac koncepata
  private int requestedID; //trazeni koncept(od 1 do 24 pri kreiranju plana koncepata
  private boolean readingConcepts = false;
  private LOM_reader_Mgr lomReaderMgr;
  private int concNumber; //broj koncepata u xml dokumentu

  public LOM_Reader(SAXParser parser, DiscoursePlanner dp, String uri, int br,
                    LOM_reader_Mgr lp) {

    this.parser = parser;
    this.uri = uri;
    discoursePlanner = dp;
    requestedID = br;
    lomReaderMgr = lp;
  }

  public void startDocument() throws SAXException {

  }

  public void endDocument() throws SAXException {
    counter = 0;

  }

  public void startElement(String namespaceURI,
                           String localName,
                           String qName,
                           Attributes attr) throws SAXException {
    contents.reset();
    if (qName.equals("LOM")) {
      String cNumber = attr.getValue("concNumber");
      concNumber = Integer.parseInt(cNumber);
    }
    if (qName.equals("Concept")) {
      if (counter == requestedID) {
        readingConcepts = true;
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
      counter++;
      if (counter == concNumber) {
        if (requestedID == (concNumber - 1)) {

          lomReaderMgr.restartCNumbering();
        }
      }
      readingConcepts = false;
    }
    if (qName.equals("identifier")) {
      if (inConceptGeneralInformation) {
        if (readingConcepts) {
          discoursePlanner.setCInfo("ID", contents.toString());
        }
      }
      else if (inUnitGeneralInformation) {
        if (inFragment) {
          //ubaciti kod
        }
        else {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        //ubaciti kod
      }
    }
    if (qName.equals("title")) {
      if (inConceptGeneralInformation) {
        if (readingConcepts) {
          discoursePlanner.setCInfo("title", contents.toString());
        }
      }
      else if (inUnitGeneralInformation) {
        if (inFragment) {
          //ubaciti kod
        }
        else {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        //ubaciti kod
      }
    }
    if (qName.equals("type")) {
      if (inConceptGeneralInformation) {
        if (readingConcepts) {
          discoursePlanner.setCInfo("type", contents.toString());
        }
      }
      else if (inUnitGeneralInformation) {
        if (inFragment) {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("detailLevel")) {
      if (inUnitGeneralInformation) {
        if (inFragment) {
          //ubaciti kod
        }
        else {
          //ubaciti kod
        }
      }
    }
    if (qName.equals("difficultyLevel")) {
      if (inUnitGeneralInformation) {
        if (inFragment) {
          //ubaciti kod
        }
        else {
          //ubaciti kod
        }
      }
      else if (inQuestions) {
        //ubaciti kod
      }
    }
    if (qName.equals("prerequisite")) {

      if (readingConcepts) {
        discoursePlanner.setCInfo("prerequisite", contents.toString());
      }

    }
    if (qName.equals("minKnowledgeLevel")) {
      if (readingConcepts) {
        discoursePlanner.setCInfo("minKnowledgeLevel", contents.toString());
      }
    }
    if (qName.equals("ordinalNumber")) {
      if (inConceptGeneralInformation) {
        if (readingConcepts) {
          discoursePlanner.setCInfo("ordinalNumber", contents.toString());
        }
      }
    }
    if (qName.equals("related-to")) {
      // ubaciti kod
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
