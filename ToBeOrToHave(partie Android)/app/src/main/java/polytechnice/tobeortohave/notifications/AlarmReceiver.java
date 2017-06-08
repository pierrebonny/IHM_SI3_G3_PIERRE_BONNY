package polytechnice.tobeortohave.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 20/05/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    private List<String> data;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = (Bundle)intent.getExtras();
        data = bundle.getStringArrayList("data");
        int i = 0;
        MyNotification notification = new MyNotification(context,data);
    }
}
