package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    // 在后台启动一个新的协程
    GlobalScope.launch {

        delay(1000L) // 挂起当前协程，但并不会阻塞程序，1秒后恢复执行

        log("World!") //延迟1秒后输出

    }

    log("Hello,") // 会立即打印，协程的delay并不会阻塞程序

    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活，否则的话协程还未恢复执行，进程就退出了

}
