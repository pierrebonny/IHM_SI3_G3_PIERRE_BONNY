package polytechnice.tobeortohave.notifications;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.util.Timer;
import java.util.TimerTask;

import polytechnice.tobeortohave.R;
import polytechnice.tobeortohave.main.MainActivity;

/**
 * Created by Pierre on 14/05/2017.
 */

public class RepeatAction {
    private Timer t;
    private Timer t1;
    private Timer t2;
    private MainActivity activity;

    public RepeatAction(MainActivity activity) {
        t = new Timer();
        t1 = new Timer();
        t2 = new Timer();
        t.schedule(new MonAction(activity,0), 280000, 180000);
        t1.schedule(new MonAction(activity,1), 200000, 180000);
        t2.schedule(new MonAction(activity,2), 120000, 180000);
        this.activity = activity;
    }

    public void cancel(int timer){
        switch (timer){
            case 0:
                t.cancel();
                t.purge();
                break;
            case 1:
                t1.cancel();
                t1.purge();
                break;
            case 2:
                t2.cancel();
                t2.purge();
                break;
            default:
                break;
            }
    }

    public void schedule(int timer){
        switch (timer){
            case 0:
                t.cancel();
                t.purge();
                t = new Timer();
                t.schedule(new MonAction(activity,0),180000,180000);
                break;
            case 1:
                t1.cancel();
                t1.purge();
                t1 = new Timer();
                t1.schedule(new MonAction(activity,1),180000,180000);
                break;
            case 2:
                t2.cancel();
                t2.purge();
                t2 = new Timer();
                t2.schedule(new MonAction(activity,2),180000,180000);
                break;
            default:
                break;
        }
    }

    class MonAction extends TimerTask {
        private MainActivity activity;
        int n;
        public MonAction(MainActivity activity,int n) {
            this.activity = activity;
            this.n = n;
        }

        public void run() {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    String title = null;
                    String message = null;
                    switch(n){
                        case 0:
                            title = "Alerte Soldes";
                            message = "Les soldes ont débuté, profitez de -10% supplémentaires sur tout les produits soldés";
                            break;
                        case 1:
                            title = "Alerte ventes privées";
                            message = "Les ventes privées ont débuté, profitez des prix soldés avant les soldes grâce à votre carte de fidélité";
                            break;
                        case 2:
                            title = "Alerte ToBeHappy";
                            message = "Dès maintenant tentez votre chance en jouant à notre grand jeu du mois";
                            break;
                        default:
                            break;
                    }
                    AlertDialog alertDialog = new AlertDialog.Builder(activity)
                            .setTitle(title)
                            .setMessage(message)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(R.drawable.cot)
                            .show();
                }
            };
            activity.runOnUiThread(run);
        }
    }
}
