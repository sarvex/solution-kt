class Solution {
  fun getFolderNames(names: Array<String>): Array<String> {
    val d: Map<String, Int> = HashMap()
    for (i in names.indices) {
      if (d.containsKey(names[i])) {
        var k = d[names[i]]!!
        while (d.containsKey(names[i] + "(" + k + ")")) {
          ++k
        }
        d.put(names[i], k)
        names[i] += "($k)"
      }
      d.put(names[i], 1)
    }
    return names
  }
}
