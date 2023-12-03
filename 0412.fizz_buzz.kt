internal class Solution {
  fun fizzBuzz(n: Int): List<String> {
    val ans: List<String> = ArrayList()
    for (i in 1..n) {
      var s = ""
      if (i % 3 == 0) {
        s += "Fizz"
      }
      if (i % 5 == 0) {
        s += "Buzz"
      }
      if (s.length == 0) {
        s += i
      }
      ans.add(s)
    }
    return ans
  }
}
