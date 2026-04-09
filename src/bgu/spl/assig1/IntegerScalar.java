package src.bgu.spl.assig1;
public class IntegerScalar implements Scalar{
    private int number;
    
    public IntegerScalar(int number){
        this.number = number;
    }
    public Scalar add(Scalar s){

    }
    public Scalar mul(Scalar s){

    }
    public Scalar neg(){

    }
    public Scalar power(int exponent){

    }
    public boolean equals(Object o){

    }
    public String toString(){

    }
    public int sign(){
        return Integer.signum(number);
    }
}