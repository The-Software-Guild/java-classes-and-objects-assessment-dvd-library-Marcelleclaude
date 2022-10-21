package com.sal.DVDlibrary.dao;

import com.sal.DVDlibrary.dto.DVD;

import java.io.*;
import java.util.*;

// in here we made ClassRosterDaoFileImpl implement the ClassRosterDao interface.
public class DVDlibraryDaoFileImpl  implements DVDlibraryDao{

    private Map<String, DVD> DvD = new HashMap<>();

    private static final String LIBRARY_FILE = "Library.txt";

    public static final String DELIMITER = "::";


    //A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).

    private DVD unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        DVD dvdFromFile = new DVD(title);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.

        // Index 1 - Release date
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - MPAA
        dvdFromFile.setMPAA(dvdTokens[2]);

        // Index 3 - Director's name
        dvdFromFile.setDirectorsName(dvdTokens[3]);

        // Index 4 - user ratings
        dvdFromFile.setUserRating(dvdTokens[4]);

        // Index 5 - studio name
        dvdFromFile.setStudio(dvdTokens[5]);

        // We have now created a student! Return it!
        return dvdFromFile;
    }
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;


        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent student unmarshalled
        DVD currentDvd;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            DvD.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    private String marshallDvd(DVD aDvd){
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // release
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // mpaa
        dvdAsText += aDvd.getMPAA() + DELIMITER;

        // director's name
        dvdAsText += aDvd.getDirectorsName() + DELIMITER;

        // user ratings
        dvdAsText += aDvd.getUserRating() + DELIMITER;

        // studio name - don't forget to skip the DELIMITER here.
        dvdAsText += aDvd.getStudio();

        // We have now turned a student to text! Return it!
        return dvdAsText;
    }
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDvds();
        //for each dvd in our  dvd list
        for (DVD currentdVd: dvdList) {
            // turn a Student into a String
            dvdAsText = marshallDvd(currentdVd);
            // write the Student object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    @Override //The HashMap class has many useful methods. For example, to add items to it, use the put() method:
    public DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException{
        loadLibrary();
        DVD prevDvd = DvD.put(title,dvd);
        writeLibrary();
        return prevDvd;
    }

    @Override
    public List<DVD> getAllDvds() throws DVDLibraryDaoException{
        loadLibrary();
        //To access a value in the HashMap, use the get() method and refer to its key:
        //in order words it will allow the user to retrieve sone DVD information
        return new ArrayList<DVD>(DvD.values());
        //reading in a file..it load into a dvd map (since we are creating a map)
    }

    @Override
    public DVD getDvd(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return DvD.get(title);
    }

    @Override
    public DVD removeDvd(String title) throws DVDLibraryDaoException {
        loadLibrary();
        //To remove all items, use the clear() method:
        //To remove an item, use the remove() method and refer to the key
        DVD removedDvd = DvD.remove(title);
        writeLibrary();
        return removedDvd;
    }
    @Override
    public DVD editReleaseDate(String title, String newReleaseDate) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editDvd = DvD.get(title);
        editDvd.setReleaseDate(newReleaseDate);
        writeLibrary();
        return editDvd;
    }

    @Override
    public DVD editMPAA(String title, String newMpaaRating) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editDvd = DvD.get(title);
        editDvd.setReleaseDate(newMpaaRating);
        writeLibrary();
        return editDvd;
    }

    @Override
    public DVD editDirectorName(String title, String newDirectorName) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editDvd = DvD.get(title);
        editDvd.setReleaseDate(newDirectorName);
        writeLibrary();
        return editDvd;
    }

    @Override
    public DVD editUserRating(String title, String newUserRating) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editDvd = DvD.get(title);
        editDvd.setReleaseDate(newUserRating);
        writeLibrary();
        return editDvd;
    }

    @Override
    public DVD editStudio(String title, String newStudioName) throws DVDLibraryDaoException {
        loadLibrary();
        DVD editDvd = DvD.get(title);
        editDvd.setReleaseDate(newStudioName);
        writeLibrary();
        return editDvd;
    }
}

