/*
 * NormalTweet
 *
 * September 28th, 2017
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at
 *
 *
 */
package ca.ualberta.cs.lonelytwitter;
import java.util.Date;
/**
 * Created by minfeng1 on 9/14/17.
 */

/**
 * @see Tweet
 * @return isImportant
 * @author minfeng1
 */

public class NormalTweet extends Tweet{
    public NormalTweet (String message){
        super(message);
    }
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
