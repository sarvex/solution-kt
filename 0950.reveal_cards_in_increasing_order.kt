class Solution {
  fun deckRevealedIncreasing(deck: IntArray): IntArray {
    val q: Deque<Int> = ArrayDeque()
    Arrays.sort(deck)
    val n = deck.size
    for (i in n - 1 downTo 0) {
      if (!q.isEmpty()) {
        q.offerFirst(q.pollLast())
      }
      q.offerFirst(deck[i])
    }
    val ans = IntArray(n)
    for (i in n - 1 downTo 0) {
      ans[i] = q.pollLast()
    }
    return ans
  }
}
