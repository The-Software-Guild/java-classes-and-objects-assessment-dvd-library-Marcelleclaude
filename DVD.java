package com.sal.DVDlibrary.dto;
/*
now after we finished creating the menu system, we can start creating the first use case that is ADD DVD
 */
public class DVD {
    private String title;
    private String ReleaseDate;
    private String MPAA;
    private String DirectorsName;
    private String Studio;
    private String UserRating;

    public DVD(String title) {
    }

    public static DVD remove(String title) {
        return null;
    }

    //in here we added the setter and getter method
    /*
    private variables can only be accessed within the same class (an outside class has no access to it).
    However, it is possible to access them if we provide public get and set methods.
    The get method returns the variable value, and the set method sets the value.
    so in other terms, the get method in this project, returns the value of the variables tile,releaseDate, MPAA etc...
    and the set method, takes a parameter in this case newTitle and assign it to the variable title (and so on and so forth).
    the this. is used to refer to the current object.
    rember when its private, it cannot be access outside of the class.
     */
    public String getTitle() {
        return title;
    }


    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        //in the object
       ReleaseDate = releaseDate;//=>whats being passed in the string

    }
//doesnt need anything () because its returning
    public String getMPAA() {
        return MPAA;
    }

    public void setMPAA(String MPAA) {
        MPAA = MPAA;
    }

    public String getDirectorsName() {
        return DirectorsName;
    }

    public void setDirectorsName(String directorsName) {
        DirectorsName = directorsName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getUserRating() {
        return UserRating;
    }

    public void setUserRating(String userRating) {
        UserRating = userRating;
    }

    public void setUserRating() {
    }

    }


