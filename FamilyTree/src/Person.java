import java.util.ArrayList;

public class Person {
    private String strName;
    private String strGender;
    private ArrayList<String>  arlPersonChildren = new ArrayList<String>();
    private ArrayList<String> arlPersonParents = new ArrayList<String>();
    private ArrayList<String> arlPersonPartners = new ArrayList<String>();

    public Person(String strName){
        this.strName = strName;
    }

    public Person(String strName, String strGender){
        this.strName = strName;
        this.strGender = strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public void addPersonParent(String personParent){
        this.arlPersonParents.add(personParent);
    }

    public int getCountParents(){
        return this.arlPersonParents.size();
    }

    public ArrayList<String> getArlPersonPartners() {
        return arlPersonPartners;
    }

    public  void addPersonPartner(String personPartner){
        this.arlPersonPartners.add(personPartner);
    }

    public void addPersonChild(String personChild){
        this.arlPersonChildren.add(personChild);
    }

    public String getStrName() {
        return strName;
    }

    public String getStrGender() {
        return strGender;
    }

    public ArrayList<String> getArlPersonParents() {
        return arlPersonParents;
    }

    public ArrayList<String> getArlPersonChildren() {
        return arlPersonChildren;
    }
}
