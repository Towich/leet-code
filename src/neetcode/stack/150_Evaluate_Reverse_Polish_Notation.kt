package neetcode.stack

import java.util.*

fun evalRPN(tokens: Array<String>): Int {

    val stack = Stack<Int>()

    for(token in tokens){
        when(token){
            "+" -> {
                val secondNum = stack.pop()
                val firstNum = stack.pop()
                stack.push(firstNum + secondNum)
            }
            "-" -> {
                val secondNum = stack.pop()
                val firstNum = stack.pop()
                stack.push(firstNum - secondNum)
            }
            "*" -> {
                val secondNum = stack.pop()
                val firstNum = stack.pop()
                stack.push(firstNum * secondNum)
            }
            "/" -> {
                val secondNum = stack.pop()
                val firstNum = stack.pop()
                stack.push(firstNum / secondNum)
            }
            else -> {
                stack.push(token.toInt())
            }
        }
    }

    return stack.pop()
}

fun main(){
    println(evalRPN(arrayOf("2","1","+","3","*")))  // 9
    println(evalRPN(arrayOf("4","13","5","/","+"))) // 6
    println(evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))  // 22
}