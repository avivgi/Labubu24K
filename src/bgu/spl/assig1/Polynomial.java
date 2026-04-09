package src.bgu.spl.assig1;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomials; 

    public Polynomial() {
        this.monomials = new ArrayList<>();
    }

    private Monomial findByExponent(int exponent) {
        for (Monomial m : monomials) {
            if (m.getExponent() == exponent) {
                return m;
            }
        }
        return null;
    }

    public static Polynomial build(String input) {
        Polynomial p = new Polynomial();
        String[] coefficients = input.split("\\s+"); 
        
        for (int i = 0; i < coefficients.length; i++) {
            String val = coefficients[i];
            if (val.equals("0")) continue; 

            Scalar s;
            if (val.contains("/")) {
                String[] parts = val.split("/");
                s = new RationalScalar(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])).reduce();
            } else {
                s = new IntegerScalar(Integer.parseInt(val));
            }
            p.monomials.add(new Monomial(i, s)); 
        }
        return p;
    }

    public Polynomial add(Polynomial p) {
        Polynomial result = new Polynomial();
    
        for (Monomial m : this.monomials) {
            result.monomials.add(new Monomial(m.getExponent(), m.getCoefficient()));
        }
        for (Monomial m : p.monomials) {
            Monomial existing = result.findByExponent(m.getExponent());
            if (existing != null) {        
                int index = result.monomials.indexOf(existing);
                result.monomials.set(index, existing.add(m));
            } else {
                result.monomials.add(new Monomial(m.getExponent(), m.getCoefficient()));
            }
        }
        return result;
    }

    public Scalar evaluate(Scalar s) {
        Scalar total = new IntegerScalar(0);
        for (Monomial m : monomials) {
            total = total.add(m.evaluate(s)); 
        }
        return total;
    }

    public Polynomial derivative() {
        Polynomial result = new Polynomial();
        for (Monomial m : monomials) {
            Monomial d = m.derivative(); 
            if (d.sign() != 0) {
                result.monomials.add(d);
            }
        }
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof Polynomial) { 
            Polynomial other = (Polynomial) o; 
            return this.monomials.size() == other.monomials.size() && 
                   this.monomials.containsAll(other.monomials);
        }
        return false;
    }

    public String toString() {
        if (monomials.isEmpty()) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < monomials.size(); i++) {
            Monomial m = monomials.get(i);
            String mStr = m.toString();
            
            if (i > 0 && m.sign() > 0) sb.append("+");
            sb.append(mStr);
        }
        return sb.toString();
    }
}