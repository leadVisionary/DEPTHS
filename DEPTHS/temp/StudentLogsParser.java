//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentLogsParser.java

package depths.studentModule;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import java.io.FileOutputStream;


import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;


import org.xml.sax.helpers.DefaultHandler;




public class StudentLogsParser
{
  private Element root;
    private Document doc=null;
    private File docFile;
    private String reference=new String();
    private SessionManager sManager;
    private Student student;
    private DefaultHandler dh=new DefaultHandler();


   public StudentLogsParser(SessionManager sm,Student st)
   {
     sManager=sm;
     student=st;

     docFile=new File("resources/xml/StudentModuleLogs.xml");


     try {
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       dbf.setValidating(true);

       DocumentBuilder db = dbf.newDocumentBuilder();
       db.setErrorHandler(dh);
       doc=db.parse(docFile);
       root=doc.getDocumentElement();

 } catch (javax.xml.parsers.ParserConfigurationException pce) {
System.out.println("ERROR: The parser was not configured correctly.");
System.exit(1);
} catch (java.io.IOException ie) {
System.out.println("ERROR: Cannot read input file."+ie.getMessage());

System.exit(1);
} catch (org.xml.sax.SAXException se) {
System.out.println("ERROR: Problem parsing the file.");
System.exit(1);
} catch (java.lang.IllegalArgumentException ae) {
System.out.println("ERROR: Please specify an XML source.");
System.exit(1);
 }
   }

   /**
    * Pronalazi korisnika na osnovu njegovog ID
    * @roseuid 3FF006D001A5
    */
   public void findUser(String studName,String userID,String password)
   {


     String readReference = new String();
     String writeReference = new String();

     NodeList students = root.getElementsByTagName("Student");
     boolean existUser = false;

     for (int studentNum = 0; studentNum < students.getLength(); studentNum++) {

       Element thisStudent = (Element) students.item(studentNum);
       String thisStudentID = thisStudent.getElementsByTagName("userID").item(0).
           getFirstChild().getNodeValue();

       String thisStudentPassword = thisStudent.getElementsByTagName("password").
           item(0).getFirstChild().getNodeValue();

       if (thisStudentID.equals(userID)) { //ako je nadjen korisnik

         if (thisStudentPassword.equals(password)) {
           //ako je lozinka odgovarajuca
           String thisStudentName = thisStudent.getElementsByTagName(
               "studentName").item(0).getFirstChild().getNodeValue();
           existUser = true;

           readReference = thisStudent.getElementsByTagName("reference").item(0).
               getFirstChild().getNodeValue();

           writeReference = readReference;
         }
       }
     }
       if (!existUser) {
           System.out.println("StudentLogsParser findUser if !existUser");
         writeReference = setReference(userID);

         readReference = "resources/xml/template.xml";
         addUser(studName, userID, writeReference, password);
       }
       sManager.setReferences(readReference, writeReference);


   }

     public String setReference(String userID)
     {

       String ref="resources/xml/"+userID.toString()+".xml";

       reference=ref;
       return reference;
     }




     public void addUser(String studName,String userID,String ref, String password)
     {
       NodeList students=doc.getElementsByTagName("studentName");
       Node thisNode=students.item(0);



       Node newNode=doc.createElement("Student");
       Node nameNode=doc.createElement("studentName");
       Text textNameNode=doc.createTextNode(studName);
       nameNode.appendChild(textNameNode);


       Node userIDNode=doc.createElement("userID");
       Text textUserIDNode=doc.createTextNode(userID);
       userIDNode.appendChild(textUserIDNode);

       Node referenceNode=doc.createElement("reference");
       Text textReferenceNode=doc.createTextNode(ref);
       referenceNode.appendChild(textReferenceNode);

       Node passwordNode=doc.createElement("password");
       Text textPasswordNode=doc.createTextNode(password);
       passwordNode.appendChild(textPasswordNode);





       newNode.appendChild(nameNode);
       newNode.appendChild(userIDNode);
       newNode.appendChild(referenceNode);
        newNode.appendChild(passwordNode);
       root.insertBefore(newNode,thisNode.getParentNode());

       writeAsXML(doc);

       sManager.sendStudData(studName,userID);



       }

       public void writeAsXML(Document doc)
       {
         try{
           TransformerFactory transFactory = TransformerFactory.newInstance();
           Transformer transformer = transFactory.newTransformer();
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");

           DOMSource source = new DOMSource(doc);

           FileOutputStream os = new FileOutputStream(docFile);
           StreamResult result = new StreamResult(os);
           transformer.transform(source, result);
         } catch (Exception ex)
         {
           System.out.println("ERROR: Exception");
         }
       }

     }



