package com.sal.DVDlibrary;

import com.sal.DVDlibrary.dao.DVDLibraryDaoException;
import com.sal.DVDlibrary.dao.DVDlibraryDao;
import com.sal.DVDlibrary.dao.DVDlibraryDaoFileImpl;
import com.sal.DVDlibrary.ui.DVDlibraryView;
import com.sal.DVDlibrary.ui.UserIO;
import com.sal.DVDlibrary.ui.UserIOConsoleImpl;
import com.sal.DVDlibraryController.DVDlibraryController;

public class App {
    /*
    Now we need to add the main method to the App class so we can test our menu system.
    In this method, we will instantiate our controller and call the run method.
     */
/*
Instantiation mean to call the constructor of a class that creates an instance or object of the type of that class.
 In other words, creating an object of the class is called instantiation.
 It occupies the initial memory for the object and returns a reference.
 syntax for instantiation is: ClassName objName = new ClassName();
 */
    public static void main(String[] args) throws DVDLibraryDaoException {

        UserIO myIo = new UserIOConsoleImpl();
        DVDlibraryView myView = new DVDlibraryView(myIo);
        DVDlibraryDao myDao = new DVDlibraryDaoFileImpl();
        DVDlibraryController controller =
                new DVDlibraryController(myDao, myView);
        controller.run();
    }
}
