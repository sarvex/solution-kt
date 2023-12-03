internal class SnapshotArray(length: Int) {
  private val arr: Array<List<IntArray>?>
  private var idx = 0

  init {
    arr = arrayOfNulls(length)
    Arrays.setAll(arr) { k -> ArrayList() }
  }

  operator fun set(index: Int, `val`: Int) {
    arr[index].add(intArrayOf(idx, `val`))
  }

  fun snap(): Int {
    return idx++
  }

  operator fun get(index: Int, snap_id: Int): Int {
    val vals = arr[index]
    var left = 0
    var right: Int = vals!!.size()
    while (left < right) {
      val mid = left + right shr 1
      if (vals[mid][0] > snap_id) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return if (left == 0) 0 else vals[left - 1][1]
  }
}
