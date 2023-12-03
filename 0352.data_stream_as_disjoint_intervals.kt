internal class SummaryRanges {
  private val mp: TreeMap<Int, IntArray>

  init {
    mp = TreeMap()
  }

  fun addNum(`val`: Int) {
    val l: Int = mp.floorKey(`val`)
    val r: Int = mp.ceilingKey(`val`)
    if (l != null && r != null && mp.get(l).get(1) + 1 === `val` && mp.get(r).get(0) - 1 === `val`) {
      mp.get(l).get(1) = mp.get(r).get(1)
      mp.remove(r)
    } else if (l != null && `val` <= mp.get(l).get(1) + 1) {
      mp.get(l).get(1) = Math.max(`val`, mp.get(l).get(1))
    } else if (r != null && `val` >= mp.get(r).get(0) - 1) {
      mp.get(r).get(0) = Math.min(`val`, mp.get(r).get(0))
    } else {
      mp.put(`val`, intArrayOf(`val`, `val`))
    }
  }

  val intervals: Array<IntArray>
    get() {
      val res = Array(mp.size()) { IntArray(2) }
      var i = 0
      for (range in mp.values()) {
        res[i++] = range
      }
      return res
    }
}
