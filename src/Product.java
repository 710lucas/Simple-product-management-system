import  java.util.ArrayList;

public class Product{

    private int Price;
    private String Name;
    private String Id;
    private int Quantity = 0;

    //Getters
    public int getPrice(){
        return Price;
    }

    public int getQuantity(){
        return Quantity;
    }

    public String getName(){
        return Name;
    }

    public String getId(){
        return Id;
    }


    //Setters
    public void setPrice(int Price){
        this.Price = Price;
    }

    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setId(String id){
        this.Id = id;
    }


    //Constructor
    public Product(String name, int Price, int Quantity){
        this.setName(name);
        this.setPrice(Price);
        this.setQuantity(Quantity);
    }


    //misc
    public int generateId(ArrayList<Product> productList){
        int i = 0;
        for(; i<productList.size(); i++){;}
        return i;
    }

    public void increaseQuantity(int Quantity){
        this.Quantity+=Quantity;
    }

    public void decreaseQuantity(int Quantity){
        this.Quantity-=Quantity;
    }

    public void changePrice(int Price){
        this.Price = Price;
    }

    public void increasePrice(int Price){
        this.Price+=Price;
    }

    public void decreasePrice(int Price){
        this.increasePrice(-Price);
    }



}