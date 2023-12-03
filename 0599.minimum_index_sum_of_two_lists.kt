internal class Solution {
  fun findRestaurant(list1: Array<String?>, list2: Array<String?>): Array<String> {
    val mp: Map<String?, Int> = HashMap()
    for (i in list2.indices) {
      mp.put(list2[i], i)
    }
    var ans: List<String?> = ArrayList()
    var mi = 2000
    for (i in list1.indices) {
      if (mp.containsKey(list1[i])) {
        val t = i + mp[list1[i]]!!
        if (t < mi) {
          ans = ArrayList()
          ans.add(list1[i])
          mi = t
        } else if (t == mi) {
          ans.add(list1[i])
        }
      }
    }
    return ans.toArray(arrayOfNulls<String>(0))
  }
}
