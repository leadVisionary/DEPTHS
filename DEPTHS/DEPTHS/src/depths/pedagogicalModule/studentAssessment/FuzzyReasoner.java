package depths.pedagogicalModule.studentAssessment;



import nrc.fuzzy.*;


public class FuzzyReasoner {
    public FuzzyVariable duration = null;
    public FuzzyVariable success = null;
    public FuzzyVariable difficulty = null;
    public FuzzyVariable appraise = null;
    private static FuzzyRuleExecutor fre = new MamdaniMinMaxMinRuleExecutor();
    private static AntecedentCombineOperator aco = new
            MinimumAntecedentCombineOperator();


    //define rules duration-success-difficulty
    FuzzyRule shortBadVeryEasy = new FuzzyRule();
    FuzzyRule shortNotBadVeryEasy = new FuzzyRule();
    FuzzyRule shortGoodVeryEasy = new FuzzyRule();
    FuzzyRule shortVeryGoodVeryEasy = new FuzzyRule();
    FuzzyRule shortExcellentVeryEasy = new FuzzyRule();

    FuzzyRule shortBadEasy = new FuzzyRule();
    FuzzyRule shortNotBadEasy = new FuzzyRule();
    FuzzyRule shortGoodEasy = new FuzzyRule();
    FuzzyRule shortVeryGoodEasy = new FuzzyRule();
    FuzzyRule shortExcellentEasy = new FuzzyRule();

    FuzzyRule shortBadMedium = new FuzzyRule();
    FuzzyRule shortNotBadMedium = new FuzzyRule();
    FuzzyRule shortGoodMedium = new FuzzyRule();
    FuzzyRule shortVeryGoodMedium = new FuzzyRule();
    FuzzyRule shortExcellentMedium = new FuzzyRule();

    FuzzyRule shortBadDifficult = new FuzzyRule();
    FuzzyRule shortNotBadDifficult = new FuzzyRule();
    FuzzyRule shortGoodDifficult = new FuzzyRule();
    FuzzyRule shortVeryGoodDifficult = new FuzzyRule();
    FuzzyRule shortExcellentDifficult = new FuzzyRule();

    FuzzyRule shortBadVeryDifficult = new FuzzyRule();
    FuzzyRule shortNotBadVeryDifficult = new FuzzyRule();
    FuzzyRule shortGoodVeryDifficult = new FuzzyRule();
    FuzzyRule shortVeryGoodVeryDifficult = new FuzzyRule();
    FuzzyRule shortExcellentVeryDifficult = new FuzzyRule();


    FuzzyRule mediumBadVeryEasy = new FuzzyRule();
    FuzzyRule mediumNotBadVeryEasy = new FuzzyRule();
    FuzzyRule mediumGoodVeryEasy = new FuzzyRule();
    FuzzyRule mediumVeryGoodVeryEasy = new FuzzyRule();
    FuzzyRule mediumExcellentVeryEasy = new FuzzyRule();

    FuzzyRule mediumBadEasy = new FuzzyRule();
    FuzzyRule mediumNotBadEasy = new FuzzyRule();
    FuzzyRule mediumGoodEasy = new FuzzyRule();
    FuzzyRule mediumVeryGoodEasy = new FuzzyRule();
    FuzzyRule mediumExcellentEasy = new FuzzyRule();

    FuzzyRule mediumBadMedium = new FuzzyRule();
    FuzzyRule mediumNotBadMedium = new FuzzyRule();
    FuzzyRule mediumGoodMedium = new FuzzyRule();
    FuzzyRule mediumVeryGoodMedium = new FuzzyRule();
    FuzzyRule mediumExcellentMedium = new FuzzyRule();

    FuzzyRule mediumBadDifficult = new FuzzyRule();
    FuzzyRule mediumNotBadDifficult = new FuzzyRule();
    FuzzyRule mediumGoodDifficult = new FuzzyRule();
    FuzzyRule mediumVeryGoodDifficult = new FuzzyRule();
    FuzzyRule mediumExcellentDifficult = new FuzzyRule();

    FuzzyRule mediumBadVeryDifficult = new FuzzyRule();
    FuzzyRule mediumNotBadVeryDifficult = new FuzzyRule();
    FuzzyRule mediumGoodVeryDifficult = new FuzzyRule();
    FuzzyRule mediumVeryGoodVeryDifficult = new FuzzyRule();
    FuzzyRule mediumExcellentVeryDifficult = new FuzzyRule();




