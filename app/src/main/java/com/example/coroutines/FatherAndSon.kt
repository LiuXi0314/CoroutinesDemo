package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        launch {
            log("我开始执行啦")
            delay(1000)
            log("我执行完了")
        }

        delay(500)
        cancel()
        log("取消任务")

    }

}