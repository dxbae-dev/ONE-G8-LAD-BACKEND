package com.one.radio.models;

public class Favorites {

    public String[] getTitles(Audio[] audios) {
        int count = 0;

        // Primer for: contar cuántos cumplen la condición
        for (Audio audio : audios) {
            if (audio.getRatingCount() >= 3 && audio.getAverageRating() >= 4.0) {
                count++;
            }
        }

        String[] titles = new String[count];
        int index = 0;

        // Segundo for: llenar el array con los títulos
        for (Audio audio : audios) {
            if (audio.getRatingCount() >= 3 && audio.getAverageRating() >= 4.0) {
                titles[index] = audio.getTitle();
                index++;
            }
        }

        return titles;
    }
}
