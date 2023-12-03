class Solution {
  fun maxNumberOfApples(weight: IntArray): Int {
    Arrays.sort(weight)
    var s = 0
    for (i in weight.indices) {
      s += weight[i]
      if (s > 5000) {
        return i
      }
    }
    return weight.size
  }
}
