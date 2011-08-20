package depths.coordinator;

import depths.pedagogicalModule.Course;
import java.util.*;
import depths.presentationModule.RegistrationBean;
import depths.pedagogicalModule.instructionalPlanner.FragmentInfo;
import depths.pedagogicalModule.studentAssessment.charts.ConceptHitChart;

public class PedagogicalModuleFacade {

  /** postavlja se na true kada je korisnik dosao do kraja poglavlja cime se sistemu daje do znanja da
   * ga treba prebaciti u novo poglavlje   */
  private boolean conceptFinished = true;

  /**daje signal sistemu da je otpoceto poglavlje i da korisnika treba voditi izmedju lekcija
   * unutar koncepta   */


  /**postavlja se na true kada je korisnik zavrsio sa pregledanjem svih lekcija unutar koncepta
   * i treba mu dati test    */
  //private boolean lessonsFinished = false;
  private Course course;
  private Tutor tutor;
  private String currentConceptId;
  private String currentUnitId;

  //private boolean inTest = false;
  //private boolean inLessons = false;
  private Vector fVect = new Vector();
  private StudentModelHandler smh;
  private DomainModuleFacade dmf;
  private boolean concStarted = false;
  private RegistrationBean regBean;

  //private boolean inAdditionalLessonFlag=false;
  private double initialSkillLevel = 0.0;
  private int numbOfAdditionalLessons = 0;
  private int countOfReLearnedLessons = 0;
private int numbOfLessons=0;
  private int countOfLearnedLessons=0;
  public PedagogicalModuleFacade(Tutor t, StudentModelHandler s,
                                 DomainModuleFacade dm, RegistrationBean rb) {
    tutor = t;
    course = new Course(this);
    smh = s;
    dmf = dm;
    regBean = rb;
  }

  /**  funkcija obradjuje slucaj kada korisnik izabere "next"   */
  public void selectNext() {
    if (conceptFinished) {

      selectNextConcept(); //treba obraditi ovu funkciju
      conceptFinished = false;
      tutor.setInLessonFlag(true);
      selectNext();

    }
    else if (conceptFinished == false) {

      if (tutor.getInLessonFlag()) {

        if (tutor.getInAdditionalLessonFlag()) {

          selectNextAdditionalLesson();

        }
        else {

          selectNextLesson();

        }
      }
      else if (tutor.getInTestFlag()) {

        if (tutor.getInAdditionalTestFlag()) {

          selectAdditionalTest();
        }
        else {


          selectTest();
          tutor.setInTestFlag(false);
          tutor.setInLessonFlag(true);


        }
      }
    }


  }
  //preuzima vektor sa nazivima koncepata za chart dijagram
 public String[] getConceptsTitles(){
   String[] concepts=smh.getConceptsTitles();
   return concepts;
 }
 //preuzima vektor sa ocenama koncepata za chart dijagram
public double[] getConceptsDegrees(){
  double[] degrees = smh.getConceptsDegrees();
  return degrees;
}
//preuzima vektor sa trenutnim znanjem u toku ucenja  koncepata za chart dijagram
public double[] getActualKnowledgeLevel(){
  double[] actKnowlLevel = smh.getActualKnowledgeLevel();
  return actKnowlLevel;
}


  /**Vrsi izbor sledece dodatne lekcije koju je Tutor preporucio studentu
   * da ponovi*/
  public void selectNextAdditionalLesson() {
    numbOfAdditionalLessons = course.getNumbOfAdditionalLessons();
    if (countOfReLearnedLessons == numbOfAdditionalLessons ) {
      tutor.setFinishLessonsFlag(true);
      tutor.setInLessonFlag(false);
      tutor.setInTestFlag(true);
      tutor.setInAdditionalLessonFlag(false);
      tutor.setInAdditionalTestFlag(true);
    }
    if (countOfReLearnedLessons < numbOfAdditionalLessons ) {
      currentUnitId = course.getAdditLessId(countOfReLearnedLessons);
      dmf.readNexLesson(currentUnitId); //proveriti
      tutor.setCurrentUnitId(currentUnitId); //proveriti
      course.addFragmentsForOneUnit(currentUnitId);
      smh.updatePassedLessonInfo(currentUnitId);
      getFragmentVectorForUnit(currentUnitId); //proveriti
      countOfReLearnedLessons++;
    }
    else {
    }
  }

