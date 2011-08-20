package depths.teacherModule;


import java.sql.*;
import depths.utility.ConnectionPool;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DatabaseStudentWriter {
    private CallableStatement cs;
    private ConnectionPool pool = null;
    private Connection conn = null;
    private SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    //Upisuje osnovne podatke o studentu u bazu podataka
    public void createNewStudent(String fName, String lName,
                                   String uName,int studentId,
                                   String email, String passw, String address,
                                   String city, int countryId,
                                   String organisation,
                                   String webS, int langId) {

        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            cs = conn.prepareCall(
                    "{call spInsertStudentData(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, studentId);
            cs.setString(2, fName);
            cs.setString(3, lName);
            cs.setString(4, uName);
            cs.setString(5, passw);
            cs.setString(6, email);
            cs.setString(7, address);
            cs.setString(8, city);
            cs.setInt(9, countryId);
            cs.setString(10, organisation);
            cs.setString(11, webS);
            cs.setInt(12, langId);

            cs.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (pool != null)
                pool.release(conn);
        }
    }
    public void settingStudentPerformances(int studentId,double inSkLev,int detailLevel,String programmingLanguage,String displayForm){
        try  {
                pool=ConnectionPool.getConnectionPool();
                conn=pool.getConnection();
                  cs=conn.prepareCall("{call spInsertStudentInitialPerformances(?,?,?,?)}");
                  cs.setInt(1,studentId);
                   cs.setDouble(2,inSkLev);
                  cs.setInt(3,detailLevel);
                  cs.setString(4,programmingLanguage);
                  cs.executeQuery();
                         }
              catch (Exception ex)  {
                         ex.printStackTrace();

                             }
              finally
            {
               if(pool!=null)
                 pool.release(conn);
            }

}
public void settingStudentGroup(int studentId,int groupId){
    try  {
          pool=ConnectionPool.getConnectionPool();
          conn=pool.getConnection();
          cs = conn.prepareCall(
          "{call spUpdateStudentGroup(?,?)}");
      cs.setInt(1, studentId);
      cs.setInt(2,groupId);

      cs.executeQuery();
                 }
        catch (Exception ex)  {
                   ex.printStackTrace();

                       }
        finally
      {
         if(pool!=null)
           pool.release(conn);
      }

}
  public void setCourseData(int studentId,String courseId,Date date,int groupId){
      System.out.println("DatabaseStudentWriter setCourseData groupId="+groupId);
      try  {


            pool=ConnectionPool.getConnectionPool();
            conn=pool.getConnection();
            cs = conn.prepareCall(
            "{call spInsertStudentInCourse(?,?,?,?,?,?)}");
        cs.setInt(1, studentId);
        cs.setString(2,df.format(date));
        cs.setString(3,df.format(date));
        cs.setInt(4, 1);
        cs.setInt(5,groupId);
        cs.setString(6,courseId);

        cs.executeQuery();
                   }
          catch (Exception ex)  {
                     ex.printStackTrace();

                         }
          finally
        {
           if(pool!=null)
             pool.release(conn);
        }

}
    public void setCourseHasStudentsInCourse(int courseId,int studentInCourseId){

    }

}
