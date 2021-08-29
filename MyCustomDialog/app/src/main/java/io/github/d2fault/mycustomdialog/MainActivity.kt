package io.github.d2fault.mycustomdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.d2fault.mycustomdialog.dialog.CustomDialogListener
import io.github.d2fault.mycustomdialog.dialog.CustomDialogMaker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDialogButton = findViewById<Button>(R.id.showDialogButton)

        showDialogButton.setOnClickListener {
            CustomDialogMaker.getDialog(
                this,
                "title",
                "message",
                "submit",
                "cancel",
                object : CustomDialogListener {
                    override fun onClickSubmitButton() {
                        Toast.makeText(applicationContext, "SUBMIT!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onClickCancelButton() {
                        Toast.makeText(applicationContext, "CANCEL!", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}