/* Generated by Together */

package depths.pedagogicalModule.studentAssessment;

public class StudentAnswer {
  public String getQuestionContent(){ return questionContent; }

  public void setQuestionContent(String questionContent){ this.questionContent = questionContent; }

  public int getStudentAnswerIndex(){
    return studentAnswerIndex;
  }

  public void setStudentAnswerIndex(int studentAnswerIndex){
      this.studentAnswerIndex= studentAnswerIndex;
    }

  public boolean isCorrectness(){ return correctness; }

  public void setCorrectness(boolean correctness){ this.correctness = correctness; }

  public int getTruthAnswerIndex(){
    return truthAnswerIndex;
  }

  public void setTruthAnswerIndex(int truthAnswerIndex){
      this.truthAnswerIndex= truthAnswerIndex;
    }

  public String getRelatedTo(){
    return relatedTo;
  }

  public void setRelatedTo(String relatedTo){
      this.relatedTo= relatedTo;
    }

  public String getTextOfTruthAnswer(){ return textOfTruthAnswer; }

  public void setTextOfTruthAnswer(String textOfTruthAnswer){ this.textOfTruthAnswer = textOfTruthAnswer; }

  public String getQuestionId(){
    return questionId;
  }

  public void setQuestionId(String questionId){
      this.questionId= questionId;
    }

  public int getQuestionOrdNumber(){
    return questionOrdNumber;
  }

  public void setQuestionOrdNumber(int questionG){
      this.questionGroup= questionG;
    }
    public int getQuestionGroup(){
    return questionGroup;
 }

 public void setQuestionGroup(int questionGroup){
     this.questionGroup= questionGroup;


   }

  public int getDifficultyLevel(){
    return difficultyLevel;
  }

  public void setDifficultyLevel(int difficultyLevel){
      this.difficultyLevel= difficultyLevel;
    }

  public int getOptTimeToSolve(){
    return optTimeToSolve;
  }

  public void setOptTimeToSolve(int optTimeToSolve){
      this.optTimeToSolve= optTimeToSolve;
    }

  private String questionContent;
  private int studentAnswerIndex;
  private boolean correctness;
  private int truthAnswerIndex;
  private String relatedTo;
  private String textOfTruthAnswer;
  private String questionId;
  private int questionOrdNumber;
  private int questionGroup;
  private int difficultyLevel;
  private int optTimeToSolve;
}