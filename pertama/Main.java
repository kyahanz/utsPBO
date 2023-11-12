import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Hewan hewan;

            System.out.print("Masukan jenis hewan (kucing/anjing): ");
            String res = input.nextLine();
            res = res.toLowerCase();
            if(res.equals("kucing")) hewan = new Kucing();
            else if(res.equals("anjing")) hewan = new Anjing();
            else {
                System.out.println("Tidak ada dalam pilihan!");
                return;
            }

            System.out.println("\nHewan bersuara: " + hewan.bersuara());
            System.out.println(hewan.isMammal());
        }
    }
}