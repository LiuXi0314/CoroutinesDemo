package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.*

fun main() = runBlocking {

    GlobalScope.launch(Dispatchers.Default) {
        delay(1000)
        log("world!")
    }

    log("Hello,")

}


