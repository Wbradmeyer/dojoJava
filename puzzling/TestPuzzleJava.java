import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
        char singleLetter = generator.getRandomLetter();
        System.out.println(singleLetter);

        String newPassword = generator.generatePassword();
        System.out.println(newPassword);

        ArrayList<String> setOfPasswords = generator.getNewPasswordSet(6);
        System.out.println(setOfPasswords);

        String[] testArray = {"dbei", "qowi", "wvbi", "muyw", "aecf", "yomj"};
        String[] shuffledArray = generator.shuffleArray(testArray);

        for (int i = 0; i < shuffledArray.length; i++) {
            System.out.println(shuffledArray[i]);
        }
	}
}
