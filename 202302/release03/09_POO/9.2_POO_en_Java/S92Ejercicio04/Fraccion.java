public class Fraccion {
  
  private int signo;
  private int numerador;
  private int denominador;
  
  public Fraccion(int n, int d) {
    if (d == 0) {
      // mejor una excepcion
      System.out.println("Una fracción no puede tener como denominador el número 0");
    } 
    else {
      if (n * d < 0) {
        this.signo = -1;
      } else {
        this.signo = 1;
      }
      this.numerador = Math.abs(n);
      this.denominador = Math.abs(d);
    }
  }

  public Fraccion(int n) {
    this(n, 1);
  }

  public Fraccion(double n) {
    this(1, 1);
    if (n < 0)
      this.signo = -1;
    int cont = 0;
    while (n != (int)n && (cont < 10)) {
      System.out.println(cont + " n: " + n);
      n *= 10.0; 
      cont++;
      this.denominador *= 10;    
    }    
    this.numerador = (int)n;
    int mcd = maximoComunDivisor(this.numerador, this.denominador);
    this.numerador /= mcd;
    this.denominador /= mcd;
  }

  int getNumerador(){
    return this.numerador;
  }
  
  int getDenominador(){
    return this.denominador;
  }
  
  int getSigno(){
    return this.signo;
  }

  public String toString() {
    if (signo == -1) {
      return "-" + this.numerador + "/" + this.denominador;
    } else {
      return this.numerador + "/" + this.denominador;
    }
  }

  /**
   * Devuelve una fracción invertida. Lo que antes era el numerador
   * ahora será el denominador y viceversa.
   * 
   * @return fracción invertida
   */
  public Fraccion invierte() {
    return new Fraccion(this.signo * this.denominador, this.numerador);
  }
  
  /**
   * Devuelve una fracción multiplicada por un escalar (un número)
   * <code>n</code>.
   * <p>
   * Cuando una fracción se multiplica por un número <code>n</code>, el
   * resultado es otra fracción con el mismo denominador que la
   * original.
   * El numerador se obtiene multiplicando <code>n</code> por el
   * numerador de la fracción original.
   * 
   * @param n escalar por el que se multiplica la fracción original
   * @return  fracción multiplicada por <code>n</code>
   */
  public Fraccion multiplica(int n)  {
    return new Fraccion(n * this.signo * this.numerador, this.denominador);
  }

  /**
   * Devuelve una fracción que es el resultado de multiplicar la
   * fracción original por otra fracción que se pasa como parámetro.
   * <p>
   * Cuando se multiplican dos fracciones, el numerador de la fracción
   * resultante es el resultado de multiplicar los numeradores de las
   * dos fracciones. El denominador de la fracción resultante se calcula
   * de forma análoga.
   * 
   * @param f fracción por la que se multiplica la fracción original
   * @return  resultado de multiplicar la fracción original por la
   *          fracción que se pasa como parámetro
   */
  public Fraccion multiplica(Fraccion f) {
    int miSigno = this.signo * f.getSigno();
    int miNum = this.numerador * f.getNumerador();
    int miDen = this.denominador * f.getDenominador();
    return new Fraccion(miSigno * miNum, miDen);
  }

  /**
   * Devuelve una fracción dividida entre un escalar (un número) <code>n
   * </code>.
   * <p>
   * Cuando una fracción se divide entre un número <code>n</code>, el
   * resultado es otra fracción con el mismo numerador que la original.
   * El denominador se obtiene multiplicando <code>n</code> por el
   * denominador de la fracción original.
   * 
   * @param n escalar entre el que se divide la fracción original
   * @return  fracción dividida entre <code>n</code>
   */
  public Fraccion divide(int n) {
    return new Fraccion(this.signo * this.numerador, this.denominador * n);
  }

  /**
   * Devuelve una fracción que es el resultado de dividir la fracción
   * original entre otra fracción que se pasa como parámetro.
   * <p>
   * Para obtener la división de dos fracciones, el numerador de una
   * fracción se multiplica por el denominador de otra y viceversa.
   * 
   * @param f fracción entre la que se quiere dividir la fracción
   *          original
   * @return  resultado de dividir la fracción original entre la
   *          fracción que se pasa como parámetro
   */
  public Fraccion divide2(Fraccion f) {
    return new Fraccion(
      this.signo * this.numerador * f.getDenominador(),
      this.denominador * f.getNumerador());
  }

  public Fraccion divide(Fraccion f) {
    Fraccion f2 = new Fraccion(1,1);
    f2.signo = this.signo * f.getSigno();
    f2.numerador = this.numerador * f.getDenominador();
    f2.denominador = this.denominador * f.getNumerador();
    return f2;
  }

  /**
   * Devuelve una fracción que es el resultado de simplificar la
   * fracción original.
   * <p>
   * Para simplificar una fracción, se comprueba si numerador y
   * denominador son divisibles entre el mismo número. En tal caso, los
   * dos se dividen. Se repite el proceso hasta que la fracción que se
   * obtiene es irreducible (no se puede simplificar más).
   * 
   * @return  resultado de simplificar (si se puede) la fracción
   *          original, o la misma fracción en caso de que la original
   *          sea irreducible
   */
  public Fraccion simplifica2() {    
    final int s = this.signo;
    int n = this.numerador;
    int d = this.denominador;      
    for (int i = 2; i <= Math.min(this.numerador, this.denominador); i++) {
      if ( n%i == 0 && d%i == 0 ) {
        n /= i;
        d /= i;
      }
    }
    return new Fraccion(s * n, d);
  }

  public Fraccion simplifica() {
    Fraccion f2 = new Fraccion(1,1);
    int mcd = maximoComunDivisor(this.numerador, this.denominador);
    // System.out.println(mcd);
    f2.numerador /= mcd;
    f2.denominador /= mcd;
    return f2;
  }

  /**
   * Devuelve el maximo comun divisor de dos numeros.
   * Devuelve el minimo comun multiplo de dos numeros.
   * @return  mcm o MCD
   */
  private int maximoComunDivisor2(int a, int b) {
    if (a == 0) 
      return a;
    int retVal = 1;
    for (int i = 2; i <= Math.min(a, b); i++) {
      if ( a%i == 0 && b%i == 0 ) {
        a /= i;
        b /= i;        
        retVal *= i;
      }
    }
    return retVal;
  }
  private int minimoComunMultiplo(int a, int b) {
    if (a == 0) 
      return a;
    return a * b / maximoComunDivisor(a, b);
  }
  private int maximoComunDivisor(int a, int b) {
    if (a == 0) 
      return a;
    int c;
    while (a != 0) {
      c = b%a;
      b = a;
      a = c;
    }
    return b;
  }
}
