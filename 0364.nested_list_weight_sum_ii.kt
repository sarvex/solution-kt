import kotlin.math.max

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
</NestedInteger> */
internal class Solution {
  fun depthSumInverse(nestedList: List<NestedInteger>): Int {
    val depth = maxDepth(nestedList)
    return dfs(nestedList, depth)
  }

  private fun maxDepth(nestedList: List<NestedInteger>): Int {
    var depth = 1
    for (item in nestedList) {
      if (item.isInteger()) {
        continue
      }
      depth = max(depth.toDouble(), (1 + maxDepth(item.getList())).toDouble()).toInt()
    }
    return depth
  }

  private fun dfs(nestedList: List<NestedInteger>, depth: Int): Int {
    var depthSum = 0
    for (item in nestedList) {
      if (item.isInteger()) {
        depthSum += item.getInteger() * depth
      } else {
        depthSum += dfs(item.getList(), depth - 1)
      }
    }
    return depthSum
  }
}
