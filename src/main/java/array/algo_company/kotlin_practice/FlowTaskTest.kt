package array.algo_company.kotlin_practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun main() = runBlocking {
    startTask()
}

suspend fun startTask() {
    var currentDelay = 1000L
    val delayFactor = 2
    doLongRunningTask()
        .flowOn(Dispatchers.Default)
        .retry(retries = 3) { cause ->
            if (cause is IOException) {
                delay(currentDelay)
                currentDelay = (currentDelay * delayFactor)
                return@retry true
            } else {
                return@retry false
            }
        }.catch {
            println("Something Went Wrong")
        }.collect {
            println("Task Completed")
        }
}

private fun doLongRunningTask(): Flow<Int> {
    return flow {
        // Added delay, random number, and exception to simulate
        delay(2000)

        val randomNumber = (0..2).random()
        if (randomNumber == 0) {
            throw IOException()
        } else if (randomNumber == 1) {
            throw IndexOutOfBoundsException()
        }
        delay(2000)
        emit(0)
    }
}