package cookies;

import java.util.ArrayList;
import java.util.List;

public class Cookies {
    private String type;

    public Cookies(int id) {
        type = ""+id;
    }

    public String getType() {
        return type;

    }
    @Override
    public String toString() {
        return "Cookies{" +
                "type='" + type + '\'' +
                '}';
    }
}
