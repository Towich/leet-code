package neetcode.linked_list


fun mergeTwoLists_iterate(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null)
        return list2
    else if(list2 == null)
        return list1

    var p1 = list1
    var p2 = list2
    var currNode: ListNode?

    if(p1.`val` <= p2.`val`){
        currNode = ListNode(p1.`val`)
        p1 = p1.next
    }
    else{
        currNode = ListNode(p2.`val`)
        p2 = p2.next
    }

    val head: ListNode = currNode

    while(p1 != null || p2 != null){
        if(p1 == null){
            currNode!!.next = ListNode(p2!!.`val`)
            p2 = p2.next
        }
        else if(p2 == null){
            currNode!!.next = ListNode(p1.`val`)
            p1 = p1.next
        }
        else{
            if(p1.`val` <= p2.`val`){
                currNode!!.next = ListNode(p1.`val`)
                p1 = p1.next
            }
            else{
                currNode!!.next = ListNode(p2.`val`)
                p2 = p2.next
            }
        }

        currNode = currNode.next
    }


    return head
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null && list2 == null){ return null }
    else if(list1 == null) { return list2 }
    else if(list2 == null) { return list1 }

    if(list1.`val` <= list2.`val`){
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    }
    else{
        list2.next = mergeTwoLists(list1, list2.next)
        return list2
    }
}

fun main(){
    val node1 = ListNode(1)
    node1.next = ListNode(2)
    node1.next!!.next = ListNode(4)

    val node2 = ListNode(1)
    node2.next = ListNode(3)
    node2.next!!.next = ListNode(4)

    val result = mergeTwoLists(node1, node2)

    println(result.toString())
}