import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
       String [] candidatosSelecionados = imprimirSelecionados();
       int nro = 0;
       for (String candidato: candidatosSelecionados){
           if (candidato != "Sem cadidato com pretenção Salarial menor ou igual ao salario BASE" ){
               nro++;               
           }        
       }     
       String [] candidatosParaLigar = new String[nro];
       for(int i=0; i<nro; i++){
        candidatosParaLigar[i] = candidatosSelecionados[i];
       }
       
       for(String candidato: candidatosParaLigar){
            ligacao(candidato);
       }
        
        

    }

    static void ligacao(String candidato){
        

        int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO PARA "+ candidato);
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    

    }


	//método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}




    static String[] imprimirSelecionados(){
        
        String [] candidatosFinais = selecaoCandidatos();
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice=0; indice<5; indice++){
            System.out.println("o Candidato de nº "+(indice+1)+" é o "+candidatosFinais[indice]);
        }
        return candidatosFinais;

    }


    static String[] selecaoCandidatos(){
        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados =0;
        int candidatosAtual =0;
        double salarioBase = 2000.00;
        String [] candidatosFinais = new String[5];
        for(int i = 0; i<5; i++){
            candidatosFinais[i] = "Sem cadidato com pretenção Salarial menor ou igual ao salario BASE";
        }
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salaraioPretendido = valorPretendido();
            //System.out.println("O candidato " + candidato + " Solictou este valor de salario "+ salaraioPretendido);
            if(salarioBase >= salaraioPretendido){
                System.out.println("o candidato "+ candidato+" foi selecionado para vaga com Pretenção salarial de: R$" + salaraioPretendido );
                candidatosFinais[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
                
            }
            candidatosAtual++;
        }

        return candidatosFinais;
       
    }

    static double valorPretendido(){
         return ThreadLocalRandom.current().nextDouble(1800, 2200);  
    }
    
    
    static void analisarCandidato(double salaraioPretendido){
        double salarioBase = 2000.00;
        if(salarioBase > salaraioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salaraioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }    
    }
}
