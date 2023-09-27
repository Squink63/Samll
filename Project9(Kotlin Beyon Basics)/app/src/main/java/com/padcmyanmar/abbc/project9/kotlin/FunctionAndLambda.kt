package com.padcmyanmar.abbc.project9.kotlin

val numberList = listOf(1,2,3,4,5)
var calculate: (num1: Int, num2: Int, operator: Char)-> Int = {num1, num2, operator -> 0
    
}

fun numberListCalculator(numList: List<Int>, operator: Char, calculate: (Int,Int,Char)-> Int) : Int {

    var initialValue = 0

    for (number in numList) {
       initialValue = calculate(initialValue,number,operator)
    }

    return initialValue
}

fun main () {

////    val result  = numberListCalculator(
////        numberList,
////        operator = '+',
////        calculate = {num1,num2,operator ->
////
////        when(operator) {
////            '+' -> num1 + num2
////            '-' -> num1 - num2
////            '*' -> num1 * num2
////            '/' -> num1 / num2
////
////            else -> 0
////        }
////
////    })
//
//    println("Result is $result")

    val result  = numberListCalculator(
        numberList,
        operator = '+')
            {num1,num2,operator ->

                when(operator) {
                    '+' -> num1 + num2
                    '-' -> num1 - num2
                    '*' -> num1 * num2
                    '/' -> num1 / num2

                    else -> 0
                }

            }

    println("Result is $result")

    "bb".let {go ->
        println(go)
    }

//    calculate = {num1, num2, operator ->
//        when(operator) {
//            '+' -> num1 + num2
//            '-' -> num1 - num2
//            '*' -> num1 * num2
//            '/' -> num1 / num2
//
//            else -> 0
//        }
//    }
//    val result  = numberListCalculator(numberList, operator = '+', calculate = calculate)
//
//    println("Result is $result")
}