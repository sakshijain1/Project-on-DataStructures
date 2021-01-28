//import required packages
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

//hard-coded map will be added soon.

class godown {

    public static Queue<orderInfo> sm1 = new LinkedList<orderInfo>();
    public static Queue<orderInfo> sm2 = new LinkedList<orderInfo>();
    public static Queue<orderInfo> sm3 = new LinkedList<orderInfo>();

    int sendDelivery(orderInfo o) {
        orderInfo ord = new orderInfo(o.destCode, o.name, o.mobile); // dont know if needed
        if (sm1.size() < 5) {
            sm1.add(ord);
            return 0;
        }
        if (sm1.size() == 5) {
            if (sm2.size() < 5) {
                sm2.add(ord);
                return 0;
            }
        }
        if (sm1.size() == 5 && sm2.size() == 5) {
            if (sm3.size() < 5) {
                sm3.add(ord);
                return 0;
            } else
                return 1;
        }
        return 1;
    }

}

class node {
    int data;
    node link;

    node(int d) {
        data = d;
        link = null;
    }
}

class orderInfo {
    int destCode;
    String name;
    String mobile;

    orderInfo() {
        destCode = 0;
        name = " ";
        mobile = " ";
    }

    orderInfo(int d, String n, String m) {
        destCode = d;
        name = n;
        mobile = m;
    }
}

class order {

    orderInfo ord = new orderInfo();

    int adjmat[][] = new int[100][100];

    ArrayList<String> discount = new ArrayList<>();

    node head[] = new node[100];
    ArrayList<String> a = new ArrayList<String>(5);

    Scanner sc = new Scanner(System.in);
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    int verticesno, edgesno;
    int from, to;

    void list() {
        /*
         * 1-Sarees 2-Heels Scandals 3-Flat Sandals 4-Jewellery 5-Make-Up 6-Perfumes
         * 7-SportWear 8-Shoes 9-Jacket 10-Sweatshirts 11-T-Shirt 12-Tops 13-Kurtas
         * 14-Leggings 15-Jeans
         * 
         */
        verticesno = 15;
        edgesno = 14;
        for (int i = 1; i <= verticesno; i++) {
            head[i] = new node(i);
        }

        insert(1, 2);
        insert(2, 3);
        insert(3, 2);
        insert(4, 2);
        insert(2, 4);
        insert(4, 5);
        insert(5, 4);
        insert(14, 15);
        insert(15, 14);
        insert(12, 15);
        insert(15, 12);
        insert(9, 10);
        insert(10, 9);
        insert(9, 11);
        insert(11, 9);
        insert(11, 15);
        insert(15, 11);
        insert(12, 15);
        insert(15, 12);
        insert(7, 8);
        insert(8, 7);
        insert(5, 6);
        insert(6, 5);
        insert(13, 14);
        insert(14, 13);
        insert(14, 2);

        discount.add("Sport Wears has Discount of 20%");
        discount.add("Tops has Discount of 50%");
        discount.add("Buy 2 Kurtas and you get 1 for free");
        discount.add("Buy Jeans on 30% off");
        discount.add("On Purcahase of more 10,000 of Jewellwery You get 1000Rs off");

    }

    String dis(int i) {
        String str = null;

        if (i == 1)
            return "Sarees";
        if (i == 2)
            return "Heels Scandals";
        if (i == 3)
            return "Flat Scandals";
        if (i == 4)
            return "Jewellery";
        if (i == 5)
            return "Make-Up";
        if (i == 6)
            return "Perfume";
        if (i == 7)
            return "Sportwear";
        if (i == 8)
            return "Shoes";
        if (i == 9)
            return "Jacket";
        if (i == 10)
            return "Sweatshirt";
        if (i == 11)
            return "T-Shirt";
        if (i == 12)
            return "Tops";
        if (i == 13)
            return "Kurtas";
        if (i == 14)
            return "Leggings";
        if (i == 15)
            return "Jeans";

        return str;
    }

