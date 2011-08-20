package depths.adminModule;
import java.util.Vector;

public class DatabaseManager {
  private DatabaseAdminReader dbAdminReader=new DatabaseAdminReader();
  private DatabaseAdminWriter dbAdminWriter=new DatabaseAdminWriter();

  public DatabaseManager() {

  }
  public boolean checkUserName(String userName){

    boolean userNameExist=dbAdminReader.checkAdminUserName(userName);

    return userNameExist;
  }
  public boolean checkAdminPassword(String userName,String adminPassword){
    boolean passwordOK=dbAdminReader.checkAdminPassword(userName, adminPassword);
    return passwordOK;
  }
 public void  newAdminRegistration(Integer newAdminId,String fName,String lName,String uName,String email,
                      String pass,String addr,String city,int country,
                      String organisation,String webS,String lang,String privilegies){

   dbAdminWriter.newAdminRegistration(newAdminId,fName,lName, uName, email,pass,addr,city,
                                     country,organisation,webS,lang, privilegies);
 }
 public String checkAdminPrivilegies(Integer usId){
   String privil=dbAdminReader.checkAdminPrivilegies(usId);
   return privil;
 }
 public Vector readAllAdministrators(){
   Vector addminsIds=dbAdminReader.readAllAdministrators();
   return addminsIds;
 }
 public Vector readAllTeachers(){
   Vector teachersIds=dbAdminReader.readAllTeachers();
   return teachersIds;
 }

 public String getAdminsDataByAdminId(String dataType, int admId){

     String value=dbAdminReader.getAdminsDataByAdminId(dataType, admId);

     if (dataType.equals("countryId")){

       Integer x=new Integer(value);
       value=dbAdminReader.getCountryNameByCountryId(x.intValue());

     }else if (dataType.equals("languageId")){

     Integer x=new Integer(value);
     value=dbAdminReader.getLanguageNameByLanguageId(x.intValue());

   }

     return value;
   }
   public void removeAdminById(int adminId){

     dbAdminReader.removeAdminById(adminId);
   }
   public void removeTeacherById(int teacherId){
    Vector assistants=   dbAdminReader.getTeacherAssistants(teacherId);
    for (int i=0;i<assistants.size();i++){
        Integer asId=new Integer(assistants.get(i).toString());
        dbAdminReader.removeAssistant(asId.intValue());
    }

     dbAdminReader.removeTeacherById(teacherId);
   }

   public Vector getCountries(){
    Vector countries=dbAdminReader.getCountries();
    return countries;
  }
  public Vector getCountriesIds(){
    Vector countryShortcut = dbAdminReader.getCountriesIds();
    return countryShortcut;
  }
  public Vector getLanguages(){
    Vector languages=dbAdminReader.getLanguages();
    return languages;
  }
  public Vector getAdministrators(){
    Vector administrators=dbAdminReader.getAdministrators();
    return administrators;
  }
  public Vector readAllCourses() {
      Vector courses = dbAdminReader.readAllCourses();
      return courses;
  }
  public Vector getLanguagesIds(){
    Vector languageShortcut = dbAdminReader.getLanguagesIds();
    return languageShortcut;
  }

