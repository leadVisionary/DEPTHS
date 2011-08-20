package depths.presentationModule;
import depths.coordinator.*;
import java.util.Vector;

public class RegistrationBean {
  private String currConceptTitle;
  private int numOfQuestionsInPlan;
  private String questionContent;
  private String questionID;
  private int unitDiffLevel;
  private String unitTitle;
  private String currUnitId;
  private int numberOfFragmentsInUnit;
  private int numberOfUnitsInConcept;
  private String fragmentType;
  private String fragmentContent;
  private String fragmentTitle;
  private String fragmentId;
  private String userName ="default ";
  private String password="";
  private boolean inAdditionalTestFlag;
  private int numOfConceptsToLearn;
  private boolean inAdditionalLessonFlag;
  private boolean concStarted;
  private boolean lessonsFinished;
  private boolean newUser=false;
  private String knowledgeLevel="default ";
  private String detailLevel="default ";
  private Vector answers=new Vector();
  private Tutor tutor;
  private boolean inLessonFlag=false;
  private boolean inTestFlag=false;
  private boolean finishLessonsFlag=false;
  public String country;
  private String programmingLanguage;
  private String firstName="", lastName="", email="", passwordConfirmation="", address="", city="",  organization="",webSite="", selectedlanguage="";
  private boolean firstNameAdded=false,lastNameAdded=false, userNameAdded=false, emailAdded=false, passwordAdded=false, passConfirmationAdded=false;
  private boolean passwordsSame=false;
  private boolean userNameChecked=false;
  boolean userNameExist=false;
  private boolean dataIsGood=true;
  private boolean formRepeated=false;
  private Vector countries;
  public Vector countriesIds;
  private Vector languages;
  public Vector languagesIds;

  //privremeno samo radi testiranja



  public RegistrationBean() {
    tutor=new Tutor(this);
  }
  public void setProgrammingLanguage(String pl){
    this.programmingLanguage=pl;
  }
  public String getProgrammingLanguage(){
    return this.programmingLanguage;
  }
  public void setNewUser(boolean val){

    newUser=val;
  }
  public boolean getNewUser(){

   return newUser;
 }

  public boolean isInAdditionalTestFlag(){

    return inAdditionalTestFlag; }
  public void setInAdditionalTestFlag(boolean inAdditionalTestFlag){ this.inAdditionalTestFlag = inAdditionalTestFlag; }
  public int getNumOfConceptsToLearn(){
    return numOfConceptsToLearn;
  }
  public int getNumOfUnitsToLearni(){
    return numberOfUnitsInConcept;
  }
  public void setNumOfConceptsToLearn(int numOfConceptsToLearn){
      this.numOfConceptsToLearn= numOfConceptsToLearn;
    }
    /**Poziva funkciju koja pronalazi iz instrukcionog plana
     * broj koncepata koji su stavljeni u Instrukcioni plan*/
    public void putNumOfConceptsToLearn(){
      int cNum=tutor.getNumOfConceptsInPlan();
      setNumOfConceptsToLearn(cNum);
    }
    public void putNumOfUnitsToLearn(){
      numberOfUnitsInConcept=tutor.getNumberOfUnitsInConcept();
    }
  public boolean isInAdditionalLessonFlag(){
    return inAdditionalLessonFlag; }
  public void setInAdditionalLessonFlag(boolean inAdditionalLessonFlag){
    this.inAdditionalLessonFlag = inAdditionalLessonFlag; }
  public boolean isConcStarted(){ return concStarted; }
  public void setConcStarted(boolean concStarted){ this.concStarted = concStarted; }
  public boolean isLessonsFinished(){ return lessonsFinished; }
  public void setLessonsFinished(boolean lessonsFinished){ this.lessonsFinished = lessonsFinished; }

