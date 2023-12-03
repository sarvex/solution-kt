class Solution {
  private var p: IntArray
  fun removeStones(stones: Array<IntArray>): Int {
    val n = 10010
    p = IntArray(n shl 1)
    for (i in p.indices) {
      p[i] = i
    }
    for (stone in stones) {
      p[find(stone[0])] = find(stone[1] + n)
    }
    val s: Set<Int> = HashSet()
    for (stone in stones) {
      s.add(find(stone[0]))
    }
    return stones.size - s.size()
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
