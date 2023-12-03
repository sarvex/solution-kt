/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
</NestedInteger> */
class NestedIterator(nestedList: List<NestedInteger>) : Iterator<Int?> {
  private val vals: List<Int>
  private val cur: Iterator<Int>

  init {
    vals = ArrayList()
    dfs(nestedList)
    cur = vals.iterator()
  }

  override fun next(): Int {
    return cur.next()
  }

  override fun hasNext(): Boolean {
    return cur.hasNext()
  }

  private fun dfs(nestedList: List<NestedInteger>) {
    for (e in nestedList) {
      if (e.isInteger()) {
        vals.add(e.getInteger())
      } else {
        dfs(e.getList())
      }
    }
  }
}
