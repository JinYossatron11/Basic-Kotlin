package com.example.add.begibkotlin.coursepeewee.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.activity.MainActivity
import com.example.add.begibkotlin.coursepeewee.toText


class MainFragment : Fragment() {

    @BindView(R.id.edt_Username)lateinit var edtUsername : EditText
    @BindView(R.id.edt_Password)lateinit var edtPassword : EditText
    @BindView(R.id.tv) lateinit var tvText : TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater!!.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    fun getMainActivity(): MainActivity {
        return activity as MainActivity
    }

    @OnClick(R.id.btn_Submit) fun onClickLogin() {
            val username = edtUsername.toText()
            val password = edtPassword.toText()

            getMainActivity().replaceFragment(Main2Fragment.newInstance(username, password))

    }

    companion object {
        fun newInstance(): MainFragment {
            val bundle = Bundle()
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }



}
