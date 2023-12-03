internal class Solution {
  fun numRescueBoats(people: IntArray, limit: Int): Int {
    Arrays.sort(people)
    var ans = 0
    var i = 0
    var j = people.size - 1
    while (i <= j) {
      if (people[i] + people[j] <= limit) {
        ++i
      }
      ++ans
      --j
    }
    return ans
  }
}
