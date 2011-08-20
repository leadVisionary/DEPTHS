//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\ConceptHistory.java

package depths.studentModule;

import java.util.Vector;
import java.util.Date;
import java.util.Calendar;

public class ConceptHistory extends CommonHistory
{

   private double degreeOfMastery;
   private double knowledgeLevel;
   private String experienceLevel;
   private String reasoningAbilityLevel;
   private String feedbackMessages;

   private Vector units=new Vector();
   private Vector tests=new Vector();
   private UnitHistory currentUnit;
   private TestHistory cParsTest;
   private TestHistory statTest;//test koji se iscitava za statistic page
   private TestHistory cAddingTest;//test koji se upravo resava
   public UnitHistory nUnit;
   private TeachingHistory tHistory;

   public TestHistory nTest=new TestHistory(this);
   public ConceptHistory(TeachingHistory th)
   {
     tHistory=th;

   }

   public void setDegreeOfMastery(double dm)
   {

     degreeOfMastery=dm;
   }

   public double getDegreeOfMastery()
   {

    return degreeOfMastery;
   }

   public void setExperienceLevel(String el)
   {
     experienceLevel=el;
   }

   public String getExperienceLevel()
   {
    return experienceLevel;
   }

   public void setReasoningAbilityLevel(String ral)
   {
     reasoningAbilityLevel=ral;
   }

   public String getReasoningAbilityLevel()
   {
    return reasoningAbilityLevel;
   }

   public void setKnowledgeLevel(double kl)
   {

     knowledgeLevel=kl;
   }
   public double getKnowledgeLevel()
   {

     return knowledgeLevel;
   }
   public void setFeedbackMessage(String fbm)
   {
     feedbackMessages=fbm;
   }
   public String getFeedbackMessage()
   {
    return feedbackMessages;
   }
   public void addConceptElem(String elem,int val)
   {
     String element = elem;
     int value = val;
     if (element.equals("numberOfPasses")){

       this.setNumberOfPasses(value);
     }

   }
   public void addConceptElem(String elem,double val)
   {

     String element = elem;
     double value = val;
     if (element.equals("degreeOfMastery")) {
       setDegreeOfMastery(value);
     }
     else if (element.equals("knowledgeLevel")) {
       setKnowledgeLevel(value);
     }

   }


   public void addConceptElem(String elem,String val)
   {
     String element=elem;
     String value=val;
     if (element.equals("experienceLevel"))
     {
       setExperienceLevel(value);
     }else if (element.equals("reasoningAbilityLevel"))
     {
       setReasoningAbilityLevel(value);
     }else if (element.equals("feedbackMessage")){
       this.setFeedbackMessage(val);
     }else if (element.equals("title")){
       this.setTitle(val);
     }else if (element.equals("reference")){
       this.setReference(val);
     }

   }
   public void addConceptElem(String el, Date val) {
     String element=el;
     java.util.Date value=val;
     if (element.equals("started"))
     {
       this.setStarted(value);
     }else if (element.equals("finished"))
     {
       this.setFinished(value);
     }

 }

   public void addUnit(){
     UnitHistory unitH=new UnitHistory();

     currentUnit=unitH;
     units.addElement(currentUnit);

   }
   //azurira podatke o lekciji kada se ponovo predje
  public void updatePassedLessonInfo(String lUnitId){
    //updatePassedLessonInfo(lUnitId);
    for(int i=0;i<units.size();i++){
       UnitHistory uh=(UnitHistory) units.get(i);
       if (uh.getID().equals(lUnitId)){

         uh.setNumberOfPasses(uh.getNumberOfPasses()+1);
         uh.setStarted(new Date());
         uh.setFinished(new Date());

       }

       }

  }

   /**Poziva se kada student predje trazeni Unit*/
   public void addLearnedUnit(String uId,String unitTitle)
   {boolean existingLesson=false;
     for(int i=0;i<units.size();i++){
       UnitHistory uh=(UnitHistory) units.get(i);
       if (uh.getID().equals(uId)){

         uh.setNumberOfPasses(uh.getNumberOfPasses()+1);
         uh.setStarted(new Date());
         uh.setFinished(new Date());
         existingLesson=true;

       }
     }
     if (existingLesson==false){

       UnitHistory unitH = new UnitHistory(uId);
       unitH.setStarted(new Date());
       unitH.setFinished(new Date());
       unitH.setNumberOfPasses(1);
       unitH.setTitle(unitTitle);
       unitH.setReference("nn");
       unitH.addGeneralElement("degreeOfMastery", "default");
       unitH.addGeneralElement("knowledgeLevel", "default");

       currentUnit = unitH;
       units.addElement(unitH);
     }

   }
   public void addUnitOrdinalNumber(int uOrdNum){
     currentUnit.setOrdinalNumber(uOrdNum);
   }

