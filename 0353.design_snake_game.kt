import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.Set

internal class SnakeGame(private val n: Int, private val m: Int, private val food: Array<IntArray>) {
  private var score = 0
  private var idx = 0
  private val q: Deque<Int> = ArrayDeque()
  private val vis: Set<Int> = HashSet()

  init {
    q.offer(0)
    vis.add(0)
  }

  fun move(direction: String): Int {
    val p = q.peekFirst()
    val i = p / n
    val j = p % n
    var x = i
    var y = j
    if ("U" == direction) {
      --x
    } else if ("D" == direction) {
      ++x
    } else if ("L" == direction) {
      --y
    } else {
      ++y
    }
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return -1
    }
    if (idx < food.size && x == food[idx][0] && y == food[idx][1]) {
      ++score
      ++idx
    } else {
      val t = q.pollLast()
      vis.remove(t)
    }
    val cur = f(x, y)
    if (vis.contains(cur)) {
      return -1
    }
    q.offerFirst(cur)
    vis.add(cur)
    return score
  }

  private fun f(i: Int, j: Int): Int {
    return i * n + j
  }
}
