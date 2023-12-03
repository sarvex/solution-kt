internal class Solution {
  fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    val cnt: Map<Int, Int> = HashMap()
    for (v in hand) {
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
    Arrays.sort(hand)
    for (v in hand) {
      if (cnt.containsKey(v)) {
        for (x in v until v + groupSize) {
          if (!cnt.containsKey(x)) {
            return false
          }
          cnt.put(x, cnt[x]!! - 1)
          if (cnt[x] === 0) {
            cnt.remove(x)
          }
        }
      }
    }
    return true
  }
}
