package depths.domainModule;

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class CourseReader
    extends DefaultHandler {
  private CharArrayWriter contents = new CharArrayWriter();
  private Course course;
  private SAXParser parser;
  private String uri;

  private boolean inConceptGeneralInformation = false;
  private boolean inUnitGeneralInformation = false;
  private boolean inTestGeneralInformation = false;
  private boolean inFragment = false;
  private boolean inQuestionare = false;

  public CourseReader(SAXParser parser, Course c, String uri) {
    this.parser = parser;
    this.uri = uri;
    course = c;
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
    if (qName.equals("Concept")) {
      course.newConcept();
    }
    if (qName.equals("Unit")) {
      course.newUnit();
    }
    if (qName.equals("Fragment")) {
      course.newFragment();
      inFragment = true;
    }
    if (qName.equals("Questionare")) {
      course.newQuestion();
      inQuestionare = true;
    }
    if (qName.equals("Question")) {
    }
    if (qName.equals("Answer")) {
      course.newAnswer();
    }
    ///////////////////////////////////////
    if (qName.equals("conceptGeneralInformation")) {
      inConceptGeneralInformation = true;
    }
    if (qName.equals("unitGeneralInformation")) {
      inUnitGeneralInformation = true;
    }
    if (qName.equals("testGeneralInformation")) {
      inTestGeneralInformation = true;
    }
  }

  public void endElement(String namespaceURI,
                         String localName,
                         String qName) throws SAXException {
    if (qName.equals("identifier")) {
      processingID(contents.toString());
    }
    if (qName.equals("title")) {
      processingTitle(contents.toString());
    }
    if (qName.equals("difficultyLevel")) {
      if (inUnitGeneralInformation) {
        course.addUnitElem("difficultyLevel",
                           Integer.parseInt(contents.toString()));
      }
      else if (inTestGeneralInformation) {
        course.addQuestionElem("difficultyLevel",
                               Integer.parseInt(contents.toString()));
      }
    }
    if (qName.equals("detailLevel")) {
      if (inFragment) {
        course.addFragmentElem("detailLevel",
                               Integer.parseInt(contents.toString()));
      }
      else if (inUnitGeneralInformation) {
        course.addUnitElem("detailLevel", Integer.parseInt(contents.toString()));
      }
    }
    if (qName.equals("content")) {
      if (inFragment) {
        course.addFragmentElem("content", contents.toString());
      }
    }
    if (qName.equals("Answer")) {
      course.finishAnswer();
    }
    if (qName.equals("type")) {
      course.addFragmentElem("type", contents.toString());
    }
    if (qName.equals("related-to")) {
      course.addQuestionElem("related-to", contents.toString());
    }
    if (qName.equals("Question")) {
      course.addQuestionElem("questionContent", contents.toString());
    }
    if (qName.equals("truth")) {
      if (contents.toString().equals("true")) {
        course.addAnswerElem("truth", true);
      }
      else if (contents.toString().equals("false")) {
        course.addAnswerElem("truth", false);
      }
    }
    if (qName.equals("textOfAnswer")) {
      course.addAnswerElem("textOfAnswer", contents.toString());
    }
    if (qName.equals("group")) {

      course.addQuestionElem("group", Integer.parseInt(contents.toString()));
    }

    ///////////////////////////
    if (qName.equals("conceptGeneralInformation")) {
      inConceptGeneralInformation = false;
    }
    if (qName.equals("unitGeneralInformation")) {
      inUnitGeneralInformation = false;
    }
    if (qName.equals("testGeneralInformation")) {
      inTestGeneralInformation = false;
    }
    if (qName.equals("Fragment")) {
      course.finishFragment();
      inFragment = false;
    }
    if (qName.equals("Questionare")) {
      course.finishQuestion();
      inQuestionare = false;
    }
    if (qName.equals("Unit")) {
      course.finishUnit();
    }
    if (qName.equals("Concept")) {
      course.finishConcept();
    }
  }
  public void characters(char[] ch, int start, int length) throws SAXException {
    contents.write(ch, start, length);
  }
  public void processingID(String id) {
    if (inConceptGeneralInformation) {
      course.addConceptElement("ID", id);
    }
    else if (inUnitGeneralInformation) {
      course.addUnitElem("ID", id);
    }
    else if (inFragment) {
      course.addFragmentElem("ID", id);
    }
    else if (inTestGeneralInformation) {
      course.addQuestionElem("ID", id);
    }
  }
  public void processingTitle(String t) {
    if (inConceptGeneralInformation) {
      course.addConceptElement("title", t);
    }
    else if (inUnitGeneralInformation) {
      course.addUnitElem("title", t);

    }
    else if (inFragment) {
      course.addFragmentElem("title", t);

    }
    else if (inTestGeneralInformation) {
      course.addQuestionElem("title", t);
    }
  }
}
