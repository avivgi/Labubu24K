package src.bgu.spl.assig1;
public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);
    String toString();
}