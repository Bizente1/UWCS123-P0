import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultiCipher extends Cipher{

    public List<Cipher> ciphers;

    public MultiCipher(List<Cipher> ciphers){
        this.ciphers = ciphers;
        if(ciphers == null){
            throw new IllegalArgumentException("The list provided was null");
        }
    }

    @Override
    public String encrypt(String input) {
        for(Cipher cipher: ciphers){
            input = cipher.encrypt(input);
        }
        return input;
    }

    @Override
    public String decrypt(String input) {
        
        for(int i = ciphers.size()-1; i >= 0; i--){
            input = ciphers.get(i).decrypt(input);
        }
        return input;
    }



    
}