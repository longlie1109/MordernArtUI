package com.example.test_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize seek bar and color
        Random random = new Random();
        final TextView redbox1 = (TextView) findViewById(R.id.redbox1);
        final TextView yellowbox1 = (TextView) findViewById(R.id.yellowbox1);
        final TextView redbox2 = (TextView) findViewById(R.id.redbox2);
        final TextView yellowbox2 = (TextView) findViewById(R.id.yellowbox2);
        final TextView bluebox2 = (TextView) findViewById(R.id.bluebox2);
        final TextView redbox3 = (TextView) findViewById(R.id.redbox3);
        final TextView yellowbox3 = (TextView) findViewById(R.id.yellowbox3);
        final TextView bluebox3 = (TextView) findViewById(R.id.bluebox3);
        final TextView bluebox1= findViewById(R.id.tv1);
        final TextView bluebox4= findViewById(R.id.tv2);
        final TextView bluebox5= findViewById(R.id.tv2);
        sb = (SeekBar) findViewById(R.id.slider);
        sb.setMax(100);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progChange = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int[] redArray = {random.nextInt(256),random.nextInt(256), random.nextInt(256)};
                int[] blueArray = {random.nextInt(256), random.nextInt(256), random.nextInt(256)};
                int[] yellowArray = {random.nextInt(256), random.nextInt(256),random.nextInt(256)};

                progChange = progress;
                //Make incremental color value changes

                redArray[0] = redArray[0] - (random.nextInt(256) / 100) * progChange;
                redArray[1] = redArray[1] + (random.nextInt(256) / 100) * progChange;
                redArray[2] = redArray[2] + (random.nextInt(256) / 100) * progChange;
                blueArray[0] = blueArray[0] + (random.nextInt(256) / 100) * progChange;
                blueArray[1] = blueArray[1] + (random.nextInt(256) / 100) * progChange;
                blueArray[2] = blueArray[2] - (random.nextInt(256) / 100) * progChange;
                yellowArray[0] = yellowArray[0] - (random.nextInt(256) / 100) * progChange;
                yellowArray[1] = yellowArray[1] - (random.nextInt(256) / 100) * progChange;
                yellowArray[2] = yellowArray[2] + (random.nextInt(256) / 100) * progChange;
                //Set the boxes to new colors

                redbox1.setBackgroundColor(Color.rgb(redArray[0], redArray[1], redArray[2]));
                redbox2.setBackgroundColor(Color.rgb(redArray[0], redArray[1], redArray[2]));
                redbox3.setBackgroundColor(Color.rgb(redArray[0], redArray[1], redArray[2]));
                bluebox2.setBackgroundColor(Color.rgb(blueArray[0], blueArray[1], blueArray[2]));
                bluebox3.setBackgroundColor(Color.rgb(blueArray[0], blueArray[1], blueArray[2]));
                yellowbox1.setBackgroundColor(Color.rgb(yellowArray[0], yellowArray[1], yellowArray[2]));
                yellowbox2.setBackgroundColor(Color.rgb(yellowArray[0], yellowArray[1], yellowArray[2]));
                yellowbox3.setBackgroundColor(Color.rgb(yellowArray[0], yellowArray[1], yellowArray[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.test:
                Toast.makeText(this, "em lam duoc roi", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Hy vong la em lam duoc", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.test2:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                TextView dialog_title = new TextView(this);
                dialog_title.setText("viet gi bay gio");
                dialog_title.setGravity(Gravity.CENTER_HORIZONTAL);
                dialog_title.setPadding(100,30,100,30);
                dialog_title.setTextSize(20);
                builder.setCustomTitle(dialog_title);
                builder.setMessage("hy vong la khong bug");
                builder.setPositiveButton("THOI BO DI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("TIEN VAO WEB DEN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent porn= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/search?q=porn&sxsrf=APq-WBvplVZW9dRUstGkdVtJAbw6WA46ng%3A1649906195368&source=hp&ei=E5JXYrnqE6fT2roP5t23uAg&iflsig=AHkkrS4AAAAAYlegIwjI3SBdfDH__4lBAnQrIZ7F2q0M&ved=0ahUKEwj5v73Fy5L3AhWnqVYBHebuDYcQ4dUDCAg&uact=5&oq=porn&gs_lcp=Cgdnd3Mtd2l6EAM6BggjECcQEzoECCMQJzoICAAQgAQQsQM6CwgAEIAEELEDEIMBOggILhCABBCxAzoLCC4QgAQQsQMQ1AI6EQguEIAEELEDEIMBEMcBEKMCOg4ILhCABBCxAxDHARCjAlAAWLgFYPMPaABwAHgAgAGEBIgBtgeSAQcwLjMuNS0xmAEAoAEB&sclient=gws-wiz"));
                        startActivity(porn);
                    }
                });
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}