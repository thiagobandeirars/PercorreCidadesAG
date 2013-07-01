/*
 * 
 * Classe AG
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
import java.math.*;


/**
 * 
 * @author Thiago Bandeira
 */
public class AG {

	private static int LIMITE_GERACOES = 170000;
	private static int TAXA_REPETICAO = 10000;
	
	private int limiteGeracoes;
	
	ArrayList<Cromossomo> pais = new ArrayList<Cromossomo>(2);
	
	/**
	 * Construtor
	 */
	public AG() {
		this.limiteGeracoes = LIMITE_GERACOES;
	}

	/**
	 * Construtor
	 * Recebe como parametro o limite de geracoes a ser executado
	 * 
	 * @param limiteGeracoes
	 */
	public AG(int limiteGeracoes) {
		this.limiteGeracoes = limiteGeracoes;
	}

	public int getLimiteGeracoes() {
		return limiteGeracoes;
	}

	public void setLimiteGeracoes(int limiteGeracoes) {
		this.limiteGeracoes = limiteGeracoes;
	}


	/**
	 * Funcao de cruzamento utilizando o operador OX 
	 * 
	 * @param populacao
	 * @param novaPopulacao
	 */
	public void cruzamento(Populacao populacao, Populacao novaPopulacao) {
		while (novaPopulacao.cromossomos.size() < novaPopulacao.getTamanhoPopulacao()) {
			ArrayList<String> f1 = new ArrayList<String>(11);
			ArrayList<String> f2 = new ArrayList<String>(11);


			ArrayList<String> t1 = new ArrayList<String>(11);
			ArrayList<String> t2 = new ArrayList<String>(11);
			
			// Seleciona dois pais por torneio
			selecionaPais(populacao);

			
//			System.out.print("PAI1 = "); 
//			for(int i = 0; i < 11;i++){
//				System.out.print(pais.get(0).getGene(i));
//				System.out.print(" | "); 
//			} 
//			System.out.print("\nPAI2 = "); 
//			for(int i = 0; i < 11;i++){ 
//				System.out.print(pais.get(1).getGene(i));
//				System.out.print(" | "); 
//			}
			for(int i = 0; i < 11; i++){
				f1.add("0");
				f2.add("0");
			}
			
			f1.set(3, pais.get(0).getGene(3));
			f1.set(4, pais.get(0).getGene(4));
			f1.set(5, pais.get(0).getGene(5));
			f1.set(6, pais.get(0).getGene(6));
			f1.set(7, pais.get(0).getGene(7));
			
			f2.set(3, pais.get(1).getGene(3));
			f2.set(4, pais.get(1).getGene(4));
			f2.set(5, pais.get(1).getGene(5));
			f2.set(6, pais.get(1).getGene(6));
			f2.set(7, pais.get(1).getGene(7));
						
			t1.add(pais.get(0).getGene(8));
			t1.add(pais.get(0).getGene(9));
			t1.add(pais.get(0).getGene(10));
			t1.add(pais.get(0).getGene(0));
			t1.add(pais.get(0).getGene(1));
			t1.add(pais.get(0).getGene(2));
			t1.add(pais.get(0).getGene(3));
			t1.add(pais.get(0).getGene(4));
			t1.add(pais.get(0).getGene(5));
			t1.add(pais.get(0).getGene(6));
			t1.add(pais.get(0).getGene(7));
			
			t2.add(pais.get(1).getGene(8));
			t2.add(pais.get(1).getGene(9));
			t2.add(pais.get(1).getGene(10));
			t2.add(pais.get(1).getGene(0));
			t2.add(pais.get(1).getGene(1));
			t2.add(pais.get(1).getGene(2));
			t2.add(pais.get(1).getGene(3));
			t2.add(pais.get(1).getGene(4));
			t2.add(pais.get(1).getGene(5));
			t2.add(pais.get(1).getGene(6));
			t2.add(pais.get(1).getGene(7));
			

			for(int i = 3;i < 8; i++){
				for(int k = 0; k < t2.size();k++){
					if(f1.get(i) == t2.get(k)){
						t2.remove(k);
						break;
					}
				}
			}
			
			f1.set(8, t2.get(0));
			f1.set(9, t2.get(1));
			f1.set(10, t2.get(2));
			f1.set(0, t2.get(3));
			f1.set(1, t2.get(4));
			f1.set(2, t2.get(5));
			
			
			for(int i = 3;i < 8; i++){
				for(int k = 0; k < t1.size();k++){
					if(f2.get(i) == t1.get(k)){
						t1.remove(k);
						break;
					}
				}
			}
			
			f2.set(8, t1.get(0));
			f2.set(9, t1.get(1));
			f2.set(10, t1.get(2));
			f2.set(0, t1.get(3));
			f2.set(1, t1.get(4));
			f2.set(2, t1.get(5));

			// gerar 2 filhos
			Cromossomo cf1 = new Cromossomo();
			Cromossomo cf2 = new Cromossomo();

			cf1.genes.addAll(f1);
			cf2.genes.addAll(f2);

			// Faz a mutacao dos filhos
			mutacao(cf1);
			mutacao(cf2);
			
			int somaCf1 = cf1.somaGenes();
			int somaCf2 = cf2.somaGenes();
			
			// Garante que nao tera filhos gemeos
			if(somaCf1 != somaCf2){
			
				// Não pode adicionar um cromossomo ja existente na populacao
				// Verifica se já existe um cromossomo igual
				// se for diferente entao insere na nova populacao
				boolean dif1 = false, dif2 = false;
				for(Cromossomo item : novaPopulacao.cromossomos){
					int somaItem = item.somaGenes();
					
					if ( somaItem != somaCf1 ){
						dif1 = true;
					}
									
					if ( somaItem != somaCf2 ){
						dif2 = true;
					}				
				}
			
				if(dif1){
					novaPopulacao.cromossomos.add(cf1);
				}
			
				if(dif2){
					novaPopulacao.cromossomos.add(cf2);
				}
			}
		
			
			// limpa o array dos pais
			pais.clear();

		}
	}

