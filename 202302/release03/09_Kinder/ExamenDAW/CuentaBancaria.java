public final class CuentaBancaria {

    private String titular;
    private double saldo;
    private String entidad;
    private String oficina;
    private String numCuenta;
    
    public static final int MAXLENGTH=100;
    public static final int MINLENGTH=10;
    
    /**
     * Método constructor que recibe todos los parámetros requeridos
     * 
     * @param <code>titular</code> Nombre del titular de la cuenta (entre 10 y 100 caracteres)
     * @param <code>entidad</code>Número de la entidad (4 dígitos numéricos)
     * @param <code>oficina</code>Número del código de la oficina (4 dígitos numéricos)
     * @param <code>DC</code>Los dos dígitos de control
     * @param <code>numCuenta</code>Número de la cuenta (10 dígitos numéricos)
     */
    public CuentaBancaria(String titular, String entidad, String oficina, String DC,String numCuenta) {
        /* Comprobamos la longitud de la cadena introducida como titular */
        if(titular.length()<MINLENGTH || titular.length()>MAXLENGTH) 
            System.out.println("Sólo se admiten nombres de titular entre 10 y 100 caracteres");

        /* Comparo lo introducido con el valor numérico que tiene*/
        if(!entidad.equals(String.valueOf(Integer.parseInt(entidad))))
            System.out.println("Número de entidad no válido" + entidad);
        if(!oficina.equals(String.valueOf(Integer.parseInt(oficina))))
            System.out.println("Número de oficina no válido" + oficina);

        /* Hacemos uso del método comprobarCCC para saber si hemos introducido
           un número de cuenta completo y correcto*/
        if(!comprobarCCC(entidad+oficina+DC+numCuenta))
            System.out.println("Codigo Cuenta Cliente no válido");

        /* Comprobamos que los dígitos de control sean correctos*/
        if(!DC.equals(obtenerDigitosControl(entidad,oficina,numCuenta)))
            System.out.println("Dígitos de Control NO válidos");

        /* Si llegamos a este punto podremos crear el objeto*/
        this.titular=titular;
        this.entidad=entidad;
        this.oficina=oficina;
        this.numCuenta=numCuenta;
        this.saldo=0;
    }
    
    public CuentaBancaria(String CCC) {
        this ("Juan M. Gago", CCC.substring(0, 4), CCC.substring(4, 8), CCC.substring(8, 10), CCC.substring(10, 20));
    }

    public void setTitular(String titular) {
        /* Comprobamos la longitud de la cadena introducida como titular */
        if(titular.length()>=MINLENGTH && titular.length()<=MAXLENGTH){ 
            this.titular=titular;
        }else{
            System.out.println("Sólo se admiten nombres de titular entre 10 y 100 caracteres");
        }
    }
    
    public String getTitular(){
        return titular;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public String getEntidad(){
        return entidad;
    }
    
    public String getOficina(){
        return oficina;
    }
    
    public String getNumCuenta(){
        return numCuenta;
    }
    
    /**
     * Método para introducción de cantidades económicas en la cuenta
     * 
     * @param <code>cantidad</code> 
     */
    public void ingresar(double cantidad) {
        if(cantidad>=0){
            saldo+=cantidad;
        }else{
            System.out.println("Sólo se permiten valores positivos");
        }
    }
    
    /**
     * Método que nos permite sacar dinero de la cuenta
     * 
     * @param <code>cantidad</code> 
     */
    public void retirar(double cantidad) {
        if(cantidad>=0){
          if(cantidad<=getSaldo()){
            saldo-=cantidad;
          }else{
            System.out.println("El saldo es inferior a la cantidad a descontar");
          }
        }else{
            System.out.println("Sólo se permiten valores positivos");
        }
    }
    
    /**
     * Comprobamos CCC compuesto por 18 ó 20 dígitos seguidos, ya que los dígitos
     * de control lo calculamos en el método obtenerDigitosControl
     * 
     * @param <code>CCC</code> Cadena de 18 dígitos para los que comprobaremos su validez
     * @return <code>boolean</code> True si es correcto el CCC
     */
    public static boolean comprobarCCC(String CCC){
        boolean si=false;
        int valor;
        CCC=CCC.trim();
        // Comprobamos que se hayan introducido 20 dígitos numéricos
        // Si es así se devuelve 'true' y en caso contrario devolvemos 'false'
        if(CCC.length()==20){
            si=true;
            for(int i=0;i<CCC.length();i++){
                valor=CCC.charAt(i)-48;
                if(valor<0 || valor>10)
                    si=false;
            }
        }
        if(si){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método al que pasamos la entidad, oficina y número de cuenta para poder
     * obtener los dígitos de control de dicha cuenta
     * 
     * @param <code>entidad</code>
     * @param <code>oficina</code>
     * @param <code>numCuenta</code>
     * @return <code>String</code> que contendrá los dos dígitos de control
     */
    public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta) {
        // memorizamos los valores multiplicadores
        int [] numeSerie={1,2,4,8,5,10,9,7,3,6};
        // añadimos dos ceros al principio para poder hacer los cálculos con entidad y oficina
        String entOfi="00"+entidad+oficina;
        // Inicializamos variables a usar
        String nume=numCuenta;
        String DC="";
        int dc1=0;
        int dc2=0;
        // Sumamos cada dígito de entidad y oficina, y numCuenta multiplicados por 
        // el que ocupa su misma posición  de numeSerie
        for(int x=0;x<numeSerie.length;x++){
            dc1+=numeSerie[x]*(entOfi.charAt(x)-48);
            dc2+=numeSerie[x]*(nume.charAt(x)-48);
        }
        // Le restamos a 11 el resto de la división entre el valor obtenido y el número 11
        dc1=11-(dc1%11);
        dc2=11-(dc2%11);
        // Comprobamos si nos ha dado 11 (pondremos 0) ó 10 (pondremos 1)
        dc1=dc1==11?0:dc1==10?1:dc1;
        dc2=dc2==11?0:dc2==10?1:dc2;
        // Unimos los dos valores finales antes de devolver el resultado al método llamante
        DC=String.valueOf(dc1)+String.valueOf(dc2);
        return DC;
    }
    
    /**
     * Método que sobreescribe la función <code>toString</code> para que contenga
     * el titular, el código de la cuenta y el saldo actual.
     * 
     * @return <code>titular</code> CC: <code>numCuenta</code> Saldo: <code>saldo</code>
     */
    public String toString(){
        return titular + " E:" + entidad + " O:" + oficina + " CC:" + numCuenta + " Saldo:" + saldo;

        

    }

}
