package com.padcmyanmar.abbc.project2.kotlin

lateinit var value3 : String

fun main(){
    print("Hello Kotlin")

    val value ="Read only"
//    value ="Write"

    var value2 = "Read and Write"
    value2 = "Assign"

    value3 = "Assign me"
    print(value3)

    Person.getPersonInfo()
    val person = Person()
    val person2 = Person(name = "Aung Aung")
//    person.name = ""


}