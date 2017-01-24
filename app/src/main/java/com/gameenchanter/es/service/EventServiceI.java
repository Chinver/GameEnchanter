package com.gameenchanter.es.service;


import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Event;

import java.util.List;

public interface EventServiceI extends BaseServiceI {
    int insertEvent(DatabaseHelper databaseHelper, Event event);

    int UpdateEvent(DatabaseHelper databaseHelper, Event event);

    Event selectEventByIdol(DatabaseHelper databaseHelper, String idol);

    List<Event> selectEvent(DatabaseHelper databaseHelper);

}
