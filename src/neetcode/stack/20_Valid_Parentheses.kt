package neetcode.stack

import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    for(char: Char in s){
        if(!stack.empty()){
            val neededClosingBracket = when(stack.peek()){
                '(' -> ')'
                '[' -> ']'
                '{' -> '}'
                else -> '0'
            }

            if(char == neededClosingBracket){
                stack.pop()
            }
            else{
                stack.push(char)
            }
        }
        else{
            stack.push(char)
        }
    }

    return stack.empty()
}

fun main(){
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("{[]}"))
    println(isValid("{[]()}"))
}