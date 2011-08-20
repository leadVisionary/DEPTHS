//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\UnitHistory.java

package depths.studentModule;

import java.util.*;
public class UnitHistory extends CommonHistory
{
  private Vector fragments;
  private int ordinalNumber;

   public UnitHistory(){

   }
   public UnitHistory(String uId)
   {
     this.setID(uId);

   }
   public void setOrdinalNumber(int ordNumb){
     ordinalNumber=ordNumb;
   }
   public int getOrdinalNumber(){
     return ordinalNumber;
   }

}
