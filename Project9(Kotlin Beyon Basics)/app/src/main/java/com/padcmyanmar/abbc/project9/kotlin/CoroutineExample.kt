package com.padcmyanmar.abbc.project9.kotlin

import kotlinx.coroutines.*

//fun main() {
//
//    GlobalScope.launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    Thread.sleep(4000L)
//
//}

//fun main() {
//
//    GlobalScope.launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    runBlocking {
//        delay(5000L)
//
//        println("over.")
//
//    }
//}

//fun doJob() = runBlocking {
//
//    GlobalScope.launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    delay(3000L)
//    println("over.")
//}
//
//fun main() {
//    doJob()
//}

//suspend function

//fun main() = runBlocking {
//    GlobalScope.launch {
//        doWorld()
//    }
//    println("Hello,")
//    delay(3000L)
//}
//
//suspend fun doWorld() {
//    delay(1000L)
//    println("World!")
//}

// join
//fun main() = runBlocking {
//    val job = GlobalScope.launch {
//        delay(3000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join()
//
//    print("over.")
//}

// coroutineScope
fun main() = runBlocking {

    launch {
        delay(2000L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(1000L)
            println("Task from nested launch")
        }

        println("Task from coroutineScope")
    }

    println("Coroutine Scope is over")
}