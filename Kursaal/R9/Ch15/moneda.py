class Moneda:
    def __init__(self, simbolo, decimales, cambio_euros):
        self.simbolo = simbolo
        self.decimales = decimales
        self.cambio_euros = cambio_euros

    def __str__(self):
        return f"Moneda: {self.simbolo}\nDecimales: {self.decimales}\nCambio en euros: {self.cambio_euros}"

# Ejemplo de uso
if __name__ == "__main__":
    euro = Moneda("EUR", 2, 1.0)
    dolar = Moneda("USD", 2, 0.85)
    libra = Moneda("GBP", 2, 1.18)

    print("Información sobre el euro:")
    print(euro)

    print("\nInformación sobre el dólar:")
    print(dolar)

    print("\nInformación sobre la libra esterlina:")
    print(libra)
