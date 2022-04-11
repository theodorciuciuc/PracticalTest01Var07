package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Random;

public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;
    private Random random = new Random();


    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Log.d("tag", "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("tag", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("action");
        intent.putExtra("text_1", random.nextInt(10));
        intent.putExtra("text_2", random.nextInt(10));
        intent.putExtra("text_3", random.nextInt(10));
        intent.putExtra("text_4", random.nextInt(10));
        Log.d("tag", "sent random numbers");
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
