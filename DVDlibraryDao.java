package com.sal.DVDlibrary.dao;

import com.sal.DVDlibrary.dto.DVD;

import java.util.List;

public interface DVDlibraryDao {
    DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException;

    //.    Adds the given Dvd to the library and associates it with the given
    List<DVD> getAllDvds() throws DVDLibraryDaoException;

    // Returns a List of all dvds in the library.
    DVD getDvd(String title) throws DVDLibraryDaoException;

    // Returns the dvd object associated with the given title.
    DVD removeDvd(String title) throws DVDLibraryDaoException;


    DVD editReleaseDate(String title, String newReleaseDate) throws DVDLibraryDaoException;

    DVD editMPAA(String title, String newMpaaRating) throws DVDLibraryDaoException;

    DVD editDirectorName(String title, String newDirectorName) throws DVDLibraryDaoException;

    DVD editUserRating(String title, String newUserRating) throws DVDLibraryDaoException;

    DVD editStudio(String title, String newStudioName) throws DVDLibraryDaoException;
    //Removes from the library the dvd associated with the title.
}
