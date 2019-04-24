package com.ctech.max.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.ctech.max.criminalintent.Crime;
import com.ctech.max.criminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    // get the crime details out of the Database and store them in a Crime object
    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Columns.UUID));
        String title = getString(getColumnIndex(CrimeTable.Columns.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Columns.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Columns.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved == 1);

        return crime;
    }
}
