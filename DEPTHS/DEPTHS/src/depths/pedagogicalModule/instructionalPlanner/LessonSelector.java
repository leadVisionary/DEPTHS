package depths.pedagogicalModule.instructionalPlanner;

import java.util.*;
import jess.*;

public class LessonSelector {
  public LessonSelector(DiscoursePlanner dp, InstructionalPlan ip) {
    dPlanner = dp;
    iPlan = ip;
  }

  public void readLOM() {
  }

  public void chooseNextLesson() {
  }

  public void selectFragments() {
  }

  public void putLessonInPlan() {
  }

  public void setUnitInfo(String elemName, int value) {
    uInfo.setUnitInfo(elemName, value);
  }
  public void setUnitInfo(String elemName, String value) {
    uInfo.setUnitInfo(elemName, value);
  }


  /** poziva se iz UnitsReadera prilikom parsiranja metapodataka za unit prilikom
   * nailaska na Unit element*/
  public void readNewUnit() {

    uInfo = new UnitInfo(currConceptID);
    numberOfUnits++;
  }

  /** poziva se iz UnitsReadera prilikom parsiranja metapodataka za unit po
   * izlasku iz Unit elementa*/
  public void endOfReadingUnit() {
    String cID = uInfo.getConceptID();
    String uID = uInfo.getID();
    int ordN = uInfo.getOrdinalNumber();
    int diffL = uInfo.getDifficultyLevel();
    addUnitInfo(ordN, uID, diffL, cID);

  }

  /**Ovde treba ubaciti kod koji ce da ucitava sadrzaj vektora u Jess*/
  public void endOfReadingCurrentConcept() {
    runQueryFindLessons(currConceptID, studActualSkillLevel);
    //Poziv funkcije koja ce da pronadje potrebne fragmente
    fSel.addFragmentsInPlan();
    numberOfUnits = 0;
  }

  public void setCurrConceptID(String val) {
    currConceptID = val;
  }

  /**prima referencu na Rete engine*/
  public void setEngineReference(Rete en) {
    engine = en;
  }

  /**dodaje podatke o Unitu u Jess memoriju*/
  public void addUnitInfo(int ordNum, String id, int diffLev, String belToConc) {
    try {
      Fact fu = new Fact("lesson", engine);
      fu.setSlotValue("ordinalNumber", new Value(ordNum, RU.INTEGER));
      fu.setSlotValue("ID", new Value(id, RU.STRING));
      fu.setSlotValue("difficultyLevel", new Value(diffLev, RU.INTEGER));
      fu.setSlotValue("belongs-to-concept", new Value(belToConc, RU.STRING));
      engine.assertFact(fu);
    }
    catch (JessException je) {
      System.out.println(" ERROR addUnitInfo function JessException " +
                         je.getMessage());
    }
  }

  /**pokrece upit koji pronalazi lekcije za dati koncept*/
  public void runQueryFindLessons(String currConc, double diffLev) {

    setCheckLessParameters();
    try {
      ValueVector vv = new ValueVector();
      vv.add(new Value(currConc, RU.STRING));
      vv.add(new Value(this.unitDifficultyLevel, RU.INTEGER));
      Iterator it = engine.runQuery("find-lessons", vv);

      try {
        while (it.hasNext()) {
          Token t = (Token) it.next();
          Fact f = t.fact(1);
          int ordinalNumber = f.getSlotValue("ordinalNumber").intValue(null);
          String id = f.getSlotValue("ID").stringValue(null);
          int difficultyLevel = f.getSlotValue("difficultyLevel").intValue(null);
          String belongs = f.getSlotValue("belongs-to-concept").stringValue(null);


          iPlan.addUnitInPlan(new UnitInfo(belongs, ordinalNumber,
                                           difficultyLevel, id), ordinalNumber);
        }
        //ovde treba dodati poziv funkcije koja ce da proverava da li su pronadjeni svi uniti
        //koji treba da budu ukljuceni u nastavni proces

        for (int i = 0; i < 5; i++) {
          checkCurrConcLessonPlan();
        }
      }
      catch (NoSuchElementException ex) {
        System.out.println("ERROR  : NoSuchElementException");
      }
    }
    catch (JessException je) {
      System.out.println("ERROR  : JessException " + je.getMessage());
    }
  }

