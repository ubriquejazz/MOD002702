class TresEnRaya:
    def __init__(self, jugador):
        self.jugador = jugador

    def __str__(self):
        return f"Nombre del jugador: {self.jugador}"

# Ejemplo de uso
if __name__ == "__main__":
    partida = TresEnRaya("Juan")
    print(partida);