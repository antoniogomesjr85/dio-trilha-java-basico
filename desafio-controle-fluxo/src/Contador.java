import java.util.Locale;
import java.util.Scanner;


public class Contador {
    public static void main(String[] args) throws Exception {
        receberParamentro();

    }


    static void receberParamentro(){
        Scanner  scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o Primeiro Parâmetro");
        int paramentroUm = scanner.nextInt();
        System.out.println("Digite o Segundo Parâmetro");
        int paramentroDois = scanner.nextInt(); 
        
        try {

            contar(paramentroUm, paramentroDois);
            
        } catch (ParametrosInvalidosException e) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
            receberParamentro();
            
        }
    }

    static void contar(int parametroUm, int parametroDois)throws ParametrosInvalidosException{
        if (parametroUm >= parametroDois)
            throw new ParametrosInvalidosException();
        
        int contagem = parametroDois - parametroUm;
        
            for(int i=0; i<contagem; i++){
            System.out.println("Imprimindo o número " + (i+1));
            }
    }

}
