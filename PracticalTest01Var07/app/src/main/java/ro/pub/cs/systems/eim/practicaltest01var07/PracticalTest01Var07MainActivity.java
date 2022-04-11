package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText text_1, text_2, text_3, text_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);
        text_4 = findViewById(R.id.text_4);

        findViewById(R.id.set).setOnClickListener(setListener);
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
}