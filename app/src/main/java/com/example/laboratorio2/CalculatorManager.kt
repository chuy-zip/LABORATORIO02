package com.example.laboratorio2

import java.util.ArrayDeque

class CalculatorManager {
    //determines if the cahracter read is an operator, if not then sends false
    fun isOperator(char: Char): Boolean {
        return char == '+' || char == '-' || char == '*' || char == '/' || char == '^'
    }
    //assigns precedence to the opeerators
    fun precedence(operator: Char): Int {
        return when (operator) {
            '+', '-' -> 1
            '*', '/' -> 2
            '^' -> 3
            else -> 0
        }
    }

    //procees that changes the list in order infix to order postfix
    fun infixToPostfix(infixList: List<String>): List<String> {

        val postfixList = mutableListOf<String>() // list to insert the expression en order postfix
        val operatorStack = ArrayDeque<Char>() // list for the opreators of the expression
        for (element in infixList) {
            if (element.length == 1 && isOperator(element[0])) { //verifies if is an operator
                while (operatorStack.isNotEmpty() && precedence(operatorStack.peek()) >= precedence(element[0])) { //pushes operator basen on precedence
                    postfixList.add(operatorStack.pop().toString())
                }
                operatorStack.push(element[0]) //inserts it into the list for operators
            } else if (element == "(") { //verifies if is an paarentesiss
                operatorStack.push('(')
            } else if (element == ")") {
                while (operatorStack.isNotEmpty() && operatorStack.peek() != '(') { //verifies that the closing parentesis has an open one
                    postfixList.add(operatorStack.pop().toString())
                }
                operatorStack.pop() // Pop the "("
            } else {
                postfixList.add(element)  // adds the numbers
            }
        }

        while (operatorStack.isNotEmpty()) {
            postfixList.add(operatorStack.pop().toString()) // empties the list for operators and insert thems into the postfix list expresion
        }

        return postfixList
    }

    fun tokenizeExpression(operationExpression: List<String>): List<String> {
        var number: String = ""
        var tokenizedList: ArrayList<String> = ArrayList()

        for (letter in operationExpression){
            if(letter.toDoubleOrNull() == null){
                // If the the variable number has something stored in it, the number will be
                // added to the list first
                if(!number.equals("")){
                    tokenizedList.add(number)
                }
                number = ""
                tokenizedList.add(letter)
            }
            else{
                number += letter
            }
        }

        return tokenizedList.toList()
    }

    fun calculate(completeOperation: List<String>): Int {
        return 5
    }


}