    FuzzyRule longBadVeryEasy = new FuzzyRule();
   FuzzyRule longNotBadVeryEasy = new FuzzyRule();
   FuzzyRule longGoodVeryEasy = new FuzzyRule();
   FuzzyRule longVeryGoodVeryEasy = new FuzzyRule();
   FuzzyRule longExcellentVeryEasy = new FuzzyRule();

   FuzzyRule longBadEasy = new FuzzyRule();
   FuzzyRule longNotBadEasy = new FuzzyRule();
   FuzzyRule longGoodEasy = new FuzzyRule();
   FuzzyRule longVeryGoodEasy = new FuzzyRule();
   FuzzyRule longExcellentEasy = new FuzzyRule();

   FuzzyRule longBadMedium = new FuzzyRule();
   FuzzyRule longNotBadMedium = new FuzzyRule();
   FuzzyRule longGoodMedium = new FuzzyRule();
   FuzzyRule longVeryGoodMedium = new FuzzyRule();
   FuzzyRule longExcellentMedium = new FuzzyRule();

   FuzzyRule longBadDifficult = new FuzzyRule();
   FuzzyRule longNotBadDifficult = new FuzzyRule();
   FuzzyRule longGoodDifficult = new FuzzyRule();
   FuzzyRule longVeryGoodDifficult = new FuzzyRule();
   FuzzyRule longExcellentDifficult = new FuzzyRule();

   FuzzyRule longBadVeryDifficult = new FuzzyRule();
  FuzzyRule longNotBadVeryDifficult = new FuzzyRule();
  FuzzyRule longGoodVeryDifficult = new FuzzyRule();
  FuzzyRule longVeryGoodVeryDifficult = new FuzzyRule();
  FuzzyRule longExcellentVeryDifficult = new FuzzyRule();






    FuzzyRule[] fuzzyRules = {shortBadVeryEasy,shortNotBadVeryEasy,shortGoodVeryEasy,shortVeryGoodVeryEasy,shortExcellentVeryEasy,
                             shortBadEasy,shortNotBadEasy,shortGoodEasy,shortVeryGoodEasy,shortExcellentEasy,
                             shortBadMedium,shortNotBadMedium,shortGoodMedium,shortVeryGoodMedium,shortExcellentMedium,
                             shortBadDifficult,shortNotBadDifficult,shortGoodDifficult,shortVeryGoodDifficult,shortExcellentDifficult,
                             shortBadVeryDifficult,shortNotBadVeryDifficult,shortGoodVeryDifficult,shortVeryGoodVeryDifficult,shortExcellentVeryDifficult,
                             mediumBadVeryEasy,mediumNotBadVeryEasy,mediumGoodVeryEasy,mediumVeryGoodVeryEasy,mediumExcellentVeryEasy,
                             mediumBadEasy,mediumNotBadEasy,mediumGoodEasy,mediumVeryGoodEasy,mediumExcellentEasy,
                             mediumBadMedium,mediumNotBadMedium,mediumGoodMedium,mediumVeryGoodMedium,mediumExcellentMedium,
                             mediumBadDifficult,mediumNotBadDifficult,mediumGoodDifficult,mediumVeryGoodDifficult,mediumExcellentDifficult,
                             mediumBadVeryDifficult,mediumNotBadVeryDifficult,mediumGoodVeryDifficult,mediumVeryGoodVeryDifficult,mediumExcellentVeryDifficult,
                             longBadVeryEasy,longNotBadVeryEasy,longGoodVeryEasy,longVeryGoodVeryEasy,longExcellentVeryEasy,
                             longBadEasy,longNotBadEasy,longGoodEasy,longVeryGoodEasy,longExcellentEasy,
                             longBadMedium,longNotBadMedium,longGoodMedium,longVeryGoodMedium,longExcellentMedium,
                             longBadDifficult,longNotBadDifficult,longGoodDifficult,longVeryGoodDifficult,longExcellentDifficult,
                             longBadVeryDifficult,longNotBadVeryDifficult,longGoodVeryDifficult,longVeryGoodVeryDifficult,longExcellentVeryDifficult,
    };
    private double optTime;
    private double minTime;
    private double maxTime;
    private double shortMax;
    private double shortMin;
    private double mediumMax;
    private double mediumMin;
    private double longMax;
    private double longMin;

