// TODO: Write your implementation to CaesarShift here!
public class CaesarShift extends Substitution {
    

    public CaesarShift(int shift){
        super();
        if(shift < 0){
            throw new IllegalArgumentException("Shift is equal too or lower than 0");
        }

        String helperString = "";
        shift %= Cipher.TOTAL_CHARS;

        for(int i = 0; i < TOTAL_CHARS; i++){
            helperString += (char)(Cipher.MIN_CHAR + ((char) (MIN_CHAR + i) + shift - Cipher.MIN_CHAR) % Cipher.TOTAL_CHARS);  
        }

        setEncoding(helperString);
    }




}