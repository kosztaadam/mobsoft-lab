package labor.mobsoft.hu.mobilsoftlab.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Koszta Ádám on 2017. 05. 04..
 */

@Table
public class User extends SugarRecord {
    private Long id;
    private String username;

    public User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
