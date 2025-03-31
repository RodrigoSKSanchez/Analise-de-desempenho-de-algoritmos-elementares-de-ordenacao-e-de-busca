import java.util.Date;
import java.util.Scanner;

public class TesteOrdenacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tamanhos de vetores a serem testados
        int[] tamanhos = {100_000, 200_000, 400_000, 800_000, 1_600_000};

        // Número de repetições para reduzir flutuações
        int repeticoes = 3;

        for (int tamanho : tamanhos) {
            System.out.println("\n➡ Testando com vetor de tamanho: " + tamanho);

            for (int i = 0; i < repeticoes; i++) {
                System.out.println("\n🔄 Execução " + (i + 1) + " de " + repeticoes);

                NossoVetor v = new NossoVetor(tamanho);
                v.preencheVetor();

                // Testando Bubble Sort
                v.resetaContadores();
                long ini = new Date().getTime();
                v.bubbleSort();
                long fim = new Date().getTime();
                System.out.println("Bubble Sort - Tempo: " + (fim - ini) + "ms, Comparações/Trocas: " + v.getComparacoes() + "/" + v.getTrocas());

                // Testando Selection Sort
                v.preencheVetor();
                v.resetaContadores();
                ini = new Date().getTime();
                v.selectionSort();
                fim = new Date().getTime();
                System.out.println("Selection Sort - Tempo: " + (fim - ini) + "ms, Comparações/Trocas: " + v.getComparacoes() + "/" + v.getTrocas());

                // Testando Insertion Sort
                v.preencheVetor();
                v.resetaContadores();
                ini = new Date().getTime();
                v.insertionSort();
                fim = new Date().getTime();
                System.out.println("Insertion Sort - Tempo: " + (fim - ini) + "ms, Comparações/Trocas: " + v.getComparacoes() + "/" + v.getTrocas());

                // Testando Busca Linear
                v.resetaContadores();
                ini = new Date().getTime();
                fim = new Date().getTime();
                System.out.println("Busca Linear - Tempo: " + (fim - ini) + "ms, Comparações: " + v.getComparacoes());

                // Testando Busca Binária (após ordenação)
                v.resetaContadores();
                ini = new Date().getTime();
                fim = new Date().getTime();
                System.out.println("Busca Binária - Tempo: " + (fim - ini) + "ms, Comparações: " + v.getComparacoes());
            }
        }

        scanner.close();
    }
}
