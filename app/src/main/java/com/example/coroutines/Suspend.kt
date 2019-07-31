package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    val totalTimes = measureTimeMillis {

        val name = requestName()

        val age = requestAge()

        log("Name: $name   Age: $age")

    }

    log(totalTimes)
}

suspend fun requestName(): String {
    delay(2000)//模拟网络请求
    return "阿丽塔"
}

suspend fun requestAge(): String {
    delay(2000)
    return "300"
}


