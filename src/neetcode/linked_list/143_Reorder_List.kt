package neetcode.linked_list

fun reorderList(head: ListNode?) {
    if(head?.next == null){
        return
    }

    var s = head
    var f = head.next

    while(f?.next != null){
        s = s?.next
        f = f.next?.next
    }

    val secondHalf = reverseList(s?.next)
    s?.next = null

    var p1 = head
    var p2 = secondHalf
    while(p1 != null && p2 != null){
        val p1Next = p1.next
        val p2Next = p2.next

        p1.next = p2
        p2.next = p1Next

        p1 = p1Next
        p2 = p2Next
    }
}

private fun reverseList(head: ListNode?): ListNode? {
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

    reorderList(head)
}