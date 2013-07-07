/*
 * Classe Log
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

import java.io.*;

/**
 * @author Thiago Bandeira
 * 
 *
 */

public class Log {
	
	private String texto = "";
	private String dirName = "geracoes";
    
	private File file;
    private File dir;
 
    /**
     * Construtor 
     * 
     * @param excluiArq
     * @param numGeracao
     */
    public Log(boolean excluiArq, Integer numGeracao) {
        String fileName = dirName + "//geracao_" + numGeracao + ".txt";
        
        file = new File(fileName);
        dir = new File("geracoes");
        
        if(dir.exists() && excluiArq){
			execluirArquivos(dir);
		}
		    
		if(!dir.exists()){
		    if (dir.mkdir()){
		        System.out.print("Diretorio " + dirName + " criado com sucesso!");                  
		    }
		    else{
		        System.out.println("Erro - Nao foi possivel criar o diretorio das geracoes!");
		    }
		}
    }

    /**
     * Seta o texto a ser salvo no arquivo
     * 
     * @param texto
     */
    public void setLog(String texto) {
        this.texto = this.texto + texto;        
    }

    /**
     * Salva o conteudo da string texto para o arquivo
     * 
     */
    public void salvaLog() {

        try {
        	file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, false);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.write(this.texto);
            writer.close();
            this.texto = "";
        } catch (FileNotFoundException e) {
            System.out.print("Erro - Arquivo nao encontrado!");
        } catch (IOException e) {
            System.out.println("Erro - Nao foi possivel escrever no arquivo!");
        }

    }
    
    /**
     *  Recebe como parametro o diretorio e exclui os arquivos existentes
     *  
     * @param dir
     */
    private void execluirArquivos(File dir){
    	if (dir.isDirectory()) {
    		System.out.println("Excluindo arquivos das geracoes...");
            File[] files = dir.listFiles();
            for (File file : files) {
                file.delete();
            }
        }
    	System.out.println("Arquivos excluidos com sucesso!");
    }
}
