package com.example.alertdialog26082021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog,mBtnCustomDialog;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);
        mBtnCustomDialog = findViewById(R.id.buttonCustomDialog);

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
                        result = result.substring(0, result.length() - 3);
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

        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.item_dialog);
                dialog.setCancelable(false);

                Window window = dialog.getWindow();
                if (window == null){
                    return;
                }

                // Set gravity cho dialog
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.gravity = Gravity.BOTTOM;
                window.setAttributes(layoutParams);

                // Kich thước dialog
                window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // ánh xạ các view trong layout
                ImageView imgClose = dialog.findViewById(R.id.imageViewClose);
                AppCompatButton button = dialog.findViewById(R.id.appButtonYes);


                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }
}