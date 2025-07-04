package com.example.fregment

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        // Get the message from arguments
        val message = arguments?.getString("message_key")
        // Set it to the TextView
        val textView = view.findViewById<TextView>(R.id.fraga)
        textView.text = message

        return view
    }

    companion object {


        fun newInstance(message: String): FragmentA {
            val fragment = FragmentA()
            val args = Bundle()
            args.putString("message_key", message)
           fragment.arguments = args
            return fragment
        }
    }
}