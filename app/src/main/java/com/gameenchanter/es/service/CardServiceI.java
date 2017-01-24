package com.gameenchanter.es.service;


import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Card;

public interface CardServiceI extends BaseServiceI {
    int insertCard(DatabaseHelper databaseHelper, Card card);

    int updateCard(DatabaseHelper databaseHelper, Card card);

}
