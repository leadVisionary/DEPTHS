package depths.coordinator;

import depths.studentModule.SessionManager;
import java.util.*;

/**
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * @author zoki
 */
public class StudentModelHandler {
  public StudentModelHandler(Tutor t) {
    tutor = t;
    sm = new SessionManager(this);

  }
  //preuzima vektor sa nazivima koncepata za chart dijagram
 public String[] getConceptsTitles(){
   String[] concepts=sm.getConceptsTitles();
   return concepts;
 }
 //preuzima vektor sa ocenama koncepata za chart dijagram
public double[] getConceptsDegrees(){
  double[] degrees = sm.getConceptsDegrees();
  return degrees;
}
//preuzima vektor sa trenutnim znanjem u toku ucenja  koncepata za chart dijagram
public double[] getActualKnowledgeLevel(){
  double[] actKnowlLevel = sm.getActualKnowledgeLevel();
  return actKnowlLevel;
}

  public void setPerformancesForOldUser(){

    tutor.setPerformancesForOldUser(userName);

  }


  public int userRegistration(String userN,String password,String courseId) {
    userName = userN;
    //initializeStudentModel();
    userID = sm.userRegistration(userName,password,courseId);
    return userID;
  }
  public int newUserRegistration(String firstName, String lastName, String userName, String email, String password,
                                 String address, String city, int country, String organization, String webSite,
                                 String language){

   userName=userName;
   initializeStudentModel();

   userID=sm.newUserRegistration(firstName,lastName,userName,email,password,
                           address,city,country,organization,webSite,language);

  return userID;
 }
 //proverava da li izabrano korisnicko ime vec postoji u bazi
  public boolean checkUserName(String userName){

    boolean userNameExist=sm.checkUserName(userName);
    return userNameExist;
  }
  //proverava da li password odgovara korisniku
 public boolean checkPassword(String userN,String pass){
   boolean passwordOK=sm.checkPassword(userN, pass);
   return passwordOK;
 }
  public void initializeStudentModel() {
  }
  public void setNewUser(boolean val) {
    tutor.setNewUser(val);
  }
  public void saveStudentData() {
    sm.saveStudentData();
  }
  public Vector addPassedConceptsToInstrPlanner() {
    Vector passedConcepts = sm.addPassedConceptsToInstrPlanner();
    return passedConcepts;
  }
  /**poziva se kada se zapocne novi koncept. Kreira novi koncept
   * u modelu studenta*/
  public void startNewConcept(String currConcId) {
    currentConceptId = currConcId;
    sm.startNewConcept(currentConceptId);
  }
  /*poziva se kada student ponavlja koncept koji je vec presao*/
  public void startRelearningConcept(String currConcId) {
    currentConceptId = currConcId;
   sm.startRelearningConcept(currentConceptId);
  }
  /** poziva se kada se zapocinje prvi koncept u sesiji za novog korisnika*/
  public void startFirstConcept(String currConcId) {
    currentConceptId = currConcId;
    sm.startFirstConcept(currentConceptId);
  }
  /**poziva se iz funkcije selectNextConcept da bi dao signal
   * modelu studenta da zavrsi prethodni koncept*/
  public void finishNewConcept() {
    sm.finishNewConcept();
  }
  /**Ubacuje naziv koncepta u model studenta*/
  public void setCurrConceptTitle(String title){
    sm.setCurrConceptTitle(title);
  }
  /** poziva se po zavrsetku svake lekcije*/
  public void finishNewUnit() {
  }

  public void addLearnedUnit(String lUnitId) {
    sm.addlearnedUnit(lUnitId,currUnitTitle);
  }
  //azurira podatke o lekciji kada se ponovo predje
  public void updatePassedLessonInfo(String lUnitId){
    sm.updatePassedLessonInfo(lUnitId);
  }

  public void setRef(PedagogicalModuleFacade ref) {
    pmf = ref;
  }

  public void setTestInSM(String qId, int gr) {
    sm.setTestInSM(qId, gr);
  }

  public void setInitialPerformances(double inSkLev, int detLev, String programmLang) {
    sm.setInitialPerformances(inSkLev, detLev, programmLang);
    initialSkillLevel=inSkLev;
    setActualSkillLevel(inSkLev);
    detailLevel=detLev;
  }

  public double getInitialSkillLevel() {
    double inSkL = sm.getInitialSkillLevel();
    return inSkL;
  }

