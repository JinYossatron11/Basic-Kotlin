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
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.activity.FirstPageActivity
import com.example.add.begibkotlin.coursepeewee.toText


class FirstPageFragment : Fragment() {

    @BindView(R.id.edt_Username)lateinit var edtUsername: EditText
    @BindView(R.id.edt_Password)lateinit var edtPassword: EditText
    @BindView(R.id.btn_Submit)lateinit var btnSubmit: Button
    @BindView(R.id.bg)lateinit var vImageBackground : ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_first_page, container, false)
        ButterKnife.bind(this,view)
        Glide.with(this).load(R.drawable.shoot).crossFade().into(vImageBackground)
        return view
    }

    fun getMainActivity(): FirstPageActivity { return activity as FirstPageActivity }

    fun nextPage() {
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

