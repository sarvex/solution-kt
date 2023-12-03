internal class RandomizedCollection {
  private val m: Map<Int, Set<Int>>
  private val l: List<Int>
  private val rnd: Random

  /** Initialize your data structure here.  */
  init {
    m = HashMap()
    l = ArrayList()
    rnd = Random()
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain
   * the specified element.
   */
  fun insert(`val`: Int): Boolean {
    m.computeIfAbsent(`val`) { k -> HashSet() }.add(l.size())
    l.add(`val`)
    return m[`val`]!!.size() === 1
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  fun remove(`val`: Int): Boolean {
    if (!m.containsKey(`val`)) {
      return false
    }
    val idxSet = m[`val`]!!
    val idx = idxSet.iterator().next()
    val lastIdx: Int = l.size() - 1
    l.set(idx, l[lastIdx])
    idxSet.remove(idx)
    val lastIdxSet = m[l[lastIdx]]!!
    lastIdxSet.remove(lastIdx)
    if (idx < lastIdx) {
      lastIdxSet.add(idx)
    }
    if (idxSet.isEmpty()) {
      m.remove(`val`)
    }
    l.remove(lastIdx)
    return true
  }

  val random: Int
    /** Get a random element from the collection.  */
    get() {
      val size: Int = l.size()
      return if (size == 0) -1 else l[rnd.nextInt(size)]
    }
}
