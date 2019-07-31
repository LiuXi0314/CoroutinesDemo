package com.example.coroutines

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutines.garbage.log
import kotlinx.coroutines.*

/**
 * 协程的作用域
 */
fun main() {

    runBlocking {
        //创建CoroutineScope的常见方式
        CoroutineScope(Dispatchers.IO).launch {
            log(1)
        }

        //创建CoroutineScope的常见方式
        CoroutineScope(Dispatchers.Default).launch {
            log(2)
        }

        //GlobalScope 全局作用域
        GlobalScope.launch {
            log(3)
        }

        delay(10000)

    }

}

class CoroutineScopeActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Default) {

    private val textView by lazy { TextView(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView.layoutParams = ViewGroup.LayoutParams(-1, -1)
        setContentView(textView)

        //TEST
        doSomething()

        launch(Dispatchers.Main) {
            //切换至UI线程
            delay(1000L)
            //关闭Activity
            log("页面关闭")
            finish()
        }
    }

    private fun doSomething() {

        log("启动协程")

        repeat(10) { i ->

            launch {

                delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒等等不同的时间
                log("Coroutine $i is done.")
            }
        }
    }

    override fun finish() {
        super.finish()
        cancel()
    }
}