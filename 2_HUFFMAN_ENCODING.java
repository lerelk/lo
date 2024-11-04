import java.util.*;
public class Assignment2 {

    static class node
    {
        char character;
        int frequency;
        node left;
        node right;

        node(char character,int frequency)
        {
            this.character=character;
            this.frequency=frequency;
            left=null;
            right=null;
        }
    }

    public static void print(node root , StringBuilder code)
    {
        if(root == null)
        {
            return;
        }

        if(root.character != '$')
        {
            System.out.println(root.character +" : "+ code);
        }

        if(root.left != null)
        {
            print(root.left, code.append('0'));
            code.deleteCharAt(code.length()-1);
        }

        if(root.right != null)
        {
            print(root.right, code.append('1'));
            code.deleteCharAt(code.length()-1);
        }
    }
    
    public static void main(String []args)
    {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter text :");
        String text = sc.nextLine();
        
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        for(char c: text.toCharArray())
        {
            if(hmap.containsKey(c))
            {
                hmap.put(c, hmap.get(c)+1);
            }
            else{
                hmap.put(c,1);
            }
        }

        // System.out.println(hmap);

        PriorityQueue<node> pq = new PriorityQueue<>((x,y)->(x.frequency - y.frequency));

        for(Map.Entry<Character,Integer> entry : hmap.entrySet())
        {
            char key = entry.getKey();
            int value = entry.getValue(); 
            pq.add(new node(key, value));
        }

        while(pq.size()>1)
        {
            node first = pq.poll();
            node second = pq.poll();

            node new_node = new node('$', first.frequency + second.frequency);

            new_node.left = first;
            new_node.right = second;

            pq.add(new_node);
        }

        node root = pq.poll();

        print(root,new StringBuilder());

        sc.close();
    }
}
