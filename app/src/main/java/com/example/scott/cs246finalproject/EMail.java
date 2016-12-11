package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EMail extends AppCompatActivity {

    public static final String SUBJECT = "Subject";

    public static final String BODY = "Body";

    private String emailSubject, emailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        // retrieve data to be sent
        Intent sentData = getIntent();
        emailSubject = sentData.getStringExtra(SUBJECT);
        emailBody = sentData.getStringExtra(BODY);

        TextView textView = (TextView) findViewById(R.id.txtView_msg_body);
        textView.setText(emailBody);
    }


    public void sendMessage(View view){
        Log.i("Send email", "");
        String[] TO = {"medahardy@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
