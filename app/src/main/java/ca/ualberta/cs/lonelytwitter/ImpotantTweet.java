package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by minfeng1 on 9/14/17.
 */

public class ImpotantTweet extends Tweet {
    public ImpotantTweet(String message){
        super(message);
    }
    public ImpotantTweet(String message, Date date) {
        super(message, date);
    }
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
