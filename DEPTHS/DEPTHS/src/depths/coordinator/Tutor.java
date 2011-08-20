package depths.coordinator;

import java.io.*;
import java.util.*;
import depths.presentationModule.*;
import depths.utility.PropertiesManager;
import depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart;

/**
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * @author zoki
 */
public class Tutor {
  private String userName = new String();
  private int userID;
  private double initialSkillLevel;
  private double actualSkillLevel = 0;
  private int detailLevel;
  private String programmLang;
  private StudentModelHandler smh;
  private PedagogicalModuleFacade pmf;
  private DomainModuleFacade dmf;
  BufferedReader in;
  private String currentConceptId;
  private String currentUnitId;
  private Vector fragmentVector;
  private boolean newUser = false;
  private RegistrationBean regBean;
 // private boolean inLessons = false;
  //private boolean inTest = false;
  private TestBean testBean;
  private StatisticBean statBean;
  private String domainModuleURI;
  private String lomURI;
  private PropertiesManager propManager;
  private ConceptHitChart chChart;
  private String rulesURI;
  private String svgURI;

  public Tutor(RegistrationBean rBean) {
    propManager=new PropertiesManager(this);
    regBean = rBean;
    smh = new StudentModelHandler(this);
    dmf = new DomainModuleFacade(this);
    pmf = new PedagogicalModuleFacade(this, smh, dmf, regBean);
    smh.setRef(pmf);
    dmf.setRef(pmf);

  }
  public void setChartsRef(ConceptHitChart conceptHitChart){
    pmf.setChartsRef(conceptHitChart);
  }


  /**
   * poziva funkciju za registraciju korisnika na pocetku sesije
   * @param name String
   * @return int
   */
  public void userRegistration(String name,String password,String courseId) {
    userName = name;
    //smh.initializeStudentModel();
    userID = smh.userRegistration(name,password,courseId);
  }
  public void newUserRegistration(String firstName, String lastName, String userName, String email, String password,
                                  String address, String city, int country, String organization, String webSite,
                                  String language){

    userName=userName;

    //initializeStudentModel treba uraditi
    userID=smh.newUserRegistration(firstName,lastName,userName,email,password,
                            address,city,country,organization,webSite,language);

  }
  //proverava da li izabrano korisnicko ime vec postoji u bazi
  public boolean checkUserName(String userName){

    boolean userNameExist=smh.checkUserName(userName);
    return userNameExist;
  }
  //proverava da li password odgovara korisniku
  public boolean checkPassword(String userN,String pass){
    boolean passwordOK=smh.checkPassword(userN, pass);
    return passwordOK;

  }


  public void initializeUserFromBean() {
    initializeUser(userID, actualSkillLevel, detailLevel, programmLang);
  }

  public void initializeUser(int userID, double actualSkillLevel, int detailLevel,String programmLang) {
    pmf.initializeUser(userID, actualSkillLevel,initialSkillLevel, detailLevel, programmLang);
  }

  public void setPerformancesForOldUser(String uName) {

    String dl = new String();
    detailLevel = smh.getDetailLevel();
    initialSkillLevel = smh.getInitialSkillLevel();
    actualSkillLevel = smh.getActualSkillLevel();
    programmLang=smh.getProgrammLang();
    if (detailLevel == 1) {
      dl = "Low";
    }
    else if (detailLevel == 2) {
      dl = "Middle";
    }
    else {
      dl = "High";
    }
    regBean.setDetailLevel(dl);
    String asl = new String();
    if (actualSkillLevel == 1) {
      asl = "Begginer";
    }
    else if ( (actualSkillLevel < 4) & (actualSkillLevel > 1)) {
      asl = "Intermediate";
    }
    else {
      asl = "Advanced";
    }
    regBean.setKnowledgeLevel(asl);
    regBean.setProgrammingLanguage(programmLang);

    //setInitialPerformances(initialSkillLevel,detailLevel);//da li treba ovo?

    pmf.initializeUser(userID, actualSkillLevel,initialSkillLevel, detailLevel,programmLang);

    //proveriti gde ce se ovo ubaciti
  }

  public String getCurrentConceptId() {
    return currentConceptId;
  }

