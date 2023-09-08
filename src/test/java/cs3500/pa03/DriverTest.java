package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class DriverTest {

  @Test
  public void testMain() {
    String[] args = {};
    assertThrows(NoSuchElementException.class, () -> Driver.main(args));
  }

}