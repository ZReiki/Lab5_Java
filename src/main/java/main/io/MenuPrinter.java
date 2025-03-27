package main.io;

public class MenuPrinter {
    public void menuOptions() {
        System.out.print("""
                    Menu:
                    1. List of Patients with the specified diagnosis;
                    2. List of Patients whose medical record number is within the specified interval;
                    3. Quantity and list of Patients whose phone number begins with the specified digit
                    4. Write the list of Patients in the txt file;
                    5. Read the list of Patients from the txt file;
                    6. Write the list of Patients in the binary file;
                    7. Read the list of Patients from the binary file;
                    0. Exit
                    Your option >>\s""");
    }
}
