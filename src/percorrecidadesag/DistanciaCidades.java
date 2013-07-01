/*
 * Classe DistanciaCidades
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
import java.util.HashMap;

/**
 * @author Thiago Bandeira
 *
 */
public class DistanciaCidades {
	
	// Belo Horizonte - BHZ
    private HashMap<String, Integer> BHZ = new HashMap<String, Integer>() {
    	{
            // BHZ
            put("BHZ", 0);
            put("BSB", 624);
            put("CGB", 1372);
            put("CWB", 820);
            put("FOR", 1893);
            put("MAO", 2556);
            put("NAT", 1831);
            put("POA", 1341);
            put("REC", 1639);
            put("RIO", 339);
            put("SSA", 964);
            put("SPO", 489);
        }
    };
    // Brasilia - BSB	
    private HashMap<String, Integer> BSB = new HashMap<String, Integer>() {
        {
            // BSB
            put("BHZ", 624);
            put("BSB", 0);
            put("CGB", 873);
            put("CWB", 1081);
            put("FOR", 1687);
            put("MAO", 1932);
            put("NAT", 1775);
            put("POA", 1619);
            put("REC", 1657);
            put("RIO", 933);
            put("SSA", 1060);
            put("SPO", 873);
        }
    };
    // Cuiaba - CGB
    private HashMap<String, Integer> CGB = new HashMap<String, Integer>() {
        {
            // CGB
            put("BHZ", 1372);
            put("BSB", 873);
            put("CGB", 0);
            put("CWB", 1302);
            put("FOR", 2329);
            put("MAO", 1453);
            put("NAT", 2524);
            put("POA", 1679);
            put("REC", 2452);
            put("RIO", 1575);
            put("SSA", 1915);
            put("SPO", 1326);
        }
    };
    // Curitiba - CWB
    private HashMap<String, Integer> CWB = new HashMap<String, Integer>() {
        {
            // CWB
            put("BHZ", 820);
            put("BSB", 1081);
            put("CGB", 1302);
            put("CWB", 0);
            put("FOR", 2670);
            put("MAO", 2734);
            put("NAT", 2645);
            put("POA", 546);
            put("REC", 2459);
            put("RIO", 675);
            put("SSA", 1784);
            put("SPO", 338);
        }
    };
    // Fortaleza - FOR
    private HashMap<String, Integer> FOR = new HashMap<String, Integer>() {
        {
            // FOR
            put("BHZ", 1893);
            put("BSB", 1687);
            put("CGB", 2329);
            put("CWB", 2670);
            put("FOR", 0);
            put("MAO", 2383);
            put("NAT", 435);
            put("POA", 3213);
            put("REC", 629);
            put("RIO", 2190);
            put("SSA", 1028);
            put("SPO", 2368);
        }
    };
    // Manaus - MAO
    private HashMap<String, Integer> MAO = new HashMap<String, Integer>() {
        {
            // MAO
            put("BHZ", 2556);
            put("BSB", 1932);
            put("CGB", 1453);
            put("CWB", 2734);
            put("FOR", 2383);
            put("MAO", 0);
            put("NAT", 2765);
            put("POA", 3132);
            put("REC", 2833);
            put("RIO", 2849);
            put("SSA", 2605);
            put("SPO", 2689);
        }
    };
    // Natal - NAT
    private HashMap<String, Integer> NAT = new HashMap<String, Integer>() {
        {
            // NAT
            put("BHZ", 1831);
            put("BSB", 1775);
            put("CGB", 2524);
            put("CWB", 2645);
            put("FOR", 435);
            put("MAO", 2765);
            put("NAT", 0);
            put("POA", 3172);
            put("REC", 253);
            put("RIO", 2085);
            put("SSA", 875);
            put("SPO", 2320);
        }
    };
    // Porto Alegre - POA
    private HashMap<String, Integer> POA = new HashMap<String, Integer>() {
        {
            // POA
            put("BHZ", 1341);
            put("BSB", 1619);
            put("CGB", 1679);
            put("CWB", 546);
            put("FOR", 3213);
            put("MAO", 3132);
            put("NAT", 3172);
            put("POA", 0);
            put("REC", 2977);
            put("RIO", 1123);
            put("SSA", 2303);
            put("SPO", 852);
        }
    };
    // Recife - REC
    private HashMap<String, Integer> REC = new HashMap<String, Integer>() {
        {
            // REC
            put("BHZ", 1639);
            put("BSB", 1657);
            put("CGB", 2452);
            put("CWB", 2459);
            put("FOR", 629);
            put("MAO", 2833);
            put("NAT", 253);
            put("POA", 2977);
            put("REC", 0);
            put("RIO", 1874);
            put("SSA", 675);
            put("SPO", 2128);
        }
    };
    // Rio de Janeiro - RIO
    private HashMap<String, Integer> RIO = new HashMap<String, Integer>() {
        {
            // RIO
            put("BHZ", 339);
            put("BSB", 933);
            put("CGB", 1575);
            put("CWB", 675);
            put("FOR", 2190);
            put("MAO", 2849);
            put("NAT", 2085);
            put("POA", 1123);
            put("REC", 1874);
            put("RIO", 0);
            put("SSA", 1209);
            put("SPO", 357);
        }
    };
    // Salvador - SSA
    private HashMap<String, Integer> SSA = new HashMap<String, Integer>() {
        {
            // SSA
            put("BHZ", 964);
            put("BSB", 1060);
            put("CGB", 1915);
            put("CWB", 1784);
            put("FOR", 1028);
            put("MAO", 2605);
            put("NAT", 875);
            put("POA", 2303);
            put("REC", 675);
            put("RIO", 1209);
            put("SSA", 0);
            put("SPO", 1453);
        }
    };
    // Sao Paulo - SPO
    private HashMap<String, Integer> SPO = new HashMap<String, Integer>() {
        {
            // SPO
            put("BHZ", 489);
            put("BSB", 873);
            put("CGB", 1326);
            put("CWB", 338);
            put("FOR", 2368);
            put("MAO", 2689);
            put("NAT", 2320);
            put("POA", 852);
            put("REC", 2128);
            put("RIO", 357);
            put("SSA", 1453);
            put("SPO", 0);
        }
    };
    HashMap<String, HashMap<String, Integer>> mapa;
    
