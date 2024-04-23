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
            if (i == 0 || Character.isSpaceChar(palavras[i - 1].charAt(palavras[i - 1].length() - 1))) { // Verifica se é a primeira palavra ou após um espaço
                nomeFormatado.append(palavras[i].substring(0, 1).toUpperCase()).append(palavras[i].substring(1).toLowerCase());
            } else {
                nomeFormatado.append(palavras[i].toLowerCase());
            }
        }

        String formatado = nomeFormatado.toString().replaceAll(" +", " "); // Remove espaços extras entre palavras

        return formatado;
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

        Restaurante restaurante = new Restaurante(mesas, new ArrayList<>(), new ArrayList<>());

        Scanner s = new Scanner(System.in);
        String input;

        System.out.println("Bem vindo ao restaurante À La Classe!");

        do {
            System.out.println("\nPor favor, informe seu nome:");
            input = s.nextLine();

            if (!nomeValido(input)) {
                clear();
                System.out.println("Nome inválido. Por favor, tente novamente.");
            }
        } while (!nomeValido(input));

        Cliente cliente = new Cliente(formatarNome(input));

        clear();
        System.out.println("Cadastro realizado com sucesso!");
        boolean entradaValida = false;

        while (true) {
            do {
                System.out.println("\nPor favor, selecione uma das seguintes opções:");
                System.out.println("\n1) Fazer reserva\n2) Sair");
                input = s.nextLine();

                if (input.equalsIgnoreCase("1")) {
                    int quantPessoas;
                    clear();
                    do {
                        System.out.println("Informe a quantidade de pessoas da reserva:");
                        quantPessoas = s.nextInt();

                        if (quantPessoas > 0) {
                            clear();
                            entradaValida = true;
                        } else {
                            clear();
                            System.out.println("Entrada inválida.");
                        }
                    } while (!entradaValida);
                    entradaValida = false;

                    //cliente.fazerReserva(cliente, quantPessoas, LocalDateTime.now());
                    Reserva reserva = new Reserva (cliente, quantPessoas, LocalDateTime.now());

                    if (restaurante.getListaDeEspera().size() == 0) {
                        if (restaurante.fazReservaDeMesa(reserva)) {
                            System.out.println("Há uma mesa disponível! Por favor, entre em contato com um garçom para que ele te leve à sua mesa.");
                        } else {
                            restaurante.adicionaListaDeEspera(reserva);
                            System.out.println("Não há mesas disponíveis no momento - você foi adicionado à lista de espera.");
                        }
                    }
                    entradaValida = true;

                } else if (input.equalsIgnoreCase("2")) {
                    clear();
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    s.close();
                    System.exit(0);

                } else {
                    clear();
                    System.out.print("Entrada inválida. ");
                }

                /* } else if (input == "0") {
                    cliente.cancelarReserva();
                    entradaValida = true; */
            } while (!entradaValida);
        }
    }
}