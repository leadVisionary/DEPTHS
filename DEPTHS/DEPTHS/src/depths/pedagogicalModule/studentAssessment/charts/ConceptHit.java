package depths.pedagogicalModule.studentAssessment.charts;

/*
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * ---------------------------
 * WebHit.java
 * ---------------------------
 * (C) Copyright 2002-2004, by Richard Atkinson.
 *
 * Original Author:  Richard Atkinson;
 */


import java.util.Date;

public class ConceptHit {
        protected String hitConcept = null;
        protected String section = null;
        protected double hitDegree = 0;
        protected int ordNumb=0;

    public ConceptHit(String dConceptTitle, String sSection,int ordinalNumber, double lHitDegree) {

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
