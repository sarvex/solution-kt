class FindSumPairs(private val nums1: IntArray, private val nums2: IntArray) {
  private val cnt: Map<Int, Int> = HashMap()

  init {
    for (v in nums2) {
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
  }

  fun add(index: Int, `val`: Int) {
    val old = nums2[index]
    cnt.put(old, cnt[old]!! - 1)
    cnt.put(old + `val`, (cnt[old + `val`] ?: 0) + 1)
    nums2[index] += `val`
  }

  fun count(tot: Int): Int {
    var ans = 0
    for (v in nums1) {
      ans += cnt[tot - v] ?: 0
    }
    return ans
  }
}
