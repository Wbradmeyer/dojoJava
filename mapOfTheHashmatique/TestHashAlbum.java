import java.util.HashMap;
import java.util.Set;
public class TestHashAlbum {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Good Times", "We're gonna have a good time...");
        trackList.put("Hard Times", "I've seen some hard times...");
        trackList.put("Bath Time", "It's 6'o'clock so I'll take a bath...");
        trackList.put("Supper Time", "Who's hungry? This guy...");

        String songLyrics = trackList.get("Bath Time");
        System.out.printf("Bath Time : %s\n\n" , songLyrics);

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.printf("Track - %s : Lyrics - %s\n", key, trackList.get(key));
        }
    }
}