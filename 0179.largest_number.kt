internal class Solution {
  fun largestNumber(nums: IntArray): String {
    val vs: List<String> = ArrayList()
    for (v in nums) {
      vs.add(v.toString() + "")
    }
    vs.sort { a, b -> (b + a).compareTo(a + b) }
    return if ("0" == vs[0]) {
      "0"
    } else java.lang.String.join("", vs)
  }
}
