public class ass4 {

    public static int knapsack(int weight[] ,int value[],int capacity)
    {
        int matrix[][]= new int [weight.length + 1][capacity + 1];

        for(int i=0;i< weight.length +1; i++)
        {
            for(int w = 0 ; w< capacity+1 ; w++)
            {
                if(w == 0 || i == 0)
                {
                    matrix[i][w] = 0;
                }

                else if(weight[i-1] <= w)
                {
                    matrix[i][w] = Math.max(matrix[i-1][w] , value[i-1] + matrix[i-1][w - weight[i-1]]);
                }

                else
                {
                    matrix[i][w] = matrix[i-1][w]; 
                }
            }
        }
        return matrix[weight.length][capacity];
    }

    public static void main(String []args)
    {
        int weight[] ={1,3,4,6};
        int value [] ={20,30,10,50};
        int capacity = 10;

        int ans = knapsack(weight,value,capacity);
        System.out.println("Max profit is :"+ans);
    }
}
