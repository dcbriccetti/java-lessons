package examples.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

  @Test void bChangesToA() {
    assertEquals("a", CaesarCipher.encrypt("b", 1));
  }

  @Test void cChangesToA() {
    assertEquals("a", CaesarCipher.encrypt("c", 2));
  }

  @Test void allKeysWork() {
    for (int i = 0; i <= 5000; ++i) {
      assertEquals("abc", CaesarCipher.decrypt(CaesarCipher.encrypt("abc", i), i));
    }
  }

  @Test void wrappingAroundWorks() {
    assertEquals("~", CaesarCipher.encrypt("!", 2));
    assertEquals("!", CaesarCipher.encrypt("~", -2));
  }
}
