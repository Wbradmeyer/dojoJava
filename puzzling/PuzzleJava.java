import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
        
Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            rolls.add(randMachine.nextInt(1, 21));
        }
        return rolls;
    }

    public char getRandomLetter() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index = randMachine.nextInt(0, 26);
        return letters[index];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 1; i <=8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> arrayOfPasswords = new ArrayList<String>();
        for (int i = 1; i <= length; i++) {
            arrayOfPasswords.add(generatePassword());
        }
        return arrayOfPasswords;
    }

    public String[] shuffleArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String temp = array[i];
            int randIndex = randMachine.nextInt(0, array.length);
            array[i] = array[randIndex];
            array[randIndex] = temp;
        }
        return array;
    }
} 