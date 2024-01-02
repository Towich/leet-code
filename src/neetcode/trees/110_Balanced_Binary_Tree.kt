package neetcode.trees

import kotlin.math.abs
import kotlin.math.max

class Solution1 {

    var balanced = true

    private fun isBalancedRecursive(node: TreeNode?): Int {
        if(node == null)
            return 0

        val leftHeight = isBalancedRecursive(node.left)
        val rightHeight = isBalancedRecursive(node.right)

        if(abs(leftHeight - rightHeight) > 1){
            balanced = false
        }

        return max(leftHeight, rightHeight) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null)
            return true

        isBalancedRecursive(root)

        return balanced
    }
}


fun main(){
//    val root = TreeNode(3)
//    val node2 = TreeNode(9)
//
//    val node3 = TreeNode(20)
//    val node4 = TreeNode(15)
//    val node5 = TreeNode(7)
//
//    root.left = node2
//    root.right = node3
//
//    node3.left = node4
//    node3.right = node5
//
//    println(Solution1().isBalanced(root))

    val root = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(2)


    val node4 = TreeNode(3)
    val node5 = TreeNode(3)

    val node6 = TreeNode(4)
    val node7 = TreeNode(4)

    root.left = node2
    root.right = node3

    node2.left = node4
    node2.right = node5

    node4.left = node6
    node4.right = node7

    println(Solution1().isBalanced(root))
}