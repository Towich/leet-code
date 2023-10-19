package neetcode.arrays_hashing


/*
    1) Сортировка слиянием (n*log n)
    2) Повторяем макс. n раз: (n * log n)
        2.1) Берём первый элемент
        2.2) Ищем пару выбранному элементу (BinarySearch log n --> приводит к ошибке: мы находим один и тот же элемент при двух одиннаковых значениях)
        2.3) Нашли      --> победа
             Не нашли   --> следующая итерация


    1)
 */

private fun mergeSortImpl(values: IntArray, buffer: IntArray, l: Int, r: Int) {
    if (l < r) {
        val m = (l + r) / 2
        mergeSortImpl(values, buffer, l, m)
        mergeSortImpl(values, buffer, m + 1, r)
        var k = l
        run {
            var i = l
            var j = m + 1
            while (i <= m || j <= r) {
                if (j > r || i <= m && values[i] < values[j]) {
                    buffer[k] = values[i]
                    ++i
                } else {
                    buffer[k] = values[j]
                    ++j
                }
                ++k
            }
        }
        for (i in l..r) {
            values[i] = buffer[i]
        }
    }
}
private fun mergeSort(values: IntArray) {
    if (values.isNotEmpty()) {
        val buffer = IntArray(values.size)
        mergeSortImpl(values, buffer, 0, values.size - 1)
    }
}
fun twoSum_not_working(nums: IntArray, target: Int): IntArray {
    val newNums = nums.clone()
    mergeSort(newNums)

    for(i in newNums.indices){
        val foundSecTarget = nums.binarySearch(element = target - newNums[i], fromIndex = i+1, toIndex = newNums.size)
        if(foundSecTarget >= 0){

            return intArrayOf(nums.binarySearch(newNums[i]), nums.binarySearch(newNums[foundSecTarget]))
        }
    }

    return intArrayOf(-1, -1)
}

/*
    Используем HashMap
    1) Создаем хэш-таблицу для двух элементов (значение и индекс)
    2) Проходим по всему массиву
        2.1) Вычисляем разность (target - nums[i])
        2.2) Если разность уже находится в хэш-таблице --> возвращаем (разность, i)
        2.3) Если нет --> добавляем текущее число и его индекс в хэш-таблицу
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val seenNums = mutableMapOf<Int, Int>()

    for(i in nums.indices){
        val difference = target - nums[i]

        if(difference in seenNums){
            return intArrayOf(seenNums[difference] ?: -1, i)
        }

        seenNums[nums[i]] = i
    }

    return intArrayOf(-1, -1)
}

fun main(){
    println("${twoSum(intArrayOf(2,7,11,15), target = 9)[0]} ${twoSum(intArrayOf(2,7,11,15), target = 9)[1]}")
    println("${twoSum(intArrayOf(3,2,4), target = 6)[0]} ${twoSum(intArrayOf(3,2,4), target = 6)[1]}")
    println("${twoSum(intArrayOf(3,3), target = 6)[0]} ${twoSum(intArrayOf(3,3), target = 6)[1]}")
}