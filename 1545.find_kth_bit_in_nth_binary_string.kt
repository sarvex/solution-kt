class Solution {
  fun findKthBit(n: Int, k: Int): Char {
    if (k == 1 || n == 1) {
      return '0'
    }
    val set: Set<Int> = HashSet()
    val len = calcLength(n, set)
    if (set.contains(k)) {
      return '1'
    }
    // 中间，返回1
    return if (k < len / 2) {
      findKthBit(n - 1, k)
    } else {
      if (set.contains(len - k)) {
        '1'
      } else r(findKthBit(n - 1, len - k + 1))
    }
  }

  private fun r(b: Char): Char {
    return if (b == '0') {
      '1'
    } else '0'
  }

  private fun calcLength(n: Int, set: Set<Int>): Int {
    if (n == 1) {
      return 1
    }
    val ans = 2 * calcLength(n - 1, set) + 1
    set.add(ans + 1)
    return ans
  }
}