  public void readNext() {
    pmf.selectNext();
  }
  public void selectParticularConcept(String cId){
    pmf.selectParticularConcept(cId);
    currentConceptId=cId;
  }
  public void selectParticularLearnedConcept(String cId){
    pmf.selectParticularLearnedConcept(cId);
    currentConceptId=cId;
  }

  public void selectParticularLesson(String lId){
   pmf.selectParticularLesson(lId);
   this.currentUnitId=lId;
 }


  /**Upisuje u model studenta initialSkillLevel i detailLevel*/
  public void setInitialPerformances(int inSkLev, int detLev, String progrLang) {
    smh.setInitialPerformances(inSkLev, detLev,progrLang);
    this.initialSkillLevel = inSkLev;
    this.detailLevel = detLev;
    this.programmLang=progrLang;
    this.actualSkillLevel = inSkLev;
  }

  //na kraju sesije ucenja cuva podatke o studentu u xml dokument
  public void saveStudentData() {
    smh.saveStudentData();
  }

  public void setCurrentConceptId(String currentConceptId) {
    this.currentConceptId = currentConceptId;
  }

  public String getCurrentUnitId() {
    return currentUnitId;
  }

  public void setCurrentUnitId(String currentUnitId) {
    this.currentUnitId = currentUnitId;
  }

  public void setNewUser(boolean val) {
    newUser = val;
    //promeni vrednost u JavaBean-u
    regBean.setNewUser(val);


  }

  public void setInLessonFlag(boolean val) {
    //inLessons = val;
    regBean.setInLessonFlag(val);
  }
  public boolean getInLessonFlag(){
    boolean val=regBean.getInLessonFlag();
    return val;
  }

  public void setInTestFlag(boolean val) {
    regBean.setInTestFlag(val);
  }
  public boolean getInTestFlag(){
    boolean val=regBean.getInTestFlag();
    return val;
  }
  public void setInAdditionalTestFlag(boolean val){
    regBean.setInAdditionalTestFlag(val);
  }
  public boolean getInAdditionalTestFlag(){
    boolean val=regBean.isInAdditionalTestFlag();
    return val;
  }
  public void setInAdditionalLessonFlag(boolean val){
    regBean.setInAdditionalLessonFlag(val);
  }
  public boolean getInAdditionalLessonFlag(){
    boolean val=regBean.isInAdditionalLessonFlag();
    return val;
  }

  public void sendUnitData(String currReadUnitId, String unTitle, int diffLev) {
    regBean.sendUnitData(currReadUnitId, unTitle, diffLev);
    smh.sendUnitData(unTitle);
  }

  public void sendConceptTitle(String title) {
    regBean.setCurrConceptTitle(title);
    smh.setCurrConceptTitle(title);
  }

  public void sendFragmentData(String id, String title, String type,
                               String content) {
    regBean.setFragmentId(id);
    regBean.setFragmentTitle(title);
    regBean.setFragmentType(type);
    regBean.setFragmentContent(content);
  }

  public void getFragmentByOrdNumber(int ordN) {
    pmf.getFragmentByOrdNumber(ordN);
  }

  public void sendAnswerData(String ansContent, boolean aTruth) {
    regBean.sendNewAnswerData(ansContent, aTruth);
  }

  public void sendQuestionData(String id, String content) {
    regBean.sendNewQuestionData(id, content);
  }

  public void getQuestionByOrdNum(int ordN) {
    pmf.getQuestionByOrdNum(ordN);
  }

  /** Proverava tacnost studentovog odgovora. Argumenti su redni broj pitanja
   * i indeks studentovog odgovora*/
  public void checkStudAnswer(int questOrdNumb, int studAnswer) {
    pmf.checkStudAnswer(questOrdNumb, studAnswer);
  }

  public void cleanStudAnswVector() {
    pmf.cleanStudAnswVector();
  }

  public void signalEndOfSendingStudentAnswers(int duration) {
    pmf.signalEndOfSendingStudentAnswers(duration);
  }

  public void sendRefFromTestBean(TestBean tb) {
    testBean = tb;
  }

