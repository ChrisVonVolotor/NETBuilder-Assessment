public class LetterToPosition {
    private String strReplacedInput = "";
    private int intAsciiPosition;

    public String replaceLetterWithPosition(String strInput){
        strReplacedInput = "";

        String strInputLower = strInput.toLowerCase();

        char[] arrChrInput = strInputLower.toCharArray();

        for (char chrLetter: arrChrInput
             ) {
            intAsciiPosition = (int)chrLetter;
            if (intAsciiPosition >= 97 && intAsciiPosition <= 122){
                strReplacedInput += (intAsciiPosition - 96) + " ";
            }

        }

        return strReplacedInput;
    }
}
