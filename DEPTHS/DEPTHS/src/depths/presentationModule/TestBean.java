package depths.presentationModule;
import depths.coordinator.Tutor;
import java.util.Date;
import java.util.Calendar;

public class TestBean {
  private Tutor tutor;
  private int numOfWrongAnsw;
  private String mainTestMessage;
  private boolean inAddition=false;
  private double testKnowledgeLevel;
  private int numbOfQuest;
  private Date started;
  private Date finished;
  private int duration;
  private double testDifficultyFactor;
  private double testSuccess;
  private int testDuration;
  private double testPointsNumber;

  public TestBean() {
  }

  public int getNumOfWrongAnsw(){
    return numOfWrongAnsw;
  }

  public void setNumOfWrongAnsw(int numOfWrongAnsw){
      this.numOfWrongAnsw= numOfWrongAnsw;
    }

  public String getMainTestMessage(){ return mainTestMessage; }

  public void setMainTestMessage(String mainTestMessage){ this.mainTestMessage = mainTestMessage; }

  public boolean isInAddition(){ return inAddition; }

  public void setInAddition(boolean inAddition){ this.inAddition = inAddition; }

  public double getTestKnowledgeLevel(){
    return testKnowledgeLevel;
  }

  public void setTestKnowledgeLevel(double testKnowledgeLevel){

      this.testKnowledgeLevel= this.doubleToTwoDecimal(testKnowledgeLevel);
    }

  public void setTutorRef(Tutor tut){
    tutor=tut;
    tutor.sendRefFromTestBean(this);
  }
  public void checkStudAnswer(int questOrdNumb,int studAnsw){

    tutor.checkStudAnswer(questOrdNumb,studAnsw);

  }
  //salje podatak da je zapoceto resavanje testa

  public void setDurationTime(){
          int hourDur=0,minDur=0,secDur=0;
    Date st=this.getStarted();
    Date fin=this.getFinished();

    Calendar stCal=Calendar.getInstance();
    stCal.setTime(st);
    Calendar finCal=Calendar.getInstance();
    finCal.setTime(fin);
    int hourSt=stCal.get(Calendar.HOUR_OF_DAY);
     int hourFin=finCal.get(Calendar.HOUR_OF_DAY);
     int minSt=stCal.get(Calendar.MINUTE);
     int minFin=finCal.get(Calendar.MINUTE);
     int secSt=stCal.get(Calendar.SECOND);
     int secFin=finCal.get(Calendar.SECOND);

     if (secFin<secSt){
       secFin=secFin+60;
       minFin--;
       secDur=secFin-secSt;
     }else{
       secDur=secFin-secSt;
     }
     if (minFin<minSt){
       minFin=minFin+60;
       hourFin--;
       minDur=minFin-minSt;

     }else{
       minDur=minFin-minSt;
     }
     if (hourFin<hourSt){
       hourFin=hourFin+24;
     }else{
       hourDur=hourFin-hourSt;
     }

    int finalDurationInSec=((hourDur*60*60)+(minDur*60)+secDur);


    this.setDuration(finalDurationInSec);

  }

  /**Poziva se neposredno pre provere odgovora studenta kako bi se ocistio
   * vektor koji cuva odgovore studenta od odgovora iz prethodnog koncepta*/
  public void cleanStudAnswVector(){
    tutor.cleanStudAnswVector();
  }
  /**Salje signal u klasu LocalAssessment da je zavrsena obrada svih
   * odgovora studenta i da pedagoski modul sada treba da ih obradi*/
  public void signalEndOfSendingStudentAnswers(){

    tutor.signalEndOfSendingStudentAnswers(duration);

  }

  public int getNumbOfQuest(){
    return numbOfQuest;
  }

  public void setNumbOfQuest(int numbOfQuest){
      this.numbOfQuest= numbOfQuest;
    }
    /**Vraca tekst pitanja na koje je student netacno odgovorio.
     * Kao parametar se prosledjuje redni broj pitanja*/
    public String getWrongQuestContent(int ordNum){
      String cont=tutor.getWrongQuestContent(ordNum);
      return cont;
    }
    /**Vraca tacan odgovor na pitanje koje student nije tacno
     * odgovorio. Kao parametar se prosledjuje redni broj pitanja*/
    public String getWrongQuestTruthAnswer(int ordNum){
      String answ=tutor.getWrongQuestTruthAnswer(ordNum);
      return answ;
    }
    /**Pronalazi naslov lekcije koju student treba da ponovi*/
    public String  getTitleOfLessonToReLearn(int ordNum){
      String lessTitle=tutor.getTitleOfLessonToReLearn(ordNum);
      return lessTitle;

    }
    /**Postavlja vrednost flaga koja signalizira da je koncept zavrsen*/
    public void setConceptFinished(boolean val){
   tutor.setConceptFinishedFlag(val);
   //tutor.setAdditionalParametersAllFalse();
 }
 public void restartCounter(){

   tutor.restartCounter();
 }
 public void startConceptAssessment(){

   tutor.startConceptAssessment();


 }

 public Date getStarted(){
    return started;
  }

 public void setStarted(Date started){

     this.started= started;
   }

 public Date getFinished(){
    return finished;
  }

 public void setFinished(Date finished){

     this.finished= finished;
     this.setDurationTime();
   }

 public int getDuration(){
    return duration;
  }

 public void setDuration(int duration){
     this.duration= duration;
   }

 public double getTestDifficultyFactor(){
    return testDifficultyFactor;
  }

 public void setTestDifficultyFactor(double testDifficultyFactor){

     this.testDifficultyFactor=this.doubleToTwoDecimal( testDifficultyFactor);


   }

 public double getTestSuccess(){
    return testSuccess;
  }

 public void setTestSuccess(double testSuccess){

     this.testSuccess= this.doubleToTwoDecimal(testSuccess);
   }

 public int getTestDuration(){
    return testDuration;
  }

 public void setTestDuration(int testDuration){
     this.testDuration= testDuration;
   }
   public double doubleToTwoDecimal(double value){

     double finalDouble=0.0;
     String temp=String.valueOf(value);
     int ind=temp.indexOf(".");


 try{
   temp = temp.substring(0, ind + 3);
 }catch(StringIndexOutOfBoundsException e){
   temp=temp;
 }
     finalDouble=Double.parseDouble(temp);

     return finalDouble;
   }

   public double getTestPointsNumber(){
    return testPointsNumber;
  }

   public void setTestPointsNumber(double testPointsN){

     this.testPointsNumber=this.doubleToTwoDecimal(testPointsN);



     }
}
