package src.bgu.spl.assig1;
public class IntegerScalar implements Scalar{
    private int number;
    
    public IntegerScalar(int number){
        this.number = number;
    }
    public Scalar add(Scalar s){
        return new IntegerScalar(this.number + ((IntegerScalar)s).number);
    }
    public Scalar mul(Scalar s){
        return new IntegerScalar(this.number * ((IntegerScalar)s).number);
    }
    public Scalar neg(){
        return new IntegerScalar(-this.number);
    }
    public Scalar power(int exponent){
        return new IntegerScalar((int) Math.pow(this.number, exponent));
    }
    public boolean equals(Object o){
        if(o instanceof IntegerScalar){
            return this.number == ((IntegerScalar)o).number;
        }        
        return false;
    }
    public String toString(){
        return number + "";
    }
    public int sign(){
        return Integer.signum(number);
    }
}