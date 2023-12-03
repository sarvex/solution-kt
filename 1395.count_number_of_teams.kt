class BinaryIndexedTree(private val n: Int) {
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
    while (x > 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun numTeams(rating: IntArray): Int {
    val n = rating.size
    val nums = rating.clone()
    Arrays.sort(nums)
    var m = 0
    for (i in 0 until n) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        nums[m++] = nums[i]
      }
    }
    val tree1 = BinaryIndexedTree(m)
    val tree2 = BinaryIndexedTree(m)
    for (v in rating) {
      val x = search(nums, v)
      tree2.update(x, 1)
    }
    var ans = 0
    for (i in 0 until n) {
      val x = search(nums, rating[i])
      tree1.update(x, 1)
      tree2.update(x, -1)
      val l = tree1.query(x - 1)
      val r = n - i - 1 - tree2.query(x)
      ans += l * r
      ans += (i - l) * (n - i - 1 - r)
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
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
