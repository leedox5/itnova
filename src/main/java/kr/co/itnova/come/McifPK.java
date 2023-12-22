package kr.co.itnova.come;

import javax.persistence.Column;
import java.io.Serializable;

public class McifPK implements Serializable {

    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;
    private String key6;

    public McifPK() {

    }

    public McifPK(String key1, String key2, String key3, String key4, String key5, String key6) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key5 = key5;
        this.key6 = key6;
    }
}
