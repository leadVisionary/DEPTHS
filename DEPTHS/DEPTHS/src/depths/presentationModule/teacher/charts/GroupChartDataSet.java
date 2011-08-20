
package depths.presentationModule.teacher.charts;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import depths.presentationModule.teacher.StudentsStatisticBean;

public class GroupChartDataSet {
        protected ArrayList data = new ArrayList();
        public java.util.List l=new ArrayList();
        private StudentsStatisticBean studStatisticBean;
         //public StudentModelAssessment sma;
  //public void setRefToStudModelAssessment(StudentModelAssessment ref){
          //  sma=ref;
  //}
  public void setStudStatBeanRef(StudentsStatisticBean studentStatisticBeanId ){
    studStatisticBean=studentStatisticBeanId;
  }
  public GroupChartDataSet(StudentsStatisticBean studStatBean,String courseId,int groupId) throws ParseException {
      studStatisticBean = studStatBean;
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
      String[] concepts = studStatisticBean.getConceptsTitles(courseId);
      int x = concepts.length;
      double degrees[] = new double[x];
      double knLev[] = new double[x];
      //kraj testa
      if (groupId == 0) {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              double value=studStatisticBean.getConceptsDegrees(courseId, concId);
              degrees[i] = value;
          }
      } else {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              degrees[i] = studStatisticBean.getConceptsDegrees(
                      courseId, concId, groupId);
          }
      }
      if (groupId == 0) {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              double value=studStatisticBean.getConceptsKnowledgeLevel(courseId, concId);
              knLev[i] = value;
          }
      } else {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              knLev[i] = studStatisticBean.getConceptsKnowledgeLevel(
                      courseId, concId, groupId);

                   }
      }
          for (int i = 0; i < concepts.length; i++) {
              data.add(new GroupHit(concepts[i], "Concepts", i, degrees[i]));
              String s = concepts[i] + "=" + knLev[i];
              l.add(s);
          }
          for (int i = 0; i < concepts.length; i++) {
              data.add(new GroupHit(concepts[i], "Progress", i, knLev[i]));
          }
  }
    public java.util.List getConceptNames(){
        return l;
    }
        public ArrayList getDataByHitConcept(String filterSection) {
                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        GroupHit sHit = (GroupHit)iter.next();
                        if (filterSection == null ? true : filterSection.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        GroupHit previousGroupHit = (GroupHit)results.get(position.intValue());
                                        previousGroupHit.setHitDegree(previousGroupHit.getHitDegree() + sHit.getHitDegree());
                                }
                        }
                }
                return results;
        }
        public ArrayList getDataBySection(String filterHitConcept) {
                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        GroupHit sHit = (GroupHit)iter.next();
                        if (filterHitConcept.equals("Progress") ? true : filterHitConcept.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        GroupHit previousGroupHit = (GroupHit)results.get(position.intValue());
                                        previousGroupHit.setHitDegree(previousGroupHit.getHitDegree() + sHit.getHitDegree());
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
