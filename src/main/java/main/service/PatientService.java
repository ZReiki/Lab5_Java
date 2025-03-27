package main.service;

import main.logic.Patient;
import java.util.Arrays;

public class PatientService {
    public Patient[] listOfPatientsWithTheSpecifiedDiagnosis(Patient[] patients, String diagnosis){
        Patient[] resultList = new Patient[patients.length];
        int counter = 0;
        for (Patient patient : patients){
            if(patient.getMedicalDiagnosis().equals(diagnosis)){
                resultList[counter] = patient;
                counter++;
            }
        }
        return Arrays.copyOf(resultList, counter);
    }

    public Patient[] listOfPatientsWhoseMedicalRecordNumberIsWithinTheSpecifiedInterval(Patient[] patients, int minInterval, int maxInterval){
        Patient[] resultList = new Patient[patients.length];
        int counter = 0;
        for (Patient patient : patients){
            if(patient.getMedicalRecordNumber() >= minInterval && patient.getMedicalRecordNumber() <= maxInterval){
                resultList[counter] = patient;
                counter++;
            }
        }
        return Arrays.copyOf(resultList, counter);
    }

    public Patient[] quantityAndListOfPatientsWhosePhoneNumberBeginsWithTheSpecifiedDigit(Patient[] patients, String phoneNumberDigit){
        Patient[] resultList = new Patient[patients.length];
        int counter = 0;
        for (Patient patient : patients){
            String phoneNumberFirstDigit = patient.getPhoneNumber().substring(4, 5);
            if(phoneNumberDigit.equals(phoneNumberFirstDigit)){
                resultList[counter] = patient;
                counter++;
            }
        }
        return Arrays.copyOf(resultList, counter);
    }
}
