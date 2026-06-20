package array.algo_company.leetcode.google

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6)
    println(calculateSum(arr, 10))


    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
}

fun calculateSum(arr: IntArray, multiplier: Int): Int {
    //avoid creating an intermediate list, use a sequence:
    return arr.asSequence()
        .filter { it % 2 == 0 }
        .sumOf { it * multiplier }
}

/**
find all unique combinations in candidates where the candidate numbers sum to target
[10,1,2,7,6,1,5] target // target = 8
 */

fun findCombinationListPair(
    startIndex: Int, candidates: IntArray,
    remainingTarget: Int, currentPairs: MutableList<Int>,
    result: ArrayList<List<Int>>
) {
    // Success: We found a combination that perfectly hits the target
    if(remainingTarget == 0){
        result.add(ArrayList(currentPairs))
        return
    }
    for(i in startIndex until candidates.size){

        // Skip Duplicates: If this number is the same as the previous one in this loop, skip it
        if(i > startIndex && candidates[i] == candidates[i-1]) continue

        // Stop Early: If the current number is bigger than what we need,
        // all numbers after it will also be too big (because the array is sorted).
        if(candidates[i] > remainingTarget){
            break
        }

        // Try this number: Add it to our current guess
        currentPairs.add(candidates[i])

        // Move to the next number (i + 1) with our new reduced target
        findCombinationListPair(
            startIndex = i + 1,
            candidates,
            remainingTarget - candidates[i],
            currentPairs,
            result
        )
        // Undo: Remove the number we just tried so we can test other options
        currentPairs.removeAt(currentPairs.size - 1)
    }
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    candidates.sort()

    findCombinationListPair(
        startIndex = 0,
        candidates,
        target,
        mutableListOf<Int>(),
        result
    )
    return result
}

