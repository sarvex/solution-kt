class SmallestInfiniteSet {
  private val s: TreeSet<Int> = TreeSet()

  init {
    for (i in 1..1000) {
      s.add(i)
    }
  }

  fun popSmallest(): Int {
    return s.pollFirst()
  }

  fun addBack(num: Int) {
    s.add(num)
  }
}
