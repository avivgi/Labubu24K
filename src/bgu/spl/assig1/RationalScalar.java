package src.bgu.spl.assig1;
public class RationalScalar implements Scalar{
    private int numerator;
    private int denominator;
    
    public RationalScalar(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public Scalar add(Scalar s) {
        return s.addRational(this);
    }
    public Scalar addRational(RationalScalar s) {
        int newNum = s.getNumerator() * this.denominator + this.numerator * s.getDenominator();
        int newDen = s.getDenominator() * this.denominator;
        return new RationalScalar(newNum, newDen).reduce();
    }
    public Scalar addInteger(IntegerScalar s) {
        int newNum = s.getNumber() * this.denominator + this.numerator;
        return new RationalScalar(newNum, this.denominator).reduce();
    }
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.numerator * s.getNumerator(), 
                                 this.denominator * s.getDenominator()).reduce();
    }
    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new RationalScalar(this.numerator * s.getNumber(), this.denominator).reduce();
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
        if(o instanceof RationalScalar){
            RationalScalar r = (RationalScalar) o;
            reduce();
            r.reduce();            
            return this.numerator == r.numerator && this.denominator == r.denominator;
        }        
        return false;
    }
    public String toString(){
        if(numerator%denominator == 0){
            reduce();
            return (numerator/denominator) + "";
        }
        if(numerator<0 &&denominator < 0){
            return numerator*-1 + "/" + denominator*-1;
        }
        else if(numerator < 0 || denominator < 0){
            return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
        }
        return numerator + "/" + denominator;
    }
    public int sign(){
        return Integer.signum(numerator) * Integer.signum(denominator);
    }
    public Scalar reduce() {
    int n = Math.abs(this.numerator);
    int d = Math.abs(this.denominator);
    
    while (d != 0) {
        int temp = d;
        d = n % d;
        n = temp;
    }
    int gcd = n;
    this.numerator /= gcd;
    this.denominator /= gcd;
    if (this.denominator < 0) {
        this.numerator = -this.numerator;
        this.denominator = -this.denominator;
    }
    if (this.denominator == 1) {
        return new IntegerScalar(this.numerator);
    }
    return this;
}
}