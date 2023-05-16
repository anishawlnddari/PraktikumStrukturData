import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Hewan {
    public static ArrayList<String> hewan = new ArrayList<>();

    public static void pause() {
        System.out.println("======================================================");
        System.out.println("Program akan melakukan sistem pause. Tekan tombol enter untuk next...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Program Telah Dilanjutkan.");
        System.out.println("======================================================");
    }

    public static void main(String[] args) {
        hewan.add("Angsa");
        hewan.add("Bebek");
        hewan.add("Cicak");
        hewan.add("Domba");
        hewan.add("Elang");
        hewan.add("Gajah");
        hewan.add("Badak");
        hewan.add("Bebek");

        int jumlahBebek = 0;
        ArrayList<Integer> indexBebek = new ArrayList<>();
        for (int i = 0; i < hewan.size(); i++) {
            if (hewan.get(i).equals("Bebek")) {
                jumlahBebek++;
                indexBebek.add(i);
            }
        }
        System.out.println("Menghitung jumlah bebek");
        System.out.println(hewan);
        System.out.println("Bebek = " + jumlahBebek);
        System.out.println("Posisi Bebek :" + indexBebek);
        pause();
        hewan.remove(1);
        System.out.println("Bebek pada index pertama telah dihapus...");
        System.out.println("Output :\n" + hewan);
        pause();
        System.out.println("Menampilkan index ke-0 dan ke-2");
        System.out.println("Output :");
        System.out.println("Index ke-0 " + hewan.get(0));
        System.out.println("Index ke-2 " + hewan.get(2));
        hewan.remove(0);
        System.out.println("Menghapus Index ke-0");
        System.out.println("Angsa berhasil dihapus...");
        System.out.println("Output :" + hewan);
        pause();
        System.out.println("Sebelum ada perubahan...");
        System.out.println("Output :" + hewan);
        System.out.println("Setelah ada perubahan...");
        hewan.set(0, "Ular");
        hewan.add(2, "Itik");
        System.out.println("Output :" + hewan);
        pause();
        System.out.println("Menghapus Element diantara ke-1 dan ke-5");
        hewan.subList(2, 5).clear();
        System.out.println("Output :" + hewan);
        pause();
        System.out.println("Menampilkan Element Pertama dan Terakhir");
        System.out.println("Element Pertama : " + hewan.get(0));
        System.out.println("Element Terakhir : " + hewan.get(hewan.size() - 1));
        pause();
        System.out.println("Menampilkan Jumlah Element");
        System.out.println("Jumlah Element : " + hewan.size());
        System.out.println("Output : " + hewan);
        pause();
        System.out.println("Mencari posisi badak");
        int posisi = hewan.indexOf("Badak");
        System.out.println("Posisi index badak adalah index ke- : " + posisi);

    }
}