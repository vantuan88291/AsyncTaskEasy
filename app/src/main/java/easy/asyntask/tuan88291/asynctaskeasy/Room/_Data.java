package easy.asyntask.tuan88291.asynctaskeasy.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class _Data {

    @PrimaryKey(autoGenerate = true)
    public long mId;

    @ColumnInfo(name = "name")
    private String name;


    @ColumnInfo(name = "age")
    private int age;

    public _Data(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public _Data(){}

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}