  /** podesava parametre  */
  public void setCheckLessParameters() {
   if (studActualSkillLevel<1.5){
     unitDifficultyLevel=1;
   }else if(studActualSkillLevel<2.5){
     unitDifficultyLevel=2;
   }else if(studActualSkillLevel<3.5){
     unitDifficultyLevel=3;
   }else if(studActualSkillLevel<4.5){
     unitDifficultyLevel=4;
   }else{
     unitDifficultyLevel=5;
   }

    uDiffLevCopy = unitDifficultyLevel;
    unDifLevUp = false;
  }

  /**pokrece upit koji pronalazi lekcije za dati koncept*/
  public void runQueryFindParticularLesson(String currConc, int diffLev,
                                           int ordNum) {

    try {
      ValueVector v = new ValueVector();
      v.add(new Value(currConc, RU.STRING));
      v.add(new Value(diffLev, RU.INTEGER));
      v.add(new Value(ordNum, RU.INTEGER));
      Iterator it = engine.runQuery("find-particular-lesson", v);

      try {
        if (it.hasNext()) {
          Token t = (Token) it.next();
          Fact f = t.fact(1);
          int ordinalNumber = f.getSlotValue("ordinalNumber").intValue(null);
          String id = f.getSlotValue("ID").stringValue(null);
          int difficultyLevel = f.getSlotValue("difficultyLevel").intValue(null);
          String belongs = f.getSlotValue("belongs-to-concept").stringValue(null);

          iPlan.addUnitInPlan(new UnitInfo(belongs, ordinalNumber,
                                           difficultyLevel, id), ordinalNumber);


        }
        //ovde treba dodati poziv funkcije koja ce da proverava da li su pronadjeni svi uniti
        //koji treba da budu ukljuceni u nastavni proces
      }
      catch (NoSuchElementException ex) {
        System.out.println("ERROR:  : NoSuchElementException");
      }
    }
    catch (JessException je) {
      System.out.println("ERROR: JessException " + je.getMessage());
    }
  }

  /**ova f-ja proverava da li su u hashtable unete sve potrebne lekcije*/
  public void checkCurrConcLessonPlan() {

    if (! (unDifLevUp)) {

      if (unitDifficultyLevel > 0) {

        unitDifficultyLevel--;
      }
      if (unitDifficultyLevel == 0) {

        unitDifficultyLevel = uDiffLevCopy;
        unitDifficultyLevel++;
        unDifLevUp = true;
      }
    }
    else if (unDifLevUp) {

      unitDifficultyLevel++;
    }
    for (int i = 0; i < numberOfUnits; i++) {

      if (iPlan.checkLessonPlan(i) == false) {

        runQueryFindParticularLesson(currConceptID, unitDifficultyLevel, i + 1);
      }
    }
  }

  public void setCurrentConceptID(String currConcId) {
    currConceptID = currConcId;
  }

  public void setFragmSelReference(FragmentsSelector fs) {
    fSel = fs;
  }

  public void setStudActSkillLevel(double sAsl) {
    this.studActualSkillLevel = sAsl;
    //ovde se stepenu slozenosti unita dodeljuje vrednost studentovog trenutnog znanja
    if(studActualSkillLevel<1.5){
      unitDifficultyLevel =1;
    }else if(studActualSkillLevel<2.5){
      unitDifficultyLevel =2;
    }else if(studActualSkillLevel<3.5){
      unitDifficultyLevel =3;
    }else if(studActualSkillLevel<4.5){
      unitDifficultyLevel =4;
    }else{
      unitDifficultyLevel =5;
    }




  }

  public void setStudDetailLevel(int sDl) {
    this.studentDetailLevel = sDl;
  }

  private String teachingStrategy;
  private double studActualSkillLevel;
  private int studentDetailLevel;
  private String learningStyle;
  private int unitDifficultyLevel;
  private int uDiffLevCopy;
  private String unitDetailLevel;
  private String unitID;
  private String unitTitle;

  private UnitInfo uInfo;
  private int numberOfUnits = 0;

  /**ovu dodelu vrednosti izbaciti kada
   * se implementira f-ja koja ce da vrsi izbor trenutnog koncepta
   */
  private String currConceptID;
  private DiscoursePlanner dPlanner;
  private Rete engine;
  private InstructionalPlan iPlan;
  private FragmentsSelector fSel;

  /**
   * Ovaj parametar govori da nema nijedne lekcije koja ima
   * manji stepen slozenosti od trazenog te da treba traziti slozenije
   */
  private boolean unDifLevUp = false;
}
