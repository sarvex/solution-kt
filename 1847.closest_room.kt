class Solution {
  fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val n = rooms.size
    val k = queries.size
    Arrays.sort(rooms) { a, b -> a.get(1) - b.get(1) }
    val idx = arrayOfNulls<Int>(k)
    for (i in 0 until k) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> queries[i][1] - queries[j][1] }
    var i = 0
    val tm: TreeMap<Int, Int> = TreeMap()
    for (room in rooms) {
      tm.merge(room[0], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans = IntArray(k)
    Arrays.fill(ans, -1)
    for (j in idx) {
      val prefer = queries[j][0]
      val minSize = queries[j][1]
      while (i < n && rooms[i][1] < minSize) {
        if (tm.merge(rooms[i][0], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          tm.remove(rooms[i][0])
        }
        ++i
      }
      if (i == n) {
        break
      }
      var p: Int = tm.ceilingKey(prefer)
      if (p != null) {
        ans[j] = p
      }
      p = tm.floorKey(prefer)
      if (p != null && (ans[j] == -1 || ans[j] - prefer >= prefer - p)) {
        ans[j] = p
      }
    }
    return ans
  }
}
