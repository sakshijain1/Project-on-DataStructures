// import required packages

// hard-coded map will be added soon.

class godown{		
	// Sakshi Joshi.
	
	/* variables: 
	 godown.id
	 5 waiting queues with capacity of 5 each.
	(5 Delivery-man with capacity of 5 orders each.)
	  */
	 
	// Decide who will ship the order ( or which waiting queue) based on area of delivery or some other logic.
	
	void sendDelivery() {
		// decide the delivery.
		// The order will be shipped, 
		// else in the waiting queue - consider the priority.
	}
	
	void complete() {
		// one delivery complete. Allocate one order in the waiting queue.
		// decide the priority.
		// this function will be called manually in the main.
	}
}

class node
{
	int data;
	node link;
	node(int d)
	{
		data=d;
		link=null;
	}
}

class order{
	
	void info()
	{
		//Taking order
				System.out.println("Welcome!!!....Enter your order");
				System.out.println("We have following products available");
}
	/* variables: 
	 object of arraylist ( or any appropriate data structure from frameworks - dynamic allocation) to store the products ordered by a 'single' customer.
	 give hard - coded graph of the recommendations.
	 allocate variables for info like address, name, mobile number, etc. But no need to accept them yet.
	
	 */
		int adjmat[][]=new int[100][100];
		
	     ArrayList<String> discount= new ArrayList<>(); 
		
		node head[]=new node[100];
		 ArrayList<String> a = new ArrayList<String>(5);
		
		 
		Scanner sc=new Scanner(System.in);
		int verticesno,edgesno;
		int from,to;
		
		
		void list()
		{
			/*
			1-Sarees
			2-Heels Scandals
			3-Flat Sandals
			4-Jewellery
			5-Make-Up
			6-Perfumes
			7-SportWear
			8-Shoes
			9-Jacket
			10-Sweatshirts
			11-T-Shirt
			12-Tops
			13-Kurtas
			14-Leggings
			15-Jeans
			
			*/
			verticesno=15;
			edgesno=14;
			for(int i=1;i<=verticesno;i++)
			{
				head[i]=new node(i);
			}
			
				insert(1,2);
				insert(2,3);
				insert(3,2);
				insert(4,2);
				insert(2,4);
				insert(4,5);
				insert(5,4);
				insert(14,15);
				insert(15,14);
				insert(12,15);
				insert(15,12);
				insert(9,10);
				insert(10,9);
				insert(9,11);
				insert(11,9);
				insert(11,15);
				insert(15,11);
				insert(12,15);
				insert(15,12);
				insert(7,8);
				insert(8,7);
				insert(5,6);
				insert(6,5);
				insert(13,14);
				insert(14,13);
				insert(14,2);
				
				discount.add("Sport Wears has Discount of 20%");
				discount.add("Tops has Discount of 50%");
				discount.add("Buy 2 Kurtas and you get 1 for free");
				discount.add("Buy Jeans on 30% off");
				discount.add("On Purcahase of more 10,000 of Jewellwery You get 1000Rs off");
				
		}
		String dis(int i)
		{
			String str = null;
			
			if(i==1)
				return "Sarees";
		    if(i==2)
		    	return "Heels Scandals";
		    if(i==3)
		    	return "Flat Scandals";
		    if(i==4)
		    	return "Jewellery";
		    if(i==5)
		    	return "Make-Up";
		    if(i==6)
		    	return "Perfume";
		    if(i==7)
		    	return "Sportwear";
		    if(i==8)
		    	return "Shoes";
		    if(i==9)
		    	return "Jacket";
		    if(i==10)
		    	return "Sweatshirt";
		    if(i==11)
		    	return "T-Shirt";
		    if(i==12)
		    	return "Tops";
		    if(i==13)
		    	return "Kurtas";
		    if(i==14)
		    	return "Leggings";
		    if(i==15)
		    	return "Jeans";
		    
			return str;
		}
	
		void addremove()
		{
			System.out.println("\n\n\nWe have following Offers ");
			for(int i=0;i<5;i++)
			{
		       System.out.println((i+1)+"->"+discount.get(i));
			}
			System.out.println("Enter the choice you want to remove");
			int c=sc.nextInt();
			discount.remove(c-1);
		}
		void insert(int from,int to)
		{
			node temp;
			temp=new node(to);
			if(head[from]==null)
			{
				head[from]=temp;
			}
			else
			{
				node p=head[from];
				while(p.link!=null)
				{
					p=p.link;
				}
				p.link=temp;
			}
		}
	
