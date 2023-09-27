package com.padcmyanmar.abbc.project9.kotlin

fun main() {
        calculate(40,2,{first,second -> (first + second) * 3})
            .toInt()
            .mbyFive()
            .dbyThree()
            .toString()
            .formatResult()
            .printOutput()
}

fun calculate(
    firstNum: Int,secondNum: Int,calculation: (Int,Int) -> Int) : String{
    return calculation(firstNum,secondNum).toString()

}

fun Int.mbyFive() = this * 5
fun Int.dbyThree() = this / 3

fun String.formatResult() = "This result is ${this}"
fun String.printOutput() = println(this)
