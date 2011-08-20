package depths.studentModule;

import java.sql.*;
import depths.utility.ConnectionPool;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Vector;

public class DataReader {

  private ConnectionPool pool = null;
  private Connection conn = null;
  private String sql, sql2 = null;
  private String sql1 = null;
  private ResultSet rsUn = null;
  private ResultSet rsPsw = null;
  private ResultSet rsPerf = null;
  private ResultSet rsTH = null;
  private ResultSet rsCT = null;
  private ResultSet rsPL = null;
  private ResultSet rsLT = null;
  private ResultSet rsPT = null;
  private ResultSet rsPQ = null;
  private Student student;
  private SimpleDateFormat df = new SimpleDateFormat(
      "yyyy.MM.dd G 'at' HH:mm:ss z");

  public DataReader() {

  }

  public void sendReference(Student s) {
    student = s;
  }

  //vraca true ukoliko u bazi podataka postoji korisnik sa istim korisnickim imenom
  public boolean checkUserName(String uName) {

    String cUName = "";
    boolean userExist = false;

    try {

      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT students.userName FROM students WHERE userName='" + uName +
          "' ";
      rsUn = stmt.executeQuery(sql);
      if (rsUn.next()) {

        cUName = rsUn.getString("userName");
        rsUn.close();
      }
      if (cUName.equals(uName)) {
        userExist = true;
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {

      if (pool != null) {
        pool.release(conn);
      }
    }

    return userExist;

  }

  //proverava da li password odgovara korisniku
  public boolean checkPassword(String uName, String pass) {

    boolean passwordOK = false;
    int count = 0;
    String passw = "";

    try {

      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT count(*) AS x FROM students WHERE ((userName='" + uName +
          "' ) AND (password='" + pass + "' ))";
      rsPsw = stmt.executeQuery(sql);
      if (rsPsw.next()) {
        count = rsPsw.getInt("x");

        rsPsw.close();
      }
      if (count == 1) {
        passwordOK = true;
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {

      if (pool != null) {
        pool.release(conn);
      }
    }
    return passwordOK;
  }

  //iscitava performanse registrovanog studenta na pocetku sesije
  //i upisuje ih u model studenta
  public void setPerformanceFromDatabase(int userID) {

    int initSkLev, actSkLev, detLev;
    String learningStyle, timeOfLastSess, expLev, reasAbil, programmLang;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT *  FROM performance WHERE (studentID='" + userID + "' )";
      rsPerf = stmt.executeQuery(sql);
      if (rsPerf.next()) {
        initSkLev = rsPerf.getInt("initialSkillLevel");
        actSkLev = rsPerf.getInt("actualSkillLevel");
        learningStyle = rsPerf.getString("learningStyle");
        timeOfLastSess = rsPerf.getString("timeOfLastSession");
        detLev = rsPerf.getInt("detailLevel");
        expLev = rsPerf.getString("experienceLevel");
        reasAbil = rsPerf.getString("reasoningAbility");
        programmLang = rsPerf.getString("programmingLanguage");
        student.setPerformances(initSkLev, actSkLev, learningStyle,
                                timeOfLastSess,
                                detLev, expLev, reasAbil, programmLang);

      }
      rsPerf.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }

  //iscitava istoriju rada sistema sa korisnikom iz baze
  //podataka i unosi podatke u model studenta
  public void readTeachingHistory(int userId,String courseId) {

    String cId, feedbackMess, start, finish, expLev, reasAbil;
    java.util.Date started, finished;
    Vector conc = new Vector();
    int duration, numbOfPass;
    double degreeOfMast, knowledgeLev;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT   * FROM conceptsincourseforstudent where IDStudentInCourse= (select IDStudentInCourse from studentsInCourse where studentID='" +
          userId +
          "' and courseId='"+courseId+"')ORDER BY conceptsInCourseForStudent.`IDConceptInCourseForStudent`";
      rsTH = stmt.executeQuery(sql);
      //rsTH.absolute(1);

      while (rsTH.next()) {

        cId = rsTH.getString("conceptID");
        duration = rsTH.getInt("duration");
        feedbackMess = rsTH.getString("feedbackMessage");
        start = rsTH.getString("started");
        finish = rsTH.getString("finished");
        started = df.parse(start);
        finished = df.parse(finish);

        numbOfPass = rsTH.getInt("numberOfPasses");
        degreeOfMast = rsTH.getDouble("degreeOfMastery");
        knowledgeLev = rsTH.getDouble("knowledgeLevel");
        expLev = rsTH.getString("experienceLevel");
        reasAbil = rsTH.getString("reasoningAbilityLevel");
        student.studTeachingHistory.addConcept();
        student.studTeachingHistory.addConceptGeneralElement("ID", cId);
        student.addConceptDuration(duration);
        student.addConceptElement("feedbackMessage", feedbackMess);
        student.addConceptElement("numberOfPasses", numbOfPass);
        student.addConceptElement("degreeOfMastery", degreeOfMast);
        student.addConceptElement("knowledgeLevel", knowledgeLev);
        student.addConceptElement("experienceLevel", expLev);
        student.addConceptElement("reasoningAbilityLevel", reasAbil);
        student.addConceptElement("started", started);
        student.addConceptElement("finished", finished);

        conc.add(cId);
        this.readConceptTable(cId);
        this.readPassedLessons(userId, cId);
        this.readPassedTests(userId, cId);

      }

      rsTH.close();
      if (conc.isEmpty()){


      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }

  //Iz tabele concept iscitava opste podatke o odredjenom konceptu
  private void readConceptTable(String cId) {

    String title, reference, courseID;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT   * FROM `concept` where conceptID= '" + cId + "'";
      rsCT = stmt.executeQuery(sql);
      while (rsCT.next()) {
        title = rsCT.getString("title");
        reference = rsCT.getString("reference");
        student.setParsingConcept(cId);
        student.addConceptElement("title", title);
        student.addConceptElement("reference", reference);

      }
      rsCT.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }

  //iz tabele unitsInConceptForStudent iscitava podatke o lekcijama koje je student presao
  //iz odredjenog koncepta
  private void readPassedLessons(int userId, String cId) {

    String unitID, start, finish, uTitle;
    java.util.Date started, finished;
    int numberOfPasses;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();

      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT * FROM unitsInConceptForStudent where IDConceptInCourseForStudent=(SELECT IDConceptInCourseForStudent FROM conceptsInCourseForStudent WHERE (conceptID='" +
          cId + "')AND (IDStudentInCourse=(SELECT IDStudentInCourse FROM studentsInCourse WHERE (studentID=" +
          userId + ")))) ORDER BY IDUnitInConceptForStudent";
      rsPL = stmt1.executeQuery(sql);

      //rsPL.next();
      while (rsPL.next()) {

        student.addUnit();
        unitID = rsPL.getString("unitID");
        start = rsPL.getString("started");
        finish = rsPL.getString("finished");
        started = df.parse(start);
        finished = df.parse(finish);

        uTitle = this.readLessonTable(unitID);
        student.addUnitGeneralElement("ID", unitID);
        student.addUnitGeneralElement("title", uTitle);

      }

      rsPL.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }

  //iz tabele unitsInConceptForStudent proverava da li je odredjena lekcija
  //vec ucena
  public boolean checkPassedLessons(int userId, String cId, String uId) {
    String unitID, start, finish, uTitle;
    java.util.Date started, finished;
    boolean exist = false;
    int numberOfPasses;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT * FROM unitsInConceptForStudent WHERE ((unitID='" + uId + "')AND (IDConceptInCourseForStudent=(SELECT IDConceptInCourseForStudent FROM conceptsInCourseForStudent WHERE (conceptID='"
          + cId + "')AND (IDStudentInCourse=(SELECT IDStudentInCourse FROM studentsInCourse WHERE (studentID='" +
          userId + "')))))) ORDER BY IDUnitInConceptForStudent";
      rsPL = stmt1.executeQuery(sql);

      //rsPL.next();


      while (rsPL.next()) {

        unitID = rsPL.getString("unitID");

        start = rsPL.getString("started");
        finish = rsPL.getString("finished");
        started = df.parse(start);
        finished = df.parse(finish);

        uTitle = this.readLessonTable(unitID);

        exist = true;
      }

      rsPL.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }
    return exist;
  }

  //iscitava opste podatke o lekciji (naslov lekcije)

  //iscitava opste podatke o lekciji (naslov lekcije)
  public String readLessonTable(String uID) {
    String title = "", reference;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT   * FROM `unit` WHERE (unitID='" + uID + "')";
      rsLT = stmt.executeQuery(sql);
      while (rsLT.next()) {
        title = rsLT.getString("title");

      }
      rsLT.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }
    return title;
  }

  private void readPassedTests(int userId, String cId) {
    String start, finish;
    java.util.Date started, finished;
    int numberOfPasses, duration, testID;
    double degreeOfMastery, knowledgeLevel, testDifficultyFactor, success,
        testPointsNumber;
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);

      sql =
          "SELECT * FROM testInConceptForStudent WHERE IDConceptInCourseForStudent=" +
          "(SELECT IDConceptInCourseForStudent FROM conceptsInCourseForStudent WHERE ((conceptID='" +
          cId + "')AND (IDStudentInCourse=" +
          "(SELECT IDStudentInCourse FROM studentsInCourse WHERE studentID='" +
          userId + "'" +
          ")))) ORDER BY IDTestInConceptForStudent";

      rsPT = stmt1.executeQuery(sql);

      //rsPL.next();




      while (rsPT.next()) {

        student.addTest();
        testID = rsPT.getInt("testID");

        start = rsPT.getString("started");
        finish = rsPT.getString("finished");
        started = df.parse(start);
        finished = df.parse(finish);
        numberOfPasses = rsPT.getInt("numberOfPasses");
        degreeOfMastery = rsPT.getDouble("degreeOfMastery");
        knowledgeLevel = rsPT.getDouble("knowledgeLevel");
        duration = rsPT.getInt("duration");
        testDifficultyFactor = rsPT.getDouble("testDifficultyFactor");
        success = rsPT.getDouble("success");
        testPointsNumber = rsPT.getDouble("testPointsNumber");

        student.addTestGeneralElem("numberOfPasses", 1);
        student.addTestGeneralElem("degreeOfMastery", degreeOfMastery);
        student.addTestGeneralElem("knowledgeLevel", knowledgeLevel);
        student.addTestGeneralElem("ID", testID);
        student.addTestGeneralElem("duration", duration);
        student.addTestGeneralElem("numberOfPasses", numberOfPasses);
        student.addTestGeneralElem("testDifficultyFactor", testDifficultyFactor);
        student.addTestGeneralElem("success", success);
        student.addTestGeneralElem("testPointsNumber", testPointsNumber);
        student.addTestGeneralElem("started", started);
        student.addTestGeneralElem("finished", finished);
        this.readPassedQuestions(userId, cId, testID);

      }

      rsPT.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }

  private void readPassedQuestions(int userId, String cId, int testID) {
    String questionID, tr;
    boolean truth = false;

    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);

      sql =
          "SELECT * FROM questionInTestForStudent WHERE IDTestInConceptForStudent=" +
          "(SELECT IDTestInConceptForStudent FROM testInConceptForStudent WHERE (testID='" +
          testID + "')AND (IDConceptInCourseForStudent=" +
          "(SELECT IDConceptInCourseForStudent FROM conceptsInCourseForStudent WHERE ((conceptID='" +
          cId + "')AND (IDStudentInCourse=" +
          "(SELECT IDStudentInCourse FROM studentsInCourse WHERE studentID='" +
          userId + "'" +
          ")))))) ORDER BY IDQuestionInTestForStudent";

      rsPQ = stmt1.executeQuery(sql);

      while (rsPQ.next()) {

        student.createNewQuestion();
        student.addQuestion();
        questionID = rsPQ.getString("questionID");
        tr = rsPQ.getString("truth");

        if (tr.equals("0")) {
          truth = false;
        }
        else if (tr.equals("1")) {
          truth = true;
        }

        student.addQuestionElem("ID", questionID);
        student.addQuestionElem("truth", truth);

      }

      rsPQ.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

  }
  public Vector getCountries(){
    Vector countries=new Vector();
    try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT * FROM `countries` ";
      rsLT = stmt.executeQuery(sql);
      while (rsLT.next()) {
        String countryName = rsLT.getString("countryName");
        countries.add(countryName);

      }
      rsLT.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }

    return countries;
  }
  public Vector getCountriesIds(){
      Vector countryIds=new Vector();
      try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT * FROM `countries`";
      rsLT = stmt.executeQuery(sql);
      while (rsLT.next()) {
        int countryId = rsLT.getInt("countryId");
        countryIds.add(new Integer(countryId));


      }
      rsLT.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      if (pool != null) {
        pool.release(conn);
      }
    }


      return countryIds;
  }
  public Vector getLanguages(){
      Vector languages=new Vector();
      try {
        pool = ConnectionPool.getConnectionPool();
        conn = pool.getConnection();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                              ResultSet.CONCUR_READ_ONLY);
        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
        sql = "SELECT * FROM `languages` ";
        rsLT = stmt.executeQuery(sql);
        while (rsLT.next()) {
          String languageName = rsLT.getString("languageName");
          languages.add(languageName);

        }
        rsLT.close();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      finally {
        if (pool != null) {
          pool.release(conn);
        }
      }

      return languages;
    }
    public Vector getLanguagesIds(){
        Vector languagesIds=new Vector();
        try {
        pool = ConnectionPool.getConnectionPool();
        conn = pool.getConnection();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                              ResultSet.CONCUR_READ_ONLY);
        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
        sql = "SELECT * FROM `languages`";
        rsLT = stmt.executeQuery(sql);
        while (rsLT.next()) {
          int languageId = rsLT.getInt("languageId");
          languagesIds.add(new Integer(languageId));


        }
        rsLT.close();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      finally {
        if (pool != null) {
          pool.release(conn);
        }
      }


        return languagesIds;
    }




}
