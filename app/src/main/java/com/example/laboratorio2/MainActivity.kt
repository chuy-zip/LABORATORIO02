package com.example.laboratorio2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    private lateinit var preResultTextView: TextView
    private lateinit var operationTextView: TextView

    private lateinit var clearButton: Button
    private lateinit var deleteButton: Button
    private lateinit var equalsButton: Button

    private lateinit var powerButton: Button
    private lateinit var moduleButton: Button
    private lateinit var divisionButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var minusButton: Button
    private lateinit var plusButton: Button


    private lateinit var nineButton: Button
    private lateinit var eightButton: Button
    private lateinit var sevenButton: Button
    private lateinit var sixButton: Button
    private lateinit var fiveButton: Button
    private lateinit var fourButton: Button
    private lateinit var threeButton: Button
    private lateinit var twoButton: Button
    private lateinit var oneButton: Button
    private lateinit var zeroButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextViews
        preResultTextView = findViewById(R.id.textViewPrevResult)
        operationTextView = findViewById(R.id.textViewOpearation)

        // Delete things
        clearButton = findViewById(R.id.buttonClearAll)
        deleteButton = findViewById(R.id.buttonDelete)

        // Operations
        equalsButton = findViewById(R.id.buttonEquals)
        powerButton = findViewById(R.id.buttonPower)
        moduleButton = findViewById(R.id.buttonModule)
        divisionButton = findViewById(R.id.buttonDivision)
        multiplyButton = findViewById(R.id.buttoMultiplication)
        minusButton = findViewById(R.id.buttonMinus)
        plusButton = findViewById(R.id.buttonPlus)

        // Numbers
        nineButton = findViewById(R.id.buttonNine)
        eightButton = findViewById(R.id.buttonEight)
        sevenButton = findViewById(R.id.buttonSeven)
        sixButton = findViewById(R.id.buttonSix)
        fiveButton = findViewById(R.id.buttonFive)
        fourButton = findViewById(R.id.buttonFour)
        threeButton = findViewById(R.id.buttonThree)
        twoButton = findViewById(R.id.buttonTwo)
        oneButton = findViewById(R.id.buttonOne)
        zeroButton = findViewById(R.id.buttonZero)

        clearButton.setOnClickListener {
            operationTextView.text = "0"
        }

        deleteButton.setOnClickListener {
            var inputString: String = operationTextView.text.toString()

            if (inputString != "0" && inputString.isNotEmpty()) {
                inputString = inputString.substring(0, inputString.length - 1)
                operationTextView.text = inputString
            }

            if (inputString.isEmpty()) {
                operationTextView.text = "0"
            }
        }

        // Numbers Listeners

        nineButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "9"
                else -> operationTextView.text = operationTextView.text.toString() + "9"
            }
        }
    }
}