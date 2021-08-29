package io.github.d2fault.mycustomdialogjava;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialogMaker {

    public static void getDialog(Context context, String title, String message, String submitCaption, String cancelCaption, final CustomDialogListener target) {
        Dialog dialog = new Dialog(context, R.style.FullWindowDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_full_activity);

        TextView titleTextView = dialog.findViewById(R.id.titleTextView);
        TextView messageTextView = dialog.findViewById(R.id.messageTextView);
        Button submitButton = dialog.findViewById(R.id.submitButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);

        titleTextView.setText(title);
        messageTextView.setText(message);
        submitButton.setText(submitCaption);
        cancelButton.setText(cancelCaption);

        submitButton.setOnClickListener(v -> {
            target.onClickSubmitButton();
            dialog.dismiss();
        });

        cancelButton.setOnClickListener(v -> {
            target.onClickCancelButton();
            dialog.dismiss();
        });

        dialog.show();
    }
}
