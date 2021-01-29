package com.example.kotlin_footballer_handbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ContentActivity : AppCompatActivity() {
    var tvTitle: TextView? = null
    var tvContent: TextView? = null
    var im: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle = findViewById(R.id.tvTitleContentLayout)
        tvContent = findViewById(R.id.tvContentContentLayout)
        im = findViewById(R.id.imContentLayout)
        tvTitle?.text = intent.getStringExtra("title")
        tvContent?.text = intent.getStringExtra("content")
        im?.setImageResource(intent.getIntExtra("image", 0))


    }
}