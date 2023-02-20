import java.util.ArrayList;
import java.util.Scanner;


class Main{

    static ArrayList<Product> products = new ArrayList<Product>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]){
        int input = 0;

        while(input != 10){
            clearConsole();
            displayMenu();
            input = scan.nextInt();
            scan.nextLine();
            inputHandler(input);


        }

        scan.close();

    }

    static void printSpaces(int amount, String reference){
        for(int i = 0; i<amount-reference.length(); i++){
            System.out.print(" ");
        }
    }

    static void displayProducts(){
        System.out.print("Name");
        printSpaces(26, "Name");
        System.out.print("Price");
        printSpaces(26, "Price");
        System.out.print("Quantity");
        System.out.println();

        for(int i = 0; i<products.size(); i++){
            System.out.print(i+" - "+products.get(i).getName());
            printSpaces(26, i+" - "+products.get(i).getName());

            System.out.print(products.get(i).getPrice());
            printSpaces(26, Integer.toString(products.get(i).getPrice()));
            System.out.print(""+products.get(i).getQuantity());
            System.out.println();
        }
        System.out.println("\n");
    }

    static void clearConsole(){
        try{
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void displayMenu(){
        displayProducts();
        System.out.println("-------------------------------------------------------------");
        System.out.print("1 - New product\t\t\t\t");
        System.out.print("2 - Remove product\n");
        System.out.print("3 - Increase product quantity\t\t");
        System.out.print("4 - Change price\n");
        System.out.print("5 - Sell product\t\t\t\t");
        System.out.print("10 - Exit\n");
    }

    static void inputHandler(int input){
        int prodNumber;
        switch(input){
            case 1:
                System.out.print("Product name: ");
                String name = scan.nextLine();
                int price, quantity;
                System.out.print("price: ");
                price = scan.nextInt();
                System.out.print("quantity: ");
                quantity = scan.nextInt();
                products.add(new Product(name, price, quantity));
                System.out.println("New product created.");
                break;
            
            case 2:
                do{
                    System.out.print("Insert product number to remove: ");
                    prodNumber = scan.nextInt();
                } while(prodNumber >= products.size());

                products.remove(prodNumber);
                System.out.println("Product removed");
                break;

            case 3:
                do{
                    System.out.print("Insert product number to increase quantity: ");
                    prodNumber = scan.nextInt();
                } while(prodNumber >= products.size());

                System.out.print("Quantity to increase: ");
                int increaseQuantity = scan.nextInt();
                products.get(prodNumber).increaseQuantity(increaseQuantity);
                System.out.println("Quantity increased");
            break;

            case 4:
                do{
                    System.out.print("Insert product number to change price: ");
                    prodNumber = scan.nextInt();
                } while(prodNumber >= products.size());
                System.out.print("inser new price for the "+products.get(prodNumber)+" product");
                int newPrice = scan.nextInt();
                products.get(prodNumber).changePrice(newPrice);

            break;

            case 5:
                do{
                    System.out.print("Insert product number that's being sold: ");
                    prodNumber = scan.nextInt();
                    scan.nextLine();
                }while(prodNumber >= products.size());
                System.out.print("Does it have a discount?\n[y/n]: ");
                String confirm = scan.nextLine();
                double percentage = 100;
                if(confirm.equalsIgnoreCase("Y")){
                    System.out.print("What's the percentage of the discount(type just the number, without the % character): ");
                    percentage = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Client needs to pay $"+products.get(prodNumber).getPrice()*(1-percentage/100));
                System.out.println("When payment is done, type Y");
                scan.nextLine();
                products.get(prodNumber).decreaseQuantity(1);

            break;

            default:
                break;
        
        }
    }

}