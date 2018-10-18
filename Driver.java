public class Driver{
  public static void main(String[] args){
    RealNumber x = new RealNumber(3);
    RealNumber y = new RealNumber(5.0);
    System.out.println(x);
    System.out.println(x.add(y));
    System.out.println(x.multiply(y));
    System.out.println(x.subtract(y));
    System.out.println(x.divide(y));
    System.out.println("______________");
    RationalNumber a = new RationalNumber(2,5);
    RationalNumber b = new RationalNumber(7,8);
    System.out.println(a);
    System.out.println(b);
    System.out.println(a.reciprocal());
    System.out.println(a.add(b));
    System.out.println(a.subtract(b));
    System.out.println(a.divide(b));
    System.out.println(a.multiply(b));

  }
}
