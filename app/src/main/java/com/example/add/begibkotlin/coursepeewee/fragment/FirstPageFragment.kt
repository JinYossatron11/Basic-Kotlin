package com.example.add.begibkotlin.coursepeewee.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import butterknife.BindView
import butterknife.OnClick
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.activity.FirstPageActivity
import com.example.add.begibkotlin.coursepeewee.toText


class FirstPageFragment : Fragment() {

    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSubmit: Button
    lateinit var vImageBackground : ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_first_page, container, false)
        edtUsername = view.findViewById(R.id.edt_Username)
        edtPassword = view.findViewById(R.id.edt_Password)
        btnSubmit = view.findViewById(R.id.btn_Submit)
        vImageBackground = view.findViewById(R.id.bg)
        vImageBackground.setBackgroundResource(R.drawable.shoot)

        return view
    }

    fun getMainActivity(): FirstPageActivity {
        return activity as FirstPageActivity
    }

    @OnClick(R.id.btn_Submit) fun onClickLogin() {
        val username = edtUsername.toText()
        val password = edtPassword.toText()

        getMainActivity().changeFragment(Main2Fragment.newInstance(username, password))
    }

    companion object {
        fun newInstance(): FirstPageFragment {
            val bundle = Bundle()
            val fragment = FirstPageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}

