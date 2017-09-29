/*
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at
 */

/*
 * Class Name:Tweet
 * Version: 1.0
 * Date: Sep. 28, 2017
 *
 *

 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by minfeng1 on 9/14/17.
 */
/**
 * Represents a Tweet
 *
 * @author YourName
 * @version 1.0
 * @see NormalTweet
 * @see ImpotantTweet
 * @since 1.0

 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }
/**
 * Construct Tweet object

 * @param message tweet message
 * @param date tweet date
 *
 *
 */

    /**
     *
     * @param message Tweet message
     */
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    /**
     *
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= 140) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}