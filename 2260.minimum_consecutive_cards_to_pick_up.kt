class Solution {
  fun minimumCardPickup(cards: IntArray): Int {
    val last: Map<Int, Int> = HashMap()
    val n = cards.size
    var ans = n + 1
    for (i in 0 until n) {
      if (last.containsKey(cards[i])) {
        ans = Math.min(ans, i - last[cards[i]]!! + 1)
      }
      last.put(cards[i], i)
    }
    return if (ans > n) -1 else ans
  }
}
