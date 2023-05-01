/*
    Camino 1:       1-2-8-10 11-13
    Camino 2:       1-2-3-4-6-7- 2-8-10-11-13
    Camino 3:       1-2-3-4-6-7- 2-8-9-10-11-13
    Camino 4:       1-2-3-5-6-7- 2-8-10-11-13
    Camino 5:       1-2-3-5-6-7- 2-8-10-11-12-13    
*/

/*
    Camino 1:       1-2-8-10 11-13                      num = 0
    Camino 3:       1-2-3-4-6-7- 2-8-9-10-11-13         num = 4, 0
    Camino 5:       1-2-3-5-6-7- 2-8-10-11-12-13        num = -1, 0
*/
public void main() {
    int suma_pos, suma_neg;
    int cont_pos, cont_neg;
    float media_pos, media_neg;
    int num = sc.nextInt() 
    while (num != 0) {          // 1
        if (num >0) {           // 2
            cont_pos++;
            suma_pos += num;
        }
        else {
            cont_neg++;
            suma_neg += num;
        }
        num = sc.nextInt()
    }
    if (cont_pos != 0) {        // 3
        media_pos = (float) suma_pos / cont_pos;
        System.out.println("Media de los positivos es " + media_pos)
    }
    if (cont_neg != 0) {        // 4
        media_neg = (float) suma_neg / cont_neg;
        System.out.println("Media de los negativos es " + media_neg)
    }

}