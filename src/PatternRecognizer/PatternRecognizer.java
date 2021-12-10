package PatternRecognizer;

import PatternRecognizer.Utils.CharacterTypeRecognizer;

//TODO add testing class
//This class recognizes the pattern: NUMBERS, LETTERS, SPECIALCHAR @
public class PatternRecognizer {

    public static void main(String args)  //static method
    {
        System.out.println(doesRespectPattern("123ciaAD@"));
    }

    public static boolean doesRespectPattern(String actualString){
        PatternRecognizerState recognizerState = PatternRecognizerState.INITIAL;
           for(Character c : actualString.toCharArray()){
               recognizerState = recognizerState.nextState(c);
           }
           return PatternRecognizerState.SPECIAL_CHARACTER == recognizerState;
    }
}