  public void selectAdditionalTest() {
    int qNumber = course.getNumberOfWrongAnswers();
    course.addPassedQuestionsToRete();
    course.cleanProcedureSet();
    for (int i = 0; i < qNumber; i++) {
      int qGroup = course.getWrongQuestionGroup(i);

      course.putQuestInQuestPlan(qGroup);
    }
    int finQNumber = course.getNumberOfQuestions(); //broj pitanja koje je rete izabrao
    if (finQNumber==0){


    }

    regBean.setNumOfQuestionsInPlan(finQNumber);
  }


  public void setLessonReadingParameter(boolean val) {
    if (val == true) {
      tutor.setInLessonFlag(false);
      tutor.setInTestFlag(true);
    }
  }

  //Salje signal da je upravo procitana poslednja lekcija
  //za dato poglavlje
  public void setFinishLessonsFlag(boolean val) {

    tutor.setFinishLessonsFlag(val);
  }

  /**Ubacuje podatke o korisniku */
  public void initializeUser(int userId, double stActSkLev, double initSkillLevel,
                             int detLev,String programmLang) {

    initialSkillLevel = initSkillLevel;
    course.initializeUser(userId, stActSkLev, initialSkillLevel, detLev, programmLang);
    conceptFinished = false;


  }

  /** Pokrece Jess, okrece inicijalni Vector i bira trenutni koncept*/
  public void startNewConcept() {
    smh.startFirstConcept(currentConceptId);
    dmf.startNewConcept(currentConceptId);
    concStarted = true;
  }

  /**  Funkcija obradjuje slucaj kada korisnik zavrsi odredjeno poglavlje i
   * izabere "next" cime ga sistem upucuje na sledece poglavlje    */
  public void selectNextConcept() {
    tutor.setFinishLessonsFlag(false);
    if (concStarted) {

      smh.finishNewConcept();
    }
    course.selectCurrentConcept();
    smh.startNewConcept(currentConceptId);
    dmf.startNewConcept(currentConceptId);
    concStarted = true;
  }

  /**  funkcija obradjuje slucaj kada korisnik sam izabere odredjeni koncept
   *     */
  public void selectParticularConcept(String cId) {
    tutor.setFinishLessonsFlag(false);
    if (concStarted) {

      //smh.finishNewConcept();
   }
    currentConceptId = cId;
    conceptFinished = false;
    tutor.setInLessonFlag(true);
    tutor.setInTestFlag(false);
    tutor.setInAdditionalLessonFlag(false);
    tutor.setInAdditionalTestFlag(false);
    if ( (tutor.getInAdditionalTestFlag()) || (tutor.getInAdditionalLessonFlag())) {
      tutor.setInAddition(true);
    }
    course.selectParticularConcept(currentConceptId);
    smh.startNewConcept(currentConceptId);
    dmf.startNewConcept(currentConceptId);
    concStarted = true;
  }
  //poziva se kada korisnik odluci da ponovo uci koncept koji je ranije ucio
  public void selectParticularLearnedConcept(String cId) {
    tutor.setFinishLessonsFlag(false);
    if (concStarted) {

      //smh.finishNewConcept();
    }
    currentConceptId = cId;
    conceptFinished = false;
    tutor.setInLessonFlag(true);
    tutor.setInTestFlag(false);
    tutor.setInAdditionalLessonFlag(false);
    tutor.setInAdditionalTestFlag(false);
    if ( (tutor.getInAdditionalTestFlag()) || (tutor.getInAdditionalLessonFlag())) {
      tutor.setInAddition(true);
    }
    course.selectParticularConcept(currentConceptId);
    smh.startRelearningConcept(currentConceptId);
    dmf.startNewConcept(currentConceptId);
    concStarted = true;
  }




