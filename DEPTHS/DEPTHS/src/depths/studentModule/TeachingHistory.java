//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\TeachingHistory.java

package depths.studentModule;

import java.util.Vector;
import java.util.Date;

public class TeachingHistory
{
  private Date started;
  private Date finished;
  private int numberOfPasses;
  public CommonHistory theCommonHistory;
  private Vector concepts = new Vector();
  public ConceptHistory cParsConcept;
  public ConceptHistory nConcept = new ConceptHistory(this);
  public ConceptHistory statConc=new ConceptHistory(this);//koristi se za lessonsStatisticPage
  private ConceptHistory cHistory;
  private ConceptHistory startConcept;
  private boolean firstConc = false;
  private boolean newUser = false;
  private Vector passedConcepts;
  private Student student;
  private String courseID;
  private String courseTitle;
  private boolean relearningConcept=false;

  public TeachingHistory(Student st) {
    student = st;

  }
  //preuzima vektor sa nazivima koncepata za chart dijagram
  public String[] getConceptsTitles(){
    String[] concs=new String[concepts.size()];

    for (int i=0;i<concepts.size();i++){

      ConceptHistory ch=(ConceptHistory)concepts.get(i);

      String s=ch.getTitle();

      concs[i]=s;

    }
    return concs;

  }
  //preuzima vektor sa ocenama koncepata za chart dijagram
  public double[] getConceptsDegrees(){
    double[] degrees=new double[concepts.size()];
    for (int i=0;i<concepts.size();i++){

      ConceptHistory ch=(ConceptHistory) concepts.get(i);

      degrees[i]=ch.getDegreeOfMastery();

    }
    return degrees;

  }
  //preuzima vektor sa trenutnim znanjem u toku ucenja  koncepata za chart dijagram
  public double[] getActualKnowledgeLevel(){
    double[] actKnowlLevel=new double[concepts.size()];
    for (int i=0;i<concepts.size();i++){
      ConceptHistory ch=(ConceptHistory) concepts.get(i);
      actKnowlLevel[i]=ch.getKnowledgeLevel();
    }
    return actKnowlLevel;

  }



  /**poziva se iz pedagoskog modula kada student zapocne novi koncept*/
  public void startNewConcept(String currConcId) {

this.relearningConcept=false;
    startConcept = new ConceptHistory(this);
    startConcept.setID(currConcId);
    startConcept.setStarted(new Date());

    //podesi default vrednosti - kasnije izbaciti//

    startConcept.setReference("ref");
    startConcept.setDegreeOfMastery(1);
    startConcept.setKnowledgeLevel(1);
    startConcept.setExperienceLevel("el");
    startConcept.setReasoningAbilityLevel("ral");
  }
  /*poziva se kada student ponavlja koncept koji je vec presao*/
  public void startRelearningConcept(String currConcId) {

    this.relearningConcept=true;
    for (int i=0;i<concepts.size();i++){
      ConceptHistory ch = (ConceptHistory) concepts.get(i);
      if (ch.getID().equals(currConcId)){
        startConcept=ch;
        //startConcept.setNumberOfPasses(startConcept.getNumberOfPasses()+1);
      }
      startConcept.setStarted(new Date());
    }


  }


  /**Ubacuje naziv koncepta u model studenta*/
  public void setCurrConceptTitle(String title) {

    startConcept.setCurrConceptTitle(title);
  }

  public void startFirstConcept(String currConcId) {

    startNewConcept(currConcId);

    if (newUser) {
      firstConc = true;
    }
    else {
      firstConc = false;
    }

  }
  public void setNewUser(boolean val){
      newUser=val;
  }

  /**Salje signal u model studenta da kreira novu instancu testa*/
  public void startTestInSM() {

    startConcept.startTestInSM();
  }

  /**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
  public void addQuestionToSM(String qId, int qGroup, boolean qTruth) {

    startConcept.addQuestionToSM(qId, qGroup, qTruth);

  }

  /**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
  public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                                  double actSkillLev, double testSuccess, double testPointsNumber) {

    startConcept.setTestElementsInSM(testKnowledgeLevel,testDifficultyFactor, actSkillLev, testSuccess, testPointsNumber);

  }

  public void signalNewUser(boolean val) {
    newUser = true;
    this.firstConc=true;
  }

  /**Dodaje predjene koncepte u Instructional Planner i Jess memoriju*/
  public Vector addPassedConceptsToInstrPlanner() {

    passedConcepts = new Vector();
    int size = concepts.size();

    for (int i = 0; i < size; i++) {

      ConceptHistory ch = (ConceptHistory) concepts.get(i);
      String cId = ch.getID();

      passedConcepts.add(i, cId);

    }
    return passedConcepts;
  }

