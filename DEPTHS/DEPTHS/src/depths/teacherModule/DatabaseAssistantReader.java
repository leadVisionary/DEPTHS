package depths.teacherModule;

import depths.utility.ConnectionPool;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Vector;
public class DatabaseAssistantReader {
    private ConnectionPool pool = null;
    private Connection conn = null;
     private String sql= null;
     private ResultSet rsUn = null;
     private ResultSet rsPsw = null;
        //vraca true ukoliko u bazi podataka postoji korisnik sa istim korisnickim imenom
            public boolean checkNewAssistantUserName(String uName) {
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
                            "SELECT assistants.username FROM assistants WHERE username='" +
                            uName + "' ";
                    rsUn = stmt.executeQuery(sql);
                    while (rsUn.next()) {
                        cUName = rsUn.getString("username");
                        if (cUName.equals(uName)) {

                        userExist = true;
                    }


                    }
                    sql="SELECT teachers.username FROM teachers WHERE username='" +
                            uName + "' ";
                        rsUn = stmt.executeQuery(sql);
                         while (rsUn.next()) {
                             cUName = rsUn.getString("username");
                             if (cUName.equals(uName)) {


                             userExist = true;
                         }

                             rsUn.close();
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
public Vector getAssistantPrivilegies(){
         Vector assistantPrivilegieIds= new Vector();

        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
            Statement stmt1 = conn.createStatement(ResultSet.
                    TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = "SELECT * FROM `assistantPrivilegies`";
            rsUn = stmt.executeQuery(sql);
            while (rsUn.next()) {
                int privilegieId = rsUn.getInt("privilegieId");
                assistantPrivilegieIds.add(new Integer(privilegieId));

            }
            rsUn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pool != null) {
                pool.release(conn);
            }
        }



         return assistantPrivilegieIds;
  }
public String getAssistantPrivilegieNameById(int privilegieId){
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
       sql = "SELECT * FROM `assistantPrivilegies` WHERE privilegieId='" +
             privilegieId + "'";
       rsUn = stmt.executeQuery(sql);
       if (rsUn.next()) {
           priv = rsUn.getString("privilegieName");

       }
       rsUn.close();
   } catch (Exception ex) {
       ex.printStackTrace();
   } finally {
       if (pool != null) {
           pool.release(conn);
       }
   }

   return priv;

   }
   public Vector     getTeacherGroupsIds(int teacherId){
          Vector teachGroupsIds=new Vector();

          try {
           pool = ConnectionPool.getConnectionPool();
           conn = pool.getConnection();
           Statement stmt = conn.createStatement(ResultSet.
                                                 TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_READ_ONLY);

           sql = "SELECT * FROM `teacher_has_groups` WHERE teacherId="+teacherId+";";
           rsUn = stmt.executeQuery(sql);
           while (rsUn.next()) {
               int privilegieId = rsUn.getInt("groupId");
               teachGroupsIds.add(new Integer(privilegieId));

           }
           rsUn.close();
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (pool != null) {
               pool.release(conn);
           }
       }

          return teachGroupsIds;
   }
   public String getGroupNameById(int groupId){
          String name= "";
  try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.
                                            TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);

