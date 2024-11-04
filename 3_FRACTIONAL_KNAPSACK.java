import java.util.*;
public class Assignment3 {

    public static class Item
    {
        int weight;
        int profit;
        double ratio;

        Item(int weight, int profit)
        {
            this.weight =  weight;
            this.profit = profit;

            this.ratio =(double)(profit/weight); 
       }
    }

    public static double solution(int capacity, ArrayList<Item> item)
    {
        Sort(item);

        double maxProfit = 0;

        for(Item i:item)
        {
            if(capacity >= i.weight)
            {
                capacity = capacity - i.weight;
                maxProfit += i.profit;
            }
            else{
                maxProfit += i.profit * ((double)(capacity/i.weight));
                break;
            }
        }
        return maxProfit;
    }

    public static void Sort(ArrayList<Item> item)
    {
        for(int i=0 ; i<item.size()-1; i++)
        {
            for(int j=0 ;j<item.size()-i-1;j++)
            {
                if(item.get(j).ratio < item.get(j+1).ratio)
                {
                    Item temp = item.get(j);
                    item.set(j , item.get(j+1));
                    item.set(j+1,temp);
                }
            }
        }
    }

    public static void main(String [] args)
    {
        int bag_capacity = 15;

        int profit []={5,10,15,7,8,9,4};
        int weight [] ={1,3,5,4,1,3,2};

        ArrayList <Item> list = new ArrayList<>();

        for(int i=0;i<profit.length ;i++)
        {
            list.add( new Item ( weight[i],profit[i]));
        }

        // Item item[] = {new Item(1,5),new Item(3,10),new Item(5,15),new Item(4,7), new Item(1,8),new Item(3,9) ,new Item(2,4)};

        double ans = solution(bag_capacity,list);
        System.out.println("Total value : "+ans);
    }
}
