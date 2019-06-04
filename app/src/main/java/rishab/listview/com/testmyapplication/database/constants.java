package rishab.listview.com.testmyapplication.database;

public class constants {
  String DATABASE_NAME;
    int DATABASE_VERSION;
    String TABLE_NAME;
    String Hours;
    String Mintune;
    String Repeat_days;
    String Label;
    String Tone ;
    String Mode;
    String no_shake;
    String diff_math;
    String no_MATH;
    String KEY_ID;


    public constants() {
    }

    public constants(String id, String hours , String minutes, String repeatingday, String label, String tone, String mode, String noshake, String diffmath, String noofmath) {

        KEY_ID=id;
        Hours=hours;
        Mintune=minutes;
        Repeat_days=repeatingday;
        Label=label;
        Tone=tone;
        Mode=mode;
        no_shake=noshake;
        diff_math=diffmath;
        no_MATH=noofmath;


    }
    public constants( String hours ,String minutes,String repeatingday,String label,String tone,String mode,String noshake,String diffmath,String noofmath) {


        Hours=hours;
        Mintune=minutes;
        Repeat_days=repeatingday;
        Label=label;
        Tone=tone;
        Mode=mode;
        no_shake=noshake;
        diff_math=diffmath;
        no_MATH=noofmath;


    }

    public String getDATABASE_NAME() {
        return DATABASE_NAME;
    }

    public void setDATABASE_NAME(String DATABASE_NAME) {
        this.DATABASE_NAME = DATABASE_NAME;
    }

    public int getDATABASE_VERSION() {
        return DATABASE_VERSION;
    }

    public void setDATABASE_VERSION(int DATABASE_VERSION) {
        this.DATABASE_VERSION = DATABASE_VERSION;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
    }

    public String getMintune() {
        return Mintune;
    }

    public void setMintune(String mintune) {
        Mintune = mintune;
    }

    public String getRepeat_days() {
        return Repeat_days;
    }

    public void setRepeat_days(String repeat_days) {
        Repeat_days = repeat_days;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTone() {
        return Tone;
    }

    public void setTone(String tone) {
        Tone = tone;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public String getNo_shake() {
        return no_shake;
    }

    public void setNo_shake(String no_shake) {
        this.no_shake = no_shake;
    }

    public String getDiff_math() {
        return diff_math;
    }

    public void setDiff_math(String diff_math) {
        this.diff_math = diff_math;
    }

    public String getNo_MATH() {
        return no_MATH;
    }

    public void setNo_MATH(String no_MATH) {
        this.no_MATH = no_MATH;
    }

    public String getKEY_ID() {
        return KEY_ID;
    }

    public void setKEY_ID(String KEY_ID) {
        this.KEY_ID = KEY_ID;
    }
}
