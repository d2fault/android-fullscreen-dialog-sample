package io.github.d2fault.mycustomdialogjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showDialogButton = findViewById(R.id.showDialogButton);
        showDialogButton.setOnClickListener(v -> {
            CustomDialogMaker.getDialog(this, "title", "message", "submit", "cancel", new CustomDialogListener() {
                @Override
                public void onClickSubmitButton() {
                    Toast.makeText(getApplicationContext(), "SUBMIT!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onClickCancelButton() {
                    Toast.makeText(getApplicationContext(), "CANCEL!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}