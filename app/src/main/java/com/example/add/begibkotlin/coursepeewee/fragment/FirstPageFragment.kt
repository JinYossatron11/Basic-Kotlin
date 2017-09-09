package com.example.add.begibkotlin.coursepeewee.fragment


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.telephony.PhoneNumberFormattingTextWatcher
import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.R.*
import com.example.add.begibkotlin.coursepeewee.activity.FirstPageActivity
import com.example.add.begibkotlin.coursepeewee.toText


class FirstPageFragment : Fragment(){

    @BindView(R.id.edt_Username)lateinit var edtUsername: EditText
    @BindView(R.id.edt_Password)lateinit var edtPassword: EditText
    @BindView(R.id.btn_Submit)lateinit var btnSubmit: Button
    @BindView(R.id.bg)lateinit var vImageBackground : ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(layout.fragment_first_page, container, false)
        ButterKnife.bind(this,view)
        Glide.with(this).load(drawable.shoot).crossFade().into(vImageBackground)
        loginCheck()
        return view
    }

    fun getMainActivity(): FirstPageActivity { return activity as FirstPageActivity }
    fun loginCheck() {

        btnSubmit.setOnClickListener {
            if (edtUsername.length() == 10 && edtPassword.length() == 6){
                nextPage()
            }else {
                Toast.makeText(context, "เกิดข้อผิดพลาด", Toast.LENGTH_LONG).show()
            }
        }
    }
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

