package webapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lns16 on 6/27/2017.
 */
public class Entries {

    private static Map<String, Entry> entries;

    static {

        entries = new HashMap<String, Entry>(){

            {
                put("dog", new Entry());
                put("cat", new Entry());
                put("kitty", new Entry());
            }
        };
    }


}
