class Solution {
  fun minNumberOperations(target: IntArray): Int {
    var f = target[0]
    for (i in 1 until target.size) {
      if (target[i] > target[i - 1]) {
        f += target[i] - target[i - 1]
      }
    }
    return f
  }
}
