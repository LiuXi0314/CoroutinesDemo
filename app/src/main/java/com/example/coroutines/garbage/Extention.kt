package com.example.coroutines.garbage

/**
 * 输出msg + 当前线程信息
 */
inline fun log(msg: Any?) {
    println("$msg  [thread name]: ${Thread.currentThread().name}")
}