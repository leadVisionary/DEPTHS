//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\SessionManager.java

package depths.studentModule;

import java.util.*;
import depths.coordinator.*;

public class SessionManager
{
  public SessionManager() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private int studentName;
   private Integer userID;
   private double actualSkillLevel;
   //private StudentLogsParser slp;
   private Student student;

   private String readReference=new String();
   private String writeReference=new String();
   private String studNameToAdd=new String();
   private String studIDToAdd=new String();
   private boolean newUser=false;
   private StudentModelHandler smh;
   private DataWriter dWriter;
   private DataReader dReader;


   /**
    * @roseuid 3FEECB290232
    */
   public SessionManager(StudentModelHandler ref)
   {       smh=ref;
     dWriter=new DataWriter(this);
     dReader=new DataReader();
   }
   //preuzima vektor sa nazivima koncepata za chart dijagram
 public String[] getConceptsTitles(){
   String[] concepts=student.getConceptsTitles();
   return concepts;
 }
 //preuzima vektor sa ocenama koncepata za chart dijagram
public double[] getConceptsDegrees(){
  double[] degrees = student.getConceptsDegrees();
  return degrees;
}
//preuzima vektor sa trenutnim znanjem u toku ucenja  koncepata za chart dijagram
public double[] getActualKnowledgeLevel(){
  double[] actKnowlLevel = student.getActualKnowledgeLevel();
  return actKnowlLevel;
}


   /**
    * Proverava da li je korisnik registrovan u StudentModuleLogs.xml
    */
   /**
    * registruje korisnika tako sto ga upisuje u StudentModuleLogs.xml (pozivom
    * funkcije addUserLog) i creira model studenta {createStudentModel ( );}
    */
  public int userRegistration(String studName,String password,String courseId)
  {

     student=new Student(this);
     dReader.sendReference(student);

     //slp=new StudentLogsParser(this,student);
     userID=new Integer(studName.hashCode());
     student.setUserID(userID.intValue());
     student.setUserName(studName);
     //slp.findUser(studName,userID.toString(),password);
     //dataReader=new XMLReaderMgr(student,readReference);
    // if (newUser)
     //{
      // setStudData(studNameToAdd, studIDToAdd);
       //smh.setNewUser(true);
     //}else {
      // smh.setNewUser(false);

      dReader.setPerformanceFromDatabase(userID.intValue());

      dReader.readTeachingHistory(userID.intValue(),courseId);
      student.setCourseId(courseId);

       smh.setPerformancesForOldUser();

       student.getAllConceptsMarks();



     //}
     return Integer.parseInt(userID.toString());

  }
  public int newUserRegistration(String firstName, String lastName, String userName, String email, String password,
                                 String address, String city, int country, String organization, String webSite,
                                 String language){

    student=new Student(this);

    userID=new Integer(userName.hashCode());

    //trebalo bi odmah upisati podatke u bazu
    dWriter.writeStudentData(userID,firstName,lastName,userName,password,email,address,city,country,organization,webSite,language);
    student.writeStudentData(userID,firstName,lastName,userName,email,address,city,country,organization,webSite,language);
    smh.setNewUser(true);
   //ovo treba obraditi
   return Integer.parseInt(userID.toString());
 }
 //proverava da li izabrano korisnicko ime vec postoji u bazi
  public boolean checkUserName(String userName){
    boolean userNameExist=dReader.checkUserName(userName);
    return userNameExist;
  }
  //proverava da li password odgovara korisniku
 public boolean checkPassword(String userN,String pass){
   boolean passwordOK=dReader.checkPassword(userN, pass);
   return passwordOK;
 }
  public int getStudentId(){
    int studId=student.getUserID();
    return studId;
  }
  public double getInitialSkillLevel(){
     double inSkL=student.getInitialSkillLevel();
     return inSkL;
   }
   public int getDetailLevel(){
     int dl=student.getDetailLevel();
     return dl;
   }
   public double getActualSkillLevel(){
     double asl=student.getActualSkillLevel();
     actualSkillLevel=asl;
         return asl;
   }
   public String getProgrammLang(){
     String pl=student.getProgrammLang();
     return pl;
   }
   public void setActualSkillLevel(double asl){
     student.setActualSkillLevel(asl);
     actualSkillLevel=asl;
   }
   public String getReasoningAbility(){
     String reasoningAb=student.getReasoningAbility();
     return reasoningAb;
   }
   public String getExperienceLevel(){
     String exp=student.getExperienceLevel();
     return exp;
   }
   public String getLearningStyle(){
     String style=student.getLearningStyle();
     return style;
   }

