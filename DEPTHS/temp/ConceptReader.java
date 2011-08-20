package depths.studentModule;


import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.text.SimpleDateFormat;



public class ConceptReader extends DefaultHandler {
  private SAXParser parser;
  private Student stud;
  private String uri;
  private CharArrayWriter contents=new CharArrayWriter();

  private boolean inPassConceptFlags=false;
  private boolean inPassUnitFlags=false;
  private boolean inPassTestFlags=false;

  private boolean inGeneral=false;
  private boolean inUnitGeneralInformation=false;
  private boolean inTestGeneralInformation=false;

  private boolean inConceptKnowledge=false;
  private boolean inTestKnowledge=false;
  private boolean inConceptCapabilityAssessment=false;
  private boolean inUnit=false;
  private boolean inTest=false;
  private boolean inQuestion=false;
  private SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

  public ConceptReader()
  {

  }
  public void collectConcepts(SAXParser parser,Student st,String uri)
  {

    this.parser=parser;
    this.uri=uri;
    stud=st;
    try{
      parser.parse(uri,this);
    }catch(Exception e)
    {
    }
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

   if (qName.equals("passConceptFlags"))
   {

     inPassConceptFlags=true;
   }
   if (qName.equals("passUnitFlags"))
   {
     inPassUnitFlags=true;
   }
   if (qName.equals("passTestFlags"))
   {
     inPassTestFlags=true;
   }
   if (qName.equals("general"))
   {
     inGeneral=true;
   }
   if (qName.equals("conceptCapabilityAssessment"))
   {
     inConceptCapabilityAssessment=true;
   }
   if (qName.equals("unitGeneralInformation"))
   {

     inUnitGeneralInformation=true;
   }
   if (qName.equals("testGeneralInformation"))
   {
     inTestGeneralInformation=true;
   }
   if (qName.equals("conceptKnowledge"))
   {
     inConceptKnowledge=true;
   }
   if (qName.equals("testKnowledge"))
   {
      inTestKnowledge=true;
   }
   if (qName.equals("Test"))
   {
     inTest=true;
     stud.createNewTest();
   }
   if (qName.equals("Question"))
   {
     inQuestion=true;
     stud.createNewQuestion();
   }
   if (qName.equals("Concept"))
   {
     stud.studTeachingHistory.addConcept();
   }

   if (qName.equals("Unit"))
   {
     inUnit=true;
     stud.studTeachingHistory.addUnit();
   }

 }

