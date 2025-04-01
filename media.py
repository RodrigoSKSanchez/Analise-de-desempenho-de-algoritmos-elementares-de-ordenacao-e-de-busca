def calcular_media():
    resultados = []
    
    for i in range(30):
        while True:
            try:
                valor = float(input(f"Digite o {i+1}º valor: "))
                resultados.append(valor)
                break
            except ValueError:
                print("Entrada inválida. Por favor, insira um número válido.")
    
    media = sum(resultados) / len(resultados)
    print(f"A média dos 30 resultados é: {media:.2f}")

if __name__ == "__main__":
    calcular_media()