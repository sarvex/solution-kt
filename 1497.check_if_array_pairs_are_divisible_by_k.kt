class Solution {
  fun canArrange(arr: IntArray, k: Int): Boolean {
    val cnt = IntArray(k)
    for (x in arr) {
      ++cnt[(x % k + k) % k]
    }
    for (i in 1 until k) {
      if (cnt[i] != cnt[k - i]) {
        return false
      }
    }
    return cnt[0] % 2 == 0
  }
}
