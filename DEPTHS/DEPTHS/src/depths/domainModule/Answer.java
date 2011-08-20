package depths.domainModule;

public class Answer {
  public String getAnswerContent(){ return answerContent; }

  public void setAnswerContent(String answerContent){ this.answerContent = answerContent; }

  public boolean isTruth(){ return truth; }

  public void setTruth(boolean truth){ this.truth = truth; }

  public void addAnswerElem(String el,String val) {
    if (el.equals("textOfAnswer")){
      setAnswerContent(val);

    }
  }
  public void addAnswerElem(String el,boolean val) {
    if (el.equals("truth")){
      setTruth(val);

    }
  }

  private String answerContent;
  private boolean truth;
 }