 public void endElement(String namespaceURI,
                        String localName,
                        String qName) throws SAXException {
if (qName.equals("started"))
  {
    if(inPassConceptFlags)
    {

      try{
        java.util.Date date=df.parse(contents.toString());
        stud.setTimeElement("started",
                            date);
      }catch(Exception e){
        System.out.println(" ERROR: Date Time error while parsing started from SM="+e.getStackTrace()+" "+e.getMessage());

      }
    }else if (inPassUnitFlags)
    {

    }else if (inPassTestFlags)
    {

    }
  }
 if (qName.equals("finished"))
  {
    if(inPassConceptFlags)
    {
      try{
        java.util.Date date=df.parse(contents.toString());
        stud.setTimeElement("finished", date);

      }catch(Exception e){
        System.out.println("ERROR: Date Time error while parsing finished from SM");
      }


    }else if (inPassUnitFlags)
    {

    }else
    {

    }
  }
 if (qName.equals("numberOfPasses"))
  {
    if(inPassConceptFlags)
    {
      stud.studTeachingHistory.addConceptGeneralElement("numberOfPasses",contents.toString());
    }else if (inPassUnitFlags)
    {
      stud.studTeachingHistory.addUnitGeneralElement("numberOfPasses",contents.toString());
    }else
    {

    }
  }
 if (qName.equals("title"))
  {
    if (inGeneral)
    {
      stud.studTeachingHistory.addConceptGeneralElement("title",contents.toString());
    }else if (inUnitGeneralInformation)
    {
      stud.studTeachingHistory.addUnitGeneralElement("title",contents.toString());
    }else
    {

    }
  }
 if (qName.equals("ID"))
  {
    if (inGeneral)
    {
       stud.studTeachingHistory.addConceptGeneralElement("ID",contents.toString());
    }else if (inUnitGeneralInformation)
    {
      stud.studTeachingHistory.addUnitGeneralElement("ID",contents.toString());
    }else if (inTestGeneralInformation)
    {

    }else if (inQuestion){
      stud.addQuestionElem("ID",contents.toString());
    }

  }
 if (qName.equals("reference"))
  {
    if (inGeneral)
    {
       stud.studTeachingHistory.addConceptGeneralElement("reference",contents.toString());
    }else if (inUnitGeneralInformation)
    {
      stud.studTeachingHistory.addUnitGeneralElement("reference",contents.toString());
    }else
    {

    }

  }
 if (qName.equals("degreeOfMastery"))
  {
    if (inConceptKnowledge)
    {
      stud.addConceptElement("degreeOfMastery",Integer.parseInt(contents.toString()));
    }else if (inTestKnowledge)
    {
        stud.addTestGeneralElem("degreeOfMastery",Integer.parseInt(contents.toString()));
    }
  }
  if (qName.equals("group")){
    stud.addQuestionElem("group", Integer.parseInt(contents.toString()));
  }
  if (qName.equals("knowledgeLevel"))
   {
     if (inConceptKnowledge)
   {
     stud.addConceptElement("knowledgeLevel",Integer.parseInt(contents.toString()));
   }else if (inTestKnowledge)
   {
       stud.addTestGeneralElem("knowledgeLevel",Integer.parseInt(contents.toString()));
   }
 }
 if(qName.equals("experienceLevel"))
 {
   if (inConceptCapabilityAssessment)
   {
     stud.addConceptElement("experienceLevel", contents.toString());
   }
 }
 if (qName.equals("truth")){
   String val=contents.toString();
   if (val.equals("true")){
     stud.addQuestionElem("truth",true );
   }else{
     stud.addQuestionElem("truth",false);
   }
 }
 if (qName.equals("reasoningAbilityLevel"))
 {
   if (inConceptCapabilityAssessment)
   {
     stud.addConceptElement("reasoningAbilityLevel",
         contents.toString());
   }
 }
 if (qName.equals("ordinalNumber")){
   if (inUnit) {
     stud.studTeachingHistory.addUnitOrdinalNumber(Integer.parseInt(contents.
         toString()));
   }
 }

 if (qName.equals("passConceptFlags"))
{
  inPassConceptFlags=false;
}
if (qName.equals("passUnitFlags"))
{
  inPassUnitFlags=false;
}
if (qName.equals("passTestFlags"))
{
  inPassTestFlags=false;
}
if (qName.equals("general"))
{
  inGeneral=false;
}
if (qName.equals("unitGeneralInformation"))
{
  inUnitGeneralInformation=false;
}
if (qName.equals("testGeneralInformation"))
{
  inTestGeneralInformation=false;
}
if (qName.equals("conceptKnowledge"))
{
  inConceptKnowledge=false;
}
if (qName.equals("testKnowledge"))
{
   inTestKnowledge=false;
}
 if (qName.equals("conceptCapabilityAssessment"))
 {
   inConceptCapabilityAssessment=false;
 }
 if (qName.equals("Unit")){
   inUnit=false;
 }
 if (qName.equals("Test")){
   inTest=false;
   stud.addTest();
 }
 if (qName.equals("Question")){
   inQuestion=false;
   stud.addQuestion();
 }
 if (qName.equals("duration")){
   if (inTest){
     stud.addTestDuration(Integer.parseInt(contents.toString()));
   }else{
     stud.addConceptDuration(Integer.parseInt(contents.toString()));
   }
 }




}
 public void characters(char[] ch, int start, int length) throws SAXException {

    contents.write(ch,start,length);

  }

}
