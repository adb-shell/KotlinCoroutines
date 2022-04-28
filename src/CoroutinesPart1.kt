import kotlinx.coroutines.*

fun main(){

    GlobalScope.launch(CoroutineName("Global 1")) {
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

    //printing from different dispatchers
    GlobalScope.launch(context = Dispatchers.Default) {
        delay(1000)
        println("Printing from the default thread")
        println(this.coroutineContext.toString())
        withContext(Dispatchers.IO){
            println("Printing from the IO thread")
            println(this.coroutineContext.toString())
        }
        withContext(Dispatchers.Unconfined){
            println("Printing from the Unconfined thread")
            println(this.coroutineContext.toString())
        }
    }

    //Job in coroutine
    


    //hold the thread until the world is printed.
    runBlocking {
        delay(10000)
    }
}