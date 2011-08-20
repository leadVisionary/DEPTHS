package depths.teacherModule;

import depths.utility.ConnectionPool;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Vector;
public class DatabaseStudentReader {
    private ConnectionPool pool = null;
    private Connection conn = null;
     private String sql= null;
     private ResultSet rsUn = null;
     private ResultSet rsPsw = null;
        //vraca true ukoliko u bazi podataka postoji korisnik sa istim korisnickim imenom
            public boolean checkNewStudentUserName(String uName) {
                String cUName = "";
                boolean userExist = false;
                try {
                    pool = ConnectionPool.getConnectionPool();
                    conn = pool.getConnection();
                             Statement stmt = conn.createStatement(ResultSet.
                                                          TYPE_SCROLL_SENSITIVE,
                                                          ResultSet.CONCUR_READ_ONLY);
                    Statement stmt1 = conn.createStatement(ResultSet.
                            TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    sql =
                            "SELECT students.username FROM students WHERE username='" +
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

            public String getStudentDataByType(String dataType,int studentId){
                String value="";
                try {
                   pool = ConnectionPool.getConnectionPool();
                   conn = pool.getConnection();
                    Statement stmt = conn.createStatement(ResultSet.
                                                         TYPE_SCROLL_SENSITIVE,
                                                         ResultSet.CONCUR_READ_ONLY);
                   sql =
                           "SELECT * FROM students WHERE studentId='" +
                           studentId + "' ";
                   rsUn = stmt.executeQuery(sql);
                   while (rsUn.next()) {
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
        public Vector    getStudentsIdsInGroup(int groupId){
            Vector studIds=new Vector();
            try {
                    pool = ConnectionPool.getConnectionPool();
                    conn = pool.getConnection();
                      Statement stmt = conn.createStatement(ResultSet.
                                                          TYPE_SCROLL_SENSITIVE,
                                                          ResultSet.CONCUR_READ_ONLY);
                    sql =
                            "SELECT students.studentId FROM students WHERE groupId='" +
                           groupId + "' ";
                    rsUn = stmt.executeQuery(sql);
                    while (rsUn.next()) {
                       int stId= rsUn.getInt("studentId");
                        studIds.add(new Integer(stId));
                    }
                             rsUn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    if (pool != null) {
                        pool.release(conn);
                    }
                }
                return studIds;
        }
        public int getGroupIdByName(String groupSection){
            int grId=0;
            try {
                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                       Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  sql =
                          "SELECT * FROM groups WHERE groupName='" +
                          groupSection + "' ";
                  rsUn = stmt.executeQuery(sql);
                  while (rsUn.next()) {
                      grId = rsUn.getInt("groupId");
            }
                           rsUn.close();
              } catch (Exception ex) {
                  ex.printStackTrace();
              } finally {
                  if (pool != null) {
                      pool.release(conn);
                  }
              }
            return grId;
        }
       public Vector getCourseIdsForGroup(int groupId){
           System.out.println("DatabaseStudentReader getCourseIdsForGroup groupId="+groupId);
           Vector courses=new Vector();
           String courseId;
           try {
                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                          Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  sql =
                          "SELECT * FROM group_has_course WHERE groupId='" +
                          groupId + "' ";
                  rsUn = stmt.executeQuery(sql);
                  while (rsUn.next()) {
                       courseId= rsUn.getString("courseId");
                       courses.add(courseId);
                       System.out.println("DatabaseStudentReader getCourseIdsForGroup courseId="+courseId);
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
       public Vector getIdStudentsInCourseFromCourseHasStudents(int groupId){

           Vector studentIds=new Vector();
           String studentId="";
           try {
                 pool = ConnectionPool.getConnectionPool();
                 conn = pool.getConnection();
                                Statement stmt = conn.createStatement(ResultSet.
                                                       TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);

                 sql =
                         "SELECT IDStudentInCourse FROM studentsInCourse WHERE groupId='" +
                         groupId + "' ";
                 rsUn = stmt.executeQuery(sql);
                 while (rsUn.next()) {
                      studentId= rsUn.getString("IDStudentInCourse");
                      studentIds.add(studentId);



                 }
                          rsUn.close();



             } catch (Exception ex) {
                 ex.printStackTrace();
             } finally {
                 if (pool != null) {
                     pool.release(conn);
                 }
             }

           return studentIds;
       }
       public String getCourseIdByName(String course){
    String courseId="";
    try {
                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                              Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  sql =
                          "SELECT courseID FROM course WHERE title='" +
                          course + "' ";
                  rsUn = stmt.executeQuery(sql);
                  if (rsUn.next()) {
                       courseId= rsUn.getString("courseID");
                     }
                           rsUn.close();
              } catch (Exception ex) {
                  ex.printStackTrace();
              } finally {
                  if (pool != null) {
                      pool.release(conn);
                  }
              }

    return courseId;
}

       public Vector getConceptsTitlesInTheCourse(String courseId){
    Vector conceptTitles=new Vector();
    String conceptName;

          try {
                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                  Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  sql =
                          "SELECT title FROM concept WHERE courseId='" +
                          courseId + "' ";
                  rsUn = stmt.executeQuery(sql);
                  while (rsUn.next()) {
                       conceptName= rsUn.getString("title");
                       conceptTitles.add(conceptName);
     }
                           rsUn.close();
              } catch (Exception ex) {
                  ex.printStackTrace();
              } finally {
                  if (pool != null) {
                      pool.release(conn);
                  }
              }

    return conceptTitles;
}
public String getConceptIdByName(String courseId,String conceptName){
     String concId="";
     try {
                 pool = ConnectionPool.getConnectionPool();
                 conn = pool.getConnection();
                     Statement stmt = conn.createStatement(ResultSet.
                                                       TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);
                 sql =
                         "SELECT conceptId FROM concept WHERE courseId='" +
                         courseId + "' AND title='"+conceptName+"'";
                 rsUn = stmt.executeQuery(sql);
                 if (rsUn.next()) {
                      concId= rsUn.getString("conceptId");

                 }
                          rsUn.close();
  } catch (Exception ex) {
                 ex.printStackTrace();
             } finally {
                 if (pool != null) {
                     pool.release(conn);
                 }
             }

     return concId;
  }
  public double getConceptsDegrees(String courseId,String concId){

      double deg=0.0,averageDegree=0.0;
      Vector allDegrees=new Vector();
      try {
                 pool = ConnectionPool.getConnectionPool();
                 conn = pool.getConnection();
                  Statement stmt = conn.createStatement(ResultSet.
                                                       TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);
                 sql =
                         "SELECT degreeOfMastery FROM conceptsInCourseForStudent WHERE courseId='" +
                         courseId + "' AND conceptID='"+concId+"'";
                 rsUn = stmt.executeQuery(sql);
                 while (rsUn.next()) {
                      deg= rsUn.getDouble("degreeOfMastery");

                      allDegrees.add(new Double(deg));

                 }
                          rsUn.close();
int size=allDegrees.size();

                          for (int i=0;i<size;i++){
               double val=  Double.parseDouble(allDegrees.get(i).toString());
                              averageDegree=averageDegree+val;
                          }
                          if (size==0){
                              averageDegree=0.0;
                          }else{
                              averageDegree = averageDegree / size;
                          }

             } catch (Exception ex) {
                 ex.printStackTrace();
             } finally {
                 if (pool != null) {
                     pool.release(conn);
                 }
             }

      return averageDegree;
  }
  public double getConceptsKnowledgeLevel(String courseId,String concId){
      double knLev=0.0,averageKnLev=0.0;
      Vector allKnLev=new Vector();
      try {
                 pool = ConnectionPool.getConnectionPool();
                 conn = pool.getConnection();
                  Statement stmt = conn.createStatement(ResultSet.
                                                       TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);
                 sql =
                         "SELECT knowledgeLevel FROM conceptsInCourseForStudent WHERE courseId='" +
                         courseId + "' AND conceptID='"+concId+"'";
                 rsUn = stmt.executeQuery(sql);
                 while (rsUn.next()) {
                      knLev= rsUn.getDouble("knowledgeLevel");
                      allKnLev.add(new Double(knLev));
                 }
                          rsUn.close();
int size=allKnLev.size();
                          for (int i=0;i<size;i++){
                                  double val=  Double.parseDouble(allKnLev.get(i).toString());
                              averageKnLev=averageKnLev+val;
                          }
                          if (size==0){
                              averageKnLev=0.0;
                          }else{
                              averageKnLev = averageKnLev / size;
                          }
             } catch (Exception ex) {
                 ex.printStackTrace();
             } finally {
                 if (pool != null) {
                     pool.release(conn);
                 }
             }

      return averageKnLev;
  }
  public double getConceptsDegrees(String courseId,String concId,int groupId){
      double deg=0.0,averageDegree=0.0;
      Vector allDegrees=new Vector();
      try {
                 pool = ConnectionPool.getConnectionPool();
                 conn = pool.getConnection();
                  Statement stmt = conn.createStatement(ResultSet.
                                                       TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);
                 sql =
                         "SELECT degreeOfMastery FROM conceptsInCourseForStudent WHERE courseId='" +
                         courseId + "' AND conceptID='"+concId+"'";
                 rsUn = stmt.executeQuery(sql);
                 while (rsUn.next()) {
                      deg= rsUn.getDouble("degreeOfMastery");
                      allDegrees.add(new Double(deg));
                 }
                          rsUn.close();
int size=allDegrees.size();
                          for (int i=0;i<size;i++){
                                  double val=  Double.parseDouble(allDegrees.get(i).toString());
                              averageDegree=averageDegree+val;
                          }
                          if (size==0){
                              averageDegree=0.0;
                          }else{
                              averageDegree = averageDegree / size;
                          }
             } catch (Exception ex) {
                 ex.printStackTrace();
             } finally {
                 if (pool != null) {
                     pool.release(conn);
                 }
             }
      return averageDegree;
  }
  public double getConceptsDegreesForGroup(String concId,int IdStudentInCourse){
      double deg=0.0,averageDegree=0.0;
     Vector allDegrees=new Vector();
     try {
                pool = ConnectionPool.getConnectionPool();
                conn = pool.getConnection();
                Statement stmt = conn.createStatement(ResultSet.
                                                      TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
                sql =
                        "SELECT degreeOfMastery FROM conceptsInCourseForStudent WHERE IDStudentInCourse='" +
                        IdStudentInCourse + "' AND conceptID='"+concId+"'";
                rsUn = stmt.executeQuery(sql);
                while (rsUn.next()) {
                     deg= rsUn.getDouble("degreeOfMastery");
                     allDegrees.add(new Double(deg));
                }
                         rsUn.close();
int size=allDegrees.size();
                         for (int i=0;i<size;i++){
                                 double val=  Double.parseDouble(allDegrees.get(i).toString());
                             averageDegree=averageDegree+val;
                         }
                         if (size==0){
                             averageDegree=0.0;
                         }else{
                             averageDegree = averageDegree / size;
                         }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (pool != null) {
                    pool.release(conn);
                }
                return averageDegree;
            }
  }
  public double getConceptsKnowledgeLevelForGroup(String concId,int IdStudentInCourse){
        double knLev=0.0;
            try {
                  pool = ConnectionPool.getConnectionPool();
                  conn = pool.getConnection();
                 Statement stmt = conn.createStatement(ResultSet.
                                                        TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
                  sql ="SELECT knowledgeLevel FROM conceptsInCourseForStudent WHERE IDStudentInCourse='" +
                          IdStudentInCourse + "' AND conceptID='"+concId+"'";
                  rsUn = stmt.executeQuery(sql);
                  if (rsUn.next()) {
                       knLev= rsUn.getDouble("knowledgeLevel");
                 }
                           rsUn.close();
               } catch (Exception ex) {
                  ex.printStackTrace();
              } finally {
                  if (pool != null) {
                      pool.release(conn);
                  }
                  return knLev;
              }
  }
  public double getConceptsDegreesForStudent(String courseId,String concId,int idStudInCourse){
      double value = 0.0;
      try {
          pool = ConnectionPool.getConnectionPool();
          conn = pool.getConnection();
          Statement stmt = conn.createStatement(ResultSet.
                                                TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
          sql = "SELECT degreeOfMastery FROM conceptsInCourseForStudent WHERE (IDStudentInCourse='" +
                idStudInCourse + "' AND conceptID='" + concId +
                "' AND courseId='" + courseId + "')";
          rsUn = stmt.executeQuery(sql);
          if (rsUn.next()) {
              value = rsUn.getDouble("degreeOfMastery");
          }
          rsUn.close();
      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
          if (pool != null) {
              pool.release(conn);
          }

          return value;
      }
  }
  public int getStudentIdByStudentInCourse(int studentInCourse){
      int studId = 0;
      try {
          pool = ConnectionPool.getConnectionPool();
          conn = pool.getConnection();
          Statement stmt = conn.createStatement(ResultSet.
                                                TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
          sql =
                  "SELECT studentID FROM studentsInCourse WHERE (IDStudentInCourse='" +
                  studentInCourse + "')";
          rsUn = stmt.executeQuery(sql);
          if (rsUn.next()) {
              studId = rsUn.getInt("studentID");
          }
          rsUn.close();
      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
          if (pool != null) {
              pool.release(conn);
          }

      }
       return studId;
  }
 public int getIdStudentInCourseForStudent(String courseId,int studId){
     System.out.println("DatabaseStudentReader getIdStudentInCourseForStudent courseId="+courseId+" studId="+studId);
     int studInCourseId=0;
     try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql =
                 "SELECT IDStudentInCourse FROM studentsInCourse WHERE (studentId='" +
                 studId + "' AND courseId='"+courseId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             studInCourseId = rsUn.getInt("IDStudentInCourse");

         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }

     }
     System.out.println("DatabaseStudentReader getIdStudentInCourseForStudent return "+studInCourseId);
     return studInCourseId;
 }
 public Vector getPassedConceptsForStudent(int studentInCourseId){
     Vector studentConcepts=new Vector();
     System.out.println("DatabaseStudentReader getPassedConceptsForStudent studentInCourseId="+studentInCourseId);
     try {
                pool = ConnectionPool.getConnectionPool();
                conn = pool.getConnection();
                Statement stmt = conn.createStatement(ResultSet.
                                                      TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
                sql =
                        "SELECT conceptID FROM conceptsInCourseForStudent WHERE IDStudentInCourse='" +
                        studentInCourseId + "'";
                rsUn = stmt.executeQuery(sql);
                while (rsUn.next()) {
                    String cId = rsUn.getString("conceptID");


                     studentConcepts.add(cId);
                }
                         rsUn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (pool != null) {
                    pool.release(conn);
                }
            }
            return studentConcepts;
 }
 public double getConceptDegreesForStudent(int idStudentInCourse,String conceptId){
        double degree=0.0;
        try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql =
                 "SELECT degreeOfMastery FROM conceptsInCourseForStudent WHERE (conceptId='" +
                 conceptId + "' AND IDStudentInCourse='"+idStudentInCourse+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             degree = rsUn.getDouble("degreeOfMastery");

         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }

     }

        return degree;
    }
    public double getStudentPassedConceptActualSkillLevel(int idStudentInCourse,
            String conceptId){

        double actSkLev=0.0;
        try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql =
                 "SELECT knowledgeLevel FROM conceptsInCourseForStudent WHERE (conceptId='" +
                 conceptId + "' AND IDStudentInCourse='"+idStudentInCourse+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             actSkLev = rsUn.getDouble("knowledgeLevel");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }
        return actSkLev;
     }

    public String getConceptName(String courseId,String concId){
        String cName="";
        try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql =
                 "SELECT title FROM concept WHERE (conceptID='" +
                 concId + "' AND courseID='"+courseId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             cName = rsUn.getString("title");

         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }

     }

        return cName;
     }
     public Vector   getPassedLessonsInConceptForStudent(int idConceptInCourseForStudent){
        Vector lessons=new Vector();
        try {
                pool = ConnectionPool.getConnectionPool();
                conn = pool.getConnection();
                Statement stmt = conn.createStatement(ResultSet.
                                                      TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
                sql =
                        "SELECT unitID FROM unitsInConceptForStudent WHERE IDConceptInCourseForStudent='" +
                        idConceptInCourseForStudent + "'";
                rsUn = stmt.executeQuery(sql);
                while (rsUn.next()) {
                    String uId = rsUn.getString("unitID");

                     lessons.add(uId);
                }
                         rsUn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (pool != null) {
                    pool.release(conn);
                }
            }

    return lessons;
}
public String getLessonNameById(String concId,String lessonId){
    String lName = "";
    try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql = "SELECT title FROM unit WHERE (conceptID='" +
                 concId + "' AND unitID='"+lessonId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             lName = rsUn.getString("title");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }

    return lName;

}
public int getLessonNumberOfPassess(int idConceptInCourse,String lessonId){
        int numb=0;
        try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql = "SELECT numberOfPasses FROM unitsInConceptForStudent WHERE (IDConceptInCourseForStudent='" +
                 idConceptInCourse + "' AND unitID='"+lessonId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             numb = rsUn.getInt("numberOfPasses");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }

        return numb;
    }
    public Vector getPassedTestsInConceptForStudent(int idConceptInCourseForStudent){
    Vector tests=new Vector();
    try {
               pool = ConnectionPool.getConnectionPool();
               conn = pool.getConnection();
               Statement stmt = conn.createStatement(ResultSet.
                                                     TYPE_SCROLL_SENSITIVE,
                                                     ResultSet.CONCUR_READ_ONLY);
               sql =
                       "SELECT testID FROM testInConceptForStudent WHERE IDConceptInCourseForStudent='" +
                       idConceptInCourseForStudent + "'";
               rsUn = stmt.executeQuery(sql);
               while (rsUn.next()) {
                   String tId = rsUn.getString("testID");
                    tests.add(tId);
               }
                        rsUn.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           } finally {
               if (pool != null) {
                   pool.release(conn);
               }
           }

    return tests;
}
public String getQuestionTruth(int idTestInConceptForStudent,String questionId){
   String truth="";
   try {
       pool = ConnectionPool.getConnectionPool();
       conn = pool.getConnection();
       Statement stmt = conn.createStatement(ResultSet.
                                             TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
       sql = "SELECT truth FROM questionInTestForStudent WHERE (IDTestInConceptForStudent='" +
               idTestInConceptForStudent + "' AND unitID='"+questionId+"')";
       rsUn = stmt.executeQuery(sql);
       if (rsUn.next()) {
           truth = rsUn.getString("truth");
       }
       rsUn.close();
   } catch (Exception ex) {
       ex.printStackTrace();
   } finally {
       if (pool != null) {
           pool.release(conn);
       }
   }
  return truth;
}
public Vector getQuestionsInTest(int idConceptInCourseForStudent,String testId){

    Vector questions=new Vector();
    try {
               pool = ConnectionPool.getConnectionPool();
               conn = pool.getConnection();
               Statement stmt = conn.createStatement(ResultSet.
                                                     TYPE_SCROLL_SENSITIVE,
                                                     ResultSet.CONCUR_READ_ONLY);
               sql =
                       "SELECT questionID FROM questionInTestForStudent WHERE IdTestInConceptForStudent='" +
                       idConceptInCourseForStudent + "'";
               rsUn = stmt.executeQuery(sql);
               while (rsUn.next()) {
                   String qId = rsUn.getString("questionID");
                    questions.add(qId);
               }
                        rsUn.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           } finally {
               if (pool != null) {
                   pool.release(conn);
               }
           }

    return questions;
}
public int getIdConceptInCourseForStudent(int idStudentInCourse,String conceptId){
    int idConceptInCourseForStudent=0;
    try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql = "SELECT IDConceptInCourseForStudent FROM conceptsInCourseForStudent WHERE (IDStudentInCourse='" +
                 idStudentInCourse + "' AND conceptID='"+conceptId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             idConceptInCourseForStudent = rsUn.getInt("IDConceptInCourseForStudent");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }
    return idConceptInCourseForStudent;
}
public int getIdTestInConceptForStudent(int idConceptInCourseForStudent,String testId){
    int idTestInConceptForStudent=0;
    try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql = "SELECT IDTestInConceptForStudent FROM testInConceptForStudent WHERE (IDConceptInCourseForStudent='" +
                 idConceptInCourseForStudent + "' AND testID='"+testId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             idTestInConceptForStudent = rsUn.getInt("IDTestInConceptForStudent");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }

    return idTestInConceptForStudent;
}
public int getConceptDuration(int idStudentInCourse,String concId){
    int dur=0;
    try {
         pool = ConnectionPool.getConnectionPool();
         conn = pool.getConnection();
         Statement stmt = conn.createStatement(ResultSet.
                                               TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
         sql = "SELECT duration FROM conceptsInCourseForStudent WHERE (IDStudentInCourse='" +
                 idStudentInCourse + "' AND conceptID='"+concId+"')";
         rsUn = stmt.executeQuery(sql);
         if (rsUn.next()) {
             dur = rsUn.getInt("duration");
         }
         rsUn.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         if (pool != null) {
             pool.release(conn);
         }
     }

    return dur;
}
public String getQuestionContent(String courseId,String qid){
    String content="";
    try {
       pool = ConnectionPool.getConnectionPool();
       conn = pool.getConnection();
       Statement stmt = conn.createStatement(ResultSet.
                                             TYPE_SCROLL_SENSITIVE,
                                             ResultSet.CONCUR_READ_ONLY);
       sql = "SELECT content FROM question WHERE (questionID='" +
               qid + "')";
       rsUn = stmt.executeQuery(sql);
       if (rsUn.next()) {
           content = rsUn.getString("content");
       }
       rsUn.close();
   } catch (Exception ex) {
       ex.printStackTrace();
   } finally {
       if (pool != null) {
           pool.release(conn);
       }
   }

    return content;
}

}