 public String getCurrConceptTitle(){ return currConceptTitle; }
  public void setCurrConceptTitle(String currConceptTitle){ this.currConceptTitle = currConceptTitle; }
  public int getNumOfQuestionsInPlan(){

    return numOfQuestionsInPlan;
  }
  public void setNumOfQuestionsInPlan(int numOfQuestionsInPl){

       this.numOfQuestionsInPlan= numOfQuestionsInPl;
     }
  public String getQuestionContent(){ return questionContent; }
  public void setQuestionContent(String questionContent){ this.questionContent = questionContent; }
  public String getQuestionID(){
    return questionID;
  }
  public void setQuestionID(String questionID){
       this.questionID= questionID;
     }
  public int getUnitDiffLevel(){
    return unitDiffLevel;
  }
  public void setUnitDiffLevel(int unitDiffLevel){
      this.unitDiffLevel= unitDiffLevel;
    }
  public String getUnitTitle(){
    return unitTitle; }
  public void setUnitTitle(String unitTitle){ this.unitTitle= unitTitle; }
  public String getCurrUnitId(){
    return currUnitId;
  }
  public void setCurrUnitId(String currUnitId){
      this.currUnitId= currUnitId;
    }
  public int getNumberOfFragmentsInUnit(){
    return numberOfFragmentsInUnit;
  }
  public void setNumberOfFragmentsInUnit(int numberOfFragmentsInUnit){
      this.numberOfFragmentsInUnit= numberOfFragmentsInUnit;
    }
  public String getFragmentType(){ return fragmentType; }
  public void setFragmentType(String fragmentType){ this.fragmentType = fragmentType; }
  public String getFragmentContent(){
    return fragmentContent; }
  public void setFragmentContent(String fragmentContent){
    this.fragmentContent = fragmentContent; }
  public String getFragmentTitle(){ return fragmentTitle; }
  public void setFragmentTitle(String fragmentTitle){ this.fragmentTitle = fragmentTitle; }
  public String getFragmentId(){
    return fragmentId;
  }
  public void setFragmentId(String fragmentId){
      this.fragmentId= fragmentId;
    }
    public void setUserName(String s) {
         //tutor.userRegistration(s);
       this.userName = s;
     }
  public String getUserName() {
    return userName;
  }
  public void setUserPassword(String pass){
    this.password=pass;
     //tutor.userRegistration(userName,password);
  }
  public void userRegistration(){
      String courseId="DP001";
    tutor.userRegistration(userName,password,courseId);
  }
  public String getUserPassword(){
    return password;
  }
  public void setKnowledgeLevel(String kl) {
    this.knowledgeLevel = kl;
  }
  public String getKnowledgeLevel() {
    return knowledgeLevel;
  }
  public void setDetailLevel(String dl) {
    this.detailLevel = dl;
  }
  public String getDetailLevel(){
    return detailLevel;
  }
  public void saveStudentData(){

    tutor.saveStudentData();
    this.setFinishLessonsFlag(false);
  }
  public void sendPerformanceToTutor(){
    int dl;
    int isl;
    if (detailLevel.equals("Low")){
      dl=1;
    }else if (detailLevel.equals("Middle")){
      dl=2;
    } else{
      dl=3;
    }
    if (knowledgeLevel.equals("Begginer")){
      isl=1;
    }else if (knowledgeLevel.equals("Intermediate")){
      isl=3;
    }else {
      isl=5;
    }
     tutor.setInitialPerformances(isl,dl,programmingLanguage);
  }
  public void readNext(){

    tutor.readNext();
  }
  public void initializeUser(){

    tutor.initializeUserFromBean();
  }
  public String readCurrConcID(){
    String cid=tutor.getCurrentConceptId();
    return cid;
  }
  public String readCurrUnitID(){

    String uid=tutor.getCurrentUnitId();

    return uid;
  }
  public void readCurrentUnit(){

  }
  public void setInLessonFlag(boolean val){

    inLessonFlag=val;
  }
  public boolean getInLessonFlag(){
    return inLessonFlag;
  }
  public void setInTestFlag(boolean val){

    inTestFlag=val;
  }
  public boolean getInTestFlag(){
    return inTestFlag;
  }
  public void sendUnitData(String currReadUnitId,String unTitle,int diffLev){

    this.setCurrUnitId(currReadUnitId);
    this.setUnitTitle(unTitle);
    this.setUnitDiffLevel(diffLev);

  }
   public void getFragmentByOrdNumber(int ordN){
     tutor.getFragmentByOrdNumber(ordN);
   }
   /**ubacuje podatke o trazenom pitanju*/
   public void sendNewQuestionData(String id,String content){
     answers.removeAllElements();
     this.setQuestionID(id);
     this.setQuestionContent(content);
   }
   /**Ubacuje odgovor na pitanje u Vektor odgovora*/
   public void sendNewAnswerData(String ansContent,boolean aTruth){

     Answer cAnswer=new Answer(ansContent,aTruth);
     answers.add(cAnswer);
   }
   /**Vraca broj odgovora koji se nalaze u vektoru odgovora*/
   public int getNumbOfAnswers(){
     int noa=answers.size();
     return noa;
   }
   /**Vraca sadrzaj odgovora na trenutno pitanje*/
   public String getAnswerContent(int ordN){
     Answer crAnswer=(Answer) answers.get(ordN);
     String cont=crAnswer.getContent();
     return cont;
   }
   public void getQuestionByOrdNum(int ordN){

    tutor.getQuestionByOrdNum(ordN);
  }
  public  Tutor getRefTutor(){
    return tutor;
  }
  public void setParameters(){

    this.setInLessonFlag(true);
    this.setInTestFlag(false);
    //tutor.setInitialParameters();
  }
  public void setAdditionalParameters(){
  this.inAdditionalLessonFlag=true;
  this.inAdditionalTestFlag=false;
  //tutor.setInitialAdditionalParameters();
  }
  /**Pronalazi  title koncepta na osnovu rednog broja
  * za sadrzaj na stranici*/
 public String getConceptByOrdNum(int ordNum){
   String cTitle=tutor.getConceptByOrdNum(ordNum);
   return cTitle;
 }
 public String getConceptIdByOrdNum(int ordNum){
   String cId=tutor.getConceptIdByOrdNum(ordNum);
   return cId;
 }
 public void goToConceptById(String concId){
 }
 public void selectParticularConcept(String cId){
   tutor.selectParticularConcept(cId);
 }
 public void selectParticularLearnedConcept(String cId){
    tutor.selectParticularLearnedConcept(cId);

  }

