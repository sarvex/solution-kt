class Solution {
  fun maximumXorProduct(a: Long, b: Long, n: Int): Int {
    val mod = 1e9.toInt() + 7
    var ax = a shr n shl n
    var bx = b shr n shl n
    for (i in n - 1 downTo 0) {
      val x = a shr i and 1L
      val y = b shr i and 1L
      if (x == y) {
        ax = ax or (1L shl i)
        bx = bx or (1L shl i)
      } else if (ax < bx) {
        ax = ax or (1L shl i)
      } else {
        bx = bx or (1L shl i)
      }
    }
    ax %= mod.toLong()
    bx %= mod.toLong()
    return (ax * bx % mod).toInt()
  }
}
