import java.io.*;
import java.util.*;

class CompareByFrequency implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode s1, HuffmanNode s2) { 
                if (s1.freq > s2.freq) 
                    return 1; 
                else if (s1.freq< s2.freq) 
                    return -1; 
                                return 0; 
                } 
}



class HuffmanNode{
    int freq;
    char val;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode(char c,int f){
        val = c;
        freq = f;
        left = null;
        right = null;
    }
}


public class LosslessCompression{
    
    static void printCodes(HuffmanNode root,String s){
        if(root.left!=null){
            printCodes(root.left,s+"0");
        }
        if(root.right!=null){
            printCodes(root.right,s+"1");
        }
        if(root.left==null && root.right==null){
            System.out.println(root.val+": "+s);
        }
    }
    
    static HuffmanNode generateTree(PriorityQueue<HuffmanNode> pq ){
        while(pq.size()>1){
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode node = new HuffmanNode('$',left.freq+right.freq);
            node.left = left;
            node.right = right;
            pq.add(node);
        }
        return(pq.peek());
    }
    
    
    
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t-->0){
            
            int n = 5;
            char[] data = {'a','t','u','l','y'};
            int[] freq = {2, 1, 1, 1, 1};
            
            
            
            PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new CompareByFrequency());
            for(int i=0;i<n;i++){
                pq.add(new HuffmanNode(data[i],freq[i]));
            }
            
            HuffmanNode node = generateTree(pq);
            printCodes(node,"");
            
        }
    }
}