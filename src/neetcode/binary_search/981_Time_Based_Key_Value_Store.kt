package neetcode.binary_search

class TimeMap() {

    private val timeHashMap = mutableMapOf<String, ArrayList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val newPairValue = Pair(value, timestamp)
        if(timeHashMap[key] == null){
            timeHashMap[key] = arrayListOf(newPairValue)
        }
        else{
            timeHashMap[key]?.add(newPairValue)
        }
    }

    fun get(key: String, timestamp: Int): String {
        val totalList = timeHashMap[key] ?: listOf()

        var left = 0
        var right = totalList.size-1

        while(left+1 < right){
            val middle = (right+left)/2

            if(timestamp < totalList[middle].second){
                right = middle
            }
            else if(timestamp > totalList[middle].second){
                left = middle+1
            }
            else if(timestamp == totalList[middle].second){
                return totalList[middle].first
            }
        }

        if(totalList.isNotEmpty()){
            if(timestamp >= totalList[right].second){
                return totalList[right].first
            }
            else if(timestamp >= totalList[left].second){
                return totalList[left].first
            }
            else{
                return ""
            }
        }
        else
            return ""

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 *
 * ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 */

fun main(){
    val timeMap = TimeMap()
    timeMap.set("foo", "bar", 1)
    println(timeMap.get("foo", 1))         // return "bar"
    println(timeMap.get("foo", 3))         // return "bar"
    timeMap.set("foo", "bar2", 4);
    println(timeMap.get("foo", 4))         // return "bar2"
    println(timeMap.get("foo", 5))         // return "bar2"

    println("---")

    val timeMap2 = TimeMap()
    timeMap2.set("love", "high", 10)
    timeMap2.set("love", "low", 20)
    println(timeMap2.get("love", 5))
    println(timeMap2.get("love", 10))
    println(timeMap2.get("love", 15))
    println(timeMap2.get("love", 20))
    println(timeMap2.get("love", 25))
}