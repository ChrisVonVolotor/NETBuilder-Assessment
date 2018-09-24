public class Main {

    public static void main(String[] args) {

        Family fam = new Family();
        System.out.println(fam.setParent("Frank", "Morgan")); // true
        System.out.println(fam.setParent("Frank", "Dylan")); // true
        System.out.println(fam.male("Dylan")); // true
        System.out.println(fam.setParent("Joy", "Frank")); // true
        System.out.println(fam.male("Frank")); // true
        System.out.println(fam.male("Morgan")); // false
        System.out.println(fam.setParent("July", "Morgan")); // true
        System.out.println(fam.isMale("Joy") || fam.isFemale("Joy")); // false
        System.out.println(fam.getChildren("Morgan")); // ["Frank", "July"]
        System.out.println(fam.setParent("Jennifer", "Morgan")); // true
        System.out.println(fam.getChildren("Morgan")); // ["Frank", "Jennifer", "July"]
        System.out.println(fam.getChildren("Dylan")); // ["Frank"]
        System.out.println(fam.getParents("Frank")); // ["Dylan", "Morgan"]
        System.out.println(fam.setParent("Morgan", "Frank")); // false

        System.out.println(fam.female("Dylan")); // false
        System.out.println(fam.isFemale("Morgan")); // true
    }
}
