import java.util.HashMap;

// Bisente Deleon-Oronia
// 10/8/25
// CSE 123
// Programming Assignment 0: Ciphers
// Trien Vuong
//


// This class implements a Substitution Cipher. It allows users to encrypt and decrypt
//messages by giving a Encoding String that maps charactors to the String provided
public class Substitution extends Cipher {

    public HashMap<Character, Character> encodeMap;
    public HashMap<Character, Character> decodeMap;

    // Behavior:
    //   - Constructs an empty Substitution Cipher with no encoding set.
    public Substitution() {
        encodeMap = new HashMap<Character, Character>();
        decodeMap = new HashMap<Character, Character>();
    }

    // Behavior:
    //   - Constructs a Substitution Cipher and sets its encoding using the provided string.
    // Parameters:
    //   - encoding: a String representing the substitution mapping for characters.
    // Exceptions:
    //   - Throws IllegalArgumentException if the encoding string is invalid.
    public Substitution(String encoding) {
        encodeMap = new HashMap<Character, Character>();
        decodeMap = new HashMap<Character, Character>();
        setEncoding(encoding);
    }

    // Behavior:
    //   - Sets up the character mapping (both encoding and decoding) based on the given encoding string.
    // Parameters:
    //   - encoding: the String containing the character substitutions.
    // Exceptions:
    //   - Throws IllegalArgumentException if the encoding string is invalid or out of range.
    public void setEncoding(String encoding) {
        checkValid(encoding);

        for (int i = 0; i < encoding.length(); i++) {
            encodeMap.put((char) (MIN_CHAR + i), encoding.charAt(i));
            decodeMap.put(encoding.charAt(i), (char) (MIN_CHAR + i));
        }
    }

    // Behavior:
    //   - Encrypts the given input String using the substitution encoding.
    // Parameters:
    //   - input: the String to be encrypted.
    // Returns:
    //   - A new String where each character has been replaced with its encoded counterpart.
    // Exceptions:
    //   - Throws IllegalArgumentException if input is null.
    //   - Throws IllegalStateException if the encoding map has not been set.
    @Override
    public String encrypt(String input) {
        if (input == null)
            throw new IllegalArgumentException("Input given was null");
        if (encodeMap.size() <= 0)
            throw new IllegalStateException("Encoding was never set");

        String encryptedString = "";
        for (int i = 0; i < input.length(); i++) {
            if (encodeMap.containsKey(input.charAt(i))) {
                encryptedString += encodeMap.get(input.charAt(i));
            } else {
                encryptedString += input.charAt(i);
            }
        }

        return encryptedString;
    }

    // Behavior:
    //   - Decrypts the given input String using the substitution decoding.
    // Parameters:
    //   - input: the encrypted String to be decrypted.
    // Returns:
    //   - A new String where each encoded character has been replaced with its original counterpart.
    // Exceptions:
    //   - Throws IllegalStateException if decoding map has not been set.
    //   - Throws IllegalArgumentException if input is null.
    @Override
    public String decrypt(String input) {
        if (decodeMap.size() <= 0)
            throw new IllegalStateException("Decoding was never set");
        if (input == null)
            throw new IllegalArgumentException("Input given was null");

        String decryptedString = "";
        for (int i = 0; i < input.length(); i++) {
            if (decodeMap.containsKey(input.charAt(i))) {
                decryptedString += decodeMap.get(input.charAt(i));
            } else {
                decryptedString += input.charAt(i);
            }
        }

        return decryptedString;
    }

    // Behavior:
    //   - Checks if a given encoding string is valid by verifying its length,
    //     character range, and that all characters are unique.
    // Parameters:
    //   - encoding: the String to validate as a substitution mapping.
    // Exceptions:
    //   - Throws IllegalArgumentException if:
    //       * encoding is null,
    //       * encoding is empty,
    //       * encoding length is greater than or less than TOTAL_CHARS,
    //       * encoding contains duplicate characters,
    //       * encoding contains characters outside the allowed range.
    //
    // This is a method the User doesn't have access to but it just help make another 
    // method more concise so it just a helper method.
    private void checkValid(String encoding) {
        if (encoding == null)
            throw new IllegalArgumentException("Encoding String was null");
        if (encoding.length() > TOTAL_CHARS)
            throw new IllegalArgumentException("Encoding String exceeds Max Chars");
        if (encoding.isEmpty())
            throw new IllegalArgumentException("Encoding String is empty");
        if (encoding.length() < TOTAL_CHARS)
            throw new IllegalArgumentException("Encoding String contain to few Chars");
        int counter;
        for (int i = 0; i < encoding.length(); i++) {
            if (!isCharInRange(encoding.charAt(i)))
                throw new IllegalArgumentException("Encoding String Chars out of Range");

            counter = 0;
            for (int j = 0; j < encoding.length(); j++) {
                if (encoding.charAt(i) == encoding.charAt(j))
                    counter++;
            }

            if (counter > 1)
                throw new IllegalArgumentException("Encoding String contains multiple of the same Char");
        }
    }

}