class Solution {
  fun decode(encoded: IntArray): IntArray {
    val n = encoded.size + 1
    var a = 0
    var b = 0
    run {
      var i = 0
      while (i < n - 1) {
        a = a xor encoded[i]
        i += 2
      }
    }
    for (i in 1..n) {
      b = b xor i
    }
    val perm = IntArray(n)
    perm[n - 1] = a xor b
    for (i in n - 2 downTo 0) {
      perm[i] = encoded[i] xor perm[i + 1]
    }
    return perm
  }
}
