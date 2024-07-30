package film_yonetim_sistemi;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FilmLibraryApp {

    public static void main(String[] args) {

        Movie movie1 = new Movie(1000, "Harry Potter", "Mike Newell", 2000, "Fantastik", 8.4);
        Movie movie2 = new Movie(1001, "Harry Potter 2", "Mike Newell", 2000, "Fantastik", 8.4);


        FilmRepo library = new FilmRepo();
        library.add(movie1);
        library.add(movie2);

        // Kullanıcı adlarını ve rollerini belirlemek için bir harita
        Map<String, Role> kullaniciRolu = new HashMap<>();
        kullaniciRolu.put("Arda", Role.ROLE_ADMIN);
        kullaniciRolu.put("Melisa", Role.ROLE_USER);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Film Kütüphanemize hoşgeldiniz.");
        System.out.print("Kullanıcı adınızı giriniz: ");
        String kullaniciAdi = scanner.nextLine();

        // Kullanıcı adı ile rolü belirle
        Role kullaniciRol = kullaniciRolu.getOrDefault(kullaniciAdi, Role.ROLE_USER);
        Kullanıcılar kullanici = new Kullanıcılar(kullaniciAdi, kullaniciRol);

        while (true) {
            System.out.println();
            System.out.println("1- Filmleri Listele");
            System.out.println("2- Filmleri İsme Göre Ara");
            System.out.println("3- Filmleri Yönetmene Göre Ara");
            System.out.println("4- Filmleri Türe Göre Ara");
            System.out.println("5- Filmleri Rating'e Göre Ara");

            if (kullanici.getRole() == Role.ROLE_ADMIN) {
                System.out.println("6- Film Ekle");
                System.out.println("7- Film Sil");
                System.out.println("8- Film Puanını Güncelle");
            }
            System.out.println("9- Çıkış Yap");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    library.get();
                    break;

                case 2:
                    System.out.println("Aramak istedğiniz filmin başlığını giriniz");
                    String baslik = scanner.nextLine();
                    library.searchByTitle(baslik);
                    break;

                case 3:
                    System.out.println("Aramak istedğiniz filmin yönetmenini giriniz");
                    String yonetmen = scanner.nextLine();
                    library.searchByDirector(yonetmen);
                    break;

                case 4:
                    System.out.println("Aramak istedğiniz filmin türünü giriniz");
                    String tur = scanner.nextLine();
                    library.searchByGenre(tur);
                    break;

                case 5:
                    System.out.println("Aramak istedğiniz filmin ratingin giriniz");
                    Double rating = scanner.nextDouble();
                    library.searchByRating(rating);
                    break;

                case 6:
                    if (kullanici.getRole() == Role.ROLE_ADMIN) {
                        System.out.print("Film ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Konsol hatası önlemek için

                        System.out.print("Film Başlığı: ");
                        String newTitle = scanner.nextLine();

                        System.out.print("Yönetmen: ");
                        String newDirector = scanner.nextLine();

                        System.out.print("Yayın Yılı: ");
                        int releaseYear = scanner.nextInt();
                        scanner.nextLine();  // Konsol hatası önlemek için

                        System.out.print("Tür: ");
                        String newGenre = scanner.nextLine();

                        System.out.print("Puan: ");
                        double newRating = scanner.nextDouble();

                        Movie newMovie = new Movie(id, newTitle, newDirector, releaseYear, newGenre, newRating);
                        library.add(newMovie);
                    } else {
                        System.out.println("Bu işlemi sadece adminler yapabilir.");
                    }
                    break;
                case 7:
                    if (kullanici.getRole() == Role.ROLE_ADMIN) {
                        System.out.println("Silmek istediğiniz filmin id'sini giriniz");
                        int id = scanner.nextInt();
                        library.remove(id);
                    } else {
                        System.out.println("Bu işlemi sadece adminler yapabilir.");
                    }
                    break;
                case 8:
                    if (kullanici.getRole() == Role.ROLE_ADMIN) {
                        System.out.print("Puanını güncellemek istediğiniz filmin ID'si: ");
                        int id = scanner.nextInt();
                        library.updateRating(id);
                    } else {
                        System.out.println("Bu işlemi sadece adminler yapabilir.");
                    }
                    break;
                case 9:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
                    break;
            }

        }


    }



}




