package neetcode.linked_list

class LRUNode(
    var key: Int,
    var timestamp: Int = 1,
    var next: LRUNode? = null,
    var prev: LRUNode? = null
)

class LRUCache(capacity: Int) {
    private val hashMap = mutableMapOf<Int, Int>()
    private var priorityQueue: LRUNode? = null
    private var freeSpace = capacity
    private var lruTimestamp = 1

    fun get(key: Int): Int {
        if (key in hashMap) {
            var p = priorityQueue
            while (p != null) {
                if (p.key == key) {
                    p.timestamp = lruTimestamp++
                    break
                }

                p = p.next
            }

            return hashMap[key]!!
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (priorityQueue == null) {
            priorityQueue = LRUNode(key = key, timestamp = lruTimestamp++)
            hashMap[key] = value
            freeSpace--
            return
        }

        if (key !in hashMap) {
            if (freeSpace <= 0) {
                val keyToRemove = findMinPriorityKey()
                hashMap.remove(keyToRemove)
                removeFromQueue(keyToRemove)
            }

            var p = priorityQueue
            while (p?.next != null) {
                p = p.next
            }

            if(priorityQueue != null) {
                p?.next = LRUNode(key = key, timestamp = lruTimestamp++, prev = p)
            }
            else{
                priorityQueue = LRUNode(key = key, timestamp = lruTimestamp++)
            }
            freeSpace--
        }
        else{
            var p = priorityQueue
            while (p?.key != key) {
                p = p?.next
            }

            p.timestamp = lruTimestamp++
        }
        hashMap[key] = value
    }

    private fun findMinPriorityKey(): Int {
        var p = priorityQueue
        var minLRUNode = p

        while (p != null) {
            if (p.timestamp < minLRUNode!!.timestamp) {
                minLRUNode = p
            }
            p = p.next
        }

        return minLRUNode?.key ?: -1
    }

    private fun removeFromQueue(key: Int) {
        var p = priorityQueue
        if(p?.key == key){
            p.next?.prev = null
            priorityQueue = p.next
            return
        }

        while (p != null) {
            if (p.key == key) {
                p.prev?.next = p.next
                p.next?.prev = p.prev
                break
            }

            p = p.next
        }
    }
}

fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    val get1 = lruCache.get(1)
    lruCache.put(3, 3)
    val get2 = lruCache.get(2)
    lruCache.put(4, 4)
    val get3 = lruCache.get(1)
    val get4 = lruCache.get(3)
    val get5 = lruCache.get(4)

//    val lru = LRUCache(2)
//    lru.put(2,1)
//    lru.put(1,1)
//    lru.put(2,3)
//    lru.put(4,1)
//    val get1 = lru.get(1)   // -1
//    val get2 = lru.get(2)   // 3

//    val lru = LRUCache(1)
//    val get6 = lru.get(6)
//    val get8 = lru.get(8)
//    lru.put(12, 1)
//    val get2 = lru.get(2)
//    lru.put(15,11)
//    lru.put(5,2)
//    lru.put(1,15)
//    lru.put(4,2)
//    val get5 = lru.get(5)
//    lru.put(15,15)
}