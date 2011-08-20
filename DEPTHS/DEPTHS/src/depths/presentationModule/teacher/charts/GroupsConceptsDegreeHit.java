package depths.presentationModule.teacher.charts;

import java.util.Date;
import depths.presentationModule.teacher.StudentsStatisticBean;
public class GroupsConceptsDegreeHit {
        protected String hitConcept = null;
        protected String section = null;
        protected double hitDegree = 0;
        protected int ordNumb=0;
        protected int hitStudentInCourse=0;
        protected String hitStudentName=null;
        private StudentsStatisticBean studStatBean;

    public GroupsConceptsDegreeHit(StudentsStatisticBean stStatBean,int studentInCourse,String conceptName, String sSection,int ordinalNumber, double lHitDegree) {

    studStatBean=stStatBean;
                this.hitStudentInCourse = studentInCourse;
                this.hitStudentName=studStatBean.getStudentNameByStudentInCourse(studentInCourse);
                this.section = sSection;
                this.ordNumb=ordinalNumber;
                this.hitDegree = lHitDegree;
                this.hitConcept=conceptName;
    }
    public int getHitStudentInCourse() {

                return this.hitStudentInCourse;
        }
        public String getHitStudentName(){

            return this.hitStudentName;
        }


public double getHitDegree(){
    return this.hitDegree;
}
    public String getHitConcept() {

                return this.hitConcept;
        }
        public String getSection() {

                return this.section;
        }

        public void setHitConcept(String dHitConcept) {
                this.hitConcept = dHitConcept;
        }
        public void setSection(String sSection) {
                this.section = sSection;
        }
        public void setHitDegree(double lHitD) {
                this.hitDegree = lHitD;
        }
        public int getOrdNumb() {
                return this.ordNumb;
        }
        public void setOrdNumb(int dOrdNum) {
                this.ordNumb = dOrdNum;
        }
}
