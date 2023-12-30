package neetcode.trees

import kotlin.math.max

class Solution {
    private var diameter = 0

    private fun diameterOfBinaryTreeRecursive(root: TreeNode?): Int {
        if(root == null)
            return 0

        val leftHeight = diameterOfBinaryTreeRecursive(root.left)
        val rightHeight = diameterOfBinaryTreeRecursive(root.right)
        diameter = max(diameter, leftHeight+rightHeight)

        return max(leftHeight, rightHeight) + 1
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null)
            return 0

        diameterOfBinaryTreeRecursive(root)

        return diameter
    }
}

fun main(){
    val root = TreeNode(4)

    val node1 = TreeNode(2)
    val node2 = TreeNode(7)
    root.left = node1
    root.right = node2

    val node3 = TreeNode(1)
    val node4 = TreeNode(3)
    node1.left = node3
    node1.right = node4

    val node5 = TreeNode(6)
    val node6 = TreeNode(9)

    node2.left = node5
    node2.right = node6

    println(Solution().diameterOfBinaryTree(root))
}
