package depths.teacherModule;
import java.util.Vector;
import java.util.Date;

public class DatabaseManager {
    public boolean checkTeacherUserName(String userName){

        boolean userNameExist=dbTeacherReader.checkTeacherUserName(userName);

        return userNameExist;
  }
  public boolean checkTeacherPassword(String teacherUserName,String teacherPassword){
    boolean passwordOK=dbTeacherReader.checkTeacherPassword(teacherUserName, teacherPassword);
    return passwordOK;
  }
public Vector checkTeacherPrivilegies(int teachId){
    Vector val=dbTeacherReader.checkTeacherPrivilegies(teachId);
    return val;
}
public boolean checkNewAssistantUserName(String uName){
      boolean val=dbAssistantReader.checkNewAssistantUserName(uName);

      return val;
    }
    public Vector getAssistantsPrivilegies(){
        Vector assistantPrivilegies=dbAssistantReader.getAssistantPrivilegies();
  return assistantPrivilegies;
    }
    public String getAssistantPrivilegieNameById(int privilegieId){
        String name=dbAssistantReader.getAssistantPrivilegieNameById(privilegieId);
   return name;
    }
    public Vector     getTeacherGroupsIds(int teacherId){
       Vector teachGroupsIds=dbAssistantReader.getTeacherGroupsIds(teacherId);
       return teachGroupsIds;
   }
   public String getGroupNameById(int groupId){
       String name=dbAssistantReader.getGroupNameById(groupId);
       return name;
   }
   public void createNewAssistant(String fName,String lName,int assistantId,String uName,
                                  String email,String passw,String address,
                                  String city,int countryId,String organisation,
                                 String webS,int langId,int teacherId){
      dbAssistantWriter.createNewAssistant(fName,lName,assistantId,uName,
                                           email,passw,address,city,countryId,
                                           organisation,webS,langId,teacherId);

  }
  public void setAssistantPrivilegie(int assistantId,int privilegieId){
       dbAssistantWriter.setAssistantPrivilegie(assistantId,privilegieId);
   }
   public void setAssistantGroup(int assistantId,int groupId){
       dbAssistantWriter.setAssistantGroup(assistantId,groupId);
   }
   public String getNewAssistantDataByType(String dataType,int assistantId){
       String value=dbAssistantReader.getNewAssistantDataByType(dataType,assistantId);
       return value;
   }
   public Vector getNewAssistantPrivilegies(int assistantId){
          Vector privilegies=dbAssistantReader.getNewAssistantPrivilegies(assistantId);
          return privilegies;
   }
   public Vector getNewAssistantGroups(int assistantId){
          Vector groups=dbAssistantReader.getNewAssistantGroups(assistantId);
          return groups;
   }
   public Vector readAllAssistants(int teacherId){
       Vector allAssistantsIds=dbAssistantReader.readAllAssistants(teacherId);
       return allAssistantsIds;
}
   public void removeAssistantById(int assistantId){
    dbAssistantReader.removeAssistantById(assistantId);
}
public void removeAllAssistantPrivilegies(int assistantId){
    dbAssistantReader.removeAllAssistantPrivilegies(assistantId);
}
public void removeAllAssistantGroups(int assistantId){
    dbAssistantReader.removeAllAssistantGroups(assistantId);
}
public boolean checkStudentUserName(String uName){
    boolean value=dbStudentReader.checkNewStudentUserName(uName);
    return value;
}
public void createNewStudent(String fName,String lName,String uName,int studentId,
                             String email,String passw,String address,
                             String city,int countryId,String organisation,
                             String webS,int langId){

    dbStudentWriter.createNewStudent(fName,lName,uName,studentId,email,passw,address,city,countryId,organisation,webS,langId);

}
public void settingStudentPerformances(int studentId,double inSkLevel,int detailLevel,String programmingLanguage,String displayForm){
    dbStudentWriter.settingStudentPerformances(studentId,inSkLevel,detailLevel,programmingLanguage,displayForm);
}
public void settingStudentGroup(int studentId,int groupId){
    dbStudentWriter.settingStudentGroup(studentId,groupId);
}
public String getStudentDataByType(String dataType,int studentId){
    String value=dbStudentReader.getStudentDataByType(dataType,studentId);
    return value;
}
public Vector getTeacherCoursesIds(int teacherId){
    Vector courses=dbTeacherReader.getTeacherCoursesIds(teacherId);
    return courses;
}
public String getCourseNameById(String courseId){
    String name="";
    name=dbTeacherReader.getCourseNameById(courseId);
    return name;

}
public Vector readAllStudents(int teacherId){
    Vector studentsIds=new Vector();
    Vector groupsIds=dbAssistantReader.getTeacherGroupsIds(teacherId);
    int groupsNumb=groupsIds.size();
    for (int i=0;i<groupsNumb;i++){
        Vector studentsInGroup=new Vector();
       Integer grId=new Integer( groupsIds.get(i).toString());
       int groupId=grId.intValue();
       studentsInGroup=dbStudentReader.getStudentsIdsInGroup(groupId);
       int numbOfStud=studentsInGroup.size();
       for (int s=0;s<numbOfStud;s++){
           String stId=studentsInGroup.get(s).toString();
           studentsIds.add(stId);
       }
       studentsInGroup.clear();
    }

    return studentsIds;
}
public Vector readAllStudentsInGroup(String groupSection){
    int grId=dbStudentReader.getGroupIdByName(groupSection);
    Vector studentsIds=dbStudentReader.getStudentsIdsInGroup(grId);
    return studentsIds;
}
public void setCourseData(int studentId,String courseId,Date date,int groupId){

    dbStudentWriter.setCourseData(studentId,courseId,date,groupId);
}
public Vector getCoursesForGroup(int groupId){
    Vector courses=dbStudentReader.getCourseIdsForGroup(groupId);
    return courses;
}
public String getCourseIdByName(String course){
    String courseId=dbStudentReader.getCourseIdByName(course);
    return courseId;
}
public String[] getConceptsTitlesInTheCourse(String courseId){
    Vector concepts=dbStudentReader.getConceptsTitlesInTheCourse(courseId);
    String [] conceptTitles=new String[concepts.size()];
    for (int i=0;i<concepts.size();i++){
        conceptTitles[i]=concepts.get(i).toString();
    }
    return conceptTitles;
}
public String getConceptIdByName(String courseId,String conceptName){
     String concId=dbStudentReader.getConceptIdByName(courseId,conceptName);
     return concId;
  }
  public double getConceptsDegrees(String courseId,String concId){

      double degree=dbStudentReader.getConceptsDegrees(courseId,concId);
      return degree;
  }
  public double getConceptsDegrees(String courseId,String concId,int groupId){

      Vector studentsIds=dbStudentReader.getIdStudentsInCourseFromCourseHasStudents(groupId);
     double averageForConcept=0.0;
     int numbOfStud=studentsIds.size();
     int divider=numbOfStud;
      for (int i=0;i<numbOfStud;i++){
          Integer stId=new Integer(studentsIds.get(i).toString());
          int IdStudentInCourse=stId.intValue();

          double averageForStudentAndConcept=dbStudentReader.getConceptsDegreesForGroup(concId,IdStudentInCourse);
          if (averageForStudentAndConcept==0.0){
              divider--;
          }
          averageForConcept=averageForConcept+averageForStudentAndConcept;

      }
      if (divider==0){
          averageForConcept=0.0;
      }else{
          averageForConcept = averageForConcept / divider;
      }
      return averageForConcept;
  }
  public double getConceptsKnowledgeLevel(String courseId,String concId){

      double degree=dbStudentReader.getConceptsKnowledgeLevel(courseId,concId);
      return degree;
  }
  public double getConceptsKnowledgeLevel(String courseId,String concId,int groupId){



      Vector studentsIds=dbStudentReader.getIdStudentsInCourseFromCourseHasStudents(groupId);
     double averageKnowledgeLevelForConcept=0.0;
     int numbOfStud=studentsIds.size();
     int divider=numbOfStud;
      for (int i=0;i<numbOfStud;i++){
          Integer stId=new Integer(studentsIds.get(i).toString());
          int IdStudentInCourse=stId.intValue();

          double averageForStudentAndConcept=dbStudentReader.getConceptsKnowledgeLevelForGroup(concId,IdStudentInCourse);

          if (averageForStudentAndConcept==0.0){

              divider--;
          }
          averageKnowledgeLevelForConcept=averageKnowledgeLevelForConcept+averageForStudentAndConcept;
      }
      if (divider==0){
          averageKnowledgeLevelForConcept=0.0;
      }else{
          averageKnowledgeLevelForConcept = averageKnowledgeLevelForConcept /
                                            divider;
      }
      return averageKnowledgeLevelForConcept;
  }


