class Solution {
  fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): List<Int> {
    val pos: Set<Int> = HashSet()
    for (x in nums) {
      pos.add(x)
    }
    for (i in moveFrom.indices) {
      pos.remove(moveFrom[i])
      pos.add(moveTo[i])
    }
    val ans: List<Int> = ArrayList(pos)
    ans.sort { a, b -> a - b }
    return ans
  }
}
