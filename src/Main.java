import java.util.Arrays;

class Film {
    private int id;
    private String nama;
    private int tahun;
    private double rating;

    public Film(int id, String nama, int tahun, double rating) {
        this.id = id;
        this.nama = nama;
        this.tahun = tahun;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getTahun() {
        return tahun;
    }

    public double getRating() {
        return rating;
    }
}

class FilmTerlaris {
    private Film[] filmList;

    public FilmTerlaris(Film[] filmList) {
        this.filmList = filmList;
    }

    public void tampilkanFilmTerlaris() {
        for (Film film : filmList) {
            System.out.println("ID Film: " + film.getId());
            System.out.println("Nama Film: " + film.getNama());
            System.out.println("Tahun: " + film.getTahun());
            System.out.println("Rating: " + film.getRating());
            System.out.println("------------------------------------");
        }
    }

    public void urutkanFilmTerlaris() {
        int n = filmList.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (filmList[j].getRating() > filmList[minIndex].getRating()) {
                    minIndex = j;
                }
            }
            Film temp = filmList[minIndex];
            filmList[minIndex] = filmList[i];
            filmList[i] = temp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat objek Film
        Film film1 = new Film(1, "Film A", 2020, 8.2);
        Film film2 = new Film(2, "Film B", 2019, 7.9);
        Film film3 = new Film(3, "Film C", 2021, 8.5);
        Film film4 = new Film(4, "Film D", 2018, 8.7);
        Film film5 = new Film(5, "Film E", 2022, 7.6);

        // Membuat objek FilmTerlaris dan menambahkan film ke dalamnya
        FilmTerlaris filmTerlaris = new FilmTerlaris(new Film[]{film1, film2, film3, film4, film5});

        // Menampilkan film terlaris sebelum diurutkan
        System.out.println("Film Terlaris Sebelum Diurutkan:");
        filmTerlaris.tampilkanFilmTerlaris();

        // Mengurutkan film terlaris menggunakan selection sort
        filmTerlaris.urutkanFilmTerlaris();

        // Menampilkan film terlaris setelah diurutkan
        System.out.println("Film Terlaris Setelah Diurutkan:");
        filmTerlaris.tampilkanFilmTerlaris();
    }
}
