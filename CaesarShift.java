// Bisente Deleon-Oronia
// 10/8/25
// CSE 123
// Programming Assignment 0: Ciphers
// Trien Vuong



// This class implements a Caesar Shift cipher
// It shifts each character in the encoding by a given number of positions within the valid range
// of characters, wrapping around when necessary.
public class CaesarShift extends Substitution {

    // Behavior:
    //   - Constructs a CaesarShift cipher using the given shift value.
    //   - Generates a substitution encoding that shifts each valid character by the given amount.
    // Parameters:
    //   - shift: the integer number of positions to shift characters by in the cipher.
    // Exceptions:
    //   - Throws IllegalArgumentException if the given shift value is less than or equal to 0.
    
    public CaesarShift(int shift) {
        super();
        if (shift < 0) {
            throw new IllegalArgumentException("Shift is equal too or lower than 0");
        }

        String helperString = "";
        shift %= Cipher.TOTAL_CHARS;

        for (int i = 0; i < TOTAL_CHARS; i++) {
            helperString += (char) (Cipher.MIN_CHAR
                    + ((char) (MIN_CHAR + i) + shift - Cipher.MIN_CHAR) % Cipher.TOTAL_CHARS);
        }

        setEncoding(helperString);
    }

}