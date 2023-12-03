class Solution {
  fun maxCoins(piles: IntArray): Int {
    Arrays.sort(piles)
    var ans = 0
    var i = piles.size - 2
    while (i >= piles.size / 3) {
      ans += piles[i]
      i -= 2
    }
    return ans
  }
}
