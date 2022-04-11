package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText text_1, text_2, text_3, text_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);
        text_4 = findViewById(R.id.text_4);

        findViewById(R.id.sum).setOnClickListener(myButtonListener);
        findViewById(R.id.product).setOnClickListener(myButtonListener);

        Intent intent = getIntent();
        if (intent != null) {
            String string = intent.getStringExtra("text_1");
            text_1.setText(String.valueOf(string));
            string = intent.getStringExtra("text_2");
            text_2.setText(String.valueOf(string));
            string = intent.getStringExtra("text_3");
            text_3.setText(String.valueOf(string));
            string = intent.getStringExtra("text_4");
            text_4.setText(String.valueOf(string));
        }
    }

    private MyButtonListener myButtonListener = new MyButtonListener();
    private class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int number_1 = Integer.valueOf(text_1.getText().toString());
            int number_2 = Integer.valueOf(text_2.getText().toString());
            int number_3 = Integer.valueOf(text_3.getText().toString());
            int number_4 = Integer.valueOf(text_4.getText().toString());
            if (view.getId() == R.id.sum) {
                int sum = number_1 + number_2 + number_3 + number_4;
                Toast.makeText(getApplicationContext(), "The sum is " + sum, Toast.LENGTH_LONG).show();
            }
            if (view.getId() == R.id.product) {
                int prod = number_1 * number_2 * number_3 * number_4;
                Toast.makeText(getApplicationContext(), "The product is " + prod, Toast.LENGTH_LONG).show();
            }
        }
    }
}