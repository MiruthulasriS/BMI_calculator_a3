package com.example.bmi_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEditText: EditText = findViewById(R.id.weightET)
        val heightEditText: EditText = findViewById(R.id.heightET)
        val calculateButton: Button = findViewById(R.id.calculatebtn)
        val resultTextView: TextView = findViewById(R.id.resultTV)
        val unitRadioGroup: RadioGroup = findViewById(R.id.unitRadioGroup)
        val meterRadioButton: RadioButton = findViewById(R.id.meterRadioButton)

        calculateButton.setOnClickListener {
            val weightText = weightEditText.text.toString()
            val heightText = heightEditText.text.toString()
            val isMeter = meterRadioButton.isChecked

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
                val weight = weightText.toDouble()
                var height = heightText.toDouble()

                // Convert height to meters if it's in centimeters
                if (!isMeter) {
                    height /= 100.0
                }

                val bmi = weight / height.pow(2)
                resultTextView.text = "Your BMI: %.2f".format(bmi)
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
        }
    }
}