  //postavlja koncept kojem se unose lekcije za trenutni
  public void setParsingConcept(String cId){
    ConceptHistory c=new ConceptHistory(this);
      for (int i=0;i<concepts.size();i++){
      c=(ConceptHistory) concepts.get(i);
      if (c.getID().equals(cId)){
        cParsConcept=c;
      }
    }
  }


  /** Treba da signalizira da je trenutni koncept zavrsen i da moze da se
   * smesti u vektor koncepata*/
  public void finishNewConcept() {
    if (firstConc) {

      concepts.removeAllElements();
      startConcept.setFinished(new Date());
      concepts.add(0, startConcept);
      firstConc = false;
    }
    else if (this.relearningConcept==false){
      startConcept.setFinished(new Date());
      concepts.add(startConcept);
    }else{
      startConcept.setFinished(new Date());
    }
    startConcept.setDurationTime();
    //student.saveAllData();
    this.saveConceptData();
  }
  //upisuje u bazu podataka podatke o upravo predjenom konceptu
  public void saveConceptData(){

    String cId,feedbackMess, experienceLev, reasonAbility;
    int duration, numbOfPass;
    double degreeOfMast, knowlLevel;
    Date started, finished;

    cId=startConcept.getID();
    duration=startConcept.getDuration();
    feedbackMess=startConcept.getFeedbackMessage();
    started=startConcept.getStarted();
    finished=startConcept.getFinished();
    numbOfPass=startConcept.getNumberOfPasses();
    degreeOfMast=startConcept.getDegreeOfMastery();
    knowlLevel=startConcept.getKnowledgeLevel();
    experienceLev=startConcept.getExperienceLevel();
    reasonAbility=startConcept.getReasoningAbilityLevel();

    if (this.relearningConcept==false){
      student.writeConceptData(this.courseID,cId, duration, feedbackMess, started, finished,
                               numbOfPass, degreeOfMast, knowlLevel,
                               experienceLev, reasonAbility);

      startConcept.saveUnitsData();

      startConcept.saveTestData();

    }else{

      student.updateConceptData(this.courseID,cId, duration, feedbackMess, started, finished,
                               numbOfPass, degreeOfMast, knowlLevel,
                               experienceLev, reasonAbility);
     startConcept.saveUnitsData();
    startConcept.saveTestData();

    }
  }
  //upisuje u bazu podataka podatke o lekciji
  public void writeUnitsData(String unitId,Date started,Date finished,int numbOfPasses){

    String cId=startConcept.getID();
    student.writeUnitsData(cId,unitId,started,finished,numbOfPasses);

  }

   //upisuje u bazu podataka podatke o testu
   public void writeTestData(int testId,Date started,Date finished,
                            int numbOfPasses,double degreeOfMast,double knowledgeLev,int duration,
      double testDifficultyFactor, double success, double testPointsNumber){
     String cId=startConcept.getID();
     student.writeTestData(cId,testId, started, finished, numbOfPasses, degreeOfMast, knowledgeLev, duration,
          testDifficultyFactor,  success, testPointsNumber);

   }
   //upisuje podatke o pitanju u bazu podataka
public void writeQuestionData(int testId,String qId,boolean truth){
  String cId=startConcept.getID();
  student.writeQuestionData(cId,testId,qId,truth);
}


  public void setStarted(Date st) {
    started = st;
  }

  public Date getStarted() {
    return started;
  }

  public void setFinished(Date fn) {
    finished = fn;
  }

  public Date getFinished() {
    return finished;
  }

  public void setNumberOfPasses(int np) {
    numberOfPasses = np;
  }

  public int getNumberOfPasses() {
    return numberOfPasses;
  }

  public void addConcept() {
    cHistory = new ConceptHistory(this);
    cParsConcept = cHistory;
    concepts.addElement(cParsConcept);
  }

  public void addConceptElement(String el, String val) {
    cParsConcept.addConceptElem(el, val);
  }

  public void addConceptElement(String el, int val) {
    cParsConcept.addConceptElem(el, val);
  }
  public void addConceptElement(String el, double val) {
    cParsConcept.addConceptElem(el, val);
  }

  public void addConceptElement(String el, Date val) {
   cParsConcept.addConceptElem(el, val);
 }


  public void setTimeElement(String el, Date val) {
    cParsConcept.setTimeElement(el, val);
  }

