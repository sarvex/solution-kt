internal class Solution {
  fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
    var i = arr1.size - 1
    var j = arr2.size - 1
    val ans: List<Int> = ArrayList()
    var c = 0
    while (i >= 0 || j >= 0 || c != 0) {
      val a = if (i < 0) 0 else arr1[i]
      val b = if (j < 0) 0 else arr2[j]
      var x = a + b + c
      c = 0
      if (x >= 2) {
        x -= 2
        c -= 1
      } else if (x == -1) {
        x = 1
        c += 1
      }
      ans.add(x)
      --i
      --j
    }
    while (ans.size() > 1 && ans[ans.size() - 1] === 0) {
      ans.remove(ans.size() - 1)
    }
    Collections.reverse(ans)
    return ans.stream().mapToInt { x -> x }.toArray()
  }
}