   public int getUnitOrdinalNumber(){
     int on= currentUnit.getOrdinalNumber();
     return on;
   }
   //Sledece funkcije sluze za parsiranje testa u model
   public void createNewTest(){
     cParsTest=new TestHistory(this);
   }
   /**Ucitava iz xml dokumenta vreme trajanja koncepta*/

    public void addTestDuration(int durInSec){
      cParsTest.setDuration(durInSec);
    }

   public void addTest(){
     this.createNewTest();
     tests.addElement(cParsTest);
   }
   public void addTestGeneralElem(String el,int val){

     cParsTest.addTestGeneralElem(el,val);
   }
   public void addTestGeneralElem(String el,double val){

     cParsTest.addTestGeneralElem(el,val);
   }
   public void addTestGeneralElem(String el,Date val){

     cParsTest.addTestGeneralElem(el,val);
   }


   public void createNewQuestion(){
     cParsTest.createNewQuestion();
   }
   public void addQuestion(){
     cParsTest.addQuestion();
   }
   public void addQuestionElem(String el,int val){
     cParsTest.addQuestElem(el,val);
   }
   public void addQuestionElem(String el,String val){
    cParsTest.addQuestElem(el,val);
  }

   public void addQuestionElem(String el,boolean val){
    cParsTest.addQuestElem(el,val);
  }
  ///////////////////////////////////////////////
   public void addUnitGeneralElem(String el,String val)
   {
     currentUnit.addGeneralElement(el,val);
   }
   public int getNumberOfUnits()
  {

    return units.size();
  }
  public int getNumberOfTests()
  {
    return tests.size();
  }
  public void setNUnit(int ind)
   {
     nUnit=(UnitHistory) units.get(ind);
   }
   public void setNTest(int ind)
      {
        nTest=(TestHistory) tests.get(ind);
      }
      public double getTestGeneralElement(String el){
        double value=0.0;
        if (el.equals("degreeOfMastery")){
          value=nTest.getDegreeOfMastery();
        }else if (el.equals("knowledgeLevel")){
          value=nTest.getKnowledgeLevel();
        }
        return value;
      }
      /**Preuzima vreme trajanja testa radi upisivanja u xml file*/
     public int getTestDuration(){
       int dur = nTest.getDuration();
       return dur;
     }

      public void setTestInSM(String qId,int gr){
        if (qId.equals("0")){
        }else{
          TestHistory testS = new TestHistory(this);
          testS.setID(qId);
          testS.setDegreeOfMastery(0);
          testS.setKnowledgeLevel(0);
          testS.setStarted(new Date());
          testS.setFinished(new Date());
          testS.setNumberOfPasses(1);
          testS.setReference("reference");
          testS.setTitle("default");
          tests.addElement(testS);
        }

      }
      /**Ubacuje naziv koncepta u model studenta*/
 public void setCurrConceptTitle(String title){
   this.setTitle(title);

 }
 public void setQuestToWrite(int ordN){
   nTest.setQuestToWrite(ordN);
 }
 public int getNumOfQuest(){
   int val=nTest.getNumOfQuestions();
   return val;
 }
 public int getQuestionElement(String el){
   int val=nTest.getQuestionElement(el);
   return val;
 }
 public String getQuestionID(){
   String val=nTest.getQuestionID();
   return val;
 }

