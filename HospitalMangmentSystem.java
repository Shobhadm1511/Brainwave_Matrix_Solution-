
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

class Patient extends Person {
    int patientId;
    String disease;

    public Patient(int patientId, String name, int age, String gender, String disease) {
        super(name, age, gender);
        this.patientId = patientId;
        this.disease = disease;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender
                + ", Disease: " + disease);
    }
}

class Doctor extends Person {
    int doctorId;
    String specialization;

    public Doctor(int doctorId, String name, int age, String gender, String specialization) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender
                + ", Specialization: " + specialization);
    }
}

public class HospitalMangmentSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Search Patient");
            System.out.println("6. Search Doctor");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    viewPatients();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    searchPatient();
                    break;
                case 6:
                    searchDoctor();
                    break;
                case 7:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.add(new Patient(id, name, age, gender, disease));
        System.out.println("Patient added successfully!");
    }

    public static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(id, name, age, gender, specialization));
        System.out.println("Doctor added successfully!");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found!");
        } else {
            for (Patient p : patients) {
                p.display();
            }
        }
    }

    public static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found!");
        } else {
            for (Doctor d : doctors) {
                d.display();
            }
        }
    }

    public static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();
        for (Patient p : patients) {
            if (p.patientId == id) {
                p.display();
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    public static void searchDoctor() {
        System.out.print("Enter Doctor ID to search: ");
        int id = scanner.nextInt();
        for (Doctor d : doctors) {
            if (d.doctorId == id) {
                d.display();
                return;
            }
        }
        System.out.println("Doctor not found!");
    }
}
