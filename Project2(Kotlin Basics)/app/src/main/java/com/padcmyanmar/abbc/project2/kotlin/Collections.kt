package com.padcmyanmar.abbc.project2.kotlin

val mylist = listOf(1,2,3)
val myMutableList = mutableListOf<Int>(1,2,3)

val myMap = mapOf<Int,String>(1 to "a",2 to "b",3 to "c")
val myMutableMap = mutableMapOf<String,String>("a" to "apple","b" to "banana")

val mySet = setOf<Int>()
val myMutableSet = mutableSetOf<String>("a","a","b")

fun main() {
    myMutableList.add(4)
    myMutableMap["c"] = "coconut"
    myMutableMap.put("c","cow")
}

