package depths.presentationModule;
import depths.coordinator.Tutor;
public class StatisticBean {

  public StatisticBean() {

  }

  public double getActualSkillLevel(){
    return actualSkillLevel;
  }

  public void setActualSkillLevel(double actualSkillLevel){
      this.actualSkillLevel= actualSkillLevel;
      if (actualSkillLevel<1.5){
        actualSkillLevelText="Bad";
        slider2="sliderG_1.jpg";
      }else if (actualSkillLevel<2.5){
        actualSkillLevelText="Not bad";
        slider2="sliderG_2.jpg";
      }else if (actualSkillLevel<3.5){
        actualSkillLevelText="Good";
        slider2="sliderG_3.jpg";
      }else if (actualSkillLevel<4.5){
        actualSkillLevelText="Very good";
        slider2="sliderG_4.jpg";
      }else {
        actualSkillLevelText="Excellent";
        slider2="sliderG_5.jpg";
      }
    }

  public boolean isQuestTruth(){ return questTruth; }

  public void setQuestTruth(boolean questTruth){ this.questTruth = questTruth; }

  public int getNumberOfPassedConcepts(){
    return numberOfPassedConcepts;
  }

  public void setNumberOfPassedConcepts(int numberOfPassedConcepts){
      this.numberOfPassedConcepts= numberOfPassedConcepts;
    }
  public void getNumOfPassedConcFromSM(){
    numberOfPassedConcepts=tutor.getNumOfPassedConcepts();

  }

  public int getNumbOfTests(){
    return numbOfTests;
  }

  public void setNumbOfTests(int numbOfTests){
      this.numbOfTests= numbOfTests;
    }

  public void setTutorRef(Tutor ref){
    tutor=ref;
    tutor.sendRefFromTestBean(this);

  }

  public double getConcDegreeOfMastery(){
    return concDegreeOfMastery;
  }

  public void setConcDegreeOfMastery(double concDegreeOfMastery){
      this.concDegreeOfMastery=this.doubleToTwoDecimal( concDegreeOfMastery);
    }

  public double getTestDegreeOfMastery(){
    return testDegreeOfMastery;
  }

  public void setTestDegreeOfMastery(double testDegreeOfMastery){
      this.testDegreeOfMastery= this.doubleToTwoDecimal( testDegreeOfMastery);
    }

  public int getTestDuration(){
    return testDuration;
  }

  public void setTestDuration(int testDuration){
      this.testDuration= testDuration;
      testHours=testDuration/3600;
          int remain=testDuration%3600;
          testMin=remain/60;
          int r=remain%60;
          testSec=r;

    }

  public int getNumbOfQuestions(){
    numbOfQuestions= tutor.getNumberOfQuestions();
    return numbOfQuestions;
  }

  public void setNumbOfQuestions(int numbOfQuestions){
      this.numbOfQuestions= numbOfQuestions;
    }

  public String getConcId(){
    return concId;
  }

  public void setConcId(String concId){
      this.concId= concId;
    }
    public void sendStatisticalData(String id,double degreeOfMast,double actualSkillLevel,int duration,String title){

      this.setConcId(id);
      this.setConcDegreeOfMastery(degreeOfMast);
      this.setConcTitle(title);
      this.setActualSkillLevel(actualSkillLevel);
      this.setDuration(duration);
    }
    /**Poziva funkciju koja ce da prosledi vrednosti za koncept iz vektora
  * predjenih koncepata*/
 public void addPassedConceptFromSM(int index){
   tutor.addPassedConceptFromSM(index);

 }

  public String getQuestContent(){ return questContent; }

  public void setQuestContent(String questContent){ this.questContent = questContent; }

  public String getConcTitle(){

    return concTitle; }

  public void setConcTitle(String concTitle){

    this.concTitle = concTitle; }
  public String getActualSkillLevelText(){
    return actualSkillLevelText;
  }
  public String getSlider2Val(){

    return slider2;
  }
  public void setDuration(int dur){
  	this.concDuration=dur;

  	hours=concDuration/3600;
  	int remain=concDuration%3600;
  	min=remain/60;
  	int r=remain%60;
  	sec=r;
  }

