package neetcode.linked_list

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head

    while(curr != null){
        val next = curr.next
        curr.next = prev

        prev = curr
        curr = next
    }

    return prev
}

fun main(){
    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    node4.next = node5
    node3.next = node4
    node2.next = node3
    head.next = node2

    var currNode: ListNode? = reverseList(head)
    while(currNode != null){
        println("${currNode.`val`} ")
        currNode = currNode.next
    }
}