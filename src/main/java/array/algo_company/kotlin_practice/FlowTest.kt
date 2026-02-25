package array.algo_company.kotlin_practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    checkFlowReduce()
    testFilterInFlow()
    testEmitAndCollect()
}

suspend fun checkFlowReduce() {
    val result = (1..5).asFlow().reduce { i, j ->
        i + j
    }
    println(result)
}

suspend fun testFilterInFlow() {
    // A list of full names
    val names = listOf("John Doe", "Jane Doe", "Peter Jones", "Bruce Wayne", "Clark Kent")
    // Convert the list to a Flow
    val namesFlow: Flow<String> = flowOf(*names.toTypedArray())
    namesFlow.collect { value ->
        println("Collected $value")
    }
    val filteredFlow = filterByFirstName(namesFlow, "Bruce")
    filteredFlow.collect {
        println("Collected Filtered Name : $it")
    }
}

fun filterByFirstName(namesFlow: Flow<String>, firstName: String): Flow<String> {
    return namesFlow.filter { fullName ->
        val parts = fullName.split(" ")
        parts.isNotEmpty() && parts[0].equals(firstName, ignoreCase = true)
    }
}

suspend fun testEmitAndCollect() {
    // 1. Define the producer (creates a cold flow with values 1 through 3)
    val myFlow = flow {
        for (i in 1..3) {
            delay(1000) // Simulate some asynchronous work
            emit(i) // Emit the value
        }
    }.map { it * it } // 2. Intermediate operator: transform to square

    // 3. Consumer: collect the values (triggers the flow execution)
    myFlow.collect { value ->
        println("Collected $value")
    }
}
