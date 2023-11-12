package kedua;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main (String[] args) {
  
        List<Pengguna> db = new ArrayList<Pengguna>(Arrays.asList(new Pengguna[]{new User("user", "user"),
        new Admin("admin", "admin")}));
        List<Buku> dbBuku = new ArrayList<Buku>(Arrays.asList(new Buku[]{new Buku("Seni itu ada bicaranya", new String[]{"Novel"}),
        new Buku("Cinta Brontosaurus", new String[]{"Slice of Life", "Daily"})}));
        try (Scanner input = new Scanner(System.in)) {
            do {
                int loginIndex = -1;
                do {
                    System.out.println("\n\nSelamat datang di sistem pengelolaan perpustakaan\n" +
                            "Silakan login terlebih dahulu");
                    System.out.print("Masukkan Username: ");
                    String username = input.nextLine();
                    System.out.print("Masukkan Password: ");
                    String pass = input.nextLine();

                    for (int i = 0; i < db.size(); i++) {
                        if (db.get(i).checkCredentials(username, pass)) {
                            loginIndex = i;
                            break;
                        }
                    }
                } while (loginIndex < 0);
                if(db.get(loginIndex).getPrivilege() == 0){     //Admin Panel
                    int pilihan = -1;
                    do {
                        System.out.print("\nOpsi,\n" +
                                "1. List buku yang tersedia\n" +
                                "2. Tambah buku\n" +
                                "3. Hapus buku\n" +
                                "4. Log out\n" +
                                "5. Exit\n" +
                                "Pilihan: ");
                        pilihan = input.nextInt();
                        input.nextLine();
                        switch (pilihan) {
                            case 1:
                                int dummy;
                                System.out.println("\nDaftar Buku\n\n");
                                db.get(loginIndex).getDaftarBuku(dbBuku);
                                do {
                                    System.out.print("\n1. Sortir berdasar genre: \n" +
                                            "2. return\n" +
                                            "Pilihan: ");
                                    dummy = input.nextInt();
                                    input.nextLine();
                                    if (dummy == 1) {
                                        System.out.print("Masukan genre : ");
                                        String sGenre = input.nextLine();
                                        String[] genre = sGenre.split(" ");
                                        System.out.println("\nDaftar Buku\n");
                                        System.out.print("Sort By Genre: ");
                                        System.out.print(sGenre + '\n');
                                        int found = db.get(loginIndex).getDaftarBukuByGenre(dbBuku, genre);
                                        System.out.println("jumlah buku yang memenuhi genre: " + found + " (from top)\n");
                                    }
                                }while(dummy == 1);
                                break;
                            case 2:
                                System.out.println("\nTambah Buku\n");
                                System.out.print("Title: ");
                                String title = input.nextLine();
                                System.out.print("Genre (separated by space): ");
                                String sGenre = input.nextLine();
                                String[] genre = sGenre.split(" ");
                                ((Admin) db.get(loginIndex)).tambahBuku(dbBuku, title, genre);     //trust me, compiler
                                break;
                            case 3:
                                System.out.println("\nHapus Buku\n");
                                System.out.print("Masukan nomor buku: ");
                                int index = input.nextInt();
                                ((Admin) db.get(loginIndex)).hapusBuku(dbBuku, index);
                                break;
                            case 4:
                                break;
                            case 5:
                                return;
                            default:
                                break;
                        }
                    }while(pilihan > 0 && pilihan < 6 && pilihan!=4);
                } else if (db.get(loginIndex).getPrivilege() == 1) {    //User panel
                    int pilihan = -1;
                    do {
                        System.out.print("\n\nOpsi,\n" +
                                "1. Daftar Buku\n" +
                                "2. Log out\n" +
                                "3. Exit\n" +
                                "Pilihan: ");
                        pilihan = input.nextInt();
                        input.nextLine();
                        switch (pilihan) {
                            case 1:
                                int dummy;
                                System.out.println("\nDaftar Buku\n\n");
                                db.get(loginIndex).getDaftarBuku(dbBuku);
                                do {
                                    System.out.print("\n1. Sortir berdasar genre: \n" +
                                            "2. return\n" +
                                            "Pilihan: ");
                                    dummy = input.nextInt();
                                    input.nextLine();
                                    if (dummy == 1) {
                                        System.out.print("Masukan genre (separated by space): ");
                                        String sGenre = input.nextLine();
                                        String[] genre = sGenre.split(" ");
                                        System.out.println("\nDaftar Buku\n");
                                        System.out.print("Sort By Genre: ");
                                        System.out.print(sGenre + '\n');
                                        int found = db.get(loginIndex).getDaftarBukuByGenre(dbBuku, genre);
                                        System.out.println("jumlah buku yang memenuhi genre: " + found + " (from top)\n");
                                    }
                                }while(dummy == 1);
                                break;
                            case 2:
                                break;
                            case 3:
                                return;
                        }
                    } while (pilihan > 0 && pilihan < 3 && pilihan!=2);
                }
            }while(true);
        }
    }
}