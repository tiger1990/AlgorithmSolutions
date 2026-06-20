package array.algo_company.leetcode.google


fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val output = optimizeTwoSum(nums, target)
    output.forEach {
        println(it)
    }
}

fun optimizeTwoSum(nums: IntArray, target: Int): IntArray {

    val map = mutableMapOf<Int, Int>()
    var pair: Pair<Int, Int>? = null

    for (index in nums.indices) {

        val compliment = target - nums[index]
        if (map.contains(compliment)) {
            pair = Pair(map.getValue(compliment), index)
        }else{
            map.putIfAbsent(nums[index], index)
        }
    }
    return pair?.let { intArrayOf(it.first, it.second)
    } ?: intArrayOf(-1,-1)
}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = mutableMapOf<Int, Int>()
    val list = arrayListOf<Int>()

    for (index in nums.indices) {

        val compliment = target - nums[index]
        if (map.contains(compliment)) {
            list.add(map.getValue(compliment))
            list.add(index)
        }else{
            map.putIfAbsent(nums[index], index)
        }
    }
    return list.toIntArray()
}
