class SparseVector(nums: IntArray) {
  var d: Map<Int?, Int> = HashMap(128)

  init {
    for (i in nums.indices) {
      if (nums[i] != 0) {
        d.put(i, nums[i])
      }
    }
  }

  // Return the dotProduct of two sparse vectors
  fun dotProduct(vec: SparseVector): Int {
    var a = d
    var b = vec.d
    if (b.size() < a.size()) {
      val t = a
      a = b
      b = t
    }
    var ans = 0
    for (e in a.entrySet()) {
      val i: Int = e.getKey()
      val v: Int = e.getValue()
      ans += v * (b[i] ?: 0)
    }
    return ans
  }
}
