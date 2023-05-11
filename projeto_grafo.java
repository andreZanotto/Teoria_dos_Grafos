import javax.swing.*;
import java.util.*;

public class projeto_grafo {
    
    public static void main(String[] args) throws Exception {
        int vertice, aresta1, aresta2;
        String txt = "";
        boolean nova_aresta = true;
        String aux = " ";
        
        vertice = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o número de vértices: \n"));
        
        int[][] grafo = new int [vertice][vertice];
        
        do{
            
            aresta1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o vértice inicial da aresta: \n"));
            aresta2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o vértice final da aresta: \n"));
    
            grafo[aresta1][aresta2] += 1;
            grafo[aresta2][aresta1] += 1;

            
            aux = JOptionPane.showInputDialog(null, "Deseja entrar com uma nova aresta?");
            
            if(aux.equalsIgnoreCase("não")){
                nova_aresta = false;
            }
            else{
                nova_aresta = true;
            }
        }while(nova_aresta == true);

        for(int i = 0; i < vertice; i++){
            for(int j = 0; j < vertice; j++){
                txt += grafo[i][j] + " ";
            }
            txt += "\n";
        }

        JOptionPane.showMessageDialog(null, txt);
    }
}
