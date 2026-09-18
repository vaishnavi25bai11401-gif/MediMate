package model;

//create class to medicine
public class Medicine 
{

    //input variable
    private int id;
    private int memberId;
    private String name;
    private String dosage;
    private String time;
    private int stock;
    private int lowStockLimit;

    //create constructor
    public Medicine
    (
            int id,
            int memberId,
            String name,
            String dosage,
            String time,
            int stock,
            int lowStockLimit
            ) 
            {

        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.dosage = dosage;
        this.time = time;
        this.stock = stock;
        this.lowStockLimit = lowStockLimit;
    }

    //create getter method
    public int getId() 
    {
        return id;
    }

    public int getMemberId() 
    {
        return memberId;
    }

    public String getName() 
    {
        return name;
    }

    public String getDosage() 
    
    {
        return dosage;
    }

    public String getTime() 
    {
        return time;
    }

    public int getStock() 
    {
        return stock;
    }

     //get method to return data of medicine
    public void takeMedicine() 
    {

        // check if stock aveilable
        if (stock > 0) 
        {
           // reduce stock by 1
            stock--;

            System.out.println("Medicine marked as taken.");

            //if stock is low alert
            if (stock <= lowStockLimit) 
            {

                System.out.println("LOW STOCK ALERT: "+ name);
            }

        } 
        else 
        {
 
             //display when stock empty
            System.out.println("Medicine stock is empty.");
        }
    }

      //convert details into string
    @Override
    public String toString() 
    {

        return id
                + " | "
                + name
                + " | Dosage: "
                + dosage
                + " | Time: "
                + time
                + " | Stock: "
                + stock;
    }
}