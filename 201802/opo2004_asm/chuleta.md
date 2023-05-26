# Modos de direccionamiento (tema 33)

## Direccionamiento inmediato (Literal to W)
En este modo, el operando es un valor constante o literal que se encuentra directamente en la instrucción. Por ejemplo:

    MOVLW 0x0A   ; Cargar el valor literal 0x0A en el registro W

## Direccionamiento directo (W to file)
En este modo, la dirección del operando se especifica directamente en la instrucción. Por ejemplo, esta instrucción se refiere directamente a una ubicación de memoria específica.

    MOVWF 0x20   ; Mover el contenido de W a la variable en la dirección 0x20
 
## Direccionamiento indirecto (file to W)
En este modo, la dirección del operando se encuentra en un registro. Por ejemplo supongamos que el registro INDF se utiliza como puntero para acceder al dato requerido

    MOVF INDF, W   ; Mover el contenido apuntado por INDF a W
    
MOVF puede combinarse con otros modos de direccionamiento y operaciones para realizar diversas tareas y manipulaciones de datos