package com.example.kristianapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

public class Calculator extends AppCompatActivity {
    private static final String CHANNEL_ID = String.valueOf(R.string.CHANNEL_ID);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        this.createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void add(View view) {
        TextView resultText = (TextView) findViewById(R.id.calculator_result);
        EditText value1 = (EditText) findViewById(R.id.calculator_value_1);
        EditText value2 = (EditText) findViewById(R.id.calculator_value_2);

        if (value1.getText().toString().equals("") || value2.getText().toString().equals("")) {
            resultText.setText("0");
            return;
        }

        int firstNum = Integer.parseInt(value1.getText().toString());
        int secondNum = Integer.parseInt(value2.getText().toString());

        int result = firstNum + secondNum;
        resultText.setText(String.valueOf(result));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, String.valueOf(R.string.CHANNEL_ID))
                .setSmallIcon(R.drawable.calculator)
                .setContentTitle("Addition")
                .setContentText(String.valueOf(result))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(new Random().nextInt(), builder.build());
    }

    public void subtract(View view) {
        TextView resultText = (TextView) findViewById(R.id.calculator_result);
        EditText value1 = (EditText) findViewById(R.id.calculator_value_1);
        EditText value2 = (EditText) findViewById(R.id.calculator_value_2);

        if (value1.getText().toString().equals("") || value2.getText().toString().equals("")) {
            resultText.setText("0");
            return;
        }

        int firstNum = Integer.parseInt(value1.getText().toString());
        int secondNum = Integer.parseInt(value2.getText().toString());
        int result = firstNum - secondNum;
        resultText.setText(String.valueOf(result));
    }

    public void multiply(View view) {
        TextView resultText = (TextView) findViewById(R.id.calculator_result);
        EditText value1 = (EditText) findViewById(R.id.calculator_value_1);
        EditText value2 = (EditText) findViewById(R.id.calculator_value_2);

        if (value1.getText().toString().equals("") || value2.getText().toString().equals("")) {
            resultText.setText("0");
            return;
        }

        int firstNum = Integer.parseInt(value1.getText().toString());
        int secondNum = Integer.parseInt(value2.getText().toString());
        int result = firstNum * secondNum;
        resultText.setText(String.valueOf(result));
    }

    public void divide(View view) {
        TextView resultText = (TextView) findViewById(R.id.calculator_result);
        EditText value1 = (EditText) findViewById(R.id.calculator_value_1);
        EditText value2 = (EditText) findViewById(R.id.calculator_value_2);

        if (value1.getText().toString().equals("") || value2.getText().toString().equals("")) {
            resultText.setText("0");
            return;
        }

        int firstNum = Integer.parseInt(value1.getText().toString());
        int secondNum = Integer.parseInt(value2.getText().toString());
        int result = firstNum / secondNum;
        resultText.setText(String.valueOf(result));
    }
}