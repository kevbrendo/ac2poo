import Domain.Cliente;
import Domain.Jogo;
import Domain.JogoPlayStation;
import Domain.JogoSwitch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jogo> ListaJogos = getJogos();

        Cliente cliente1 = new Cliente(1,"","");
        ArrayList<Jogo> jogosCliente = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        int IdJogo;
        double valorLocacao;

        while (escolha != 4) {
            System.out.println("Menu:");
            System.out.println("1 – Alugar");
            System.out.println("2 – Devolver");
            System.out.println("3 – Mostrar");
            System.out.println("4 – Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> {
                    System.out.println("Digite o Numero de Jogo:");
                    IdJogo = scanner.nextInt();

                    System.out.println("Qual o valor da locacao:");
                    valorLocacao = scanner.nextDouble();

                    for(Jogo jogo : getJogos()) {
                        if(jogo.getIdJogo() == IdJogo) {
                            jogo.setDisponivel(false);
                            jogo.setValorLocacao(valorLocacao);
                            jogosCliente.add(jogo);
                            cliente1.setListaJogos(jogosCliente);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Digite o Numero de Jogo:");
                    IdJogo = scanner.nextInt();

                    for(Jogo jogo : getJogos()) {
                        if(jogo.getIdJogo() == IdJogo) {
                            jogo.setDisponivel(true);
                            jogosCliente.remove(jogo);
                            cliente1.setListaJogos(jogosCliente);
                        }
                    }
                }
                case 3 -> {
                    System.out.printf(cliente1.toString());
                }
                case 4 -> System.out.print("Tchau");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static ArrayList<Jogo> getJogos() {
        ArrayList<Jogo> ListaJogos = new ArrayList<>();

        JogoSwitch jogo1 = new JogoSwitch(1,"Mario", 2.1, "aventura", "2008");
        JogoSwitch jogo2 = new JogoSwitch(2,"Zelda", 3.1, "aventura", "2009");
        JogoSwitch jogo3 = new JogoSwitch(3,"Stray", 5.1, "aventura", "2022");
        JogoPlayStation jogo4 = new JogoPlayStation(3,"Stray", 5.1, "aventura", "2022");
        JogoSwitch jogo5 = new JogoSwitch(3,"Stray", 5.1, "aventura", "2022");

        ListaJogos.add(jogo1);
        ListaJogos.add(jogo2);
        ListaJogos.add(jogo3);
        ListaJogos.add(jogo4);
        ListaJogos.add(jogo5);
        return ListaJogos;
    }
}