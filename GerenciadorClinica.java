import java.util.Scanner;

public class GerenciadorClinica {
    private static FilaDeAtendimento fila = new FilaDeAtendimento();
    private static PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();

    public static void adicionarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();

        System.out.println("Digite a idade do paciente:");
        while (!leitor.hasNextInt()) {
            System.out.println("Idade inválida. Por favor, digite um número:");
            leitor.next();
        }
        int idade = leitor.nextInt();
        leitor.nextLine();

        System.out.println("Digite o sintoma do paciente:");
        String sintoma = leitor.nextLine();

        Paciente novoPaciente = new Paciente(nome, idade, sintoma);
        fila.adicionarPaciente(novoPaciente);
        System.out.println("Paciente " + novoPaciente.getNome() + " adicionado à fila.");
    }

    public static void atenderProximo() {
        if (!fila.estaVazia()) {
            Paciente pacienteAtendido = fila.atenderPaciente();
            historico.adicionarAoHistorico(pacienteAtendido);
            System.out.println("Paciente atendido: " + pacienteAtendido.exibirInfo());
        } else {
            System.out.println("Não há pacientes na fila para atendimento.");
        }
    }

    public static Integer menu(Scanner leitor) {
        System.out.println("===============================================");
        System.out.println("1- Adicionar novo paciente à fila");
        System.out.println("2- Atender próximo paciente");
        System.out.println("3- Exibir fila de atendimento");
        System.out.println("4- Exibir histórico de atendimentos");
        System.out.println("0- Sair");
        System.out.println("===============================================");
        System.out.print("Escolha uma opção: ");

        while (!leitor.hasNextInt()) {
            System.out.println("Opção inválida. Digite um número:");
            leitor.next();
        }
        return leitor.nextInt();
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            opcao = menu(leitor);
            leitor.nextLine();

            if (opcao == 1) {
                adicionarPaciente(leitor);
            } else if (opcao == 2) {
                atenderProximo();
            } else if (opcao == 3) {
                fila.mostrarFila();
            } else if (opcao == 4) {
                historico.mostrarHistorico();
            } else if (opcao == 0) {
                System.out.println("Finalizando o programa...");
            } else {
                System.out.println("Opção inválida! Por favor, tente novamente.");
            }
        } while (opcao != 0);

        leitor.close();
    }
}
