//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\Student.java

package depths.studentModule;
import java.util.*;
import java.text.SimpleDateFormat;
public class Student
{
  private String userName;
  private int userID;

  public Performance studPerformance;
  public TeachingHistory studTeachingHistory;
  private SessionManager sm;
  private SimpleDateFormat df = new SimpleDateFormat(
      "yyyy.MM.dd G 'at' HH:mm:ss z");
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String city;
  private int country;
  private String organization;
  private String webSite;
  private String language;

  public Student(SessionManager sessM) {
    sm = sessM;
    studPerformance = new Performance();
    studTeachingHistory = new TeachingHistory(this);
  }
  //preuzima vektor sa nazivima koncepata za chart dijagram
  public String[] getConceptsTitles(){
    String[] concepts=studTeachingHistory.getConceptsTitles();
    return concepts;
  }
  //preuzima vektor sa ocenama koncepata za chart dijagram
 public double[] getConceptsDegrees(){
   double[] degrees = studTeachingHistory.getConceptsDegrees();
   return degrees;
 }
 //preuzima vektor sa trenutnim znanjem u toku ucenja  koncepata za chart dijagram
 public double[] getActualKnowledgeLevel(){
   double[] actKnowlLevel = studTeachingHistory.getActualKnowledgeLevel();
   return actKnowlLevel;
 }

  public void setInitialPerformances(double inSkLev, int detLev,
                                     String programmLang) {
    studPerformance.setInitialSkillLevel(inSkLev);
    studPerformance.setDetailLevel(detLev);
    studPerformance.setProgrammingLanguage(programmLang);
    //dodati podatke u bazu podataka
  }

  public double getInitialSkillLevel() {
    double inSkL = studPerformance.getInitialSkillLevel();
    return inSkL;
  }

  public double getActualSkillLevel() {
    double asl = studPerformance.getActualSkillLevel();
    // actualSkillLevel=asl;
    return asl;
  }

  public String getProgrammLang() {
    String pl = studPerformance.getProgrammingLanguage();
    return pl;
  }

  public void setActualSkillLevel(double asl) {
    studPerformance.setActualSkillLevel(asl);
    // actualSkillLevel=asl;
  }

  public int getDetailLevel() {
    int dl = studPerformance.getDetailLevel();
    return dl;
  }

