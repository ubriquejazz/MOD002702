public class CompruebaMail {

    public static boolean compruebaMail(String s){
        int i, cuentaarroba = 0;
        System.out.println(">> " + s);
        if(s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.' || s.charAt(0) == '@' || s.charAt(s.length() - 1) == '@' || s.charAt(0) == '-' || s.charAt(s.length() - 1) == '-'){
            System.out.println("ERROR: Tienes un punto, un arroba o un guión al principio o al final del email.");
            return false;
        }
        for(i = 0; i < s.length(); i++){

            if(s.charAt(i) == '@') {
                cuentaarroba++;
            }
            if(s.charAt(i) == ' '){
                System.out.println("ERROR: Tu email contiene espacios.");
                return false;
            }
            if(s.charAt(i) == '.' && s.charAt(i + 1) == '.'){
                System.out.println("ERROR: Tu email tiene dos puntos seguidos.");
                return false;
            }
            if(s.charAt(i) == 'ñ'){
                System.out.println("ERROR: Tu email contiene la letra 'ñ'.");
                return false;
            }
        }
        if(cuentaarroba != 1){
            System.out.println("ERROR: Tu email tiene cero o mas de una arroba.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // args[0].trim();
        String[] list = {
                "very.common@example.com",
                "esto no es un email",
                "adñmin@mailserver1",
                ".very.common@example.com-",
                "very..common@example.com",
                "verycommonexample.com"};
        for (String myString : list)
            if (compruebaMail(myString)) System.out.println(myString + " es ok");
    }  
}