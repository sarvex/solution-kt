/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
internal class Solution : SolBase() {
  fun rand10(): Int {
    while (true) {
      val i: Int = rand7() - 1
      val j: Int = rand7()
      val x = i * 7 + j
      if (x <= 40) {
        return x % 10 + 1
      }
    }
  }
}
