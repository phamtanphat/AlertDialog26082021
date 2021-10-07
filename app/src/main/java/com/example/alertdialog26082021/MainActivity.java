package com.example.alertdialog26082021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = -1;
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Pick your option");
                alertBuilder.setIcon(R.mipmap.ic_launcher);
                alertBuilder.setCancelable(false);

                // multiple choice

                String[] arrayTopping = {"Onion", "Lettuce", "Tomato", "Pepper", "Hot Sauce"};
                boolean[] arrayChecked = {false, false, false, false, false, false};

                alertBuilder.setMultiChoiceItems(arrayTopping, arrayChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });

                alertBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";

                        for (int i = 0; i < arrayTopping.length; i++) {
                            if (arrayChecked[i]) {
                                result += arrayTopping[i] + " , ";
                            }
                        }
                        result = result.substring(0, result.length() - 3 );
                        Toast.makeText(MainActivity.this, "Thành phần : " + result, Toast.LENGTH_SHORT).show();
                    }
                });

                alertBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Không", Toast.LENGTH_SHORT).show();
                    }
                });

//                alertBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
//                    }
//                });

                alertBuilder.show();

            }
        });
    }
}