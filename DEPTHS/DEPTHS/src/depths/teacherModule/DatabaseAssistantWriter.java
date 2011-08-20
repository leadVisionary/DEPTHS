package depths.teacherModule;


import java.sql.*;
import depths.utility.ConnectionPool;

public class DatabaseAssistantWriter {
  private CallableStatement cs;
  private ConnectionPool pool=null;
   private Connection conn=null;

  public DatabaseAssistantWriter() {
  }
  //Upisuje osnovne podatke o studentu u bazu podataka
  public void createNewAssistant(String fName,String lName,int assistantId,String uName,
                                  String email,String passw,String address,
                                  String city,int countryId,String organisation,
                                 String webS,int langId,int teacherId){



         try  {
           pool=ConnectionPool.getConnectionPool();
           conn=pool.getConnection();
             cs=conn.prepareCall("{call spInsertNewAssistantData(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
             cs.setInt(1,assistantId);
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
             cs.setInt(13, teacherId);
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
   public void setAssistantPrivilegie(int assistantId,int privilegieId){
       try  {
       pool=ConnectionPool.getConnectionPool();
       conn=pool.getConnection();
         cs=conn.prepareCall("{call spInsertNewAssistantPrivilegie(?,?)}");
         cs.setInt(1,assistantId);
         cs.setInt(2,privilegieId);

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
      public void setAssistantGroup(int assistantId,int groupId){
          try  {
       pool=ConnectionPool.getConnectionPool();
       conn=pool.getConnection();
         cs=conn.prepareCall("{call spInsertNewAssistantGroup(?,?)}");
         cs.setInt(1,assistantId);
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

}
