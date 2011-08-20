package depths.domainModule;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

public class XMLCourseReaderMgr {
  private Course course;
  public XMLCourseReaderMgr(Course c, String rRef) {
    course = c;
    String uri = rRef;
    try {
      SAXParserFactory parserFactory = SAXParserFactory.newInstance();
      parserFactory.setValidating(false);
      parserFactory.setNamespaceAware(false);
      SAXParser parser = parserFactory.newSAXParser();
      CourseReader xmlreaderInstance = new CourseReader(parser, course, uri);
      parser.parse(uri, xmlreaderInstance);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    catch (SAXException ex) {
      ex.printStackTrace();
    }
    catch (ParserConfigurationException ex) {
      ex.printStackTrace();
    }
    catch (FactoryConfigurationError ex) {
      ex.printStackTrace();
    }
  }
}
