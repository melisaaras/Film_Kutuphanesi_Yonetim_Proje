package film_yonetim_sistemi;
//type olarak genişlik sağladığı için generics kullandık.

public interface Repo <T>{

    void add(T t);
    void remove(int id);
    void updateRating(int id);
    void get();







}
