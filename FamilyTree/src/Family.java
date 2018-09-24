import java.util.ArrayList;
import java.util.HashMap;

public class Family {
    private HashMap<String, Person> mapFamily = new HashMap<String, Person>();


    private void setPartnerGender(ArrayList<String> arlStrPartners, String strGender){
        for (String partner: arlStrPartners
                ) {

            mapFamily.get(partner).setStrGender(strGender);
        }
    }

    private boolean checkPartnerGender(ArrayList<String> arlStrPartners, String strGender){
        for (String partner: arlStrPartners
                ) {
            if (mapFamily.get(partner).getStrGender() == strGender){
                return false;
            }
        }
        return true;
    }

    public boolean male(String strName){
        if (mapFamily.containsKey(strName)){

            if (mapFamily.get(strName).getStrGender() == null){
                if (mapFamily.get(strName).getArlPersonPartners().isEmpty()){
                    mapFamily.get(strName).setStrGender("Male");

                    setPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Female");
                    return true;
                }else{

                    if(!checkPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Male")){
                        return false;
                    }


                    mapFamily.get(strName).setStrGender("Male");
                    setPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Female");

                    return true;

                }

            }else{
                return false;
            }

        }else{
            mapFamily.put(strName, new Person(strName, "Male"));
            return true;
        }
    }

    public boolean female(String strName){
        if (mapFamily.containsKey(strName)){

            if (mapFamily.get(strName).getStrGender() == null){
                mapFamily.get(strName).setStrGender("Female");
                setPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Male");

                return true;
            }else{
                if(!checkPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Female")){
                    return false;
                }

                mapFamily.get(strName).setStrGender("Female");
                setPartnerGender(mapFamily.get(strName).getArlPersonPartners(), "Male");

                return true;

            }

        }else{
            mapFamily.put(strName, new Person(strName, "Female"));
            return true;
        }
    }

    public boolean isMale(String strName){
        if (mapFamily.containsKey(strName)){

            return mapFamily.get(strName).getStrGender() == "Male";

        }else{
            return false;
        }
    }

    public boolean isFemale(String strName){
        if (mapFamily.containsKey(strName)){

            return mapFamily.get(strName).getStrGender() == "Female";

        }else{
            return false;
        }
    }

    public boolean setParent(String strChildName, String strParentName){

        //ensure child exists
        if (!mapFamily.containsKey(strChildName)) {
            mapFamily.put(strChildName, new Person(strChildName));
        }

        //exit if there are already 2 parents
        if (mapFamily.get(strChildName).getCountParents() == 2){
            return false;
        }

        //ensure parent exists
        if (!mapFamily.containsKey(strParentName)) {
            mapFamily.put(strParentName, new Person(strParentName));
        }
        //child not parent of parent
        if (mapFamily.get(strChildName).getArlPersonChildren().contains(strParentName)){
            return false;
        }

        if(mapFamily.get(strChildName).getCountParents() == 0 ){

            mapFamily.get(strChildName).addPersonParent(mapFamily.get(strParentName).getStrName());
            mapFamily.get(strParentName).addPersonChild(mapFamily.get(strChildName).getStrName());

        }else if(mapFamily.get(strChildName).getCountParents() == 1){





            String thisParentGender = mapFamily.get(strParentName).getStrGender();
            String otherParentName = mapFamily.get(strChildName).getArlPersonParents().get(0);

            String otherParentGender = mapFamily.get(otherParentName).getStrGender();

            if (otherParentGender == null){
                otherParentGender = "";
            }

            if (otherParentGender.equals(thisParentGender)){
                return false;
            }else{
                if (otherParentGender.equals("Male")) {
                    mapFamily.get(strParentName).setStrGender("Female");
                }else if(otherParentGender.equals("Female")){
                    mapFamily.get(strParentName).setStrGender("Male");
                }
            }

            //adding partners to each others list
            mapFamily.get(strParentName).addPersonPartner(mapFamily.get(otherParentName).getStrName());
            mapFamily.get(otherParentName).addPersonPartner(mapFamily.get(strParentName).getStrName());
            //adding child-part to name lists
            mapFamily.get(strChildName).addPersonParent(mapFamily.get(strParentName).getStrName());
            mapFamily.get(strParentName).addPersonChild(mapFamily.get(strChildName).getStrName());


        }else{
            //already ahs 2 parents

            return false;
        }

        return true;


    }

    public String getParents(String strName){
        return mapFamily.get(strName).getArlPersonParents().toString();
    }

    public String getChildren(String strName){
        return mapFamily.get(strName).getArlPersonChildren().toString();
    }
}
