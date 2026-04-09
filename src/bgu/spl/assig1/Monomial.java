package src.bgu.spl.assig1;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent == m.exponent) {
            return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
        }
        return null; 
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.mul(s.power(this.exponent));
    }

    public Monomial derivative() {
        if (this.exponent == 0) {
            return new Monomial(0, new IntegerScalar(0));
        }
        Scalar newCoeff = this.coefficient.mul(new IntegerScalar(this.exponent));
        return new Monomial(this.exponent - 1, newCoeff);
    }

    public int sign() {
        return this.coefficient.sign();
    }

    public boolean equals(Object o) {
        if (o instanceof Monomial) {
            Monomial m = (Monomial) o;
            return this.exponent == m.exponent && this.coefficient.equals(m.coefficient);
        }
        return false;
    }

    public String toString() {
        if (exponent == 0) {
            return this.coefficient.toString();
        }
        String coeffStr = this.coefficient.toString();
        
        if (coeffStr.equals("1")) coeffStr = "";
        else if (coeffStr.equals("-1")) coeffStr = "-";

        // Handle exponent of 1 
        if (exponent == 1) {
            return coeffStr + "x";
        }
        return coeffStr + "x^" + this.exponent;
    }
}