    public FuzzyReasoner() {
    }
    public void setTimeLines(int optTime){
      this.setOptTime(optTime);
      this.setMaxTime(optTime*5);
      this.setMinTime(0.0);
      this.setShortMin(optTime/2);
      this.setShortMax(optTime-optTime/5);
      this.setMediumMin(optTime-optTime/3);
      this.setMediumMax(optTime+optTime/3);
      this.setLongMin(optTime+optTime/5);
      this.setLongMax(optTime*2);


    }

    public void init(int optTime) {

      this.setTimeLines(optTime);

        try {


            //define duration, success and appraise  variables

            duration = new FuzzyVariable("duration", this.getMinTime(), this.getMaxTime(), "seconds");
            success = new FuzzyVariable("success", 0.0, 101.0, "per_cent %");
            difficulty = new FuzzyVariable("difficulty", 0.0, 100.0, "%");
            appraise = new FuzzyVariable("appraise", 0.0, 6.0, "number");


        } catch (InvalidFuzzyVariableNameException nameEx) {

        } catch (InvalidUODRangeException rangeEx) {

        }
        try {


            //adding terms to the duration, success and appraise variables


            duration.addTerm("shortD", new ZFuzzySet(this.getShortMin(), this.getShortMax()));

            duration.addTerm("mediumD", new TriangleFuzzySet(this.getMediumMin(), this.getOptTime(), this.getMediumMax()));

            duration.addTerm("longD", new SFuzzySet(this.getLongMin(), this.getLongMax()));


            success.addTerm("badS", new ZFuzzySet(45.0, 50.0));
            success.addTerm("notbadS",
                            new TrapezoidFuzzySet(45.0, 50.0, 60.0, 65.0));
            success.addTerm("goodS",
                            new TrapezoidFuzzySet(60.0, 65.0, 75.0, 80.0));
            success.addTerm("verygoodS",
                            new TrapezoidFuzzySet(75.0, 80.0, 90.0, 95.0));
            success.addTerm("excellentS", new SFuzzySet(90.0, 95.0));


            difficulty.addTerm("veryEasy", new ZFuzzySet(10.0, 25.0));
            difficulty.addTerm("easy",  new TrapezoidFuzzySet(15.0, 25.0, 40.0, 45.0));
            difficulty.addTerm("medium",
                               new TrapezoidFuzzySet(35.0, 45.0, 60.0, 65.0));
            difficulty.addTerm("difficult",
                               new TrapezoidFuzzySet(55.0, 65.0, 80.0, 85.0));
            difficulty.addTerm("veryDifficult", new SFuzzySet(75.0, 90.0));


            appraise.addTerm("badA", new ZFuzzySet(0.0, 1.5));
            appraise.addTerm("enoughA",
                             new TrapezoidFuzzySet(1.0, 1.5, 2.0, 2.5));
            appraise.addTerm("goodA", new TrapezoidFuzzySet(2.0, 2.5, 3.0, 3.5));
            appraise.addTerm("verygoodA",
                             new TrapezoidFuzzySet(3.0, 3.5, 4.0, 4.5));
            appraise.addTerm("excellentA",
                             new TrapezoidFuzzySet(4.0, 4.5, 5.0, 5.5));
            appraise.addTerm("extraexcellentA", new SFuzzySet(5.0, 5.5));


        } catch (XValuesOutOfOrderException outOfOrderEx) {
          System.out.println("ERROR: XValuesOutOfOrderException");
        } catch (XValueOutsideUODException outsideOUD) {
           System.out.println("ERROR: XValuesOutSideUODException");

        }
        try {
            //defines 15 rules


            shortBadVeryEasy.addAntecedent(new FuzzyValue(duration, "shortD"));
            shortBadVeryEasy.addAntecedent(new FuzzyValue(success, "badS"));
            shortBadVeryEasy.addAntecedent(new FuzzyValue(difficulty, "veryEasy"));
            shortBadVeryEasy.addConclusion(new FuzzyValue(appraise, "badA"));

            shortBadEasy.addAntecedent(new FuzzyValue(duration, "shortD"));
            shortBadEasy.addAntecedent(new FuzzyValue(success, "badS"));
            shortBadEasy.addAntecedent(new FuzzyValue(difficulty, "easy"));
            shortBadEasy.addConclusion(new FuzzyValue(appraise, "badA"));

            shortBadMedium.addAntecedent(new FuzzyValue(duration, "shortD"));
            shortBadMedium.addAntecedent(new FuzzyValue(success, "badS"));
            shortBadMedium.addAntecedent(new FuzzyValue(difficulty, "medium"));
            shortBadMedium.addConclusion(new FuzzyValue(appraise, "badA"));

            shortBadDifficult.addAntecedent(new FuzzyValue(duration, "shortD"));
            shortBadDifficult.addAntecedent(new FuzzyValue(success, "badS"));
            shortBadDifficult.addAntecedent(new FuzzyValue(difficulty, "difficult"));
            shortBadDifficult.addConclusion(new FuzzyValue(appraise, "badA"));

            shortBadVeryDifficult.addAntecedent(new FuzzyValue(duration, "shortD"));
            shortBadVeryDifficult.addAntecedent(new FuzzyValue(success, "badS"));
            shortBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty, "veryDifficult"));
            shortBadVeryDifficult.addConclusion(new FuzzyValue(appraise, "badA"));


            shortNotBadVeryEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortNotBadVeryEasy.addAntecedent(new FuzzyValue(success,"notbadS"));
             shortNotBadVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            shortNotBadVeryEasy.addConclusion(new FuzzyValue(appraise,"enoughA"));

            shortNotBadEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortNotBadEasy.addAntecedent(new FuzzyValue(success,"notbadS"));
             shortNotBadEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            shortNotBadEasy.addConclusion(new FuzzyValue(appraise,"enoughA"));

            shortNotBadMedium.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortNotBadMedium.addAntecedent(new FuzzyValue(success,"notbadS"));
            shortNotBadMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            shortNotBadMedium.addConclusion(new FuzzyValue(appraise,"enoughA"));

            shortNotBadDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortNotBadDifficult.addAntecedent(new FuzzyValue(success,"notbadS"));
            shortNotBadDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            shortNotBadDifficult.addConclusion(new FuzzyValue(appraise,"goodA"));

            shortNotBadVeryDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortNotBadVeryDifficult.addAntecedent(new FuzzyValue(success,"notbadS"));
            shortNotBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            shortNotBadVeryDifficult.addConclusion(new FuzzyValue(appraise,"goodA"));



            shortGoodVeryEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortGoodVeryEasy.addAntecedent(new FuzzyValue(success,"goodS"));
            shortGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            shortGoodVeryEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            shortGoodEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortGoodEasy.addAntecedent(new FuzzyValue(success,"goodS"));
            shortGoodEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            shortGoodEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            shortGoodMedium.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortGoodMedium.addAntecedent(new FuzzyValue(success,"goodS"));
            shortGoodMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            shortGoodMedium.addConclusion(new FuzzyValue(appraise,"goodA"));

            shortGoodDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortGoodDifficult.addAntecedent(new FuzzyValue(success,"goodS"));
            shortGoodDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            shortGoodDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            shortGoodVeryDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortGoodVeryDifficult.addAntecedent(new FuzzyValue(success,"goodS"));
             shortGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            shortGoodVeryDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));



            shortVeryGoodVeryEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortVeryGoodVeryEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
            shortVeryGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            shortVeryGoodVeryEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            shortVeryGoodEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortVeryGoodEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
            shortVeryGoodEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            shortVeryGoodEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            shortVeryGoodMedium.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortVeryGoodMedium.addAntecedent(new FuzzyValue(success,"verygoodS"));
            shortVeryGoodMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            shortVeryGoodMedium.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            shortVeryGoodDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortVeryGoodDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
            shortVeryGoodDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            shortVeryGoodDifficult.addConclusion(new FuzzyValue(appraise,"excellentA"));

            shortVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
            shortVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            shortVeryGoodVeryDifficult.addConclusion(new FuzzyValue(appraise,"excellentA"));




            shortExcellentVeryEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
            shortExcellentVeryEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
            shortExcellentVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            shortExcellentVeryEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            shortExcellentEasy.addAntecedent(new FuzzyValue(duration,"shortD"));
          shortExcellentEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
           shortExcellentEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
          shortExcellentEasy.addConclusion(new FuzzyValue(appraise,"excellentA"));

          shortExcellentMedium.addAntecedent(new FuzzyValue(duration,"shortD"));
          shortExcellentMedium.addAntecedent(new FuzzyValue(success,"excellentS"));
          shortExcellentMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
          shortExcellentMedium.addConclusion(new FuzzyValue(appraise,"excellentA"));

          shortExcellentDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
          shortExcellentDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
           shortExcellentDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
          shortExcellentDifficult.addConclusion(new FuzzyValue(appraise,"extraexcellentA"));

          shortExcellentVeryDifficult.addAntecedent(new FuzzyValue(duration,"shortD"));
          shortExcellentVeryDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
          shortExcellentVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
          shortExcellentVeryDifficult.addConclusion(new FuzzyValue(appraise,"extraexcellentA"));




            mediumBadVeryEasy.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumBadVeryEasy.addAntecedent(new FuzzyValue(success,"badS"));
             mediumBadVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            mediumBadVeryEasy.addConclusion(new FuzzyValue(appraise,"badA"));

            mediumBadEasy.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumBadEasy.addAntecedent(new FuzzyValue(success,"badS"));
             mediumBadEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            mediumBadEasy.addConclusion(new FuzzyValue(appraise,"badA"));

            mediumBadMedium.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumBadMedium.addAntecedent(new FuzzyValue(success,"badS"));
            mediumBadMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            mediumBadMedium.addConclusion(new FuzzyValue(appraise,"badA"));

            mediumBadDifficult.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumBadDifficult.addAntecedent(new FuzzyValue(success,"badS"));
            mediumBadDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            mediumBadDifficult.addConclusion(new FuzzyValue(appraise,"badA"));

            mediumBadVeryDifficult.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumBadVeryDifficult.addAntecedent(new FuzzyValue(success,"badS"));
            mediumBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            mediumBadVeryDifficult.addConclusion(new FuzzyValue(appraise,"badA"));



            mediumNotBadVeryEasy.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumNotBadVeryEasy.addAntecedent(new FuzzyValue(success,"notbadS"));
            mediumNotBadVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            mediumNotBadVeryEasy.addConclusion(new FuzzyValue(appraise,"badA"));

            mediumNotBadEasy.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumNotBadEasy.addAntecedent(new FuzzyValue(success,"notbadS"));
             mediumNotBadEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            mediumNotBadEasy.addConclusion(new FuzzyValue(appraise,"enoughA"));

            mediumNotBadMedium.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumNotBadMedium.addAntecedent(new FuzzyValue(success,"notbadS"));
            mediumNotBadMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            mediumNotBadMedium.addConclusion(new FuzzyValue(appraise,"enoughA"));

            mediumNotBadDifficult.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumNotBadDifficult.addAntecedent(new FuzzyValue(success,"notbadS"));
            mediumNotBadDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            mediumNotBadDifficult.addConclusion(new FuzzyValue(appraise,"enoughA"));

            mediumNotBadVeryDifficult.addAntecedent(new FuzzyValue(duration,"mediumD"));
            mediumNotBadVeryDifficult.addAntecedent(new FuzzyValue(success,"notbadS"));
            mediumNotBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            mediumNotBadVeryDifficult.addConclusion(new FuzzyValue(appraise,"goodA"));



            mediumGoodVeryEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumGoodVeryEasy.addAntecedent(new FuzzyValue(success,"goodS"));
            mediumGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            mediumGoodVeryEasy.addConclusion(new FuzzyValue(appraise,"enoughA"));

            mediumGoodEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumGoodEasy.addAntecedent(new FuzzyValue(success,"goodS"));
            mediumGoodEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            mediumGoodEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            mediumGoodMedium.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumGoodMedium.addAntecedent(new FuzzyValue(success,"goodS"));
            mediumGoodMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            mediumGoodMedium.addConclusion(new FuzzyValue(appraise,"goodA"));

            mediumGoodDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumGoodDifficult.addAntecedent(new FuzzyValue(success,"goodS"));
            mediumGoodDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            mediumGoodDifficult.addConclusion(new FuzzyValue(appraise,"goodA"));

            mediumGoodVeryDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumGoodVeryDifficult.addAntecedent(new FuzzyValue(success,"goodS"));
            mediumGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            mediumGoodVeryDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));



            mediumVeryGoodVeryEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumVeryGoodVeryEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
             mediumVeryGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            mediumVeryGoodVeryEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            mediumVeryGoodEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumVeryGoodEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
            mediumVeryGoodEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            mediumVeryGoodEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            mediumVeryGoodMedium.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumVeryGoodMedium.addAntecedent(new FuzzyValue(success,"verygoodS"));
            mediumVeryGoodMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            mediumVeryGoodMedium.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            mediumVeryGoodDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumVeryGoodDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
            mediumVeryGoodDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            mediumVeryGoodDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            mediumVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
            mediumVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            mediumVeryGoodVeryDifficult.addConclusion(new FuzzyValue(appraise,"excellentA"));



            mediumExcellentVeryEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
            mediumExcellentVeryEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
            mediumExcellentVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            mediumExcellentVeryEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            mediumExcellentEasy.addAntecedent(new FuzzyValue(duration, "mediumD"));
           mediumExcellentEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
           mediumExcellentEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
           mediumExcellentEasy.addConclusion(new FuzzyValue(appraise,"verygoodA"));

           mediumExcellentMedium.addAntecedent(new FuzzyValue(duration, "mediumD"));
           mediumExcellentMedium.addAntecedent(new FuzzyValue(success,"excellentS"));
           mediumExcellentMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
           mediumExcellentMedium.addConclusion(new FuzzyValue(appraise,"excellentA"));

           mediumExcellentDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
           mediumExcellentDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
           mediumExcellentDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
           mediumExcellentDifficult.addConclusion(new FuzzyValue(appraise,"excellentA"));

           mediumExcellentVeryDifficult.addAntecedent(new FuzzyValue(duration, "mediumD"));
           mediumExcellentVeryDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
           mediumExcellentVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
           mediumExcellentVeryDifficult.addConclusion(new FuzzyValue(appraise,"extraexcellentA"));





            longBadVeryEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longBadVeryEasy.addAntecedent(new FuzzyValue(success, "badS"));
            longBadVeryEasy.addAntecedent(new FuzzyValue(difficulty, "veryEasy"));
            longBadVeryEasy.addConclusion(new FuzzyValue(appraise,"badA"));

            longBadEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longBadEasy.addAntecedent(new FuzzyValue(success, "badS"));
            longBadEasy.addAntecedent(new FuzzyValue(difficulty, "easy"));
            longBadEasy.addConclusion(new FuzzyValue(appraise,"badA"));

            longBadMedium.addAntecedent(new FuzzyValue(duration,"longD"));
            longBadMedium.addAntecedent(new FuzzyValue(success, "badS"));
            longBadMedium.addAntecedent(new FuzzyValue(difficulty, "medium"));
            longBadMedium.addConclusion(new FuzzyValue(appraise,"badA"));

            longBadDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longBadDifficult.addAntecedent(new FuzzyValue(success, "badS"));
            longBadDifficult.addAntecedent(new FuzzyValue(difficulty, "difficult"));
            longBadDifficult.addConclusion(new FuzzyValue(appraise,"badA"));

            longBadVeryDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longBadVeryDifficult.addAntecedent(new FuzzyValue(success, "badS"));
            longBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty, "veryDifficult"));
            longBadVeryDifficult.addConclusion(new FuzzyValue(appraise,"badA"));




            longNotBadVeryEasy.addAntecedent(new FuzzyValue(duration, "longD"));
            longNotBadVeryEasy.addAntecedent(new FuzzyValue(success, "notbadS"));
            longNotBadVeryEasy.addAntecedent(new FuzzyValue(difficulty, "veryEasy"));
            longNotBadVeryEasy.addConclusion(new FuzzyValue(appraise, "badA"));

            longNotBadEasy.addAntecedent(new FuzzyValue(duration, "longD"));
            longNotBadEasy.addAntecedent(new FuzzyValue(success, "notbadS"));
            longNotBadEasy.addAntecedent(new FuzzyValue(difficulty, "easy"));
            longNotBadEasy.addConclusion(new FuzzyValue(appraise, "badA"));

            longNotBadMedium.addAntecedent(new FuzzyValue(duration, "longD"));
            longNotBadMedium.addAntecedent(new FuzzyValue(success, "notbadS"));
            longNotBadMedium.addAntecedent(new FuzzyValue(difficulty, "medium"));
            longNotBadMedium.addConclusion(new FuzzyValue(appraise, "badA"));

            longNotBadDifficult.addAntecedent(new FuzzyValue(duration, "longD"));
            longNotBadDifficult.addAntecedent(new FuzzyValue(success, "notbadS"));
            longNotBadDifficult.addAntecedent(new FuzzyValue(difficulty, "difficult"));
            longNotBadDifficult.addConclusion(new FuzzyValue(appraise, "enoughA"));

            longNotBadVeryDifficult.addAntecedent(new FuzzyValue(duration, "longD"));
            longNotBadVeryDifficult.addAntecedent(new FuzzyValue(success, "notbadS"));
            longNotBadVeryDifficult.addAntecedent(new FuzzyValue(difficulty, "veryDifficult"));
            longNotBadVeryDifficult.addConclusion(new FuzzyValue(appraise, "enoughA"));





            longGoodVeryEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longGoodVeryEasy.addAntecedent(new FuzzyValue(success, "goodS"));
            longGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty, "veryEasy"));
            longGoodVeryEasy.addConclusion(new FuzzyValue(appraise, "enoughA"));

            longGoodEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longGoodEasy.addAntecedent(new FuzzyValue(success, "goodS"));
            longGoodEasy.addAntecedent(new FuzzyValue(difficulty, "easy"));
            longGoodEasy.addConclusion(new FuzzyValue(appraise, "enoughA"));

            longGoodMedium.addAntecedent(new FuzzyValue(duration,"longD"));
            longGoodMedium.addAntecedent(new FuzzyValue(success, "goodS"));
            longGoodMedium.addAntecedent(new FuzzyValue(difficulty, "medium"));
            longGoodMedium.addConclusion(new FuzzyValue(appraise, "enoughA"));

            longGoodDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longGoodDifficult.addAntecedent(new FuzzyValue(success, "goodS"));
            longGoodDifficult.addAntecedent(new FuzzyValue(difficulty, "difficult"));
            longGoodDifficult.addConclusion(new FuzzyValue(appraise, "enoughA"));

            longGoodVeryDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longGoodVeryDifficult.addAntecedent(new FuzzyValue(success, "goodS"));
            longGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty, "veryDifficult"));
            longGoodVeryDifficult.addConclusion(new FuzzyValue(appraise, "enoughA"));





            longVeryGoodVeryEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longVeryGoodVeryEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
            longVeryGoodVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            longVeryGoodVeryEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            longVeryGoodEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longVeryGoodEasy.addAntecedent(new FuzzyValue(success,"verygoodS"));
            longVeryGoodEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            longVeryGoodEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            longVeryGoodMedium.addAntecedent(new FuzzyValue(duration,"longD"));
            longVeryGoodMedium.addAntecedent(new FuzzyValue(success,"verygoodS"));
            longVeryGoodMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            longVeryGoodMedium.addConclusion(new FuzzyValue(appraise,"goodA"));

            longVeryGoodDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longVeryGoodDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
            longVeryGoodDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            longVeryGoodDifficult.addConclusion(new FuzzyValue(appraise,"goodA"));

            longVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(success,"verygoodS"));
             longVeryGoodVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            longVeryGoodVeryDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));





            longExcellentVeryEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longExcellentVeryEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
            longExcellentVeryEasy.addAntecedent(new FuzzyValue(difficulty,"veryEasy"));
            longExcellentVeryEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            longExcellentEasy.addAntecedent(new FuzzyValue(duration,"longD"));
            longExcellentEasy.addAntecedent(new FuzzyValue(success,"excellentS"));
             longExcellentEasy.addAntecedent(new FuzzyValue(difficulty,"easy"));
            longExcellentEasy.addConclusion(new FuzzyValue(appraise,"goodA"));

            longExcellentMedium.addAntecedent(new FuzzyValue(duration,"longD"));
            longExcellentMedium.addAntecedent(new FuzzyValue(success,"excellentS"));
            longExcellentMedium.addAntecedent(new FuzzyValue(difficulty,"medium"));
            longExcellentMedium.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            longExcellentDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longExcellentDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
            longExcellentDifficult.addAntecedent(new FuzzyValue(difficulty,"difficult"));
            longExcellentDifficult.addConclusion(new FuzzyValue(appraise,"verygoodA"));

            longExcellentVeryDifficult.addAntecedent(new FuzzyValue(duration,"longD"));
            longExcellentVeryDifficult.addAntecedent(new FuzzyValue(success,"excellentS"));
            longExcellentVeryDifficult.addAntecedent(new FuzzyValue(difficulty,"veryDifficult"));
            longExcellentVeryDifficult.addConclusion(new FuzzyValue(appraise,"excellentA"));





        } catch (InvalidLinguisticExpressionException lingEx) {}

    }

    public double run(double dt, double st, double diff) {


        double durationTemp = dt;
        double successTemp = st;
        double difficultyTemp=diff;
        FuzzyValue durTempFV = null, succTempFV = null, diffTempFV=null;
        FuzzyValue fv;
        double results = 0.0;
        FuzzyValue globalOutput = null;
        FuzzyValueVector fvv = null;


        if (durationTemp < 0.0 || durationTemp > 61.0) {
            System.out.println("Uneto vreme trajanja nije dozvoljeno");
          }
        if (successTemp < 0.0 || successTemp > 101.0) {
            System.out.println("uneta vrednost za uspeh nije dozvoljena");
          }
        if (difficultyTemp<0.0 ||difficultyTemp>100.0){
            System.out.println("uneta vrednost za tezinu testa nije dozvoljena");
          }


        for (int i = 0; i < fuzzyRules.length; i++) {
            fuzzyRules[i].setAntecedentCombineOperator(aco);
            fuzzyRules[i].setDefaultRuleExecutor(fre);

        }

        try {

            durTempFV = new FuzzyValue(duration,
                                       new
                                       TriangleFuzzySet(durationTemp -
                    0.05, durationTemp, durationTemp + 0.05));

            succTempFV = new FuzzyValue(success,
                                        new TriangleFuzzySet(successTemp,
                    successTemp, successTemp + 0.05));

            diffTempFV=new FuzzyValue(difficulty, new TriangleFuzzySet(difficultyTemp, difficultyTemp, difficultyTemp+0.05));

            for (int k = 0; k < fuzzyRules.length; k++) {
                fuzzyRules[k].removeAllInputs();
                fuzzyRules[k].addInput(durTempFV);
                fuzzyRules[k].addInput(succTempFV);
                fuzzyRules[k].addInput(diffTempFV);

                try{


                  if (this.fuzzyRules[k].testRuleMatching()) {

                    fvv = fuzzyRules[k].execute();

                    fv = fvv.fuzzyValueAt(0);


                    if (globalOutput == null) {
                      globalOutput = fv;
                    }
                    else {
                      globalOutput = globalOutput.fuzzyUnion(fv);
                    }
                  }
                }catch(NullPointerException e){

                }
            }


            results = globalOutput.momentDefuzzify();

        } catch (XValueOutsideUODException xvouode) {
        } catch (XValuesOutOfOrderException xvoooe) {
        } catch (IncompatibleRuleInputsException irue) {
        } catch (InvalidDefuzzifyException ifve) {
        } catch (IncompatibleFuzzyValuesException ifv) {

        }
        System.out.println(globalOutput.plotFuzzyValue("*"));



        return results;
     }
    public double getOptTime(){
    return optTime;
  }

    public void setOptTime(double optTime){
        this.optTime= optTime;
      }

    public double getMinTime(){
    return minTime;
  }

    public void setMinTime(double minTime){
        this.minTime= minTime;
      }

    public double getMaxTime(){
    return maxTime;
  }

    public void setMaxTime(double maxTime){
        this.maxTime= maxTime;
      }

    public double getShortMax(){
    return shortMax;
  }

    public void setShortMax(double shortMax){
        this.shortMax= shortMax;
      }

    public double getShortMin(){
    return shortMin;
  }

    public void setShortMin(double shortMin){
        this.shortMin= shortMin;
      }

    public double getMediumMax(){
    return mediumMax;
  }

    public void setMediumMax(double mediumMax){
        this.mediumMax= mediumMax;
      }

    public double getMediumMin(){
    return mediumMin;
  }

    public void setMediumMin(double mediumMin){
        this.mediumMin= mediumMin;
      }

    public double getLongMax(){
    return longMax;
  }

    public void setLongMax(double longMax){
        this.longMax= longMax;
      }

    public double getLongMin(){
    return longMin;
  }

    public void setLongMin(double longMin){
        this.longMin= longMin;
      }
}