	int ch,n;
	String s;
	void takeOrder() {
		
		do
		{
	   System.out.println("1.Sarees\n2.Heels Scandals\n3.Flat Sandals\n4.Jewellery\n5.Make-Up\n6.Perfumes\n7.SportWear\n8.Shoes\n9.Jacket\n10.Sweatshirts\n11.T-Shirt\n12.Tops\n13.Kurtas\n14.Leggings\n15.Jeans\n16.Don't want to buy more???\n17.To remove Items from Discount");
			
		System.out.println("\nEnter your choice to buy product:");
		ch=sc.nextInt();
		if(ch==17)
		{
			addremove();
		}
		s=dis(ch);
		if(s==null)
		{
			System.out.println("Thanks for buying Products from us!!!");
		}
		else
		{
		System.out.println("Your Product "+s+" is Booked");
		
		// 3. keep adding the ordered products in the arraylist/else.
				
				 a.add(s);
				 
		// giving recommendations.
		node p=head[ch];
		p=p.link;
		System.out.println("\nWe recommend you to buy");
		while(p!=null)
		{
			n=p.data;
			s=dis(n);
			System.out.println(s);
			p=p.link;
		}
		//Displaying Discount
		System.out.println("\n\n\nWe have following Offers");
		for(int i=0;i<discount.size();i++)
		{
	       System.out.println(discount.get(i));
		}
	//Displaying cart
		System.out.println("\nYour Cart contains Product....");
		 for (int i=0; i<a.size(); i++) 
	            System.out.print(a.get(i)+"\n"); 
		}
	}while(ch!=16);
		System.out.println("\n\n\n");
}
}

class centre{
	/* variables: 
	 hard coded map object.
	 order object.
	 godown class objects, say 4. 
	 godownID 
	 */
								//Adding variables for djisktra
	int cost[][]=new int[10][10];
	int dist[]=new int[10];
	int visited[]=new int[10];
	int pred[]=new int[10];
	int cnt=0;
	
	void initialize(int v)					//function to initialize cost(compulsory)
	{
		//int cost[][]=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for (int j=0;j<v;j++)
			{
				cost[i][j]=999;
			}
		}
	}
	void create(int x,int y,int wt)				//Removing the function and Adding hard coded map..
	{
		cost[x-1][y-1]=wt;
		cost[y-1][x-1]=wt;
	}
	
	void order() {
		// call takeorder().
		// accept the info of the order: address, name, mobile number.
	}
	
	void shortest() {
		//Need to add following parameters:int (no_of_vertices)v,int st(start),int dest(destination)
		// calculate the distances of the order from the godowns. Find shortest.
		int min=999,next=0;				//algo to find shortest path
		for(int i=0;i<v;i++)
		{
			dist[i]=cost[st-1][i];
			visited[i]=0;
			pred[i]=st-1;
		}
		
		visited[st-1]=1;
		dist[st-1]=0;
		while(cnt<dest-2)
		{
			min=999;
			for(int i=0;i<v;i++)
			{
				if(visited[i]!=1&&dist[i]<min)
				{
					min=dist[i];
					next=i;
				}
			}
			cnt++;
			visited[next]=1;
			for(int w=0;w<v;w++)
			{
				if(cost[next][w]!=9999&&visited[w]!=1)
				{
					if(dist[w]>(dist[next]+cost[next][w]))
					{
						dist[w]=(dist[next]+cost[next][w]);
						pred[w]=next;
					}
				}
			}
		}
	
		// godownID = shortest distance godown.id	
	}
	
	void display(int st,int dest)						//Function to display
	{
		System.out.println("Shortest distance is:"+dist[dest-1]);
		System.out.println(dest);
		int a=pred[dest-1];
		System.out.println(a+1);
		while(a!=st-1)
		{
			a=pred[a];
			System.out.println(a+1);
		}
	}
	
	
	void shipOrder() {
		// call sendDelivery() for the godownID object.
	}
	
}


public class dsa2Main {
	public static void main(String args[]) {
		// object of centre class.
		// menu driven.
		
		// if needed, complete() can be called for appropriate godown. Just for generalization.
	}
}
