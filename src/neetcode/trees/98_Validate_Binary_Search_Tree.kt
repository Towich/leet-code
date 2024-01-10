package neetcode.trees

fun isValidBSTRecursive(root: TreeNode?, low: Long, high: Long): Boolean{
    return (root == null ||
            (root.`val` > low
            && root.`val` < high
            && isValidBSTRecursive(root.left, low, root.`val`.toLong())
            && isValidBSTRecursive(root.right, root.`val`.toLong(), high)))
}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

fun main(){
    val codec = Codec()
    val root1 = codec.deserialize("5,4,6,null,null,3,7")
    val root2 = codec.deserialize("5,1,4,null,null,3,6")
    val root3 = codec.deserialize("2,1,3")
    val root4 = codec.deserialize("3,1,5,0,2,4,6")
    val root5 = codec.deserialize("120,70,140,50,100,130,160,20,55,75,110,119,135,150,200")

    println(isValidBST(root1))  // false
    println(isValidBST(root2))  // false
    println(isValidBST(root3))  // true
    println(isValidBST(root4))  // true
    println(isValidBST(root5))  // false
}