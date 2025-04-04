package com.one.radio.models;

public class Audio {

    private String title;
    private int totalViews;
    private int totalLikes;
    private boolean like;

    private double durationSeconds;

    private int totalRatingPoints;
    private int ratingCount;

    public void like() {
        if (!this.like) {
            this.totalLikes++;
        } else {
            this.totalLikes--;
        }
        this.like = !this.like;
    }

    public void view() {
        this.totalViews++;
    }

    // Añade la calificacion del usuario
    public void rate(int stars) {
        if (stars < 1 || stars > 5) {
            System.out.println("La calificación debe estar entre 1 y 5 estrellas.");
        }
        this.totalRatingPoints += stars;
        this.ratingCount++;
    }

    // Devuelve el promedio de calificación
    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0.0;
        }
        return (double) totalRatingPoints / ratingCount;
    }

    // Getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(double durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public int getTotalRatingPoints() {
        return totalRatingPoints;
    }
}