    ArrayList<String> indexMapa = new ArrayList<String>();
    
    
    public DistanciaCidades() {
        mapa = new HashMap<String, HashMap<String, Integer>>();
       
        /*
        mapa.put(0, BHZ);//0
        mapa.put(1, BSB);//1
        mapa.put(2, CGB);//2
        mapa.put(3, CWB);//3
        mapa.put(4, FOR);//4
        mapa.put(5, MAO);//5
        mapa.put(6, NAT);//6
        mapa.put(7, POA);//7
        mapa.put(8, REC);//8
        mapa.put(9, RIO);//9
        mapa.put(10, SSA);//10
        mapa.put(11, SPO);//11
        */
        
       
        mapa.put("BHZ", BHZ);//0
        mapa.put("BSB", BSB);//1
        mapa.put("CGB", CGB);//2
        mapa.put("CWB", CWB);//3
        mapa.put("FOR", FOR);//4
        mapa.put("MAO", MAO);//5
        mapa.put("NAT", NAT);//6
        mapa.put("POA", POA);//7
        mapa.put("REC", REC);//8
        mapa.put("RIO", RIO);//9
        mapa.put("SSA", SSA);//10
        mapa.put("SPO", SPO);//11
        
        indexMapa.add("BHZ");
        indexMapa.add("BSB");
        indexMapa.add("CGB");
        indexMapa.add("CWB");
        indexMapa.add("FOR");
        indexMapa.add("MAO");
        indexMapa.add("NAT");
        indexMapa.add("POA");
        indexMapa.add("REC");
        indexMapa.add("RIO");
        indexMapa.add("SSA");
        indexMapa.add("SPO");
        indexMapa.add("NAT");
        
   
    }

    /**
     * Retorna a distancia entre as cidades
     * 
     * @param origem
     * @param destino
     * @return distancia
     */
    public int getDistanciaCidades(String origem, String destino) {
        return mapa.get(origem).get(destino);

    }

}
