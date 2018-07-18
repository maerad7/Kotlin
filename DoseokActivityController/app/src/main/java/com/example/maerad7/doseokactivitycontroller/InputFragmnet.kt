package com.example.maerad7.doseokactivitycontroller


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InputFragmnet : Fragment() {
    var button: Button? = null
    var edit:EditText? = null
    var edit2:EditText? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_input_fragmnet, container, false)
        button = view.findViewById(R.id.button)
        edit = view.findViewById(R.id.editText)
        edit2 = view.findViewById(R.id.editText2)

        button?.setOnClickListener {
            //자기자신을 관리하는 액티비티 주소값을 가져온다.
            var main_activity = activity as MainActivity

            main_activity.value1 = edit?.text.toString()
            main_activity.value2 = edit2?.text.toString()
            main_activity.setFragment("result")

        }
        // Inflate the layout for this fragment
        return view
    }


}
