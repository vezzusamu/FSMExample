package PatternRecognizer.Utils;

public class CharacterTypeRecognizer {
    private static final int MIN_NUMBER_VALUE_ASCII = 48;
    private static final int MAX_NUMBER_VALUE_ASCII = 57;
    private static final int MIN_UPPERCASE_VALUE_ASCII = 65;
    private static final int MAX_UPPERCASE_VALUE_ASCII = 90;
    private static final int MIN_LOWERCASE_VALUE_ASCII = 97;
    private static final int MAX_LOWERCASE_VALUE_ASCII = 122;
    private static final int SPECIAL_CHARACTER_VALUE_ASCII = 64;


    public static CharacterType typeRecognizing(Character character){
        int asciiValue = (int) character;
        if(characterIsNumber(asciiValue)){
            return CharacterType.NUMBER;
        }
        else if(characterIsLetter(asciiValue)){
            return CharacterType.LETTER;
        } else if(asciiValue == SPECIAL_CHARACTER_VALUE_ASCII){
            return CharacterType.SPECIAL_CHARACTER;
        }
        return CharacterType.OTHER;
    }

    private static boolean characterIsNumber(int asciiValue){
        return asciiValue >= MIN_NUMBER_VALUE_ASCII && asciiValue <= MAX_NUMBER_VALUE_ASCII;
    }

    private static boolean characterIsLetter(int asciiValue){
        return (asciiValue >= MIN_UPPERCASE_VALUE_ASCII && asciiValue <= MAX_UPPERCASE_VALUE_ASCII) ||
                (asciiValue >= MIN_LOWERCASE_VALUE_ASCII && asciiValue <= MAX_LOWERCASE_VALUE_ASCII);
    }
}
