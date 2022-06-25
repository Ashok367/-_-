import java .util.Scanner;
class BankAccount
{
	String name;
	String username;
	String password;
	String accountno;
	float balance=100000f;
	int transactions=0;
	String transactionHistory="";
	public void register()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\n Enter your Name: ");
		this.name=sc.nextLine();
		System.out.print("\nEnter your UserName: ");
		this.username=sc.nextLine();
		System.out.print("\nEnter your password: ");
		this.password=sc.nextLine();
		System.out.print("\nEnter your Account Number: ");
		this.accountno=sc.nextLine();
		System.out.println("\n Registration completed ....Kindly login");
	}
	public boolean login()
	{
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin)
		{
			System.out.print("\nEnter your username: ");
			String Username=sc.nextLine();
			if(Username.equals(username))
			{
				while(!isLogin)
				{
					System.out.println("\n Enter your password: ");
					String password=sc.nextLine();
					if(password.equals(password))
					{
						System.out.print("\n Login Successful!!!");
						isLogin=true;
					}
					else
					{
						System.out.println("\n Incorrect Password");
					}
				}
			}
			else
			{
				System.out.println("\n Username not found");
			}
		}
		return isLogin;
	}
	public void withdraw()
	{
		System.out.print("\n Enter Amount You want to withdraw: ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(balance>=amount)
			{
				transactions++;
				balance-=amount;
				System.out.println("\n Withdrawal successfull!!!");
				String str=amount+" Rs Withdrawed\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\n Insufficient balance!");
			}
		}
		catch(Exception e)
		{
		}
	}
	public void deposit()
	{
		System.out.print("\n Enter Amount You want to deposit: ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(amount<=100000f)
			{
				transactions++;
				balance+=amount;
				System.out.println("\n Deposited successfully!!!");
				String str=amount+" Rs Deposited\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\nSorry ...Limit is 100000.00");
			}
		}
		catch(Exception e)
		{
		}
	}
	public void checkBalance()
	{
		System.out.println("\n"+balance+" Rs");
	}
	public void transHistory()
	{
		if(transactions==0)
		{
			System.out.println("\nEmpty");
		}
		else{
			System.out.println("\n"+transactionHistory);
		}
	}
}
public class AtmInterface
{
	public static int takeIntegerInput(int limit)
	{
		int input=0;
		boolean flag=false;
		while(!flag)
		{
			try{
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag&&input>limit||input<1)
				{
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter only Integer Value! ");
				flag=false;
			}
		};
		return input;
	}
	public static void main(String[] args)
	{
		System.out.println("\n**********WELCOME TO ATM SERVICE**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.println("Enter your choice: ");
		int choice=takeIntegerInput(2);
		if(choice==1)
		{
			BankAccount b=new BankAccount();
			b.register();
			while(true)
			{
				System.out.println("\n1.Login \n2.Exit ");
				System.out.print("Enter your choice: ");
				int ch=takeIntegerInput(2);
				if(ch==1)
				{
					if(b.login())
					{
						System.out.println("\n\n**********WELCOME BACK  "+ b.name + " ***********\n");
						boolean isFinished=false;
						while(!isFinished)
						{
							System.out.println("\n1.Withdraw \n 2.Deposit\n3.Check Balance \n4.transactionHistory \n5.Exit");
							System.out.println("Enter your Choice : ");
							int c=takeIntegerInput(6);
							switch(c)
				            {
					        case 1:
					        b.withdraw();
					        break;
					        case 2:
					        b.deposit();
					        case 3:
					        b.checkBalance();
					        break;
					        case 4:
					        b.transHistory();
					        break;
					        case 5:
					        isFinished=true;
					        break;
							}
						}
					}
			    }
  
	            else
				{
		          System.exit(0);
	            }
            }
        }
        else
		{
	     System.exit(0);
        }
    }
}

		