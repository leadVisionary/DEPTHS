package depths.domainModule;

import java.util.Vector;

public class Unit {
  public Unit(Concept conc){
    concept=conc;
  }
  public int getUnitDifficultyLevel(){
    return unitDifficultyLevel;
  }

  public void setUnitDifficultyLevel(int unitDifficultyLevel){
      this.unitDifficultyLevel= unitDifficultyLevel;

    }

  public String getUnitTitle(){ return unitTitle; }

  public void setUnitTitle(String unitTitle){
    this.unitTitle = unitTitle;

  }

  public int getUnitDetailLevel(){
    return unitDetailLevel;
  }

  public void setUnitDetailLevel(int unitDetailLevel){
      this.unitDetailLevel= unitDetailLevel;

    }

  public String getUnitID(){
    return unitID;
  }

  public void setUnitID(String unitID){
      this.unitID= unitID;

    }

  public void finishFragment() {
    fragments.addElement(cFragment);
  }

  public void addFragmentElem(String el,String val) {
    cFragment.addFragmentElem(el,val);
  }
  public void addFragmentElem(String el,int val) {
   cFragment.addFragmentElem(el,val);
 }


  public void newFragment() {
    cFragment=new Fragment();

  }

  public void addUnitElem(String el,String val) {
    if (el.equals("title")){
      this.setUnitTitle(val);
    }else if (el.equals("ID")){
      this.setUnitID(val);

    }
  }
  public void addUnitElem(String el,int val) {
     if (el.equals("difficultyLevel")){
      this.setUnitDifficultyLevel(val);
    }else if (el.equals("detailLevel")){
      this.setUnitDetailLevel(val);
    }
  }
  public void readNextFragment(String fragmId){

    int numOfFragm=fragments.size();
      for (int i=0;i<numOfFragm;i++){
      rFragment = (Fragment) fragments.get(i);
      if (rFragment.getFragmentID().equals(fragmId)) {
        String id = rFragment.getFragmentID();
        String title = rFragment.getFragmentTitle();
        String type = rFragment.getFragmentType();
        String content = rFragment.getFragmentContent();
        concept.sendFragmentData(id, title, type, content);
      }
    }

  }

  private Vector fragments=new Vector();
  public Fragment cFragment;
  public Fragment rFragment;
  private int unitDifficultyLevel;
  private String unitTitle;
  private int unitDetailLevel;
  private String unitID;
  private Concept concept;
}