  public void sendFeedbackText(double testKnowledgeLevel,double testDifficultyFactor,double testSuccess, String mainTestMessage,
                               int numOfQuest, int numOfWrongAnsw, int testDuration, double testPointsNumber) {
    testBean.setTestKnowledgeLevel(testKnowledgeLevel);
    testBean.setMainTestMessage(mainTestMessage);
    testBean.setNumbOfQuest(numOfQuest);
    testBean.setNumOfWrongAnsw(numOfWrongAnsw);
    testBean.setTestDifficultyFactor(testDifficultyFactor);
    testBean.setTestSuccess(testSuccess);
    testBean.setTestDuration(testDuration);
    testBean.setTestPointsNumber(testPointsNumber);
  }

  /**Vraca tekst pitanja na koje je student netacno odgovorio.
   * Kao parametar se prosledjuje redni broj pitanja*/
  public String getWrongQuestContent(int ordNum) {
    String cont = pmf.getWrongQuestContent(ordNum);
    return cont;
  }

  /**Vraca tacan odgovor na pitanje koje student nije tacno
   * odgovorio. Kao parametar se prosledjuje redni broj pitanja*/
  public String getWrongQuestTruthAnswer(int ordNum) {
    String answ = pmf.getWrongQuestTruthAnswer(ordNum);
    return answ;
  }

/**Pronalazi naslov lekcije koju student treba da ponovi*/
    public String  getTitleOfLessonToReLearn(int ordNum){
      String lessTitle=pmf.getTitleOfLessonToReLearn(ordNum);
      return lessTitle;
    }

    public void setConceptFinishedFlag(boolean val){
      pmf.setConceptFinishedFlag(val);
    }
    public void setInitialAdditionalParameters(){
      pmf.setInitialAdditionalParameters();
    }
    public void setAdditionalParametersAllFalse(){
    }

    public void restartCounter(){
      pmf.restartCounter();
    }
    /**Pronalazi broj koncepata koji su izabrani u instrukcioni plan*/
    public int getNumOfConceptsInPlan(){
      int cNum=pmf.getNumOfConceptsInPlan();
      return cNum;
    }
    public int getNumberOfUnitsInConcept(){
      int nUnits=pmf.getNumberOfUnitsInConcept();
      return nUnits;
    }
    /**Pronalazi  title koncepta na osnovu rednog broja
    * za sadrzaj na stranici*/
   public String getConceptByOrdNum(int ordNum){
     String cTitle=pmf.getConceptByOrdNum(ordNum);
     return cTitle;
   }
   public String getConceptIdByOrdNum(int ordNum){
   String cId=pmf.getConceptIdByOrdNum(ordNum);
   return cId;
 }
  public void setInAddition(boolean val){
    testBean.setInAddition(val);
  }
  public void setFinishLessonsFlag(boolean val){

    regBean.setFinishLessonsFlag(val);
  }
  /**Oznacava kraj koncepta u SM a poziva se
   * neposredno pre izlasak iz programa da bi se
   * sacuvali podaci o predjenom konceptu*/
  public void finishNewConcept(){

    smh.finishNewConcept();
    }
  /**Poziva procenu znanja studenta za predjeni koncept */
  public void startConceptAssessment(){
    pmf.startConceptAssessment();
  }
  /**Menja stepen trenutnog znanja studenta*/
    public void changeActualSkillLevel(double actualSkillLevel){
      this.actualSkillLevel=actualSkillLevel;
      smh.setActualSkillLevel(actualSkillLevel);
    }
    /**Preuzima broj predjenih koncepata iz modela studenta*/
    public int getNumOfPassedConcepts(){
      int val=smh.getNumOfPassedConcepts();
      return val;

    }
    /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
   * predjenih koncepata*/
  public void addPassedConceptFromSM(int index){
    smh.addPassedConceptFromSM(index);

  }
  /**Salje podatke o predjenim konceptima u prezentacioni modul*/
public void sendStatisticalData(String id,double degreeOfMast,double actualSkillLevel,int duration,String title){

  statBean.sendStatisticalData(id,degreeOfMast, actualSkillLevel,duration,title);

}
public void sendRefFromTestBean(StatisticBean statB){
  this.statBean=statB;
}
/**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
  * statisticke podatke u lessonStatisticPage*/
 public void getConceptById(String concId){
   smh.getConceptById(concId);

 }
 /**Salje podatke o broju lekcija i testova u datom konceptu
  * u lessonStatisticPage*/
 public void sendNumbersOfToStatisticPage(int numOfLessons,int numOfTests){
   statBean.sendNumbersOfToStatisticPage(numOfLessons,numOfTests);
 }
 /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){
   String lTitle=smh.getLessonTitle(lessOrdNum);
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
   int numOfPass=smh.getLessonNumberOfPassess(lessOrdNum);
   return numOfPass;
 }

 /**Postavlja test koji ce se citati za statistic page*/
