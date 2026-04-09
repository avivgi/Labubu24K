package src.bgu.spl.assig1;

public class IntegerScalar implements Scalar {
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    public Scalar addInteger(IntegerScalar s) {
        return new IntegerScalar(this.number + s.getNumber());
    }

    public Scalar addRational(RationalScalar s) {
        int newNumerator = this.number * s.getDenominator() + s.getNumerator();
        return new RationalScalar(newNumerator, s.getDenominator()).reduce();
    }
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(this.number * s.getNumber());
    }

    
    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator()).reduce();
    }

    public Scalar neg() {
        return new IntegerScalar(-number);
    }

    public Scalar power(int exponent) {
        return new IntegerScalar((int) Math.pow(number, exponent));
    }

    public int sign() {
        return Integer.signum(number);
    }

    public boolean equals(Object o) {
        if (o instanceof Scalar) {
            return this.toString().equals(o.toString());
        }
        return false;
    }

    
    public String toString() {
        return "" + number;
    }
}