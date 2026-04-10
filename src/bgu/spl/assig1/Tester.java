package src.bgu.spl.assig1;

public class Tester {
    public static void main(String[] args) {
        System.out.println("--- Starting Manual Tests ---");

        // 1. IntegerScalar Tests
        System.out.println("\n[1] Testing IntegerScalar:");
        Scalar i1 = new IntegerScalar(10);
        Scalar i2 = new IntegerScalar(-3);
        System.out.println("Add: 10 + (-3) | Expected: 7 | Actual: " + i1.add(i2));
        System.out.println("Mul: 10 * (-3) | Expected: -30 | Actual: " + i1.mul(i2));
        System.out.println("Neg: -10 | Expected: -10 | Actual: " + i1.neg());
        System.out.println("Power: 10^2 | Expected: 100 | Actual: " + i1.power(2));
        System.out.println("Sign: 10 | Expected: 1 | Actual: " + i1.sign());
        System.out.println("Equals: 10 == 10 | Expected: true | Actual: " + i1.equals(new IntegerScalar(10)));

        // 2. RationalScalar Tests
        System.out.println("\n[2] Testing RationalScalar:");
        Scalar r1 = new RationalScalar(1, 2);
        Scalar r2 = new RationalScalar(1, 3);
        Scalar r3 = new RationalScalar(1, 2);
        System.out.println("Add: 1/2 + 1/3 | Expected: 5/6 | Actual: " + r1.add(r2));
        System.out.println("Mul: 1/2 * 1/3 | Expected: 1/6 | Actual: " + r1.mul(r2));
        System.out.println("Neg: -1/2 | Expected: -1/2 | Actual: " + r1.neg());
        System.out.println("Power: (1/2)^3 | Expected: 1/8 | Actual: " + r1.power(3));
        System.out.println("Sign: 1/2 | Expected: 1 | Actual: " + r1.sign());
        System.out.println("Equals: 1/2 == 2/4 | Expected: true | Actual: " + r3.equals(new RationalScalar(2, 4)));

        System.out.println("Reduction: 12/-4 | Expected: -3 | Actual: " + new RationalScalar(12, -4).reduce());
        System.out.println("Reduction: -12/-5 | Expected: 12/5 | Actual: " + new RationalScalar(-12, -5).reduce());
        System.out.println("Reduction: 12/-8 | Expected: -3/2 | Actual: " + new RationalScalar(12, -8).reduce());

        // 3. Monomial Tests
        System.out.println("\n[3] Testing Monomials:");
        Monomial m1 = new Monomial(2, new IntegerScalar(3)); // 3x^2
        Monomial m2 = new Monomial(2, new IntegerScalar(4)); // 4x^2
        Monomial m3 = new Monomial(1, new IntegerScalar(2)); // 2x
        
        System.out.println("Add (same exp): 3x^2 + 4x^2 | Expected: 7x^2 | Actual: " + m1.add(m2));
        System.out.println("Add (diff exp): 3x^2 + 2x | Expected: null | Actual: " + m1.add(m3));
        System.out.println("Mul: 3x^2 * 2x | Expected: 6x^3 | Actual: " + m1.mul(m3));
        System.out.println("Evaluate: 3x^2 at x=2 | Expected: 12 | Actual: " + m1.evaluate(new IntegerScalar(2)));
        System.out.println("Derivative: d/dx(3x^2) | Expected: 6x | Actual: " + m1.derivative());
        System.out.println("Sign: 3x^2 | Expected: 1 | Actual: " + m1.sign());
        System.out.println("Equals: 3x^2 == 3x^2 | Expected: true | Actual: " + m1.equals(new Monomial(2, new IntegerScalar(3))));

        System.out.println("Format: 1x^3 | Expected: x^3 | Actual: " + new Monomial(3, new IntegerScalar(1)));
        System.out.println("Format: 4x^1 | Expected: 4x | Actual: " + new Monomial(1, new IntegerScalar(4)));
        System.out.println("Format: -1x^7 | Expected: -x^7 | Actual: " + new Monomial(7, new IntegerScalar(-1)));

        // 4. Polynomial Tests
        System.out.println("\n[4] Testing Polynomials:");
        Polynomial p1 = Polynomial.build("1 2 3"); // 1+2x+3x^2
        Polynomial p2 = Polynomial.build("0 1 1"); // x+x^2
        
        System.out.println("Build: 1 2 3 | Expected: 1+2x+3x^2 | Actual: " + p1);
        System.out.println("Build with Rationals: 0 1/2 -5/3 | Expected: 1/2x-5/3x^2 | Actual: " + Polynomial.build("0 1/2 -5/3"));
        System.out.println("Add: (1+2x+3x^2) + (x+x^2) | Expected: 1+3x+4x^2 | Actual: " + p1.add(p2));
        System.out.println("Mul: (1+x) * (2) | Expected: 2+2x | Actual: " + Polynomial.build("1 1").mul(Polynomial.build("2")));
        System.out.println("Evaluate: 1+2x+3x^2 at x=2 | Expected: 17 | Actual: " + p1.evaluate(new IntegerScalar(2)));
        System.out.println("Derivative: d/dx(1+2x+3x^2) | Expected: 2+6x | Actual: " + p1.derivative());
        System.out.println("Equals: p1 == p1 | Expected: true | Actual: " + p1.equals(Polynomial.build("1 2 3")));

        System.out.println("\n--- Tests Complete ---");
    }
}