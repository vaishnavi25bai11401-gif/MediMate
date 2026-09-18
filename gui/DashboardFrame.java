package gui;

import model.FamilyMember;
import model.Medicine;
import model.MedicineRecord;

import service.FamilyServices;
import service.MedicineService;

import javax.swing.*;
import java.awt.*;

//create class to display dashboard
public class DashboardFrame extends JFrame 
{

        //variable for family service
        private final FamilyServices familyServices;

    private MedicineService medicineService;

    private JTextArea output;

     //create constructor
    public DashboardFrame
    (
            FamilyServices familyService,
            MedicineService medicineService
            ) 
            {

        this.familyServices = familyService;

        this.medicineService = medicineService;

        //set title of dashboard
        setTitle
        (
                "MediMate - Family Health Dashboard"
        );
      
         //set size of dashboard
        setSize(900, 600);

        setDefaultCloseOperation
        (
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();

        refreshDashboard();
    }

     //create method to create GUI
    private void createGUI() 
    {

        setLayout
        (
                new BorderLayout()
        );

        //create 6title of dashboard
        JLabel title =
                new JLabel
                (
                        "MEDIMATE - FAMILY HEALTH DASHBOARD",
                        SwingConstants.CENTER
                );

         //font of title
        title.setFont
        (
                new Font
                (
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

         //add title to dashboard
        add
        (
                title,
                BorderLayout.NORTH
        );

        output =
                new JTextArea();

        output.setEditable(false);

         //set font of output
        output.setFont
        (
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

         //add output to dashboard
        add
        (
                new JScrollPane(output),
                BorderLayout.CENTER
        );
           //Create button panel
        JPanel buttonPanel =
                new JPanel();

          //buttons
        JButton refreshButton =
                new JButton("Refresh");

        JButton addMemberButton =
                new JButton("Add Family Member");

        JButton addMedicineButton =
                new JButton("Add Medicine");

        JButton takenButton =
                new JButton("Mark Taken");

        JButton missedButton =
                new JButton("Mark Missed");

        JButton recordsButton =
                new JButton("View Records");

          //add buttons to button panel
        buttonPanel.add
        (
                refreshButton
        );

        buttonPanel.add
        (
                addMemberButton
        );

        buttonPanel.add
        (
                addMedicineButton
        );

        buttonPanel.add
        (
                takenButton
        );

        buttonPanel.add
        (
                missedButton
        );

        buttonPanel.add
        (
                recordsButton
        );

        add
        (
                buttonPanel,
                BorderLayout.SOUTH
        );

        refreshButton.addActionListener
        (
                e -> refreshDashboard()
        );

         //open form to add family member
        addMemberButton.addActionListener
        (
                e -> addFamilyMember()
        );

        addMedicineButton.addActionListener
        (
                e -> addMedicine()
        );

        takenButton.addActionListener
        (
                e -> markMedicineTaken()
        );

        missedButton.addActionListener
        (
                e -> markMedicineMissed()
        );

        recordsButton.addActionListener
        (
                e -> showRecords()
        );
    }

      //create method to refresh dashboard
    private void refreshDashboard() 
    {

        StringBuilder result =
                new StringBuilder();

        result.append("========================================\n");

        result.append("FAMILY MEMBERS\n");

        result.append("========================================\n\n");
 
          //display family member details
        for 
        (
                FamilyMember member :
                familyServices.getMembers()
        ) 
        {

            result.append("ID: ").append(member.getId());

            result.append(" | Name: ").append(member.getName());

            result.append(" | Age: ").append( member.getAge());

            result.append(" | Relation: ").append(member.getRelationship());

            result.append("\n");
        }

        result.append("\n========================================\n");

        result.append("MEDICINES\n");

        result.append("========================================\n\n");

          //display medicine details
        for (
                Medicine medicine :
                medicineService.getMedicines()
        ) 
        {

             //find family member associated with medicine
            FamilyMember member =
                    familyServices.findMember(medicine.getMemberId());

            result.append("Medicine ID: ").append(medicine.getId());

            result.append("\nMember: ");

              //check if member is found
            if (member != null) 
            {

                result.append(member.getName());

            } 
            else 
            {

                result.append("Unknown");
            }

            result.append("\nMedicine: ").append(medicine.getName());

            result.append("\nDosage: ").append(medicine.getDosage() );

            result.append("\nTime: ").append(medicine.getTime());

            result.append("\nStock: ").append(medicine.getStock());

            result.append("\n----------------------------------------\n");
        }

          //display the result in the output text area
        output.setText(result.toString());
    }

        //create method to add family member
    private void addFamilyMember() 
    {

         //create input field
        JTextField nameField =
                new JTextField();

        JTextField ageField =
                new JTextField();

        JTextField relationshipField =
                new JTextField();

          //store input fields in an array
        Object[] fields = 
        {

                "Name:",
                nameField,

                "Age:",
                ageField,

                "Relationship:",
                relationshipField
        };

        //display input
        int result =
                JOptionPane.showConfirmDialog
                (
                        this,
                        fields,
                        "Add Family Member",
                        JOptionPane.OK_CANCEL_OPTION
                );

        //check if user clicked OK
        if 
        (
                result ==
                JOptionPane.OK_OPTION
        ) 
        {

            try 
            {

                String name =
                        nameField.getText();

                int age =
                        Integer.parseInt(
                                ageField.getText()
                        );

                String relationship =
                        relationshipField.getText();

                if 
                (
                        name.isEmpty()
                        ||
                        relationship.isEmpty()
                ) 
                {

                    JOptionPane.showMessageDialog
                    (
                            this,
                            "Please enter all details."
                    );

                    return;
                }

                   //add family member to the list
                familyServices.addMember
                (
                        name,
                        age,
                        relationship
                );

                JOptionPane.showMessageDialog
                (
                        this,
                        "Family member added successfully!"
                );

                 //update the dashboard 
                refreshDashboard();

            } 
            catch (NumberFormatException e)
             {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Age must be a number."
                );
            }
        }
    }

        //create method to add medicine
    private void addMedicine() 
    {

        JTextField memberIdField =
                new JTextField();

        JTextField medicineNameField =
                new JTextField();

        JTextField dosageField =
                new JTextField();

        JTextField timeField =
                new JTextField();

        JTextField stockField =
                new JTextField();

        //store input fields in an array
        Object[] fields = 
        {

                "Member ID:",
                memberIdField,

                "Medicine Name:",
                medicineNameField,

                "Dosage:",
                dosageField,

                "Time:",
                timeField,

                "Stock:",
                stockField
        };

        //display input
        int result =
                JOptionPane.showConfirmDialog
                (
                        this,
                        fields,
                        "Add Medicine",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (
                result ==
                JOptionPane.OK_OPTION
        ) 
        {

            try 
            {

                int memberId =
                        Integer.parseInt( memberIdField.getText());

                FamilyMember member =familyServices.findMember(memberId);

                 //check if member is found
                if (member == null) 
                {

                    JOptionPane.showMessageDialog
                    (
                            this,
                            "Member ID not found."
                    );

                    return;
                }

                String medicineName =
                        medicineNameField.getText();

                String dosage =
                        dosageField.getText();

                String time =
                        timeField.getText();

                int stock =
                        Integer.parseInt(stockField.getText());

                 //add medicine to the list
                medicineService.addMedicine
                (
                        memberId,
                        medicineName,
                        dosage,
                        time,
                        stock,
                        5
                );

                //display success message
                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine added successfully!"
                );

                 //update the dashboard
                refreshDashboard();

            } 
            catch (NumberFormatException e)
             {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Member ID and Stock must be numbers."
                );
            }
        }
    }

     //create method to mark medicine as taken
    private void markMedicineTaken() 
    {

          //ask user for medicine ID
        String input =
                JOptionPane.showInputDialog
                (
                        this,
                        "Enter Medicine ID:"
                );

         //stop if user cancels
        if (input == null) 
        {

            return;
        }

        try 
        {

             //conver id to integer
            int id =
                    Integer.parseInt(input);

            Medicine medicine =
                    medicineService.findMedicine(id);

            if (medicine == null) {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine not found."
                );

                return;
            }

              //check if stock is available
            if (medicine.getStock() == 0) 
            {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine stock is empty!"
                );

                return;
            }

             //mark medicine as taken
            medicineService.markTaken(id);

            if (medicine.getStock() <= 5) 
            {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine taken successfully.\n\n"
                        + "LOW STOCK ALERT!\n"
                        + medicine.getName()
                        + " has only "
                        + medicine.getStock()
                        + " left."
                );

            } 
            else 
            {

                    //display success message
                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine marked as TAKEN."
                );
            }