  public void setUserName(String s) {
    userName = s;
  }
  public String getReasoningAbility(){
    String reasAb=studPerformance.getReasoningLevel();
    return reasAb;
  }
  public String getExperienceLevel(){
    String experience=studPerformance.getExperienceLevel();
    return experience;
  }
  public String getLearningStyle(){
    String style=studPerformance.getLearningStyle();
    return style;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserID(int i) {
    userID = i;

  }

  public int getUserID() {

    return userID;
  }

  public void addConcept() {
    studTeachingHistory.addConcept();
  }

  public void testing() {
  }

  public void startNewConcept(String currConcId) {

    studTeachingHistory.startNewConcept(currConcId);

  }
  /*poziva se kada student ponavlja koncept koji je vec presao*/
  public void startRelearningConcept(String currConcId) {
    studTeachingHistory.startRelearningConcept(currConcId);
  }


  public void startFirstConcept(String currConcId) {
    studTeachingHistory.startFirstConcept(currConcId);
  }
  public void setNewUser(boolean val){
      studTeachingHistory.setNewUser(val);
  }

  /**Ubacuje naziv koncepta u model studenta*/
  public void setCurrConceptTitle(String title) {
    studTeachingHistory.setCurrConceptTitle(title);
  }

  public void finishNewConcept() {
    studTeachingHistory.finishNewConcept();
  }

  public void signalNewUser(boolean val) {
    studTeachingHistory.signalNewUser(val);
  }

  public Vector addPassedConceptsToInstrPlanner() {
    Vector passedConcepts = studTeachingHistory.addPassedConceptsToInstrPlanner();
    return passedConcepts;
  }
  //postavlja koncept kojem se unose lekcije za trenutni
  public void setParsingConcept(String cId){

    studTeachingHistory.setParsingConcept(cId);
  }
  public void addUnit(){
    studTeachingHistory.addUnit();

  }
  public void addTest(){
    studTeachingHistory.addTest();

  }


  public void addLearnedUnit(String luId, String unitTitle) {
    studTeachingHistory.addLearnedUnit(luId, unitTitle);

  }
  //azurira podatke o lekciji kada se ponovo predje
  public void updatePassedLessonInfo(String lUnitId){
    studTeachingHistory.updatePassedLessonInfo(lUnitId);
  }

  public void addUnitGeneralElement(String el, String val) {

    studTeachingHistory.addUnitGeneralElement(el,val);
  }


  public void setTestInSM(String qId, int gr) {
    studTeachingHistory.setTestInSM(qId, gr);
  }

  //Sledece funkcije sluze za parsiranje testa u model
  public void createNewTest() {
    studTeachingHistory.createNewTest();
  }


  public void addTestGeneralElem(String el, int val) {
    studTeachingHistory.addTestGeneralElem(el, val);
  }
  public void addTestGeneralElem(String el, double val) {
    studTeachingHistory.addTestGeneralElem(el, val);
  }
  public void addTestGeneralElem(String el, Date val) {
    studTeachingHistory.addTestGeneralElem(el, val);
  }



  public void createNewQuestion() {
    studTeachingHistory.createNewQuestion();
  }

  public void addQuestion() {
    studTeachingHistory.addQuestion();
  }

  public void addQuestionElem(String el, int val) {
    studTeachingHistory.addQuestionElem(el, val);
  }

  public void addQuestionElem(String el, String val) {
    studTeachingHistory.addQuestionElem(el, val);
  }

  public void addQuestionElem(String el, boolean val) {
    studTeachingHistory.addQuestionElem(el, val);
  }

  ///////////////////////////////////////////////
  public double getTestGeneralElement(String el) {
    double value = studTeachingHistory.getTestGeneralElement(el);
    return value;
  }

  public void setQuestToWrite(int ordN) {
    studTeachingHistory.setQuestToWrite(ordN);
  }

  public int getNumOfQuest() {
    int val = studTeachingHistory.getNumOfQuest();

    return val;
  }

  public int getQuestionElement(String el) {
    int val = studTeachingHistory.getQuestionElement(el);
    return val;
  }

  public String getQuestionID() {
    String val = studTeachingHistory.getQuestionID();
    return val;
  }

  public boolean getStudentAnswerTruth() {
    boolean val = studTeachingHistory.getStudentAnswerTruth();
    return val;
  }

  /**Salje signal u model studenta da kreira novu instancu testa*/
  public void startTestInSM() {
    studTeachingHistory.startTestInSM();
  }

  /**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
  public void addQuestionToSM(String qId, int qGroup, boolean qTruth) {
    studTeachingHistory.addQuestionToSM(qId, qGroup, qTruth);
  }

  /**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
  public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                                  double actSkillLev, double testSuccess, double testPointsNumber) {
    studTeachingHistory.setTestElementsInSM(testKnowledgeLevel,testDifficultyFactor, actSkillLev, testSuccess, testPointsNumber);
  }

  /**Salje zahtev modelu studenta da prosledi u Pedagoski modul ocene svih koncepata
   * koje je student ranije presao*/
public void setCourseId(String courseId){
      studTeachingHistory.setCourseID(courseId);

  }
  public void getAllConceptsMarks() {

    studTeachingHistory.getAllConceptsMarks();

  }

  /**Salje ocenu za odredjeno poglavlje u klasu GlobalAssessment,
   * radi dobijanja prosecne ocene*/
  public void sendConceptMarkInPedMod(double mark) {
    sm.sendConceptMarkInPedMod(mark);

  }

  /**Preuzima broj predjenih koncepata iz modela studenta*/
  public int getNumOfPassedConcepts() {
    int val = studTeachingHistory.getNumOfPassedConcepts();
    return val;

  }
  public String getPassedConceptTitleByOrdNum(int i){
    String cTitle=studTeachingHistory.getPassedConceptTitleByOrdNum(i);
    return cTitle;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    double degree=studTeachingHistory.getPassedConceptDegreeOfMastByOrdNum(i);
return degree;
  }



  /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
   * predjenih koncepata*/
  public void addPassedConceptFromSM(int index) {
    studTeachingHistory.addPassedConceptFromSM(index);

  }

  /**Salje podatke o predjenim konceptima u prezentacioni modul*/
  public void sendStatisticalData(String id, double degreeOfMast,
                                  double actualSkillLevel, int duration,
                                  String title) {

    sm.sendStatisticalData(id, degreeOfMast, actualSkillLevel, duration, title);

  }

  /**Salje podatke o upravo zavrsenom konceptu u model studenta*/
  public void sendConceptDataToSM(double currConceptDegree, double studSkillLevel) {
    studTeachingHistory.sendConceptDataToSM(currConceptDegree, studSkillLevel);
  }

  public void addConceptElement(String el, int val) {

    studTeachingHistory.addConceptElement(el, val);
  }
  public void addConceptElement(String el, double val) {

    studTeachingHistory.addConceptElement(el, val);
  }


  public void addConceptElement(String el, String val) {

    studTeachingHistory.addConceptElement(el, val);
  }
  public void addConceptElement(String el, Date val){

    studTeachingHistory.addConceptElement(el,val);
  }

  public void setTimeElement(String el, Date val) {

    studTeachingHistory.setTimeElement(el, val);
  }

  public String getTimeOfLastSession() {
    Date d = studPerformance.getTimeOfLastSession();
    String str = df.format(d);
    return str;

  }

  public String getConceptDateElement(String el) {

    Date d = studTeachingHistory.getConceptDateElement(el);

    String str = df.format(d);
    return str;
  }

  public void saveAllData() {
    //sm.saveStudentData();
  }

  /**Ucitava iz xml dokumenta vreme trajanja koncepta*/
  public void addConceptDuration(int durInSec) {
    studTeachingHistory.addConceptDuration(durInSec);
  }

  /**Ucitava iz xml dokumenta vreme trajanja koncepta*/
  public void addTestDuration(int durInSec) {
    studTeachingHistory.addTestDuration(durInSec);
  }

  /**Preuzima vreme trajanja koncepta radi upisivanja u xml dokument*/
  public int getConceptDuration() {
    int dur = studTeachingHistory.getConceptDuration();
    return dur;

  }

  /**Preuzima vreme trajanja testa radi upisivanja u xml file*/
  public int getTestDuration() {
    int dur = studTeachingHistory.getTestDuration();
    return dur;
  }

  /**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
   * statisticke podatke u lessonStatisticPage*/
  public void getConceptById(String concId) {
    studTeachingHistory.getConceptById(concId);

  }

  /**Salje podatke o broju lekcija i testova u datom konceptu
   * u lessonStatisticPage*/
  public void sendNumbersOfToStatisticPage(int numOfLessons, int numOfTests) {
    sm.sendNumbersOfToStatisticPage(numOfLessons, numOfTests);
  }

  /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
  public String getLessonTitle(int lessOrdNum) {
    String lTitle = studTeachingHistory.getLessonTitle(lessOrdNum);
    return lTitle;
  }
  public int getLessonNumberOfPassess(int lessOrdNum){
   int numOfPass=studTeachingHistory.getLessonNumberOfPassess(lessOrdNum);
   return numOfPass;
 }


  /**Postavlja test koji ce se citati za statistic page*/
  public void setStatisticTest(int testOrdNum) {
    studTeachingHistory.setStatisticTest(testOrdNum);
  }

  /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum) {
    String qId = studTeachingHistory.getQuestionDataFromSM(qOrdNum);
    return qId;

  }

  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
  public void sendQuestionTruth(boolean qTruth) {
    sm.sendQuestionTruth(qTruth);
  }

