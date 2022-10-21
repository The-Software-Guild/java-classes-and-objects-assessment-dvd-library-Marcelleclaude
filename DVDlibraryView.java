package com.sal.DVDlibrary.ui;

import com.sal.DVDlibrary.dto.DVD;
import com.sal.DVDlibrary.ui.UserIO;
import com.sal.DVDlibrary.ui.UserIOConsoleImpl;
import java.util.List;

public class DVDlibraryView {

    private UserIO io;
//hello
    public DVDlibraryView(UserIO io) {
        this.io = io;
    }
    /*
    All we have done is move the functionality for printing the menu and getting the user's selection from the controller over to the view.
    Notice that we're using composition here —
    the ClassRosterView has-a UserIO member and it uses UserIO to interact with the user. Remember that UserIO is an interface
     */

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select form the above choices. ", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title of the DVD");
        String ReleaseDate = io.readString("Please enter the release Date");
        String MPAA = io.readString("Please enter the MPAA");
        String DirectorsName = io.readString("Please enter the directors name");
        String Studio = io.readString("Please enter the Studio name");
        String UserRating = io.readString("Please enter the User Rating");

        DVD currentDVD = new DVD(title);//create a new dvd data type
        currentDVD.setReleaseDate(ReleaseDate);
        currentDVD.setMPAA(MPAA);
        currentDVD.setDirectorsName(DirectorsName);
        currentDVD.setStudio(Studio);
        currentDVD.setUserRating(UserRating);
        return currentDVD;

    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }


    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDisplayDvdBanner() {

        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {

        return io.readString("Please enter the DVD title.");
    }

    public void displayRemoveDvdBanner () {
        io.print("=== Remove Dvd ===");
    }

    public void displayDvd(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAA());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("DVD does not exist.");
        }
        io.readString("Please hit enter to continue.");

    }

    public void displayDvdList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("#%s : %s %s %s %s %s ",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMPAA(),
                    currentDVD.getDirectorsName(),
                    currentDVD.getStudio(),
                    currentDVD.getUserRating());
            io.print(dvdInfo);

        }
        io.readString("Please hit enter to continue");
    }



        public void displayRemoveResult (DVD dvdRecord){
            if (dvdRecord != null) {
                io.print("DVD successfully removed.");
            } else {
                io.print("No such DVD.");
            }
            io.readString("Please hit enter to continue.");
        }

        public void displayExitBanner () {
            io.print("CIAO!!!");
        }

        public void displayUnknownCommandBanner () {
            io.print("Unknown Command!!!");
        }

        public void displayErrorMessage (String errorMsg){
            io.print("=== ERROR ===");
            io.print(errorMsg);
        }

        // ALL ABOUT EDITING EXISTING DVDS
        public int printEditMenuAndGetSelection () {
            io.print("Edit Menu");
            io.print("1. Edit Release Date");
            io.print("2. Edit MPAA");
            io.print("3. Edit Director Name");
            io.print("4. Edit User Rating");
            io.print("5. Edit Studio Name");
            io.print("6. Exit");

            return io.readInt("Please select from the above choices.", 1, 6);
        }

        public void displayEditDvdBanner () {
            io.print("=== Edit DVD ===");
        }

        public void displayEditDvdSuccess () {
            io.readString(
                    "DVD successfully Edited.  Please hit enter to continue");
        }

        public void displayEditReleaseDateBanner () {
            io.print("=== Edit DVD Release Date ===");
        }

        public void displayEditMPAABanner () {
            io.print("=== Edit DVD MPAA rating ===");
        }

        public void displayEditDirectorNameBanner () {
            io.print("=== Edit DVD Director's Name ===");
        }

        public void displayEditStudio () {
            io.print("=== Edit DVD Studio ===");
        }

        public void displayEditUserRating () {
            io.print("=== Edit DVD User Rating ===");
        }

        public String getNewReleaseDate () {
            return io.readString("Please enter new release date.");
        }

        public String getNewMpaaRating () {
            return io.readString("Please enter new MPAA rating.");
        }

        public String getNewDirectorName () {
            return io.readString("Please enter new director's name.");
        }

        public String getNewUserRating () {
            return io.readString("Please enter new user rating.");
        }

        public String getNewStudio () {
            return io.readString("Please enter new studio.");
        }

        public void displayNullDVD () {
            io.print("No such DVD.");
            io.readString("Please hit enter to continue.");
        }
    }

        /*public void displayRemoveResult(DVD removedDvd) {
        }
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayRemoveDvdBanner() {
    }


    public void displayEditStudio() {
    }

         */
