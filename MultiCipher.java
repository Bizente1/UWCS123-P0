// Bisente Deleon-Oronia
// 10/8/25
// CSE 123
// Programming Assignment 0: Ciphers
// Trien Vuong
//

import java.util.List;

// This class implements a MultiCipher, which applies multiple Cipher objects in sequence.
public class MultiCipher extends Cipher {

    private List<Cipher> ciphers;


    // Behavior:
    //   - Constructs a MultiCipher with the given list of Cipher objects.
    // Parameters:
    //   - ciphers: a List of Cipher objects to be applied in sequence.
    // Exceptions:
    //   - Throws IllegalArgumentException if the provided list is null.
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("The list provided was null");
        }

        this.ciphers = ciphers;
    }

    // Behavior:
    //   - Encrypts the given input String by applying each Cipher in the list sequentially.
    // Parameters:
    //   - input: the String to be encrypted.
    // Returns:
    //   - A String that has been encrypted by all ciphers in order.
    // Exceptions:
    //   - Throws IllegalArgumentException if the input is null.

    @Override
    public String encrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("The input provided was null");
        }
        for (Cipher cipher : ciphers) {
            input = cipher.encrypt(input);
        }
        return input;
    }

    // Behavior:
    //   - Decrypts the given input String by applying each Cipher in reverse order.
    // Parameters:
    //   - input: the String to be decrypted.
    // Returns:
    //   - A String restored to its original state after reversing all encryption steps.
    // Exceptions:
    //   - Throws IllegalArgumentException if the input is null.
    @Override
    public String decrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("The input provided was null");
        }

        for (int i = ciphers.size() - 1; i >= 0; i--) {
            input = ciphers.get(i).decrypt(input);
        }
        return input;
    }

}