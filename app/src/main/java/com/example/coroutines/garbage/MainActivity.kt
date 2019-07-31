package com.example.coroutines.garbage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutines.CoroutineScopeActivity
import com.example.coroutines.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scopeTest.setOnClickListener { startActivity(Intent(this, CoroutineScopeActivity::class.java)) }

        //测试withContext()
//        withContextTest()
    }


    private fun withContextTest() {
        log(1)

        GlobalScope.launch(Dispatchers.IO) {

            log(2)

            withContext(Dispatchers.Main) {
                //切换至主线程
                delay(1000)
                log(3)

            }

            log(4)
        }
    }

}
