package ictgradschool.adminApp.swingclient.model;

public class User {

    private int userID;
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String avatarImage;
    private String introduction;
    private int numberOfArticles;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", avatarImage='" + avatarImage + '\'' +
                ", introduction='" + introduction + '\'' +
                ", numberOfArticles=" + numberOfArticles +
                '}';
    }
}
