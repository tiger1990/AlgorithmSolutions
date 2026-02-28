package array.algo_company.kotlin_practice

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    startFlowBuilders()
}

suspend fun startFlowBuilders() {
    /**
     * flowOf()
     * Creates a flow from a fixed set of values.
     * Below example prints each value after a delay of 500ms.
     */
    println("flowOf Flow")
    flowOf(4, 2, 5, 1, 7)
        .onEach { delay(500) }
        .flowOn(Dispatchers.Default)
        .collect { println(it) }

    /**
     * asFlow()
     * Extension function that converts a collection/range into a Flow.
     */
    println("asFlow Flow")
    (4..10).asFlow()
        .onEach { delay(500) }
        .flowOn(Dispatchers.Default)
        .collect { println(it) }

    testHotAndColdFlows()
}

suspend fun testHotAndColdFlows() {

    //Starts when collected
    //Each collector gets separate stream
    //Example: flow {}, channelFlow {}
    testColdFlows()

    // Emits regardless of collectors
    // Shared among collectors
    // Stays in memory
    testHotFlows()
}

/**
 * ---------------------------------------------------
 * HOT FLOWS (SharedFlow, StateFlow)
 *
 * Hot Flow:
 * - Starts emitting values immediately.
 * - Does NOT depend on collectors.
 * - All collectors receive the same emissions.
 * - Remains active in memory.
 * ---------------------------------------------------
 */
suspend fun testHotFlows() = coroutineScope {

    println("SharedFlow Example")

    /**
     * SharedFlow
     * - Used for one-time events (e.g., navigation, toast, clicks)
     * - Does NOT hold a state by default
     * - Can have multiple collectors
     */
    val sharedFlow = MutableSharedFlow<Int>()

    //Get the values that were emitted in the past (configured with a replay buffer).
//    val sharedFlow2 = MutableSharedFlow<Int>(
//        replay = 1,
//        extraBufferCapacity = 0
//    )

    // Collector 1
    launch {
        sharedFlow.collect {
            println("Collector 1: $it")
        }
    }

    // Emit values
    launch {
        (1..3).forEach {
            sharedFlow.emit(it)
            delay(500)
        }
    }

    // collector 2 will start collecting after 500ms delay so latest
    // emitted values will be collected because its hot flow ,
    // will print Collector 2: 2, Collector 2: 3
    delay(500)
    launch {
        sharedFlow.collect {
            println("Collector 2: $it")
        }
    }

    delay(2000)

    println("\nStateFlow Example")
    /**
     * StateFlow
     * - Used for holding UI state
     * - Always has an initial value
     * - Replays latest value to new collectors
     * - Similar to LiveData
     */
    val stateFlow = MutableStateFlow(0)

    // Collector
    launch {
        stateFlow.collect {
            println("StateFlow Collector: $it")
        }
    }

    delay(500)

    // Update state
    launch {
        for (i in 1..3) {
            delay(500)
            stateFlow.value = i
        }
    }
    delay(2000)
}

/**
 * Cold Flows (flow{}, channelFlow{})
 * Cold flows start producing data only when a collector is active.
 */
suspend fun testColdFlows() {
    /**
     * flow { }
     * Builder function used to construct arbitrary flows.
     * Emits values with a delay and applies a transformation using map.
     */
    println("flow{} builder function")

    flow {
        (1..5).forEach {
            delay(500)
            emit(it)
        }
    }.map { it * it }
        .flowOn(Dispatchers.Default)
        .collect { println(it) }

    /**
     * channelFlow { }
     * Creates a cold flow using a channel.
     * Values are emitted using send().
     */
    println("channelFlow{} builder function")

    val channelFlow = channelFlow {
        (0..3).forEach {
            send(it)
        }
        close()
        awaitClose { /* Optional cleanup logic
        awaitClose {} keeps the flow alive forever
         awaitClose() suspends indefinitely until the channel is closed or cancelled.
        */
            println("channel closed")
        }
    }.flowOn(Dispatchers.Default)
        .collect { println(it) }
    channelFlow
}
