public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0);//this value is ignored!
    if (deno == 0){
      nume = 0;
      deno = 1;
    }
    numerator = nume;
    denominator = deno;
    reduce();
  }

  public double getValue(){
    return (double)numerator/(double)denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber n = new RationalNumber(denominator, numerator);
    return n;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if(getDenominator() == 1){
      return "" + getNumerator();
    }
    if (getNumerator() == 0){
      return "" + getNumerator();
    }
    return getNumerator() + "/" + getDenominator();
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    if (a > b){
      while(b > 0){
        int n = b;
        b = a % b;
        a = n;
      }
      return a;
    }
    else{
      while(a > 0){
        int n = a;
        a = b % a;
        b = n;
      }
      return b;
    }
  }


  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    numerator = this.numerator / gcd(numerator, denominator);
    denominator = this.denominator / gcd(numerator, denominator);

  }
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber n = new RationalNumber(this.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
    return n;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int newdeno = this.getDenominator() * other.getDenominator();
    int newnume = this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator();
    RationalNumber n = new RationalNumber(newnume, newdeno);
    return n;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int newdeno = this.getDenominator() * other.getDenominator();
    int newnume = this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator();
    RationalNumber n = new RationalNumber(newnume, newdeno);
    return n;
  }
}