   public void saveStudentData()
   {
     //dataWriter=new StudentXMLWriter(student,writeReference);
     //dataWriter.saveAll();
     dWriter.writePerformance();

   }
   //upisuje u bazu podataka podatke o upravo predjenom konceptu
   public void writeConceptData(String courseId,int studId,String cId,int duration,String feedbackMess,
                                Date started,Date finished,int numbOfPass,
                               double degreeOfMast,double knowlLevel,String experienceLev,String reasonAbility
){
    dWriter.writeConceptData(courseId,studId,cId,duration,feedbackMess,started,finished,numbOfPass,
                        degreeOfMast, knowlLevel, experienceLev, reasonAbility);

  }
  //azurira u bazi podataka podatke o ponovo predjenom konceptu
  public void updateConceptData(String courseId,int studId, String cId,int duration,String feedbackMess,
                               Date started,Date finished,int numbOfPass,
                              double degreeOfMast,double knowlLevel,String experienceLev,String reasonAbility){
    dWriter.updateConceptData(courseId,studId,cId,duration,feedbackMess,started,finished,numbOfPass,
                        degreeOfMast, knowlLevel, experienceLev, reasonAbility);

  }

  //upisuje u bazu podataka podatke o lekciji
   public void writeUnitsData(int userId,String cId,String unitId,Date started,Date finished,int numbOfPasses){
if(dReader.checkPassedLessons(userId,cId,unitId)==false){
  dWriter.writeUnitData(userId, cId, unitId, started, finished, numbOfPasses);
}else{
  dWriter.updateUnitData(userId, cId, unitId, started, finished, numbOfPasses);

}
   }
   //upisuje u bazu podataka podatke o testu
   public void writeTestData(int userId,String cId,int testId,Date started,Date finished,
                            int numbOfPasses,double degreeOfMast,double knowledgeLev,int duration,
      double testDifficultyFactor, double success, double testPointsNumber){

     dWriter.writeTestData(userId,cId,testId, started, finished, numbOfPasses, degreeOfMast, knowledgeLev, duration,
          testDifficultyFactor,  success,  testPointsNumber);
   }
   //upisuje podatke o pitanju u bazu podataka
public void writeQuestionData(int userId,String cId,int testId,String qId,boolean truth){

  dWriter.writeQuestionData(userId,cId,testId,qId,truth);
}


   public void setInitialPerformances(double inSkLev,int detLev, String programmLang){
     student.setInitialPerformances(inSkLev,detLev, programmLang);
     //dodati podatke u bazu podataka
     dWriter.writeInitialPerformances(userID.intValue(), inSkLev, detLev, programmLang);
   }
   public void setReferences(String r,String w)
   {

     readReference=r;
     writeReference=w;

   }
   public void sendStudData(String n,String ID)
   {

     studNameToAdd=n;
     studIDToAdd=ID;
     newUser=true;
     student.signalNewUser(true);
   }
   public void setStudData(String n,String ID)
   {
     student.setUserName(n);
     student.setUserID(Integer.parseInt(ID));
   }
   /**Poziva funkciju koja kreira novi koncept u modelu studenta*/
   public void startNewConcept(String currConcId)
   {
     student.startNewConcept(currConcId);
   }
   /*poziva se kada student ponavlja koncept koji je vec presao*/
  public void startRelearningConcept(String currConcId) {
    student.startRelearningConcept(currConcId);
  }

   public void startFirstConcept(String currConcId){

   	student.startFirstConcept(currConcId);
   }
   /**Ubacuje naziv koncepta u model studenta*/
  public void setCurrConceptTitle(String title){
    student.setCurrConceptTitle(title);
  }

   public void finishNewConcept(){

     student.finishNewConcept();
   }
   public Vector addPassedConceptsToInstrPlanner(){
			 Vector passedConcepts=student.addPassedConceptsToInstrPlanner();
			 return passedConcepts;
		 }
  public void addlearnedUnit(String luId,String unitTitle){
    student.addLearnedUnit(luId,unitTitle);
  }
  //azurira podatke o lekciji kada se ponovo predje
  public void updatePassedLessonInfo(String lUnitId){
    student.updatePassedLessonInfo(lUnitId);
  }

