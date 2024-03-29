/* Generated by Together */

package depths.pedagogicalModule.instructionalPlanner;


import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class FragmentsReader
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
  private int requestedID;
  private boolean inRequestedConcept = false;
  private boolean inRequestedUnit = false;
  private FragmentsSelector fSel;
  private String currUnitID;
  private String currConcID;

  public FragmentsReader(SAXParser parser, DiscoursePlanner dp,
                         FragmentsSelector fs,
                         String uri, String currConc,
                         LOM_reader_Mgr lp) {
    this.parser = parser;
    this.uri = uri;
    discoursePlanner = dp;
    fSel = fs;
    lomReaderMgr = lp;
    currConcID = currConc;
  }

  public void setCurrentUnitID(String uid) {
    currUnitID = uid;
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
    if (qName.equals("Unit")) {
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
      if (inRequestedUnit) {
        fSel.readNewFragment(currConcID);
      }
    }
    if (qName.equals("type")) {
     if (inRequestedConcept) {
        if (inRequestedUnit) {
           if (inFragment) {
             String pl=attr.getValue("programmingLanguage");
            if (pl==null){
              pl="any";
            }



          fSel.addFragmentProgrammingLanguage(pl);
        }
      }
    }



   }

  }


  public void endElement(String namespaceURI,
                         String localName,
                         String qName) throws SAXException {
    if (qName.equals("Concept")) {
      if (inRequestedConcept) {
        inRequestedConcept = false;
        //poziv funkcije koja ce da signalizira da je zavrseno parsiranje
        //trenutnog koncepta
      }
    }
    if (qName.equals("identifier")) {
      if (inConceptGeneralInformation) {
        if (contents.toString().equals(currConcID)) {
          inRequestedConcept = true;
        }
      }
      else if (inUnitGeneralInformation) {
        if (inRequestedConcept) {
          if (contents.toString().equals(currUnitID)) {

            inRequestedUnit = true;
          }
          else {
            inRequestedUnit = false;
          }
        }
      }
      else if (inFragment) {
        if (inRequestedConcept) {
          if (inRequestedUnit) {

            fSel.addFragmentID(contents.toString());
          }
        }
      }
    }
    if (qName.equals("title")) {

    }
    if (qName.equals("type")) {
      if (inRequestedConcept) {
         if (inRequestedUnit) {
            if (inFragment) {

           fSel.addFragmentType(contents.toString());
         }
       }
     }



    }
    if (qName.equals("difficultyLevel")) {

    }
    if (qName.equals("detailLevel")) {

        if (inRequestedConcept) {
          if (inRequestedUnit) {
             if (inFragment) {

            fSel.addFragmentDetailLevel(Integer.parseInt(contents.toString()));
          }
        }
      }
    }
    if (qName.equals("ordinalNumber")) {
      if (inUnitGeneralInformation) {
        if (inRequestedUnit) {
        }
      }
    }
    if (qName.equals("Unit")) {
      if (inRequestedConcept) {
        if (inRequestedUnit) {
          fSel.putVectorInPlan();


          //dodati kod koji ce da aktivira proceduru za proveru sledeceg unita
          inRequestedUnit = false;
        }
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

      if (inRequestedUnit){

        fSel.checkCurrFragment();
        //dodati kod koji ce da signalizira proveru fragmenta
        //checkFragment
      }
      inFragment = false;
    }
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    contents.write(ch, start, length);
  }
}
