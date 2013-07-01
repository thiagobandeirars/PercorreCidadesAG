/* 
 * Classe Populacao
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


import java.util.ArrayList;

/**
 * @author Thiago Bandeira
 *
 */
public class Populacao {

	private static int TAM_POPULACAO = 11;
	private int melhorCromossomoID = -1;
	private int melhorCromossomoValor = 0;
    private int tamanhoPopulacao = 0;
    
    ArrayList<Cromossomo> cromossomos;

    public int getMelhorCromossomoID() {
        return melhorCromossomoID;
    }

    public void setMelhorCromossomoID(int melhorCromossomoID) {
        this.melhorCromossomoID = melhorCromossomoID;
    }

    public int getMelhorCromossomoValor() {
        return melhorCromossomoValor;
    }

    public void setMelhorCromossomoValor(int melhorCromossomoValor) {
        this.melhorCromossomoValor = melhorCromossomoValor;
    }

    public Populacao() {
        this.tamanhoPopulacao = TAM_POPULACAO;
        this.cromossomos = new ArrayList<Cromossomo>();

    }
    public Populacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.cromossomos = new ArrayList<Cromossomo>();

    }

    public Cromossomo getCromossomo(int posicao) {
        return this.cromossomos.get(posicao);
    }

    public void addCromossomo(Cromossomo cr) {
        this.cromossomos.add(cr);
    }

    /**
     *  Gera cromossomos aleatoriamente e insere na populacao
     *  
     */
    public void geraPopulacaoRand() {
        for (int i = 0; i < getTamanhoPopulacao(); i++) {
            Cromossomo cr = new Cromossomo();
            cr.geraGenes();
            this.cromossomos.add(cr);
        }
    }

    public void setTamanhoPopulacao(Integer tamanho) {
        this.tamanhoPopulacao = tamanho;
    }

    public int getTamanhoPopulacao() {
        return this.tamanhoPopulacao;
    }

    /**
     * Imprime em um arquivo texto a populacao de uma geracao
     * Cada geracao e criado um arquivo com o seu numero
     * 
     * 
     * @param excluirArq
     * @param numGeracao
     */
    public void printPopoulacaoArquivo(boolean excluirArq, int numGeracao) {
        //int result = addSomaGenesToList();
        Log log = new Log(excluirArq, numGeracao);

        for (int i = 0; i < getTamanhoPopulacao(); i++) {
            //System.out.println("---------------------------------------------------------------------------------");
            //System.out.print("Cromossomo: " + i);
            //System.out.print(" | ");
           // log.setLog("---------------------------------------------------------------------------------\n");
            log.setLog("Cromossomo: " + i);
            log.setLog(" | ");

            for (int k = 0; k < this.cromossomos.get(i).getTamanhoCromossomo(); k++) {
                //System.out.print(this.cromossomos.get(i).getGene(k));
                log.setLog(this.cromossomos.get(i).getGene(k));
                //System.out.print(" | ");
                log.setLog(" | " );
           
               // log.setLog();
            }
            
            int soma = this.cromossomos.get(i).getSomatorioGenes();//this.cromossomos.get(i).somaGenes();
            //System.out.println("\nDistancia do percurso : " + soma+ " Km");
            //System.out.println("---------------------------------------------------------------------------------");
           // log.setLog("\nDistancia do percurso : " + soma + " Km");
           // log.setLog("\n---------------------------------------------------------------------------------\n");
            log.setLog(this.cromossomos.get(i).getSomatorioGenes()+"\n");

        }
        // Salva o arquivo 
        log.salvaLog();
    }

    /**
     *  Soma os genes dos cromossomos
     */
    public void addSomaGenesCromossomos() {
        int soma = 0;
        for(Cromossomo item : cromossomos){
        	soma = item.somaGenes();
        	item.setSomatorioGenes(soma);
        }
    }

    /**
     * 
     *  Funcao de Aptidao
     *  
     * Retorna o id do melhor cromossomo da populacao
     * 
     * @return 
     */
    public int buscaMelhorCromossomoPopulacao() {
        // Pega o primeiro da lista
        int min = this.cromossomos.get(0).getSomatorioGenes();
        int id = 0;
        for (int i = 1; i < this.cromossomos.size(); i++) {
            if (this.cromossomos.get(i).getSomatorioGenes() < min) {
                min = this.cromossomos.get(i).getSomatorioGenes();
                id = i;
            }
        }
        
        setMelhorCromossomoID(id);
        setMelhorCromossomoValor(min);

        return getMelhorCromossomoID();
    }

    /**
     * Imprime os genes do cromossomo passado por parametro
     * 
     * @param id cromossomo
     */
    public void printCromossomo(int id) {    	
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("| ");
        System.out.print("POA");
        for (int k = 0; k < this.cromossomos.get(id).getTamanhoCromossomo(); k++) {
            System.out.print(" | ");
            System.out.print(this.cromossomos.get(id).getGene(k));
            
        }
        System.out.print(" | POA |");
    	System.out.println("\n-------------------------------------------------------------------------------");

    }
}
