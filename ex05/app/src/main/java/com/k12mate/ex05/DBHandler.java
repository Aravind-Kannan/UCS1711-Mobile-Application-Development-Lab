package com.k12mate.ex05;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "PersonDB";
    private static final int DB_VERSION = 1;
    private static final String ID_COL = "id";
    private static final String TABLE_NAME = "Person";
    private static final String NAME_COL = "name";
    private static final String COUNTRY_COL = "country";
    private static final String PHONE_COL = "phone";
    private static final String EMAIL_COL = "email";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + COUNTRY_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + EMAIL_COL + " TEXT UNIQUE)";
        db.execSQL(query);
    }

    public void addNewEntry(String name, String country, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(COUNTRY_COL, country);
        values.put(PHONE_COL, phone);
        values.put(EMAIL_COL, email);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<PersonModel> getInfo() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor PersonCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<PersonModel> Persons = new ArrayList<>();

        if (PersonCursor.moveToFirst()) {
            do {
                Persons.add(
                        new PersonModel(
                            PersonCursor.getInt(0),
                            PersonCursor.getString(1),
                            PersonCursor.getString(2),
                            PersonCursor.getString(3),
                            PersonCursor.getString(4)
                        )
                    );
            } while (PersonCursor.moveToNext());
        }
        PersonCursor.close();

        return Persons;
    }

    public PersonModel getIndividualInfo(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor PersonalInfoCursor =
                db.rawQuery(
                        String.format("SELECT * FROM %s where %s = ?", TABLE_NAME, ID_COL),
                        new String[]{id}
                        );

        if (PersonalInfoCursor.moveToFirst()) {
            return new PersonModel(
                    PersonalInfoCursor.getInt(0),
                    PersonalInfoCursor.getString(1),
                    PersonalInfoCursor.getString(2),
                    PersonalInfoCursor.getString(3),
                    PersonalInfoCursor.getString(4)
            );
        }
        PersonalInfoCursor.close();

        return null;
    }

    public void updateInfo(String id, String name, String country, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(COUNTRY_COL, country);
        values.put(PHONE_COL, phone);
        values.put(EMAIL_COL, email);

        db.update(TABLE_NAME, values, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteEntry(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "id=?", new String[]{id});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}