package com.one.radio.main;

import com.one.radio.models.Favorites;
import com.one.radio.models.Podcast;
import com.one.radio.models.Song;
import com.one.radio.models.Audio;


import java.util.Scanner;

public class Main {

    public static void mostrarCanciones(Song[] songs) {
        System.out.println("\n🎧 Canciones disponibles:");
        for (int i = 0; i < songs.length; i++) {
            System.out.println(i + " - " + songs[i].getTitle());
        }
    }

    public static void mostrarPodcasts(Podcast[] podcasts) {
        System.out.println("\n🎤 Podcasts disponibles:");
        for (int i = 0; i < podcasts.length; i++) {
            System.out.println(i + " - " + podcasts[i].getTitle());
        }
    }

    public static void showInfoSong(Song song){
        System.out.println("\n🎧. " + song.getTitle());
        System.out.println("Artista: " + song.getArtist());
        System.out.println("Album: " + song.getAlbum());
        System.out.println("Genero:" + song.getGender());
        System.out.println("Total de Visualizaciones: "+ song.getTotalViews());
        System.out.println("Calificacion: " + song.getAverageRating());

    }

    public static void showInfoPodcast(Podcast podcast){
        System.out.println("\n🎤. " + podcast.getTitle());
        System.out.println("Descripcion: "+ podcast.getDescription());
        System.out.println("Categoria:" + podcast.getTopic());
        System.out.println("Total de Visualizaciones: "+ podcast.getTotalViews());
        System.out.println("Calificacion: " + podcast.getAverageRating());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 🎸 Canciones
        Song scarTissue = new Song();
        scarTissue.setTitle("Scar Tissues");
        scarTissue.setAlbum("Californication");
        scarTissue.setArtist("Red Hot Chili Peppers");
        scarTissue.setGender("Rock");
        scarTissue.setTotalViews(199);

        for (int i = 0; i < 99; i++) {
            scarTissue.rate(5);
        }

        Song bohemianRhapsody = new Song();
        bohemianRhapsody.setTitle("Bohemian Rhapsody");
        bohemianRhapsody.setAlbum("A Night at the Opera");
        bohemianRhapsody.setArtist("Queen");
        bohemianRhapsody.setGender("Rock");
        bohemianRhapsody.setTotalViews(19);
        for (int i = 0; i < 19; i++) {
            bohemianRhapsody.rate(3);
        }

        Song badGuy = new Song();
        badGuy.setTitle("Bad Guy");
        badGuy.setAlbum("When We All Fall Asleep, Where Do We Go?");
        badGuy.setArtist("Billie Eilish");
        badGuy.setGender("Pop");
        badGuy.setTotalViews(999);
        for (int i = 0; i < 100; i++) {
            badGuy.rate(4);
        }

        Song[] songs = {scarTissue, bohemianRhapsody, badGuy};

        // 🎙️ Podcasts
        Podcast laPension = new Podcast();
        laPension.setTitle("La Pensión");
        laPension.setDescription("Podcast de comedia de Criss Martell y Fedelobo");
        laPension.setTopic("Comedia");
        laPension.setTotalViews(1999);
        for (int i = 0; i < 99; i++) {
            laPension.rate(5);
        }

        Podcast seRegalanDudas = new Podcast();
        seRegalanDudas.setTitle("Se Regalan Dudas");
        seRegalanDudas.setDescription("Cuestionando todo lo que creíamos saber");
        seRegalanDudas.setTopic("Reflexión");
        seRegalanDudas.setTotalViews(100);
        for (int i = 0; i < 99; i++) {
            seRegalanDudas.rate(2);
        }

        Podcast theJoeRogan = new Podcast();
        theJoeRogan.setTitle("The Joe Rogan Experience");
        theJoeRogan.setDescription("Entrevistas, ciencia y todo lo raro con Joe Rogan");
        theJoeRogan.setTopic("Variedades");
        theJoeRogan.setTotalViews(29);
        for (int i = 0; i < 19; i++) {
            theJoeRogan.rate(2);
        }

        Podcast[] podcasts = {laPension, seRegalanDudas, theJoeRogan};

        Favorites favorites = new Favorites();
        boolean running = true;

        Audio[] audios = new Audio[songs.length + podcasts.length];
        System.arraycopy(songs, 0, audios, 0, songs.length);
        System.arraycopy(podcasts, 0, audios, songs.length, podcasts.length);


        while (running) {
            System.out.println("\n🎵 MENÚ PRINCIPAL 🎵");
            System.out.println("1. 🎧 Canciones");
            System.out.println("2. 🎤 Podcasts");
            System.out.println("3. ▶️ Reproducir canción o podcast");
            System.out.println("4. ❤️ Dar like a canción o podcast");
            System.out.println("5. ⭐ Calificar canción o podcast");
            System.out.println("6. 🔥 Ver favoritos mejor calificados");
            System.out.println("7. 🎧 Ver informacion de una cancion");
            System.out.println("8. 🎤 Ver informacion de un podcast");


            System.out.println("0. ❌ Salir");
            System.out.print("Selecciona una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (option) {
                case 1:
                    mostrarCanciones(songs);
                    break;
                case 2:
                    mostrarPodcasts(podcasts);
                    break;
                case 3:
                    System.out.print("¿Qué deseas reproducir? (0: canción, 1: podcast): ");
                    int mediaType = scanner.nextInt();
                    if (mediaType == 0) {
                        mostrarCanciones(songs);
                        System.out.print("Elige el número de la canción: ");
                        int songIndex = scanner.nextInt();
                        if (songIndex >= 0 && songIndex < songs.length) {
                            songs[songIndex].view();
                            System.out.println("🎶 Reproduciendo: " + songs[songIndex].getTitle());
                        }
                    } else if (mediaType == 1) {
                        mostrarPodcasts(podcasts);
                        System.out.print("Elige el número del podcast: ");
                        int podcastIndex = scanner.nextInt();
                        if (podcastIndex >= 0 && podcastIndex < podcasts.length) {
                            podcasts[podcastIndex].view();
                            System.out.println("🎙️ Reproduciendo: " + podcasts[podcastIndex].getTitle());
                        }
                    }
                    break;
                case 4:
                    System.out.print("¿A qué le das like? (0: canción, 1: podcast): ");
                    int likeType = scanner.nextInt();
                    if (likeType == 0) {
                        mostrarCanciones(songs);
                        System.out.print("Elige el número de la canción: ");
                        int songIndex = scanner.nextInt();
                        if (songIndex >= 0 && songIndex < songs.length) {
                            songs[songIndex].like();
                            System.out.println("❤️ Like a: " + songs[songIndex].getTitle());
                        }
                    } else if (likeType == 1) {
                        mostrarPodcasts(podcasts);
                        System.out.print("Elige el número del podcast: ");
                        int podcastIndex = scanner.nextInt();
                        if (podcastIndex >= 0 && podcastIndex < podcasts.length) {
                            podcasts[podcastIndex].like();
                            System.out.println("❤️ Like a: " + podcasts[podcastIndex].getTitle());
                        }
                    }
                    break;
                case 5:
                    System.out.print("¿Qué deseas calificar? (0: canción, 1: podcast): ");
                    int rateType = scanner.nextInt();
                    if (rateType == 0) {
                        mostrarCanciones(songs);
                        System.out.print("Elige el número de la canción: ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < songs.length) {
                            System.out.print("Ingresa calificación (1-5): ");
                            int stars = scanner.nextInt();
                            songs[index].rate(stars);
                            System.out.println("⭐ Calificación guardada para " + songs[index].getTitle());
                        }
                    } else if (rateType == 1) {
                        mostrarPodcasts(podcasts);
                        System.out.print("Elige el número del podcast: ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < podcasts.length) {
                            System.out.print("Ingresa calificación (1-5): ");
                            int stars = scanner.nextInt();
                            podcasts[index].rate(stars);
                            System.out.println("⭐ Calificación guardada para " + podcasts[index].getTitle());
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n🔥 Audios mejor calificados:");
                    String[] favTitles = favorites.getTitles(audios);
                    for (String title : favTitles) {
                        System.out.println("- " + title);
                    }
                    break;
                case 7:
                    mostrarCanciones(songs);
                    System.out.print("Elige el número de la canción: ");
                    int numberSong = scanner.nextInt();

                    showInfoSong(songs[numberSong]);
                    break;
                case 8:
                    mostrarPodcasts(podcasts);
                    System.out.print("Elige el número del Podcast: ");
                    int numberPodcast = scanner.nextInt();
                    showInfoPodcast(podcasts[numberPodcast]);
                    break;
                case 0:
                    running = false;
                    System.out.println("👋 Saliendo... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
