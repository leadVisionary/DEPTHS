package depths.domainModule;

import java.util.Vector;

public class Concept {
  private String conceptID;
  private String conceptTitle=new String();
  private Vector units=new Vector();
  private Vector questions=new Vector();
  private Unit cUnit;
  private Question cQuestion;
  private String currentReadingUnitId;
  private Unit currReadUnit=new Unit(this);
  private Course course;
  private Question currentReadingQuestion;
   private Question currentCheckingQuestion;

public Concept(Course c){
  course=c;
}
  public void addFragmentElem(String el,String val) {
    cUnit.addFragmentElem(el,val);
  }
  public void addFragmentElem(String el,int val) {
   cUnit.addFragmentElem(el,val);
 }


  public void finishQuestion() {
     questions.addElement(cQuestion);
  }

  public void finishAnswer() {
    cQuestion.finishAnswer();

  }

  public void finishUnit() {

    units.addElement(cUnit);
  }

  public void finishFragment() {
    cUnit.finishFragment();
  }

  public void newFragment() {
    cUnit.newFragment();
  }

  public void newUnit() {
    cUnit=new Unit(this);

  }

  public void newAnswer() {
   cQuestion.newAnswer();
  }

  public void newQuestion() {
     cQuestion =new Question(this);

  }

  public Concept() {
  }
  public void setConceptID(String v)
  {    conceptID=v;

  }
  public String getConceptID()
  {    return conceptID;
  }
  public void setConceptTitle(String t)
  {    conceptTitle=t;

  }
  public String getConceptTitle()
  {    return conceptTitle;
  }
  public void addConceptElem(String el,String val)
  {

      if (el.equals("title"))
     {
       setConceptTitle(val);
     }else if(el.equals("ID"))
      {
        setConceptID(val);

      }

  }
  public void addConceptElem(String el,int val)
  {

  }


  public void addUnitElement(String el,int val)
   {
     cUnit.addUnitElem(el,val);
   }
   public void addUnitElement(String el,String val)
   {
     cUnit.addUnitElem(el,val);
   }


     public void addQuestionElement(String el,String val)
      {
        cQuestion.addQuestionElem(el,val);

      }
      public void addQuestionElement(String el,int val)
      {
        cQuestion.addQuestionElem(el,val);

      }

      public void addAnswerElem(String el,String val) {
        cQuestion.addAnswerElem(el,val);
      }
      public void addAnswerElem(String el,boolean val) {
        cQuestion.addAnswerElem(el,val);
      }
      public void readNextLesson(String currReadUnitId){


        currentReadingUnitId=currReadUnitId;
        int capacity=units.size();
          for (int i=0;i<capacity;i++){

            Unit u=(Unit) units.get(i);

            if (u.getUnitID().equals(currentReadingUnitId)){

              currReadUnit=u;
              //ovde dodati kod koji ce da prosledjuje podatke o nadjenom unitu
              //u presentacioni modul
              String unTitle=currReadUnit.getUnitTitle();
              int diffLev=currReadUnit.getUnitDifficultyLevel();
              course.sendUnitData(currentReadingUnitId,unTitle,diffLev);
          }
        }
      }
      public void readNextFragment(String fragmId){


        currReadUnit.readNextFragment(fragmId);
      }
      public void sendFragmentData(String id,String title,String type,String content){

        course.sendFragmentData(id,title,type,content);
      }
      /** Pronalazi pitanje iz DM na osnovu njegovog ID broja*/
      public void getQuestionFromDMbyID(String qId){
       int qCapacity=questions.size();
       String crQuestID;
       String crQuestContent;

       for (int i=0;i<qCapacity;i++){
         Question cQuest =(Question) questions.get(i);

         if (cQuest.getQuestionID().equals(qId)){
           currentReadingQuestion=cQuest;
           crQuestID=currentReadingQuestion.getQuestionID();
           crQuestContent=currentReadingQuestion.getQuestionContent();
          course.sendQuestionData(crQuestID,crQuestContent);

       currentReadingQuestion.getAnswers();

         }
       }

      }
      /**Salje podatke o odgovoru u regBean*/
      public void sendAnswerData(String ansContent,boolean aTruth){
        course.sendAnswerData(ansContent,aTruth);
      }
      /**Pronalazi trazeno pitanje i trazi tacan odgovor*/
      public void checkStudAnswerByID(String questId,int studAnswer){
        int questNumb=questions.size();
        for (int i=0;i<questNumb;i++){
          Question cQ=(Question) questions.get(i);
          if (cQ.getQuestionID().equals(questId)){
            currentCheckingQuestion=cQ;
          }
        }
        currentCheckingQuestion.checkStudAnswer(questId,studAnswer);
      }
      /**Vraca nadjeno pitanje i ostale potrebne podatke prema
       * Pedagoskom modulu da bi ga obradio*/
      public void sendStudentAnswerBackFromDM(
                  String questId,String questContent,int studAnswer,
                  int indexOfTruthAnsw,String textOfTruthAnsw,String qRelatedTo,int qGroup,
                      int questionDifficultyLevel, int optTimeToSolveQuest){

          course.sendStudentAnswerBackFromDM(questId,questContent,studAnswer,
                                      indexOfTruthAnsw,textOfTruthAnsw,qRelatedTo,qGroup, questionDifficultyLevel, optTimeToSolveQuest);
     }
     /**Pronalazi naslov lekcije koju student treba da ponovi*/
    public String  getTitleOfLessonToReLearn(String lessId){
      int capacity=units.size();

      String lessTitle=new String();
      for (int i=0;i<capacity;i++){


        Unit nUnit = (Unit) units.get(i);

        if (nUnit.getUnitID().equals(lessId)) {
          lessTitle = nUnit.getUnitTitle();
        }
      }
       return lessTitle;
   }

   /**Pronalazi tekst pitanja i salje ga u statistic page*/
       public String getQuestContent(String qId){

         int numOfQuest=questions.size();
         String qCont=new String();
         for (int i=0;i<numOfQuest;i++){
           Question q = (Question) questions.get(i);
           if (q.getQuestionID().equals(qId)){
             qCont=q.getQuestionContent();

           }

         }
         return qCont;

       }



}
