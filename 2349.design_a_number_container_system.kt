class NumberContainers {
  private val mp: Map<Int, Int> = HashMap()
  private val t: Map<Int, TreeSet<Int>> = HashMap()
  fun change(index: Int, number: Int) {
    if (mp.containsKey(index)) {
      val v = mp[index]!!
      t[v].remove(index)
      if (t[v].isEmpty()) {
        t.remove(v)
      }
    }
    mp.put(index, number)
    t.computeIfAbsent(number) { k -> TreeSet() }.add(index)
  }

  fun find(number: Int): Int {
    return if (t.containsKey(number)) t[number].first() else -1
  }
}
