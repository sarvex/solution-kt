class Solution {
  var n = 0
  var budget = 0
  var composition: List<List<Int>>? = null
  var stock: List<Int>? = null
  var cost: List<Int>? = null
  fun isValid(target: Long): Boolean {
    for (currMachine in composition!!) {
      var remain = budget.toLong()
      var j = 0
      while (j < n && remain >= 0) {
        val need = Math.max(0, currMachine[j] * target - stock!![j])
        remain -= need * cost!![j]
        j++
      }
      if (remain >= 0) {
        return true
      }
    }
    return false
  }

  fun maxNumberOfAlloys(
    n: Int, k: Int, budget: Int, composition: List<List<Int>>?,
    stock: List<Int>, cost: List<Int>
  ): Int {
    this.n = n
    this.budget = budget
    this.composition = composition
    this.stock = stock
    this.cost = cost
    var l = -1
    var r = budget / cost[0] + stock[0]
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (isValid(mid.toLong())) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }
}
