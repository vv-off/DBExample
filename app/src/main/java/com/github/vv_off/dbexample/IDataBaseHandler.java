package com.github.vv_off.dbexample;

import java.util.List;

public interface IDataBaseHandler {
    public DataDB getDataDB(int id);
    public List<DataDB> getAllDataDB();
    public int countDataDB();
    public void addDataDB(DataDB dataDB);
    public int updateDataDB(DataDB dataDB);
    public void deleteDataDB(DataDB dataDB);
    public void deleteAll();
}
