internal class RangeFreqQuery(arr: IntArray) {
  private val mp: Map<Int, List<Int>> = HashMap()

  init {
    for (i in arr.indices) {
      mp.computeIfAbsent(arr[i]) { k -> ArrayList() }.add(i)
    }
  }

  fun query(left: Int, right: Int, value: Int): Int {
    if (!mp.containsKey(value)) {
      return 0
    }
    val arr = mp[value]!!
    val l = search(arr, left - 1)
    val r = search(arr, right)
    return r - l
  }

  private fun search(arr: List<Int>, `val`: Int): Int {
    var left = 0
    var right: Int = arr.size()
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] > `val`) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
