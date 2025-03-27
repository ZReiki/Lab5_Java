package main.controller;

import main.io.*;
import java.util.*;
import main.logic.*;
import main.service.*;

public class PatientController {
    private final PatientService service = new PatientService();
    private final View view = new View();
    private final Scanner scanner = new Scanner(System.in);
    private final MenuPrinter menuOptions = new MenuPrinter();
    private final PatientRepositoryTextImpl txtFileService = new PatientRepositoryTextImpl();
    private final PatientRepositoryBinaryImpl binaryFileService = new PatientRepositoryBinaryImpl();

    public void controller(Patient[] patients) {
        exitLabel:
        while (true) {
            // write menu options
            menuOptions.menuOptions();

            // enter menu option
            int menu;
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1 -> {
                    System.out.print("Enter the diagnosis: ");
                    String diagnosis = scanner.nextLine();
                    view.showPatient(service.listOfPatientsWithTheSpecifiedDiagnosis(patients, diagnosis));
                }
                case 2 -> {
                    System.out.print("Enter the first interval number: ");
                    int first = scanner.nextInt();
                    System.out.print("Enter the last interval number: ");
                    int last = scanner.nextInt();
                    view.showPatient(service.listOfPatientsWhoseMedicalRecordNumberIsWithinTheSpecifiedInterval(patients, first, last));
                }
                case 3 -> {
                    System.out.print("Enter the first phone number: ");
                    String firstPhoneNumber = scanner.nextLine();
                    view.showPatient(service.quantityAndListOfPatientsWhosePhoneNumberBeginsWithTheSpecifiedDigit(patients, firstPhoneNumber));
                }
                case 4 ->{
                    String fileName = "patients.txt";
                    txtFileService.outputArray(patients, fileName);
                }
                case 5 ->{
                    String fileName = "patients.txt";
                    patients = txtFileService.readArray(fileName);
                }
                case 6 ->{
                    String fileName = "patients.bin";
                    binaryFileService.outputArray(patients, fileName);
                }
                case 7 ->{
                    String fileName = "patients.bin";
                    patients = binaryFileService.readArray(fileName);
                }
                case 0 -> {
                    break exitLabel;
                }
                default -> System.out.println("Invalid menu option");
            }
        }
    }
}