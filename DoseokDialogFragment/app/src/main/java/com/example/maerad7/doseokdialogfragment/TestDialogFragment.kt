package com.example.maerad7.doseokdialogfragment


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TestDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(activity)
        builder.setTitle("타이틀입니다")
        builder.setMessage("메세지입니다.")

        var listner = DialogListner()
        builder.setPositiveButton("positive",listner)
        builder.setNegativeButton("Negative",listner)
        builder.setNeutralButton("Neutral",listner)

        var alert = builder.create()

        return alert
        return super.onCreateDialog(savedInstanceState)
    }
    inner class DialogListner : DialogInterface.OnClickListener{
        override fun onClick(p0: DialogInterface?, p1: Int) {
            //메인액티비티의 텍스트 뷰에 디스플레이 하기 때문에
            var main_activity = activity as MainActivity
            when(p1){
                DialogInterface.BUTTON_POSITIVE -> {
                    main_activity.textView.text = "positive"
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    main_activity.textView.text = "Neutral"
                }
                DialogInterface.BUTTON_NEGATIVE->{
                    main_activity.textView.text = "Negative"
                }
            }

        }

    }

}
