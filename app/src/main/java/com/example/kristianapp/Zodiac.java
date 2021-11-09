package com.example.kristianapp;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.Random;

public class Zodiac extends AppCompatActivity {
    private static final String CHANNEL_ID = String.valueOf(R.string.CHANNEL_ID_ZODIAC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name_zodiac);
            String description = getString(R.string.channel_description_zodiac);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void submitZodiacToast(View v) {
        DatePicker datepicker = (DatePicker) findViewById(R.id.pickedDate);
        int day = datepicker.getDayOfMonth();
        int month = datepicker.getMonth() + 1;
        int year = datepicker.getYear();
        Toast.makeText(this, month + "-" + day + "-" + year, Toast.LENGTH_LONG).show();

    }
    public void submitZodiacData(View view) {
        DatePicker datePicker = (DatePicker) findViewById(R.id.pickedDate);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;;

        String sign = getSign(month, day);
        String iconName = sign.toLowerCase();
        int resID = getResources().getIdentifier(iconName, "drawable", getPackageName());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, String.valueOf(R.string.CHANNEL_ID))
                .setSmallIcon(R.drawable.zodiacicon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        resID))
                .setContentTitle("Your zodiac sign")
                .setContentText("Your zodiac sign is " + sign)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(new Random().nextInt(), builder.build());
    }

    public String getSign(int month, int day) {
        String sign = "";
        if (month == 1) {
            if (day < 20)
                sign = "Capricorn";
            else
                sign = "Aquarius";
        }
        else if (month == 2) {
            if (day < 19)
                sign = "Aquarius";
            else
                sign = "Pisces";
        }
        else if(month == 3) {
            if (day < 21)
                sign = "Pisces";
            else
                sign = "Aries";
        }
        else if (month == 4) {
            if (day < 20)
                sign = "Aries";
            else
                sign = "Taurus";
        }
        else if (month == 5) {
            if (day < 21)
                sign = "Taurus";
            else
                sign = "Gemini";
        }
        else if( month == 6) {
            if (day < 21)
                sign = "Gemini";
            else
                sign = "Cancer";
        }
        else if (month == 7) {
            if (day < 23)
                sign = "Cancer";
            else
                sign = "Leo";
        }
        else if( month == 8) {
            if (day < 23)
                sign = "Leo";
            else
                sign = "Virgo";
        }
        else if (month == 9) {
            if (day < 23)
                sign = "Virgo";
            else
                sign = "Libra";
        }
        else if (month == 10) {
            if (day < 23)
                sign = "Libra";
            else
                sign = "Scorpio";
        }
        else if (month == 11) {
            if (day <= 22)
                sign = "Scorpio";
            else
                sign = "Sagittarius";
        }
        else if (month == 12) {
            if (day < 22)
                sign = "Sagittarius";
            else
                sign ="Capricorn";
        }

        return sign;
    }
}
