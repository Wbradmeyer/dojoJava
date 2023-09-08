import java.util.Date;
public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello %s, lovely to see you.", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return String.format("It is currently %s.", date);
    }

    public String respondBeforeAlexis(String conversation) {
        if(conversation.length() > 50) {
            return "You lost me. Please ask again more succinctly.";
        } else if(conversation.indexOf("Alexis") > -1) {
            return "I shall handle that request in her absence.";
        } else if(conversation.indexOf("Alfred") > -1) {
            return "At your service, naturally.";
        } else {
            return "Right. And with that, I shall retire.";
        }
    }
}