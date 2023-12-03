import java.util.*
import kotlin.collections.ArrayDeque

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
  fun deserialize(s: String): NestedInteger {
    if (s[0] != '[') {
      return NestedInteger(s.toInt())
    }
    val stk: Deque<NestedInteger> = ArrayDeque()
    var x = 0
    var neg = false
    for (i in 0 until s.length) {
      val c = s[i]
      if (c == '-') {
        neg = true
      } else if (Character.isDigit(c)) {
        x = x * 10 + c.code - '0'.code
      } else if (c == '[') {
        stk.push(NestedInteger())
      } else if (c == ',' || c == ']') {
        if (Character.isDigit(s[i - 1])) {
          if (neg) {
            x = -x
          }
          stk.peek().add(NestedInteger(x))
        }
        x = 0
        neg = false
        if (c == ']' && stk.size() > 1) {
          val t: NestedInteger = stk.pop()
          stk.peek().add(t)
        }
      }
    }
    return stk.peek()
  }
}
