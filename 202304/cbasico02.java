/*
    Camino 1:   1-2-7-9-10          num=1
    Camino 2:   1-2-3-4-5-2-7-8-10  num=2
    Camino 3:   1-2-3-5-2-7-9-10    num=3
    Camino 4:   1-2-7-8-10          num=0
    
*/

public void main() {
    int sumadivisores = 0;
    int divisor = 1
    int num = sc.nextInt() 
    while (divisor <= num/2) {
        if (num % divisor == 0) {
            sumadivisores += divisor;
        }
        divisor++
    }
    if (num == sumadivisores) {
        System.out.println(num + " es un numero perfecto")
    }
    else {        
        System.out.println(num + " no es un numero perfecto")
    }
}