                   //update the dashboard
            refreshDashboard();

        } 
        catch (NumberFormatException e) 
        {

            JOptionPane.showMessageDialog
            (
                    this,
                    "Please enter a valid ID."
            );
        }
    }

     //create method to mark medicine as missed
    private void markMedicineMissed() 
    {

         //ask user for id of medicine
        String input =
                JOptionPane.showInputDialog
                (
                        this,
                        "Enter Medicine ID:"
                );

           //check if exist
        if (input == null) 
        {

            return;
        }

        try 
        {

            int id =
                    Integer.parseInt(input);

             //find medicine by id
            Medicine medicine =
                    medicineService.findMedicine(id);

            if (medicine == null) 
            {

                JOptionPane.showMessageDialog
                (
                        this,
                        "Medicine not found."
                );

                return;
            }

                //mark medicine as missed
            medicineService.markMissed(id);

            JOptionPane.showMessageDialog
            (
                    this,
                    "Medicine marked as MISSED."
            );

        } 
        catch (NumberFormatException e) 
        {

            JOptionPane.showMessageDialog
            (
                    this,
                    "Please enter a valid ID."
            );
        }
    }

     //create method to show medicine records
    private void showRecords() 
    {

        StringBuilder result =
                new StringBuilder();

        result.append("========================================\n");

        result.append("MEDICINE HISTORY\n");

        result.append("========================================\n\n");

           //check records
        if 
        (
                medicineService
                        .getRecords()
                        .isEmpty()
        ) 
        {

            result.append("No medicine records available.");

        } 
        else 
        {

            for 
            (
                    MedicineRecord record :
                    medicineService.getRecords()
            ) 
            {

                result.append(record);

                result.append("\n");
            }
        }

                //display the result in the output text area
        output.setText(result.toString());
    }
}