      sql = "SELECT * FROM `groups` WHERE groupId='" +
            groupId + "'";
      rsUn = stmt.executeQuery(sql);
      if (rsUn.next()) {
          name = rsUn.getString("groupName");

      }
      rsUn.close();
  } catch (Exception ex) {
      ex.printStackTrace();
  } finally {
      if (pool != null) {
          pool.release(conn);
      }
  }



          return name;
   }
   public String getNewAssistantDataByType(String dataType,int assistantId){
          String value="";
  try {
      pool = ConnectionPool.getConnectionPool();
      conn = pool.getConnection();
      Statement stmt = conn.createStatement(ResultSet.
                                            TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      sql = "SELECT * FROM `assistants` WHERE assistentId='" +
            assistantId + "'";
      rsUn = stmt.executeQuery(sql);
      if (rsUn.next()) {
          value = rsUn.getString(dataType);

      }
      rsUn.close();
  } catch (Exception ex) {
      ex.printStackTrace();
  } finally {
      if (pool != null) {
          pool.release(conn);
      }
  }
   return value;
   }
   public Vector getNewAssistantPrivilegies(int assistantId){
       Vector privilegies=new Vector();
       try {
           pool = ConnectionPool.getConnectionPool();
           conn = pool.getConnection();
           Statement stmt = conn.createStatement(ResultSet.
                                                 TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_READ_ONLY);

           sql = "SELECT * FROM `assistant_has_privilegies` WHERE assistantId="+assistantId+";";
           rsUn = stmt.executeQuery(sql);
           while (rsUn.next()) {
               int privilegieId = rsUn.getInt("privilegieId");
               privilegies.add(new Integer(privilegieId));

           }
           rsUn.close();
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (pool != null) {
               pool.release(conn);
           }
       }

       return privilegies;
   }
   public Vector getNewAssistantGroups(int assistantId){
          Vector groups=new Vector();
          try {
              pool = ConnectionPool.getConnectionPool();
              conn = pool.getConnection();
              Statement stmt = conn.createStatement(ResultSet.
                                                    TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY);

              sql = "SELECT * FROM `assistant_has_groups` WHERE assistantId="+assistantId+";";
              rsUn = stmt.executeQuery(sql);
              while (rsUn.next()) {
                  int groupId = rsUn.getInt("groupId");
                  groups.add(new Integer(groupId));

              }
              rsUn.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          } finally {
              if (pool != null) {
                  pool.release(conn);
              }
          }

          return groups;
   }
   public Vector readAllAssistants(int teacherId){
       Vector allAssistantsIds=new Vector();
       try {
              pool = ConnectionPool.getConnectionPool();
              conn = pool.getConnection();
              Statement stmt = conn.createStatement(ResultSet.
                                                    TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY);

              sql = "SELECT * FROM `assistants` WHERE teacherId="+teacherId+";";
              rsUn = stmt.executeQuery(sql);
              while (rsUn.next()) {
                  int assId = rsUn.getInt("assistentId");
                  allAssistantsIds.add(new Integer(assId));

              }
              rsUn.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          } finally {
              if (pool != null) {
                  pool.release(conn);
              }
          }


       return allAssistantsIds;
}
   public void removeAssistantById(int assistantId) {
        try {
            pool = ConnectionPool.getConnectionPool();
            conn = pool.getConnection();
            Statement stmt = conn.createStatement(ResultSet.
                                                  TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
           sql =
                    "DELETE FROM assistant_has_groups WHERE assistantId='" +
                    assistantId +
                    "' ";
            stmt.execute(sql);

            sql =
                    "DELETE FROM assistant_has_privilegies WHERE assistantId='" +
                    assistantId +
                    "' ";

            stmt.execute(sql);

            sql =
                    "DELETE FROM assistants WHERE assistentId='" +
                    assistantId +
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
    public void removeAllAssistantPrivilegies(int assistantId){
        try {
             pool = ConnectionPool.getConnectionPool();
             conn = pool.getConnection();
             Statement stmt = conn.createStatement(ResultSet.
                                                   TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);
            sql =
                     "DELETE FROM assistant_has_privilegies WHERE assistantId='" +
                     assistantId +"' ";
             stmt.execute(sql);
          } catch (Exception ex) {
             ex.printStackTrace();
         } finally {
             if (pool != null) {
                 pool.release(conn);
             }
         }

    }
    public void removeAllAssistantGroups(int assistantId){
        try {
             pool = ConnectionPool.getConnectionPool();
             conn = pool.getConnection();
             Statement stmt = conn.createStatement(ResultSet.
                                                   TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);
            sql =
                     "DELETE FROM assistant_has_groups WHERE assistantId='" +
                     assistantId +"' ";
             stmt.execute(sql);
          } catch (Exception ex) {
             ex.printStackTrace();
         } finally {
             if (pool != null) {
                 pool.release(conn);
             }
         }

}

}

