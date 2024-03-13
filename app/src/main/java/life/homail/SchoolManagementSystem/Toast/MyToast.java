package life.homail.SchoolManagementSystem.Toast;

import android.content.Context;
import android.widget.Toast;

public class MyToast {
    private static Toast toast;
    public static void makeToast(String toastText, Context context){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(context,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
}
