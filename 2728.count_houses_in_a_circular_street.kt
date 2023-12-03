/**
 * Definition for a street.
 * class Street {
 * public Street(int[] doors);
 * public void openDoor();
 * public void closeDoor();
 * public boolean isDoorOpen();
 * public void moveRight();
 * public void moveLeft();
 * }
 */
internal class Solution {
  fun houseCount(street: Street, k: Int): Int {
    var k = k
    while (k-- > 0) {
      street.openDoor()
      street.moveLeft()
    }
    var ans = 0
    while (street.isDoorOpen()) {
      ++ans
      street.closeDoor()
      street.moveLeft()
    }
    return ans
  }
}
