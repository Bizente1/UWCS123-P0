// TODO: Write your implementation to CaesarShift here!
public class CaesarShift extends Substitution {
    private int shift;
    

    public CaesarShift(int shift){
        super();
        //this.setEncoding(getEncode());
        this.shift = shift;
    }

    public void setEncoding(String encoding){
        String helperString = "";
        this.shift %= Cipher.TOTAL_CHARS;
        for(int i = 0; i < encoding.length(); i++){
        helperString += (char)(Cipher.MIN_CHAR + (encoding.charAt(i) + shift - Cipher.MIN_CHAR) % Cipher.TOTAL_CHARS);  
        }
        System.out.println(helperString);
        super.setEncoding(helperString);
    }

    public static void main(String[] args){
        CaesarShift caesarShift = new CaesarShift(2);
        caesarShift.setEncoding(caesarShift.getEncode());
    }

    public String encrypt(String input){
        return super.encrypt(input);
    }

    public String getEncode(){
        String toReturn = "";
        for(int i = 0; i < TOTAL_CHARS; i++){
            toReturn += (char) (MIN_CHAR + i);
        }
        return toReturn;
    }

}