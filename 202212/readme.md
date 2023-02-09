## Release 02

- Before Xmas (07/12)
- Hasta funciones (T8)

## Cadenas

1. Escribe la función “numeroEspacios” a la que le pasamos una cadena y nos devuelve el número de espacios que contiene esa cadena (tanto al principio y al final como intercalados).

2. Escribe la función “numeroVocales” a la que le pasamos una cadena y nos devuelve el número de vocales que hay en la cadena.

3. Escribe la función “esPalindromo” a la que le pasamos una cadena y nos dice si la cadena es un palíndromo (true) o no (false). Un palíndromo es una palabra o frase que se lee igual al revés que al derecho.

4. Escribe la función “contiene” a la que le pasamos una cadena y un carácter por parámetro y nos dice si el carácter aparece en la cadena o no. Es igual que la función contains. Evidentemente, no podéis usar esta función para hacer la vuestra.

5. Escribe la función “repiteCaracter” a la que le pasamos dos parámetros: un carácter y un entero. La función nos devolverá una cadena que contendrá el carácter repetido tantas veces como indique el entero. Ej.: repiteCaracter(‘A’, 5) = “AAAAA”.

6. Escribe las funciones “padLeft” y “padRight” a las que le pasaremos una cadena y una longitud final. Ambas funciones nos añadirán espacios delante (padLeft) o detrás (padRight) de nuestra cadena hasta que el tamaño de nuestra cadena llega a la longitud que le hemos pasado. Ejemplo: padLeft(“patata”, 10) nos añadirá 4 espacios delante de “patata” para que la longitud final quede 10. El resultado sería “~~~~patata” (~ = espacio). Estas funciones nos serán muy útiles para cuando queramos escribir por pantalla listados y tablas de manera elegante.

7. Escribe la función “quitaEspacios” a la que le pasamos una cadena y nos devuelve la misma cadena, pero con todos los espacios quitados (tanto los del principio como los del final como los intermedios).

8. Escribe la función “quitaEspaciosTrim” a la que le pasamos una cadena y nos devuelve otra cadena igual que la primera en la que se han eliminado los espacios que haya al principio y al final. No se puede utilizar trim, obviamente.

9. Escribe la función “sustituyeCaracter” a la que le pasamos una cadena, un carácter y otro carácter y nos devuelve otra cadena igual que la primera en la que se ha sustituido el primer carácter por el segundo carácter. Ojo, en las cadenas, al contrario que en los arrays, no podemos modificar directamente un valor al estilo de cadena[2] = ‘A’ (los corchetes sólo sirven para leer el valor, no para modificarlo).

10. Escribe la función “cuentaPalabras” a la que le pasamos una cadena que contiene una frase y nos devuelve el número de palabras que hay en la misma.

11. Escribe la función “esNumero”, a la que le pasamos una cadena y nos dice si está formada enteramente por números o no. Esta función es muy interesante para evitarnos errores a la hora de hacer un Scanner.nextInt(). Si queremos leer un número del teclado, lo más correcto es leerlo con un Scanner.next() como si fuera una cadena, después comprobar con la función esNumero si está formado completamente por dígitos y después convertirlo a entero con, por ejemplo, un Integer.parseInt().

12. Escribe la función “quitaCaracter” a la que le pasamos una cadena y un carácter y nos devuelve la cadena, pero con todas las ocurrencias de ese carácter quitadas.

13. Escribe la función “quitaAcentos” a la que le pasas una cadena con caracteres acentuados y te devuelve la cadena con los acentos quitados (esto se hace para algunos programas que no se enteran de los acentos).

14. Escribe la función “invierteCadena” a la que le pasamos una cadena y nos la devuelve invertida (de detrás para delante, vamos).

15. Escribe la función “vecesCaracter” a la que le pasamos una cadena y un carácter y nos dice cuántas veces se repite ese carácter.

16. Escribe la función “vecesPalabra” a la que le pasamos una cadena y una palabra (otra cadena) y nos dice cuántas veces se repite esa palabra en la cadena.

17. Escribe la función “mayusculasPrimera” a la que le pasas una cadena y te devuelve la cadena con la primera letra de cada palabra puesta en mayúsculas.

18. Escribe la función “sustituyePalabra” a la que le pasamos una cadena y dos palabras y nos devuelve otra cadena en la que haya que sustituir la primera por la segunda.

19. Escribe una función “inviertePalabras” a la que la pasamos una cadena y nos devuelve otra en la que están invertidas todas las palabras (no la cadena entera, sino cada palabra independientemente).

20. Escribe la función “quitaEspaciosSobrantes” a la que le pasamos una cadena por parámetro y nos devuelve otra. La cadena que le pasamos podrá tener espacios delante y detrás, además de espacios entre las palabras. Para obtener la cadena resultado, tendremos que quitar los espacios de delante y de detrás y si entre dos palabras hay más de un espacio, deberemos dejar sólo uno. Ej.: “~~~Mi~~mamá~~~~me~mima~~” -> “Mi~mamá~me~mima” (~ = espacio)