  /** funkcija obradjuje slucaj kada korisnik zapocinje ili se nalazi unutar poglavlja
   * prilikom cega ga sistem vodi od jedne do druge lekcije    */
  public void selectNextLesson() {

this.numbOfLessons=course.getNumberOfLessons();

    String currentUnitId = course.readNextLesson();

    dmf.readNexLesson(currentUnitId);

    tutor.setCurrentUnitId(currentUnitId);


    addLearnedUnitInSM(currentUnitId);

    getFragmentVectorForUnit(currentUnitId);

this.countOfLearnedLessons++;

  }
  /** funkcija obradjuje slucaj kada korisnik sam izabere lekciju koju ce uciti
    */
  public void selectParticularLesson(String uId) {

this.numbOfLessons=course.getNumberOfLessons();
   String currentUnitId = course.readParticularLesson(uId);
   dmf.readNexLesson(currentUnitId);
   tutor.setCurrentUnitId(currentUnitId);
   //addLearnedUnitInSM(currentUnitId);
   getFragmentVectorForUnit(currentUnitId);


//this.countOfLearnedLessons++;
  }


  /** Dodaje lekciju koja je upravo predjena u model studenta*/
  public void addLearnedUnitInSM(String currUnId) {

    smh.addLearnedUnit(currUnId);
  }

  /**Poziva funkciju iz instrukcionog plana koja vraca
   * vektor u kome se nalaze izabrani fragmenti za dati Unit*/
  public void getFragmentVectorForUnit(String currUnitId) {

    try{

      fVect = course.getFragmentVectorForUnit(currUnitId);

      try {

        int vectCap = fVect.size();

        regBean.setNumberOfFragmentsInUnit(vectCap);

      }
      catch (NoSuchElementException e) {
      }
    }catch(NullPointerException npe){
    System.out.println("****ERROR NO SUCH ELEMENT EXCEPTION");}
  }

  /**poziva se iz Registration Bean-a tj. iz jsp strane za vrednosti od 0 do
   * broja fragmenata u planu lekcije*/
  public void getFragmentByOrdNumber(int ordN) {

    try{

      FragmentInfo nn = (FragmentInfo) fVect.elementAt(ordN);

      String fragmId = nn.getFragmentID();

      dmf.readNextFragment(fragmId);

    }catch(NullPointerException npe){
      System.out.println("****ERROR NULL POINTER EXCEPTION");


    }
  }

  /**funkcija obradjuje slucaj kada je korisnik zavrsio sa svim lekcijama unutar koncepta i
   * treba mu postaviti test   */
  public void selectTest() {
    int qNumber = course.getNumberOfQuestions(); //broj pitanja

    regBean.setNumOfQuestionsInPlan(qNumber);
  }

  /** Iz Pedagoskog modula pronalazi ID za pitaje sa odredjenim rednim
   * brojem pod kojim je smesten u vektoru*/
  public void getQuestionByOrdNum(int ordN) {
    String qId = course.getQuestionByOrdNum(ordN);
    getQuestionFromDMbyID(qId);
  }

  /** Iz Domenskog modula pronalazi pitaje na osnovu ID broja
   * nakon cega ga prosledjuje u registrationBean*/
  public void getQuestionFromDMbyID(String qId) {
    dmf.getQuestionFromDMbyID(qId);
  }

  public void setCurrentConceptId(String currConcId) {
    currentConceptId = currConcId;
    tutor.setCurrentConceptId(currentConceptId);
  }

  public Vector addPassedConceptsFromStMod() {
    Vector passedConcepts = smh.addPassedConceptsToInstrPlanner();
    return passedConcepts;
  }

