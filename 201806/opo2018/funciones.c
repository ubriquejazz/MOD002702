#include <stdio.h>
#include "funciones.h"

char lut[] = "+-*/^"; // look up table

void mostrarResultado(int op, int n1, int n2, int r) {
  printf("%d %c %d = %d\n\n", n1, lut[op-1], n2, r);
}  

void mostrarMenu(){
  printf("RESOLUCIÓN DEL EXAMEN DE OPOS 2018\n");
  printf("-----------------------------------\n");
  printf("\tPulse 1 para sumar: \n");
  printf("\tPulse 2 para restar: \n");
  printf("\tPulse 3 para multiplicar: \n");
  printf("\tPulse 4 para dividir: \n");
  printf("\tPulse 5 para intercambiar variables: \n");
  printf("\tPulse 6 para salir: \n");
  printf("Seleccione opción: ");
}

void leer(int *n) {
  scanf("%d",n);
}

int leer2() {
  int n;
  leer(&n);
  while(n==0) {
    printf("Divisor no puede ser cero, repite: ");
    leer(&n);
  }
  return n;
}

int leerOpcion(){
  int op;
  scanf("%d",&op);
  while(op<1 || op>7){
    printf("Mal (debe estar entre 1 y 6), repite: ");
    leer(&op);
  }
  return op;
}

int gestionarOpcion() {
  mostrarMenu();
  return leerOpcion();
}

// Operaciones simples

void sumar(int n1, int n2, int *r){
  *r = n1+n2;
}

void restar(int n1, int n2, int *r){
  *r = n1-n2;
}

void intercambiar(int* a, int* b){
//  printf("\n\t%d\n",a);
//  printf("\n\t%d\n",*a);
  int aux;
  aux = *a;
  *a = *b;
  *b=aux;
}

int compruebaSigno(int x, int *positivo) {
  int signo = 1;
  *positivo = x;
  if(x<0) {
    signo = -1;
    *positivo = 0-x;
  }
  return signo;
}

// Operaciones usando las operaciones anteriores

int multiplicar(int n1, int n2) {
  int i, a, b, resultado = 0;
  int signo1 = compruebaSigno(n1, &a);
  int signo2 = compruebaSigno(n2, &b);

  for(int i=0;i<b;i++){
    resultado = resultado + a;
  }
  if(signo1!=signo2)
    resultado = 0-resultado;
  return resultado;
}

int dividir(int n1, int n2) {
  int a, b, resultado = 0;
  int signo1 = compruebaSigno(n1, &a);
  int signo2 = compruebaSigno(n2, &b);

  while(a>=b){
    resultado++;
    a = a - b;
  }
  if(signo1!=signo2)
    resultado = 0-resultado;
  return resultado;
}

void calcularOperacion(int op, int *n1, int *n2, int *r) 
{
  printf("Introduzca el primer operando: ");
  leer(n1);
  printf("Introduzca el segundo operando: ");
  if (op == 4) // en caso de division op vale 4
    *n2 = leer2();  
  else 
    leer(n2);

  switch(op){
    case 1:
      sumar(*n1, *n2, r);
      break;
    case 2:
      restar(*n1, *n2, r);
      break;
    case 3:
      *r = multiplicar(*n1, *n2);
      break;
    case 4:
      *r = dividir(*n1, *n2);
      break;
    default:
      intercambiar(n1,n2);
      *r = 0; // sin sentido cuando intercambio operandos
    }      
}
