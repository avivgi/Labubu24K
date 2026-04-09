package src.bgu.spl.assig1;
public class Monomial{
    private int exponent;
    private Scalar coefficient;
    
    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial add(Monomial m){
        if(this.exponent == m.exponent){
            return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
        }
        return null;
    } // same exponent, otherwise null
    public Monomial mul(Monomial m){
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }
    public Scalar evaluate(Scalar s){
        return this.coefficient.mul(s.pow(this.exponent));
    }
    public Monomial derivative(){
        if(this.exponent == 0){
            return new Monomial(0, new Scalar(0));
        }
        return new Monomial(this.exponent - 1, this.coefficient.mul(new Scalar(this.exponent)));
    }
    public int sign(){
        return this.coefficient.sign();
    }
    public boolean equals(Object o){
        if(o instanceof Monomial){
            o = (Monomial) o;
            return this.exponent == o.exponent && this.coefficient.equals(o.coefficient);
        }
        return false;
    }
    public String toString(){
        if(exponent == 0){
            return this.coefficient.toString();
        }
        return this.coefficient.toString() + "x^" + this.exponent;
    }

}