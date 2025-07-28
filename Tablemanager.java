package tablemanager;

import java.util.Scanner;

public class Tablemanager {
    public static void main(String[] args) {
        int lugares = 130; // Número de lugares que precisam ser alocados
        ConsultaMesas.Distribuicao distrib = ConsultaMesas.distribuirInteligente(lugares, ConsultaMesas.TOTAL_MESAS_6, ConsultaMesas.TOTAL_MESAS_4, ConsultaMesas.TOTAL_MESAS_2);

        if (distrib != null) {
            ConsultaMesas.salvarDistribuicao(distrib); // Salva a distribuição otimizada
            distrib.imprimir(); 
        } else {
            System.out.println("Distribuição não encontrada.");
        }
        ConsultaMesas.mostrarDistribuicaoPorTipo(1); // Mesas de 6 lugares
        ConsultaMesas.mostrarDistribuicaoPorTipo(2); // Mesas de 4 lugares
        ConsultaMesas.mostrarDistribuicaoPorTipo(3); // Mesas de 2 lugares
    }
}
