class H2O {
  private val h: Semaphore = Semaphore(2)
  private val o: Semaphore = Semaphore(0)
  @Throws(InterruptedException::class)
  fun hydrogen(releaseHydrogen: Runnable) {
    h.acquire()
    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    releaseHydrogen.run()
    o.release()
  }

  @Throws(InterruptedException::class)
  fun oxygen(releaseOxygen: Runnable) {
    o.acquire(2)
    // releaseOxygen.run() outputs "O". Do not change or remove this line.
    releaseOxygen.run()
    h.release(2)
  }
}
