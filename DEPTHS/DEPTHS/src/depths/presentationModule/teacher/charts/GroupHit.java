package depths.presentationModule.teacher.charts;

import java.util.Date;
public class GroupHit {
        protected String hitConcept = null;
        protected String section = null;
        protected double hitDegree = 0;
        protected int ordNumb=0;

    public GroupHit(String dConceptTitle, String sSection,int ordinalNumber, double lHitDegree) {

                this.hitConcept = dConceptTitle;
                this.section = sSection;
                this.ordNumb=ordinalNumber;
                this.hitDegree = lHitDegree;
    }
        public String getHitConcept() {
                return this.hitConcept;
        }
        public String getSection() {
                return this.section;
        }
        public double getHitDegree() {
                return this.hitDegree;
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
