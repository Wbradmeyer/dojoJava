public class AlfredTest {

    public static void main(String[] args) {
        // AlfredQuotes instance
        AlfredQuotes alfredBot = new AlfredQuotes();

        // greetings
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis, how about a fat beat?");
        String alfredTest = alfredBot.respondBeforeAlexis("Where is my kazoo. Maybe Alfred knows.");
        String notRelevantTest = alfredBot.respondBeforeAlexis("I am the terror that quacks in the night.");

        String testBonusGreeting = alfredBot.guestGreeting("Bruce Wayne", "evening");
        String lengthTest = alfredBot.respondBeforeAlexis("wefnweifubqicqbhcbqwbwihxb   oiwhb   owihbwbqonoiwunxwouifhcwoeifxuwefwhfniuwefiwzufhmowiufmwouiwofuiwmouibmvoihfbvoiwbe");

        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);

        System.out.println(testBonusGreeting);
        System.out.println(lengthTest);
    }
}