 public void selectParticularLesson(String lId){

   tutor.selectParticularLesson(lId);
   this.setCurrUnitId(lId);

 }
 public boolean isFinishLessonsFlag(){
   return finishLessonsFlag; }
 public void setFinishLessonsFlag(boolean val)
   {

     if (val==true){
     }else if (val==false){
     }
     this.finishLessonsFlag = val;
  }
  /**Oznacava kraj koncepta u SM a poziva se
  * neposredno pre izlasak iz programa da bi se
  * sacuvali podaci o predjenom konceptu*/
 public void finishNewConcept(){
   tutor.finishNewConcept();

 }
 public Tutor sendTutorRefToStatBean(){
   return tutor;
 }
 /**Zapocinje novu instancu testa u SM*/
  public void startTestInSM(){
    tutor.startTestInSM();
  }
  /**Pronalazi naslov lekcije na osnovu njenog rednog broja u instrukcionom planu*/
  public String getUnitTitleByOrdNum(int ordNum){
    String title=tutor.getUnitTitleByOrdNum(ordNum);
    return title;
  }
  /**Pronalazi id lekcije na osnovu njenog rednog broja u instrukcionom planu*/
  public String getUnitIdByOrdNum(int ordNum){
    String unitId=tutor.getUnitIdByOrdNum(ordNum);
    return unitId;
  }

