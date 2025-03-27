package main.io;

import main.logic.Patient;

public class View {
    public void showPatient(Patient[]  patients) {
        if (patients.length != 0) {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }else{
            System.out.println("There are no patients with this information.");
        }
    }
}