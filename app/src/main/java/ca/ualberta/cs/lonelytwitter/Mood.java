package ca.ualberta.cs.lonelytwitter;
import java.util.Date
/**
 * Created by minfeng1 on 9/14/17.
 */

public abstract class Mood {
    private String mood;
    private Date date;
}
public void setData(Date date) {
    this.date = date;
}
public void setMood(String mood){
    this.mood = mood;
}