  public int getNumbOfLessons(){
    return numbOfLessons;
  }

  public void setNumbOfLessons(int numbOfLessons){
      this.numbOfLessons= numbOfLessons;
    }

  public int getHours(){
  	return hours;
  }
  public int getMin(){
  	return min;
  }
  public int getSec(){
  	return sec;
  }
  public int getTestHours(){
         return testHours;
 }
 public int getTestMin(){
         return testMin;
 }
 public int getTestSec(){
         return testSec;
 }

  public int getDuration(){
  	return concDuration;
  }
  /**Pronalazi koncept na osnovu njegovog ID broja kako bi prosledio
   * statisticke podatke u lessonStatisticPage*/
  public void getConceptById(String concId){
    tutor.getConceptById(concId);

  }
  /**Salje podatke o broju lekcija i testova u datom konceptu
  * u lessonStatisticPage*/
 public void sendNumbersOfToStatisticPage(int numOfLessons,int numOfTests){
   this.setNumbOfLessons(numOfLessons);
   this.setNumbOfTests(numOfTests);


 }
 /**Preuzima iz modela studenta naslov lekcije na osnovu njenog ID broja*/
 public String getLessonTitle(int lessOrdNum){
   String lTitle=tutor.getLessonTitle(lessOrdNum);
   return lTitle;
 }
 public int getLessonNumberOfPassess(int lessOrdNum){
   int numOfPass=tutor.getLessonNumberOfPassess(lessOrdNum);
   return numOfPass;
 }
 /**Pronalazi pitanje u modelu studenta na osnovu njegovog rednog broja
  * i vraca tacnost studentovog odgovora a zatim iz domenskog modula uzima
  * tekst pitanja*/
 public void getQuestionDataFromSM(int qOrdNum){
   tutor.getQuestionDataFromSM(qOrdNum);
 }
 /**Postavlja test koji ce se citati za statistic page*/
public void setStatisticTest(int testOrdNum){
  tutor.setStatisticTest(testOrdNum);
}
/**Salje podatke o tacnosti studentovog odgovora na pitanje u statistic page*/
 public void sendQuestionTruth(boolean qTruth){
   this.setQuestTruth(qTruth);

 }
 /**Postavlja koncept koji se trenutno ucitava u statistic page u
     * domenskom modulu*/
    public void setConceptForStatPage(String concId){
      tutor.setConceptForStatPage(concId);

    }

  public double getTestDifficultyFactor(){
    return testDifficultyFactor;
  }

  public void setTestDifficultyFactor(double testDifficultyFactor){
      this.testDifficultyFactor= this.doubleToTwoDecimal(testDifficultyFactor);
    }

  public double getTestSuccess(){
    return testSuccess;
  }

  public void setTestSuccess(double testSuccess){
      this.testSuccess= this.doubleToTwoDecimal(testSuccess);
    }

  public double getTestPointsNumber(){
    return testPointsNumber;
  }

  public void setTestPointsNumber(double testPointsN){
      this.testPointsNumber= this.doubleToTwoDecimal(testPointsN);
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
   //pronalazi id koncepta iz vektora predjenih koncepata na osnovu njegovog
   //indeksa u vektoru
   public String getPassedConceptIdByOrdNum(int passedConceptId){
     String cId=tutor.getPassedConceptIdByOrdNum(passedConceptId);
     return cId;
   }


  private double actualSkillLevel;
  private boolean questTruth;
  private int numberOfPassedConcepts;

  private Tutor tutor;
  private double concDegreeOfMastery;
  private double testDegreeOfMastery;
  private int testDuration;
  private int numbOfQuestions;
  private String concId;
  private int concDuration;
  private int numbOfLessons;

  private int hours=0,min=0,sec=0;
  private int testHours=0, testMin=0,testSec=0;
  private String questContent;
  private String concTitle;
  private String actualSkillLevelText;
  private String slider2=new String();
  private int numbOfTests;
  private double testDifficultyFactor;
  private double testSuccess;
  private double testPointsNumber;
}
