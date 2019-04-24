package com.example.newsimple;

import android.provider.BaseColumns;

public class TaskDBschema {
    public static final class TaskTable implements BaseColumns{
        public static final String TABLE_NAME = "taskList";
        public static final String HEADER = "header";
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String ADDRESS_LAT = "addressLat";
        public static final String ADDRESS_LONG = "addressLong";
        public static final String PAYOUT = "payout";
        public static final String CONTACT_EMAIL = "contactEmail";
        public static final String CONTACT_PHONE = "contactPhone";
        public static final String TIMESTAMP = "timeStamp";
    }
}
