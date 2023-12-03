internal class Solution {
  fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    Arrays.sort(people) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else b.get(0) - a.get(0) }
    val ans: List<IntArray> = ArrayList(people.size)
    for (p in people) {
      ans.add(p[1], p)
    }
    return ans.toArray(arrayOfNulls<IntArray>(ans.size()))
  }
}
