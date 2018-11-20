package Testing;

public class Note {

    private String userid;
    private String privateBool;

    public String toString(){
        return userid + "\n" + privateBool + "\n";
    }

    public void setUserid(String userid){
        System.out.println(userid);
        this.userid = userid;
    }
    public void setPrivateBool(String privateBool){
        System.out.println(privateBool);
        this.privateBool = privateBool;
    }
    public String getUserid(){
        return userid;
    }
    public String getPrivateBool(){
        return privateBool;
    }
}