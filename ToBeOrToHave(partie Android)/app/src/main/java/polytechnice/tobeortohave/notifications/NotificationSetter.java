package polytechnice.tobeortohave.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import polytechnice.tobeortohave.main.MainActivity;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Pierre on 21/05/2017.
 */

public class NotificationSetter {
    private MainActivity activity;
    AlarmManager alarmManager;

    public NotificationSetter(MainActivity activity){
        this.activity = activity;
        alarmManager = (AlarmManager)activity.getSystemService(ALARM_SERVICE);
    }

    public PendingIntent setNotifications(ArrayList<String> data,Bundle b) {
        b = setBundle(data,b);
        Intent intent = new Intent(activity, AlarmReceiver.class);
        intent.putExtras(b);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(activity, ((int) System.currentTimeMillis()), intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 10000, 60000, pendingIntent);
        return pendingIntent;
    }

    public void cancelNotification(PendingIntent pendingIntent){
        alarmManager.cancel(pendingIntent);
    }

    private Bundle setBundle( ArrayList<String> data,Bundle b){
        b.remove("data");
        b.putStringArrayList("data",data);
        return b;
    }
}
