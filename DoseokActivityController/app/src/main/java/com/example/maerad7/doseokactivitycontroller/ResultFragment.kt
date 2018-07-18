package com.example.maerad7.doseokactivitycontroller


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ResultFragment : Fragment() {

    var button2:Button? = null
    var textView:TextView? =null
    var textView2 : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_result, container, false)
        button2 = view.findViewById(R.id.button2)
        textView = view.findViewById(R.id.textView)
        textView2 = view.findViewById(R.id.textView2)
        var main_activity = activity as MainActivity
        textView?.text = main_activity.value1
        textView2?.text = main_activity.value2

        //이전으로 돌아가기
        button2?.setOnClickListener {view ->
            main_activity.supportFragmentManager.popBackStack()
        }
        return view
    }


}
