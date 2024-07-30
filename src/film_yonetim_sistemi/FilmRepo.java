package film_yonetim_sistemi;

import java.util.LinkedList;
import java.util.Scanner;

public class FilmRepo implements Repo <Movie>{

    LinkedList<Movie> film_listesi = new LinkedList<>(); //EN BAŞTA LİST YAZSAK DA İNTERFACE AYNI OLDUĞU İÇİN ÇALIŞIR.

    Scanner scanner = new Scanner(System.in);




    @Override
    public void add(Movie movie) {
            film_listesi.add(movie);
            System.out.println( movie.getTitle() + " isimli film başarıyla eklenmiştir.");
        }



    @Override
    public void remove(int id) {

        boolean bulundu = false;
        for (Movie w : film_listesi) {
            if (w.getId() == id) {
                film_listesi.remove(w);
                System.out.println(w.getTitle() + " isimli film silindi");
                bulundu = true;
                break;
            }
        }
        if (!bulundu) {
            System.out.println("Böyle bir film bulunamadı");
        }
    }



    @Override
    public void updateRating(int id) {

            boolean filmBulundu=false;
        for ( Movie w: film_listesi ){
        if (w.getId()==id){
            System.out.println("Güncellemek istediğiniz ratingi giriniz.");
            double newRating = scanner.nextDouble();
            w.setRating(newRating);
            System.out.println( w.getTitle() + " isimli filmin ratingi başarıyla güncellenmiştir.");
            filmBulundu=true;
            break;


         }
             if (!filmBulundu){
                 System.out.println("Böyle bir film bulunamadı");
             }
         }

    }

    @Override
    public void get() {
        for (Movie w : film_listesi){
            System.out.println(w);
            }

    }

    public void searchByTitle(String title) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : film_listesi) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                result.add(movie);
                System.out.println(movie);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Bu isimde film bulunamadı.");
        }
    }

    public void searchByDirector(String director) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : film_listesi) {
            if (movie.getDirector().equalsIgnoreCase(director)) {
                result.add(movie);
                System.out.println(movie);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Bu yönetmene ait film bulunamadı.");
        }
    }

    public void searchByGenre(String genre) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : film_listesi) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                result.add(movie);
                System.out.println(movie);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Bu türde film bulunamadı.");
        }
    }

    public void searchByRating(Double rating) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : film_listesi) {
            if (movie.getRating() >= rating) {
                result.add(movie);
                System.out.println(movie);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Bu rating'e uygun film bulunamadı.");
        }
    }


}
