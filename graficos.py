import matplotlib.pyplot as plt

def criar_grafico():
    tamanhos = ['100k', '200k', '400k', '800k', '1.6M']
    operacoes = []

    titulo = input("digite o título do gráfico: ")

    print("insira os valores de operações para os seguintes tamanhos (em bilhões - B):")
    
    for tamanho in tamanhos:
        while True:
            try:
                valor = float(input(f"{tamanho}: "))
                operacoes.append(valor)
                break
            except ValueError:
                print("valor inválido, tente novamente")

    plt.figure(figsize=(12, 6))
    plt.plot(tamanhos, operacoes, marker='o', linestyle='-', color='b', label='total de operações')

    for i, valor in enumerate(operacoes):
        texto = f'{valor:.1f}B'
        plt.text(tamanhos[i], valor, texto, fontsize=10, ha='center', va='bottom')

    plt.title(titulo.lower())
    plt.xlabel('tamanho do vetor')
    plt.ylabel('total de operações (bilhões - B)')
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    criar_grafico()
