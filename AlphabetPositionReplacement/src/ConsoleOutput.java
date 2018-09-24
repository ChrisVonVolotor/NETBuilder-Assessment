import java.util.Scanner;

public class ConsoleOutput {
    private Scanner sc = new Scanner(System.in);
    private LetterToPosition ltpReplacer = new LetterToPosition();



    public void outputStart(){
        outputWelcome();
        outputStringRequest();

    }

    private void outputWelcome(){
        System.out.println();
        System.out.println("Welcome to the Alphabet Position Replacement Tool!");
        System.out.println("NETbuilder Assessment September 2018");
        System.out.println("Author: Christopher Darrall");
        System.out.println();
    }

    private void outputStringRequest( ){
        String strInput;
        Boolean booActive = true;

        while (booActive) {
            strInput = "";
            System.out.println();
            System.out.println("Please input a string to replace with positions: (leave blank to exit)");
            strInput = sc.nextLine();
            if (strInput.isEmpty()){
                booActive = false;
                System.out.println("Goodbye!");
            }else{
                System.out.println(ltpReplacer.replaceLetterWithPosition(strInput));
            }
        }
    }
}
