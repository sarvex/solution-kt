internal class Solution(n: Int, blacklist: IntArray) {
  private val d: Map<Int, Int> = HashMap()
  private val rand: Random = Random()
  private val k: Int

  init {
    k = n - blacklist.size
    var i = k
    val black: Set<Int> = HashSet()
    for (b in blacklist) {
      black.add(b)
    }
    for (b in blacklist) {
      if (b < k) {
        while (black.contains(i)) {
          ++i
        }
        d.put(b, i++)
      }
    }
  }

  fun pick(): Int {
    val x: Int = rand.nextInt(k)
    return d[x] ?: x
  }
}
