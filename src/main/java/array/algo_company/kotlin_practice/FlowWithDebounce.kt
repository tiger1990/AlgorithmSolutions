package array.algo_company.kotlin_practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun holdUpto64() {

    // Emitter producing more  value than collector
    // accumulate value in buffer upto 64 by default and wait on collector if exceeded
    val numbers = flow {
        repeat(100) {
            emit(it)
            println("Numbers Emitted: $it")
        }
    }.flowOn(Dispatchers.IO)
    // flowOn operator configured to run on different coroutine

    runBlocking(Dispatchers.Default) {
        numbers.collect {
            delay(5.seconds)
            println("Current Number: $it")
        }
    }
}

fun chainEmitterCollector() {
    // emitter and collector put on Dispatcher.Default
    // it create a buffer of 5 , values emitted upto 5 and comer start consuming,
    // with every consumption emitter also keep on buffer fill
    runBlocking(Dispatchers.Default) {
        flow {
            repeat(100) {
                emit(it)
                println("Numbers Emitted: $it")
            }
        }.buffer(5).collect { // buffer split our flow 1st part on another coroutine, and 2nd on another
            delay(5.seconds)
            println("Current Number: $it")
        }
    }
}

fun chainEmitterCollectorWithOperatorFusion() {
    // emitter and collector put on Dispatcher.Default
    // it create a buffer of 5 , values emitted upto 5 and comer start consuming,
    // with every consumption emitter also keep on buffer fill
    runBlocking(Dispatchers.Default) {
        flow {
            repeat(100) {
                emit(it)
                println("Numbers Emitted: $it")
            }
        }.buffer(5) // tells to launch both emitter and collector on different coroutine
            .flowOn(Dispatchers.IO)  //but this behaves as fusion here,still 2 coroutine for both emitter and collector
            .collect { // buffer split our flow 1st part on another coroutine, and 2nd on another
                delay(5.seconds)
                println("Current Number: $it")
            }
    }
}

// emitter keeps on emitting but collector always gets latest value
fun emitterCollectorWithConflate() {
    runBlocking(Dispatchers.Default) {
        flow {
            repeat(100) {
                emit(it)
                println("Numbers Emitted: $it")
            }
        }.conflate()
            .collect {
                delay(5.seconds)
                println("Current Number: $it")
            }
        // first value print 0 and for next iteration delay for 5sec and only latest value gets collected
    }
}

@OptIn(FlowPreview::class)
fun main() {

    //holdUpto64()

    //chainEmitterCollector()

    // emitterCollectorWithConflate()

    debounceForSearchControlWithAutoSuggest()
}

fun uncontrolledServiceCallsInCollectorForEveryKey() {
    val searchWord = "L-Polo T-shirt"

    val searchProducts = flow {
        searchWord.indices.forEach {
            val typed = searchWord.take(it + 1)
            delay(100.milliseconds)
            println("SEARCH FOR: $typed")
            emit(typed)
        }
    }

    runBlocking {
        searchProducts.collect {
            launch(Dispatchers.Default) {
                println("Searching For $it")
                val result = Service.search(it)
                println("Found result: ${result.size} and result for $it")
            }
        }
    }
}

fun debounceForSearchControlWithAutoSuggest() {

    val search = "Polo T-shirt"

    val searchValue = flow {
        search.indices.forEach {
            val typed = search.take(it + 1)
            delay(100.milliseconds)
            println("SEARCH FOR: $typed")
            emit(typed)
        }
    }

    // emitter can send the value with their pace but collector won`t get it until emitter is quiet for 300 millis.
    runBlocking {
        searchValue.debounce(300.milliseconds).collect {
            println(it)
            val result = Service.search(it)

            println("Found result: ${result.size} and result for $it")
            result.forEach { it -> println(it.name)}
        }
    }
}

data class Product(val name: String, val price: String)

object Service {
    private var callCounter = 0

    suspend fun search(key: String): List<Product> {
        println("Service is called ${++callCounter} times.")
        delay(300.milliseconds)
        val response = productList.filter { it.name.contains(key, ignoreCase = true) }
        return response
    }

    private val productList = listOf(
        Product("Levis Shirt", "$250"),
        Product("US-Polo T-Shirt", "$350"),
        Product("Denim Shirt", "$150"),
        Product("Woodland Jacket", "$350"),
        Product("T-Levis Shirt", "$250"),
        Product("T-US-Polo T-Shirt", "$350"),
        Product("T-Denim Shirt", "$150"),
        Product("T-Woodland Jacket", "$350")
    )
}
