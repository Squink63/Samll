package com.padcmyanmar.abbc.project3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//        btn_hello.setOnClickListener {
//            val name = edtName.text.toString()
//            Toast.makeText(this, "Hello, $name", Toast.LENGTH_LONG).show()
//        }

        val helloImages = intArrayOf(
            R.drawable.hello1,
            R.drawable.hello2,
            R.drawable.hello3,
            R.drawable.hello4,
            R.drawable.hello5
        )

        btn_hello.setOnClickListener {
            val randomSeed = Random
            val randomIndex = randomSeed.nextInt(helloImages.size)

            imageview.setImageResource(helloImages[randomIndex])
        }

        btnCheckFruit.setOnClickListener {
            var selectedFruit = ""
            if (checkbox1.isChecked){
                selectedFruit = getString(R.string.cb_1)
            }
            if (checkbox2.isChecked){
                selectedFruit += getString(R.string.cb_2)
            }
            if (checkbox3.isChecked){
                selectedFruit += getString(R.string.cb_3)
            }

            val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle(getString(R.string.fruit_alert_dialog_title))
            alertDialog.setMessage("Your Selected Fruits , $selectedFruit")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Ok",
            DialogInterface.OnClickListener { dialog : DialogInterface, which ->dialog.dismiss()  })
            alertDialog.show()
        }

        radioBtnMale.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this,getString(R.string.rb_male), Toast.LENGTH_LONG).show()
            }
        }
        radioBtnFemale.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this,getString(R.string.rb_female), Toast.LENGTH_LONG).show()
            }
        }

        // Toggle Button
        tb_guest_room_light.setOnCheckedChangeListener { compoundButton, isChecked ->
            when{
                isChecked -> {
                    Toast.makeText(this,getString(R.string.text_light_on), Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this,getString(R.string.text_light_off), Toast.LENGTH_LONG).show()
                }
            }
        }

        // Switch
        swtDoorLock.setOnCheckedChangeListener { compoundButton, isChecked ->
            when{
                isChecked -> {
                    Toast.makeText(this,"The door is locked.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this,"The door is opened", Toast.LENGTH_LONG).show()
                }
            }
        }

        // SeekBar
        sbBrightness.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        //RatingBar
        rbStar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

        }

        //autoCompleteTextView
        val additionalDrinksAdapter : ArrayAdapter<Any?> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.additional_drinks)
        )

        actvDrinks.setAdapter(additionalDrinksAdapter)

        //Date Picker
        btn_select_date.setOnClickListener {
            val calender = Calendar.getInstance()
            val day  = calender[Calendar.DAY_OF_MONTH]
            val month = calender[Calendar.MONTH]
            val year = calender[Calendar.YEAR]


            //date picker dialog
            val picker = DatePickerDialog(this, {
                    view, year,monthOfYear,dayOfmonth ->
                tv_selected_date.text =
                    ("$dayOfmonth/${monthOfYear + 1}/$year")
            }, year,month,day)
            picker.show()

        }

        //Timepicker
        btn_select_time.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minutes = calendar[Calendar.MINUTE]

            //time picker dialog
            val picker = TimePickerDialog(this,{
                tp ,sHour ,sMinute ->
                tv_selected_time.text = ("$sHour:$sMinute")
            },hour,minutes,true)
            picker.show()
        }
    }




}