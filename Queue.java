import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    void displayLink() {
        System.out.println(data + "");
    }
}

class BankQueue {
    Node front, rear;

    BankQueue() {
        front = rear = null;
    }

    /// method untuk menambahkan elemen baru ke dalam queue
    void enqueue(int data) {
        Node newNode = new Node(data);

        /// jika queue masih kosong, maka node baru akan menjadi front dan rare
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        /// tambahkan node baru ke belakang queue dan perbarui rear
        rear.next = newNode;
        rear = newNode;
    }

    void dequeue() {
        /// jika queueu kosong, tidak ada yang bisa dihapus
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        /// simpan front node dan pindahkan front ke mode selanjutnya
        Node temp = front;
        front = front.next;

        /// jika front menjadi null, artinya queueu kosong dan rear juga harus di update
        if (front == null) {
            rear = null;
        }
    }

    /// method untuk melihat element pertama dalam queue
    int peek() {
        /// jika queue kosong, kembalikan -1
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        /// kembalikan data pada front node
        return front.data;
    }

    /// method untuk mengecek apaka queue kosong atau tidak
    boolean isEmpty() {
        return front == null;
    }

    /// method untuk menghitung ukuran dari queue
    int size() {
        int count = 0;
        Node temp = front;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    void displayLink() {
        Node current = front;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

public class Queue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankQueue queue = new BankQueue();

        while (true) {
            System.out.println("==================================================================");
            System.out.println("Selamat Datang to Bank rut");
            System.out.println("1. Ambil Nomor Antrian.");
            System.out.println("2. Panggilan nasabah nomor antrian.");
            System.out.println("3. Cek jumlah nasabah dalam queue. ");
            System.out.println("4. Keluar. ");

            System.out.print("Masukan pilihan : ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukan nomor antrian : ");
                int nomor_antrian = input.nextInt();
                input.nextLine();
                queue.enqueue(nomor_antrian);
                System.out.println("Nomor queue " + nomor_antrian + " Telah ditambahkan ke dalam queue");
                System.out.println("==================================================================");
            } else if (pilihan == 2) {
                int nomor_antrian = queue.peek();
                if (nomor_antrian == -1) {
                    System.out.println("Tidak ada pelanggan dalam antrian");
                } else {
                    queue.dequeue();
                    System.out.println("Silahkan nasabah dengan nomor queue " + nomor_antrian + " Menuju ke loket");
                    System.out.println("==================================================================");
                }
            } else if (pilihan == 3) {
                int jumlah_pelanggan = queue.size();
                if (jumlah_pelanggan == 0) {
                    System.out.println("Tidak ada pelanggan dalam queue");
                } else {
                    System.out.println("Jumlah pelanggan dalam antrian : " + jumlah_pelanggan);
                    System.out.println("==================================================================");
                }
            } else if (pilihan == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid");
                System.out.println("==================================================================");
            }
        }
        System.out.println("Terima kasih atas kunjungan anda");
    }
}