    void addremove() {
        System.out.println("\n\n\n We have following discounts: ");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "->" + discount.get(i));
        }
        System.out.println("\n\nEnter the choice: " + "\n1. Add new discount: " + "\n2. Remove a discount");
        int ans = sc.nextInt();

        switch (ans) {
        case 1:
            System.out.println("Enter the discount: ");
            String temp = scan.next();
            discount.add(temp);
            break;
        case 2:
            System.out.println("Enter the choice you want to remove");
            int c = sc.nextInt();
            discount.remove(c - 1);
            break;
        }
        System.out.println("Done.");
    }

    void insert(int from, int to) {
        node temp;
        temp = new node(to);
        if (head[from] == null) {
            head[from] = temp;
        } else {
            node p = head[from];
            while (p.link != null) {
                p = p.link;
            }
            p.link = temp;
        }
    }

    int ch, n;
    String s;

    void takeOrder() {

        // Taking order
                System.out.println("Welcome!!!....Enter your order");
                System.out.println("We have following products available");                
        do {
            System.out.println("\n");
            System.out.println(
                    "1.Sarees\n2.Heels Scandals\n3.Flat Sandals\n4.Jewellery\n5.Make-Up\n6.Perfumes"
                    + "\n7.SportWear\n8.Shoes\n9.Jacket\n10.Sweatshirts\n11.T-Shirt\n12.Tops\n13.Kurtas"
                    + "\n14.Leggings\n15.Jeans\n16.Don't want to buy more???");

            System.out.println("\nEnter your choice to buy product:");
            ch = sc.nextInt();
            
            s = dis(ch);
            if (s == null) {
                System.out.println("Thank You, visit again!");
            } else {
                System.out.println("Your Product " + s + " is Booked");

                // 3. keep adding the ordered products in the arraylist/else.
                a.add(s);

                // giving recommendations.
                node p = head[ch];
                p = p.link;
                System.out.println("\nWe recommend you to buy");
                while (p != null) {
                    n = p.data;
                    s = dis(n);
                    System.out.println(s);
                    p = p.link;
                }
                // Displaying Discount
                System.out.println("\n\n\nWe have following Offers");
                for (int i = 0; i < discount.size(); i++) {
                    System.out.println(discount.get(i));
                }
                // Displaying cart
                System.out.println("\nYour Cart contains Product....");
                for (int i=0; i<a.size(); i++) {
                        System.out.print(a.get(i)+"\n"); 
                }            
            }
        }while(ch!=16);System.out.println("\n\n\n");
}}

class centre {
    /*
     * variables: hard coded map object. order object. godown class objects, say 4.
     * godownID
     */
    // Adding variables for djisktra
    int gd = 0;
    Scanner sc = new Scanner(System.in);
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    order o = new order();
    godown g1 = new godown();
    godown g2 = new godown();
    godown g3 = new godown();

    float ADM[][] = new float[14][14];
    String names[] = new String[14];
    int gn[] = new int[3];

    float dist[] = new float[14];
    float sd[] = new float[3]; // distance of destination from each godown
    int visited[] = new int[14];
    int pred[] = new int[14];
    int cnt = 0;

