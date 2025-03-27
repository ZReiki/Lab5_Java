package main.service;

import main.logic.PatientRepository;

import main.logic.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class PatientRepositoryTextImpl implements PatientRepository {
    @Override
    public void outputArray(Patient[] patients, File file){
        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))){
            if(patients != null){
                for(Patient patient : patients){
                    out.println(patient.getId() + "; " +
                            patient.getFullName() + "; " +
                            patient.getAddress() + "; " +
                            patient.getPhoneNumber() + "; " +
                            patient.getMedicalRecordNumber() + "; " +
                            patient.getMedicalDiagnosis() + "; " +
                            patient.getLastDateVisit() + "; ");
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }
    }

    @Override
    public void outputArray(Patient[] patients, String fileName){
        File file = new File(fileName);
        outputArray(patients, file);
    }

    @Override
    public Patient[] readArray(File file){
        int size = 5;
        int counter = 0;
        Patient[] patients = new Patient[size];
        try(BufferedReader in = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            while((line = in.readLine()) != null) {
                String[] tokens = line.split("; ");
                if (tokens.length == 7) {
                    patients[counter] = new Patient(
                            Integer.parseInt(tokens[0]),
                            tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4]),
                            tokens[5],
                            tokens[6]
                    );
                }
                counter++;
            }
        }catch (IOException e){
            System.out.println("File not found");
        }
        return patients;
    }

    @Override
    public Patient[] readArray(String fileName){
        File file = new File(fileName);
        return readArray(file);
    }
}
