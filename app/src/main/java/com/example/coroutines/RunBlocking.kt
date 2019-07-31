package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * runBlocking开启主协程
 */
fun main() = runBlocking {

    /**
     * 开启子协程
     */
    val job = GlobalScope.launch {

        delay(1000) // 挂起当前协程，但并不会阻塞程序，1秒后恢复执行
        log("World！")

    }

    log("Hello,")
}

