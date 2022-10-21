package com.sal.DVDlibraryController;

import com.sal.DVDlibrary.dao.DVDlibraryDao;
import com.sal.DVDlibrary.dao.DVDlibraryDaoFileImpl;
import com.sal.DVDlibrary.dao.DVDLibraryDaoException;
import com.sal.DVDlibrary.dto.DVD;
import com.sal.DVDlibrary.ui.DVDlibraryView;
import com.sal.DVDlibrary.ui.UserIO;
import com.sal.DVDlibrary.ui.UserIOConsoleImpl;

import java.util.List;

public class DVDlibraryController {
    private DVDlibraryView view;
    private UserIO io = new UserIOConsoleImpl();
    private DVDlibraryDao dao;


    public DVDlibraryController(DVDlibraryDao myDao, DVDlibraryView myView) {
        this.view=myView;
        this.dao=myDao;

    }


    /*
     specify that a method doesn't return anything.
     As the main() method doesn't return anything, its return type is void.
     As soon as the main() method terminates, the java program terminates too.
     When the run() method calls, the code specified in the run() method is executed. You can call the run() method multiple times.
     */
    public void run() throws DVDLibraryDaoException {
        Boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                //So at first we had the "list" in the Controller, and did not have  menuSelection = getMenuSelection();<== by creating that method the following showed up  private int getMenuSelection() {
                //        return view.printMenuAndGetSelection();
                // we did not have   private DVDlibraryView view = new DVDlibraryView(); either.
            /*
            We Created a new method called getMenuSelection() that we call to get the menuSelection in the run method
               Made a  call to printlnMenuAndGetSelection() on the view member
             */
//why was moving this list to the view important?

          /*  io.print("Main Menu");
            io.print("1. List DVDs");
            io.print("2. Create New DVD");
            io.print("3. View a DVD");
            io.print("4. Remove a DVD");
            io.print("5. Edit a DVD");
            io.print("6. Exit");
            //So basically we are telling this code to ask the user to choose between option 1-5.and telling the system to read menu Selection
            menuSelection=io.readInt("Please select from the" + " above choices.", 1 ,6);

           */


          /* Switch is an alternative to If-Else-If ladder and to select one among many blocks of code.it looks like that
/switch(<conditional-expression>) {
        //case value1:
        // // code
        // break;
           */
//we changed our swicth method here after creating the DVD code, we change case 2 to only show create dvd.
          /*  switch (menuSelection){
                case 1:
                    io.print("LIST DVDS");
                    break;
                case 2:
                    io.print("CREATE NEW DVD");
                    break;
                case 3:
                    io.print("VIEW A DVD");
                    break;
                case 4:
                    io.print("REMOVE A DVD");
                    break;
                case 5:
                    io.print("EDIT A DVD");
                case 6:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");

           */
                menuSelection = io.readInt("Please select from the above choices.", 1, 6);
                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        io.print("EDIT A DVD");
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");

                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }


    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void removeDvd() throws DVDLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        DVD removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDvd = view.getNewDVDInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DVDLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        DVD dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editDvd() throws DVDLibraryDaoException {
        view.displayEditDvdBanner();//=== Edit DVD ===
        String title = view.getDvdTitleChoice();//asks user to input title
        DVD currentDVD = dao.getDvd(title);//returns title
        if (currentDVD == null) {
            view.displayNullDVD(); //if user inputs non-existing dvd, it will return "no such dvd"
        } else {
            view.displayDvd(currentDVD); //displays current dvd info
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection(); //Editing Menu

                switch (editMenuSelection) {
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMPAA(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editUserRating(title);
                        break;
                    case 5:
                        editStudioName(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
                }
            }

        }

    }

    private int getEditMenuSelection() {
        return view.printMenuAndGetSelection();
    }


    private void editReleaseDate(String title) throws DVDLibraryDaoException {
        view.displayEditReleaseDateBanner();//=== Edit DVD Release Date ===
        String newReleaseDate = view.getNewReleaseDate();//asks input for new release date
        dao.editReleaseDate(title, newReleaseDate);
        view.displayEditDvdSuccess();//displays success in editing
    }

    private void editMPAA(String title) throws DVDLibraryDaoException {
        view.displayEditMPAABanner();
        String newMpaaRating = view.getNewMpaaRating();
        dao.editMPAA(title, newMpaaRating);
        view.displayEditDvdSuccess();
    }

    private void editDirectorName(String title) throws DVDLibraryDaoException {
        view.displayEditDirectorNameBanner();
        String newDirectorName = view.getNewDirectorName();
        dao.editDirectorName(title, newDirectorName);
        view.displayEditDvdSuccess();
    }

    private void editUserRating(String title) throws DVDLibraryDaoException {
        view.displayEditUserRating();
        String newUserRating = view.getNewUserRating();
        dao.editUserRating(title, newUserRating);
        view.displayEditDvdSuccess();
    }

    private void editStudioName(String title) throws DVDLibraryDaoException {
        view.displayEditStudio();
        String newStudioName = view.getNewStudio();
        dao.editStudio(title, newStudioName);
        view.displayEditDvdSuccess();
    }
}
