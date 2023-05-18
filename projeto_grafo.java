import java.util.*;
import javax.swing.*;

public class projeto_grafo {

    static String txt = "";
    
    public static void main(String[] args) throws Exception {
        int vertice, aresta1, aresta2;
        boolean nova_aresta = true;
        String aux = " ";
        int num_aresta = 0;
        int j = 1;
        int cont_max = 0, cont_min = 1000;
        
        vertice = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o número de vértices: \n"));
        
        int[][] grafo = new int [vertice][vertice];
        
        txt += "   ";

        for (int i = 1; i <= vertice; i++){
            txt += i + " ";
        }

        txt += "\n";
        
        //construir_matriz(grafo, txt);

        do{
            aresta1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o vértice inicial da aresta: \n"));
            aresta2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o vértice final da aresta: \n"));

            num_aresta++;

            aresta1 -= 1;
            aresta2 -= 1;

            if(aresta1 == aresta2){
                grafo[aresta1][aresta2] += 1;
            }else{
                grafo[aresta1][aresta2] += 1;
                grafo[aresta2][aresta1] += 1;
            }
            
            aux = JOptionPane.showInputDialog(null, "Deseja entrar com uma nova aresta?");
            
            if(aux.equalsIgnoreCase("Não") || aux.equalsIgnoreCase("não") || aux.equalsIgnoreCase("Nao") || aux.equalsIgnoreCase("nao") || aux.equalsIgnoreCase("N") || aux.equalsIgnoreCase("n")){
                nova_aresta = false;
            }
            else{
                nova_aresta = true;
            }
        }while(nova_aresta == true);

        for(int i = 1; i <= vertice; i++){
            txt += j + " ";
            for(int k = 0; k < vertice; k++){
                txt += grafo[i - 1][k] + " ";
            }
            txt += "\n";
            j++;
        }

        txt += "\nO número de arestas é igual a: " + num_aresta + "\nO número de vértices é igual a: " + vertice;

        for(int i = 0; i < vertice; i++){
            int aux_cont = 0;
            for(int k = 0; k < vertice; k++){
                aux_cont += grafo[i][k];
            }

            if(aux_cont > cont_max){
                cont_max = aux_cont;
            }

            if(cont_min > aux_cont){
                cont_min = aux_cont;
            }
        }

        txt += "\nGrau máximo: " + cont_max + "\nGrau mínimo: " + cont_min;
        txt += "\nA busca em largura tem retorno de: \n";

        busca_largura(grafo, 0);
        txt += "\nO grafo tem: \n" + componentesProcurados(grafo);

        JOptionPane.showMessageDialog(null, txt);
    }

    public static void busca_largura(int[][] grafo, int inicial) {
        int vertices = grafo.length;
        boolean[] visitado = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();
        visitado[inicial] = true;
        queue.offer(inicial);

        StringBuilder saida = new StringBuilder();

        while (!queue.isEmpty()) {
            int verticieAtual = queue.poll();
            saida.append(verticieAtual).append(" ");

            for (int i = 0; i < vertices; i++) {
                if (grafo[verticieAtual][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    queue.offer(i);
                }
            }
        }

        txt += inicial + " : " + saida;
    }

    public static void busca_componente(int[][] grafo, int verticeInicial, boolean[] visitado, StringBuilder saidaComponente) {
        int numVertices = grafo.length;
        Queue<Integer> queue = new LinkedList<>();
        visitado[verticeInicial] = true;
        queue.offer(verticeInicial);

        saidaComponente.append(verticeInicial).append(" ");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int i = 0; i < numVertices; i++) {
                if (grafo[currentVertex][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    queue.offer(i);
                    saidaComponente.append(i).append(" ");
                }
            }
        }
    }

    public static String componentesProcurados(int[][] grafo) {
        int numVertices = grafo.length;
        boolean[] visitado = new boolean[numVertices];
        StringBuilder saidaResultado = new StringBuilder();

        int numComponentes = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                numComponentes++;
                StringBuilder saidaComponente = new StringBuilder();
                busca_componente(grafo, i, visitado, saidaComponente);
                saidaResultado.append(numComponentes).append(": ").append(saidaComponente).append("\n");
            }
        }

        return numComponentes + " : " + saidaResultado + "-> são o numero de componentes conexos e quais são eles, respectivamente";
    }
}