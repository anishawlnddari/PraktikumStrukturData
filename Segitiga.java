import java.util.Scanner;

public class Segitiga<T extends Number> {

    private T alas, tinggi;

    public int getResultAsInt() {
        double luas = 0.5 * alas.intValue() * tinggi.intValue();
        return (int) luas;
    }

    public double getResultAsDouble() {
        return 0.5 * alas.doubleValue() * tinggi.doubleValue();
    }

    /// Constructor untuk inisialisasi nilai alas dan tinggi
    public Segitiga(T alas, T tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public static void main(String[] args) {
        /// fungsi scanner untuk menerima nilai alas tinggi
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("============================");
                System.out.println("==> HITUNG LUAS SEGITIGA <==");
                System.out.println("============================");
                System.out.println("Pilih tipe data input:\n1. Integer\n2. Double\n3. Keluar");
                System.out.print("Masukkan pilihan Anda: ");
                int pilihan = input.nextInt();

                if (pilihan == 1) {
                    System.out.println("Menghitung hasil luas dari Segitiga dalam 2 Tipe");
                    System.out.print("Masukan nilai Alas (Int) : ");
                    int alasInt = input.nextInt();
                    System.out.print("Masukan nilai Tinggi (Int) : ");
                    int tinggiInt = input.nextInt();

                    Segitiga<Integer> luasTipeInt = new Segitiga<>(alasInt, tinggiInt);
                    int hasilInt = luasTipeInt.getResultAsInt();
                    System.out.println("Berikut Hasil Dari Perhitungan :  " + hasilInt);
                } else if (pilihan == 2) {
                    System.out.print("Masukan nilai Alas (Double) : ");
                    double alasDouble = input.nextDouble();
                    System.out.print("Masukan nilai Tinggi (Double) : ");
                    double tinggiDouble = input.nextDouble();

                    Segitiga<Double> luasTipeDouble = new Segitiga<>(alasDouble, tinggiDouble);
                    double hasilDouble = luasTipeDouble.getResultAsDouble();
                    System.out.println("Berikut Hasil Dari Perhitungan : " + hasilDouble);
                } else if (pilihan == 3) {
                    break;
                } else {
                }
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}