    void hardcodedMap() {
        o.list();
        gn[0] = 0;
        gn[1] = 4;
        gn[2] = 9; // godown1 = 0, godown2 = 4, godown3 = 9;

        names[0] = "Godown1              ";
        names[1] = "Chandani Chowk       ";
        names[2] = "Warje Malwadi        ";
        names[3] = "Mahatma Society      ";
        names[4] = "Godown2              ";
        names[5] = "Shaniwar Wada        ";
        names[6] = "Pandit Neharu Stadium";
        names[7] = "COEP                 ";
        names[8] = "Mangala CityPride    ";
        names[9] = "Godown3              ";
        names[10] = "Film Institute      ";
        names[11] = "Erandwane           ";
        names[12] = "Model colony        ";
        names[13] = "SPPU                ";

        ADM[0][0] = 999;
        ADM[0][1] = (float) 7.6;
        ADM[0][2] = 4;
        ADM[0][3] = (float) 3.8;
        ADM[0][4] = 10;
        ADM[0][5] = 8;
        ADM[0][6] = 6;
        ADM[0][7] = 10;
        ADM[0][8] = 11;
        ADM[0][9] = 11;
        ADM[0][10] = 5;
        ADM[0][11] = (float) 4.9;
        ADM[0][12] = 8;
        ADM[0][13] = 10;
        ADM[1][0] = ADM[0][1];
        ADM[2][0] = ADM[0][2];
        ADM[3][0] = ADM[0][3];
        ADM[4][0] = ADM[0][4];
        ADM[5][0] = ADM[0][5];
        ADM[6][0] = ADM[0][6];
        ADM[7][0] = ADM[0][7];
        ADM[8][0] = ADM[0][8];
        ADM[9][0] = ADM[0][9];
        ADM[10][0] = ADM[0][10];
        ADM[11][0] = ADM[0][11];
        ADM[12][0] = ADM[0][12];
        ADM[13][0] = ADM[0][13];
        ADM[1][1] = 999;
        ADM[1][2] = (float) 7.9;
        ADM[1][3] = 4;
        ADM[1][4] = 10;
        ADM[1][5] = (float) 9.5;
        ADM[1][6] = 10;
        ADM[1][7] = 14;
        ADM[1][8] = 12;
        ADM[1][9] = (float) 9.7;
        ADM[1][10] = (float) 6.3;
        ADM[1][11] = (float) 6.7;
        ADM[1][12] = 10;
        ADM[1][13] = 10;
        ADM[2][1] = ADM[1][2];
        ADM[3][1] = ADM[1][3];
        ADM[4][1] = ADM[1][4];
        ADM[5][1] = ADM[1][5];
        ADM[6][1] = ADM[1][6];
        ADM[7][1] = ADM[1][7];
        ADM[8][1] = ADM[1][8];
        ADM[9][1] = ADM[1][9];
        ADM[10][1] = ADM[1][10];
        ADM[11][1] = ADM[1][11];
        ADM[12][1] = ADM[1][12];
        ADM[13][1] = ADM[1][13];
        ADM[2][2] = 999;
        ADM[2][3] = (float) 4.6;
        ADM[2][4] = (float) 8.5;
        ADM[2][5] = (float) 8.6;
        ADM[2][6] = (float) 7.4;
        ADM[2][7] = (float) 12;
        ADM[2][8] = (float) 8.9;
        ADM[2][9] = (float) 9.3;
        ADM[2][10] = (float) 5.3;
        ADM[2][11] = (float) 5.7;
        ADM[2][12] = (float) 8.5;
        ADM[2][13] = (float) 9;
        ADM[3][2] = ADM[2][3];
        ADM[4][2] = ADM[2][4];
        ADM[5][2] = ADM[2][5];
        ADM[6][2] = ADM[2][6];
        ADM[7][2] = ADM[2][7];
        ADM[8][2] = ADM[2][8];
        ADM[9][2] = ADM[2][9];
        ADM[10][2] = ADM[2][10];
        ADM[11][2] = ADM[2][11];
        ADM[12][2] = ADM[2][12];
        ADM[13][2] = ADM[2][13];
        ADM[3][3] = 999;
        ADM[3][4] = (float) 7.7;
        ADM[3][5] = (float) 7.8;
        ADM[3][6] = (float) 7.3;
        ADM[3][7] = (float) 11;
        ADM[3][8] = (float) 7.3;
        ADM[3][9] = (float) 8.7;
        ADM[3][10] = (float) 3.7;
        ADM[3][11] = (float) 5.1;
        ADM[3][12] = (float) 6.8;
        ADM[3][13] = (float) 8.4;
        ADM[4][3] = ADM[3][4];
        ADM[5][3] = ADM[3][5];
        ADM[6][3] = ADM[3][6];
        ADM[7][3] = ADM[3][7];
        ADM[8][3] = ADM[3][8];
        ADM[9][3] = ADM[3][9];
        ADM[10][3] = ADM[3][10];
        ADM[11][3] = ADM[3][11];
        ADM[12][3] = ADM[3][12];
        ADM[13][3] = ADM[3][13];
        ADM[4][4] = 999;
        ADM[4][5] = (float) 0.75;
        ADM[4][6] = (float) 1.8;
        ADM[4][7] = (float) 2.7;
        ADM[4][8] = (float) 1.9;
        ADM[4][9] = (float) 3.7;
        ADM[4][10] = (float) 3.6;
        ADM[4][11] = (float) 3.1;
        ADM[4][12] = (float) 4;
        ADM[4][13] = (float) 6.1;
        ADM[5][4] = ADM[4][5];
        ADM[6][4] = ADM[4][6];
        ADM[7][4] = ADM[4][7];
        ADM[8][4] = ADM[4][8];
        ADM[9][4] = ADM[4][9];
        ADM[10][4] = ADM[4][10];
        ADM[11][4] = ADM[4][11];
        ADM[12][4] = ADM[4][12];
        ADM[13][4] = ADM[4][13];
        ADM[5][5] = 999;
        ADM[5][6] = (float) 3.1;
        ADM[5][7] = (float) 2.5;
        ADM[5][8] = (float) 1;
        ADM[5][9] = (float) 3.8;
        ADM[5][10] = (float) 3.7;
        ADM[5][11] = (float) 3.2;
        ADM[5][12] = (float) 3.1;
        ADM[5][13] = (float) 4.3;
        ADM[6][5] = ADM[5][6];
        ADM[7][5] = ADM[5][7];
        ADM[8][5] = ADM[5][8];
        ADM[9][5] = ADM[5][9];
        ADM[10][5] = ADM[5][10];
        ADM[11][5] = ADM[5][11];
        ADM[12][5] = ADM[5][12];
        ADM[13][5] = ADM[5][13];
        ADM[6][6] = 999;
        ADM[6][7] = (float) 4.5;
        ADM[6][8] = (float) 3;
        ADM[6][9] = (float) 5.8;
        ADM[6][10] = (float) 4.5;
        ADM[6][11] = (float) 3.8;
        ADM[6][12] = (float) 4.7;
        ADM[6][13] = (float) 6.8;
        ADM[7][6] = ADM[6][7];
        ADM[8][6] = ADM[6][8];
        ADM[9][6] = ADM[6][9];
        ADM[10][6] = ADM[6][10];
        ADM[11][6] = ADM[6][11];
        ADM[12][6] = ADM[6][12];
        ADM[13][6] = ADM[6][13];
        ADM[7][7] = 999;
        ADM[7][8] = (float) 1.2;
        ADM[7][9] = (float) 3.3;
        ADM[7][10] = (float) 4.3;
        ADM[7][11] = (float) 3.8;
        ADM[7][12] = (float) 2.6;
        ADM[7][13] = (float) 5;
        ADM[8][7] = ADM[7][8];
        ADM[9][7] = ADM[7][9];
        ADM[10][7] = ADM[7][10];
        ADM[11][7] = ADM[7][11];
        ADM[12][7] = ADM[7][12];
        ADM[13][7] = ADM[7][13];
        ADM[8][8] = 999;
        ADM[8][9] = 3;
        ADM[8][10] = (float) 3.8;
        ADM[8][11] = (float) 3.3;
        ADM[8][12] = (float) 2.4;
        ADM[8][13] = (float) 3.6;
        ADM[9][8] = ADM[8][9];
        ADM[10][8] = ADM[8][10];
        ADM[11][8] = ADM[8][11];
        ADM[12][8] = ADM[8][12];
        ADM[13][8] = ADM[8][13];
        ADM[9][9] = 999;
        ADM[9][10] = (float) 3.8;
        ADM[9][11] = (float) 5.3;
        ADM[9][12] = (float) 0.75;
        ADM[9][13] = (float) 2;
        ADM[10][9] = ADM[9][10];
        ADM[11][9] = ADM[9][11];
        ADM[12][9] = ADM[9][12];
        ADM[13][9] = ADM[9][13];
        ADM[10][10] = 999;
        ADM[10][11] = (float) 1.2;
        ADM[10][12] = (float) 3.1;
        ADM[10][13] = (float) 4.8;
        ADM[11][10] = ADM[10][11];
        ADM[12][10] = ADM[10][12];
        ADM[13][10] = ADM[10][13];
        ADM[11][11] = 999;
        ADM[11][12] = (float) 3.9;
        ADM[11][13] = (float) 5.7;
        ADM[12][11] = ADM[11][12];
        ADM[13][11] = ADM[11][13];
        ADM[12][12] = 999;
        ADM[12][13] = (float) 2.9;
        ADM[13][12] = ADM[12][13];
        ADM[13][13] = 999;

    }

