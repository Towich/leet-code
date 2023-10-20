package neetcode.stack

import java.util.*

class MinStack() {

    private val stack: Stack<Node> = Stack()

    fun push(`val`: Int) {
        if(stack.empty()){
            stack.push(Node(`val`, `val`))
        }
        else{
            val pickedNode = stack.peek()
            if(`val` < pickedNode.min){
                stack.push(Node(`val`, `val`))
            }
            else{
                stack.push(Node(`val`, pickedNode.min))
            }
        }
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().min
    }

}

data class Node(val value: Int, val min: Int)

fun main(){
    val obj = MinStack()
    obj.push(-2)
    obj.push(3)
    var param_2 = obj.top() // equals 3
    println(param_2)
    obj.push(2)
    obj.push(1)
    obj.pop()
    var param_3 = obj.top() // equals 2
    println(param_3)
    var param_4 = obj.getMin()  // equals -2
    println(param_4)
}