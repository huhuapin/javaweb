package domain;

public class Root {

    private String username = "root";
    private String password =  "root123";


    private Root() {}

    public static Root getRoot() {

    }

    public void setPassword(String password) {
        this.password = password;
    }


}
