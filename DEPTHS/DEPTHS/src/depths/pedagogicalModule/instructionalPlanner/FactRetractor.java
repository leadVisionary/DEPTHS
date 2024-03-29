/* Generated by Together */

package depths.pedagogicalModule.instructionalPlanner;
import jess.*;
import java.util.*;
public class FactRetractor {

  public FactRetractor(Rete eng) {
    engine=eng;
  }

  public Deftemplate getDeftemplateByName(String name) {

    Iterator itt=engine.listDeftemplates();

    Deftemplate deftemp=null;

    while (itt.hasNext()){

      Deftemplate next= (Deftemplate) itt.next();

      if (next.getName().equals(name)){

        deftemp=next;

      }
    }
    return deftemp;
  }

  public void retractAllFactsOfType(Deftemplate deftemplate) {
    try{
      Iterator itt=engine.listFacts();
      while(itt.hasNext()){
        Fact fact=(Fact) itt.next();
        if(fact.getDeftemplate().equals(deftemplate)){
          engine.retract(fact);

        }
      }
    }catch (JessException jex){
      jex.printStackTrace(System.err);
    }
  }
  public void removeQuestionFromJess(String currConc, int group){

           Context context=engine.getGlobalContext();
               try {

                   Funcall f = new Funcall("retract_question", engine);
                   ValueVector vv = new ValueVector();
                   Value c = new Value(currConc, RU.STRING);
                   Value g = new Value(group, RU.INTEGER);
                   vv.add(c);
                   vv.add(g);


                   f.addAll(vv);
                   f.execute(context);
               }

              catch (NoSuchElementException ex) {
                   System.out.println("ERROR  : NoSuchElementException");

           }

               catch (JessException je) {
                   System.out.println("ERROR  : JessException " + je.getMessage());
               }

     }

  public void removeConceptsAddedInPlan(){

    Deftemplate deftemplate=getDeftemplateByName("MAIN::concepts_added_in_plan");

    retractAllFactsOfType(deftemplate);

  }
  public void removeStudentDataFromJess(){
    Deftemplate deftemplate=getDeftemplateByName("MAIN::student");
    retractAllFactsOfType(deftemplate);

  }

  private Rete engine;


}
