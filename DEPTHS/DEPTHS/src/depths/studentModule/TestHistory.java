//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModule\\TestHistory.java

package depths.studentModule;
import java.util.Vector;
import java.util.Date;



public class TestHistory extends CommonHistory
{
   private double degreeOfMastery;
   private double knowledgeLevel;
   private int testID;
   private Vector questions;
   private Question cParsQuest;
   private Question cQuestToWrite;
   private ConceptHistory cHistory;
   private Question cAddingQuestion;//pitanje koje se dodaje iz
   //pedagoskog modula

   private double testDifficultyFactor;
   private double success;
   private double testPointsNumber;

   /**    */
   public TestHistory(ConceptHistory cHist)
   {
     questions=new Vector();
     cHistory=cHist;

   }
   public void setTestID(int val){
     this.testID=val;

   }
   public int getTestID(){

     return this.testID;

   }

   /**    */
   public void setDegreeOfMastery(double dm)
   {
     degreeOfMastery=dm;

   }

   /**   ocena testa */
   public double getDegreeOfMastery()
   {
    return degreeOfMastery;
   }

   /** stepen trenutnog studentovog znanja u trenutku kada resava test*/
   public void setKnowledgeLevel(double kl)
   {
     knowledgeLevel=kl;
   }

   /** */
   public double getKnowledgeLevel()
   {
    return knowledgeLevel;
   }


   public void addTestGeneralElem(String el,int val)
   {

       if (el.equals("ID")){
      this.setTestID(val);
    }else if (el.equals("duration")){
      this.setDuration(val);
    }
   }
   public void addTestGeneralElem(String el,double val)
   {

       if(el.equals("degreeOfMastery"))
    {
      setDegreeOfMastery(val);

    }else if (el.equals("knowledgeLevel"))
    {
      setKnowledgeLevel(val);

    }else if (el.equals("testDifficultyFactor")){
      this.setTestDifficultyFactor(val);
    }else if (el.equals("sucess")){
      this.setSuccess(val);
    }else if (el.equals("testPointsNumber")){
      this.setTestPointsNumber(val);
    }

   }
   public void addTestGeneralElem(String el,Date val)
   {

       if(el.equals("started"))
    {
      this.setStarted(val);

    }else if (el.equals("finished"))
    {
      this.setFinished(val);

    }

   }


   public void createNewQuestion(){
     cParsQuest=new Question();
    }
    public void addQuestElem(String el,int val){
       if (el.equals("group")){
        cParsQuest.setGroup(val);
      }
    }
    public void addQuestElem(String el,String val){
      if (el.equals("ID")){
        cParsQuest.setID(val);
      }
    }

    public void addQuestElem(String el,boolean val){
      if (el.equals("truth")){
        cParsQuest.setStudentAnswerTruth(val);
      }
    }
    public void addQuestion(){
      questions.addElement(cParsQuest);
    }
    public void setQuestToWrite(int ordN){
      cQuestToWrite=(Question) questions.get(ordN);
    }
    public int getNumOfQuestions(){
      int val=questions.size();
      return val;
    }
    public int getQuestionElement(String el){
      int val=0;
       if (el.equals("group")){
        val=cQuestToWrite.getGroup();
      }
      return val;
    }
    public String getQuestionID(){
      String val="";
        val=cQuestToWrite.getID();
      return val;
    }
    public boolean getStudentAnswerTruth(){
      boolean val=cQuestToWrite.isStudentAnswerTruth();
      return val;
   }
   /**Dodaje podatke o odredjenom pitanju iz testa u model studenta*/
public void addQuestionToSM(String qId,int qGroup,boolean qTruth){
  cAddingQuestion=new Question();
  cAddingQuestion.setID(qId);
  cAddingQuestion.setGroup(qGroup);
  cAddingQuestion.setStudentAnswerTruth(qTruth);
  questions.addElement(cAddingQuestion);
}
/**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
   * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
   * tekst pitanja*/
  public String getQuestionDataFromSM(int qOrdNum){
    Question quest=(Question) questions.get(qOrdNum);
    String qId=quest.getID();
    boolean qTruth=quest.isStudentAnswerTruth();
    cHistory.sendQuestionTruth(qTruth);
    return qId;
  }
  /**Preuzima broj pitanja za dati test iz modela studenta i salje u statistic
    * page*/
  public int getNumberOfQuestions(){
    int numbOfQuests=questions.size();
    return numbOfQuests;
  }
  //upisuje podatke o pitanjima koja su postavljena u testu u bazu podataka
  public void saveQuestionData(){
    int numbOfQuests;
    String qId;
    boolean truth;
    Question quest=new Question();
    numbOfQuests=questions.size();
    for (int i=0;i<numbOfQuests;i++){

      quest=(Question) questions.get(i);
      qId=quest.getID();
      truth=quest.isStudentAnswerTruth();
      cHistory.writeQuestionData(qId,truth);
    }
  }

  public double getTestDifficultyFactor(){
    return testDifficultyFactor;
  }

  public void setTestDifficultyFactor(double testDifficultyFactor){
      this.testDifficultyFactor= testDifficultyFactor;
    }

  public double getSuccess(){
    return success;
  }

  public void setSuccess(double success){
      this.success= success;
    }

  public double getTestPointsNumber(){
    return testPointsNumber;
  }

  public void setTestPointsNumber(double testPointsNumber){
      this.testPointsNumber= testPointsNumber;
    }
}
