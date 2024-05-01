import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDateTime;

public class RestauranteMain {
    static void clear() { // Limpa a tela do console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean nomeValido(String nome) {
        if (nome == null || nome.isEmpty() || !Pattern.compile("[a-zA-Z ]*").matcher(nome).matches())
            return false;

        return true;
    }

    public static String formatarNome(String nome) {
        nome = nome.trim();// Remove espaços extras no início e no fim

        String[] palavras = nome.split(" "); // Separa o nome de usuário em palavras

        StringBuilder nomeFormatado = new StringBuilder(); // Construtor para o nome de usuário formatado

        for (int i = 0; i < palavras.length; i++) {
            if (i == 0 || Character.isSpaceChar(palavras[i - 1].charAt(palavras[i - 1].length() - 1))) { // Verifica se
                                                                                                         // é a primeira
                                                                                                         // palavra ou
                                                                                                         // após um
                                                                                                         // espaço
                nomeFormatado.append(palavras[i].substring(0, 1).toUpperCase())
                        .append(palavras[i].substring(1).toLowerCase());
            } else {
                nomeFormatado.append(palavras[i].toLowerCase());
            }
        }

        String formatado = nomeFormatado.toString().replaceAll(" +", " "); // Remove espaços extras entre palavras

        return formatado;
    }

    public static void main(String[] args) throws Exception {
        clear();
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();

        for (int i = 0; i < 4; i++) {
            Mesa mesa = new Mesa(4);
            mesas.add(mesa);
        }

        for (int i = 0; i < 4; i++) {
            Mesa mesa = new Mesa(6);
            mesas.add(mesa);
        }

        for (int i = 0; i < 2; i++) {
            Mesa mesa = new Mesa(8);
            mesas.add(mesa);
        }

        Restaurante restaurante = new Restaurante(mesas);

        Scanner leitor = new Scanner(System.in);
        String escolha;

        System.out.println("Gerenciamento do restaurante À La Classe");

        do {
            System.out.println("\nOpções:");
            System.out.println(
                    "\n1) Iniciar atendimento\n\n2) Encerrar atendimento\n\n3) Exibir mesas disponíveis\n\n4) Exibir lista de espera\n\n5) Remover atendimento da lista de espera\n\n0) Sair");
            System.out.print("\nPor favor, selecione uma opção: ");
            escolha = leitor.nextLine();
            clear();
            switch (escolha) {
                case "1":
                    do {
                        System.out.print("\nInforme o nome do cliente: ");
                        escolha = leitor.nextLine();

                        if (!nomeValido(escolha)) {

                            System.out.println("Nome inválido. Por favor, tente novamente.");
                        }
                    } while (!nomeValido(escolha));

                    Cliente cliente = new Cliente(formatarNome(escolha));

                    System.out.println("Cadastro realizado com sucesso.");
                    clear();

                    int quantPessoas = 0;

                    do {
                        System.out.print("\nInforme a quantidade de pessoas da atendimento: ");
                        quantPessoas = leitor.nextInt();
                        leitor.nextLine();

                        if (quantPessoas > 0) {
                            clear();
                        } else {
                            clear();
                            System.out.println("Entrada inválida.");
                        }
                    } while (quantPessoas < 1);

                    Atendimento atendimento = new Atendimento(cliente, quantPessoas, LocalDateTime.now());

                    if (restaurante.fazReservaDeMesa(atendimento)) {
                        System.out.println(
                                "Há uma mesa disponível!");
                    } else {
                        restaurante.adicionaFilaDeEspera(atendimento);
                        System.out.println(
                                "Não há mesas disponíveis no momento - o cliente foi adicionado à fila de espera.");
                    }
                    break;
                case "2":
                    restaurante.exibeAtendimentos();

                    if (restaurante.quantidadeAtendimentos() > 0) {
                        System.out.print("Qual cliente você deseja encerrar o atendimento: ");

                        int indice;
                        do {
                            indice = leitor.nextInt();
                            leitor.nextLine();
                            if (indice < 1 || indice > restaurante.quantidadeAtendimentos()) {
                                System.out.print("\nValor inválido! Digite um valor válido: ");
                            }
                        } while (indice < 1 || indice > restaurante.quantidadeAtendimentos());

                        Atendimento reservaEscolhida = restaurante.getAtendimentos().get(indice - 1);
                        reservaEscolhida.setDataHoraSaida(LocalDateTime.now());
                        restaurante.removeReserva(reservaEscolhida);
                    }
                    break;
                case "3":
                    restaurante.exibeMesasDisponiveis();
                    break;
                case "4":
                    restaurante.exibeFilaDeEspera();
                    break;
                case "5":
                    restaurante.exibeFilaDeEspera();

                    if (restaurante.quantidadeFilaDeEspera() > 0) {
                        System.out.print("Qual cliente você deseja cancelar a atendimento: ");

                        int indice;
                        do {
                            indice = leitor.nextInt();
                            leitor.nextLine();
                            if (indice < 1 || indice > restaurante.quantidadeFilaDeEspera()) {
                                System.out.print("\nValor inválido! Digite um valor válido: ");
                            }
                        } while (indice < 1 || indice > restaurante.quantidadeFilaDeEspera());

                        Atendimento reservaEscolhida = restaurante.getFilaDeEspera().get(indice - 1);
                        restaurante.removeFilaDeEspera(reservaEscolhida);
                    }
                    break;
                case "0":
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    leitor.close();
                    System.exit(0);
                    break;
                default:
                    System.out.print("Entrada inválida!");
                    break;
            }
        } while (!escolha.equals("0"));
    }
}