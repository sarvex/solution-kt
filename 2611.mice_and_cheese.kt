class Solution {
  fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
    val n = reward1.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> reward1[j] - reward2[j] - (reward1[i] - reward2[i]) }
    var ans = 0
    for (i in 0 until k) {
      ans += reward1[idx[i]!!]
    }
    for (i in k until n) {
      ans += reward2[idx[i]!!]
    }
    return ans
  }
}
