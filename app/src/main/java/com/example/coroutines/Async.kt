package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val deferred = async {
        delay(1000)
        "world!"
    }

    log("Hello,")
    log(deferred.await())

}