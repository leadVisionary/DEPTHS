/* Generated by Together */

package depths.pedagogicalModule.instructionalPlanner;
import java.util.*;
public class FragmentsSelector {
  public FragmentsSelector(DiscoursePlanner dp,LessonSelector ls,InstructionalPlan ip){
    dPlanner=dp;
    lSel=ls;
    iPlan=ip;
    lSel.setFragmSelReference(this);

  }
  public int getStudentDetailLevel(){
    return studentDetailLevel;
  }

  public void setStudentDetailLevel(int studentDetailLevel){
      this.studentDetailLevel= studentDetailLevel;
      this.studentDetailLevelTemp=studentDetailLevel;

    }

  public String getCurrUnitID(){
    return currUnitID;
  }

  public void setCurrUnitID(String currUnitID){
      this.currUnitID= currUnitID;
    }

  public String getCurrConceptID(){
    return currConceptID;
  }

  public void setCurrConceptID(String currConceptID){
      this.currConceptID= currConceptID;
    }
    /**vrsi proveru da li stepen detaljnosti fragmenta
     * odgovara potrebama studenta
     */
  public void checkCurrFragment(){


    if (studentDetailLevelTemp >= fInfo.getDetailLevel()) {
      if(fInfo.getFragmentProgrammingLanguage().equals("any")){
          fVector.add(fInfo);
          this.fragmentsForLessonCounter++;

      }else if (studProgrammLang.equals(fInfo.getFragmentProgrammingLanguage())) {
          fVector.add(fInfo);

          this.fragmentsForLessonCounter++;

      }

    }
  }




  /** ubacuje vektor fragmenata u hash tabelu    */
  public void putVectorInPlan(){
    iPlan.putFragmentVectorInPlan(currUnitID,fVector);

    fVector=new Vector();

  }
  /**  pokrece mehanizam za ubacivanje fragmenata u instrukcioni plan    */
  public void addFragmentsInPlan(){
    iPlan.addFragmentsInPlan();
  }
  public void readNewFragment(String currConcID){


    fInfo=new FragmentInfo(currConcID,currUnitID);


  }
  public void addFragmentType(String type){
    fInfo.setFragmentType(type);
  }
  public void addFragmentProgrammingLanguage(String lang){
       fInfo.setFragmentProgrammingLanguage(lang);
  }
public void addFragmentID(String fId){
  fInfo.setFragmentID(fId);
}
public void addFragmentDetailLevel(int dl){
  fInfo.setDetailLevel(dl);
}


public void createNewFragmentVector(){
  fVector=new Vector();
}
public void setStudentProgrammLang(String progLang){
  this.studProgrammLang=progLang;

}
public void setStudentDetailLevelTemp(int sdl){
  this.studentDetailLevelTemp=sdl;
}
public int getStudentDetailLevelTemp(){
 return this.studentDetailLevelTemp;
}
  public int getFragmentsForLessonCounter(){

    return this.fragmentsForLessonCounter;
  }
  public void setFragmentsForLessonCounter(int value){

    this.fragmentsForLessonCounter=value;
  }

  private int studentDetailLevel;
  private int studentDetailLevelTemp;
  private String studProgrammLang;
  private String currUnitID;
  private String currConceptID;
  private DiscoursePlanner dPlanner;
  private LessonSelector lSel;
  private InstructionalPlan iPlan;
  private FragmentInfo fInfo;
  private Vector fVector=new Vector();
  private int privremeni=0;
  private int fragmentsForLessonCounter=0;

}