public void setStatisticTest(int testOrdNum){
  smh.setStatisticTest(testOrdNum);
}

 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    String qId=smh.getQuestionDataFromSM(qOrdNum);
    String questContent=dmf.getQuestContent(qId);

    statBean.setQuestContent(questContent);
    return qId;
  }
    /**Postavlja koncept koji se trenutno ucitava u statistic page u
     * domenskom modulu*/
    public void setConceptForStatPage(String concId){
      dmf.setConceptForStatPage(concId);
    }
  /**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
 public void sendQuestionTruth(boolean qTruth){
   statBean.sendQuestionTruth(qTruth);
 }
 /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
  * page*/
public int getNumberOfQuestions(){
  int numbOfQuests=smh.getNumberOfQuestions();
  return numbOfQuests;
}
/**Salje podatke o izabranom testu  u statistic page*/
  public void sendTestDataToStatPage(double testDegreeOfMast,int testDuration,
      double testDifficultyF,double testSucc,double testPointsN){
    statBean.setTestDegreeOfMastery(testDegreeOfMast);
    statBean.setTestDuration(testDuration);
    statBean.setTestDifficultyFactor(testDifficultyF);
    statBean.setTestSuccess(testSucc);
    statBean.setTestPointsNumber(testPointsN);
  }
  /**Zapocinje novu instancu testa u SM*/
  public void startTestInSM(){
    smh.startTestInSM();
  }
  /**pronalazi naslov lekcije na osnovu njenog rednog broja u instrukcionom planu*/
public String getUnitTitleByOrdNum(int ordNum){
  String title=pmf.getUnitTitleByOrdNum(ordNum);
  return title;

}
/**Pronalazi id lekcije na osnovu njenog rednog broja u instrukcionom planu*/
  public String getUnitIdByOrdNum(int ordNum){
    String unitId=pmf.getUnitIdByOrdNum(ordNum);
    return unitId;
  }
//postavlja podatke koji se odnose na kurs koji se izucava
  public void setCourseData(){
    smh.setCourseData();
  }

  public String getDomainModuleURI(){
    return domainModuleURI;
  }

  public void setDomainModuleURI(String domainModuleURI){
      this.domainModuleURI= domainModuleURI;
    }

  public String getLomURI(){
    return lomURI;
  }

  public void setLomURI(String lomURI){
      this.lomURI= lomURI;
    }
    //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int passedConceptId){
     String cId=smh.getPassedConceptIdByOrdNum(passedConceptId);
     return cId;
   }
   //preuzima iz modela studenta broj predjenih koncepata
  public int getNumberOfPassedConcepts(){
    int numOfPassConc=smh.getNumOfPassedConcepts();
    return numOfPassConc;
  }
  public String getPassedConceptTitleByOrdNum(int i){
    String cTitle=smh.getPassedConceptTitleByOrdNum(i);
    return cTitle;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    double degree=smh.getPassedConceptDegreeOfMastByOrdNum(i);
return degree;
  }

  public String getRulesURI(){
    return rulesURI;
  }

  public void setRulesURI(String rulesURI){
      this.rulesURI= rulesURI;
    }

  public String getSvgURI(){
    return svgURI;
  }

  public void setSvgURI(String svgURI){

      this.svgURI= svgURI;

    }
    public Vector getCountries(){
    Vector countries=smh.getCountries();
    return countries;
  }

  public Vector getCountriesIds(){
      Vector countryShortcut=smh.getCountriesIds();
      return countryShortcut;
  }
  public Vector getLanguages(){
   Vector countries=smh.getLanguages();
   return countries;
 }

 public Vector getLanguagesIds(){
     Vector countryShortcut=smh.getLanguagesIds();
     return countryShortcut;
 }
 public String findPreviousLessonId(String currUnitId){
   String privUnitId=pmf.findPreviousLessonId(currUnitId);
   return privUnitId;
 }


}
