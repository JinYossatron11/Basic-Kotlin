package com.example.add.begibkotlin.coursepeewee


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.add.begibkotlin.R

class Main2Fragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main2, container, false)

        Toast.makeText(context, "$getUsername $getPassword", Toast.LENGTH_LONG).show()

        return view

    }

    val getUsername  get() = arguments.getString(EXTRA_USERNAME)
    val getPassword  get() = arguments.getString(EXTRA_PASSWORD)


    companion object {
        val EXTRA_USERNAME = "EXTRA_USERNAME"
        val EXTRA_PASSWORD = "EXTRA_PASSWORD"

        fun newInstance(username: String, password: String): Main2Fragment {
            val bundle = Bundle()
            val fragment = Main2Fragment()

            bundle.putString(EXTRA_USERNAME, username)
            bundle.putString(EXTRA_PASSWORD,password)

            fragment.arguments = bundle
            return fragment
        }
    }
}
