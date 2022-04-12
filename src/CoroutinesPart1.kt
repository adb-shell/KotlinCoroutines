import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    GlobalScope.launch {
        delay(1000)
        print("world")
    }
    print("Hello")

    //hold the thread until the world is printed.
    runBlocking {
        delay(3000)
    }
}