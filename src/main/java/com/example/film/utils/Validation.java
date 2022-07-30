package com.example.film.utils;

import com.example.film.model.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]{5,13}$";
    public static final String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9!@#$%]{5,13}$";
    public static final String EMAIL_REGEX_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";

    public static final String TITLE_REGEX_PATTERN = "^[ĄČĘĖĮŠŲŪŽąčęėįšųūžA-Za-z0-9_)(!@#$%^&*?/.,;:' -]{5,70}$";
    public static final String ID_REGEX_PATTERN = "^[0-9]{1,13}$";
    public static final String SUMMARY_REGEX_PATTERN = "^[ĄČĘĖĮŠŲŪŽąčęėįšųūžA-Za-z0-9_)(!@#$%^&*?/.,;:' -]{5,500}$";
    public static final String IMDB_REGEX_PATTERN = "^[0-9]+.[0-9]{1,1}$";


    public static boolean isValidUsername(String username) {
        //Sukuriamos validacijos taisyklės pagal anksčiau apsirašytą šabloną
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        //Validacijos atitikmens sukūrimas palyginant vartotojo įvestą username su validacijos taisyklėmis
        Matcher matcher = pattern.matcher(username);
        //Grąžins true jeigu atitiks vartotojo susikurtas vardas mūsų susikurtą validaciją, priešingu atveju - false.
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean isValidTitle(String title) {
        Pattern pattern = Pattern.compile(TITLE_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(title);
        return matcher.find();
    }

    public static boolean isValidId(String id) {
        Pattern pattern = Pattern.compile(ID_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(id);
        return matcher.find();
    }

    public static boolean isValidSummary(String summary) {
        Pattern pattern = Pattern.compile(SUMMARY_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(summary);
        return matcher.find();
    }

    public static boolean isValidIMDB(String imdb) {
        Pattern pattern = Pattern.compile(IMDB_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(imdb);
        return matcher.find();
    }

    public static boolean chechUsernameDublication(String username){
        String getUsername = UserDao.searchByUsernameReturnUsername(username);
        if(getUsername.equals(username)) return false;
        else return true;
    }

    public static boolean chechEmailDublication(String email){
        String getEmail = UserDao.searchByEmailReturnEmail(email);
        if(getEmail.equals(email)) return false;
        else return true;
    }
}
