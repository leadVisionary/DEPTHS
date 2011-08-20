package depths.presentationModule.admin;

import depths.adminModule.*;
import java.util.Vector;

public class AdminBean {

  public AdminBean() {

  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  public boolean checkAdministratorData() {

    boolean isPasswordGood = false;
    this.checkAdminName();
    if (adminNameExist) {

      isPasswordGood = this.checkAdminPassword();
    }
    else {
        adminNameExist=false;
        userNameChecked = false;

      System.out.println("ERROR: Username does not exist. Please register!");
    }
    return isPasswordGood;

  }

  //proverava dali izabrano korisnicko ime vec postoji u bazi podataka
  public boolean checkAdminName() {

    if (!userNameChecked) {

      if (!this.getUserName().equals("")) {

        adminNameExist = dbManager.checkUserName(userName);

      }
      if (!adminNameExist) {

        userNameChecked = true;

      }
    }

    return adminNameExist;
  }

  //proverava da li password odgovara korisniku
  public boolean checkAdminPassword() {
    boolean passwordOK = dbManager.checkAdminPassword(this.userName,
        this.adminPassword);
    return passwordOK;

  }

  //proverava administratorske privilegije
  public void setAdminPrivilegies() {
    String privil = "";
    Integer usId = this.getAdminId();
    privil = dbManager.checkAdminPrivilegies(usId);
    this.setPrivilegies(privil);

  }

  public void adminRegistration() {
    this.adminId = new Integer(userName.hashCode());

  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getNewFirstName() {
    return newFirstName;
  }

  public void setNewFirstName(String newFirstName) {
    this.newFirstName = newFirstName;
  }

  public String getNewLastName() {
    return newLastName;
  }

  public void setNewLastName(String newLastName) {
    this.newLastName = newLastName;
  }

  public String getNewUserName() {
    return newUserName;
  }

  public void setNewUserName(String newUserName) {

    this.newUserName = newUserName;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getNewPasswordConfirmation() {
    return newPasswordConfirmation;
  }

  public void setNewPasswordConfirmation(String newPasswordConfirmation) {
    this.newPasswordConfirmation = newPasswordConfirmation;
  }

  public String getNewEmail() {
    return newEmail;
  }

  public void setNewEmail(String newEmail) {
    this.newEmail = newEmail;
  }

  public String getNewCity() {
    return newCity;
  }

  public void setNewCity(String newCity) {
    this.newCity = newCity;
  }

  public String getNewCountry() {
    return newCountry;
  }

  public void setNewCountry(String newCountry) {
    this.newCountry = newCountry;
  }

  public String getNewOrganisation() {
    return newOrganisation;
  }

  public void setNewOrganisation(String newOrganisation) {
    this.newOrganisation = newOrganisation;
  }

  public String getNewWebSite() {
    return newWebSite;
  }

  public void setNewWebSite(String newWebSite) {
    this.newWebSite = newWebSite;
  }

  public String getNewSelectedLanguage() {
    return newSelectedLanguage;
  }

  public void setNewSelectedLanguage(String newSelectedLanguage) {
    this.newSelectedLanguage = newSelectedLanguage;
  }

  public boolean getAddedData(String dataType) {
    boolean returnValue = false;
    if (dataType == "firstName") {
      returnValue = this.firstNameAdded;
    }
    else if (dataType == "lastName") {
      returnValue = this.lastNameAdded;
    }
    else if (dataType == "userName") {
      returnValue = this.userNameAdded;
    }
    else if (dataType == "email") {
      returnValue = this.emailAdded;
    }
    else if (dataType == "password") {
      returnValue = this.passwordAdded;
    }
    else if (dataType == "passwordConfirmation") {
      returnValue = this.passConfirmationAdded;
    }
    return returnValue;
  }

  public boolean isFormRepeated() {
    return formRepeated;
  }

  public void setFormRepeated(boolean formRepeated) {
    this.formRepeated = formRepeated;
  }

  //proverava dali izabrano korisnicko ime vec postoji u bazi podataka
  public boolean checkUserName() {

    if (!userNameChecked) {
      if (!this.getUserName().equals("")) {
        userNameExist = dbManager.checkUserName(userName);
      }
      if (!userNameExist) {
        userNameChecked = true;
      }
    }
    return userNameExist;
  }

  //proverava dali izabrano korisnicko ime vec postoji u bazi podataka
  public boolean checkNewUserName() {

    if (!newUserNameChecked) {

      if (!this.getNewUserName().equals("")) {

        newUserNameExist = dbManager.checkUserName(newUserName);
      }
      if (!newUserNameExist) {

        newUserNameChecked = true;
      }
    }
    return newUserNameExist;
  }

  public boolean isNewUserNameExist() {
    return this.newUserNameExist;
  }

  //proverava da li su u formu za registraciju uneti svi neophodni podaci
  public boolean checkNewAdminData() {

    dataIsGood = true;
    if (!this.getNewFirstName().equals("")) {
      this.setAddedData("firstName", true);
    }
    else {

      dataIsGood = false;
    }
    if (!this.getNewLastName().equals("")) {
      this.setAddedData("lastName", true);
    }
    else {
      dataIsGood = false;
    }
    if (!this.getNewUserName().equals("")) {
      this.setAddedData("userName", true);
    }
    else {
      dataIsGood = false;
    }
    if (!this.getNewEmail().equals("")) {
      this.setAddedData("email", true);
    }
    else {
      dataIsGood = false;
    }
    if (!this.getNewPassword().equals("")) {
      this.setAddedData("password", true);
    }
    else {
      dataIsGood = false;
    }
    if (!this.getNewPasswordConfirmation().equals("")) {
      this.setAddedData("passwordConfirmation", true);
    }
    if (this.comparePasswords() == false) {
      dataIsGood = false;
    }
    return dataIsGood;
  }

  public void newAdminRegistration() {

    Integer newAdminId = new Integer(newUserName.hashCode());
    String fName = this.getNewFirstName();
    String lName = this.getNewLastName();
    String uName = this.getNewUserName();
    String email = this.getNewEmail();
    String pass = this.getNewPassword();
    String addr = this.getNewAddress();
    String city = this.getNewCity();
    Integer x = new Integer(this.getNewCountry());
    int country = x.intValue();
    String organisation = this.getNewOrganisation();
    String webS = this.getNewWebSite();
    String lang = this.getNewSelectedLanguage();
    String newPrivilegies = this.getNewPrivilegies();

    dbManager.newAdminRegistration(newAdminId, fName, lName, uName, email, pass,
                                   addr, city, country, organisation, webS,
                                   lang, newPrivilegies);

  }

  //proverava da li su obe unete lozinke iste
  public boolean comparePasswords() {
    boolean value = false;
    boolean p = this.getAddedData("password");
    boolean pc = this.getAddedData("passwordConfirmation");
    if (p == true) {
      if (pc == true) {
        if (this.getNewPassword().equals(this.getNewPasswordConfirmation())) {
          this.setPasswordsSame();
          value = true;
        }
        else {
          this.setNewPassword("");
          this.setNewPasswordConfirmation("");
          this.setAddedData("password", false);
          this.setAddedData("passwordConfirmation", false);
        }
      }
    }
    return value;
  }

  public void setAddedData(String dataType, boolean value) {

    if (dataType == "firstName") {
      this.firstNameAdded = value;
    }
    else if (dataType == "lastName") {
      this.lastNameAdded = value;
    }
    else if (dataType == "userName") {
      this.userNameAdded = value;
    }
    else if (dataType == "email") {
      this.emailAdded = value;
    }
    else if (dataType == "password") {
      this.passwordAdded = value;
    }
    else if (dataType == "passwordConfirmation") {
      this.passConfirmationAdded = value;
    }
  }

  public void setPasswordsSame() {
    this.passwordsSame = true;
  }

  public String getNewAddress() {
    return newAddress;
  }

  public void setNewAddress(String newAddress) {
    this.newAddress = newAddress;
  }

  public String getPrivilegies() {
    return privilegies;
  }

  public void setPrivilegies(String privilegies) {
    this.privilegies = privilegies;
  }

  public String getNewPrivilegies() {
    return newPrivilegies;
  }

  public void setNewPrivilegies(String privilegies) {

    this.newPrivilegies = privilegies;
  }

  //cita iz baze id brojeve svih administratora
  public void readAllAdministrators() {
    this.allAdminsIds = dbManager.readAllAdministrators();
  }
  public void readAllTeachers() {
      this.allTeachersIds = dbManager.readAllTeachers();
  }
  public int getAdminsNumb() {

    return this.allAdminsIds.size();
  }
  public int getTeachersNumb() {

    return this.allTeachersIds.size();
  }


  public int getAdminIdByOrdNum(int i) {

    Integer id = (Integer)this.allAdminsIds.get(i);

    return id.intValue();
  }
  public int getTeacherIdByOrdNum(int i) {

   Integer id = (Integer)this.allTeachersIds.get(i);

   return id.intValue();
 }


  public String getAdminsDataByAdminId(String dataType, int admId) {

    String value = dbManager.getAdminsDataByAdminId(dataType, admId);
    if (value.equals("")) {
      value = "-not set-";
    }
    return value;
  }
  public String getTeacherDataByTeacherId(String dataType, int teacherId) {

    String value = dbManager.getTeacherDataById(dataType, teacherId);
    if (value.equals("")) {
      value = "-not set-";
    }

    return value;
  }


  public void removeAdminById(int adminId) {

    dbManager.removeAdminById(adminId);
  }
  public void removeTeacherById(int teacherId) {

    dbManager.removeTeacherById(teacherId);
  }


  public void clearOldData() {

    this.setNewAddress("");
    this.setNewCity("");
    this.setNewCountry("");
    this.setNewEmail("");
    this.setNewFirstName("");
    this.setNewLastName("");
    this.setNewOrganisation("");
    this.setNewPassword("");
    this.setNewPasswordConfirmation("");
    this.setNewPrivilegies("");
    this.setNewSelectedLanguage("");
    this.setNewUserName("");
    this.setNewWebSite("");
    this.newUserNameExist = false;
    this.newUserNameChecked = false;
    this.dataIsGood = true;
    this.firstNameAdded = false;
    this.lastNameAdded = false;
    this.passwordAdded = false;
    this.passConfirmationAdded = false;
    this.userNameAdded = false;
    this.passConfirmationAdded = false;
    this.emailAdded = false;
    this.formRepeated = false;

  }

  public void getCountries() {
    this.countries = dbManager.getCountries();
  }

  public int getNumbOfCountries() {
    int numb = countries.size();
    return numb;
  }

  public String getCountryName(int i) {

    String name = countries.get(i).toString();

    return name;
  }

  public void getCountriesIds() {
    this.countriesIds = dbManager.getCountriesIds();
  }

  public int getCountryId(int i) {
    Integer id = (Integer) countriesIds.get(i);
    return id.intValue();
  }
  public void getLanguages() {
    this.languages = dbManager.getLanguages();
  }
  public void getAdministrators() {
    this.administratorsIds = dbManager.getAdministrators();
  }
  public void readAllCourses() {
    this.courseIds = dbManager.readAllCourses();
  }




  public int getNumbOfLanguages() {
    int numb = languages.size();
    return numb;
  }
  public int getNumbOfAdministrators() {
    int numb = administratorsIds.size();
    return numb;
  }
  public int getNumbOfCourses() {
    int numb = this.courseIds.size();
    return numb;
  }


  public String getLanguageName(int i) {
    String name = languages.get(i).toString();
    return name;
  }
  public String getAdministratorData(String dataType,int id) {
   String value = dbManager.getAdminDataById(dataType,id);

   return value;
 }
 public String getCourseName(String id) {
  String value = dbManager.getCourseName(id);

  return value;
}


  public void getLanguagesIds() {
    this.languagesIds = dbManager.getLanguagesIds();
  }
  public int getLanguageId(int i) {
    Integer id = (Integer) languagesIds.get(i);
    return id.intValue();
  }
  public String getCourseIdByOrdNumb(int i) {
    String id =  courseIds.get(i).toString();
    return id;
  }

  public int getAdministratorId(int i) {
    Integer id = (Integer) administratorsIds.get(i);
    return id.intValue();
  }

  public void getPrivilegiesIds() {
    this.allPrivilegies = dbManager.getPrivilegiesIds();
  }

  public int getNumbOfPrivilegies() {
    return this.allPrivilegies.size();
  }

  public int getPrivilegieIdByOrdNum(int i) {
    Integer id = new Integer(this.allPrivilegies.get(i).toString());
    int prId=id.intValue();

    return prId;
  }

  public String getPrivilegieById(int privilegieId) {
    String privilegie = dbManager.getPrivilegieById(privilegieId);

    return privilegie;
  }

  public String getAdminDataById(String dataType, String adminId) {
    Integer v = new Integer(adminId);
    String name = dbManager.getAdminDataById(dataType, v.intValue());
    return name;
  }
  public String getTeacherDataByTeacherId(String dataType, String adminId) {
    Integer v = new Integer(adminId);
    String value = dbManager.getTeacherDataById(dataType, v.intValue());
    if (value.equals("")) {
      value = "-not set-";
    }

    return value;
  }


  public String getAdminPrivilegieNameByAdminId(String adminId) {

    Integer v = new Integer(adminId);
    String priv = dbManager.getAdminPrivilegieNameByAdminId(v.intValue());

    return priv;
  }
  public void updateAdminData(String fName,String lName,String email,
                              String password,String address,String city,
String country,String organisation,String webSite,String language){

    dbManager.updateAdminData(checkValue(fName),checkValue(lName),this.userName,checkValue(email),
        password,checkValue(address),checkValue(city),stringToInt(country),checkValue(organisation),
        checkValue(webSite),stringToInt(language));

  }
  public String checkValue(String x){

    if (x.equals("-not set-")){
      x="";
    }
    return x;
  }
  public int stringToInt(String x){
    Integer y=new Integer(x);
    return y.intValue();
  }

  public void changePrivilegie(String admId, String newPrivilegieId) {
    String dataType = "privilegieId_FK";
    Integer v = new Integer(admId);
    Integer v2 = new Integer(newPrivilegieId);
    dbManager.updateAdminData(v.intValue(), dataType, v2.intValue());
  }

  public boolean isTeacherUserNameExist(){
    return teacherUserNameExist;
  }

  public void setTeacherUserNameExist(boolean teacherUserNameExist){
      this.teacherUserNameExist= teacherUserNameExist;
    }
    public boolean checkTeacherUserName(String uName){

      boolean val=dbManager.checkTeacherUserName(uName);
      this.setTeacherUserNameExist(val);

      return val;
    }
   public String getNewTeacherDataByType(String dataType,String teacherUserName){
     String value=dbManager.getNewTeacherDataByType(dataType,teacherUserName);
      return value;

   }
   public Vector getNewTeacherPrivilegies(String teacherUserName){
     Integer x=new Integer(teacherUserName.hashCode());
     Vector privilegies=dbManager.getNewTeacherPrivilegies(x.intValue());
     return privilegies;
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
public void createNewTeacher(String fName,String lName,String uName,
                           String email,String passw,String address,
                           String city,String country,
                           String organisation,String webS,String lang){

    this.newTeacherFirstName=fName;
    this.newTeacherLastName=lName;
    this.newTeacherUserName=uName;
    this.newTeacherEmail=email;
    this.newTeacherPassword=passw;
    this.newTeacherAddress=address;
    this.newTeacherCity=city;
    this.newTeacherCourtryId=country;
    this.newTeacherOrganisation=organisation;
    this.newTeacherWebSite=webS;
    this.newTeacherLanguage=lang;




}
    public void addNewTeacherData(){

        int teacherId=this.newTeacherUserName.hashCode();
  int countryId=this.stringToInt(this.newTeacherCourtryId);
  int langId=this.stringToInt(this.newTeacherLanguage);
  int createdByAdminId= this.getAdminId().intValue();

        dbManager.createNewTeacher(teacherId,this.newTeacherFirstName,
                                   this.newTeacherLastName,this.newTeacherUserName,
                                   this.newTeacherEmail,this.newTeacherPassword,
                                   this.newTeacherAddress,this.newTeacherCity,
                                   countryId,this.newTeacherOrganisation,
                                   this.newTeacherWebSite,langId,createdByAdminId);
    }
    public void addNewTeacherData(int createdByTeacherId){//poziva se kada nastavnik kreira
        //novog nastavnika

       int teacherId=this.newTeacherUserName.hashCode();
 int countryId=this.stringToInt(this.newTeacherCourtryId);
 int langId=this.stringToInt(this.newTeacherLanguage);


       dbManager.createNewTeacher(teacherId,this.newTeacherFirstName,
                                  this.newTeacherLastName,this.newTeacherUserName,
                                  this.newTeacherEmail,this.newTeacherPassword,
                                  this.newTeacherAddress,this.newTeacherCity,
                                  countryId,this.newTeacherOrganisation,
                                  this.newTeacherWebSite,langId,createdByTeacherId);
   }

public void createNewTeacherPrivilegies(String uName,String privilegie){

  Integer x=new Integer(uName.hashCode());
  Integer y=new Integer(privilegie);
  dbManager.createNewTeacherPrivilegies(x.intValue(),y.intValue());
}
    public void createNewTeacherPrivilegies(int teacherId,int privilegieId){


  dbManager.createNewTeacherPrivilegies(teacherId,privilegieId);
}

public int getNumberOfTeachersPrivilegies(){
  int val=this.teacherPrivilegiesIds.size();
  return val;
}
public void getTeachersPrivilegies(){
  teacherPrivilegiesIds=dbManager.getTeachersPrivilegies();

}
public int getTeacherPrivilegieIdByOrdNumb(int i){
 Integer x=new Integer( this.teacherPrivilegiesIds.get(i).toString());
 return x.intValue();
}
 public String getTecherPrivilegieNameById(int privilegieId){
   String name=dbManager.getTeacherPrivilegieNameById(privilegieId);
   return name;
 }
 public void getTeacherPrivilegies(int teachId){
   this.teacherPrivilegies=dbManager.getTeacherPrivilegies(teachId);
 }
public int getTeacherPrivilegiesNumb(){
  int x=this.teacherPrivilegies.size();
  return x;
}
public String getTeachPrivByOrdNumb(int i){
  String priv=teacherPrivilegies.get(i).toString();
  return priv;
}
public DatabaseManager getManagerReference(){
  return dbManager;
}
public boolean checkIfTeacherAlreadyHavePrivilegie(int teacherId,int privilegieId){
    boolean val=dbManager.checkIfTeacherAlreadyHavePrivilegie(teacherId,privilegieId);
    return val;
}
public void removeAllTeacherPrivilegies(int teacherId){
    dbManager.removeAllTeacherPrivilegies(teacherId);
}
public Vector getCourses(){
    Vector coursesIds=dbManager.getCourses();
    return coursesIds;
}
public void setCourseForTeacher(String courseId,int teacherId){
    dbManager.setCourseForTeacher(courseId,teacherId);

}
  private boolean passwordsSame = false;
  private Vector allAdminsIds;
  private Vector allTeachersIds;
  private Vector teacherPrivilegiesIds;
  private boolean dataIsGood = true;
  private boolean userNameExist = false;
  private boolean newUserNameExist = false;
  private String userName;
  private String adminPassword;
  private boolean userNameChecked = false;
  private boolean newUserNameChecked = false;
  boolean adminNameExist = false;
  private Vector allPrivilegies = new Vector();
  private DatabaseManager dbManager = new DatabaseManager();

  private Integer adminId;
  private String newFirstName;
  private String newLastName;
  private String newUserName;
  private String newPassword;
  private String newPasswordConfirmation;
  private String newEmail;
  private String newCity;
  private String newCountry;
  private String newOrganisation;
  private String newWebSite;
  private String newSelectedLanguage;
  private boolean firstNameAdded = false, lastNameAdded = false, userNameAdded = false,
      emailAdded = false, passwordAdded = false, passConfirmationAdded = false;
  private boolean formRepeated = false;
  private String newAddress;
  private String privilegies;
  private String newPrivilegies;
  private Vector countries;
  private Vector countriesIds;
  private Vector languages;
  private Vector administratorsIds;
  private Vector languagesIds;
  private Vector teacherPrivilegies;
  public Vector courseIds;
  private boolean teacherUserNameExist=false;
  private String newTeacherFirstName,newTeacherLastName,newTeacherUserName,
          newTeacherEmail,newTeacherPassword,
          newTeacherAddress,newTeacherCity,newTeacherCourtryId,newTeacherOrganisation,
          newTeacherWebSite,newTeacherLanguage;
}
