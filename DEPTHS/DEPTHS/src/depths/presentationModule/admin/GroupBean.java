package depths.presentationModule.admin;
import depths.adminModule.*;
import java.util.Vector;

public class GroupBean {
  public String getGroupName(){
    return groupName;
  }

  public void setGroupName(String groupName){
      this.groupName= groupName;
    }
    public boolean groupExists(String groupName) {
       boolean returnValue = false;
       returnValue=dbManager.checkIfGroupExists(groupName);

       return returnValue;
  }
  public void setDbManagerRef(DatabaseManager dbManagerRef){
    dbManager=dbManagerRef;
  }
  public void setGroupData(int groupId,String groupName,int langId,String description){
    dbManager.setGroupData(groupId,groupName, langId, description);
  }
  public void setGroupAdministrator(int groupId,int adminId){
    dbManager.setGroupAdministrator(groupId,adminId);
  }
  public void setGroupTeacher(int groupId,int teacherId){
    dbManager.setGroupTeacher(groupId,teacherId);
  }
  public void setGroupCourse(int groupId,String courseId){
    dbManager.setGroupCourse(groupId,courseId);
  }
  public String getNewGroupDataByType(String dataType,int groupId){
      String value=dbManager.getNewGroupDataByType(dataType,groupId);
      if (value.equals("")){
          value="-not set-";
      }
      return value;
  }
  public Vector getNewGroupVectorData(String dataType,int groupId){
      Vector v=dbManager.getNewGroupVectorData(dataType,groupId);
      return v;
  }
public String getNewGroupLanguage(int groupId){
    String value=dbManager.getGroupLanguageById(groupId);
    return value;
}
public void readAllGroups(){

    this.allGroupsIds = dbManager.readAllGroups();

}
public int getGroupsNumb(){
    int val=this.allGroupsIds.size();
    return val;
}
public int getGroupIdByOrdNum(int i){
   Integer val=  (Integer) allGroupsIds.get(i);
   int value=val.intValue();
   return value;
}
public void removeGroupById(int groupId){
    dbManager.removeGroupById(groupId);
}
  private String groupName;
  private DatabaseManager dbManager;
  private Vector allGroupsIds=new Vector();

}

