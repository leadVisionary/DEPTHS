package depths.adminModule;

import java.sql.*;
import depths.utility.ConnectionPool;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Vector;
import depths.utility.ConnectionPool;

public class DatabaseAdminReader {
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

    public DatabaseAdminReader() {

    }

    //vraca true ukoliko u bazi podataka postoji korisnik sa istim korisnickim imenom
    public boolean checkAdminUserName(String uName) {
        String cUName = "";
        boolean userExist = false;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql =
                    "SELECT administrators.userName FROM administrators WHERE userName='" +
                    uName + "' ";
            rsUn = stmt.executeQuery(sql);
            if (rsUn.next()) {
                cUName = rsUn.getString("userName");
                rsUn.close();
            }
            if (cUName.equals(uName)) {
                userExist = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return userExist;
    }

    //proverava da li password odgovara korisniku
    public boolean checkAdminPassword(String uName, String pass) {
        boolean passwordOK = false;
        int count = 0;
        String passw = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT count(*) AS x FROM administrators WHERE ((userName='" +
                  uName + "' ) AND (password='" + pass + "' ))";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                count = rsPsw.getInt("x");
                rsPsw.close();
            }
            if (count == 1) {
                passwordOK = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }
        return passwordOK;
    }

    public String checkAdminPrivilegies(Integer usId) {
        String privil = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int adminId = usId.intValue();
            sql = "SELECT * FROM privilegies WHERE (privilegieId=(SELECT administrators.privilegieId_FK FROM administrators WHERE administratorId='" +
                  adminId + "')) ";
            rsUn = stmt.executeQuery(sql);
            if (rsUn.next()) {
                privil = rsUn.getString("privType");
                 rsUn.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return privil;
    }

    public Vector readAllAdministrators() {
        Vector addminsIds = new Vector();
        Integer id;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM administrators  ";
            rsUn = stmt.executeQuery(sql);
            while (rsUn.next()) {
                int tid = rsUn.getInt("administratorId");
                id = new Integer(tid);
                addminsIds.add(id);
            }
            rsUn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return addminsIds;
    }

    public Vector readAllTeachers() {
        Vector teachersIds = new Vector();
        Integer id;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM teachers  ";
            rsUn = stmt.executeQuery(sql);
            while (rsUn.next()) {
                int tid = rsUn.getInt("teacherId");
                id = new Integer(tid);
                teachersIds.add(id);
            }
            rsUn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return teachersIds;
    }

    public String getAdminsDataByAdminId(String dataType, int admId) {
        String value = "";
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if (dataType.equals("privType")) {

                sql = "SELECT privType FROM privilegies WHERE  (privilegieId=(SELECT privilegieId_FK FROM administrators WHERE (administratorId='" +
                      admId + "'))) ";
            } else {

                sql = "SELECT * FROM administrators WHERE  (administratorId='" +
                      admId +
                      "')";
            }
            rsUn = stmt.executeQuery(sql);
            if (rsUn.next()) {
                value = rsUn.getString(dataType);

                rsUn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return value;
    }

    public void removeAdminById(int adminId) {
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql =
                    "DELETE FROM administrator_has_groups WHERE administratorId='" +
                    adminId +
                    "' ";
            stmt.execute(sql);

            sql = "DELETE FROM administrators WHERE administratorId='" +
                  adminId +
                  "' ";
            stmt.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
    }

    public void removeTeacherById(int teacherId) {
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "DELETE FROM teacher_has_course WHERE teacherId='" +
                  teacherId +
                  "' ";
            stmt.execute(sql);

            sql = "DELETE FROM teacher_has_groups WHERE teacherId='" +
                  teacherId +
                  "' ";
            stmt.execute(sql);
            sql = "DELETE FROM teacher_has_privilegies WHERE teacherId_FK='" +
                  teacherId +
                  "' ";
            stmt.execute(sql);


            sql = "DELETE FROM teachers WHERE teacherId='" + teacherId +
                  "' ";
            stmt.execute(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
    }
    public void removeAssistant(int assistantId) {
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "DELETE FROM assistant_has_groups WHERE assistantId='" +
                  assistantId +
                  "' ";
            stmt.execute(sql);


            sql = "DELETE FROM assistant_has_privilegies WHERE assistantId='" +
                  assistantId +
                  "' ";
            stmt.execute(sql);


            sql = "DELETE FROM assistants WHERE assistentId='" + assistantId +
                  "' ";
            stmt.execute(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
    }

    public Vector getTeacherAssistants(int teacherId){
        Vector assistants=new Vector();
        try {
           pool = ConnectionPool.getConnectionPool();
           conn = pool.getConnection();
           Statement stmt = conn.createStatement(ResultSet.
                                                 TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_READ_ONLY);
           Statement stmt1 = conn.createStatement(ResultSet.
                   TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_READ_ONLY);
           sql = "SELECT assistentId FROM `assistants` ";
           rsLT = stmt.executeQuery(sql);
           while (rsLT.next()) {
               String countryName = rsLT.getString("assistentId");
               assistants.add(countryName);
           }
           rsLT.close();
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (pool != null) {
               pool.release(conn);
           }
       }

        return assistants;
    }
    public Vector getCountries() {
        Vector countries = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `countries` ";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                String countryName = rsLT.getString("countryName");
                countries.add(countryName);
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return countries;
    }

    public Vector getCountriesIds() {
        Vector countryIds = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `countries`";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                int countryId = rsLT.getInt("countryId");
                countryIds.add(new Integer(countryId));

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return countryIds;
    }

    public String getCountryNameByCountryId(int countryId) {

        String countryName = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `countries` WHERE countryId='" + countryId +
                  "'";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                countryName = rsLT.getString("countryName");
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return countryName;
    }

    public Vector getLanguages() {
        Vector languages = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `languages` ";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                String languageName = rsLT.getString("languageName");
                languages.add(languageName);
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return languages;
    }

    public Vector getAdministrators() {
        Vector administrators = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `administrators` ";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                int id = rsLT.getInt("administratorId");
                Integer adminId = new Integer(id);
                administrators.add(adminId);
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return administrators;
    }

    public Vector readAllCourses() {
        Vector courses = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `course` ";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                String id = rsLT.getString("courseID");

                courses.add(id);
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return courses;
    }

    public Vector getLanguagesIds() {
        Vector languagesIds = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `languages`";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                int languageId = rsLT.getInt("languageId");
                languagesIds.add(new Integer(languageId));

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return languagesIds;
    }

    public String getLanguageNameByLanguageId(int languageId) {

        String languageName = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `languages` WHERE languageId='" + languageId +
                  "'";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                languageName = rsLT.getString("languageName");
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return languageName;
    }

    public Vector getPrivilegiesIds() {
        Vector privilegieIds = new Vector();

        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `privilegies`";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                int privilegieId = rsLT.getInt("privilegieId");
                privilegieIds.add(new Integer(privilegieId));

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return privilegieIds;
    }

    public String getPrivilegieById(int privilegieId) {
        String privilegie = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `privilegies` WHERE privilegieId='" +
                  privilegieId +
                  "'";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                privilegie = rsLT.getString("privType");

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return privilegie;

    }

    public String getAdminDataById(String dataType, int adminId) {
        String data = "";
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM administrators WHERE administratorId='" +
                  adminId +
                  "' ";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                data = rsLT.getString(dataType);

            }
            rsLT.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return data;
    }

    public String getCourseName(String id) {
        String name = "";
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM course WHERE courseId='" + id + "' ";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                name = rsLT.getString("title");

            }
            rsLT.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return name;
    }

    public String getTeacherDataById(String dataType, int teacherId) {
        String data = "";
        try {

            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM teachers WHERE teacherId='" + teacherId + "' ";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                data = rsLT.getString(dataType);

            }
            rsLT.close();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return data;
    }

    public String getAdminPrivilegieNameByAdminId(int adminId) {

        String priv = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `privilegies` WHERE privilegieId=(SELECT privilegieId_FK FROM administrators WHERE administratorId=" +
                  adminId + ")";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                priv = rsLT.getString("privType");

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return priv;
    }

    public boolean checkTeacherUserName(String uName) {
        boolean val = false;
        int count = 0;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT count(*) AS x FROM teachers WHERE (userName='" +
                  uName + "' )";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                count = rsPsw.getInt("x");
                rsPsw.close();
            }
            if (count > 0) {
                val = true;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }
        return val;
    }

    public String getNewTeacherDataByType(String dataType,
                                          String teacherUserName) {
        String value = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM teachers WHERE userName='" + teacherUserName+"';";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                value = rsPsw.getString(dataType);
                rsPsw.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }

        return value;

    }

    public Vector getNewTeacherPrivilegies(int teacherId) {

        Vector privilegies = new Vector();
        String value = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT privilegieName FROM teacherPrivilegies LEFT JOIN teacher_has_privilegies ON (teacherPrivilegies.`privilegieId`=teacher_has_privilegies.`privilegieId_FK`)" +
                  "WHERE (teacher_has_privilegies.`teacherId_FK`=" + teacherId +
                  ");";
            rsPsw = stmt.executeQuery(sql);
            while (rsPsw.next()) {
                value = rsPsw.getString("privilegieName");
                privilegies.add(value);

            }
            rsPsw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }

        return privilegies;
    }


    public int getPrivilegieId(String privilegie) {
        int privId = 0;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `privilegies` WHERE privType='" + privilegie +
                  "'";

            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                privId = rsLT.getInt("privilegieId");

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }
        return privId;
    }

    public Vector getTeachersPrivilegies() {
        Vector teacherPrivilegieIds = new Vector();

        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `teacherPrivilegies`";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                int privilegieId = rsLT.getInt("privilegieId");
                teacherPrivilegieIds.add(new Integer(privilegieId));

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return teacherPrivilegieIds;

    }

    public String getTeacherPrivilegieNameById(int privilegieId) {
        String priv = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `teacherPrivilegies` WHERE privilegieId='" +
                  privilegieId + "'";
            rsLT = stmt.executeQuery(sql);
            if (rsLT.next()) {
                priv = rsLT.getString("privilegieName");

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return priv;
    }

    public Vector getTeacherPrivilegies(int teachId) {
        Vector teacherPrivilegies = new Vector();
        String priv = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT privilegieName FROM teacherPrivilegies LEFT JOIN teacher_has_privilegies ON (teacherPrivilegies.`privilegieId`=teacher_has_privilegies.`privilegieId_FK`)" +
                  "WHERE (teacher_has_privilegies.`teacherId_FK`=" + teachId +
                  ");";
            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                priv = rsLT.getString("privilegieName");
                teacherPrivilegies.add(priv);

            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return teacherPrivilegies;
    }

    public boolean checkIfGroupExists(String groupName) {

        boolean returnValue = false;
        int count = 0;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT count(*) AS x FROM groups WHERE (groupName='" +
                  groupName + "' )";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                count = rsPsw.getInt("x");

                rsPsw.close();
            }
            if (count > 0) {
                returnValue = true;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }

        return returnValue;
    }

    public String getNewGroupDataByType(String dataType, int groupId) {
        String value = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);

            sql = "SELECT * FROM groups WHERE (groupId='" + groupId + "' )";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                value = rsPsw.getString(dataType);
                rsPsw.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }

        return value;
    }

    public Vector getNewGroupVectorData(String dataType, int groupId,
                                        String sql) {

        Vector returnValue = new Vector();
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);

            rsLT = stmt.executeQuery(sql);
            while (rsLT.next()) {
                if (dataType.equals("courses")) {
                    String val = rsLT.getString("courseId");
                    returnValue.add(val);

                } else if (dataType.equals("administrators")){
                    int val = rsLT.getInt("administratorId");
                    returnValue.add(new Integer(val));

                }else if(dataType.equals("teachers")){
                    int val = rsLT.getInt("teacherId");
                    returnValue.add(new Integer(val));


                }
            }
            rsLT.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

        return returnValue;
    }
    public String getGroupLanguageById(int groupId){
        String value="";
        try {
              pool = ConnectionPool.getConnectionPool();
              conn = pool.getConnection();
              //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
              Statement stmt = conn.createStatement(ResultSet.
                                                    TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY);

              sql = "SELECT * FROM languages WHERE languageId=(SELECT languageId FROM groups WHERE groupId='"+groupId+"')" ;
              rsPsw = stmt.executeQuery(sql);
              if (rsPsw.next()) {
                  value = rsPsw.getString("languageName");
                  rsPsw.close();
              }

          } catch (Exception ex) {
              ex.printStackTrace();
          } finally {

              if (pool != null) {
                  pool.release(conn);
              }
          }

          return value;

}
      public Vector readAllGroups(){

    Vector allGroupsIds =new Vector();
    Integer id;
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            sql = "SELECT * FROM groups  ";

            rsUn = stmt.executeQuery(sql);

            while (rsUn.next()) {

                int tid = rsUn.getInt("groupId");
                id = new Integer(tid);

                allGroupsIds.add(id);

            }
            rsUn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

    return allGroupsIds;
}
public void removeGroupById(int groupId){
    try {

              pool = ConnectionPool.getConnectionPool();
              conn = pool.getConnection();
              //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
              Statement stmt = conn.createStatement(ResultSet.
                                                    TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY);
              Statement stmt1 = conn.createStatement(ResultSet.
                      TYPE_SCROLL_SENSITIVE,
                      ResultSet.CONCUR_READ_ONLY);
              sql = "DELETE FROM group_has_course WHERE groupId='" +groupId +"' ";
              stmt.execute(sql);

              sql = "DELETE FROM administrator_has_groups WHERE groupId='" +groupId +"' ";
              stmt.execute(sql);
              sql = "DELETE FROM teacher_has_groups WHERE groupId='" +groupId +"' ";
              stmt.execute(sql);
              sql = "DELETE FROM groups WHERE groupId='" +groupId +"' ";
              stmt.execute(sql);
          } catch (Exception ex) {
              ex.printStackTrace();
          } finally {
              if (pool != null) {
                  pool.release(conn);
              }
          }

}
      public boolean checkIfTeacherAlreadyHavePrivilegie(int teacherId,int privilegieId){
          boolean val=false;
          int count = 0;
        String passw = "";
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT count(*) AS x FROM teacher_has_privilegies WHERE ((teacherId_FK='" +
                  teacherId + "' ) AND (privilegieId_FK='" + privilegieId + "' ))";
            rsPsw = stmt.executeQuery(sql);
            if (rsPsw.next()) {
                count = rsPsw.getInt("x");
                rsPsw.close();
            }
            if (count == 1) {
                val = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pool != null) {
                pool.release(conn);
            }
        }

          return val;
}
      public void removeAllTeacherPrivilegies(int teacherId){
          try {

                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                  //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
                  Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  Statement stmt1 = conn.createStatement(ResultSet.
                          TYPE_SCROLL_SENSITIVE,
                          ResultSet.CONCUR_READ_ONLY);
                  sql = "DELETE FROM teacher_has_privilegies WHERE teacherId_FK='" +
                        teacherId +"' ";
                  stmt.execute(sql);



              } catch (Exception ex) {
                  ex.printStackTrace();
              } finally {
                  if (pool != null) {
                      pool.release(conn);
                  }
              }

}
          public Vector getCourses(){
              Vector coursesIds=new Vector();
              try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            sql = "SELECT * FROM course";

            rsUn = stmt.executeQuery(sql);

            while (rsUn.next()) {

                String cid = rsUn.getString("courseId");


                coursesIds.add(cid);

            }
            rsUn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }

              return coursesIds;
}
}
