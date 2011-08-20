package depths.coordinator;
import depths.domainModule.Course;
import depths.domainModule.XMLCourseReaderMgr;

public class DomainModuleFacade {
  private Course course;
  private XMLCourseReaderMgr readerMgr;
  private Tutor tutor;
  private PedagogicalModuleFacade pmf;
  private String currentReadingConceptId;
  private String currentReadingUnitId;
  private String unitTitle;

  public DomainModuleFacade(Tutor tut){
    tutor=tut;
    initializeDomainModule();

  }

  /**Inicijalizuje domenski model pre pocetka sesije ucenja*/
  public void initializeDomainModule(){
    String uri=tutor.getDomainModuleURI();
    //uri="resources/xml/example_domain.xml";
    course=new Course(this);
    readerMgr=new XMLCourseReaderMgr(course,uri);
  }
  public void setRef(PedagogicalModuleFacade ref){
    pmf=ref;
  }
  /**Podesava trenutni koncept koji se cita*/
  public void startNewConcept(String currConcId){


    currentReadingConceptId=currConcId;

    course.startReadingNewConcept(currentReadingConceptId);
  }
  public void readNexLesson(String currUnitId){
    currentReadingUnitId=currUnitId;
    course.readNextLesson(currentReadingUnitId);

  }
  public void  sendUnitData(String currReadUnitId,String unTitle,int diffLev){

    tutor.sendUnitData(currReadUnitId,unTitle, diffLev);

  }
  public void sendConceptTitle(String title){
    tutor.sendConceptTitle(title);
  }
  public void readNextFragment(String fragmId){
    course.readNextFragment(fragmId);
  }
  public void sendFragmentData(String id,String title,String type,String content){

    tutor.sendFragmentData(id,title,type,content);
  }
  /**pronalazi pitanje na osnovu njegovog ID broja*/
  public void getQuestionFromDMbyID(String qId){
    course.getQuestionFromDMbyID(qId);

  }
  public void sendAnswerData(String ansContent,boolean aTruth){
    tutor.sendAnswerData(ansContent,aTruth);
  }
  public void sendQuestionData(String id,String content){
      tutor.sendQuestionData(id,content);


    }
    public void checkStudAnswerByID(String questId,int studAnswer){
      course.checkStudAnswerByID(questId,studAnswer);
    }
    public void sendStudentAnswerBackFromDM( String questId,String questContent,int studAnswer,
                  int indexOfTruthAnsw,String textOfTruthAnsw,String qRelatedTo,int qGroup,
                  int questionDifficultyLevel,int optTimeToSolveQuest){
        pmf.sendStudentAnswerBackFromDM(questId,questContent,studAnswer,
        indexOfTruthAnsw,textOfTruthAnsw,qRelatedTo,qGroup, questionDifficultyLevel, optTimeToSolveQuest);
   }

   /**Pronalazi naslov lekcije koju student treba da ponovi*/
    public String  getTitleOfLessonToReLearn(String lessId){
       String lessTitle=course.getTitleOfLessonToReLearn(lessId);
       return lessTitle;
   }
   /**Pronalazi  title koncepta na osnovu id koncepta
    * za sadrzaj na stranici*/
   public String findConceptTitleById(String cid){
     String cTitle=course.findConceptTitleById(cid);
     return cTitle;
   }
   /**Postavlja koncept koji se trenutno ucitava u statistic page u
     * domenskom modulu*/
    public void setConceptForStatPage(String concId){
      course.setConceptForStatPage(concId);
    }
    /**Pronalazi tekst pitanja i salje ga u statistic page*/
    public String getQuestContent(String qId){
      String questCont=course.getQuestContent(qId);
      return questCont;

    }
   /**pronalazi naslov lekcije koji treba dodati u meni*/
   public String findUnitTitleById(String unitId){
     String title=course.getTitleOfLessonToReLearn(unitId);
         return title;
   }
}
