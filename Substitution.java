// TODO: Write your implementation to Subsitution here!

import java.util.HashMap;

public class Substitution extends Cipher{

    public HashMap<Character, Character> encodeMap;
    public HashMap<Character, Character> decodeMap;

    public Substitution(){
        encodeMap = new HashMap<Character, Character>();
        decodeMap = new HashMap<Character, Character>();       
    }

    public Substitution(String encoding){
        encodeMap = new HashMap<Character, Character>();
        decodeMap = new HashMap<Character, Character>();
        setEncoding(encoding);
    }

    public void setEncoding(String encoding){
        checkValid(encoding);

        for(int i = 0; i < encoding.length(); i++ ){
            encodeMap.put((char) (MIN_CHAR + i), encoding.charAt(i));
            decodeMap.put(encoding.charAt(i), (char) (MIN_CHAR + i));
        }  
    }

    @Override
    public String encrypt(String input){
        if(input == null) throw new IllegalArgumentException("Input given was null");
        if(encodeMap.size() <= 0) throw new IllegalStateException("Encoding was never set");
        

        String encryptedString = "";
        for(int i = 0; i < input.length(); i++){
            if(encodeMap.containsKey(input.charAt(i))){
                encryptedString += encodeMap.get(input.charAt(i));
            } else{
                encryptedString += input.charAt(i);
            }
        }

        return encryptedString;
    }

    @Override
    public String decrypt(String input) {
        if(decodeMap.size() <= 0) throw new IllegalStateException("Decoding was never set");
        if(input == null) throw new IllegalArgumentException("Input given was null");
        
        String decryptedString = "";
        for(int i = 0; i < input.length(); i++){
            if(decodeMap.containsKey(input.charAt(i))){
                decryptedString += decodeMap.get(input.charAt(i));
            } else{
                decryptedString += input.charAt(i);
            }
        }
        
        return decryptedString;
    }



    public void checkValid(String encoding){
        if(encoding == null) throw new IllegalArgumentException("Encoding String was null");
        if(encoding.length() > TOTAL_CHARS) throw new IllegalArgumentException("Encoding String exceeds Max Chars");
        if(encoding.isEmpty()) throw new IllegalArgumentException("Encoding String is empty");
        if(encoding.length() < TOTAL_CHARS) throw new IllegalArgumentException("Encoding String contain to few Chars");
        int counter;
        for(int i = 0; i < encoding.length(); i++){
            if(!isCharInRange(encoding.charAt(i))) throw new IllegalArgumentException("Encoding String Chars out of Range");

            counter = 0;
            for(int j = 0; j < encoding.length(); j++){
                if(encoding.charAt(i) == encoding.charAt(j)) counter++;
            }

            if(counter > 1) throw new IllegalArgumentException("Encoding String contains multiple of the same Char");
        }
    }
    
}