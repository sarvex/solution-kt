class LockingTree(parent: IntArray) {
  private val locked: IntArray
  private val parent: IntArray
  private val children: Array<List<Int>?>

  init {
    val n = parent.size
    locked = IntArray(n)
    this.parent = parent
    children = arrayOfNulls(n)
    Arrays.fill(locked, -1)
    Arrays.setAll(children) { i -> ArrayList() }
    for (i in 1 until n) {
      children[parent[i]].add(i)
    }
  }

  fun lock(num: Int, user: Int): Boolean {
    if (locked[num] == -1) {
      locked[num] = user
      return true
    }
    return false
  }

  fun unlock(num: Int, user: Int): Boolean {
    if (locked[num] == user) {
      locked[num] = -1
      return true
    }
    return false
  }

  fun upgrade(num: Int, user: Int): Boolean {
    var x = num
    while (x != -1) {
      if (locked[x] != -1) {
        return false
      }
      x = parent[x]
    }
    val find = BooleanArray(1)
    dfs(num, find)
    if (!find[0]) {
      return false
    }
    locked[num] = user
    return true
  }

  private fun dfs(x: Int, find: BooleanArray) {
    for (y in children[x]!!) {
      if (locked[y] != -1) {
        locked[y] = -1
        find[0] = true
      }
      dfs(y, find)
    }
  }
}
