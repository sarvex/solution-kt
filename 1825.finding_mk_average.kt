import java.util.*
import kotlin.collections.ArrayDeque

class MKAverage(private val m: Int, private val k: Int) {
  private var s: Long = 0
  private var size1 = 0
  private var size3 = 0
  private val q: Deque<Int> = ArrayDeque()
  private val lo: TreeMap<Int, Int> = TreeMap()
  private val mid: TreeMap<Int, Int> = TreeMap()
  private val hi: TreeMap<Int, Int> = TreeMap()
  fun addElement(num: Int) {
    if (lo.isEmpty() || num <= lo.lastKey()) {
      lo.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      ++size1
    } else if (hi.isEmpty() || num >= hi.firstKey()) {
      hi.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      ++size3
    } else {
      mid.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += num.toLong()
    }
    q.offer(num)
    if (q.size() > m) {
      val x = q.poll()
      if (lo.containsKey(x)) {
        if (lo.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          lo.remove(x)
        }
        --size1
      } else if (hi.containsKey(x)) {
        if (hi.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          hi.remove(x)
        }
        --size3
      } else {
        if (mid.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          mid.remove(x)
        }
        s -= x.toLong()
      }
    }
    while (size1 > k) {
      val x: Int = lo.lastKey()
      if (lo.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        lo.remove(x)
      }
      mid.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += x.toLong()
      --size1
    }
    while (size3 > k) {
      val x: Int = hi.firstKey()
      if (hi.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        hi.remove(x)
      }
      mid.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += x.toLong()
      --size3
    }
    while (size1 < k && !mid.isEmpty()) {
      val x: Int = mid.firstKey()
      if (mid.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        mid.remove(x)
      }
      s -= x.toLong()
      lo.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      ++size1
    }
    while (size3 < k && !mid.isEmpty()) {
      val x: Int = mid.lastKey()
      if (mid.merge(x, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        mid.remove(x)
      }
      s -= x.toLong()
      hi.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      ++size3
    }
  }

  fun calculateMKAverage(): Int {
    return if (q.size() < m) -1 else (s / (q.size() - k * 2)) as Int
  }
}
