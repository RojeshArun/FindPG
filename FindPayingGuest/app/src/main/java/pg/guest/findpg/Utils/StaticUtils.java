package pg.guest.findpg.Utils;

import android.util.Patterns;

/**
 * Created by ADMIN on 21-08-2016.
 */
public class StaticUtils {

    public static boolean IS_GUEST_LOGIN = false;


    public static boolean isValidEmail(String s) {
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }
}
