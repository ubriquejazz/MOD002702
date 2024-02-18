public class Ficha {
  private int lado1;
  private int lado2;

  public Ficha(int lado1, int lado2) {
    this.lado1 = lado1;
    this.lado2 = lado2;
  }

  Ficha voltea() {
    return new Ficha(lado2, lado1);
  }

  boolean encaja(Ficha ficha) {
    return (lado1 == ficha.lado1) || (lado1 == ficha.lado2) ||
           (lado2 == ficha.lado1) || (lado2 == ficha.lado2);
  }

  @Override
  public String toString() {
    return "[" + (lado1 == 0 ? " " : lado1) + "|" + (lado2 == 0 ? " " : lado2) + ']';
  }
}
