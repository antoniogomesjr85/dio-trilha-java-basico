import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
            //TODO: criar variaveis,  importar classe scanner
            //Exibir as perguntas para usuarios 
            //com Scanner pegar os valores digitados
            //exibir os valores no terminal
        Scanner  scanner = new Scanner(System.in).useLocale(Locale.US);  
        int numero;
        String agencia;
        String nomeCliente;
        String sobrenomeCliente;
        double saldo;

        System.out.println("Por favor digite o numero da conta:");
        numero = scanner.nextInt();

        System.out.println("Por favor digitar a Agencia:");
        agencia = scanner.next();

        System.out.println("Por favor digite seu primeiro nome:");
        nomeCliente = scanner.next();
        
        System.out.println("Por favor digite seu sobrenome:");
        sobrenomeCliente = scanner.next();
        
        System.out.println("Por favor digite o Saldo:");
        saldo = scanner.nextDouble();

        System.out.println("Olá "+ nomeCliente + " "+ sobrenomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é: "+ agencia + ", sua conta é: "+ numero + " e seu saldo é: " + saldo + " já disponivel para saque.");
        





        
        
        
    }
}
