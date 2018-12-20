package com.badderxkaido.customlistview;

/*
Created By  Badre Eddine MOUHOUB
            Ingénieur d'Etat, JAVA Software Engineer, ENSAH
            badre.mouhoub@gmail.com
            https://www.linkedin.com/in/bmouhoub/

 */

public class Item {

    private String repoName;
    private String repoDescription;
    private String ownerName;
    private String ownerAvatar;
    private String numberOfStars;
    private String starsImage;

    public Item(String repoName, String repoDescription, String ownerName, String ownerAvatar, String numberOfStars) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.ownerName = ownerName;
        this.ownerAvatar = ownerAvatar;
        this.numberOfStars = numberOfStars;
        this.starsImage = "https://cdn3.iconfinder.com/data/icons/inficons-set-2/512/star-ratings-512.png";
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public void setRepoDescription(String repoDescription) {
        this.repoDescription = repoDescription;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAvatar() {
        return ownerAvatar;
    }

    public void setOwnerAvatar(String ownerAvatar) {
        this.ownerAvatar = ownerAvatar;
    }

    public String getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(String numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getStarsImage() {
        return starsImage;
    }

    public void setStarsImage(String starsImage) {
        this.starsImage = starsImage;
    }
}
