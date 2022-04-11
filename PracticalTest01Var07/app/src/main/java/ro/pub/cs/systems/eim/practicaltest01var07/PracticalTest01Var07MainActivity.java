package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText text_1, text_2, text_3, text_4;
    private IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);


        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);
        text_4 = findViewById(R.id.text_4);

        findViewById(R.id.set).setOnClickListener(setListener);

        Intent intent = new Intent(getApplicationContext(), PracticalTEst01Var07Service.class);
        getApplicationContext().startService(intent);

        intentFilter.addAction("action");
    }

    private SetListener setListener = new SetListener();
    private class SetListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.set) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                if (text_1.getText().toString().isEmpty() || text_2.getText().toString().isEmpty() ||
                        text_3.getText().toString().isEmpty() || text_4.getText().toString().isEmpty())
                    return;
                intent.putExtra("text_1", text_1.getText().toString());
                intent.putExtra("text_2", text_2.getText().toString());
                intent.putExtra("text_3", text_3.getText().toString());
                intent.putExtra("text_4", text_4.getText().toString());
                startActivityForResult(intent, 2022);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("text_1", text_1.getText().toString());
        bundle.putString("text_2", text_2.getText().toString());
        bundle.putString("text_3", text_3.getText().toString());
        bundle.putString("text_4", text_4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.containsKey("text_1")) {
            text_1.setText(bundle.getString("text_1"));
        }
        if (bundle.containsKey("text_2")) {
            text_2.setText(bundle.getString("text_2"));
        }
        if (bundle.containsKey("text_3")) {
            text_3.setText(bundle.getString("text_3"));
        }
        if (bundle.containsKey("text_4")) {
            text_4.setText(bundle.getString("text_4"));
        }
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTEst01Var07Service.class);
        stopService(intent);
        super.onDestroy();
    }

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("tag", "received random numbers");
            text_1.setText(String.valueOf(intent.getIntExtra("text_1", 0)));
            text_2.setText(String.valueOf(intent.getIntExtra("text_2", 0)));
            text_3.setText(String.valueOf(intent.getIntExtra("text_3", 0)));
            text_4.setText(String.valueOf(intent.getIntExtra("text_4", 0)));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }
}