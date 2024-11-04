import java.util.*;
class Assignment1{

    public void fibo_non_rec(int n)
    {
        int num1=0,num2=1,num3;
        for (int i=0;i<n;i++)
        {
            System.out.print(num1+" ");
            num3=num1+num2;
            num1=num2;
            num2=num3;
        }
    }

    public int Fib(int n)
    {
        if(n<=1)
        {
            return n;
        }

        int first=Fib(n-1);
        int sec=Fib(n-2);

        return first+sec;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        Assignment1 obj = new Assignment1();
        int choice=0;
        while(choice != 3)
        {
            System.out.println("\n***MENU***");
            System.out.println("1.Fibonacci number using iterative approach (Print series)\n2.Fibonacci Number using recursive approach (Print nth element of series)/n3.Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1: 
                System.out.println("Enter the Number : ");
                int N=sc.nextInt();
                obj.fibo_non_rec(N);
                break;
            
                case 2: 
                System.out.println("Enter the Number : ");
                int n=sc.nextInt();
                System.out.println(obj.Fib(n-1));
                break;

                case 3:
                System.out.println("Exiting....");
                break;

                default:
                System.out.println("Enter valid response");
            }
        }
        sc.close();
    }
}
