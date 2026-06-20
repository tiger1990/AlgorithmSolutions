package array.algo_company.leetcode.google

import kotlin.math.abs

fun main() {

    val array = intArrayOf(0,1,2)
    val output = threeSumClosest(array, target = 3)
    println(output)
}

fun threeSumClosest(nums: IntArray, target: Int): Int {

   nums.sort()

    var closest = nums[0] + nums[1] + nums[2]

    for (i in 0 until nums.size - 2) {

        var left = i + 1
        var right = nums.lastIndex

        while (left < right) {

            val currentSum = nums[i] + nums[left] + nums[right]

            if(abs(currentSum - target) < abs(closest - target)){
                closest = currentSum
            }

            if(currentSum < target) {
                left++
            }else if(currentSum > target) {
                right--
            }else
                return currentSum
        }
    }
    return closest
}