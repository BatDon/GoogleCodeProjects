package com.test.table.roomwordssample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                    // Wipes and rebuilds instead of migrating
                    // if no Migration object.
                    // Migration is not part of this practical.
                           .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        WordRoomDatabase wordRoomDatabase;
        WordDao wordDao;
        String[] words = {"Dolphin", "Shark", "Lion"};

        public PopulateDbAsync(WordRoomDatabase wordRoomDatabase){
            this.wordRoomDatabase=wordRoomDatabase;
            wordDao=wordRoomDatabase.wordDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAll();
            for (int i = 0; i < words.length; i++) {
                Word word = new Word(words[i]);
                wordDao.insert(word);
            }
            return null;
        }
    }
}