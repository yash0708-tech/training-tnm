class MediaItem {
     String title;
     int duration;
     String mediaType;

    
    public MediaItem(String title, int duration, String mediaType) {
        this.title = title;
        this.duration = duration;
        this.mediaType = mediaType;
    }

    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Media Type: " + mediaType);
    }
}

class Book extends MediaItem {
     String author;

    // Constructor
    public Book(String title, int duration, String mediaType, String author) {
        super(title, duration, mediaType);
        this.author = author;
    }

    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
    }
}

class Movie extends MediaItem {
     String director;

    
    public Movie(String title, int duration, String mediaType, String director) {
        super(title, duration, mediaType);
        this.director = director;
    }

    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Director: " + director);
    }
}

class MusicAlbum extends MediaItem {
    private String artist;

    
    public MusicAlbum(String title, int duration, String mediaType, String artist) {
        super(title, duration, mediaType);
        this.artist = artist;
    }

    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Artist: " + artist);
    }
}

public class Task1 {
    public static void main(String[] args) {
        
        Book book = new Book("The Catcher in the Rye", 234, "Book", "J.D. Salinger");
        Movie movie = new Movie("Inception", 148, "Movie", "Christopher Nolan");
        MusicAlbum musicAlbum = new MusicAlbum("Abbey Road", 47, "MusicAlbum", "The Beatles");

        
        System.out.println("Book Information:");
        book.displayInfo();

        System.out.println("\nMovie Information:");
        movie.displayInfo();

        System.out.println("\nMusic Album Information:");
        musicAlbum.displayInfo();
    }
}
