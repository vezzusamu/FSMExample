package PatternRecognizer;

import PatternRecognizer.Utils.CharacterType;
import PatternRecognizer.Utils.CharacterTypeRecognizer;

//This class check the recognising step for the following pattern Numbers + Letters + @
public enum PatternRecognizerState {
    INITIAL {
        @Override
        PatternRecognizerState nextState(Character currentCharacter){
            CharacterType characterType = CharacterTypeRecognizer.typeRecognizing(currentCharacter);
            if(characterType == CharacterType.NUMBER) {
                return NUMBERS;
            }
            return INITIAL;
        }
    },
    NUMBERS{
        @Override
        PatternRecognizerState nextState(Character currentCharacter){
            CharacterType characterType = CharacterTypeRecognizer.typeRecognizing(currentCharacter);
            switch (characterType) {
                case LETTER -> {return LETTERS;}
                case NUMBER -> {return NUMBERS;}
                case SPECIAL_CHARACTER, OTHER -> {
                    return INITIAL;
                }
            }
            return INITIAL;
        }
    },
    LETTERS{
        @Override
        PatternRecognizerState nextState(Character currentCharacter){
            CharacterType characterType = CharacterTypeRecognizer.typeRecognizing(currentCharacter);
            switch (characterType) {
                case LETTER -> {return LETTERS;}
                case NUMBER -> {return NUMBERS;}
                case SPECIAL_CHARACTER -> {return SPECIAL_CHARACTER;}
                case OTHER -> {
                    return INITIAL;
                }
            }
            return INITIAL;
        }
    },
    SPECIAL_CHARACTER{
        @Override
        PatternRecognizerState nextState(Character currentCharacter){
            return SPECIAL_CHARACTER;
        }
    };
    abstract PatternRecognizerState nextState(Character currentCharacter);
}
