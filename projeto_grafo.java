import javax.swing.*;

public class projeto_grafo {
    
    public static void main(String[] args) throws Exception {
        int vertice, aresta1, aresta2;
        String txt = "";
        boolean nova_aresta = true;
        String aux = " ";
        int num_aresta = 0;
        int j = 1;
        int cont_max = 0, cont_min = 1000;
        
        vertice = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o número de vértices: \n"));
        
        int[][] grafo = new int [vertice][vertice];
        
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
                grafo[aresta2 ][aresta1] += 1;
            }
            
            aux = JOptionPane.showInputDialog(null, "Deseja entrar com uma nova aresta?");
            
            if(aux.equalsIgnoreCase("não")){
                nova_aresta = false;
            }
            else{
                nova_aresta = true;
            }
        }while(nova_aresta == true);

        txt += "   ";

        for (int i = 1; i <= vertice; i++){
            txt += i + " ";
        }

        txt += "\n";

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

        JOptionPane.showMessageDialog(null, txt);
    }
}
