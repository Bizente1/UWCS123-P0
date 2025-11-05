import java.util.List;

// Bisente Deleon-Oronia
// 10/8/25
// CSE 123
// Programming Assignment 0: Ciphers
// Trien Vuong
//

// This class is a MultiCipher and inherits from the Cipher Abstract Class. 
// This class holds a list of Ciphers that applies the encryptions 
// and decryption of each onto the given String
public class MultiCipher extends Cipher {

    private List<Cipher> ciphers;

    // Behavior:
    //   - Constructs a MultiCipher with the given list of Cipher objects.
    // Exceptions:
    //   - Throws IllegalArgumentException if the provided list is null.
    // Returns:
    //     - N/A is a Constructor
    // Parameters:
    //   - ciphers: a List of Cipher objects to be applied in sequence.
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("The list provided was null");
        }

        this.ciphers = ciphers;
    }

    // Behavior:
    //   - Encrypts the given input String within the encodeable range by applying each Cipher in the list sequentially.
    // Exceptions:
    //   - Throws IllegalArgumentException if the input is null.
    // Returns:
    //   - A String that has been encrypted by all ciphers in order.
    //   - If a character that was given lies outside the encodable range then its 
    //      will not be changed in the String be returned.
    // Parameters:
    //   - input: the String to be encrypted.
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
    //   - Decrypts the given input String within the encodeable range by applying each Cipher in reverse order.
    // Exceptions:
    //   - Throws IllegalArgumentException if the input is null.
    // Returns:
    //   - A String restored to its original state after reversing all encryption steps.
    //   - If a character lies outside the encodeable range then the charater in 
    //      the String will remain unchanged
    // Parameters:
    //   - input: the String to be decrypted.
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