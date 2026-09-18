import gui.DashboardFrame;
import service.FamilyServices;
import service.MedicineService;

import javax.swing.SwingUtilities;

public class Main 
{

    public static void main(String[] args) 
    {

        SwingUtilities.invokeLater(() -> 
        {
            // creating object
            FamilyServices familyServices = new FamilyServices();
            MedicineService medicineService = new MedicineService();

            //family member
            familyServices.addMember
            (
                    "Lata",
                    65,
                    "Grandmother"
            );

            //medicine
            medicineService.addMedicine
            (
                    1,
                    "BP Tablet",
                    "1 Tablet",
                    "08:00 AM",
                    10,
                    5
            );
             
               //create dashboard
            DashboardFrame dashboard =new DashboardFrame
                    (
                            familyServices,
                            medicineService
                    );
 
            //display dashboard
            dashboard.setVisible(true);
        }
        );
    }
}