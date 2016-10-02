package pg.guest.findpg.activities.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem());
            addItem(new DummyItem("Kartheek PG","Asian ","100 Beds available","2 Sharing",true));
            addItem(new DummyItem("ABC PG","North Indian ","10 Beds available","5 Sharing",false));
            addItem(new DummyItem("Duffa PG","Asian ","100 Beds available","10 Sharing",true));
            addItem(new DummyItem("No Entry PG","African ","143 Beds available","2 Sharing",false));

    }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.pgName, item);
    }

    private static DummyItem createDummyItem() {
        return new DummyItem("Chamndeswari PG","South Indian","3 Beds available","2 Sharing",true);
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String pgName,pgType,pgBedStatus,roomSharing;
        public final boolean gender;

        public DummyItem(String pgName, String pgType, String pgBedStatus,String roomSharing,boolean gender) {
            this.pgName = pgName;
            this.pgType = pgType;
            this.pgBedStatus = pgBedStatus;
            this.roomSharing = roomSharing;
            this.gender = gender;

        }

        @Override
        public String toString() {
            return pgName;
        }
    }
}
