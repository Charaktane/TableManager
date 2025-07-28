public class Tablemanager {
    public static void main(String[] args) {
        // Dados fornecidos
        final int TOTAL_MESAS_6 = 40; // 40 mesas de 6 lugares
        final int TOTAL_MESAS_4 = 40; // 40 mesas de 4 lugares
        final int TOTAL_MESAS_2 = 40; // 40 mesas de 2 lugares

        // Reservas fixas
        final int RESERVAS = (10 * 14) + (5 * 20) + (10 * 5) + (10 * 6); // 350 lugares reservados

        // Calculando a capacidade total de lugares
        int totalLugares = TOTAL_MESAS_6 * 6 + TOTAL_MESAS_4 * 4 + TOTAL_MESAS_2 * 2; // Total de 480 lugares
        int lugaresDisponiveis = totalLugares - RESERVAS; // Lugares disponíveis após subtrair as reservas

        System.out.println("----------------------------------");
        System.out.println("Capacidade total de lugares: " + totalLugares);
        System.out.println("----------------------------------");
        System.out.println("Lugares ocupados por reservas: " + RESERVAS);
        System.out.println("----------------------------------");
        System.out.println("Lugares restantes para alocar: " + lugaresDisponiveis);
        System.out.println("----------------------------------");

        // Realiza a distribuição inteligente dos lugares restantes
        ConsultaMesas.Distribuicao distrib = ConsultaMesas.distribuirInteligente(lugaresDisponiveis, TOTAL_MESAS_6, TOTAL_MESAS_4, TOTAL_MESAS_2);

        if (distrib != null) {
            // Salva a distribuição otimizada e exibe os detalhes
            ConsultaMesas.salvarDistribuicao(distrib);

            System.out.println("\nDistribuição otimizada encontrada:");
            distrib.imprimir();
        } else {
            System.out.println("Distribuição não encontrada. Verifique os dados de entrada.");
        }

        // Exibe a quantidade de mesas disponíveis de cada tipo
        System.out.println("\nDistribuição das mesas restantes por tipo:");
        ConsultaMesas.mostrarDistribuicaoPorTipo(1); // Mesas de 6 lugares
        System.out.println("----------------------------------");
        ConsultaMesas.mostrarDistribuicaoPorTipo(2); // Mesas de 4 lugares
        System.out.println("----------------------------------");
        ConsultaMesas.mostrarDistribuicaoPorTipo(3); // Mesas de 2 lugares
        System.out.println("----------------------------------");

    }
}
