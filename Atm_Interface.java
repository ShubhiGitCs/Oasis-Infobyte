import java.util.Scanner;

//import javax.lang.model.util.ElementScanner14;
class AtmInterface
{
    String name;
    String userName;
    String PassWord;
    String AccountNo;
    double Mybalance = 100000.00;
    int transaction=0;
    String TransactionHistory = "";

    //regis of the user

    public void register()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        this.name=input.nextLine();
        System.out.println("\nEnter username: ");
        this.userName=input.nextLine();
        System.out.println("\nEnter PassWord: ");
        this.PassWord=input.nextLine();
        System.out.println("\nEnter AccountNo: ");
        this.AccountNo=input.nextLine();
        System.out.println("\nYou have Successfully completed your Registrations! Kindly login to yout Account. ");

    }

    //login of user
    public boolean Login(){
        boolean LoginIs = false;
        Scanner input = new Scanner(System.in);
        while(!LoginIs)
        {
            System.out.print("Enter username: ");
            String username = input.nextLine();
            if(username.equals(userName))
            {
                while(!LoginIs)
                {
                    System.out.print("Eenter password: ");
                    String password = input.nextLine();
                    if(password.equals(PassWord))
                    {
                        System.out.println("\nYour login is Successfull!");
                        LoginIs = true;

                    }
                    else
                        System.out.println("\0Incorrect Password! ");

                }
            }
            else
                System.out.println("\n#username not Found! ");

        }
        return LoginIs;
    }

    // Witdrawal
    public void withdraw()
    {
        System.out.println("\nEnter the amount to withdraw: ");
        Scanner input = new Scanner(System.in);
        double amount = input.nextDouble();
        try{
            if(Mybalance>=amount){
                Mybalance-=amount;
                System.out.println("\n Withdraw Successfully done! ");
                String str = "Rs "+ amount + " withdraw\n";
                TransactionHistory = TransactionHistory.concat(str);


            }
            else
                System.out.println("\nInsufficient balance. ");

        }
        catch(Exception e){}

    }
    //Deposition
    public void Deposit()
    {
        System.out.println("\nEnter the amount to Deposit: ");
        Scanner input = new Scanner(System.in);
        double amount = input.nextDouble();
        try{
            if(amount<=100000.00)
            {
                transaction++;
                Mybalance+=amount;
                System.out.println("\nsucessfull deposition. ");
                String str ="Rs "+ amount + " deposited\n";
                TransactionHistory=TransactionHistory.concat(str);
            }
            else
                System.out.println("\nLimit exceeds! ");

        }
        catch(Exception e){}


    }
    //amount transfer
    public void transfer()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Recepient name: ");
        String Recepient = input.nextLine();
        System.out.println("\nEnter the amount that you have to transfer: ");
        double amount =  input.nextDouble();
        try{
            if(Mybalance>=amount){
                if(amount<=50000.00){
                    transaction++;
                    Mybalance-=amount;
                    System.out.println("\nThe amount is Successfully transferred to "+ Recepient);
                    String str = "Rs "+ amount + " transferred to " + Recepient+ "\n";
                    TransactionHistory = TransactionHistory.concat(str);



                }
                else
                    System.out.println("\nLimit exceeds 50000.00");
            }
            else
                System.out.println("\nYou have Insufficient balance ");
        }
        catch(Exception e){}


    }
    //checking balance
    public void balanceCheck()
    {
        System.out.println("\nRs "+ Mybalance);


    }
    //history of the transactions
    public void transactionHis()
    {
        if(transaction==0){
            System.out.println("\null! ");
        }
        else
            System.out.println("\n "+TransactionHistory);
    }
}
//Interface
class Atm_Interface{
    public static int takeInput(int limit)
    {
        int intake = 0;
        boolean temp = false;
        while(!temp)
        {
            try
            {
                Scanner input = new Scanner(System.in);
                intake=input.nextInt();
                temp=true;
                if(temp && intake>limit || intake<1)
                {
                    System.out.println("Select the number between 1 to "+limit);
                    temp =false;
                }



            }
            catch(Exception e){}
            {
                System.out.println("\nEnter integer value only");
                temp=false;
            }
        };
        return intake;

    }
    //main method
    public static void main(String[] args){
        System.out.println("\n WELCOME TO SBI Atm \n");
        System.out.println("1.Register\n2.Exit");
        System.out.println("\nEnter the choice: ");
        int choice = takeInput(2);
        if(choice==1)
        {
            AtmInterface a=new AtmInterface();
            a.register();
            while(true)
            {
                System.out.println("\n1.Login\n2.Exit");
                System.out.println("\nEnter the choice: ");
                int ch = takeInput(2);
                if(ch==1)
                {
                    if(a.Login())
                    {
                        System.out.println("\nWELCOME BACK! "+a.name+"\n\n");
                        boolean Finished=false;
                        while(!Finished)
                        {
                            System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.TransactionHistory\n55.balanceCheck");
                            System.out.println("Enter the Choice: ");
                            int b =takeInput(7);
                            switch(b)
                            {
                                case 1:
                                    a.Deposit();
                                    break;
                                case 2:
                                    a.withdraw();
                                    break;
                                case 3:
                                    a.transfer();
                                    break;
                                case 4:
                                    a.transactionHis();
                                    break;
                                case 5:
                                    a.balanceCheck();
                                    break;
                                default:
                                    System.out.println("\nWrong choice! ");
                            }

                        }

                    }
                }
                else
                    System.exit(0);
            }

        }
        else
            System.exit(0);
    }
}




