class Solution {
  fun maximumCoins(heroes: IntArray, monsters: IntArray, coins: IntArray): LongArray {
    val m = monsters.size
    val idx = arrayOfNulls<Int>(m)
    for (i in 0 until m) {
      idx[i] = i
    }
    Arrays.sort(idx, Comparator.comparingInt { j -> monsters[j] })
    val s = LongArray(m + 1)
    for (i in 0 until m) {
      s[i + 1] = s[i] + coins[idx[i]!!]
    }
    val n = heroes.size
    val ans = LongArray(n)
    for (k in 0 until n) {
      val i = search(monsters, idx, heroes[k])
      ans[k] = s[i]
    }
    return ans
  }

  private fun search(nums: IntArray, idx: Array<Int?>, x: Int): Int {
    var l = 0
    var r = idx.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[idx[mid]!!] > x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
