package model;

import java.time.LocalDateTime;

//create class to store medicine data
public class MedicineRecord 
{

    private int medicineId;
    private String status;
    private LocalDateTime time;

      //create constructor
    public MedicineRecord
    (
            int medicineId,
            String status
            ) 
            {

        this.medicineId = medicineId;
        this.status = status;

        //currentbd date and time
        this.time = LocalDateTime.now();
    }

     //create getter method
    public int getMedicineId() 
    {
        return medicineId;
    }

     //get method to return data of medicine
    public String getStatus() 
    {
        return status;
    }

    public LocalDateTime getTime() 
    {
        return time;
    }

         //display record
    @Override
    public String toString() 
    {

         //display record
        return "Medicine ID: "
                + medicineId
                + " | Status: "
                + status
                + " | Time: "
                + time;
    }
}