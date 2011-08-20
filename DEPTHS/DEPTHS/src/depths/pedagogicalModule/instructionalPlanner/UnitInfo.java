

package depths.pedagogicalModule.instructionalPlanner;

public class UnitInfo {
  public UnitInfo(String cID){
    conceptID=cID;
  }
  public UnitInfo(String cID, int on,int dl,String id){

    conceptID=cID;
    setOrdinalNumber(on);
    setDifficultyLevel(dl);
    setID(id);
  }
  public void setUnitInfo(String elemName, int value) {
    if (elemName == "ordinalNumber") {
      setOrdinalNumber(value);
    }
    else if (elemName == "difficultyLevel") {
      setDifficultyLevel(value);
    }

  }
  public void setUnitInfo(String elemName, String value) {
     if (elemName == "ID") {
      setID(value);
    }
  }

  public int getOrdinalNumber() {
    return ordinalNumber;
  }
  private void setOrdinalNumber(int ordinalNumber) {
    this.ordinalNumber = ordinalNumber;
  }
  public int getDifficultyLevel() {
    return difficultyLevel;
  }
  private void setDifficultyLevel(int difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }
  public String getID() {

    return ID;
  }
  private void setID(String ID) {
    this.ID = ID;
  }
  public String getTitle() {
    return title;
  }
  private void setTitle(String title) {
    this.title = title;
  }
  public String getConceptID(){
    return conceptID;
  }
  private int ordinalNumber;
  private int difficultyLevel;
  private String ID;
  private String title;
  private String conceptID;
}
