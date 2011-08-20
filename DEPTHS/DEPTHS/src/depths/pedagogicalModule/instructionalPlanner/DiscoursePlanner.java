
package depths.pedagogicalModule.instructionalPlanner;

import jess.*;
import java.io.*;
import java.util.*;
import depths.pedagogicalModule.Course;

public class DiscoursePlanner {
  public DiscoursePlanner(Course c) {
    course=c;
    iPlan = new InstructionalPlan(this);
    cSel = new ConceptSelector(this, iPlan);
    lSel = new LessonSelector(this,iPlan);
    fSel=new FragmentsSelector(this,lSel,iPlan);
    String lomURL=course.getLomURL();
    lrMgr = new LOM_reader_Mgr(this, lSel, lomURL);
    pSel=new ProcedureSelector(this,iPlan,lrMgr);
    lrMgr.setFSelReference(fSel);
    iPlan.setReferences(lrMgr,fSel);
    createReteObject();
  }
  /**  Privremeni vektor u kome su smesteni koncepti
   * prenosi u drugi vektor obrnutim redosledom kako
   * bi dobili pravi redosled    */
  public void turnConceptVector(){
       cSel.turnAroundConceptPlan();
  }

  /**kreira plan koncepata*/
  public void createConceptPlan() {

    cSel.addPassedConcepts("0");
    addPassedConceptsFromStMod();
    cSel.putConceptsInPlanToMemory("0");
    for (int i = 0; i < 23; i++) {
      cleanCVector();
      lrMgr.runParser();
      cSel.addConcFacts();
    }
  }

  /**Dodaje predjene koncepte iz modela studenta*/
  public void addPassedConceptsFromStMod(){

  	Vector passedConcepts=course.addPassedConceptsFromStMod();

  	int sz=passedConcepts.size();

  	for (int i=0;i<sz;i++){



  		String val=passedConcepts.get(i).toString();

  		cSel.addPassedConcepts(val);
  	}

  }


  /**
   * Vrsi izbor trenutnog koncepta koji ce se predstaviti
   * studentu i automatski kreira plan lekcija kao i skup procedura
   */
  public void selectCurrentConcept() {


    currentConceptID=cSel.selectCurrentConcept();


    lSel.setCurrentConceptID(currentConceptID);

    fSel.setCurrConceptID(currentConceptID);

    pSel.setCurrentConceptID(currentConceptID);

    course.setCurrentConceptID(currentConceptID);

    lrMgr.runUnitsReaderParser(currentConceptID);

    pSel.createProcedureSet();

  }
  public void selectParticularConcept(String cConceptId){

  currentConceptID=cConceptId;
  iPlan.selectParticularConcept(currentConceptID);
  lSel.setCurrentConceptID(currentConceptID);
  fSel.setCurrConceptID(currentConceptID);
  pSel.setCurrentConceptID(currentConceptID);
  course.setCurrentConceptID(currentConceptID);
  lrMgr.runUnitsReaderParser(currentConceptID);
  pSel.createProcedureSet();

 }

  public void createLessonPlan() {}
  public void createProcedurePlan() {}
  public void selectCurrentLesson() {}
  public void presentCurrentLesson() {}
  public void presentProcedureSet() {}
  public void checkProcedureResults() {}
  public void provideRealtimeFeedback() {}
  public void lessonReplan() {}
  public void procedureSetReplan() {}

  /**kreira Rete objekat u konstruktoru klase*/
  private void createReteObject() {
    try {
      String uri=course.getRulesURI();
      fr = new FileReader(uri);
      engine = new Rete();
      lSel.setEngineReference(engine);
      cSel.setEngineReference(engine);
      pSel.setEngineReference(engine);
      jesp = new Jesp(fr, engine);
      try {
        jesp.parse(false);
      }
      catch (JessException re) {
        System.out.println("ERROR createReteObject JessException "  +
                           re.getMessage());
      }
    }
    catch (IOException e) {
      System.out.println("ERROR createReteObject IOException ");
    }
   cSel.sendPointerToJess();
  }

  public void setCInfo(String s, String v) {
    cSel.setConceptInfo(s, v);
  }
/**uklanja sve podatke iz Vektora u kome se
 * cuvaju podaci o prerequisitima za trenutni koncept
 *
 */
  public void cleanCVector() {
    cSel.clearConceptVector();
  }
  public void startSession() {

  	  try {

      engine.run();

    }
    catch (JessException je) {
     System.out.println("ERROR: DiscoursePlanner startSession engine run exception: "+je.getMessage());
    }

    turnConceptVector();


    selectCurrentConcept();

     }
  /** poziva iz instrukcionog plana sledecu lekciju*/
  public String readNextLesson(){
    String lId=iPlan.readNextUnitFromPlan();
    return lId;
  }
  /** poziva iz instrukcionog plana odredjenu lekciju*/
  public String readParticularLesson(String uId){

    String lId=iPlan.readParticularUnitFromPlan(uId);

    return lId;
  }

  public void setLessonReadingParameter(boolean val){
    course.setLessonReadingParameter(val);
  }
  //Salje signal da je upravo procitana poslednja lekcija
  //za dato poglavlje
  public void setFinishLessonsFlag(boolean val){
    course.setFinishLessonsFlag(val);
  }
  /**Poziva funkciju iz instrukcionog plana koja vraca
   * vektor u kome se nalaze izabrani fragmenti za dati Unit*/
  public Vector getFragmentVectorForUnit(String currUnitId){
    Vector fVect=iPlan.getFragmentVectorForUnit(currUnitId);
    return fVect;
  }