  /** salje ID postavljenog pitanja u model studenta*/
  public void setTestInSM(String qId, int gr) {
    smh.setTestInSM(qId, gr);
  }

  /** Proverava tacnost studentovog odgovora tako sto najpre pronalazi ID
   * za pitanje za koje je dobio redni broj u intrukcionom planu a potom sa
   * tim brojem pronalazi pitanje u domenskom modulu*/
  public void checkStudAnswer(int questOrdNumb, int studAnswer) {

    String questId = course.getQuestionByOrdNum(questOrdNumb);

    dmf.checkStudAnswerByID(questId, studAnswer);

  }

  /**  Preuzima podatke o trazenom pitanju iz domenskog modula i
   * salje ga u pedagoski modul*/
  public void sendStudentAnswerBackFromDM(String questId, String questContent,
                                          int studAnswer, int indexOfTruthAnsw,
                                          String textOfTruthAnsw, String qRelatedTo, int qGroup,
                                          int questionDifficultyLevel, int optTimeToSolveQuest
      ) {
    course.sendStudentAnswerBackFromDM(questId, questContent, studAnswer,
                                       indexOfTruthAnsw, textOfTruthAnsw,
                                       qRelatedTo, qGroup, questionDifficultyLevel, optTimeToSolveQuest);
  }

  /**Uklanja sve podatke iz vektora u kome se cuvaju studentovi odgovori.
   * Poziva se pre pocetka procene testa, da bi se uklonili podaci iz prethodnog
   * koncepta*/
  public void cleanStudAnswVector() {
    course.cleanStudAnswVector();
  }

  /**Signalizira da je zavrseno slanje stdentovih odgovora u pedagoski
   * modul i da moze da pocne njihova obrada*/
  public void signalEndOfSendingStudentAnswers(int duration) {
    course.signalEndOfSendingStudentAnswers(duration);
  }

  public void sendFeedbackText(double testKnowledgeLevel,double testDifficultyFactor,double testSuccess, String mainTestMessage,
                               int numOfQuest, int numOfWrongAnsw, int testDuration, double testPointsNumber) {
    tutor.sendFeedbackText(testKnowledgeLevel, testDifficultyFactor,testSuccess,mainTestMessage, numOfQuest,
                           numOfWrongAnsw, testDuration, testPointsNumber);
  }

  /**Vraca tekst pitanja na koje je student netacno odgovorio.
   * Kao parametar se prosledjuje redni broj pitanja*/
  public String getWrongQuestContent(int ordNum) {
    String cont = course.getWrongQuestContent(ordNum);
    return cont;
  }

  /**Vraca tacan odgovor na pitanje koje student nije tacno
   * odgovorio. Kao parametar se prosledjuje redni broj pitanja*/
  public String getWrongQuestTruthAnswer(int ordNum) {
    String answ = course.getWrongQuestTruthAnswer(ordNum);
    return answ;
  }

  /**Pronalazi naslov lekcije koju student treba da ponovi*/
  public String getTitleOfLessonToReLearn(int ordNum) {
    String lessId = course.getLessonToReLearn(ordNum);
    String lessTitle = dmf.getTitleOfLessonToReLearn(lessId);
    return lessTitle;
  }

  public void setInitialParameters() {
    tutor.setInLessonFlag(true);
    tutor.setInTestFlag(false);
  }

  public void setInitialAdditionalParameters() {
    tutor.setInAdditionalLessonFlag(true);
    tutor.setInAdditionalTestFlag(false);
  }

  public void setAdditionalParametersAllFalse() {
  }

  public void setConceptFinishedFlag(boolean val) {
    this.conceptFinished = val;
  }

  /**Poziva se na pocetku koncepta da resetuje brojac ponovljenih lekcija*/
  public void restartCounter() {
    countOfReLearnedLessons = 0;
    this.countOfLearnedLessons=0;
  }

