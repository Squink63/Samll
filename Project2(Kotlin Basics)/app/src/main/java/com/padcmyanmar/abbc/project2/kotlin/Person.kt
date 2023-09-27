package com.padcmyanmar.abbc.project2.kotlin

class Person(val name : String){

    constructor():this(name="")


//    var name : String="Aung Aung"
//    set(value) {
//        if (value.isNotEmpty()){
//            field = value
//        }
//    }


    //null safety
    companion object{

        val email : String?=null

        fun getPersonInfo(){

            if (email != null){
               //null safe
            }

            email?.let {
                //null safe
            }

            val data = email?:""
        }

    }
}

open class Preson2(name : String){

   open fun eat(){}

    fun sleep(){}

    fun work(){}

}