    void order() {
        o.takeOrder();
        System.out.println("Enter the customer details: ");
        System.out.println("Name: ");
        o.ord.name = sc.next(); // try delimiter
        String mn;
        while (true) {
            System.out.println("Mobile number: ");
            mn = sc.next();
            if (mn.length() == 10)
                break;
            else
                System.out.println("Invalid mobile number, please enter again: ");
        }
        o.ord.mobile = mn;
        System.out.println("\nReceipt:\n\nCustomer name:"+o.ord.name+"\nMobile Number:"+o.ord.mobile);
        System.out.println("\nYour cart contains:");
        for (int i=0; i<o.a.size(); i++) 
        {
            System.out.print(o.a.get(i)+"\n"); 
        }
        System.out.println("The landmarks and destination codes are: ");
        
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        int i = 0, dest = 0;
        System.out.println("\nLandmarks\t\tCode:");
        for(int l=0;l<14;l++)
        {
            if(l!=0&&l!=4&&l!=9)
                System.out.println(names[l]+" :  "+l);
        }
        System.out.println("Enter the nearest landmark code: ");
        dest = sc.nextInt();    
        o.ord.destCode = dest;
    }

    float path(int st) { // finds the dist between godown and destination.
        // st: godown index

        float min = 999;
        int next = 0;
        for (int i = 0; i < 14; i++) {
            dist[i] = ADM[st][i];
            visited[i] = 0;
            pred[i] = st;
        }

        visited[st] = 1;
        dist[st] = 0;
        int c=(o.ord.destCode-st)+1;
        
        while (cnt < c) {
            min = 999;
            for (int i = 0; i < 14; i++) {
                if (visited[i] != 1 && dist[i] < min) {
                    min = dist[i];
                    next = i;
                }
            }
            cnt++;
            visited[next] = 1;
            for (int w = 0; w < 14; w++) {
                if (ADM[next][w] != 999 && visited[w] != 1) {
                    if (dist[w] > (dist[next] + ADM[next][w])) {
                        dist[w] = (dist[next] + ADM[next][w]);
                        pred[w] = next;
                    }
                }
            }
        }

        return dist[o.ord.destCode];
    }

