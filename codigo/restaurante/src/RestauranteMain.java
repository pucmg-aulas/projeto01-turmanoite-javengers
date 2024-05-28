import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import main.java.model.Alimento;
import main.java.model.Atendimento;
import main.java.model.Bebida;
import main.java.model.Cliente;
import main.java.model.Comanda;
import main.java.model.Mesa;
import main.java.model.Pedido;
import main.java.model.Prato;

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

    public static ArrayList<Alimento> montaCardapio() {
        ArrayList<Alimento> cardapio = new ArrayList<>();

        Bebida agua = new Bebida(500, "Água mineral", "Água mineral", 2.00);
        Bebida sucoLaranja = new Bebida(200, "Suco de laranja", "Suco de laranja", 5.50);
        Bebida refrigeranteCola = new Bebida(250, "Refrigerante de cola", "Refrigerante de cola", 3.50);
        Bebida cervejaPilsen = new Bebida(350, "Cerveja Pilsen", "Cerveja Pilsen", 4.00);
        Bebida vinhoTinto = new Bebida(150, "Vinho tinto seco", "Vinho tinto seco", 8.00);
        Prato moquecaTilápia = new Prato(1, "Moqueca de Tilápia", "Moqueca de Tilápia", 45.00);
        Prato falafelAssado = new Prato(2, "Falafel Assado", "Falafel Assado", 30.00);
        Prato saladaPrimavera = new Prato(1, "Salada Primavera com Macarrão Konjac",
                "Salada Primavera com Macarrão Konjac", 28.00);
        Prato escondidinhoFrango = new Prato(2, "Escondidinho de Frango", "Escondidinho de Frango", 35.00);
        Prato strogonoff = new Prato(2, "Strogonoff de Carne", "Strogonoff de Carne", 40.00);
        Prato caçarolaCarneLegumes = new Prato(4, "Caçarola de Carne com Legumes", "Caçarola de Carne com Legumes",
                42.00);

        cardapio.add(agua);
        cardapio.add(sucoLaranja);
        cardapio.add(refrigeranteCola);
        cardapio.add(cervejaPilsen);
        cardapio.add(vinhoTinto);
        cardapio.add(moquecaTilápia);
        cardapio.add(falafelAssado);
        cardapio.add(saladaPrimavera);
        cardapio.add(escondidinhoFrango);
        cardapio.add(strogonoff);
        cardapio.add(caçarolaCarneLegumes);

        return cardapio;
    }

    public static void main(String[] args) throws Exception {
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

        Restaurante restaurante = new Restaurante(mesas, montaCardapio());

        Scanner leitor = new Scanner(System.in);
        int escolha;

        System.out.println("Gerenciamento do restaurante À La Classe");

        do {
            System.out.println("\nOpções:");
            System.out.println(
                    "\n1) Iniciar atendimento\n\n2) Encerrar atendimento\n\n3) Exibir mesas disponíveis\n\n4) Exibir lista de espera\n\n5) Remover atendimento da lista de espera\n\n6) Exibir cardápio\n\n7) Fazer pedido\n\n8) Exibir comanda do cliente\n\n0) Sair");
            System.out.print("\nPor favor, selecione uma opção: ");
            escolha = leitor.nextInt();
            switch (escolha) {
                case 1:
                    String nome;
                    do {
                        System.out.print("\nInforme o nome do cliente: ");
                        leitor.nextLine();
                        nome = leitor.nextLine();

                        if (!nomeValido(nome)) {

                            System.out.println("Nome inválido. Por favor, tente novamente.");
                        }
                    } while (!nomeValido(nome));

                    Cliente cliente = new Cliente(formatarNome(nome));
                    clear();
                    System.out.println("Cadastro realizado com sucesso.");

                    int quantPessoas = 0;

                    do {
                        System.out.print("\nInforme a quantidade de pessoas do atendimento: ");
                        quantPessoas = leitor.nextInt();
                        leitor.nextLine();

                        if (quantPessoas > 0) {
                            clear();
                        } else {
                            clear();
                            System.out.println("Entrada inválida.");
                        }
                    } while (quantPessoas < 1);

                    Atendimento novoAtendimento = new Atendimento(cliente, quantPessoas, LocalDateTime.now());

                    if (restaurante.fazReservaDeMesa(novoAtendimento)) {
                        System.out.println(
                                "Há uma mesa disponível!");
                    } else {
                        restaurante.adicionaFilaDeEspera(novoAtendimento);
                        System.out.println(
                                "Não há mesas disponíveis no momento - o cliente foi adicionado à fila de espera.");
                    }
                    break;
                case 2:
                    clear();
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
                case 3:
                    clear();
                    restaurante.exibeMesasDisponiveis();
                    break;
                case 4:
                    clear();
                    restaurante.exibeFilaDeEspera();
                    break;
                case 5:
                    clear();
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
                case 6:
                    clear();
                    restaurante.exibeCardapio();
                    break;
                case 7:
                    clear();
                    restaurante.exibeAtendimentos();

                    if (restaurante.quantidadeAtendimentos() > 0) {
                        System.out.print("Qual cliente deseja fazer um pedido: ");
                        int indice = leitor.nextInt();

                        Atendimento atendimento = restaurante.getAtendimentos().get(indice - 1);
                        Comanda comanda = atendimento.getComanda();

                        do {
                            restaurante.exibeCardapio();

                            System.out.print("Escolha um item do cardápio (0 para finalizar): ");
                            int escolhaItem = leitor.nextInt();

                            if (escolhaItem == 0)
                                break;

                            Alimento alimento = restaurante.getCardapio().get(escolhaItem - 1);
                            System.out.print("Quantidade: ");
                            int quantidade = leitor.nextInt();

                            Pedido pedido = new Pedido(alimento, quantidade);
                            comanda.adicionaPedido(pedido);
                            System.out.println("Pedido adicionado com sucesso!");

                            System.out.print("Deseja fazer mais um pedido? (1 para sim, 0 para não): ");
                            escolhaItem = leitor.nextInt();
                            if (escolhaItem == 0)
                                break;

                        } while (true);
                    }
                    break;
                case 8:
                    clear();
                    restaurante.exibeAtendimentos();

                    if (restaurante.quantidadeAtendimentos() > 0) {
                        System.out.print("Qual cliente deseja ver a comanda: ");

                        int indice;

                        do {
                            indice = leitor.nextInt();
                            leitor.nextLine();
                            if (indice < 1 || indice > restaurante.quantidadeAtendimentos()) {
                                System.out.print("\nValor inválido! Digite um valor válido: ");
                            }
                        } while (indice < 1 || indice > restaurante.quantidadeAtendimentos());

                        Atendimento reservaEscolhida = restaurante.getAtendimentos().get(indice - 1);

                        reservaEscolhida.getComanda().imprimeComanda();
                    }
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar nossos serviços!\n");
                    leitor.close();
                    System.exit(0);
                    break;
                default:
                    System.out.print("Entrada inválida!");
                    break;
            }
        } while (escolha != 0);
    }
}