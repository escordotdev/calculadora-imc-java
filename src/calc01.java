import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class calc01 {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CALCULADORA DE IMC E MACRONUTRIENTES");

        System.out.print("Digite seu peso (KG): ");
        Double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite sua altura em metros: ");
        String alturaTexto = scanner.nextLine();

        double altura = Double.parseDouble(alturaTexto.replace("," , "."));

        System.out.print("Qual sua idade? ");
        Integer idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o sexo: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        int sexo = scanner.nextInt();

        int s;
        if (sexo == 1){
            s = 1;
        }
        else {
            s = 0;
        }

        System.out.println("Escolha seu nível de atividade: ");
        System.out.println("1 - Sedentário (pouco ou nenhum exercício)");
        System.out.println("2 - Levemente ativo (1 a 3 dias por semana)");
        System.out.println("3 - Moderadamente ativo (3 a 5 dias por semana");
        System.out.println("4 - Muito ativo ( 6 a 7 dias por semana) ");
        System.out.println("5 - Extremamente ativo (treinos intensos)");

        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt();

        Double nivelAtividade;

        switch (opcao) {
            case 1:
                nivelAtividade = 1.20;
                break;
            case 2:
                nivelAtividade = 1.375;
                break;
            case 3:
                nivelAtividade = 1.55;
                break;
            case 4:
                nivelAtividade = 1.725;
                break;
            case 5:
                nivelAtividade = 1.90;
                break;
            default:
                nivelAtividade = 1.20;
                System.out.println("Opção inválida. ");

        }
        double alturaCm = altura * 100;
        double tbm = 0.0;

        if (sexo == 1){
            tbm = (10 * peso) + (6.25 * alturaCm) - (5 * idade) + 5;
        }
        else if (sexo == 2){
            tbm = (10 * peso) + (6.25 * alturaCm) - (5 * idade) - 161;
        }
        else{
            System.out.println("Sexo inválido para a fórmula selecionada");
        }

        double gastoET = tbm * nivelAtividade;

        System.out.println("Qual seu objetivo? ");
        System.out.println("1 - Emagrecimento");
        System.out.println("2 - Manutenção");
        System.out.println("3 - Ganho de massa");

        int opcaoObjetivo = scanner.nextInt();

        String objetivo;

        switch (opcaoObjetivo) {
            case 1:
                objetivo = "emagrecimento";
                break;
            case 2:
                objetivo = "munutencao";
                break;
            case 3:
                objetivo = "ganho de massa";
                break;
            default:
                objetivo = "manutencao";
                System.out.println("Opção inválida. Manutenção definida como padrão.");
                break;
        }

        Double indiceMassaCorporal = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f%n " , indiceMassaCorporal);

        System.out.println("CLASSIFICAÇÃO CONVENCIONAL ADULTOS");

        if (indiceMassaCorporal < 18.5)
        {
            System.out.println("Abaixo do peso. ");
        }
        else if (indiceMassaCorporal >= 18.5 && indiceMassaCorporal < 25)
        {
            System.out.println("Faixa de peso normal");
        }
        else if (indiceMassaCorporal >= 25 && indiceMassaCorporal < 30)
        {
            System.out.println("Sobrepeso");
        }
        else if (indiceMassaCorporal >= 30 && indiceMassaCorporal < 35)
        {
            System.out.println("Obesidade grau I ");
        }
        else if (indiceMassaCorporal >= 35 && indiceMassaCorporal < 40)
        {
            System.out.println("Obesidade grau II ");
        }
        else{
            System.out.println("Obesidade grau III (Mórbida) ");
        }

        double gordura = (1.20 * indiceMassaCorporal) + (0.23 * idade) - (10.8 * s) - 5.4;

        System.out.println("\n--- RESULTADOS ---");
        System.out.printf("PERCENTUAL DE GORDURA ESTIMADO: %.2f%%%n", gordura );
        System.out.printf("TAXA DE METABOLISMO BASAL: %.2f kcal/dia%n", tbm);
        System.out.printf("GASTO ENERGÉTICO TOTAL: %.2f kcal/dia%n", gastoET);

        scanner.close();

    }
}
