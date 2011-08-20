//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\XMLReaderMgr.java

package depths.studentModule;


import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.text.SimpleDateFormat;


public class StudentReader extends DefaultHandler
{
  private CharArrayWriter contents = new CharArrayWriter();
  private Student stud;
  private SAXParser parser;
  private String uri;
  private ConceptReader conceptMapper=new ConceptReader();
  private SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

   /**
    * @roseuid 3FF7EE4B00CB
    */
   public StudentReader(SAXParser parser,Student st,String uri)
   {

     this.parser=parser;
     this.uri=uri;
     stud=st;


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

    if (qName.equals("Concept"))
    {
      stud.addConcept();
      conceptMapper.collectConcepts(parser,stud,uri);
    }

  }
  public void endElement(String namespaceURI,
                         String localName,
                         String qName) throws SAXException {
    if (qName.equals("ID"))
     {
       stud.setUserID(Integer.parseInt(contents.toString()));
     }
     if (qName.equals("Name"))
     {
      stud.setUserName(contents.toString());
     }

     if (qName.equals("initialSkillLevel"))
     {

        stud.studPerformance.setInitialSkillLevel(Integer.parseInt(contents.toString()));
     }
     if (qName.equals("actualSkillLevel"))
     {
       stud.studPerformance.setActualSkillLevel(Integer.parseInt(contents.toString()));

     }
     if (qName.equals("learningStyle"))
     {
        stud.studPerformance.setLearningStyle(contents.toString());
     }
     if (qName.equals("timeOfLastSession"))
     {

       try{
         java.util.Date date=df.parse(contents.toString());
        stud.studPerformance.setTimeOfLastSession(date);

      }catch(Exception e)
        {System.out.println("ERROR while parsing timeOfLastSession "+e.getMessage());}
     }
     if (qName.equals("detailLevel"))
     {
        stud.studPerformance.setDetailLevel(Integer.parseInt(contents.toString()));
     }
     if (qName.equals("experienceLevel"))
     {
       stud.studPerformance.setExperienceLevel(contents.toString());
     }
     if (qName.equals("reasoningAbilityLevel"))
     {
        stud.studPerformance.setReasoningLevel(contents.toString());
     }
     if (qName.equals("programmingLanguage")){
       stud.studPerformance.setProgrammingLanguage(contents.toString());

     }
  }

  public void characters(char[] ch, int start, int length) throws SAXException {

    contents.write(ch,start,length);

  }



}
