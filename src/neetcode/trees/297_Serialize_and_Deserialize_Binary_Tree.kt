package neetcode.trees

import java.util.LinkedList

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if(root == null)
            return ""

        val resultURL = StringBuilder()
        val queue = LinkedList<TreeNode?>()
        var isFirstNode = true

        queue.add(root)

        while(queue.isNotEmpty()){
            val node = queue.pop()

            if(!isFirstNode){
                resultURL.append(',')
            }
            else{
                isFirstNode = false
            }

            if(node == null){
                resultURL.append("null")
            }
            else{
                resultURL.append(node.`val`)
                queue.add(node.left)
                queue.add(node.right)
            }
        }

        var lastIndex = resultURL.length-1
        while(!resultURL[lastIndex].isDigit()){
            lastIndex -= 5
        }

        return resultURL.substring(startIndex = 0, endIndex = lastIndex+1)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if(data.isEmpty())
            return null

        val array = data.split(",").toTypedArray()
        val queue = LinkedList<TreeNode>()
        val root = TreeNode(array[0].toInt())
        queue.add(root)

        var i = 1
        while(i < array.size){
            val parent = queue.pop()
            var leftNode: TreeNode?
            var rightNode: TreeNode?

            if(array[i] != "null") {
                leftNode = TreeNode(array[i].toInt())
                queue.add(leftNode)
            }
            else
                leftNode = null

            i++

            if(i < array.size && array[i] != "null") {
                rightNode = TreeNode(array[i].toInt())
                queue.add(rightNode)
            }
            else
                rightNode = null

            i++

            parent.left = leftNode
            parent.right = rightNode
        }

        return root
    }
}

fun main(){
    val codec = Codec()
    val rootString = "3,9,20,null,null,15,7"

    val rootNode = codec.deserialize(rootString)
    println(rootNode?.`val`)

    val rootSerialized = codec.serialize(rootNode)
    println(rootSerialized)
}