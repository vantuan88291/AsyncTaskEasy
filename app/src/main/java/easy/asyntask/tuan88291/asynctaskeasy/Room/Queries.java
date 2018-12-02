package easy.asyntask.tuan88291.asynctaskeasy.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface Queries {

    @Insert
    void insertData(_Data item);

    @Query("select * from user")
    List<_Data> getAll();
}