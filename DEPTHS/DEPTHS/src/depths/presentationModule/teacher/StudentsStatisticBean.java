package depths.presentationModule.teacher;
//import depths.presentationModule.teacher.charts.StudentsHitChart;
import depths.teacherModule.DatabaseManager;
import java.util.Vector;
public class StudentsStatisticBean {
    private DatabaseManager dbManager;
    private int duration=0,hours=0,mins=0,secs=0;

    public StudentsStatisticBean() {
    }

   public String[] getConceptsTitles(String courseId){
       String [] concepts=dbManager.getConceptsTitlesInTheCourse(courseId);
       return concepts;
   }
  public double getConceptsDegrees(String courseId,String concId){
      double degree=dbManager.getConceptsDegrees(courseId,concId);
      return degree;
  }
  public double getConceptsDegrees(String courseId,String concId,int groupId){
      double degree=dbManager.getConceptsDegrees( courseId, concId, groupId);
      return degree;
  }
  public double getConceptsKnowledgeLevel(String courseId,String concId){
      double degree=dbManager.getConceptsKnowledgeLevel(courseId,concId);
      return degree;
  }
  public double getConceptsKnowledgeLevel(String courseId,String concId,int groupId){
      double degree=dbManager.getConceptsKnowledgeLevel( courseId, concId, groupId);
      return degree;
  }
  public String getConceptIdByName(String courseId,String conceptName){
      String concId=dbManager.getConceptIdByName(courseId,conceptName);
      return concId;
  }
public void   setDbManagerReg(DatabaseManager dbManRef){
    dbManager=dbManRef;
}
public int getGroupIdByName(String groupName){
   int groupId =dbManager.getGroupIdByName(groupName);

   return groupId;
}
    public String getGroupNameById(int groupId){
        String name=dbManager.getGroupNameById(groupId);
        return name;
    }

    public int[] getStudentIdInCourse(int groupId){

        String grId=String.valueOf(groupId);
        Vector students=dbManager.getStudentIdInCourse(groupId);
        int [] studs=new int[students.size()];
        for (int i=0;i<students.size();i++){
            Integer stId=new Integer(students.get(i).toString());
            studs[i]=stId.intValue();

        }
        return studs;

    }
    public double getConceptsDegreesForStudent(String courseId,String concId,int idStudInCourse){
        double value=dbManager.getConceptsDegreesForStudent(courseId,concId,idStudInCourse);
        return value;
    }
    public String getStudentNameByStudentInCourse(int studentInCourse){
        String studentName = dbManager.getStudentNameByStudentInCourse(studentInCourse);
        return studentName;
    }
    public Vector getPassedConceptsForStudent(String courseId,int studId){

        Vector passedConcepts=dbManager.getPassedConceptsForStudent(courseId,studId);

        return passedConcepts;
    }
    public double getStudentPassedConceptDegreeOfMast(String courseId,
            int studentId,String conceptId){
        double degree=dbManager.getConceptDegreesForStudent(courseId,studentId,conceptId);

        return degree;
    }
    public double getStudentPassedConceptActualSkillLevel(String courseId,
            int studId,String concId){
        double actSkLev=dbManager.getStudentPassedConceptActualSkillLevel(courseId,studId,concId);
        return actSkLev;
     }
    public String getConceptNameById(String courseId,String concId){
        String cName=dbManager.getConceptName(courseId,concId);
        return cName;

    }
public Vector   getPassedLessonsInConceptForStudent(String courseId,
            int studId,String conceptId){
        Vector lessons=dbManager.getPassedLessonsInConceptForStudent(courseId,studId,conceptId);
    return lessons;
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
    public String getLessonNameById(String concId,String lessonId){
        String lName=dbManager.getLessonNameById(concId,lessonId);
        return lName;
    }
    public int getLessonNumberOfPassess(String courseId,int studentId,
                                        String conceptId,String lessonId){
        int numb=dbManager.getLessonNumberOfPassess(courseId,studentId,conceptId,lessonId);
        return numb;
    }

    public String getPassedConceptRating(double passConcDegree){
        String ratingPictureName="rating-1.gif";
        if(passConcDegree<1.5){
          ratingPictureName="rating-1.gif";
        }else if(passConcDegree<2.5){
          ratingPictureName="rating-2.gif";
        }else if(passConcDegree<3.5){
          ratingPictureName="rating-3.gif";
        }else if(passConcDegree<4.5){
          ratingPictureName="rating-4.gif";
        }else {
          ratingPictureName="rating-5.gif";
        }
       return ratingPictureName;
  }
public int getConceptDuration(String courseId,int studentId,String concId){
    int dur=dbManager.getConceptDuration(courseId,studentId,concId);            ;
      hours=dur/3600;
      int remain=dur%3600;
      mins=remain/60;
      int r=remain%60;
      secs=r;

    return duration;
}
public int getHours(){

    return hours;
}
public int getMins(){

    return mins;
}
public int getSecs(){

    return secs;
}
public Vector getPassedTestsInConceptForStudent(String courseId,
        int studentId,String conceptId){
    Vector tests=dbManager.getPassedTestsInConceptForStudent(courseId,studentId,
            conceptId);
    return tests;
}
public String getQuestionTruth(String courseId,
                               int studId,String conceptId,String testId,String questionId){
    String truth=dbManager.getQuestionTruth(courseId,studId,conceptId,testId,questionId);
    return truth;
}
public double getTestDegreeOfMastery(String courseId,
                                     int studId,String conceptId,String testId){
    double degree=0.0;
    return degree;

}
public int getTestPointsNumber(String courseId,
                               int studId,String conceptId,String testId){
    int points=0;
    return points;
}
public int getTestDifficultyFactor(String courseId,
                                   int studId,String conceptId,String testId){
    int factor=0;
    return factor;
}
public double getTestSuccess(String courseId,
                             int studId,String conceptId,String testId){
    double success=0.0;
    return success;
}
public int getTestDuration(String courseId,
                           int studId,String conceptId,String testId){
    int duration=0;
    return duration;
}
public Vector getQuestionsInTest(String courseId,
                                 int studentId,String conceptId,String testId){
    Vector questions=dbManager.getQuestionsInTest(courseId,studentId,conceptId,testId);
    return questions;
}
public String getSlider2Val(double actualSkillLevel){
    String slider2="";
      if (actualSkillLevel<1.5){
        slider2="sliderG_1.jpg";
      }else if (actualSkillLevel<2.5){
       slider2="sliderG_2.jpg";
      }else if (actualSkillLevel<3.5){
        slider2="sliderG_3.jpg";
      }else if (actualSkillLevel<4.5){
       slider2="sliderG_4.jpg";
      }else {
        slider2="sliderG_5.jpg";
      }
    return slider2;
}
public String getActualSkillLevelText(double actualSkillLevel){
    String actualSkillLevelText="";
      if (actualSkillLevel<1.5){
        actualSkillLevelText="Bad";
       }else if (actualSkillLevel<2.5){
        actualSkillLevelText="Not bad";
      }else if (actualSkillLevel<3.5){
        actualSkillLevelText="Good";
      }else if (actualSkillLevel<4.5){
        actualSkillLevelText="Very good";
      }else {
        actualSkillLevelText="Excellent";
       }
    return actualSkillLevelText;

}

public String getQuestContent(String courseId,String qid){
    String content=dbManager.getQuestionContent(courseId,qid);
    return content;
}
public double[] getConceptsDegrees(String courseId,int studentId){
    double[]degrees=new double[10];
    return degrees;
}
public double[] getActualKnowledgeLevel(String courseId,int studentId){
    double[] knLev=new double[10];
    return knLev;
}

}
