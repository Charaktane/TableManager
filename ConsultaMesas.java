public class ConsultaMesas {

    public static final int TOTAL_MESAS_6 = 40;
    public static final int TOTAL_MESAS_4 = 40;
    public static final int TOTAL_MESAS_2 = 40;

    public static final int RESERVAS = (10 * 14) + (5 * 20) + (10 * 5) + (10 * 6); // 350

    // Resultado da distribuição otimizada
    private static Distribuicao distribuicaoAtual;

    // Salva a distribuição otimizada
    public static void salvarDistribuicao(Distribuicao dist) {
        distribuicaoAtual = dist;
    }

    // Mostra as mesas disponíveis de acordo com o tipo
    public static void mostrarDistribuicaoPorTipo(int tipoMesa) {
        if (distribuicaoAtual == null) {
            System.out.println("Nenhuma distribuição disponível.");
            return;
        }
        mostrarMesasDisponiveis(tipoMesa);
    }

    // Método genérico para mostrar mesas disponíveis
    private static void mostrarMesasDisponiveis(int tipoMesa) {
        // Arrays que representam as mesas por tipo (6, 4, 2)
        int[] mesas = {distribuicaoAtual.mesas6, distribuicaoAtual.mesas4, distribuicaoAtual.mesas2};
        int[] totais = {TOTAL_MESAS_6, TOTAL_MESAS_4, TOTAL_MESAS_2};

        // Calcula a quantidade de mesas e lugares disponíveis de acordo com o tipo
        int mesasDisp = totais[tipoMesa - 1] - mesas[tipoMesa - 1];
        int lugaresDisp = mesasDisp * (tipoMesa == 1 ? 6 : tipoMesa == 2 ? 4 : 2);

        // Exibe as informações
        System.out.println("Mesas de " + (tipoMesa == 1 ? "6" : tipoMesa == 2 ? "4" : "2") + " lugares disponíveis: " + mesasDisp);
        System.out.println("Lugares disponíveis nesse tipo: " + lugaresDisp);
    }

    // Classe interna para guardar a melhor distribuição
    public static class Distribuicao {
        public int mesas6, mesas4, mesas2;
        public int lugaresOcupados, lugaresRestando;

        public void imprimir() {
            System.out.println("----------------------------------");
            System.out.println("Distribuição ideal:");
            System.out.println("- Mesas de 6 lugares: " + mesas6);
            System.out.println("- Mesas de 4 lugares: " + mesas4);
            System.out.println("- Mesas de 2 lugares: " + mesas2);
            System.out.println("Lugares ocupados: " + lugaresOcupados);
            System.out.println("Lugares sobrando: " + lugaresRestando);
            System.out.println("----------------------------------");
        }
    }

    // Distribuição inteligente
    public static Distribuicao distribuirInteligente(int lugares, int max6, int max4, int max2) {
        Distribuicao melhor = null;

        // Busca pela distribuição otimizada
        for (int m6 = 0; m6 <= Math.min(max6, lugares / 6); m6++) {
            for (int m4 = 0; m4 <= Math.min(max4, (lugares - m6 * 6) / 4); m4++) {
                for (int m2 = 0; m2 <= Math.min(max2, (lugares - m6 * 6 - m4 * 4) / 2); m2++) {
                    int usados = m6 * 6 + m4 * 4 + m2 * 2;
                    int sobra = lugares - usados;

                    // Se a distribuição for exata, verifica se é a melhor distribuição
                    if (sobra == 0 && (melhor == null || (m6 + m4 + m2) < (melhor.mesas6 + melhor.mesas4 + melhor.mesas2))) {
                        melhor = new Distribuicao();
                        melhor.mesas6 = m6;
                        melhor.mesas4 = m4;
                        melhor.mesas2 = m2;
                        melhor.lugaresOcupados = usados;
                        melhor.lugaresRestando = sobra;
                    }
                }
            }
        }

        return melhor;
    }
}
