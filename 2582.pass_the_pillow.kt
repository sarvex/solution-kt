class Solution {
  fun passThePillow(n: Int, time: Int): Int {
    val k = time / (n - 1)
    val mod = time % (n - 1)
    return if (k and 1 == 1) n - mod else mod + 1
  }
}
