package array.algo_company.kotlin_practice.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import java.io.IOException

fun main() = runBlocking {

    supervisorScope {
        val user = async { getUser() }
        val balance = async { getBalance() }

        val userResult = runCatching { user.await() }
        val balanceResult = runCatching { balance.await() }

        println(userResult)
        println(balanceResult)
    }

    //Since a = getUser already failed earlier, the parent coroutine is already cancelled.
    //So b.await() throws CancellationException immediately.
    //launch -> crashes immediately
    //async -> crashes on await
    //SupervisorJob -> isolates failures
    coroutineScope {
        val a = async { getUser() }
        val b = async { getBalance() }

        val userResult = b.await() + a.await()
        println(userResult)
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