  public void setTestInSM(String qId,int gr){
    student.setTestInSM(qId,gr);
  }
  /**Salje signal u model studenta da kreira novu instancu testa*/
public void startTestInSM(){
student.startTestInSM();
}
/**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
public void addQuestionToSM(String qId,int qGroup,boolean qTruth){
student.addQuestionToSM(qId,qGroup,qTruth);
}
/**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                                  double actSkillLev,double testSuccess,double testPointsNumber){
student.setTestElementsInSM(testKnowledgeLevel,testDifficultyFactor,actSkillLev, testSuccess, testPointsNumber);
}
  /**Salje ocenu za odredjeno poglavlje u klasu GlobalAssessment,
    * radi dobijanja prosecne ocene*/
   public void sendConceptMarkInPedMod(double mark){
     smh.sendConceptMarkInPedMod(mark);

   }
   /**Preuzima broj predjenih koncepata iz modela studenta*/
    public int getNumOfPassedConcepts(){
      int val=student.getNumOfPassedConcepts();
      return val;

    }
    public String getPassedConceptTitleByOrdNum(int i){
    String cTitle=student.getPassedConceptTitleByOrdNum(i);
    return cTitle;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    double degree=student.getPassedConceptDegreeOfMastByOrdNum(i);
return degree;
  }


    /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
  * predjenih koncepata*/
 public void addPassedConceptFromSM(int index){
   student.addPassedConceptFromSM(index);

 }
 /**Salje podatke o predjenim konceptima u prezentacioni modul*/
public void sendStatisticalData(String id,double degreeOfMast,double actualSkillLevel,int duration,String title){

  smh.sendStatisticalData(id,degreeOfMast,actualSkillLevel,duration,title);

}
/**Salje podatke o upravo zavrsenom konceptu u model studenta*/
   public void sendConceptDataToSM(double currConceptDegree,double studSkillLevel){

     student.sendConceptDataToSM(currConceptDegree,studSkillLevel);
   }
   /**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
  * statisticke podatke u lessonStatisticPage*/
 public void getConceptById(String concId){
   student.getConceptById(concId);

 }
 /**Salje podatke o broju lekcija i testova u datom konceptu
  * u lessonStatisticPage*/
 public void sendNumbersOfToStatisticPage(int numOfLessons,int numOfTests){
   smh.sendNumbersOfToStatisticPage(numOfLessons,numOfTests);
 }
 /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){
   String lTitle=student.getLessonTitle(lessOrdNum);
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
   int numOfPass=student.getLessonNumberOfPassess(lessOrdNum);
   return numOfPass;
 }

 /**Postavlja test koji ce se citati za statistic page*/
public void setStatisticTest(int testOrdNum){
  student.setStatisticTest(testOrdNum);
}

 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    String qId=student.getQuestionDataFromSM(qOrdNum);
    return qId;

  }
  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
 public void sendQuestionTruth(boolean qTruth){
   smh.sendQuestionTruth(qTruth);
 }

 /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
   * page*/
 public int getNumberOfQuestions(){
   int numbOfQuests=student.getNumberOfQuestions();
   return numbOfQuests;
 }
 /**Salje podatke o izabranom testu  u statistic page*/
   public void sendTestDataToStatPage(double testDegreeOfMast,int testDuration,
       double testDifficultyF,double testSucc,double testPointsN){
     smh.sendTestDataToStatPage(testDegreeOfMast,testDuration,testDifficultyF,testSucc, testPointsN);
   }
   //postavlja podatke koji se odnose na kurs koji se izucava
   //a zatim ih upisuje u bazu podataka
  public void setCourseData(){
    student.setCourseData();
    String cId=student.getCourseId();


    Date cStart=student.getCourseStarted();
    int numbOfPass=student.getCourseNumbOfPass();
    dWriter.writeCourseData(userID.intValue(),cStart,cStart, numbOfPass,cId);
  }

  private void jbInit() throws Exception {
  }
  //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int passedConceptId){
     String cId=student.getPassedConceptIdByOrdNum(passedConceptId);
     return cId;
   }
   public int getNumberOfQuestInTest(int i){
     int qNumb=student.getNumberOfQuestInTest(i);
     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
     double degreeT=student.getTestDegreeByOrdNum(i);
     return degreeT;
   }
   public int getNumberOfTests(){
    int numb=student.getNumberOfTests();
    return numb;
  }
  public Vector getCountries(){
    Vector countries=dReader.getCountries();
    return countries;
  }
  public Vector getCountriesIds(){
      Vector countryShortcut=dReader.getCountriesIds();
      return countryShortcut;
  }
  public Vector getLanguages(){
    Vector languages=dReader.getLanguages();
    return languages;
  }
  public Vector getLanguagesIds(){
      Vector languagesIds=dReader.getLanguagesIds();
      return languagesIds;
  }








}
