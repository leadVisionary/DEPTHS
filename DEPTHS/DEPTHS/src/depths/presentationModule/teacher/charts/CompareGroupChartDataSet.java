
package depths.presentationModule.teacher.charts;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import depths.presentationModule.teacher.StudentsStatisticBean;

public class CompareGroupChartDataSet {
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
  public CompareGroupChartDataSet(StudentsStatisticBean studStatBean,String courseId,int groupId,int compareGroupId) throws ParseException {
      studStatisticBean = studStatBean;
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
      String[] concepts = studStatisticBean.getConceptsTitles(courseId);
      int x = concepts.length;
      double gDegrees[] = new double[x];
      double gKnLev[] = new double[x];
      double compGrDegrees[]=new double[x];
      double compGrKnLev[]=new double[x];
      //kraj testa
      if (groupId == 0) {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              double value=studStatisticBean.getConceptsDegrees(courseId, concId);
              gDegrees[i] = value;

          }
      } else {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              gDegrees[i] = studStatisticBean.getConceptsDegrees(
                      courseId, concId, groupId);

          }
      }
      for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              compGrDegrees[i] = studStatisticBean.getConceptsDegrees(
                      courseId, concId, compareGroupId);

          }

      if (groupId == 0) {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              double value=studStatisticBean.getConceptsKnowledgeLevel(courseId, concId);
              gKnLev[i] = value;

          }
      } else {
          for (int i = 0; i < x; i++) {
              String concId = studStatisticBean.getConceptIdByName(
                      courseId, concepts[i]);
              gKnLev[i] = studStatisticBean.getConceptsKnowledgeLevel(
                      courseId, concId, groupId);

                   }
      }
      for (int i = 0; i < x; i++) {
             String concId = studStatisticBean.getConceptIdByName(
                     courseId, concepts[i]);
             compGrKnLev[i] = studStatisticBean.getConceptsKnowledgeLevel(
                     courseId, concId, compareGroupId);

                  }

          for (int i = 0; i < concepts.length; i++) {
              data.add(new CompareGroupHit(concepts[i], "Concepts", i, gDegrees[i]));
              String s = concepts[i] + "=" + gKnLev[i];
              l.add(s);
          }
          for (int i = 0; i < concepts.length; i++) {
              data.add(new CompareGroupHit(concepts[i], "Progress", i, gKnLev[i]));
          }
          for (int i = 0; i < concepts.length; i++) {
              compData.add(new CompareGroupHit(concepts[i], "Concepts", i, compGrDegrees[i]));
              String s = concepts[i] + "=" + compGrKnLev[i];
              compL.add(s);
          }
          for (int i = 0; i < concepts.length; i++) {
              compData.add(new CompareGroupHit(concepts[i], "Progress", i, compGrKnLev[i]));
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

        public ArrayList getDataByHitConcept(String filterSection) {
                ArrayList results = new ArrayList();
                HashMap conceptMap = new HashMap();
                Iterator iter = this.data.listIterator();
                int currentPosition = 0;
                while (iter.hasNext()) {
                        CompareGroupHit sHit = (CompareGroupHit)iter.next();
                        if (filterSection == null ? true : filterSection.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        CompareGroupHit previousStudentsHit = (CompareGroupHit)results.get(position.intValue());
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
                        CompareGroupHit sHit = (CompareGroupHit)iter.next();
                        if (filterSection == null ? true : filterSection.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        CompareGroupHit previousStudentsHit = (CompareGroupHit)results.get(position.intValue());
                                        previousStudentsHit.setHitDegree(previousStudentsHit.getHitDegree() + sHit.getHitDegree());
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
                        CompareGroupHit sHit = (CompareGroupHit)iter.next();
                        if (filterHitConcept.equals("Progress") ? true : filterHitConcept.equals(sHit.getSection())) {
                                Integer position = (Integer)conceptMap.get(sHit.getHitConcept());
                                if (position == null) {
                                        results.add(sHit);
                                        conceptMap.put(sHit.getHitConcept(), new Integer(currentPosition));
                                        currentPosition++;
                                } else {
                                        CompareGroupHit previousStudentsHit = (CompareGroupHit)results.get(position.intValue());
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
