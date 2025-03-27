package main.service;

import main.logic.Patient;
import main.logic.PatientRepository;

import java.io.*;
import java.nio.file.Files;

public class PatientRepositoryBinaryImpl implements PatientRepository {
    @Override
    public void outputArray(Patient[] patients, File file){
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()))){
            out.writeObject(patients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputArray(Patient[] patients, String fileName){
        File file = new File(fileName);
        outputArray(patients, file);
    }

    @Override
    public Patient[] readArray(File file){
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()))){
            return (Patient[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient[] readArray(String fileName){
        File file = new File(fileName);
        return readArray(file);
    }
}
