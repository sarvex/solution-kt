class Solution {
  fun displayTable(orders: List<List<String>>): List<List<String>> {
    val tables: Set<Int> = HashSet()
    val foods: Set<String> = HashSet()
    val mp: Map<String, Int> = HashMap()
    for (order in orders) {
      val table = order[1].toInt()
      val food = order[2]
      tables.add(table)
      foods.add(food)
      val key = "$table.$food"
      mp.put(key, (mp[key] ?: 0) + 1)
    }
    val t: List<Int> = ArrayList(tables)
    val f: List<String> = ArrayList(foods)
    Collections.sort(t)
    Collections.sort(f)
    val res: List<List<String>> = ArrayList()
    val title: List<String> = ArrayList()
    title.add("Table")
    title.addAll(f)
    res.add(title)
    for (table in t) {
      val tmp: List<String> = ArrayList()
      tmp.add(table.toString())
      for (food in f) {
        tmp.add(java.lang.String.valueOf(mp["$table.$food"] ?: 0))
      }
      res.add(tmp)
    }
    return res
  }
}
