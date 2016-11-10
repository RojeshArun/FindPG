package pg.guest.findpg.Utils;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

/**
 * Created by ADMIN on 21-08-2016.
 */
public class StaticUtils {

    public static boolean IS_GUEST_LOGIN = false;


    public static boolean isValidEmail(String s) {
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }

    public static void ShowToast(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
