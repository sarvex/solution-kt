class Solution {
  fun minNumberOfHours(
    initialEnergy: Int, initialExperience: Int, energy: IntArray, experience: IntArray
  ): Int {
    var initialEnergy = initialEnergy
    var initialExperience = initialExperience
    var ans = 0
    for (i in energy.indices) {
      val a = energy[i]
      val b = experience[i]
      if (initialEnergy <= a) {
        ans += a - initialEnergy + 1
        initialEnergy = a + 1
      }
      if (initialExperience <= b) {
        ans += b - initialExperience + 1
        initialExperience = b + 1
      }
      initialEnergy -= a
      initialExperience += b
    }
    return ans
  }
}
