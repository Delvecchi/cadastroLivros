import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaL = new ArrayList<>();

        Livro metodosL = new Livro();

        System.out.println("Bem vindo ao sistema de cadastro de Livros");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livros / 0 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Livro novaL = new Livro();
                    Autor novaA = new Autor();

                    System.out.println("Digite o título do livro: ");
                    novaL.titulo = scanner.next();

                    System.out.println("Digite o autor do livro: ");
                    novaA.nome = scanner.next();

                    System.out.println("Digite o local de nascimento do autor: ");
                    novaA.localNasc = scanner.next();

                    System.out.println("Digite o preço do livro: ");
                    novaL.preco = scanner.nextFloat();

                    System.out.println("Digite o ano de lançamento do livro (dd/MM/yyyy): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novaL.dataLancamento = date;

                    if (periodo.getYears() > 5) {
                        System.out.println("O livro tem mais de 5 anos de lançamento.");
                    } else {
                        System.out.println("O livro não tem mais de 5 anos de lançamento.");
                        break;
                    }





                    listaL.add(novaL);

                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 2:
                    if (listaL.size() > 0) {
                        for (Livro cadaL : listaL) {
                            System.out.println();
                            System.out.println("Título: " + cadaL.titulo);
                            System.out.println("Autor e Local de Nascimento: " + cadaL.autor.nome + ", " + cadaL.autor.localNasc);
                            System.out.println("Preço: " + cadaL.preco);
                            System.out.println("Data de lançamento: " +cadaL.dataLancamento);

                        }

                        opcao = scanner.nextInt();
                    } else {
                        System.out.println("Lista vazia!");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o sistema!");
                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida.");
                    break;
            }
        }while (opcao != 0);
    }
}