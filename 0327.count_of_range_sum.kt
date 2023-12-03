internal class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] += v
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x != 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val arr = LongArray(n * 3 + 3)
    run {
      var i = 0
      var j = 0
      while (i <= n) {
        arr[j] = s[i]
        arr[j + 1] = s[i] - lower
        arr[j + 2] = s[i] - upper
        ++i
        j += 3
      }
    }
    Arrays.sort(arr)
    var m = 0
    for (i in arr.indices) {
      if (i == 0 || arr[i] != arr[i - 1]) {
        arr[m++] = arr[i]
      }
    }
    val tree = BinaryIndexedTree(m)
    var ans = 0
    for (x in s) {
      val l = search(arr, m, x - upper)
      val r = search(arr, m, x - lower)
      ans += tree.query(r) - tree.query(l - 1)
      tree.update(search(arr, m, x), 1)
    }
    return ans
  }

  private fun search(nums: LongArray, r: Int, x: Long): Int {
    var r = r
    var l = 0
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l + 1
  }
}