  /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
   * page*/
  public int getNumberOfQuestions() {
    int numbOfQuests = studTeachingHistory.getNumberOfQuestions();
    return numbOfQuests;
  }

  /**Salje podatke o izabranom testu  u statistic page*/
  public void sendTestDataToStatPage(double testDegreeOfMast, int testDuration,
      double testDifficultyF,double testSucc,double  testPointsN) {
    sm.sendTestDataToStatPage(testDegreeOfMast, testDuration, testDifficultyF,testSucc, testPointsN);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getCountry() {
    return country;
  }

  public void setCountry(int country) {
    this.country = country;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

//upisuje osnovne podatke o korisniku prilikom registracije
  public void writeStudentData(Integer studID, String fName, String lName,
                               String uName, String email,
                               String addr,
                               String city, int country, String organization,
                               String webSite, String language) {
    this.setUserID(studID.intValue());
    this.setFirstName(fName);
    this.setLastName(lName);
    this.setUserName(uName);
    this.setEmail(email);
    this.setAddress(addr);
    this.setCity(city);
    this.setCountry(country);
    this.setOrganization(organization);
    this.setWebSite(webSite);
    this.setLanguage(language);

  }
  //postavlja podatke koji se odnose na kurs koji se izucava
  public void setCourseData(){
    studTeachingHistory.setCourseData();
  }
  public String getCourseId(){
    String cId = studTeachingHistory.getCourseID();
    return cId;
  }
  public Date getCourseStarted(){
    Date cStart = studTeachingHistory.getStarted();
    return cStart;
  }
  public int getCourseNumbOfPass(){

    int numbOfPass=studTeachingHistory.getNumberOfPasses();
    return numbOfPass;
  }
  //upisuje u bazu podataka podatke o upravo predjenom konceptu
  public void writeConceptData(String courseId,String cId,int duration,String feedbackMess,
                               Date started,Date finished,int numbOfPass,
                              double degreeOfMast,double knowlLevel,String experienceLev,String reasonAbility){
    sm.writeConceptData(courseId,this.userID,cId,duration,feedbackMess,started,finished,numbOfPass,
                        degreeOfMast, knowlLevel, experienceLev, reasonAbility);

  }
  //azurira u bazi podataka podatke o ponovo predjenom konceptu
  public void updateConceptData(String courseId,String cId,int duration,String feedbackMess,
                               Date started,Date finished,int numbOfPass,
                              double degreeOfMast,double knowlLevel,String experienceLev,String reasonAbility){
    sm.updateConceptData(courseId,this.userID,cId,duration,feedbackMess,started,finished,numbOfPass,
                        degreeOfMast, knowlLevel, experienceLev, reasonAbility);

  }

  //upisuje u bazu podataka podatke o lekciji
  public void writeUnitsData(String cId,String unitId,Date started,Date finished,int numbOfPasses){

    sm.writeUnitsData(this.userID,cId,unitId,started,finished,numbOfPasses);

  }
  //upisuje u bazu podataka podatke o testu
   public void writeTestData(String cId,int testId,Date started,Date finished,
                            int numbOfPasses,double degreeOfMast,double knowledgeLev,int duration,
      double testDifficultyFactor, double success, double testPointsNumber){

     sm.writeTestData(this.userID,cId,testId, started, finished, numbOfPasses, degreeOfMast, knowledgeLev, duration,
          testDifficultyFactor, success, testPointsNumber);
   }
   //upisuje podatke o pitanju u bazu podataka
public void writeQuestionData(String cId,int testId,String qId,boolean truth){

  sm.writeQuestionData(this.userID,cId,testId,qId,truth);
}
public void setPerformances(int initSkLev,int actSkLev,String learningStyle,String timeOfLastSess,
                             int detLev, String expLev,String reasAbil, String programmLang){
   Date date=new Date();
   try{
     date = df.parse(timeOfLastSess);
   }catch(Exception e){}
      studPerformance.setInitialSkillLevel(initSkLev);
      studPerformance.setActualSkillLevel(actSkLev);
      studPerformance.setLearningStyle(learningStyle);
      studPerformance.setTimeOfLastSession(date);
      studPerformance.setDetailLevel(detLev);
      studPerformance.setExperienceLevel(expLev);
      studPerformance.setReasoningLevel(reasAbil);
      studPerformance.setProgrammingLanguage(programmLang);


    }
    //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int passedConceptId){

     String cId=studTeachingHistory.getPassedConceptIdByOrdNum(passedConceptId);

     return cId;
   }
   public int getNumberOfQuestInTest(int i){
     int qNumb=studTeachingHistory.getNumberOfQuestInTest(i);
     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
     double degreeT=studTeachingHistory.getTestDegreeByOrdNum(i);
     return degreeT;
   }
   public int getNumberOfTests(){
    int numb=studTeachingHistory.getNumberOfTests();
    return numb;
  }










}
