import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.Map

class FirstUnique(nums: IntArray) {
  private val cnt: Map<Int, Int> = HashMap()
  private val q: Deque<Int> = ArrayDeque()

  init {
    for (v in nums) {
      cnt.put(v, (cnt[v] ?: 0) + 1)
      q.offer(v)
    }
  }

  fun showFirstUnique(): Int {
    while (!q.isEmpty() && cnt[q.peekFirst()] !== 1) {
      q.poll()
    }
    return if (q.isEmpty()) -1 else q.peekFirst()
  }

  fun add(value: Int) {
    cnt.put(value, (cnt[value] ?: 0) + 1)
    q.offer(value)
  }
}
