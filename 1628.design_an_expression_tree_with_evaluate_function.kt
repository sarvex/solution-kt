import java.util.Deque
import kotlin.collections.ArrayDeque

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
internal abstract class Node {
  abstract fun evaluate(): Int

  // define your fields here
  protected var `val`: String? = null
  var left: Node? = null
  var right: Node? = null
}

internal class MyNode(`val`: String?) : Node() {
  init {
    this.`val` = `val`
  }

  override fun evaluate(): Int {
    if (isNumeric) {
      return `val`.toInt()
    }
    val leftVal: Int = left.evaluate()
    val rightVal: Int = right.evaluate()
    if (Objects.equals(`val`, "+")) {
      return leftVal + rightVal
    }
    if (Objects.equals(`val`, "-")) {
      return leftVal - rightVal
    }
    if (Objects.equals(`val`, "*")) {
      return leftVal * rightVal
    }
    return if (Objects.equals(`val`, "/")) {
      leftVal / rightVal
    } else 0
  }

  val isNumeric: Boolean
    get() {
      for (c in `val`.toCharArray()) {
        if (!Character.isDigit(c)) {
          return false
        }
      }
      return true
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */
internal class TreeBuilder {
  fun buildTree(postfix: Array<String?>): Node {
    val stk: Deque<MyNode> = ArrayDeque()
    for (s in postfix) {
      val node = MyNode(s)
      if (!node.isNumeric) {
        node.right = stk.pop()
        node.left = stk.pop()
      }
      stk.push(node)
    }
    return stk.peek()
  }
}
