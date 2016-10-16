package ch.heigvd.sym.template;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class SuccessActivity extends AppCompatActivity {

    // Intent keywords
    public final static String emailEntered = "emailEntered";
    public final static String passwordGiven = "passwordGiven";

    // GUI elements
    TextView emailTextView = null;
    TextView imeiTextView = null;
    ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // Retrieve data from MainActivity
        Intent intent = getIntent();
        String email = intent.getStringExtra(emailEntered);
        String password = intent.getStringExtra(passwordGiven);

        // Get the layout elements
        emailTextView = (TextView)findViewById(R.id.successEmail);
        imeiTextView = (TextView)findViewById(R.id.imei);
        imageView = (ImageView)findViewById(R.id.imageView);

        // Set the email text field
        emailTextView.setText(email);

        // Set the IMEI number
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        imeiTextView.setText(tm.getDeviceId());

        // Set the image from file
        File image = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Test.jpg");
        if(image.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(image.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