  public void addConceptGeneralElement(String el, String val) {
    cParsConcept.addGeneralElement(el, val);
  }

  /**Dodaje upravo predjeni Unit*/
  public void addLearnedUnit(String luId, String unitTitle) {

    startConcept.addLearnedUnit(luId, unitTitle);

  }
  //azurira podatke o lekciji kada se ponovo predje
  public void updatePassedLessonInfo(String lUnitId){
    startConcept.updatePassedLessonInfo(lUnitId);
  }


  public void addUnit() {
    cParsConcept.addUnit();

  }

  public void addUnitGeneralElement(String el, String val) {

    cParsConcept.addUnitGeneralElem(el, val);
  }

  public void addUnitOrdinalNumber(int uON) {
    cParsConcept.addUnitOrdinalNumber(uON);
  }

  //Sledece funkcije sluze za parsiranje testa u model
  public void createNewTest() {
    cParsConcept.createNewTest();
  }

  public void addTest() {
    cParsConcept.addTest();
  }

  public void addTestGeneralElem(String el, int val) {
    cParsConcept.addTestGeneralElem(el, val);
  }
  public void addTestGeneralElem(String el, double val) {
    cParsConcept.addTestGeneralElem(el, val);
  }
  public void addTestGeneralElem(String el, Date val) {
    cParsConcept.addTestGeneralElem(el, val);
  }



  public void createNewQuestion() {
    cParsConcept.createNewQuestion();
  }

  public void addQuestion() {
    cParsConcept.addQuestion();
  }

  public void addQuestionElem(String el, int val) {
    cParsConcept.addQuestionElem(el, val);
  }
  public void addQuestionElem(String el, String val) {
    cParsConcept.addQuestionElem(el, val);
  }


  public void addQuestionElem(String el, boolean val) {
    cParsConcept.addQuestionElem(el, val);
  }

  ///////////////////////////////////////////////

  public void setNConcept(int ind) {
    nConcept = (ConceptHistory) concepts.get(ind);
  }

  public double getTestGeneralElement(String el) {
    double value = nConcept.getTestGeneralElement(el);
    return value;
  }

  public int getNumberOfConcepts() {
    return concepts.size();
  }

  public void setTestInSM(String qId, int gr) {
    startConcept.setTestInSM(qId, gr);
  }

  public void setQuestToWrite(int ordN) {
    nConcept.setQuestToWrite(ordN);
  }

  public int getNumOfQuest() {
    int val = nConcept.getNumOfQuest();
    return val;
  }

  public int getQuestionElement(String el) {
    int val = nConcept.getQuestionElement(el);
    return val;
  }
  public String getQuestionID() {
    String val = nConcept.getQuestionID();
    return val;
  }

  public boolean getStudentAnswerTruth() {
    boolean val = nConcept.getStudentAnswerTruth();
    return val;
  }

  /**Salje zahtev modelu studenta da prosledi u Pedagoski modul ocene svih koncepata
   * koje je student ranije presao*/
  public void getAllConceptsMarks() {

    int numOfConc = concepts.size();


    for (int i = 0; i < numOfConc ; i++) {

      ConceptHistory ch = (ConceptHistory) concepts.get(i);

      double mark = ch.getDegreeOfMastery();

      student.sendConceptMarkInPedMod(mark);
    }

  }

  /**Preuzima broj predjenih koncepata iz modela studenta*/
  public int getNumOfPassedConcepts() {
    if (!concepts.isEmpty()){
      ConceptHistory lc = (ConceptHistory) concepts.lastElement();
      int val = 0;
      if (lc.getID().equals("0")) {
        val = 0;
      }
      else {
        val = concepts.size();
      }
      return val;
    }else{
      return 0;
    }
  }

  /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
   * predjenih koncepata*/
  public void addPassedConceptFromSM(int index) {

    ConceptHistory cc = (ConceptHistory) concepts.get(index);
    String id = cc.getID();
    double degreeOfMast = cc.getDegreeOfMastery();
    double actualSkLevel=cc.getKnowledgeLevel();
    int concDuration=cc.getDuration();
    String title = cc.getTitle();
    student.sendStatisticalData(id, degreeOfMast,actualSkLevel,concDuration, title);
  }

  /**Salje podatke o upravo zavrsenom konceptu u model studenta*/
  public void sendConceptDataToSM(double currConceptDegree, double studSkillLevel) {
    startConcept.setDegreeOfMastery(currConceptDegree);
    startConcept.setKnowledgeLevel(studSkillLevel);
    int n=startConcept.getNumberOfPasses();

    startConcept.setNumberOfPasses(n+1);
  }

