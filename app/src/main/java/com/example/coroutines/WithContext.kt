package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.*

fun main() {

    runBlocking {
        log(1)
        launch(Dispatchers.IO) {
            log(2)
            withContext(Dispatchers.Unconfined) {
                delay(1000)
                log(3)
            }
            log(4)
        }
    }

}