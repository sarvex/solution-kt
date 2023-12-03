/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 * public void printValue(); // print the value of this node.
 * public ImmutableListNode getNext(); // return the next node.
 * };
 */
internal class Solution {
  fun printLinkedListInReverse(head: ImmutableListNode?) {
    if (head != null) {
      printLinkedListInReverse(head.getNext())
      head.printValue()
    }
  }
}