	/**
	 *   Pega aleatoriamente dois genes e faz a mutacao do cromossomo
	 *   
	 * @param cromossomo 
	 */
	public void mutacao(Cromossomo cromossomo) {
		Random rand = new Random();
		int r1 = 0, r2 = 0;
		do {
			r1 = rand.nextInt(cromossomo.genes.size());
			r2 = rand.nextInt(cromossomo.genes.size());
		//	r3 = rand.nextInt(cromossomo.genes.size());

			if (r1 != r2) {				
				String s1 = cromossomo.getGene(r1);
				String s2 = cromossomo.getGene(r2);
				//String s3 = cromossomo.getGene(r3);

				cromossomo.genes.set(r1, s2);
				cromossomo.genes.set(r2, s1);
				//cromossomo.genes.set(r3, s1);
	
				break;
			}
		} while (r1 == r2);
	}

	/**
	 * Executa o algoritmo genetico da busca da melhor solucao
	 * 
	 * @param salvarGeracao Salvar cada geracao em um arquivo
	 * @param tamanhoPopulacao Tamanho da populacao ser criada para cada geracao
	 */
	public void executaAG(boolean salvarGeracao, int tamanhoPopulacao) {
		int f = 0;
		int geracao = 1;
		boolean inicio = true;
		int qtdMelhor = 0, v1 = 0,v2 = 0; 
		
		Populacao populacao = new Populacao(tamanhoPopulacao);
		
		System.out.println("Executando AG! Aguarde...");
		do {
			
			// Se for a primeira iteracao entao inicializa a populacao com
			// valores aleatorios
			if (inicio) {
				populacao.geraPopulacaoRand();
			}

			// adiciona em uma lista a soma dos genes de todos os cromossomos
			populacao.addSomaGenesCromossomos();

			if(salvarGeracao){
				// imprime a populacao atual
				populacao.printPopoulacaoArquivo(inicio, geracao);
			}
			// Cria a nova populacao
			Populacao novaPopulacao = new Populacao(tamanhoPopulacao);

			/* FUNCAO DE APTIDAO
			 *  Pega o melhor cromossomo da populacao atual
			 */
			int melhorID = populacao.buscaMelhorCromossomoPopulacao();

			v2 = populacao.getMelhorCromossomoValor();
			
			// Passa o melhor por elitismo para a nova Geracao
			novaPopulacao.addCromossomo(populacao.getCromossomo(melhorID));
			
			// faz o cruzamento
			cruzamento(populacao, novaPopulacao);

			// seta a soma dos genes de todos os cromossomos
			novaPopulacao.addSomaGenesCromossomos(); 

	
			/* FUNCAO DE APTIDAO
			 *  Pega o melhor cromossomo da populacao atual
			 */
			novaPopulacao.buscaMelhorCromossomoPopulacao();
			
			v1 = novaPopulacao.getMelhorCromossomoValor();
			if (v1 == v2){
				qtdMelhor++;	
				//System.out.println("v1: " + v1 + "- v2: "+ v2);
			}
			else{
				qtdMelhor = 0;
			}
			
			if (qtdMelhor == TAXA_REPETICAO  || geracao == getLimiteGeracoes()) {
				// achou melhor resultado
				int id = novaPopulacao.buscaMelhorCromossomoPopulacao();
				System.out.println("Quantidade repetida:" + qtdMelhor);
				System.out.println("\nResultado:");
				System.out.println("Qtd: Geracoes: " + geracao);
				System.out.println("\nGeracao: " + geracao);
				System.out.println("ID Melhor Cromossomo: " + id);
				System.out.println("Distancia: " + novaPopulacao.getMelhorCromossomoValor() + " Km");
				System.out.println("Resultado da Funcao de Aptidao: " + f);
				System.out.println("\nPossivel solucao:");
				novaPopulacao.printCromossomo(id);
				break;
			}

			
			// limpa tudo que existe da populacao atual
			populacao.cromossomos.clear();
			populacao.setMelhorCromossomoID(-1);
			populacao.setMelhorCromossomoValor(0);

			// adiciona a novaPopulacao
			populacao.cromossomos.addAll(novaPopulacao.cromossomos);
			novaPopulacao.cromossomos.clear();
			
			geracao++;
			inicio = false;
		} while (true);

	}

	/**
	 *  Pega aleatoriamente dois pais e executa o torneio
	 *  o melhor vai para a lista dos pais.
	 *  
	 * @param populacao
	 */
	public void selecionaPais(Populacao populacao) {
		Random rand = new Random();
		int idxP1;
		int idxP2;
		int cont = 0;

		do {
			idxP1 = rand.nextInt(populacao.cromossomos.size());
			idxP2 = rand.nextInt(populacao.cromossomos.size());

			if (idxP1 != idxP2) {
				
				int menor = populacao.cromossomos.get(idxP1)
						.getSomatorioGenes();
				if (menor < populacao.cromossomos.get(idxP2)
						.getSomatorioGenes()) {
					// nao pode ter dois pais iguais na lista
					if (!pais.contains(populacao.cromossomos.get(idxP1))) {
						pais.add(populacao.cromossomos.get(idxP1));
						cont++;

					}
				} else {
					// nao pode ter dois pais iguais na lista
					if (!pais.contains(populacao.cromossomos.get(idxP2))) {
						pais.add(populacao.cromossomos.get(idxP2));
						cont++;
					}
				}
			}
		} while (idxP1 == idxP2 || cont < 2);

	}
}