    void shortest() { // return godown id
        sd[0] = path(0);
        sd[1] = path(4);
        sd[2] = path(9);
        for (int i = 0; i < 3; i++) {
            if (sd[gd] > sd[i])
                gd = i;
        }
        path(gn[gd]);
    }

    void display() // Function to display
    {
        System.out.println("Shortest distance is:" + sd[gd]+" Kms.");
        System.out.println("The route is: ");
        System.out.println(o.ord.destCode);
        int a = pred[o.ord.destCode];
        System.out.println(a);
        while (a != gn[gd] ) {
            a = pred[a];
            System.out.println(a+"->");
        }
    }

    void shipOrder() {
        // call sendDelivery() for the godownID object.
        int flag = 1;
        if (gd == 0)
            flag = g1.sendDelivery(o.ord);
        else if (gd == 1)
            flag = g2.sendDelivery(o.ord);
        else if (gd == 2)
            flag = g3.sendDelivery(o.ord);

        if (flag == 0) {
            System.out.println("The order is delivered to godown: " + gn[gd]);
            System.out.println("To view details enter 1");
            int ans = sc.nextInt();
            if (ans == 1)
                display();
        }

        else {
            float min = 999;
            System.out
                    .println("The order was delivered to godown " + gd + ". But due to waiting, it is delivered to: ");
            for (int i = 0; i < 3 && i != gd; i++) {
                if (min > sd[i]) {
                    min = sd[i];
                    gd = i;
                }
            }
            System.out.println("Godown " + gd);
            shipOrder();
        }

    }

}

public class dsa2Main {
    public static void main(String args[]) {
        centre c = new centre();
        Scanner sc = new Scanner(System.in);
        c.hardcodedMap();
        int ans=1;
        do {
        	System.out.println("Enter the operation: "
        			+ "\n1.Take order"
        			+ "\n2.Change discounts"
        			+ "\n0.Exit");
        	ans = sc.nextInt();
        	switch(ans) {
        	case 1:
        		c.order();
                c.shortest();
                c.shipOrder();
                System.out.println("Thank You! Order Again!!");
                break;
        	case 2:
        		c.o.addremove();
        		break;
        	}
        }while(ans != 0);
        
        
    }
}