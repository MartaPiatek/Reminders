package pl.martapiatek.reminders;

/**
 * Created by Marta on 24.06.2017.
 */

public class Reminder {

    private int mId;
    private String mContent;
    private int mImportant;

    public Reminder(int id, String content, int important) {
        mId = id;
        mContent = content;
        mImportant = important;
    }

    public int getId() {
        return mId;
    }

    public String getContent() {
        return mContent;
    }

    public int getImportant() {
        return mImportant;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public void setImportant(int important) {
        mImportant = important;
    }

}
