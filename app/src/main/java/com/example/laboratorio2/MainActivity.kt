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

    private val originalSize = 70
    private var actualSize = originalSize
    private val minSize = 50
    private val maxCharacters = 26

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
                setOriginalSize()
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
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "9"
                    else -> operationTextView.text = operationTextView.text.toString() + "9"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            eightButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "8"
                    else -> operationTextView.text = operationTextView.text.toString() + "8"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            sevenButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "7"
                    else -> operationTextView.text = operationTextView.text.toString() + "7"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            sixButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "6"
                    else -> operationTextView.text = operationTextView.text.toString() + "6"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            fiveButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "5"
                    else -> operationTextView.text = operationTextView.text.toString() + "5"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            fourButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "4"
                    else -> operationTextView.text = operationTextView.text.toString() + "4"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            threeButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "3"
                    else -> operationTextView.text = operationTextView.text.toString() + "3"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            twoButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "2"
                    else -> operationTextView.text = operationTextView.text.toString() + "2"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            oneButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "1"
                    else -> operationTextView.text = operationTextView.text.toString() + "1"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            zeroButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "0"
                    else -> operationTextView.text = operationTextView.text.toString() + "0"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            // Sign Listeners
            equalsButton.setOnClickListener {

            }

            powerButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "^"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            moduleButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "%"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            divisionButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "/"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            multiplyButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "*"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            minusButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "-"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            plusButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                operationTextView.text = operationTextView.text.toString() + "+"

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            openParenthesisButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = "("
                    else -> operationTextView.text = operationTextView.text.toString() + "("
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }

            closeParenthesisButton.setOnClickListener {
                if (operationTextView.text.length < maxCharacters) {
                reSizeOperation()
                when (operationTextView.text) {
                    "0" -> operationTextView.text = ")"
                    else -> operationTextView.text = operationTextView.text.toString() + ")"
                }

                } else {
                    Toast.makeText(this, "Número máximo de caracteres alcanzado.", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun reSizeOperation() {
        if (operationTextView.text.length >= 9 && operationTextView.textSize > minSize) {
            actualSize -= 5
            operationTextView.textSize = actualSize.toFloat()
        }

        equalsButton.setOnClickListener {
            try {
                // We take the content of the TextView and store in a string
                var infixExpression: String = operationTextView.text.toString()

                //The string is turned into a list
                var operationExpression: List<String> = infixExpression.split("")

                // The list is tokenized so the list know has the numbers and signs grouped correctly
                operationExpression = calculator.tokenizeExpression(operationExpression)

                // The operation is turned into a postfix expression
                operationExpression = calculator.infixToPostfix(operationExpression)
                println(operationExpression)

                var result = calculator.calculate(operationExpression)

                operationTextView.setText(result)
                preResultTextView.setText(result)

            } catch (e: Exception) {
                Toast.makeText(this, "Syntax error", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private fun setOriginalSize() {
        operationTextView.textSize = originalSize.toFloat()
        actualSize = originalSize
    }
}