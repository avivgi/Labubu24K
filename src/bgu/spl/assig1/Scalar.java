package src.bgu.spl.assig1;
public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);
    String toString();
        //helper methods to avoid casting
    Scalar addInteger(IntegerScalar s);
    Scalar addRational(RationalScalar s);
    Scalar mulInteger(IntegerScalar s);
    Scalar mulRational(RationalScalar s);
}