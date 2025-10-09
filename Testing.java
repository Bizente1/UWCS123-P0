import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assume.assumeTrue;
import java.util.*;

public class Testing {

    @Test
    @DisplayName("EXAMPLE TEST CASE - 'A'-'G' Spec Example")
    public void subAGTest() {
        // Remember that you can change MIN_CHAR AND MAX_CHAR 
        // in Cipher.java to make testing easier! For this 
        // example test, we are using MIN_CHAR = A and MAX_CHAR = G

        // If this is false (i.e. the constants are not 'A'-'G'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('G'));

        Cipher testSubstitution = new Substitution("GCBEAFD");
        assertEquals("FGE", testSubstitution.encrypt("FAD"));
        assertEquals("BAD", testSubstitution.decrypt("CGE"));
        
        // Per the spec, we should throw an IllegalArgumentException if 
        // the length of the shifter doesn't match the number of characters
        // within our Cipher's encodable range
        assertThrows(IllegalArgumentException.class, () -> {
            new Substitution("GCB");
        });
    }

    @Test
    @DisplayName("EXAMPLE TEST CASE - 'A'-'Z' Shifter")
    public void subAZTest() {
        // If this is false (i.e. the constants are not 'A'-'Z'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));

        // Reverse alphabetic
        Cipher testSubstitution = new Substitution(
            "ZYXWVUTSRQPONMLKJIHGFEDCBA"
        );
        assertEquals("UZW", testSubstitution.encrypt("FAD"));
        assertEquals("BAD", testSubstitution.decrypt("YZW"));
    }

    @Test
    @DisplayName("EXAMPLE TEST CASE - ' '-'}' Shifter")
    public void subComplexTest() {
        // If this is false (i.e. the constants are not ' '-'}'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)(' ') && Cipher.MAX_CHAR == (int)('}'));
        
        // Swapping lowercase a<->b
        Cipher testSubstitution = new Substitution(
            " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`" +
            "bacdefghijklmnopqrstuvwxyz{|}"
        );
        assertEquals("FAD", testSubstitution.encrypt("FAD"));
        assertEquals("fbd", testSubstitution.encrypt("fad"));
        assertEquals("BAD", testSubstitution.decrypt("BAD"));
        assertEquals("bad", testSubstitution.decrypt("abd"));
    }

    @Test
    @DisplayName("TODO: CaesarKey - 'A'-'Z'")
    public void keyAZOne() {
        // If this is false (i.e. the constants are not 'A'-'Z'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));
        
        
        // TODO: Create a new CaesarKey("TIN"), encrypt the message "HELLO" and check the
        //       result's accurate. Then, take the encrypted message, decrypt it, and
        //       check the result's accurate
        CaesarKey testKey = new CaesarKey("TIN");
        assertEquals("EBJJM", testKey.encrypt("HELLO"));
        assertEquals("HELLO", testKey.decrypt("EBJJM"));
    
    }

    @Test
    @DisplayName("TODO: CaesarShift - 'A'-'Z' Shifter")
    public void shiftAZOne() {
        // If this is false (i.e. the constants are not 'A'-'Z'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));

        // TODO: Create a new CaesarShift(6), encrypt the message "HELLO" and check the
        //       result's accurate. Then, take the encrypted message, decrypt it, and
        //       check the result's accurate
        CaesarShift shiftTest = new CaesarShift(6);
        assertEquals("NKRRU", shiftTest.encrypt("HELLO"));
        assertEquals("HELLO", shiftTest.decrypt("NKRRU"));
    }

    @Test
    @DisplayName("TODO: MultiCipher - 'A'-'Z' Shifter")
    public void multiAZOne() {
        // If this is false (i.e. the constants are not 'A'-'Z'), the test will halt and 
        // be ignored (aborted). This doesn't mean that the code is wrong! It just means that
        // the test won't produce any meaningful information if the assumption is not met.
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));

        // TODO: Create a new MultiCipher with ciphers CaesarKey("TIN") and CaesarShift(6)),
        //       encrypt the message "HELLO", and check the result's accurate. Then, take
        //       the encrypted message, decrypt it, and check the result's accurate
        MultiCipher testMultiCipher = new MultiCipher(Arrays.asList(
            new CaesarKey("TIN"), new CaesarShift(6),
            new CaesarShift(6), new CaesarKey("TIN")));
            
        assertEquals("PLVVY", testMultiCipher.encrypt("HELLO"));
        assertEquals("HELLO", testMultiCipher.decrypt("PLVVY"));
    }
}
