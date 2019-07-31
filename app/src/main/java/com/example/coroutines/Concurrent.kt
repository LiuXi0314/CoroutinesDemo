package com.example.coroutines

import com.example.coroutines.garbage.log
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

/**
 * 并发操作
 * 线程安全的数据结构
 * 以细粒度限制线程
 * 以粗粒度限制线程
 */

var totalCount = AtomicInteger()

fun main() {

    runBlocking {
        withContext(Dispatchers.Default) {
            calculate {
                totalCount.incrementAndGet()
            }
        }
        log("最终结果：$totalCount")
    }
}

suspend fun calculate(action: suspend () -> Unit) {

    val n = 1_000_000 //启动协程的数量

    val m = 1_00 //每个协程重复执行计算的次数

    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(m) { action.invoke() }
                }
            }
        }
    }
    log("执行任务花费了$time 毫秒")
}