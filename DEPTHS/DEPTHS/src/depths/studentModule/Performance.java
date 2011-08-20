//Source file: E:\\MojiProjekti\\mag\\StudModel\\StudentModel\\StudentModel\\src\\StudentModule\\StudentModel\\Perfomance.java

package depths.studentModule;

import java.util.Date;

public class Performance
{
   private double initialSkillLevel;
   private double actualSkillLevel;
   private String learningStyle=new String();;
   private Date timeOfLastSession=new Date();;
   private int detailLevel;
   private String experienceLevel=new String();;
   private String reasoningLevel=new String();;
   private String programmingLanguage;

   /**
    * @roseuid 3FEECD1C02BE
    */
   public Performance()
   {

   }
   public void setProgrammingLanguage(String pl){
     this.programmingLanguage=pl;
   }
   public String getProgrammingLanguage(){
     return this.programmingLanguage;
   }

   public void setInitialSkillLevel(double s)
   {

     initialSkillLevel=s;
   }
   public double getInitialSkillLevel()
   {

     return initialSkillLevel;
   }

   public void setActualSkillLevel(double s)
   {
     actualSkillLevel=s;
   }
   public double getActualSkillLevel()
   {
     return actualSkillLevel;
   }

   public void setLearningStyle(String s)
      {
        learningStyle=s;
      }
      public String getLearningStyle()
      {
        return learningStyle;
      }

      public void setTimeOfLastSession(Date d)
         {
           timeOfLastSession=d;
         }
         public Date getTimeOfLastSession()
         {

           return timeOfLastSession;
         }

         public void setDetailLevel(int s)
            {
              detailLevel=s;
            }
            public int getDetailLevel()
            {
              return detailLevel;
            }

            public void setExperienceLevel(String s)
               {
                 experienceLevel=s;
               }
               public String getExperienceLevel()
               {
                 return experienceLevel;
               }

               public void setReasoningLevel(String s)
                  {
                    reasoningLevel=s;
                  }
                  public String getReasoningLevel()
                  {
                    return reasoningLevel;
                  }

}
