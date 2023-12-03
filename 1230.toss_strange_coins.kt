internal class Solution {
  fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
    val f = DoubleArray(target + 1)
    f[0] = 1.0
    for (p in prob) {
      for (j in target downTo 0) {
        f[j] *= 1 - p
        if (j > 0) {
          f[j] += p * f[j - 1]
        }
      }
    }
    return f[target]
  }
}