  /**Pronalazi broj koncepata koji su izabrani u instrukcioni plan*/
  public int getNumOfConceptsInPlan() {
    int cNum = course.getNumOfConceptsInPlan();
    return cNum;
  }

  public int getNumberOfUnitsInConcept() {
    int nUnits = course.getNumberOfLessons();
    return nUnits;
  }

  /**Pronalazi id i title koncepta na osnovu rednog broja
   * za sadrzaj na stranici*/
  public String getConceptByOrdNum(int ordNum) {
    String cId = course.getConceptIdByOrdNum(ordNum);
    String cTitle = dmf.findConceptTitleById(cId);
    return cTitle;
  }

  public String getConceptIdByOrdNum(int ordNum) {
    String cId = course.getConceptIdByOrdNum(ordNum);
    return cId;
  }

  /**Salje signal u model studenta da kreira novu instancu testa*/
  public void startTestInSM() {
    //smh.startTestInSM();
  }

  /**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
  public void addQuestionToSM(String qId, int qGroup, boolean qTruth) {
    smh.addQuestionToSM(qId, qGroup, qTruth);
  }

  /**Salje ocenu testa i trenutni stepen znanja studenta u model studenta*/
  public void setTestElementsInSM(double testKnowledgeLevel,double testDifficultyFactor,
                                  double actSkillLev, double testSuccess, double testPointsNumber) {
    smh.setTestElementsInSM(testKnowledgeLevel,testDifficultyFactor, actSkillLev, testSuccess, testPointsNumber);
  }

  /**Poziva procenu znanja studenta za predjeni koncept */
  public void startConceptAssessment() {
    course.startConceptAssessment();
  }

  /**Menja stepen trenutnog znanja studenta*/
  public void changeActualSkillLevel(double actualSkillLevel) {
    tutor.changeActualSkillLevel(actualSkillLevel);
  }

  /**Salje ocenu za odredjeno poglavlje u klasu GlobalAssessment,
   * radi dobijanja prosecne ocene*/
  public void sendConceptMarkInPedMod(double mark) {
    course.sendConceptMarkInPedMod(mark);

  }

  /**Salje podatke o upravo zavrsenom konceptu u model studenta*/
  public void sendConceptDataToSM(double currConceptDegree, double studSkillLevel) {
    smh.sendConceptDataToSM(currConceptDegree, studSkillLevel);
  }

  /**pronalazi naslov lekcije na osnovu njenog rednog broja u instrukcionom planu*/
  public String getUnitTitleByOrdNum(int ordNum) {

    String unitId = course.getUnitIdByOrdNum(ordNum);
    String title =dmf.findUnitTitleById(unitId);

    return title;

  }
  /**Pronalazi id lekcije na osnovu njenog rednog broja u instrukcionom planu*/
  public String getUnitIdByOrdNum(int ordNum){
    String unitId=course.getUnitIdByOrdNum(ordNum);
    return unitId;
  }

  //vraca URL LOM xml dokumenta
   public String getLomURL(){
     String lomURL=tutor.getLomURI();
     return lomURL;
   }
   public void setChartsRef(ConceptHitChart conceptHitChart){
    course.setChartsRef(conceptHitChart);
  }
  public int getNumberOfQuestInTest(int i){
     int qNumb=smh.getNumberOfQuestInTest(i);
     return qNumb;
   }
   public double getTestDegreeByOrdNum(int i){
     double degreeT=smh.getTestDegreeByOrdNum(i);
     return degreeT;
   }
   public int getNumberOfTests(){
    int numb=smh.getNumberOfTests();
    return numb;
  }
  public String getRulesURI(){
   String uri=tutor.getRulesURI();
   return uri;
 }
 public String findPreviousLessonId(String currUnitId){
   String privUnitId=course.findPreviousLessonId(currUnitId);
   return privUnitId;
 }







}
