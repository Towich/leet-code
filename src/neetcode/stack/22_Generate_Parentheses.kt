package neetcode.stack

fun generateParenthesisRecursive(
    n: Int,
    openBrackets: Int,
    closeBrackets: Int,
    str: String,
    totalList: MutableList<String>
){
    if(n - openBrackets > 0)
        generateParenthesisRecursive(n, openBrackets+1, closeBrackets, "$str(", totalList)

    if(closeBrackets < openBrackets)
        generateParenthesisRecursive(n, openBrackets, closeBrackets+1, "$str)", totalList)

    if(openBrackets == closeBrackets && openBrackets == n) {
        totalList.add(str)
        return
    }
}

fun generateParenthesis(n: Int): List<String> {
    val totalList = mutableListOf<String>()

    generateParenthesisRecursive(n, 0, 0, "", totalList)

    return totalList
}

fun main(){
    println(generateParenthesis(1))
    println(generateParenthesis(2))
    println(generateParenthesis(3))
    println(generateParenthesis(4))
}