  public int getGroupIdByName(String groupName){

   int groupId = dbStudentReader.getGroupIdByName(groupName);
   return groupId;
}
    public Vector getStudentIdInCourse(int groupId){

       Vector studIdsInCourse=dbStudentReader.getIdStudentsInCourseFromCourseHasStudents(groupId);
       return studIdsInCourse;
   }
   public double getConceptsDegreesForStudent(String courseId,String concId,int idStudInCourse){
           double value=dbStudentReader.getConceptsDegreesForStudent(courseId,concId,idStudInCourse);
           return value;
    }
    public String getStudentNameByStudentInCourse(int studentInCourse){
        int studentId=dbStudentReader.getStudentIdByStudentInCourse(studentInCourse);
        String firstName = dbStudentReader.getStudentDataByType("lastName",studentId);
        String lastName=dbStudentReader.getStudentDataByType("firstName",studentId);
        String studentName=lastName+" "+firstName;
        return studentName;
    }
    public Vector getPassedConceptsForStudent(String courseId,int studId){
        int studentInCourseId=dbStudentReader.getIdStudentInCourseForStudent(courseId,studId);
        System.out.println("DatabaseManager studentInCourse="+studentInCourseId);
            Vector passedConcepts=dbStudentReader.getPassedConceptsForStudent(studentInCourseId);
            return passedConcepts;
    }
    public double getConceptDegreesForStudent(String courseId,int studentId,
                                              String conceptId){
        int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studentId);
        double degree=dbStudentReader.getConceptDegreesForStudent(idStudentInCourse,conceptId);
              return degree;
    }
    public double getStudentPassedConceptActualSkillLevel(String courseId,
            int studId,String concId){
        int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studId);
        double actSkLev=dbStudentReader.getStudentPassedConceptActualSkillLevel(idStudentInCourse,concId);
        return actSkLev;
     }

    public String getConceptName(String courseId,String concId){
        String cName=dbStudentReader.getConceptName(courseId,concId);
        return cName;
     }
     public Vector   getPassedLessonsInConceptForStudent(String courseId,
            int studId,String conceptId){
        int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studId);
        int idConceptInCourseForStudent=dbStudentReader.getIdConceptInCourseForStudent(idStudentInCourse,conceptId);
        Vector lessons=dbStudentReader.getPassedLessonsInConceptForStudent(idConceptInCourseForStudent);
    return lessons;
}
public String getLessonNameById(String concId,String lessonId){
    String lName = dbStudentReader.getLessonNameById(concId, lessonId);
    return lName;
}
public int getLessonNumberOfPassess(String courseId,int studentId,
                                        String conceptId,String lessonId){
        int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studentId);
        int idConceptInCourseForStudent=dbStudentReader.getIdConceptInCourseForStudent(idStudentInCourse,conceptId);
        int numb=dbStudentReader.getLessonNumberOfPassess(idConceptInCourseForStudent,lessonId);
        return numb;
    }
    public Vector getPassedTestsInConceptForStudent(String courseId,
        int studentId,String conceptId){
    int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studentId);
        int idConceptInCourseForStudent=dbStudentReader.getIdConceptInCourseForStudent(idStudentInCourse,conceptId);
    Vector tests=dbStudentReader.getPassedTestsInConceptForStudent(idConceptInCourseForStudent);
    return tests;
}
public String getQuestionTruth(String courseId,
                               int studId,String conceptId,String testId,String questionId){
    int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studId);
        int idConceptInCourseForStudent=dbStudentReader.getIdConceptInCourseForStudent(idStudentInCourse,conceptId);
        int idTestInConceptForStudent=dbStudentReader.getIdTestInConceptForStudent(idConceptInCourseForStudent,testId);
    String truth=dbStudentReader.getQuestionTruth(idTestInConceptForStudent,questionId);
    return truth;
}
public Vector getQuestionsInTest(String courseId,
                                 int studentId,String conceptId,String testId){
    int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studentId);
        int idConceptInCourseForStudent=dbStudentReader.getIdConceptInCourseForStudent(idStudentInCourse,conceptId);
    Vector questions=dbStudentReader.getQuestionsInTest(idConceptInCourseForStudent,testId);
    return questions;
}
public String getQuestContent(String courseId,String qid){
    String content=dbStudentReader.getQuestionContent(courseId,qid);
    return content;
}

public int getConceptDuration(String courseId,int studentId,String concId){
    int idStudentInCourse=dbStudentReader.getIdStudentInCourseForStudent(courseId,studentId);
    int dur=dbStudentReader.getConceptDuration(idStudentInCourse,concId);
    return dur;
}
public String getQuestionContent(String courseId,String qid){
    String content=dbStudentReader.getQuestionContent(courseId,qid);
    return content;
}



  /**
   * @label Uses
   * @clientCardinality 0..*
   * @supplierCardinality 1
   */
  private DatabaseTeacherReader dbTeacherReader = new DatabaseTeacherReader();
  private DatabaseAssistantReader dbAssistantReader = new DatabaseAssistantReader();
  private DatabaseAssistantWriter dbAssistantWriter=new DatabaseAssistantWriter();
  private DatabaseStudentReader dbStudentReader=new DatabaseStudentReader();
  private DatabaseStudentWriter dbStudentWriter=new DatabaseStudentWriter();
}
