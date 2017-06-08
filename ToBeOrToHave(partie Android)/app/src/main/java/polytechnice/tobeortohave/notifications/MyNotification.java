package polytechnice.tobeortohave.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import polytechnice.tobeortohave.R;
import polytechnice.tobeortohave.main.MainActivity;

import static android.R.attr.bitmap;
import static android.R.attr.data;
import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Pierre on 19/05/2017.
 */

public class MyNotification {

    private Context context;
    private Notification.BigTextStyle bigTextStyle;
    private Bitmap bitmap;
    private List<String> data;

    public MyNotification(Context context,List<String> data) {
        this.context = context;
        bigTextStyle = new Notification.BigTextStyle();
        bigTextStyle.setBigContentTitle("Alertes Bons Plans");
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.cot);
        this.data = data;
        initializeInboxStyle();
        setNotification();
    }


    public void setNotification(){
        NotificationManager nManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("");
        builder.setContentText("");
        builder.setLargeIcon(bitmap);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.pouce);
        builder.setStyle(bigTextStyle);
        builder.setDefaults(Notification.DEFAULT_LIGHTS);
        builder.setVibrate(new long[]{0l});
        nManager.notify("ToBeOrToHave",0,builder.build());
    }

    private void initializeInboxStyle(){
        bigTextStyle.setSummaryText("Aujourd'hui dans vos magasins ToBeHappy");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< data.size(); i++){
            if(i == data.size() -1){
                builder.append(data.get(i));
            }
            else {
                builder.append(data.get(i)+"\n");
            }
        }
        bigTextStyle.bigText(builder.toString());
    }
}
