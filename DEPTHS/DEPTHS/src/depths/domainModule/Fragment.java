package depths.domainModule;

public class Fragment {
  public int getFragmentDetailLevel(){
    return fragmentDetailLevel;
  }

  public void setFragmentDetailLevel(int fragmentDetailLevel){
      this.fragmentDetailLevel= fragmentDetailLevel;

    }

  public String getFragmentContent(){ return fragmentContent; }

  public void setFragmentContent(String fragmentContent){
    this.fragmentContent = fragmentContent;

  }

  public String getFragmentTitle(){ return fragmentTitle; }

  public void setFragmentTitle(String fragmentTitle){
    this.fragmentTitle = fragmentTitle;

  }

  public String getFragmentType(){ return fragmentType; }

  public void setFragmentType(String fragmentType){
    this.fragmentType = fragmentType;

  }

  public String getFragmentID(){
    return fragmentID;
  }

  public void setFragmentID(String fragmentID){
      this.fragmentID= fragmentID;

    }

  public void addFragmentElem(String el,String val) {
    if (el.equals("ID")){
    this.setFragmentID(val);
  }else if (el.equals("type")){
      this.setFragmentType(val);
    }else if (el.equals("title")){
      this.setFragmentTitle(val);
    }else if (el.equals("content")){
      this.setFragmentContent(val);
    }
  }
  public void addFragmentElem(String el,int val) {
    if (el.equals("detailLevel")){
     this.setFragmentDetailLevel(val);
   }

  }

  private int fragmentDetailLevel;
  private String fragmentContent;
  private String fragmentTitle;
  private String fragmentType;
  private String fragmentID;
}
