class Solution {
  fun dividePlayers(skill: IntArray): Long {
    Arrays.sort(skill)
    val n = skill.size
    val t = skill[0] + skill[n - 1]
    var ans: Long = 0
    var i = 0
    var j = n - 1
    while (i < j) {
      if (skill[i] + skill[j] != t) {
        return -1
      }
      ans += skill[i].toLong() * skill[j]
      ++i
      --j
    }
    return ans
  }
}