  public int getDetailLevel() {
    int dl = sm.getDetailLevel();
    return dl;
  }
  public double getActualSkillLevel(){
    double asl=sm.getActualSkillLevel();
    actualSkillLevel=asl;
    return asl;
  }
  public String getProgrammLang(){
    String pl=sm.getProgrammLang();
    return pl;
  }
  public void setActualSkillLevel(double asl){
    sm.setActualSkillLevel(asl);
    actualSkillLevel=asl;
  }
  /**Ubacuje podatak o predjenom unitu u SM*/
  public void sendUnitData(String unitTitle){
    currUnitTitle=unitTitle;
  }
  /**Salje signal u model studenta da kreira novu instancu testa*/
public void startTestInSM(){
 sm.startTestInSM();
}
/**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
public void addQuestionToSM(String qId,int qGroup,boolean qTruth){
 sm.addQuestionToSM(qId,qGroup,qTruth);
}
/**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                               double actSkillLev, double testSuccess, double testPointsNumber){
 sm.setTestElementsInSM(testKnowledgeLevel,testDifficultyFactor,actSkillLev, testSuccess, testPointsNumber);
}
  /**Salje ocenu za odredjeno poglavlje u klasu GlobalAssessment,
    * radi dobijanja prosecne ocene*/
   public void sendConceptMarkInPedMod(double mark){
     pmf.sendConceptMarkInPedMod(mark);

   }
   /**Preuzima broj predjenih koncepata iz modela studenta*/
    public int getNumOfPassedConcepts(){
      int val=sm.getNumOfPassedConcepts();
      return val;

    }
    public String getPassedConceptTitleByOrdNum(int i){
    String cTitle=sm.getPassedConceptTitleByOrdNum(i);
    return cTitle;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    double degree=sm.getPassedConceptDegreeOfMastByOrdNum(i);
return degree;
  }


    /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
  * predjenih koncepata*/
 public void addPassedConceptFromSM(int index){
   sm.addPassedConceptFromSM(index);

 }
 /**Salje podatke o predjenim konceptima u prezentacioni modul*/
public void sendStatisticalData(String id,double degreeOfMast,double actualSkillLevel,int duration,String title){

  tutor.sendStatisticalData(id,degreeOfMast, actualSkillLevel,duration,title);

}
/**Salje podatke o upravo zavrsenom konceptu u model studenta*/
   public void sendConceptDataToSM(double currConceptDegree,double studSkillLevel){
     sm.sendConceptDataToSM(currConceptDegree,studSkillLevel);
   }
   /**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
  * statisticke podatke u lessonStatisticPage*/
 public void getConceptById(String concId){
   sm.getConceptById(concId);

 }
 /**Salje podatke o broju lekcija i testova u datom konceptu
  * u lessonStatisticPage*/
 public void sendNumbersOfToStatisticPage(int numOfLessons,int numOfTests){
   tutor.sendNumbersOfToStatisticPage(numOfLessons,numOfTests);
 }
 /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){
   String lTitle=sm.getLessonTitle(lessOrdNum);
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
   int numOfPass=sm.getLessonNumberOfPassess(lessOrdNum);
   return numOfPass;
 }

 /**Postavlja test koji ce se citati za statistic page*/
public void setStatisticTest(int testOrdNum){
  sm.setStatisticTest(testOrdNum);
}

 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    String qId=sm.getQuestionDataFromSM(qOrdNum);
    return qId;

  }
  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
 public void sendQuestionTruth(boolean qTruth){
   tutor.sendQuestionTruth(qTruth);
 }
 /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
   * page*/
 public int getNumberOfQuestions(){
   int numbOfQuests=sm.getNumberOfQuestions();
   return numbOfQuests;
 }
 /**Salje podatke o izabranom testu  u statistic page*/
   public void sendTestDataToStatPage(double testDegreeOfMast,int testDuration,
                                      double testDifficultyF,double testSucc,double testPointsN){
     tutor.sendTestDataToStatPage(testDegreeOfMast,testDuration,testDifficultyF,testSucc, testPointsN);
   }
   //postavlja podatke koji se odnose na kurs koji se izucava
  public void setCourseData(){
    sm.setCourseData();
  }
  //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int passedConceptId){
     String cId=sm.getPassedConceptIdByOrdNum(passedConceptId);
     return cId;
   }
   public int getNumberOfQuestInTest(int i){
     int qNumb=sm.getNumberOfQuestInTest(i);
     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
     double degreeT=sm.getTestDegreeByOrdNum(i);
     return degreeT;
   }
   public int getNumberOfTests(){
    int numb=sm.getNumberOfTests();
    return numb;
  }
  public Vector getCountries(){
    Vector countries=sm.getCountries();
    return countries;
  }
  public Vector getCountriesIds(){
      Vector countryShortcut=sm.getCountriesIds();
      return countryShortcut;
  }
  public Vector getLanguages(){
    Vector languages=sm.getLanguages();
    return languages;
  }
  public Vector getLanguagesIds(){
      Vector languagesIds=sm.getLanguagesIds();
      return languagesIds;
  }







  private SessionManager sm;
  private int userID;
  private String userName = new String();
  private double actualSkillLevel;
  private int detailLevel;
  private double initialSkillLevel;
  private String currentConceptId;
  private String currUnitTitle;
  private PedagogicalModuleFacade pmf;
  private Tutor tutor;

}
