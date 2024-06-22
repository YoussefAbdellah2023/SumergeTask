package utility;

public class WaitingMethod extends ScreenShot{

    public void waitForAFixedPeriod(int periodinSec)  {
        try {
            Thread.sleep(periodinSec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
