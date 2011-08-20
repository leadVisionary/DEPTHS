//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\CommonHistory.java

package depths.studentModule;
import java.util.Date;

import java.util.Calendar;
public abstract class CommonHistory
{

   private Date started;
   private int duration;
   private Date finished;
   private int numberOfPasses=0;
   private String title;
   private String ID;
   private String reference;

   public CommonHistory()
   {
   }
   public void setTimeElement(String el,Date val){
     if (el.equals("started")){
       this.setStarted(val);
     }else if (el.equals("finished")){
       this.setFinished(val);
     }

   }
   /**    */
   public void setStarted(Date st)
   {
     this.started = st; }

   /**    */
   public Date getStarted()
   { return started; }

   /**    */
   public void setFinished(Date fn)
   {


     this.finished = fn; }

   public int getDuration(){ return duration; }

   public void setDuration(int duration){ this.duration = duration; }


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

   /**    */
   public Date getFinished()
   { return finished; }
   /**    */
   public void setNumberOfPasses(int np)
   {

     numberOfPasses=np;    }

   /**    */
   public int getNumberOfPasses()

   {

     return numberOfPasses;
   }

   /**    */
   public void setTitle(String tit)
   {

         title=tit;
   }
   /**    */
   public String getTitle()
   {

     return title;    }

   /**        */
   public void setID(String id)
   {       ID=id;    }

   public String getID()
   {     return ID;    }
   public void setReference(String r)
   {     reference=r;    }
   public String getReference()
   {      return reference;    }

   public void addGeneralElement(String elem,String val)
   {
     String element=elem;
     String value=val;

     if (element.equals("numberOfPasses"))
     {
       setNumberOfPasses(Integer.parseInt(value));

     }else if (element.equals("title"))
     {
       setTitle(value);

     }else if (element.equals("ID"))
     {
       setID(value);

     } else if (element.equals("reference"))
     {
       setReference(value);

     }
   }
}
