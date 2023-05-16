import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataPraktikan {

    private HashMap<String, String> tabelData;
    private HashMap<String, String> tabelSesiLogin;

    public DataPraktikan() {
        tabelData = new HashMap<String, String>();
        tabelSesiLogin = new HashMap<String, String>();

        tabelSesiLogin.put("Anishawulandari@umm.ac.id", "Anisha111");
        tabelSesiLogin.put("Anishawlnd@umm.ac.id", "Anisha111");
    }
    ///Mengembalikan true jika sudah terdapat key yang sama dalam sebuah HashMap tabel data
    public boolean tambahData(String nim, String namaAsisten) {
        if (nim.contains("IF") && !tabelData.containsKey(nim)) {
            tabelData.put(nim, namaAsisten);
            return true;
        } else {
            System.out.println("Gagal menambahkan data. NIM harus berawalan IF atau sudah terdaftar.");
            return false;
        }
    }
    ///Mengembalikan kumpulan key yang ada dalam HashMap tabel data
    public void tampil() {
        System.out.println("Data Praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println("NIM: " + nim + " | Nama Asisten: " + tabelData.get(nim));
        }
    }
    ///Mengembalikan Kumpulan key yang ada dalam HashMap tabel data
    public void listNimPraktikan() {
        System.out.println("Daftar NIM Praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }
    ///Mengembalikan true jika dalam Map terdapat value yang sama dengan 
    ///parameter value yang sudah di masukan 
    public void listNamaAsisten() {
        System.out.println("Daftar Nama Asisten:");
        Set<String> nama = new HashSet<>();
        for (String namaAsisten : tabelData.values()) {
            nama.add(namaAsisten);
        }
        for (String namaAsisten : nama) {
            System.out.println(namaAsisten);
        }
    }
    ///Mengembalikan kumpulan key yang ada dalam HashMap tabel sesi login
    public int totalEmail() {
        int count = 0;
        for (String email : tabelSesiLogin.keySet()) {
            if (email.matches("(.+)@umm.ac.id")) {
                count++;
            }
        }
        return count;
    }
    ///Mengembalikan true jika sudah terdapat key yang sama dalam sebuah HashMap
    public boolean hapusData(String nim, String namaAsisten) {
        if (tabelData.containsKey(nim) && tabelData.get(nim).equals(namaAsisten)) {
            tabelData.remove(nim);
            return true;
        }
        return false;
    }
    ///Mengembalikan true jika sudah terdapat key yang sama dalam sebuah HashMap
    public void editData(String nim, String namaAsisten) {
        if (tabelData.containsKey(nim)) {
            tabelData.put(nim, namaAsisten);
        }
    }
    ///Mengembalikan true jiika dalam map terdapat value yang sama dengan paramteter value yang sudah dimasukan
    public void search(String namaAsisten) {
        ArrayList<String> listNim = new ArrayList<String>();
        for (String nim : tabelData.keySet()) {
            if (tabelData.get(nim).equals(namaAsisten)) {
                listNim.add(nim);
            }
        }
        if (listNim.size() > 0) {
            System.out.println("Daftar NIM Praktikan dengan nama asisten " + namaAsisten + ":");
            for (String nim : listNim) {
                System.out.println(nim);
            }
        } else {
            System.out.println("Tidak ada NIM praktikan dengan nama asisten " + namaAsisten);
        }
    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            if (email.matches("(.+)@umm.ac.id")) {
                try {
                    System.out.println("Loading...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Login berhasil.\n");
                menu();
            } else {
                try {
                    System.out.println("Loading...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Gagal login. Email tidak valid.\n");
                login();
            }
        } else {
            try {
                System.out.println("Loading...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Gagal login. Email atau password salah.\n");
            login();
        }
        input.close();
    }

    public void Logout() {
        login();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        DataPraktikan dataPraktikan = new DataPraktikan();

        int pilihan = 0;

        while (true) {
            System.out.println("\nPilih Menu:");
            System.out.println("1. Tambah data praktikan");
            System.out.println("2. Edit data praktikan");
            System.out.println("3. Hapus data praktikan");
            System.out.println("4. Tampilkan data praktikan");
            System.out.println("5. Total email");
            System.out.println("6. Tampilkan asisten");
            System.out.println("7. Tampilkan nim");
            System.out.println("8. Cari NIM praktikan berdasarkan nama asisten");
            System.out.println("9. Keluar");

            System.out.print("Masukkan pilihan (1-9): ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukkan NIM: ");
                String nim = scanner.next();
                System.out.print("Masukkan nama asisten: ");
                String namaAsisten = scanner.next();
                if (dataPraktikan.tambahData(nim, namaAsisten)) {
                    System.out.println("Data praktikan berhasil ditambahkan.");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan NIM: ");
                String nim = scanner.next();
                scanner.nextLine();
                System.out.print("Masukkan nama asisten baru: ");
                String namaAsisten = scanner.nextLine();
                dataPraktikan.editData(nim, namaAsisten);
            } else if (pilihan == 3) {
                System.out.print("Masukkan NIM: ");
                String nim = scanner.next();
                System.out.print("Masukkan nama asisten: ");
                String namaAsisten = scanner.next();
                if (dataPraktikan.hapusData(nim, namaAsisten)) {
                    System.out.println("Data praktikan berhasil dihapus.");
                } else {
                    System.out.println("Data praktikan gagal dihapus. NIM atau nama asisten tidak cocok.");
                }
            } else if (pilihan == 4) {
                dataPraktikan.tampil();
            } else if (pilihan == 5) {
                dataPraktikan.totalEmail();
                System.out.println("Jumlah email yang valid: " + dataPraktikan.totalEmail());
            } else if (pilihan == 6) {
                dataPraktikan.listNamaAsisten();
            } else if (pilihan == 7) {
                dataPraktikan.listNimPraktikan();
            } else if (pilihan == 8) {
                System.out.print("Masukkan nama asisten: ");
                String namaAsisten = scanner.next();
                dataPraktikan.search(namaAsisten);
            } else if (pilihan == 9) {
                System.out.println("Keluar dari program");
                dataPraktikan.Logout();
                break;
            } else {
                System.out.println("Inputan salah");
            }
        }
        scanner.close();
    }
}
