package src.bgu.spl.assig1;
public class RationalScalar implements Scalar{
    private int numerator;
    private int denominator;
    
    public RationalScalar(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Scalar add(Scalar s){

    }
    public Scalar mul(Scalar s){

    }
    public Scalar neg(){
            this.numerator = -this.numerator;
            return this;
    }
    public Scalar power(int exponent){
        this.numerator = (int) Math.pow(this.numerator, exponent);
        this.denominator = (int) Math.pow(this.denominator, exponent);
        return this;
    }
    public boolean equals(Object o){

    }
    public String toString(){
        
    }
    public int sign(){
        return Integer.signum(numerator) * Integer.signum(denominator);
    }
    public Scalar reduce(){

    }
}