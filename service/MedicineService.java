package service;

import model.Medicine;
import model.MedicineRecord;

import java.util.ArrayList;

//create class to store medicine data
public class MedicineService 
{

      //arraylist for medicine
    private ArrayList<Medicine> medicines;

      //arraylist for medicine record
    private ArrayList<MedicineRecord> records;

      //variable for medicine id
    private int nextId;

     //create constructor
    public MedicineService() 
    {

        medicines = new ArrayList<>();

        records = new ArrayList<>();

        nextId = 1;
    }

       //add medicine
    public Medicine addMedicine
    (
            int memberId,
            String name,
            String dosage,
            String time,
            int stock,
            int lowStockLimit
            ) 
            {

           //create new objectt
        Medicine medicine =new Medicine
                (
                        nextId,
                        memberId,
                        name,
                        dosage,
                        time,
                        stock,
                        lowStockLimit
                );
 
         //add medicine to arraylist
        medicines.add(medicine);

        nextId++;

        return medicine;
    }

        //return medicine data
    public ArrayList<Medicine> getMedicines() 
    {

        return medicines;
    }

     //search medicine by id
    public Medicine findMedicine(int id) 
    {

        for (Medicine medicine : medicines) 
        {

            if (medicine.getId() == id) 
            {

                return medicine;
            }
        }

        //return null if medicine not found
        return null;
    }

       //mark medicine as taken
    public void markTaken(int id) 
    {

        Medicine medicine =findMedicine(id);

        if (medicine == null) 
        {

            System.out.println("Medicine not found.");

            return;
        }

         //check if stock is available
        if (medicine.getStock() > 0) 
        {

            medicine.takeMedicine();

            MedicineRecord record =new MedicineRecord
            (
                            id,
                            "TAKEN"
                    );

            records.add(record);

        } 
        else 
        {

            System.out.println("Cannot mark medicine as taken.");
        }
    }

      //mark medicine as missed
    public void markMissed(int id) 
    {

        Medicine medicine =findMedicine(id);

        if (medicine == null) 
        {

            System.out.println("Medicine not found.");

            return;
        }

         //check if stock is available
        MedicineRecord record =new MedicineRecord
        (
                        id,
                        "MISSED"
                );

        records.add(record);

        System.out.println("Medicine marked as missed.");
    }

     //get method to return data of medicine record
    public ArrayList<MedicineRecord> getRecords() 
    {

        return records;
    }
}