// Bisente Deleon-Oronia
// 10/8/25
// CSE 123
// Programming Assignment 0: Ciphers
// Trien Vuong


// This class implements a Caesar Key cipher
// It generates an encoding based on a provided key string. The key determines the starting
// sequence of the encoding, and all remaining valid characters are appended in order to
// complete the substitution mapping.

public class CaesarKey extends Substitution {

    // Behavior:
    //   - Constructs a Caesar Key cipher using the given key string.
    // Parameters:
    //   - key: the String used as the basis for the substitution mapping.
    // Exceptions:
    //   - Throws IllegalArgumentException if:
    //       * the key is null
    //       * the key contains invalid characters,
    //       * the key includes duplicate characters.
    public CaesarKey(String key) {
        super();
        if (key == null) {
            throw new IllegalArgumentException("Key was null");
        }

        int counter;
        for (int i = 0; i < key.length(); i++) {
            if (!isCharInRange(key.charAt(i)))
                throw new IllegalArgumentException("Encoding String Chars out of Range");

            counter = 0;
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j))
                    counter++;
            }

            if (counter > 1)
                throw new IllegalArgumentException("Encoding String contains multiple of the same Char");
        }

        String helperString = key;
        for (int i = 0; i < TOTAL_CHARS; i++) {
            if (!key.contains(String.valueOf((char) (MIN_CHAR + i)))) {
                helperString += (char) (MIN_CHAR + i);
            }
        }
        System.out.println(helperString);
        setEncoding(helperString);

    }
}