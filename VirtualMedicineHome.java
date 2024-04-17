import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VirtualMedicineHome {

    private JFrame frame;
    private JPanel panel;
    private JButton addDoctorButton;
    private JButton managePatientsButton;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public VirtualMedicineHome() {
        frame = new JFrame("Virtual Medicine Home - Admin Module");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel(new GridLayout(2, 1));

        addDoctorButton = new JButton("Add Doctor");
        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter doctor's name:");
                String speciality = JOptionPane.showInputDialog(frame, "Enter doctor's speciality:");
                Doctor doctor = new Doctor(name, speciality);
                doctors.add(doctor);
                JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
            }
        });

        managePatientsButton = new JButton("Manage Patients");
        managePatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Patient patient : patients) {
                    sb.append(patient.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString());
            }
        });

        panel.add(addDoctorButton);
        panel.add(managePatientsButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VirtualMedicineHome();
            }
        });
    }

    private class Doctor {
        private String name;
        private String speciality;
        private List<Patient> assignedPatients = new ArrayList<>();

        public Doctor(String name, String speciality) {
            this.name = name;
            this.speciality = speciality;
        }

        public void addPatient(Patient patient) {
            assignedPatients.add(patient);
        }

        @Override
        public String toString() {
            return "Doctor{name='" + name + "', speciality='" + speciality + "', assignedPatients=" + assignedPatients.size() + "}";
        }
    }

    private class Patient {
        private String name;
        private String condition;
        private Doctor attendingDoctor;

        public Patient(String name, String condition) {
            this.name = name;
            this.condition = condition;
        }

        public void setAttendingDoctor(Doctor doctor) {
            this.attendingDoctor = doctor;
            doctor.addPatient(this);
        }

        @Override
        public String toString() {
            return "Patient{name='" + name + "', condition='" + condition + "', attendingDoctor=" + attendingDoctor.name + "}";
        }
    }
}
