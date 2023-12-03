class Allocator(n: Int) {
  private val tm: TreeMap<Int, Int> = TreeMap()
  private val d: Map<Int, List<Int>> = HashMap()

  init {
    tm.put(-1, -1)
    tm.put(n, n)
  }

  fun allocate(size: Int, mID: Int): Int {
    var s = -1
    for (entry in tm.entrySet()) {
      val v: Int = entry.getKey()
      if (s != -1) {
        val e = v - 1
        if (e - s + 1 >= size) {
          tm.put(s, s + size - 1)
          d.computeIfAbsent(mID) { k -> ArrayList() }.add(s)
          return s
        }
      }
      s = entry.getValue() + 1
    }
    return -1
  }

  fun free(mID: Int): Int {
    var ans = 0
    for (s in d[mID] ?: Collections.emptyList()) {
      val e: Int = tm.remove(s)
      ans += e - s + 1
    }
    d.remove(mID)
    return ans
  }
}
