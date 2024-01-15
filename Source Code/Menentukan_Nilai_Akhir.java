package menentukan_nilai_akhir;

import java.util.Scanner;

public class Menentukan_Nilai_Akhir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        class Student {
            private String name;
            private String nim;
            private double score;

            public Student(String name, String nim) {
                this.name = name;
                this.nim = nim;
                this.score = 0.0;
            }

            public double getScore() {
                return score;
            }

            public String getName() {
                return name;
            }

            public String getNim() {
                return nim;
            }

            public void setScore(double score) {
                this.score = score;
            }
        }

        class GradeCalculator {
            private Student student;
            private String courseName;  // Menambahkan atribut untuk nama mata kuliah

            public GradeCalculator(Student student, String courseName) {
                this.student = student;
                this.courseName = courseName;
            }

            public void calculateFinalGrade(double assignmentScore, double midtermScore, double finalScore) {
                double weightedScore = (assignmentScore * 0.3) + (midtermScore * 0.3) + (finalScore * 0.4);
                student.setScore(weightedScore);
            }

            public String getCourseName() {
                return courseName;
            }
        }

        // Membuat objek mahasiswa
        System.out.print("Masukkan nama mahasiswa: ");
        String studentName = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String studentNim = scanner.nextLine();
        Student student = new Student(studentName, studentNim);

        // Membuat objek penghitung nilai
        System.out.print("Masukkan nama mata kuliah: ");
        String courseName = scanner.nextLine();
        GradeCalculator gradeCalculator = new GradeCalculator(student, courseName);

        // Masukkan nilai secara manual
        System.out.print("Masukkan nilai tugas: ");
        double assignmentScore = scanner.nextDouble();
        System.out.print("Masukkan nilai ujian tengah semester: ");
        double midtermScore = scanner.nextDouble();
        System.out.print("Masukkan nilai ujian akhir semester: ");
        double finalScore = scanner.nextDouble();

        // Hitung nilai akhir
        gradeCalculator.calculateFinalGrade(assignmentScore, midtermScore, finalScore);

        // Cetak hasil
        System.out.println("\nNama Mahasiswa: " + student.getName());
        System.out.println("NIM: " + student.getNim());
        System.out.println("Mata Kuliah: " + gradeCalculator.getCourseName());
        System.out.println("Nilai Akhir: " + student.getScore());
    }
}