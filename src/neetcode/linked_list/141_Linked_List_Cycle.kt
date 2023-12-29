package neetcode.linked_list

fun hasCycleNonOptimized(head: ListNode?): Boolean {
    val hashMap = mutableMapOf<Int, MutableSet<ListNode>>()

    var p = head
    while(p != null){
        if(p.`val` in hashMap.keys){
            val listNodes = hashMap[p.`val`]!!

            for(node in listNodes){
                if(node === p){
                    return true
                }
            }

            hashMap[p.`val`]!!.add(p)
        }
        else{
            hashMap[p.`val`] = mutableSetOf(p)
        }

        p = p.next
    }

    return false
}

// Floyd's algorithm (slow and fast pointer)
fun hasCycle(head: ListNode?): Boolean {
    var s = head
    var f = head?.next

    while(f != null){
        s = s?.next
        f = f.next?.next

        if(s != null && s == f)
            return true
    }

    return false
}

fun main(){
//    val head = ListNode(3)
//    val node2 = ListNode(2)
//    val node3 = ListNode(0)
//    val node4 = ListNode(-4)
//
//    head.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = null
//
//    println(hasCycle(head))

    val head = ListNode(5)
    val node2 = ListNode(5)
    head.next = node2
    node2.next = null
    println(hasCycle(head))
}