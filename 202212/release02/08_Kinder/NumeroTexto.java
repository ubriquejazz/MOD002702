public class NumeroTexto {

    public static String numeroTextoUnidad(int n) {
        String result="";
        switch (n) {
            case 1: result="uno"; break;
            case 2: result="dos"; break;
            case 3: result="tres"; break;
            case 4: result="cuatro"; break;
            case 5: result="cinco"; break;
            case 6: result="seis"; break;
            case 7: result="siete"; break;
            case 8: result="ocho"; break;
            case 9: result="nueve"; break;
            default: break;
        }
        return result;
    }  

    public static String numeroTextoDecena(int n) {
        String result="";
        switch (n) {
            case 1: result="diez"; break;
            case 2: result="veinte"; break;
            case 3: result="treinta"; break;
            case 4: result="cuarenta"; break;
            case 5: result="cincuenta"; break;
            case 6: result="sesenta"; break;
            case 7: result="setenta"; break;
            case 8: result="ochenta"; break;
            case 9: result="noventa"; break;
            default: break;
        }
        return result;
    }  

    public static String numeroTexto99(int n) {
        String result="";
        String[] raros = {"once", "doce", "trece", "catorce", "quince"};
        if (n < 10) 
            result = numeroTextoUnidad(n);
        else if (n % 10 == 0)
            result = numeroTextoDecena(n/10);
        else if ((n > 10) && (n < 16))
            result = raros[n-11];
        else if ((n > 15) && (n < 20))
            result = "dieci" + numeroTextoUnidad(n%10);
        else if ((n > 20) && (n < 30))
            result = "venti" + numeroTextoUnidad(n%10);
        else 
            result = numeroTextoDecena(n/10) + " y " + numeroTextoUnidad(n%10);
        return result;
    }  

    public static void main(String[] args) {
        int arr[] ={23, 18, 60, 29, 2, 45, 11, 5};  
        for(int i=0; i < arr.length; i++){  
            System.out.printf("%02d", arr[i]);  
            System.out.println(" - " + numeroTexto99(arr[i]));
        }
    }  
}