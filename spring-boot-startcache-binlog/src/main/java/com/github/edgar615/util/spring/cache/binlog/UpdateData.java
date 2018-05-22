package com.github.edgar615.util.spring.cache.binlog;

import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Edgar on 2018/5/21.
 *
 * @author Edgar  Date 2018/5/21
 */
public class UpdateData implements DmlData {

  private final List<Map<Integer, Object>> data = new ArrayList<>();

  private final String database;

  private final String table;


  public UpdateData(Event tableMap, Event updateRows) {
    TableMapEventData tableMapEventData = tableMap.getData();
    this.database = tableMapEventData.getDatabase();
    this.table = tableMapEventData.getTable();
    UpdateRowsEventData updateRowsEventData = updateRows.getData();
    BitSet bitSet = updateRowsEventData.getIncludedColumns();
    List<Map.Entry<Serializable[], Serializable[]>> rows = updateRowsEventData.getRows();
    for (Map.Entry<Serializable[], Serializable[]> entry : rows) {
      Map<Integer, Object> rowMap = new HashMap<>();
      data.add(rowMap);
      for (int i = 0; i < bitSet.size(); i++) {
        if (bitSet.get(i)) {
          rowMap.put(i, entry.getValue()[i]);
        }
      }
    }
  }

  public String database() {
    return database;
  }

  public String table() {
    return table;
  }

  public List<Map<Integer, Object>> data() {
    return data;
  }

  @Override
  public DmlType type() {
    return DmlType.UPDATE;
  }

  @Override
  public String toString() {
    return "UpdateData{" +
           "data=" + data +
           ", database='" + database + '\'' +
           ", table='" + table + '\'' +
           '}';
  }
}
