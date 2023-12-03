import java.util.*
import kotlin.collections.ArrayDeque

internal class BoundedBlockingQueue(capacity: Int) {
  private val s1: Semaphore
  private val s2: Semaphore
  private val q: Deque<Int> = ArrayDeque()

  init {
    s1 = Semaphore(capacity)
    s2 = Semaphore(0)
  }

  @Throws(InterruptedException::class)
  fun enqueue(element: Int) {
    s1.acquire()
    q.offer(element)
    s2.release()
  }

  @Throws(InterruptedException::class)
  fun dequeue(): Int {
    s2.acquire()
    val ans = q.poll()
    s1.release()
    return ans
  }

  fun size(): Int {
    return q.size()
  }
}
