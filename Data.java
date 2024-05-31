import java.util.ArrayList;
import java.util.Scanner;

class Data {
    public static ArrayList<Tanaman> tanamans = new ArrayList<>();
    public static ArrayList<Integer> lokasi = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);

    public static void mulai() {
        System.out.print("Masa tanam (bulan): ");
        int masaTanam = in.nextInt() * 30;
        
        for (int i = 0; i < 3; i++) {
            tanamans.add(menanam());
        }
        
        for (int hari = 0; hari < masaTanam; hari++) {
            ArrayList<Integer> mati = new ArrayList<>();
            for (int i = 0; i < tanamans.size(); i++) {
                if (tanamans.get(i).status().equals("Hidup")) {
                    tanamans.get(i).berkembang();
                } else {
                    mati.add(i);
                }
            }
            if (hari % 90 == 0) {
                for (int i = 0; i < tanamans.size(); i++) {
                    if (!mati.contains(i)) {
                        ((Perawatan) tanamans.get(i)).treatment();
                    }
                }
            }
            for (int index : mati) {
                tanamans.set(index, menanam());
            }
        }
        in.close();
    }

    public static Tanaman menanam() {
        System.out.println("Mau menanam apa ?");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");
        int pilihan = in.nextInt();
        Tanaman tanaman;
        switch (pilihan) {
            case 1:
                tanaman = new Tomat();
                break;
            case 2:
                tanaman = new Stroberi();
                break;
            case 3:
                tanaman = new Persik();
                break;
            default:
                tanaman = new Tomat();
                break;
        }
        System.out.println(tanaman.getClass().getSimpleName() + " berhasil ditanam.");
        return tanaman;
    }

    public static void info() {
        System.out.println("\n-------------------");
        System.out.println("PROSES PERKEMBANGAN");
        System.out.println("-------------------\n");

        // 

        System.out.println("-----HASIL MENANAM-----\n");

        for (int i = 0; i < tanamans.size(); i++) {
            System.out.println("Tanaman buah ke-" + (i + 1) + "\n" + tanamans.get(i).toString());
        }
    }
}
