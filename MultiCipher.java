import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultiCipher extends Cipher {

    public List<Cipher> ciphers;

    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("The list provided was null");
        }

        this.ciphers = ciphers;
    }

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