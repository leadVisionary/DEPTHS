
package depths.presentationModule.teacher.charts;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import depths.presentationModule.teacher.StudentsStatisticBean;

public class GroupsConceptsDegreeChartDataSet {
        protected ArrayList data = new ArrayList();
        protected ArrayList compData = new ArrayList();
        public java.util.List l=new ArrayList();
        public java.util.List compL=new ArrayList();
        private StudentsStatisticBean studStatisticBean;
         //public StudentModelAssessment sma;
  //public void setRefToStudModelAssessment(StudentModelAssessment ref){
          //  sma=ref;
  //}
  public void setStudStatBeanRef(StudentsStatisticBean studentStatisticBeanId ){
    studStatisticBean=studentStatisticBeanId;
  }
  public GroupsConceptsDegreeChartDataSet(StudentsStatisticBean studStatBean,String courseId,int groupId,String conceptName) throws ParseException {

      studStatisticBean = studStatBean;
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
      int[] students = studStatisticBean.getStudentIdInCourse(groupId);
      int x = students.length;
      double sDegrees[] = new double[x];
      double gKnLev[] = new double[x];

      //kraj testa
      String concId = studStatisticBean.getConceptIdByName(courseId, conceptName);

     /* if (groupId == 0) {
          for (int i = 0; i < x; i++) {

              double value=studStatisticBean.getConceptsDegreesForStudent(courseId, concId,students[i]);
              sDegrees[i] = value;

          }
      } else {*/
          for (int i = 0; i < x; i++) {


              sDegrees[i] = studStatisticBean.getConceptsDegreesForStudent(
                                       courseId, concId, students[i]);


          }
      //}
          for (int i = 0; i < x; i++) {
              data.add(new GroupsConceptsDegreeHit(this.studStatisticBean,students[i],conceptName, "Concepts", i, sDegrees[i]));
              String s = students[i] + "=" + gKnLev[i];
              l.add(s);
          }



  }
    public java.util.List getConceptNames(){
        return l;
    }
    public String getMainConceptNames(int i){
        String val=l.get(i).toString();

        return val;
    }

    public String getCompConceptNames(int i){
String val= compL.get(i).toString();

       return val ;
   }

        public ArrayList getDataByHitConcept(String filterSection,String filterConcept) {

                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        GroupsConceptsDegreeHit sHit = (GroupsConceptsDegreeHit)iter.next();
                        if (filterSection == "Concepts" && filterConcept.equals(sHit.getHitConcept())) {

                                Integer position = (Integer)conceptMap.get(sHit.getHitStudentName());
                                if (position == null) {

                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitStudentName(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {

                                        GroupsConceptsDegreeHit previousStudentsHit = (GroupsConceptsDegreeHit)results.get(position.intValue());
                                        previousStudentsHit.setHitDegree(previousStudentsHit.getHitDegree() + sHit.getHitDegree());
                                }
                        }
                }

                return results;
        }
        public ArrayList getCompDataByHitConcept(String filterSection) {
                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.compData.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        GroupsConceptsDegreeHit sHit = (GroupsConceptsDegreeHit)iter.next();
                        if (filterSection == null ? true : filterSection.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        GroupsConceptsDegreeHit previousStudentsHit = (GroupsConceptsDegreeHit)results.get(position.intValue());
                                        previousStudentsHit.setHitDegree(previousStudentsHit.getHitDegree() + sHit.getHitDegree());
                                }
                        }
                }
                return results;
        }

        public ArrayList getDataBySection(String filterHitSection,String filterHitConcept) {

                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {

                        GroupsConceptsDegreeHit sHit = (GroupsConceptsDegreeHit)iter.next();

                        if (filterHitConcept.equals("Concepts") ? true : filterHitConcept.equals(sHit.getSection())) {

                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {

                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {

                                        GroupsConceptsDegreeHit previousStudentsHit = (GroupsConceptsDegreeHit)results.get(position.intValue());
                                        previousStudentsHit.setHitDegree(previousStudentsHit.getHitDegree() + sHit.getHitDegree());
                                }
                        }
                }

                return results;
        }
    public ArrayList getSections() {
        ArrayList list = new ArrayList();
        list.add("Catalog");
        list.add("Checkout");
        list.add("Tracking");
        list.add("Service");
        return list;
    }
        public static void main(java.lang.String[] args) {
        }
        public static ArrayList getDateList() {
                ArrayList dateList = new ArrayList();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.UK);
                        dateList.add("Abstract Factory");
                        dateList.add("Factory");
                        dateList.add("Bridge");
                        dateList.add("Proxy");
                return dateList;
        }
        public  ArrayList getSectionList() {
                ArrayList sectionList = new ArrayList();
                sectionList.add("Concepts");
                sectionList.add("Progress");
                sectionList.add("Service");
                sectionList.add("Tracking");
                return sectionList;
        }

}
