package depths.domainModule;

import java.util.Vector;
import depths.coordinator.DomainModuleFacade;


public class Course {
  private Vector concepts=new Vector();
  private Concept cConcept;
  private Concept statConcept;//koncept koji se ucitava u statistic page
  private String currentReadingConceptId;
  private Concept currReadConcept=new Concept();
  private String currentReadingUnitId;
  private DomainModuleFacade dmf;
  public Course(DomainModuleFacade dm) {
    dmf=dm;

  }
  public void newConcept()
  {
    cConcept=new Concept(this);
  }

  public void addConceptElement(String el,String val)
   {
     cConcept.addConceptElem(el,val);
   }

   public void addAnswerElem(String el,String val) {
     cConcept.addAnswerElem(el,val);
   }
   public void addAnswerElem(String el,boolean val) {
     cConcept.addAnswerElem(el,val);
   }


   public void finishQuestion() {
     cConcept.finishQuestion();
   }

   public void addFragmentElem(String el,String val) {
     cConcept.addFragmentElem(el,val);
   }
   public void addFragmentElem(String el,int val) {
     cConcept.addFragmentElem(el,val);
   }
   public void newQuestion() {
     cConcept.newQuestion();
   }
   public void finishFragment() {
     cConcept.finishFragment();
   }
   public void newFragment() {
     cConcept.newFragment();
   }
   public void addConceptElement(String el,int val)
   {
     cConcept.addConceptElem(el,val);
   }
   public void finishUnit() {
     cConcept.finishUnit();
   }
   public void newUnit() {
     cConcept.newUnit();
   }
   public void finishAnswer() {
     cConcept.finishAnswer();
   }
   public void newAnswer() {
     cConcept.newAnswer();
   }
   public void addQuestionElem(String el,String val) {
     cConcept.addQuestionElement(el,val);
   }
   public void addQuestionElem(String el,int val) {
     cConcept.addQuestionElement(el,val);
   }
   public void finishConcept() {
     concepts.addElement(cConcept);
   }
   public void addUnitElem(String el,String val) {
     cConcept.addUnitElement(el,val);
   }
   public void addUnitElem(String el,int val) {
     cConcept.addUnitElement(el,val);
   }
   public void startReadingNewConcept(String concId){

     currentReadingConceptId=concId;
     int capacity=concepts.size();

     for (int i=0;i<capacity;i++){
       Concept c=(Concept) concepts.get(i);
       if (c.getConceptID().equals(currentReadingConceptId)){

         currReadConcept=c;
         String title=currReadConcept.getConceptTitle();
         dmf.sendConceptTitle(title);
       }
     }
   }
   public void readNextLesson(String currReadUnitId){
     currentReadingUnitId=currReadUnitId;
     currReadConcept.readNextLesson(currentReadingUnitId);
    }
    public void sendUnitData(String currReadUnitId,String unTitle,int diffLev){
      dmf.sendUnitData(currReadUnitId, unTitle,diffLev);
    }
    public void readNextFragment(String fragmId){

      currReadConcept.readNextFragment(fragmId);
    }
    public void sendFragmentData(String id,String title,String type,String content){
      dmf.sendFragmentData(id,title,type,content);
    }
    public void getQuestionFromDMbyID(String qId){
      currReadConcept.getQuestionFromDMbyID(qId);
    }
    public void sendAnswerData(String ansContent,boolean aTruth){
      dmf.sendAnswerData(ansContent,aTruth);

    }
    public void sendQuestionData(String id,String content){
      dmf.sendQuestionData(id,content);

    }
    public void checkStudAnswerByID(String questId,int studAnswer){
      currReadConcept.checkStudAnswerByID(questId, studAnswer);
    }
    public void sendStudentAnswerBackFromDM(
                  String questId,String questContent,int studAnswer,
                  int indexOfTruthAnsw,String textOfTruthAnsw,String qRelatedTo,int qGroup,
                    int questionDifficultyLevel, int optTimeToSolveQuest
                     ){
        dmf.sendStudentAnswerBackFromDM(questId,questContent,studAnswer,
                                      indexOfTruthAnsw,textOfTruthAnsw,qRelatedTo,qGroup, questionDifficultyLevel, optTimeToSolveQuest);
                  }
     /**Pronalazi naslov lekcije koju student treba da ponovi*/
     public String  getTitleOfLessonToReLearn(String lessId){

        String lessTitle=currReadConcept.getTitleOfLessonToReLearn(lessId);

        return lessTitle;
    }
    /**Pronalazi  title koncepta na osnovu id koncepta
   * za sadrzaj na stranici*/
  public String findConceptTitleById(String cid){
    int numOfConc = concepts.size();
    String cTitle=new String();

   for (int i=0;i<numOfConc;i++){
     Concept c = (Concept) concepts.get(i);
     if (cid.equals( c.getConceptID())) {
       cTitle = c.getConceptTitle();
     }
   }
    return cTitle;
  }
  /**Postavlja koncept koji se trenutno ucitava u statistic page u
     * domenskom modulu*/
    public void setConceptForStatPage(String concId){
      int numOfConc=concepts.size();
      for (int i=0;i<numOfConc;i++){
        Concept sConcept = (Concept) concepts.get(i);
        if (sConcept.getConceptID().equals(concId)){
          statConcept=sConcept;
        }
      }
    }
    /**Pronalazi tekst pitanja i salje ga u statistic page*/
    public String getQuestContent(String qId){
      String questCont=statConcept.getQuestContent(qId);
      return questCont;

    }






}
