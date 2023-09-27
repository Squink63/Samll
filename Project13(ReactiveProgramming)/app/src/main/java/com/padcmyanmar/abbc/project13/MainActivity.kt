package com.padcmyanmar.abbc.project13


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Just
        Observable.just(getNumbersFromOneToTen())
            .subscribe {
                Log.d("just", it.toString())
            }

        //Iterable
        Observable.fromIterable(getNumbersFromOneToTen())
            .subscribe {
                Log.d("iterable", it.toString())
            }

        //Callable
        Observable.fromCallable { getNumbersFromOneToTen() }
            .subscribe {
                Log.d("callable", it.toString())
            }

        //RxKotlin
        getNumbersFromOneToTen().toObservable()
            .subscribe {
                Log.d("toObservable", it.toString())
            }

        //Filtering Operators
        //Filter
        getNumbersFromOneToTen().toObservable()
            .filter{ it % 2 == 0}
            .subscribe {
                Log.d("filter", it.toString())
            }


        //Skip
        getNumbersFromOneToTen().toObservable()
            .skip(4)
            .subscribe{
                Log.d("skip", it.toString())
            }

        //Take
        getNumbersFromOneToTen().toObservable()
            .take(4)
            .subscribe {
                Log.d("take", it.toString())
            }

        //Distinct Until Changed
        getDuplicateNumberWithOneToTen().toObservable()
            .distinctUntilChanged()
            .subscribe {
                Log.d("distinctUntilChanged",it.toString())
            }

        //Transforming Operators
        //Map
        getNumbersFromOneToTen().toObservable()
            .map { it * 2 }
            .subscribe {
                Log.d("map", it.toString())
            }

        //Any
        getNumbersFromOneToTen().toObservable()
            .any { it == 5 }
            .toObservable()
            .subscribe {
                Log.d("any", it.toString() )
            }

        //Reduce
        getNumbersFromOneToTen().toObservable()
            .reduce {first, second -> first + second}
            .subscribe {
                Log.d("reduce", it.toString())
            }


        //Combining Operators
        //CombineLatest
        Observable.combineLatest(
            listOf(
                getNumbersFromOneToTen().toObservable(),
                getHundreds().toObservable()
            )
        ) {
            it.map { it.toString() }.joinToString ( "," )
        }.subscribe {
            Log.d("combineLatest", it.toString())
        }

        //Zip
        Observable.zip(
            listOf(
                getNumbersFromOneToTen().toObservable(),
                getHundreds().toObservable()
            )
        ) {
            it.map { it.toString() }.joinToString(",")
        }.subscribe {
            Log.d("zip", it.toString())
        }


    }

    private fun getNumbersFromOneToTen(): List<Int> {
        return (1..10).toList()
    }

    private fun getHundreds(): List<Int> {
        return arrayListOf(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000)
    }

    private fun getDuplicateNumberWithOneToTen(): List<Int>{
        return arrayListOf(1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9, 10)
    }
}