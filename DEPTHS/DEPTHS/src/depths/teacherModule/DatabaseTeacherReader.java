package depths.teacherModule;

import depths.utility.ConnectionPool;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Vector;
public class DatabaseTeacherReader {
    private ConnectionPool pool = null;
    private Connection conn = null;
     private String sql= null;
     private ResultSet rsUn = null;
     private ResultSet rsPsw = null;
        //vraca true ukoliko u bazi podataka postoji korisnik sa istim korisnickim imenom
            public boolean checkTeacherUserName(String uName) {
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
                            "SELECT teachers.username FROM teachers WHERE username='" +
                            uName + "' ";
                    rsUn = stmt.executeQuery(sql);
                    if (rsUn.next()) {
                        cUName = rsUn.getString("username");
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
                public boolean checkTeacherPassword(String uName, String pass) {
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
                        sql = "SELECT count(*) AS x FROM teachers WHERE ((username='" +
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
                public Vector checkTeacherPrivilegies(int teacherId) {
                        String privil = "";
                        Vector privVector=new Vector();
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

                            rsUn = stmt.executeQuery(sql);
                            while (rsUn.next()) {
                                privil = rsUn.getString("privilegieName");
                                privVector.add(privil);


                            }
                             rsUn.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            if (pool != null) {
                                pool.release(conn);
                            }
                        }
                        return privVector;
    }
    public Vector getTeacherCoursesIds(int teacherId){
        String courseId="";
    Vector courses=new Vector();
    try {
                            pool = ConnectionPool.getConnectionPool();
                            conn = pool.getConnection();
                            //conn=DriverManager.getConnection("jdbc:mysql://localhost/studentmodel?user=root&password=daewoo");
                            Statement stmt = conn.createStatement(ResultSet.
                                                                  TYPE_SCROLL_SENSITIVE,
                                                                  ResultSet.CONCUR_READ_ONLY);

                            sql = "SELECT courseId FROM teacher_has_course WHERE teacherId='" + teacherId +"';";

                            rsUn = stmt.executeQuery(sql);
                            while (rsUn.next()) {
                                courseId = rsUn.getString("courseId");
                                courses.add(courseId);


                            }
                             rsUn.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            if (pool != null) {
                                pool.release(conn);
                            }
                        }

    return courses;
}
public String getCourseNameById(String courseId){
    String name="";
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
                       sql = "SELECT title FROM course WHERE courseID='"+courseId+"'";
                       rsPsw = stmt.executeQuery(sql);
                       if (rsPsw.next()) {
                           name = rsPsw.getString("title");
                           rsPsw.close();
                       }

                   } catch (Exception ex) {
                       ex.printStackTrace();
                   } finally {

                       if (pool != null) {
                           pool.release(conn);
                       }
                   }

    return name;

}

}
