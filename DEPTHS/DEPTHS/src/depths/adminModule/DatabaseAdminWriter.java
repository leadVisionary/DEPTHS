package depths.adminModule;
import java.sql.*;
import depths.utility.ConnectionPool;

public class DatabaseAdminWriter {
  private CallableStatement cs;
  private ConnectionPool pool=null;
   private Connection conn=null;

  public DatabaseAdminWriter() {
  }
  //Upisuje osnovne podatke o studentu u bazu podataka
  public void newAdminRegistration(Integer adminID, String fName, String lName,String uName,
                               String passw,String email,String addr,
                                     String city, int country, String organization,
                                     String webSite, String language, String privilegies){
         try  {
           pool=ConnectionPool.getConnectionPool();
           conn=pool.getConnection();
             cs=conn.prepareCall("{call spInsertNewAdminData(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
             cs.setInt(1,adminID.intValue());
             cs.setString(2,fName);
             cs.setString(3,lName);
             cs.setString(4,uName);
             cs.setString(5,passw);
             cs.setString(6,email);
             cs.setString(7,addr);
             cs.setString(8,city);
             cs.setInt(9,country);
             cs.setString(10,organization);
             cs.setString(11,webSite);
             cs.setString(12,language);
             cs.setString(13, privilegies);
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
     public void updateAdminData(int admId,String dataType,int newPrivilegieId){
       try  {
                  pool=ConnectionPool.getConnectionPool();
                  conn=pool.getConnection();
                    cs=conn.prepareCall("{call spUpdateAdminPrivilegies(?,?)}");
                    cs.setInt(1,admId);
                    cs.setInt(2,newPrivilegieId);


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
     public void updateAdminData(String fName,String lName,String uName,String email,
        String password,String address,String city,int country,String organisation,
        String webSite,int language){
       try  {
                      pool=ConnectionPool.getConnectionPool();
                      conn=pool.getConnection();
                        cs=conn.prepareCall("{call spUpdateAdminData(?,?,?,?,?,?,?,?,?,?,?)}");
                        cs.setString(1,fName);
                       cs.setString(2,lName);
                       cs.setString(3,uName);
                       cs.setString(4,email);
                       cs.setString(5,password);
                       cs.setString(6,address);
                       cs.setString(7,city);
                       cs.setInt(8,country);
                       cs.setString(9,organisation);
                       cs.setString(10,webSite);
                       cs.setInt(11,language);

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
         public void createNewTeacher(int teacherId,String fName,String lName,
                                      String uName,String email,
                             String passw,String address,String city,int countryId,
String organisation,String webS,int langId,int adminId){

  try  {

             pool=ConnectionPool.getConnectionPool();
             conn=pool.getConnection();
               cs=conn.prepareCall("{call spInsertNewTeacherData(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
               cs.setInt(1,teacherId);
               cs.setString(2,fName);
               cs.setString(3,lName);
               cs.setString(4,uName);
               cs.setString(5,passw);
               cs.setString(6,email);
               cs.setString(7,address);
               cs.setString(8,city);
               cs.setInt(9,countryId);
               cs.setString(10,organisation);
               cs.setString(11,webS);
               cs.setInt(12,langId);
               cs.setInt(13,adminId);

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
     public void createNewTeacherPrivilegies(int teacherId,int privId){


       try  {
                            pool=ConnectionPool.getConnectionPool();
                            conn=pool.getConnection();
                              cs=conn.prepareCall("{call spInsertTeacherPrivilegies(?,?)}");
                              cs.setInt(1,teacherId);
                             cs.setInt(2,privId);


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
         public void setGroupData(int groupId,String groupName, int langId,String description){
           try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            cs = conn.prepareCall("{call spInsertGroupData(?,?,?,?)}");
            cs.setInt(1, groupId);
            cs.setString(2, groupName);
            cs.setInt(3,langId);
            cs.setString(4,description);
            cs.executeQuery();

          }
          catch (Exception ex) {
            ex.printStackTrace();

          }
          finally {
            if (pool != null)
              pool.release(conn);

          }

  }

 public void setGroupAdministrator(int groupId,int adminId){

   try {
     pool = ConnectionPool.getConnectionPool();
     conn = pool.getConnection();
     cs = conn.prepareCall("{call spInsertGroupAdministrator(?,?)}");
     cs.setInt(1, groupId);
     cs.setInt(2, adminId);
     cs.executeQuery();

   }
   catch (Exception ex) {
     ex.printStackTrace();

   }
   finally {
     if (pool != null)
       pool.release(conn);

   }
 }
 public void setGroupTeacher(int groupId,int teacherId){

   try {
    pool = ConnectionPool.getConnectionPool();
    conn = pool.getConnection();
    cs = conn.prepareCall("{call spInsertGroupTeacher(?,?)}");
    cs.setInt(1, groupId);
    cs.setInt(2, teacherId);
    cs.executeQuery();

  }
  catch (Exception ex) {
    ex.printStackTrace();

  }
  finally {
    if (pool != null)
      pool.release(conn);

  }

  }
  public void setGroupCourse(int groupId,String courseId){
    try {
  pool = ConnectionPool.getConnectionPool();
  conn = pool.getConnection();
  cs = conn.prepareCall("{call spInsertGroupCourse(?,?)}");
  cs.setInt(1, groupId);
  cs.setString(2, courseId);
  cs.executeQuery();

}
catch (Exception ex) {
  ex.printStackTrace();

}
finally {
  if (pool != null)
    pool.release(conn);

}

  }
  public void setCourseForTeacher(String courseId,int teacherId){
      try {
  pool = ConnectionPool.getConnectionPool();
  conn = pool.getConnection();
  cs = conn.prepareCall("{call spInsertTeacherCourse(?,?)}");
  cs.setInt(1, teacherId);
  cs.setString(2, courseId);
  cs.executeQuery();

}
catch (Exception ex) {
  ex.printStackTrace();

}
finally {
  if (pool != null)
    pool.release(conn);

}


}

}
