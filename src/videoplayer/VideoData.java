
package videoplayer;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author SELMAKA
 */
public class VideoData {

    private static class Item {

        Item(String n, String d, int r) {
            name = n;
            director = d;
            rating = r;
        }

        // instance variables         
        private String name;
        private String director;
        private int rating;
        private int playCount;

        public String toString() {
            return name + " - " + director;
        }
    }

    // with a Map you use put to insert a key, value pair
    // and get(key) to retrieve the value associated with a key
    // You don't need to understand how this works!     
    private static Map<String, Item> library = new TreeMap<String, Item>();

    static {
        // if you want to have extra library items, put them in here         // use the same style - keys should be 2 digit Strings        
        library.put("01", new Item("Tom and Jerry", "Fred Quimby", 3));
        library.put("02", new Item("Tweety Pie ", "Wrexler Ripmophomtofz", 5));
        library.put("03", new Item("Dr. Strangelove", "Stanley Kubrick", 2));
        library.put("04", new Item("Babies 1st Birthday", "Me", 10));
        library.put("05", new Item("Rat Pfink a Boo Boo", "Ray Steckler", 0));
    }

    /**
     * Returns the list of all videos
     *
     * @return Returns the list of all videos
     */
    public static String listAll() {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);
            output += key + " " + item.name + " - " + item.director + "\n";
        }
        return output;
    }

    /**
     * Returns the name of the video
     *
     * @param key the key for the video item
     * @return
     */
    public static String getName(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.name;
        }
    }

    /**
     * returns the director of the video
     *
     * @param key key for the video item
     * @return
     */
    public static String getDirector(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.director;
        }
    }

    /**
     * return the video rating
     *
     * @param key key for the video item
     * @return
     */
    public static int getRating(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.rating;
        }
    }

    /**
     * sets the rating for video item
     *
     * @param key    key for the video item
     * @param rating item for the video
     */
    public static void setRating(String key, int rating) {
        Item item = library.get(key);
        if (item != null) {
            item.rating = rating;
        }
    }

    /**
     * returns the play count for the video
     *
     * @param key key for the video item
     * @return
     */
    public static int getPlayCount(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.playCount;
        }
    }

    /**
     * Increase the play count of the video
     *
     * @param key key for the video item
     */
    public static void incrementPlayCount(String key) {
        Item item = library.get(key);
        if (item != null) {
            item.playCount += 1;
        }
    }

    /**
     * Does nothing, as the static database is used
     */
    public static void close() {
        // Does nothing for this static version.
        // Write a statement to close the database when you are using one
    }
}