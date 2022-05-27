package com.example.android.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val myName = MyName("Bruno M")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.userName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View?) {
        binding.apply {
            myName.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = GONE
            doneButton.visibility = GONE
            nicknameText.visibility = VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}