  public Vector getPrivilegiesIds(){
   Vector privilegieIds=dbAdminReader.getPrivilegiesIds();
   return privilegieIds;
 }
 public String getPrivilegieById(int privilegieId){
  String privilegie=dbAdminReader.getPrivilegieById(privilegieId);
  return privilegie;
}
public String getAdminDataById(String dataType,int adminId){

String name=  dbAdminReader.getAdminDataById(dataType,adminId);
  return name;
}
public String getCourseName(String id) {
  String value = dbAdminReader.getCourseName(id);

  return value;
}
public String getTeacherDataById(String dataType,int adminId){

String name=  dbAdminReader.getTeacherDataById(dataType,adminId);

  return name;
}
public String getAdminPrivilegieNameByAdminId(int adminId){

  String priv=dbAdminReader.getAdminPrivilegieNameByAdminId(adminId);
  return priv;
}
public void updateAdminData(int admId,String dataType,int newPrivilegieId){

  Integer v=new Integer(admId);
  Integer v2=new Integer(newPrivilegieId);
  dbAdminWriter.updateAdminData(admId,dataType,newPrivilegieId);
}
public void updateAdminData(String fName,String lName,String uName,String email,
        String password,String address,String city,int country,String organisation,
        String webSite,int language){
  dbAdminWriter.updateAdminData( fName, lName, uName, email,
        password, address, city, country, organisation,
         webSite, language);

}
  public boolean checkTeacherUserName(String uName){
      boolean val=dbAdminReader.checkTeacherUserName(uName);

      return val;
    }
    public void createNewTeacher(int teacherId,String fName,String lName,String uName,String email,
                             String passw,String address,String city,int countryId,
String organisation,String webS,int langId,int adminId){



  dbAdminWriter.createNewTeacher(teacherId,fName,lName,uName,email,passw,address,city,countryId,
organisation,webS,langId,adminId);
}
public String getNewTeacherDataByType(String dataType,String teacherUserName){
     String value=dbAdminReader.getNewTeacherDataByType(dataType,teacherUserName);
     return value;

   }
   public Vector getNewTeacherPrivilegies(int teacherId){

     Vector privilegies=dbAdminReader.getNewTeacherPrivilegies(teacherId);
     return privilegies;
   }

public void createNewTeacherPrivilegies(int teacherId,int privilegie){
//int privId= dbAdminReader.getPrivilegieId(privilegie);
  dbAdminWriter.createNewTeacherPrivilegies(teacherId,privilegie);
}
public Vector getTeachersPrivilegies(){
  Vector teacherPrivilegies=dbAdminReader.getTeachersPrivilegies();
  return teacherPrivilegies;
}
public String getTeacherPrivilegieNameById(int privilegieId){
   String name=dbAdminReader.getTeacherPrivilegieNameById(privilegieId);
   return name;
 }
 public Vector getTeacherPrivilegies(int teachId){
   Vector teacherPrivilegies=dbAdminReader.getTeacherPrivilegies(teachId);
   return teacherPrivilegies;
 }
 public boolean checkIfGroupExists(String groupName) {

        boolean returnValue=dbAdminReader.checkIfGroupExists(groupName);

        return returnValue;
  }
  public void setGroupData(int groupId,String groupName,int langId,String description){
    dbAdminWriter.setGroupData(groupId,groupName, langId, description);
  }

  public void setGroupAdministrator(int groupId,int adminId){
      dbAdminWriter.setGroupAdministrator(groupId,adminId);
  }
  public void setGroupTeacher(int groupId,int teacherId){
      dbAdminWriter.setGroupTeacher(groupId,teacherId);
  }
  public void setGroupCourse(int groupId,String courseId){
    dbAdminWriter.setGroupCourse(groupId,courseId);
  }
  public String getNewGroupDataByType(String dataType,int groupId){
        String value=dbAdminReader.getNewGroupDataByType(dataType,groupId);
        return value;
  }
  public Vector getNewGroupVectorData(String dataType,int groupId){
        Vector v;
        String sql="";
        if (dataType.equals("administrators")){

            sql = "SELECT * FROM administrator_has_groups WHERE groupId=" +groupId + ";";

        }else if (dataType.equals("teachers")){

             sql = "SELECT * FROM teacher_has_groups "+
                   "WHERE groupId="+groupId+";";

        }else if (dataType.equals("courses")){

            sql = "SELECT * FROM group_has_course "+
                  "WHERE groupId="+groupId + ";";
        }
        v=dbAdminReader.getNewGroupVectorData(dataType,groupId,sql);
        return v;
  }
  public String getGroupLanguageById(int groupId){
      String value=dbAdminReader.getGroupLanguageById(groupId);
      return value;
}
  public Vector readAllGroups(){
    Vector allGroupsIds = dbAdminReader.readAllGroups();
    return allGroupsIds;
}
public void removeGroupById(int groupId){
    dbAdminReader.removeGroupById(groupId);
}
public boolean checkIfTeacherAlreadyHavePrivilegie(int teacherId,int privilegieId){
    boolean val=dbAdminReader.checkIfTeacherAlreadyHavePrivilegie(teacherId,privilegieId);
    return val;
}
public void removeAllTeacherPrivilegies(int teacherId){
    dbAdminReader.removeAllTeacherPrivilegies(teacherId);
}
public Vector getCourses(){
    Vector coursesIds=dbAdminReader.getCourses();
    return coursesIds;
}
public void setCourseForTeacher(String courseId,int teacherId){
    dbAdminWriter.setCourseForTeacher(courseId,teacherId);

}


}
