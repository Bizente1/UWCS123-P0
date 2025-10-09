public class CaesarKey extends Substitution{
    public CaesarKey(String key){
        super();
        if(key == null){
            throw new IllegalArgumentException("Key was null");
        }

        int counter;
        for(int i = 0; i < key.length(); i++){
            if(!isCharInRange(key.charAt(i))) throw new IllegalArgumentException("Encoding String Chars out of Range");

            counter = 0;
            for(int j = 0; j < key.length(); j++){
                if(key.charAt(i) == key.charAt(j)) counter++;
            }

            if(counter > 1) throw new IllegalArgumentException("Encoding String contains multiple of the same Char");
        }

        String helperString = key;
        for(int i = 0; i < TOTAL_CHARS; i++){
            char[] toCheck = {(char) (MIN_CHAR + i)};
            if(!key.contains(new String(toCheck))){
                helperString += (char) (MIN_CHAR + i);
            }
        }
        System.out.println(helperString);
        setEncoding(helperString);
        
        

    }
}