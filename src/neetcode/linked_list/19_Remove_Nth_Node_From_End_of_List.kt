package neetcode.linked_list

private fun reverseLinkedList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head

    while(curr != null){
        val next: ListNode? = curr.next
        curr.next = prev

        prev = curr
        curr = next
    }

    return prev
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if(head == null){
        return null
    }

    val revHead = reverseLinkedList(head)
    if(n == 1){
        return reverseLinkedList(revHead?.next)
    }

    var currPointer = revHead
    for(counter in 1 until n-1){
        currPointer = currPointer?.next
    }

    if(currPointer == null)
        return revHead

    currPointer.next = currPointer.next?.next

    return reverseLinkedList(revHead)
}

fun main(){
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
//    head.next!!.next!!.next = ListNode(4)
//    head.next!!.next!!.next!!.next = ListNode(5)

    println(head.`val`)
    val listRemovedFromEnd = removeNthFromEnd(head, 3)

    println(listRemovedFromEnd!!.`val`)
}