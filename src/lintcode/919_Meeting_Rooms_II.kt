package lintcode

data class Interval(var start: Int, var end: Int)

fun minMeetingRooms(intervals: List<Interval?>): Int {

    val intervalsSorted = intervals.sortedBy { it?.start }
    val rooms = mutableListOf(0)

    for(interval in intervalsSorted){
        var minRoomValue = rooms[0]
        var minRoomIndex = 0

        for(i in rooms.indices){
            if(rooms[i] < minRoomValue){
                minRoomValue = rooms[i]
                minRoomIndex = i
            }
        }

        if(interval?.start!! >= minRoomValue){
             rooms[minRoomIndex] = interval.end
        }
        else{
            rooms.add(interval.end)
        }
    }

    return rooms.size
}

fun main(){
    val intervals1 = listOf(Interval(0,30), Interval(5,10), Interval(15,20))
    val intervals2 = listOf(Interval(2,7))
    val intervals3 = listOf(Interval(7,10), Interval(2,4))
    val intervals4 = listOf(Interval(25,30),Interval(25,30),Interval(0,30), Interval(5,10), Interval(15,20))


    println(minMeetingRooms(intervals1))    // 2
    println(minMeetingRooms(intervals2))    // 1
    println(minMeetingRooms(intervals3))    // 1
    println(minMeetingRooms(intervals4))    // 3

}