/* 
 * Classe Cromossomo
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

import java.util.*;


public class Cromossomo {

	private static int TAM_CROMOSSOMO = 11;
	 
    private int somatorioGenes = 0;
    private int tamanhoCromossomo = 0;
   
    
    private DistanciaCidades dc = new DistanciaCidades();
    public ArrayList<String> genes;

    
    public Cromossomo() {
        this.tamanhoCromossomo = TAM_CROMOSSOMO;
        this.genes = new ArrayList<String>(tamanhoCromossomo);

    }

    public int getSomatorioGenes() {
        return somatorioGenes;
    }

    public void setSomatorioGenes(int somatorioGenes) {
        this.somatorioGenes = somatorioGenes;
    }

    public void setTamanhoCromossomo(Integer tamanho) {
        this.tamanhoCromossomo = tamanho;
    }

    public int getTamanhoCromossomo() {
        return this.tamanhoCromossomo;
    }

    public void addGene(String gene) {
        this.genes.add(gene);
    }

    public String getGene(int posicao) {
        return this.genes.get(posicao);
    }

    /**
     *  Gera genes aleatorios
     */
    public void geraGenes() {
        boolean flag = false;
        for (int i = 0; i < getTamanhoCromossomo(); i++) {

            List<Integer> valuesList = new ArrayList<Integer>(dc.mapa.get(dc.indexMapa.get(i)).values());
               
            do {
            	
                int randomIndex = new Random().nextInt(valuesList.size());
                Integer randomValue = valuesList.get(randomIndex);
                String key = getKey(dc.indexMapa.get(i), randomValue);

                if (!this.genes.contains(key) && !key.equals("POA")) {
                    this.genes.add(key);
                    break;
                } 
            } while (true);
        }
    }

    /**
     *  retorna a chave em string do gene
     *  
     * @param pos posicao 
     * @param value valor 
     * @return chave
     */
    private String getKey(String pos, Integer value) {
        String key = null;
        for (Map.Entry entry : dc.mapa.get(pos).entrySet()) {
            if (value.equals(entry.getValue())) {
                key = (String) entry.getKey();
                break;
            }
        }
        return key;
    }

    /**
     *  soma as distancias entre as cidades
     */
    public int somaGenes() {
        int soma = 0;
        // Pega o valor de POA ate o primeiro da posicao
        soma = dc.getDistanciaCidades("POA", this.genes.get(0));

        for (int i = 0; i < this.getTamanhoCromossomo(); i++) {
            // Pega o ultimo da posicao e vai ate POA
            if (i == this.getTamanhoCromossomo() - 1) {
                soma = soma + dc.getDistanciaCidades(this.getGene(i), "POA");
            } else {
                soma = soma + dc.mapa.get(this.genes.get(i)).get(this.genes.get(i + 1));
            }
        }
        return soma;
    }
  
    
}
