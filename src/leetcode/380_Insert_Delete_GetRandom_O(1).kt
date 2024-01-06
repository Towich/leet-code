package leetcode

import kotlin.random.Random

private class RandomizedSet {

    val mapValue: MutableMap<Int, Int> = mutableMapOf()
    val mapIndex: MutableMap<Int, Int> = mutableMapOf()
    var lastElemIndex = -1

    fun insert(`val`: Int): Boolean {
        val isInMap = mapValue.getOrDefault(`val`, -1) != -1

        if(!isInMap){
            mapValue[`val`] = ++lastElemIndex
            mapIndex[lastElemIndex] = `val`
        }

        return !isInMap
    }

    fun remove(`val`: Int): Boolean {
        val isInMap = mapValue.getOrDefault(`val`, -1) != -1

        if(isInMap) {
            val indexToRemove = mapValue[`val`]!!

            mapValue[mapIndex[lastElemIndex]!!] = indexToRemove

            val tmp = mapIndex[indexToRemove]!!
            mapIndex[indexToRemove] = mapIndex[lastElemIndex]!!
            mapIndex[lastElemIndex] = tmp



            mapIndex.remove(lastElemIndex)
            mapValue.remove(`val`)
            lastElemIndex--
        }

        return isInMap
    }

    fun getRandom(): Int {
        val randInd = Random.nextInt(0, lastElemIndex+1)
        return mapIndex[randInd]!!
    }
}

fun main(){
    val randomizedSet = RandomizedSet()
    val bool1 = randomizedSet.insert(1) // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    val bool2 = randomizedSet.remove(2) // Returns false as 2 does not exist in the set.
    val bool3 = randomizedSet.insert(2) // Inserts 2 to the set, returns true. Set now contains [1,2].
    val randomInt1 = randomizedSet.getRandom() // getRandom() should return either 1 or 2 randomly.
    val randomInt11 = randomizedSet.getRandom() // getRandom() should return either 1 or 2 randomly.
    val randomInt111 = randomizedSet.getRandom() // getRandom() should return either 1 or 2 randomly.
    val randomInt1111 = randomizedSet.getRandom() // getRandom() should return either 1 or 2 randomly.
    val randomInt11111 = randomizedSet.getRandom() // getRandom() should return either 1 or 2 randomly.
    val bool4 = randomizedSet.remove(1) // Removes 1 from the set, returns true. Set now contains [2].
    val bool5 = randomizedSet.insert(2) // 2 was already in the set, so return false.
    val randomInt2 = randomizedSet.getRandom() // Since 2 is the only number in the set, getRandom() will always return 2.
}