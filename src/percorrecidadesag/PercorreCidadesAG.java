/* 
 * Classe PercorreCidadesAG
 * 
 * Trabalho de Algoritmos Geneticos - Ulbra Gravatai
 * Disciplina: Inteligencia Artificial II - Ciencia da Computacao
 * 
 * Nome: Thiago Bandeira
 * Data: 14/06/2013
 * 
 * Professor: Tales
 * 
 */

package percorrecidadesag;



/**
 * @author Thiago Bandeira
 *
 */
public class PercorreCidadesAG {
    
	
    public static void main(String[] args) {

    	// Instancia o objeto AG
        AG ag = new AG();
        
        boolean salvaGeracaoArquivo = true;
        
        // Executa o processo de busca
        ag.executaAG(salvaGeracaoArquivo, 11);
       
        System.out.println("Legenda:");
        System.out.println("POA : Porto Alegre");
    	System.out.println("BSB : Brasilia");
    	System.out.println("BHZ : Belo Horizonte");
    	System.out.println("CGB : Cuiaba");
    	System.out.println("CWB : Curitiba");
    	System.out.println("NAT : Natal");
    	System.out.println("RIO : Rio de Janeiro");
    	System.out.println("SPO : Sao Paulo");
    	System.out.println("MAO : Manaus");
    	System.out.println("SSA : Salvador");
    	System.out.println("FOR : Fortaleza");
    	System.out.println("REC : Recife");
        
        Runtime.getRuntime().exit(0);
      
    }
}