  public Date getConceptDateElement(String el) {
    Date d=new Date();
    if (el.equals("started")) {
      d = nConcept.getStarted();
    }
    else if (el.equals("finished")) {
      d = nConcept.getFinished();
    }
    return d;
  }
  /**Ucitava iz xml dokumenta vreme trajanja koncepta*/
    public void addConceptDuration(int durInSec){
      cParsConcept.setDuration(durInSec);
    }
    /**Ucitava iz xml dokumenta vreme trajanja koncepta*/

    public void addTestDuration(int durInSec){
      cParsConcept.addTestDuration(durInSec);
    }

    /**Preuzima vreme trajanja koncepta radi upisivanja u xml dokument*/
    public int getConceptDuration(){
      int dur=nConcept.getDuration();
      return dur;

    }
    /**Preuzima vreme trajanja testa radi upisivanja u xml file*/
     public int getTestDuration(){
       int dur = nConcept.getTestDuration();
       return dur;
     }

    /**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
  * statisticke podatke u lessonStatisticPage*/
 public void getConceptById(String concId){
   int numOfConcepts=concepts.size();
   for (int i=0;i<numOfConcepts;i++){
     ConceptHistory sConcept=(ConceptHistory)concepts.get(i);
     if (sConcept.getID().equals(concId)){
       statConc=sConcept;
     }
   }
   double degreeOfMast=statConc.getDegreeOfMastery();
   double knowledgeLevel=statConc.getKnowledgeLevel();
   int duration=statConc.getDuration();
   String title=statConc.getTitle();

   student.sendStatisticalData(concId,degreeOfMast,knowledgeLevel,duration,title);
   int numOfLessons=statConc.getNumberOfUnits();
   int numOfTests=statConc.getNumberOfTests();
   student.sendNumbersOfToStatisticPage(numOfLessons,numOfTests);
 }
 /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){

   String lTitle=statConc.getLessonTitle(lessOrdNum);
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
  int numOfPass=statConc.getLessonNumberOfPassess(lessOrdNum);
  return numOfPass;
}

 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    String qId=statConc.getQuestionDataFromSM(qOrdNum);
    return qId;

  }
  /**Postavlja test koji ce se citati za statistic page*/
public void setStatisticTest(int testOrdNum){
  statConc.setStatisticTest(testOrdNum);
}

  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
  public void sendQuestionTruth(boolean qTruth){
    student.sendQuestionTruth(qTruth);
  }
  /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
    * page*/
  public int getNumberOfQuestions(){
    int numbOfQuests=statConc.getNumberOfQuestions();
    return numbOfQuests;
  }
  /**Salje podatke o izabranom testu  u statistic page*/
  public void sendTestDataToStatPage(double testDegreeOfMast,int testDuration,
      double testDifficultyF,double testSucc,double testPointsN){
    student.sendTestDataToStatPage(testDegreeOfMast,testDuration,testDifficultyF,testSucc, testPointsN);
  }
  public void setCourseID(String courseId){
    this.courseID=courseId;
  }
  public String getCourseID(){
    return this.courseID;
  }
  public void setCourseTitle(String courseTitle){
    this.courseTitle=courseTitle;
  }
  public String getCourseTitle(){
    return this.courseTitle;
  }
  //postavlja podatke koji se odnose na kurs koji se izucava
  public void setCourseData(){
    this.setCourseID("DP001");
    this.setCourseTitle("Design Patterns");
    Date d=new Date();
    this.setStarted(d);
    this.setNumberOfPasses(1);
  }
  //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int ordNum){
     ConceptHistory ch=(ConceptHistory) concepts.get(ordNum);
     String cid=ch.getID();

     return cid;
   }
   public String getPassedConceptTitleByOrdNum(int i){

    ConceptHistory ch=(ConceptHistory) concepts.get(i);
     String cTitle=ch.getTitle();

    return cTitle;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    ConceptHistory ch=(ConceptHistory) concepts.get(i);
    double degree=ch.getDegreeOfMastery();
    return degree;

  }
  public int getNumberOfQuestInTest(int i){
     int qNumb=startConcept.getNumberOfQuestInTest(i);
     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
     double degreeT=startConcept.getTestDegreeByOrdNum(i);
     return degreeT;
   }
   public int getNumberOfTests(){
    int numb=startConcept.getNumberOfTests();
    return numb;
  }







}


