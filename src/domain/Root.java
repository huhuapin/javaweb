package domain;

public class Root {

    private String username = "root";
    private String password =  "root123";

    private static Root root = new Root();

    private Root() {}

    public static Root getRoot() {
        return root;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
