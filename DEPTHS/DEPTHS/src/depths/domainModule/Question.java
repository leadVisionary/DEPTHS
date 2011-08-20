package depths.domainModule;

import java.util.Vector;

public class Question {

  public Question(Concept conc){
    concept=conc;
  }
  public String getQuestionRelatedTo(){
    return questionRelatedTo;
  }

  public void setQuestionRelatedTo(String questionRelatedTo){
      this.questionRelatedTo= questionRelatedTo;

    }

  public int getQuestionDifficultyLevel(){
    return questionDifficultyLevel;
  }

  public void setQuestionDifficultyLevel(int questionDifficultyLevel){
      this.questionDifficultyLevel= questionDifficultyLevel;

    }

  public String getQuestionTitle(){ return questionTitle; }

  public void setQuestionTitle(String questionTitle){
    this.questionTitle = questionTitle;

  }

  public String getQuestionID(){
    return questionID;
  }

  public void setQuestionID(String questionID){
      this.questionID= questionID;

    }
    public void setQGroup(int qGroup){

      this.qGroup=qGroup;
    }
    public int getQGroup(){

      return this.qGroup;
    }

  public String getQuestionContent(){ return questionContent; }

  public void setQuestionContent(String questionContent){
    this.questionContent = questionContent;

  }

  public void finishAnswer() {
    answers.addElement(cAnswer);
  }

  public void addAnswerElem(String el,String val) {
    cAnswer.addAnswerElem(el,val);
  }
  public void addAnswerElem(String el,boolean val) {
    cAnswer.addAnswerElem(el,val);
  }
  public void newAnswer() {
    cAnswer=new Answer();

  }
  public void addQuestionElem(String el, String val) {
    if (el.equals("title")){
      this.setQuestionTitle(val);
    }else if (el.equals("questionContent")){
      this.setQuestionContent(val);
    }else if (el.equals("ID")){
      this.setQuestionID(val);
    }else if (el.equals("related-to")){
      this.setQuestionRelatedTo(val);
    }


  }
  public void addQuestionElem(String el, int val) {
     if (el.equals("difficultyLevel")){
      this.setQuestionDifficultyLevel(val);
    }else if (el.equals("group")){
      this.setQGroup(val);
    }
  }

  /**Pronalazi odgovore za trazeno pitanje i salje u regBean*/
  public void getAnswers(){

    int numOfAnswers=answers.size();
    for (int i=0;i<numOfAnswers;i++){

      Answer rAnswer=(Answer) answers.get(i);
      String ansContent=rAnswer.getAnswerContent();
      boolean aTruth=rAnswer.isTruth();
      concept.sendAnswerData(ansContent,aTruth);

    }
  }
  public void checkStudAnswer(String questId,int studAnswer){
    int numOfAnswers=answers.size();
    int indexOfTruthAnsw=0;
    String qRelatedTo;
    for (int i=0;i<numOfAnswers;i++){
      Answer rAnswer = (Answer) answers.get(i);

      if (rAnswer.isTruth()==true){
        truthAnswer=rAnswer;
        indexOfTruthAnsw=i;

      }
    }
    String textOfTruthAnsw=truthAnswer.getAnswerContent();
    String questContent=this.getQuestionContent();
    qRelatedTo=this.getQuestionRelatedTo();
    int questionGroup=this.getQGroup();



    concept.sendStudentAnswerBackFromDM(questId,questContent,studAnswer,indexOfTruthAnsw,textOfTruthAnsw,qRelatedTo,questionGroup,
                                        questionDifficultyLevel, optTimeToSolveQuest);

  }

  private String questionRelatedTo;
  private int questionDifficultyLevel;
  private int optTimeToSolveQuest=30;
  private String questionTitle;
  private String questionID;
  private Vector answers=new Vector();
  private Answer cAnswer;
  private Answer truthAnswer;
  private String questionContent;
  private Concept concept;
  private int qGroup;
}
