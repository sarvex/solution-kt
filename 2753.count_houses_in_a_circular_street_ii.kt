/**
 * Definition for a street.
 * class Street {
 * public Street(int[] doors);
 * public void closeDoor();
 * public boolean isDoorOpen();
 * public void moveRight();
 * }
 */
internal class Solution {
  fun houseCount(street: Street, k: Int): Int {
    while (!street.isDoorOpen()) {
      street.moveRight()
    }
    var ans = 0
    for (i in 1..k) {
      street.moveRight()
      if (street.isDoorOpen()) {
        ans = i
        street.closeDoor()
      }
    }
    return ans
  }
}
