

package depths.pedagogicalModule.instructionalPlanner;

import jess.*;

public class ConceptSelector {

  public ConceptSelector(DiscoursePlanner dp,InstructionalPlan ip){
    discPlanner=dp;
    iPlan=ip;
    cInfo=new ConceptInfo(this);
    iPlan.setConcSelectReference(this);

  }
    public void setConceptInfo(String a, String v){
      cInfo.setConceptInfo(a,v);
    }

   public void clearConceptVector()
   {
     cInfo.clearVector();
   }

    public String getID(){
     String x=cInfo.getID();
     return x;
    }

    public String getType(){
      String t=cInfo.getType();
      return t;
    }
    public String getTitle(){
      String t=cInfo.getTitle();
      return t;
    }
    public int getMinKnowledgeLevel(){
      int mkl=cInfo.getMinKnowledgeLevel();
      return mkl;
    }
    public int getOrdinalNumber(){
      int on=cInfo.getOrdinalNumber();
      return on;
    }
    public void setVectCapacity(int x){
      setPrerVectCapacity(x);
    }

    public String getPrerequisite(int rb) {
      String x=cInfo.getPrerequisite(rb);

      return x;
    }
    /**prenosi podatak o broju prerequisite u trenutnom konceptu*/
    public void beforeAssertConc(){
      cInfo.setVectorCap();
    }

    /**treba da doda concept u Jess memoriju*/
  public void addConcFacts() {
    try {
      ValueVector prerequisites = new ValueVector();
      Fact f = new Fact("concepts", engine);
      beforeAssertConc();
      f.setSlotValue("ID", new Value(getID(), RU.STRING));
      f.setSlotValue("ordinalNumber",
                     new Value(getOrdinalNumber(), RU.INTEGER));
      f.setSlotValue("minKnowledgeLevel",
                     new Value(getMinKnowledgeLevel(), RU.INTEGER));
      if (prereqVectCapacity > 0) {
        for (int i = 0; i < prereqVectCapacity; i++) {
          prerequisites.add(new Value(getPrerequisite(i), RU.STRING));
        }
        f.setSlotValue("prerequisite", new Value(prerequisites, RU.LIST));
      }
      engine.assertFact(f);
    }
    catch (JessException je) {
      System.out.println("  ERROR addConcFacts function JessException " +
                         je.getMessage());
    }
  }

/**definise velicinu vektora prerequisite*/
  public void setPrerVectCapacity(int x) {
    prereqVectCapacity = x;
  }
  /**poziva se iz Jess-a kada se ispuni uslov za ubacivanje koncepta u instrukcioni plan*/
    public void addConceptToPlan(String ID, int ordNumb) {

      if (iPlan.addConceptInPlan(ID)) {
        putConceptsInPlanToMemory(ID);
      }
    }

  public void addPassedConcepts(String cID) {
    iPlan.addPassedConcept(cID);
    addPassedConceptToRete(cID);
  }

/**dodaje u Jess koncepte koji su predjeni*/
  public void addPassedConceptToRete(String cID) {
    try {

      fpc = new Fact("passed_concepts", engine);
      fpc.setSlotValue("ID", new Value(cID, RU.STRING));
      engine.assertFact(fpc);
        }
    catch (JessException je) {
      System.out.println("ERROR addPassedConcepts ");
    }
  }

  /**dodaje koncept koji je prosao check_concept pravilo u plan koncepata i ubacuje ga u Jess memoriju
  *kao  (deftemplate concepts_added_in_plan
  * (slot ID (type INTEGER)))*/
  public void putConceptsInPlanToMemory(String cID) {
    try {
      fpcIP = new Fact("concepts_added_in_plan", engine);
      fpcIP.setSlotValue("ID", new Value(cID, RU.STRING));
      engine.assertFact(fpcIP);
    }
    catch (JessException je) {
      System.out.println("ERROR: putConceptsInPlanToMemory Function " +je.getMessage() );
    }
  }
  /** Salje referencu na Java objekat*/
   public void sendPointerToJess() {
     try {
      engine.store("pump-1", this);
       engine.executeCommand("(bind ?pok (fetch pump-1))");
         }
     catch (JessException je) {
      System.out.println("ERROR JessException " + je.getMessage());
     }
   }
public void setEngineReference(Rete en){
  engine=en;
  fRetr=new FactRetractor(engine);
  discPlanner.setFactRetractRef(fRetr);
}
/**  Okrece plan koncepata  */
public void turnAroundConceptPlan(){
  iPlan.turnVectorAround();
}
/**  Vrsi izbor koncepta koji ce biti trenutni tj. koji ce se prikazati studentu  */
public String selectCurrentConcept(){

  currentConceptID=iPlan.selectCurrentConcept();

    return currentConceptID;
}
  public void setStudActualSkillLev(double studActSkLev){
    this.studActualSkillLevel=studActSkLev;
  }
  /**Poziva se iz klase GlobalAssessment kada dodje do promena
   * ocene znanja studenta tj. karakteristike actualSkillLevel*/
  public void changeConceptPlan(){

    iPlan.cleanBothConceptPlans();
    fRetr.removeConceptsAddedInPlan();
    fRetr.removeStudentDataFromJess();
    discPlanner.addStudentData(studentID,studActualSkillLevel);

    discPlanner.createConceptPlan();

    try{


      engine.run();

    }catch(JessException je){
      je.printStackTrace();
    }

    discPlanner.turnConceptVector();

    //discPlanner.selectCurrentConcept();

  }
  public void setStudentId(int sid){
    studentID=sid;
  }
    private double studActualSkillLevel;
    private String teachingStrategy;
    private String learningStyle;
    private int detailLevel;
    private int conceptPrerequisite;
    private String conceptID;
    private int conceptMinKnowledgeLevel;
    private String conceptTitle;
    private ConceptInfo cInfo;
    private int studentID;
    private DiscoursePlanner discPlanner;
    private Rete engine;
     private Fact fpc;
     private Fact fpcIP;
      private int prereqVectCapacity; //ovo prebaciti u private
      private InstructionalPlan iPlan;
      private String currentConceptID;
      private FactRetractor fRetr;
}
