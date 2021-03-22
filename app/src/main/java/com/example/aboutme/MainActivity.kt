package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val MyName : MyName = MyName("Dionisio")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = MyName
        binding.button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
            binding.apply {
                invalidateAll()
                myName?.nickName = nicknameEdit.text.toString()
                nicknameEdit.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
                button.visibility = View.GONE
            }
           view.visibility = View.GONE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}