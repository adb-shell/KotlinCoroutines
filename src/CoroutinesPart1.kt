import kotlinx.coroutines.*

fun main(){
    GlobalScope.launch {
        delay(1000)
        print("world")

        val async1 = async {
            delay(1000)
           return@async "World2"
        }
        val async2 = async {
            delay(1000)
            return@async "World3"
        }
        println()
        //will wait until each of the async operation is returned.
        println(async1.await())
        println(async2.await())
    }
    print("Hello")

    //hold the thread until the world is printed.
    runBlocking {
        delay(10000)
    }
}