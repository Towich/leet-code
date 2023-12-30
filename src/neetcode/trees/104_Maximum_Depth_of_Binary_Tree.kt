package neetcode.trees

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    if(root == null)
        return 0

    return max(maxDepth(root.left), maxDepth(root.right)) + 1
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

    println(maxDepth(root))
}