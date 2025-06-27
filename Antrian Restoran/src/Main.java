import java.util.Scanner;

class Node{
    String data;
    Node next;

    public Node(String data){
        this.data = data;
        this.next = null;
    }
}

class QueueManagement {
    Node head;

    public void push(String data){ //ditambahkan ke antrian
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public  void pop(){ //melayani antrian (hilangkan dari list)
        if(head != null){
            head = head.next;
        }
    }

    public void display(){
        Node current = head;
        System.out.println("List Antrian: \n");
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("Habis");
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        QueueManagement list = new QueueManagement();

        System.out.println("--Aplikasi Antrian Restoran--");

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Tambahkan Antrian Pelanggan:");
            System.out.println("2. Layani Antrian");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Keluar");
            System.out.println("Pilih opsi: ");

            int pilihan = -1;
            try {
                pilihan =scanner.nextInt();
            }catch(Exception e){
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next(); // Membersihkan buffer scanner
                continue;
            }
            scanner.nextLine(); // Membersihkan newline character dari buffer

            switch(pilihan){
                case 1:
                    System.out.println("Masukkan nama pelanggan: ");
                    String data = scanner.nextLine();
                    list.push(data);
                    list.display();
                    break;

                case 2:
                    list.pop();
                    System.out.println("Antrian telah dilayani\n");
                    list.display();
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Keluar dari sistem");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilih tidak valid, silahkan pilih angka 1-4. ");
            }
        }

    }
}
