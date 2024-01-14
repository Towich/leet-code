package neetcode.trees

class Solution3 {
    var i: Int = 0
    var answer: Int = -1

    private fun kthSmallestRecursive(root: TreeNode?, k: Int){
        if(root == null)
            return

        kthSmallest(root.left, k)

        if(++i == k)
            answer = root.`val`

        kthSmallest(root.right, k)
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        kthSmallestRecursive(root, k)
        return answer
    }
}


fun main(){
    val s = Solution3()
    val codec = Codec()

    val root = codec.deserialize("3,1,4,null,2")
    println(s.kthSmallest(root, 2))

    val root2 = codec.deserialize("5,3,6,2,4,null,null,1")
    println(s.kthSmallest(root2, 3))
}