import matplotlib.pyplot as plt
#python -m pip install -U pip
#python -m pip install -U matplotlib

def criar_grafico():
    resultados = []
    
    for i in range(5):
        while True:
            try:
                valor = float(input(f"Digite o {i+1}º valor: "))
                resultados.append(valor)
                break
            except ValueError:
                print("Entrada inválida. Por favor, insira um número válido.")
    
    plt.plot(range(1, 6), resultados, marker='o', linestyle='-', color='b', label='Resultados')
    plt.xlabel("Tentativas")
    plt.ylabel("Valores")
    plt.title("Gráfico de Linha dos Resultados")
    plt.legend()
    plt.grid(True)
    plt.show()

if __name__ == "__main__":
    criar_grafico()