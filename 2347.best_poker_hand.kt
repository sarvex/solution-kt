class Solution {
  fun bestHand(ranks: IntArray, suits: CharArray): String {
    var flush = true
    var i = 1
    while (i < 5 && flush) {
      flush = suits[i] == suits[i - 1]
      ++i
    }
    if (flush) {
      return "Flush"
    }
    val cnt = IntArray(14)
    var pair = false
    for (x in ranks) {
      if (++cnt[x] == 3) {
        return "Three of a Kind"
      }
      pair = pair || cnt[x] == 2
    }
    return if (pair) "Pair" else "High Card"
  }
}