  public void setFirstName(String fn){
    this.firstName=fn;
  }
  public String getFirstName(){
    return this.firstName;
  }
  public void setLastName(String ln){
    this.lastName=ln;
  }
  public String getLastName(){
    return this.lastName;
  }
  public void setPassword(String pass){
    this.password=pass;

  }
  public String getPassword(){

    return this.password;
  }
  public void setEmail(String e){
    this.email=e;
  }
  public String getEmail(){
    return this.email;
  }
  public void setPasswordConfirmation(String pc){
    this.passwordConfirmation=pc;
  }
  public String getPasswordConfirmation(){
    return this.passwordConfirmation;
  }
  public void setAddress(String add){
    this.address=add;
  }
  public String getAddress(){
    return this.address;
  }
  public void setCity(String c){
    this.city=c;
  }
  public String getCity(){
    return this.city;
  }
  public void setCountry(String c){

    //Integer x=new Integer(c);
    this.country=c;

  }
  public String getCountry(){
    return this.country;
  }
  public void setOrganization(String org){
    this.organization=org;
  }
  public String getOrganization(){
    return this.organization;
  }
  public void setWebSite(String ws){
   this.webSite=ws;
 }
 public String getWebSite(){
   return this.webSite;
 }
  public void setSelectedLanguage(String sl){
    this.selectedlanguage=sl;
  }
  public String getSelectedLanguage(){
    return this.selectedlanguage;
  }
  public void setAddedData(String dataType,boolean value){
    if (dataType=="firstName"){
      this.firstNameAdded=value;
    }else if (dataType=="lastName"){
      this.lastNameAdded=value;
    }else if (dataType=="userName"){
      this.userNameAdded=value;
    }else if (dataType=="email"){
      this.emailAdded=value;
    }else if (dataType=="password"){
      this.passwordAdded=value;
    }else if (dataType=="passwordConfirmation"){
      this.passConfirmationAdded=value;
    }
  }
  public boolean getAddedData(String dataType){
    boolean returnValue=false;
   if (dataType=="firstName"){
     returnValue=this.firstNameAdded;
   }else if (dataType=="lastName"){
     returnValue=this.lastNameAdded;
   }else if (dataType=="userName"){
     returnValue=this.userNameAdded;
   }else if (dataType=="email"){
     returnValue=this.emailAdded;
   }else if (dataType=="password"){
     returnValue=this.passwordAdded;
   }else if (dataType=="passwordConfirmation"){
     returnValue=this.passConfirmationAdded;
   }
   return returnValue;
 }
  public void setPasswordsSame(){
    this.passwordsSame=true;
  }
  public boolean getPasswordSame(){
    return this.passwordsSame;
  }
  //proverava da li su obe unete lozinke iste
  public boolean comparePasswords(){
    boolean value=false;
    boolean p=this.getAddedData("password");
    boolean pc=this.getAddedData("passwordConfirmation");
    if (p==true){
      if (pc==true){
        if (this.getPassword().equals(this.getPasswordConfirmation())){
          this.setPasswordsSame();
          value=true;
        }else{
          this.setPassword("");
          this.setPasswordConfirmation("");
          this.setAddedData("password",false);
          this.setAddedData("passwordConfirmation",false);
        }
      }
   }
    return value;
  }
  //proverava podatke za postojeceg korisnika
  public boolean checkExistingUserData(){
    boolean isPasswordGood=false;
    this.checkUserName();
    if (userNameExist){
      isPasswordGood=this.checkPassword();
    }else{
        this.userNameExist=false;
        this.userNameChecked=false;
        this.userNameAdded=false;

      System.out.println("ERROR: Username does not exist. Please register!");
    }
    return isPasswordGood;
  }
  //proverava dali izabrano korisnicko ime vec postoji u bazi podataka
  public boolean checkUserName(){
    if (!userNameChecked){
      if (!this.getUserName().equals("")) {
        userNameExist = tutor.checkUserName(userName);

      }
      if (!userNameExist){
        userNameChecked=true;

       }
    }
    return userNameExist;
  }
  //proverava da li password odgovara korisniku
  public boolean checkPassword(){
    boolean passwordOK=tutor.checkPassword(this.userName, this.password);


    return passwordOK;

  }
  //proverava da li su u formu za registraciju uneti svi neophodni podaci
  public boolean checkNewUserData(){

    dataIsGood=true;
    if (!this.getFirstName().equals("")){
      this.setAddedData("firstName",true);
    }else dataIsGood=false;
    if (!this.getLastName().equals("")){
      this.setAddedData("lastName",true);
    }else dataIsGood=false;
    if (!this.getUserName().equals("")){
       this.setAddedData("userName",true);
     }else dataIsGood=false;
    if (!this.getEmail().equals("")){
        this.setAddedData("email",true);
     }else dataIsGood=false;
     if (!this.getPassword().equals("")){
       this.setAddedData("password",true);
     }else dataIsGood=false;
     if (!this.getPasswordConfirmation().equals("")){
       this.setAddedData("passwordConfirmation",true);
     }
     if (this.comparePasswords()==false){
       dataIsGood=false;
     }
    return dataIsGood;
  }
  public void newUserRegistration(){


    String fName=this.getFirstName();
    String lName=this.getLastName();
    String uName=this.getUserName();
    String pass=this.getPassword();
    String addr=this.getAddress();
    String city=this.getCity();
    Integer c=new Integer(this.getCountry());
    int countryId=c.intValue();
    String organization=this.getOrganization();
    String webS=this.getWebSite();
    String lang=this.getSelectedLanguage();

    tutor.newUserRegistration(fName,lName, uName, email,pass,addr,city,countryId,organization,webS,lang);
  }

