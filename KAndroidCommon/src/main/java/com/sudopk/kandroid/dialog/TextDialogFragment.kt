package com.sudopk.kandroid.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AppCompatDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.sudopk.kandroid.R

class TextDialogFragment : AppCompatDialogFragment() {

    private fun onButton(button: ButtonDescription) {
        dismiss()
        onButtonClicked(button.id)
    }

    private fun onButtonClicked(buttonId: String) {
        container.onDialogButtonClicked(buttonId)
    }

    private val container: Container
        get() {
            if (parentFragment != null) {
                return parentFragment as Container
            }
            return activity as Container
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.getString(TITLE)?.isNotBlank() ?: false) {
            setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_Dialog)
        } else {
            setStyle(DialogFragment.STYLE_NO_TITLE, 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.text_dialog_fragment, container, false)
        view.findViewById<TextView>(R.id.message).text = arguments!!.getString(MESSAGE)

        val buttons = view.findViewById<LinearLayout>(R.id.buttons)

        buttons.removeAllViews()

        for (button in arguments!!.getParcelableArray(BUTTONS)!!) {
            addButton(inflater, buttons, button as ButtonDescription)
        }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setTitle(arguments!!.getString(TITLE))
        return dialog
    }

    private fun addButton(inflater: LayoutInflater, parent: ViewGroup, buttonDescription: ButtonDescription) {
        val button = inflater.inflate(R.layout.borderless_button, parent, false) as Button
        button.setOnClickListener { onButton(buttonDescription) }
        button.text = buttonDescription.title
        parent.addView(button)
    }

    class Builder(private val mMessage: String, private val mButtons: Array<ButtonDescription>) {
        private var mCancelable: Boolean
        private var mTitle: String

        init {
            mCancelable = false
            mTitle = ""
        }

        fun setCancelable(cancelable: Boolean): Builder {
            mCancelable = cancelable
            return this
        }

        fun setTitle(title: String): Builder {
            mTitle = title
            return this
        }

        fun build(): TextDialogFragment {
            val args = Bundle()
            args.putString(TITLE, mTitle)
            args.putString(MESSAGE, mMessage)
            args.putParcelableArray(BUTTONS, mButtons)

            val fragment = TextDialogFragment()
            fragment.arguments = args
            fragment.isCancelable = mCancelable
            return fragment
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        container.onDialogCanceled()
    }

    interface Container {
        fun onDialogButtonClicked(buttonId: String)

        fun onDialogCanceled()
    }

    companion object {
        private val TITLE = "title"
        private val MESSAGE = "message"
        private val BUTTONS = "buttons"

        fun newBlockingInstance(message: String, buttons: Array<ButtonDescription>): TextDialogFragment {
            return Builder(message, buttons).setCancelable(false).build()
        }

        fun newCancelableInstance(message: String, buttons: Array<ButtonDescription>): TextDialogFragment {
            return Builder(message, buttons).setCancelable(true).build()
        }
    }
}
