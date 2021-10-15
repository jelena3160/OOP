import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Platforma p1 = new Platforma("ArchLinux", 8000, 20);
        Platforma p2 = new Platforma("Windows 10", 10_000, 30);

        System.out.println("Dostupne platforme");
        System.out.println(p1);
        System.out.println(p2);

        KompiliranProgram kp1 = new KompiliranProgram("IntelliJ Idea",700,p1, 3_000_000);
        KompiliranProgram kp2 = new KompiliranProgram("Visual Studio.exe", 400, p2, 5_000_000);

        Skripta s1 = new Skripta("inicijalizacijaBaze", 0.2,p1,SkriptJezik.Lua, 1200, 100);
        Skripta s2 = new Skripta("zaustaviWinUpdate", 5, p2, SkriptJezik.Python, 1000, 300);

        Program[] p = {s1, s2, kp1, kp2};

        Scanner sc = new Scanner(System.in);
        String opcija = sc.next();

        while(!opcija.equals("izlaz")){
            if(opcija.equals("svi")){
                for(Program program: p)
                    System.out.println(program);
            }
            if(opcija.equals("mem")){
                for(Program program: p)
                    System.out.println(program.memorijskoZauzece());
            }
            if(opcija.equals("cena")){
                for(Program program: p)
                    System.out.println(program.cenaIzvrsavanja());
            }
            if(opcija.equals("pomoc")){
                System.out.println("Dostupne opcije");
                System.out.println("izlaz - izlazak iz programa");
                System.out.println("mem - prikaz memorijskog zauzeca");
                System.out.println("cena - prikaz cene izvrsavanja");
                System.out.println("svi - prikaz dostupnih programa");
                System.out.println("pomoc - prikaz ovog menija");
            }

            opcija = sc.next();
        }
     }
}