 public boolean getStudentAnswerTruth(){
      boolean val=nTest.getStudentAnswerTruth();
      return val;
   }
   /**Salje signal u model studenta da kreira novu instancu testa*/
public void startTestInSM(){
cAddingTest=new TestHistory(this);
cAddingTest.setStarted(new Date());
      int x=tests.size();
      int testId=x+1;

cAddingTest.setTestID(testId);
      cAddingTest.setNumberOfPasses(1);
}
/**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
public void addQuestionToSM(String qId,int qGroup,boolean qTruth){
cAddingTest.addQuestionToSM(qId,qGroup,qTruth);
}
/**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                                    double actSkillLev, double testSuccess, double testPointsNumber){

cAddingTest.setDegreeOfMastery(testKnowledgeLevel);
  cAddingTest.setKnowledgeLevel(actSkillLev);
  cAddingTest.setFinished(new Date());

  cAddingTest.setDurationTime();
  cAddingTest.setTestDifficultyFactor(testDifficultyFactor);
  cAddingTest.setSuccess(testSuccess);
  cAddingTest.setTestPointsNumber(testPointsNumber);
tests.addElement(cAddingTest);
}

/**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){
   UnitHistory un=(UnitHistory) units.get(lessOrdNum);
   String lTitle=un.getTitle();
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
   UnitHistory un=(UnitHistory) units.get(lessOrdNum);

  int numOfPass=un.getNumberOfPasses();
  return numOfPass;
}

 /**Postavlja test koji ce se citati za statistic page*/
 public void setStatisticTest(int testOrdNum){

   statTest=(TestHistory) tests.get(testOrdNum);
   double testDegreeOfMast=statTest.getDegreeOfMastery();
   double testDifficultyF=statTest.getTestDifficultyFactor();
   double testSucc=statTest.getSuccess();
   double testPointsN=statTest.getTestPointsNumber();
   int testDuration=statTest.getDuration();

   tHistory.sendTestDataToStatPage(testDegreeOfMast,testDuration, testDifficultyF,testSucc, testPointsN );


 }
 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    String qId=statTest.getQuestionDataFromSM(qOrdNum);
    return qId;

  }

  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
  public void sendQuestionTruth(boolean qTruth){
    tHistory.sendQuestionTruth(qTruth);
  }
  /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
  * page*/
public int getNumberOfQuestions(){
  int numbOfQuests=statTest.getNumberOfQuestions();
  return numbOfQuests;
}
//upisuje podatke o lekcijama iz koncepta koji je upravo predjen u bazu podataka
public void saveUnitsData(){


  String unitId;
  int numbOfPasses;
  Date started, finished;

  int numbUnits=this.getNumberOfUnits();
  for (int i=0;i<numbUnits;i++){
    nUnit=(UnitHistory) units.get(i);
    unitId=nUnit.getID();
    numbOfPasses=nUnit.getNumberOfPasses();
    started=nUnit.getStarted();
    finished=nUnit.getFinished();



      tHistory.writeUnitsData(unitId, started, finished, numbOfPasses);

  }
}
//upisuje podatke o testovima iz koncepta koji je upravo predjen u bazu podataka
public void saveTestData(){
  int numbOfTests,numbOfPasses,   duration;

  double degreeOfMast, knowledgeLev, testDifficultyFactor, success,  testPointsNumber;
  int testId;
  Date started, finished;
  numbOfTests=this.getNumberOfTests();
  for (int i=0;i<numbOfTests;i++){
    nTest = (TestHistory) tests.get(i);
    testId=nTest.getTestID();
    started=nTest.getStarted();
    finished=nTest.getFinished();
    numbOfPasses=nTest.getNumberOfPasses();
    degreeOfMast=nTest.getDegreeOfMastery();
    knowledgeLev=nTest.getKnowledgeLevel();
    duration=nTest.getDuration();
    testDifficultyFactor=nTest.getTestDifficultyFactor();
        success=nTest.getSuccess();
        testPointsNumber=nTest.getTestPointsNumber();

    tHistory.writeTestData(testId, started, finished, numbOfPasses, degreeOfMast, knowledgeLev, duration,
        testDifficultyFactor, success,  testPointsNumber);
    nTest.saveQuestionData();

  }
}
//upisuje podatke o pitanju u bazu podataka
public void writeQuestionData(String qId,boolean truth){
  int testId=nTest.getTestID();
  tHistory.writeQuestionData(testId,qId,truth);
}
public int getNumberOfQuestInTest(int i){
  TestHistory th=(TestHistory) tests.get(i);
  int qNumb=th.getNumberOfQuestions();

     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
      TestHistory th=(TestHistory) tests.get(i);
     double degreeT=th.getDegreeOfMastery();
     return degreeT;
   }






}
