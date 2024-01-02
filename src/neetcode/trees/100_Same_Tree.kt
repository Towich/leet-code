package neetcode.trees

class Solution2 {

    private var isSame = true

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        isSameTreeRecursive(p, q)
        return isSame
    }

    private fun isSameTreeRecursive(p: TreeNode?, q: TreeNode?){
        if(p == null && q == null){
            return
        }
        else if(p == null || q == null){
            isSame = false
            return
        }

        if(p.`val` != q.`val`) {
            isSame = false
            return
        }

        isSameTreeRecursive(p.left, q.left)
        isSameTreeRecursive(p.right, q.right)
    }
}


fun main() {
//    val node1 = TreeNode(1)
//    val node2 = TreeNode(2)
//    val node3 = TreeNode(3)
//
//    node1.left = node2
//    node1.right = node3
//
//    val node11 = TreeNode(1)
//    val node22 = TreeNode(2)
//    val node33 = TreeNode(3)
//
//    node11.left = node22
//    node11.right = node33
//
//    println(Solution2().isSameTree(node1, node11))

    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(2)


    val node4 = TreeNode(3)
    val node5 = TreeNode(3)

    val node6 = TreeNode(4)
    val node7 = TreeNode(4)

    node1.left = node2
    node1.right = node3

    node2.left = node4
    node2.right = node5

    node4.left = node6
    node4.right = node7

    val node11 = TreeNode(1)
    val node22 = TreeNode(2)
    val node33 = TreeNode(2)


    val node44 = TreeNode(3)
    val node55 = TreeNode(3)

    val node66 = TreeNode(4)
    val node77 = TreeNode(4)

    node11.left = node22
    node11.right = node33

    node22.left = node44
    node22.right = node55

    node44.left = node66
    node44.right = node77

    println(Solution2().isSameTree(node1, node11))
}