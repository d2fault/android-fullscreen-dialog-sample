package io.github.d2fault.mycustomdialog.dialog

import android.app.Dialog
import android.content.Context
import io.github.d2fault.mycustomdialog.R
import io.github.d2fault.mycustomdialog.databinding.DialogFullActivityBinding

object CustomDialogMaker {
    fun getDialog(
        context: Context,
        title: String,
        message: String,
        submitCaption: String,
        cancelCaption: String,
        target: CustomDialogListener
    ) {
        val dialog = Dialog(context, R.style.FullWindowDialog)
        val dialogBinding = DialogFullActivityBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(dialogBinding.root)

        dialogBinding.titleTextView.text = title
        dialogBinding.messageTextView.text = message
        dialogBinding.submitButton.text = submitCaption
        dialogBinding.cancelButton.text = cancelCaption

        dialogBinding.submitButton.setOnClickListener {
            target.onClickSubmitButton()
            dialog.dismiss()
        }

        dialogBinding.cancelButton.setOnClickListener {
            target.onClickCancelButton()
            dialog.dismiss()
        }

        dialog.show()
    }
}