import java.util.Random;

public class NossoVetor {
    private int ocupacao;
    private int[] vetor;
    private long comparacoes;
    private long trocas;

    public NossoVetor(int tamanho) {
        vetor = new int[tamanho];
        ocupacao = 0;
        comparacoes = 0;
        trocas = 0;
    }

    public NossoVetor() {
        this(10);
    }

    public boolean estaCheio() {
        return ocupacao == vetor.length;
    }

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    public void insere(int i) {
        if (estaCheio())
            redimensiona(vetor.length * 2);
        vetor[ocupacao++] = i;
    }

    public int getTamanho() {
        return vetor.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("ocupacao = " + ocupacao + "\n");
        for (int i = 0; i < ocupacao; i++) {
            s.append(vetor[i]).append(" ");
        }
        return s.toString();
    }

    public void resetaContadores() {
        comparacoes = 0;
        trocas = 0;
    }

    public int remove() {
        if (estaVazio()) {
            throw new VetorVazioException("Vetor vazio, nao ha o que remover");
        }
        int aux = vetor[--ocupacao];
        if (vetor.length >= 6 && ocupacao <= vetor.length / 4) {
            redimensiona(vetor.length / 2);
        }
        return aux;
    }

    private void redimensiona(int novoTamanho) {
        int[] temp = new int[novoTamanho];
        for (int i = 0; i < ocupacao; i++) {
            temp[i] = vetor[i];
        }
        vetor = temp;
    }

    public void preencheVetor() {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(vetor.length * 10);
        }
        ocupacao = vetor.length;
        comparacoes = 0;
        trocas = 0;
    }

    public boolean contem(int elemento) {
        for (int i = 0; i < ocupacao; i++) {
            comparacoes++;
            if (elemento == vetor[i])
                return true;
        }
        return false;
    }

    public int indiceDe(int elemento) {
        if (estaVazio())
            throw new VetorVazioException("vetor esta vazio");
        for (int i = 0; i < ocupacao; i++) {
            comparacoes++;
            if (elemento == vetor[i])
                return i;
        }
        throw new ElementoNaoEncontradoException("elemento nao encontrado");
    }

    public void bubbleSort() {
        comparacoes = 0;
        trocas = 0;
        for (int i = 1; i < ocupacao; i++) {
            for (int j = 0; j < ocupacao - i; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocas++;
                }
            }
        }
    }

    public void selectionSort() {
        comparacoes = 0;
        trocas = 0;
        for (int i = 0; i < ocupacao - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < ocupacao; ++j) {
                comparacoes++;
                if (vetor[j] < vetor[min])
                    min = j;
            }
            int x = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = x;
            trocas++;
        }
    }

    public void insertionSort() {
        comparacoes = 0;
        trocas = 0;
        for (int j = 1; j < ocupacao; ++j) {
            int x = vetor[j];
            int i;
            for (i = j - 1; i >= 0 && vetor[i] > x; --i) {
                vetor[i + 1] = vetor[i];
                comparacoes++;
                trocas++;
            }
            vetor[i + 1] = x;
        }
    }

    public int buscaLinear(int elemento) {
        for (int i = 0; i < ocupacao; i++) {
            comparacoes++;
            if (vetor[i] == elemento)
                return i;
        }
        return -1;
    }

    public int buscaBinaria(int elemento) {
        int inicio = 0, fim = ocupacao - 1;
        while (inicio <= fim) {
            comparacoes++;
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == elemento)
                return meio;
            if (vetor[meio] < elemento)
                inicio = meio + 1;
            else
                fim = meio - 1;
        }
        return -1;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getTrocas() {
        return trocas;
    }
}

class VetorVazioException extends RuntimeException {
    public VetorVazioException(String msg) {
        super(msg);
    }
}

class ElementoNaoEncontradoException extends RuntimeException {
    public ElementoNaoEncontradoException(String msg) {
        super(msg);
    }
}
