internal class Solution {
  fun averageHeightOfBuildings(buildings: Array<IntArray>): Array<IntArray> {
    val height: TreeMap<Int, Int> = TreeMap()
    val cnt: TreeMap<Int, Int> = TreeMap()
    for (v in buildings) {
      val s = v[0]
      val e = v[1]
      val h = v[2]
      cnt.put(s, cnt.getOrDefault(s, 0) + 1)
      cnt.put(e, cnt.getOrDefault(e, 0) - 1)
      height.put(s, height.getOrDefault(s, 0) + h)
      height.put(e, height.getOrDefault(e, 0) - h)
    }
    var i = 0
    var h = 0
    var n = 0
    val res: List<IntArray> = ArrayList()
    for (j in cnt.keySet()) {
      if (n > 0) {
        val t = intArrayOf(i, j, h / n)
        val k: Int = res.size() - 1
        if (k >= 0 && res[k][1] === i && res[k][2] === t[2]) {
          res[k][1] = j
        } else {
          res.add(t)
        }
      }
      h += height.get(j)
      n += cnt.get(j)
      i = j
    }
    val ans = Array(res.size()) { IntArray(3) }
    i = 0
    while (i < ans.size) {
      ans[i] = res[i]
      ++i
    }
    return ans
  }
}
