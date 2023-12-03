internal class Solution(private val m: Int, private val n: Int) {
  private var total: Int
  private val rand: Random = Random()
  private val mp: Map<Int, Int> = HashMap()

  init {
    total = m * n
  }

  fun flip(): IntArray {
    val x: Int = rand.nextInt(total--)
    val idx = mp[x] ?: x
    mp.put(x, mp[total] ?: total)
    return intArrayOf(idx / n, idx % n)
  }

  fun reset() {
    total = m * n
    mp.clear()
  }
}
