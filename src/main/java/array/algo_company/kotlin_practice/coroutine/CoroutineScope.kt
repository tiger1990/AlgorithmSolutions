package array.algo_company.kotlin_practice.coroutine

import array.algo_company.kotlin_practice.startFlowBuilders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import java.io.IOException

fun main() = runBlocking {

    testEarlyExit()
    testSupervisorJob()
}

suspend fun testSupervisorJob() {
    //Since a = getUser already failed earlier, the parent coroutine is already cancelled.
    //So b.await() throws CancellationException immediately.
    //launch -> crashes immediately
    //async -> crashes on await
    //SupervisorJob -> isolates failures
    supervisorScope {
        val user = async { getUser() }
        val balance = async { getBalance() }

        val userResult = runCatching { user.await() }
        val balanceResult = runCatching { balance.await() }

        println(userResult)
        println(balanceResult)
    }

    coroutineScope {
        val a = async { getUser() }
        val b = async { getBalance() }

        val userResult = b.await() + a.await()
        println(userResult)
    }
}

suspend fun testEarlyExit() {
    val backgroundScope = CoroutineScope(SupervisorJob())
    coroutineScope {
        backgroundScope.launch {
            val job1 = launch {
                delay(2000)
                println("C")
                delay(1000)
            }
            println("B")
            job1.join()
            println("A")
            delay(2000)
        }
        //main finishes its delay(2000).
        // Since main has no other active children (it doesn't "own" backgroundScope),
        // the program may terminate here before the rest of the code runs.
        // o/p is  -> B, C
        delay(2000)
    }
}

suspend fun getUser(): Int {
    delay(100)
    throw IOException("API1 failed")
}

suspend fun getBalance(): Int {
    delay(200)
    return 10
}