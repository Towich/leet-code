


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        return 0
    }

}

fun main(){
    println("Hello, World!")

    var root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(0)

    root.left!!.left = TreeNode(7)
    root.left!!.right = TreeNode(-8)


}