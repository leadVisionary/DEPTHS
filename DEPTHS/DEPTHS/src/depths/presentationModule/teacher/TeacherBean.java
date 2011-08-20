package depths.presentationModule.teacher;

import depths.teacherModule.DatabaseManager;
import java.util.Vector;
import java.util.Date;
public class TeacherBean {
    public TeacherBean() {
    }
    public String getTeacherUserName(){
        return teacherUserName;
    }
    public void setTeacherUserName(String teachUserName){
            this.teacherUserName= teachUserName;
        }
    public String getTeacherPassword(){
        return teacherPassword;
    }
    public void setTeacherPassword(String teacherPassword){
            this.teacherPassword= teacherPassword;
        }
        public boolean checkTeacherData() {
           boolean isPasswordGood = false;
           this.checkTeacherName();
           if (this.teacherNameExist) {
             isPasswordGood = this.checkTeacherPassword();
           }
           else {
               this.teacherNameExist=false;
               teacherUserNameChecked = false;
             System.out.println("ERROR: Username does not exist. Please register!");
           }
           return isPasswordGood;
    }
    //proverava dali izabrano korisnicko ime vec postoji u bazi podataka
 public boolean checkTeacherName() {

   if (!teacherUserNameChecked) {
     if (!this.getTeacherUserName().equals("")) {
       teacherNameExist = dbManager.checkTeacherUserName(teacherUserName);
     }
     if (!teacherNameExist) {
       teacherUserNameChecked = true;
     }
   }
   return teacherNameExist;
 }
 //proverava da li password odgovara korisniku
   public boolean checkTeacherPassword() {
     boolean passwordOK = dbManager.checkTeacherPassword(this.teacherUserName,
         this.teacherPassword);
     return passwordOK;
  }
  public void teacherRegistration() {
      Integer tId=new Integer(teacherUserName.hashCode());
        this.teacherId = tId.intValue();
  }
  //proverava administratorske privilegije
    public void setTeacherPrivilegies() {
      String privil = "";
      privilegies = dbManager.checkTeacherPrivilegies(teacherId);
  }
public Vector  getTeacherPrivilegies(){
    return privilegies;
}
public boolean isTeacherUserNameExist(){
    return false;//ovo treba doraditi
}
public boolean checkNewAssistantUserName(String uName){
    boolean val = dbManager.checkNewAssistantUserName(uName);
    this.setAssistantUserNameExist(val);
    return val;
}
public void setAssistantUserNameExist(boolean val){
    this.assistantUserNameExist=val;
}
public boolean    checkPasswords(String passw,String passwConf){
  boolean passwOK=false;
  if (passw.equals(passwConf)){
    passwOK=true;
  }else{
    passwOK=false;
  }
  return passwOK;
}
    public void createNewAssistant(String fName,String lName,String uName,
                           String email,String passw,String address,
                           String city,int country,
                           String organisation,String webS,int lang){

    this.newAssistantFirstName=fName;
    this.newAssistantLastName=lName;
    this.newAssistantUserName=uName;
    this.newAssistantEmail=email;
    this.newAssistantPassword=passw;
    this.newAssistantAddress=address;
    this.newAssistantCity=city;
    this.newAssistantCourtryId=country;
    this.newAssistantOrganisation=organisation;
    this.newAssistantWebSite=webS;
    this.newAssistantLanguage=lang;
    Integer x=new Integer(uName.hashCode());
    this.newAssistantId=x.intValue();

dbManager.createNewAssistant(fName,lName,this.newAssistantId,uName,email,
                                 passw,address,city,country,organisation,
                                 webS,lang,this.teacherId);


}
public void getAssistantPrivilegies(){

}
 public int getNumberOfAssistantsPrivilegies(){
     assistantPrivilegiesIds=dbManager.getAssistantsPrivilegies();
     int size=assistantPrivilegiesIds.size();
     return size;
 }
 public int getAssistantPrivilegieIdByOrdNumb(int i){
     Integer x=new Integer( this.assistantPrivilegiesIds.get(i).toString());
 return x.intValue();
 }
public String getAssistantPrivilegieNameById(int privilegieId){
    String name=dbManager.getAssistantPrivilegieNameById(privilegieId);
   return name;
}
    public int getTeacherId(){
        return teacherId;
    }
    public void setTeacherId(int teacherId){
            this.teacherId= teacherId;
        }
   public Vector     getTeacherGroupsIds(int teacherId){
       Vector teachGroupsIds=dbManager.getTeacherGroupsIds(teacherId);
       return teachGroupsIds;
   }
   public String getGroupNameById(int groupId){
       String name=dbManager.getGroupNameById(groupId);
       return name;
   }
   public void setAssistantPrivilegie(int assistantId,int privilegieId){
       dbManager.setAssistantPrivilegie(assistantId,privilegieId);
   }
   public void setAssistantGroup(int assistantId,int groupId){
       dbManager.setAssistantGroup(assistantId,groupId);
   }
   public String getNewAssistantDataByType(String dataType,int assistantId){
       String value=dbManager.getNewAssistantDataByType(dataType,assistantId);
       if (value.equals("")){
           value="-not set-";
       }
       return value;
   }
   public Vector getNewAssistantPrivilegies(int assistantId){
       Vector privilegies=dbManager.getNewAssistantPrivilegies(assistantId);
       return privilegies;
   }
   public Vector getNewAssistantGroups(int assistantId){
       Vector groups=dbManager.getNewAssistantGroups(assistantId);
       return groups;
   }
public void readAllAssistants(){
    this.allAssistantsIds=dbManager.readAllAssistants(this.teacherId);
}
public int getAssistantsNumb(){
    return this.allAssistantsIds.size();
}
public int getAssistantIdByOrdNum(int i){
    Integer aId=new Integer(this.allAssistantsIds.get(i).toString());

    return aId.intValue();
}
public void removeAssistantById(int assistantId){
    dbManager.removeAssistantById(assistantId);
}
public void removeAllAssistantPrivilegies(int assistantId){
    dbManager.removeAllAssistantPrivilegies(assistantId);
}
public void removeAllAssistantGroups(int assistantId){
    dbManager.removeAllAssistantGroups(assistantId);
}
public boolean isStudentUserNameExist(){
    return studentUserNameExist;
}
public boolean checkStudentUserName(String uName){
    boolean value=dbManager.checkStudentUserName(uName);
    return value;
}
public void createNewStudent(String fName,String lName,String uName,
                             String email,String passw,String address,
                             String city,int countryId,String organisation,
                             String webS,int langId){
    Integer usId=new Integer(uName.hashCode());
    int studentId=usId.intValue();
    dbManager.createNewStudent(fName,lName,uName,studentId,email,passw,address,city,countryId,organisation,webS,langId);

}
public void settingStudentPerformances(int studentId,String knowLevel,String detailLevel,String programmingLanguage,String displayForm){
    double knLev=0.0;
    int detLev=0;
    if(knowLevel.equals("Begginer")){
        knLev=1.0;
    }else if(knowLevel.equals("Intermediate")){
        knLev=3.0;
    }else{
        knLev=5.0;
    }
    if (detailLevel.equals("Low")){
        detLev=1;
    }else if (detailLevel.equals("Middle")){
        detLev=2;
    }else{
        detLev=3;
    }
    dbManager.settingStudentPerformances(studentId,knLev,detLev,programmingLanguage,displayForm);
}
public void settingStudentGroup(int studentId,int groupId){
    dbManager.settingStudentGroup(studentId,groupId);
}
public String getStudentDataByType(String dataType,int studentId){
    String value=dbManager.getStudentDataByType(dataType,studentId);
    return value;
}
public Vector getTeacherCoursesIds(int teacherId){
    Vector courses=dbManager.getTeacherCoursesIds(teacherId);
    return courses;
}
public String getCourseNameById(String courseId){
    String name="";
    name=dbManager.getCourseNameById(courseId);
    return name;

}
public Vector readAllStudents(int teacherId){
    Vector studentsIds=dbManager.readAllStudents(teacherId);
    return studentsIds;
}
public Vector readAllStudentsInGroup(String groupSection){
    Vector studentsIds=dbManager.readAllStudentsInGroup(groupSection);
    return studentsIds;
}
public void setCourseData(int studentId,String courseId,Date date,int groupId){
    System.out.println("TeacherBean setCourseData studentId="+studentId+" courseId="+courseId+" groupId="+groupId);
    dbManager.setCourseData(studentId,courseId,date,groupId);
}
public Vector getCoursesForGroup(int groupId){
Vector courses=    dbManager.getCoursesForGroup(groupId);
    return courses;
}
public DatabaseManager getDatabaseManagerRef(){
    return dbManager;
}
public String getCourseIdByName(String course){
    String courseId=dbManager.getCourseIdByName(course);
    return courseId;
}
public void removeStudentById(int studentId){
    System.out.println("Ova funkcija treba da obrise sve podatke o studentu id="+studentId);
}
    private String teacherUserName;
    private String teacherPassword;
    boolean teacherNameExist = false;
    boolean studentUserNameExist=false;
    boolean assistantUserNameExist = false;
    private boolean teacherUserNameChecked = false;
    private Vector privilegies=new Vector();
    private DatabaseManager dbManager = new DatabaseManager();
    private String newAssistantFirstName,newAssistantLastName,newAssistantUserName,
           newAssistantEmail,newAssistantPassword,
           newAssistantAddress,newAssistantCity,newAssistantOrganisation,
           newAssistantWebSite;
   int newAssistantId,newAssistantCourtryId,newAssistantLanguage;
   private Vector assistantPrivilegiesIds;
   private Vector allAssistantsIds;
   private int teacherId;
}
