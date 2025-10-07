// TODO: Write your implementation to CaesarShift here!
public class CaesarShift extends Substitution {
    private int shift;

    public CaesarShift(int shift){
        super();
        this.shift = shift;
    }

    public CaesarShift(int shift, String encoding){
        super(encoding);
        this.shift = shift;
    }

    
}