  public boolean isDataIsGood(){ return dataIsGood; }
  public void setDataIsGood(boolean dataIsGood){ this.dataIsGood= dataIsGood; }
  public boolean isFormRepeated(){
   return formRepeated; }
  public void setFormRepeated(boolean formRepeated){ this.formRepeated = formRepeated; }
  public boolean isUserNameExist(){
    return this.userNameExist;
  }
  //postavlja podatke koji se odnose na kurs koji se izucava
  public void setCourseData(){
    if (!userNameExist){
      tutor.setCourseData();
    }
  }
  //preuzima iz modela studenta broj predjenih koncepata
  public int getNumberOfPassedConcepts(){
    int numOfPassConc=tutor.getNumberOfPassedConcepts();
    return numOfPassConc;
  }
  public String getPassedConceptTitleByOrdNum(int i){
    String cTitle=tutor.getPassedConceptTitleByOrdNum(i);
    return cTitle;
  }
  public String getPassedConceptIdByOrdNum(int i){

    String cId=tutor.getPassedConceptIdByOrdNum(i);
    return cId;
  }
  //preuzima ocenu za koncept na osnovu rednog broja
  //i prosledjuje u meni
  public double getPassedConceptDegreeOfMastByOrdNum(int i){
    double degree=tutor.getPassedConceptDegreeOfMastByOrdNum(i);
    return degree;
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

  public String getSVG_uri(){
String uri=    tutor.getSvgURI();

    return uri;
  }
  public void getCountries(){
    this.countries=tutor.getCountries();
  }
  public int getNumbOfCountries(){
    int numb=countries.size();
    return numb;
  }
  public String getCountryName(int i){

    String name=countries.get(i).toString();

    return name;
  }
  public void getCountriesIds(){
    this.countriesIds=tutor.getCountriesIds();
  }
  public int getCountryId(int i){

    Integer id=(Integer) countriesIds.get(i);

    return id.intValue();
  }
  public void getLanguages(){
    this.languages=tutor.getLanguages();
  }
  public int getNumbOfLanguages(){
    int numb=languages.size();
    return numb;
  }
  public String getLanguageName(int i){

    String name=languages.get(i).toString();

    return name;
  }
  public void getLanguagesIds(){
    this.languagesIds=tutor.getLanguagesIds();
  }
  public int getLanguageId(int i){

    Integer id=(Integer) languagesIds.get(i);

    return id.intValue();
  }
  public String findPreviousLesson(String currUnitId){
    String privUnitId=tutor.findPreviousLessonId(currUnitId);
    return privUnitId;
  }





}
