package com.example.laboratorio2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var openParenthesisButton: Button
    private lateinit var closeParenthesisButton: Button

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
        var calculator = CalculatorManager()

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
        openParenthesisButton = findViewById(R.id.buttonOpenParenthesis)
        closeParenthesisButton = findViewById(R.id.buttonCloseParenthesis)

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

        eightButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "8"
                else -> operationTextView.text = operationTextView.text.toString() + "8"
            }
        }

        sevenButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "7"
                else -> operationTextView.text = operationTextView.text.toString() + "7"
            }
        }

        sixButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "6"
                else -> operationTextView.text = operationTextView.text.toString() + "6"
            }
        }

        fiveButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "5"
                else -> operationTextView.text = operationTextView.text.toString() + "5"
            }
        }

        fourButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "4"
                else -> operationTextView.text = operationTextView.text.toString() + "4"
            }
        }

        threeButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "3"
                else -> operationTextView.text = operationTextView.text.toString() + "3"
            }
        }

        twoButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "2"
                else -> operationTextView.text = operationTextView.text.toString() + "2"
            }
        }

        oneButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "1"
                else -> operationTextView.text = operationTextView.text.toString() + "1"
            }
        }

        zeroButton.setOnClickListener {
            when (operationTextView.text) {
                "0" -> operationTextView.text = "0"
                else -> operationTextView.text = operationTextView.text.toString() + "0"
            }
        }

        // Sign Listeners
        equalsButton.setOnClickListener {

        }

        powerButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "^"
        }

        moduleButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "%"
        }

        divisionButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "/"
        }

        multiplyButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "*"
        }

        minusButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "-"
        }

        plusButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "+"
        }

        openParenthesisButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + "("
        }

        closeParenthesisButton.setOnClickListener {
            operationTextView.text = operationTextView.text.toString() + ")"
        }

        equalsButton.setOnClickListener {
            try {
                // We take the content of the TextView and store in a string
                var infixExpression: String = operationTextView.text.toString()

                //The string is turned into a list
                var operationExpression: List<String> = infixExpression.split("")

                // The list is tokenized so the list know has the numbers and signs grouped correctly
                var completeOperation = calculator.tokenizeExpression(operationExpression)

                // The operation is turned into a postfix expression
                completeOperation = calculator.infixToPostfix(completeOperation)

                var result: Int = calculator.calculate(completeOperation)

                calculator.tokenizeExpression(operationExpression)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error, look for syntax error", Toast.LENGTH_SHORT).show();

            }

        }

    }
}