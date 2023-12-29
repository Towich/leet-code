package neetcode.linked_list

private fun isFirstListNodeLarger(l1: ListNode?, l2: ListNode?): Boolean{
    var c1 = l1
    var c2 = l2
    var c1Count = 0
    var c2Count = 0

    while(c1 != null){
        c1Count++
        c1 = c1.next
    }

    while(c2 != null){
        c2Count++
        c2 = c2.next
    }

    return c1Count >= c2Count
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    var isAddOne = false

    val isFirstLarger: Boolean = isFirstListNodeLarger(l1, l2)

    while(p1 != null || p2 != null){
        var sum: Int

        if(p1 == null){
            sum = p2!!.`val`
        }
        else if(p2 == null){
            sum = p1.`val`
        }
        else{
            sum = p1.`val` + p2.`val`
        }

        if(isAddOne) {
            sum++
            isAddOne = false
        }

        if(sum > 9)
            isAddOne = true

        if(isFirstLarger){
            p1?.`val` = sum % 10
        }
        else{
            p2?.`val` = sum % 10
        }

        if(p1?.next == null && p2?.next == null && isAddOne){
            if(isFirstLarger){
                p1?.next = ListNode(1)
            }
            else{
                p2?.next = ListNode(1)
            }
            break
        }

        p1 = p1?.next
        p2 = p2?.next


    }

    return if(isFirstLarger) l1 else l2
}

fun main(){
    val node1 = ListNode(5)
//    val node2 = ListNode(4)
//    val node3 = ListNode(3)

//    node3.next = null
//    node2.next = node3
    node1.next = null

    val node4 = ListNode(5)
    val node5 = ListNode(6)
    val node6 = ListNode(4)

    node6.next = null
    node5.next = node6
    node4.next = node5

    addTwoNumbers(node1, node4)
}