  /**dodaje podatke o studentu u Jess memoriju    */
  public void addStudentData(int userId, double knLevel) {
    try {
      Fact fs = new Fact("student", engine);
      fs.setSlotValue("ID", new Value(userId, RU.INTEGER));
      fs.setSlotValue("knowledgeLevel", new Value(knLevel, RU.INTEGER));
      engine.assertFact(fs);
    }
    catch (JessException je) {
      System.out.println("ERROR addStudentData " + je.getMessage());
    }
  }
  /**pokrece Rete mehanizam */
   public void runEngine() {
    try {
      engine.runUntilHalt();
    }
    catch (JessException je) {
      System.out.println("ERROR runEngine function");
    }
  }
  public void setStudDetailLevel(int stDl){
    this.studDetailLevel=stDl;
    fSel.setStudentDetailLevel(stDl);
    lSel.setStudDetailLevel(stDl);
    pSel.setStudentDetailLevel(stDl);
  }
  public void setStudActualSkillLevel(double stAsl){
    this.studActualSkillLevel=stAsl;
    cSel.setStudActualSkillLev(stAsl);
    lSel.setStudActSkillLevel(stAsl);
    pSel.setStudActualSkillLevel(stAsl);
  }
  public void setStudentProgrammLang(String prLang){
    fSel.setStudentProgrammLang(prLang);
  }
  /**
   * podesava parametre datog studenta
   * @param studentActualSkillLevel int
   * @param studentDetailLevel int
   */
  public void setStudentData(int studId,double studentActualSkillLevel, int studentDetailLevel, String programmLang){
       this.studentID=studId;
       cSel.setStudentId(studId);
  	this.addStudentData(studId,studentActualSkillLevel);
    this.setStudActualSkillLevel(studentActualSkillLevel);
    this.setStudDetailLevel(studentDetailLevel);
    this.setStudentProgrammLang(programmLang);
  }
  public int getNumberOfLessons(){
  	int nol=iPlan.getNumberOfLessons();
  	return nol;
  }
  public String selectTest(int pos){
  	String val=iPlan.selectTest(pos);
  	return val;
  }
  /** salje podatak o pitanju u model studenta*/
  public void setTestInSM(String qId,int gr){
    course.setTestInSM(qId,gr);
  }
  public int getNumberOfQuestions(){
    int noq=iPlan.getNumberOfQuestions();
    return noq;
  }
  public String getQuestionByOrdNum(int ordN){


    String qId=iPlan.getQuestionByOrdNum(ordN);
    return qId;
  }
  public void addFragmentsForOneUnit(String uid) {
    iPlan.addFragmentsForOneUnit(uid);
    currentLessonID=uid;
  }
  /**Uklanja sve elemente vektora ProcedureSet*/
  public void cleanProcedureSet(){
    iPlan.cleanProcedureSet();
  }
  /**Bira jedno od pitanja i ubacuje u instrukcioni plan*/
  public void putQuestInQuestPlan(int qGroup){
    pSel.setQuestAllreadyRemoved(false);
    pSel.putQuestionInQuestPlan(qGroup);
  }
  /**Dodaje predjena pitanja u Rete*/
 public void addPassedQuestionsToRete(){
   pSel.addPassedQuestionToJess();
 }
 /**Pronalazi broj koncepata koji su izabrani u instrukcioni plan*/
   public int getNumOfConceptsInPlan(){
     int cNum=iPlan.getNumOfConceptsInPlan();
     return cNum;
   }
   /**Pronalazi id koncepta na osnovu rednog broja
    * za sadrzaj na stranici*/
   public String getConceptIdByOrdNum(int ordNum){
     String cId=iPlan.getConceptIdByOrdNum(ordNum);
     return cId;
   }
   public void changeConceptPlan(){
     cSel.changeConceptPlan();
   }
   /**pronalazi id lekcije na osnovu njenog rednog broja*/
   public String getUnitIdByOrdNum(int ordNum){

     String unitId=iPlan.getUnitIdByOrdNum(ordNum);
     return unitId;
   }
   //preuzima referencu na FactRetractor klasu iz ConceptSelectora i
   //salje je u Procedure Selector
   public void setFactRetractRef(FactRetractor fRetr){
     fRetractor=fRetr;
     pSel.setFactRetractRef(fRetr);
   }
   public String getCurrConceptID(){
     return currentConceptID;
   }
   public String findPreviousLessonId(String currUnitId){
   String privUnitId=iPlan.findPreviousLessonId(currUnitId);
   return privUnitId;
 }


  private Rete engine;
  private FileReader fr;
  private FileInputStream fis;
  private Jesp jesp;
  private ConceptSelector cSel;
  private LOM_reader_Mgr lrMgr;
  private int studentID;
  private String currentLessonID;
  private String currentConceptID;
  private String learningStyle;
  private String teachingStrategy;
  private int studDetailLevel;
  private double studActualSkillLevel;
  private boolean vectorPassedConceptsCreated = false;
  private boolean vectorConceptsInPlan = false;
  private InstructionalPlan iPlan;
  private LessonSelector lSel;
  private ProcedureSelector pSel;
  private FactRetractor fRetractor;
  /**stepen slozenosti koji odgovara trenutnom
  *znanju studenta
  private ValueVector IDcIP;*/
  private int difficultyLevel;
  private FragmentsSelector fSel;
  private Course course;





}
