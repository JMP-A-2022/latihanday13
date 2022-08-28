package com.fitrizuyinanurazizah.latihanday13;

import android.accounts.Account;

import androidx.recyclerview.widget.ItemTouchHelper;

import com.fitrizuyinanurazizah.latihanday13.model.Session;

public class Application extends android.app.Application {

    public String deskripsi;
    public String amount;
    private static Session session;

    public Application(String deskripsi, String amount) {
        this.deskripsi = deskripsi;
        this.amount = amount;
    }

    public void onCreate() {
        super.onCreate();
        account = new Account("Budi");;
        ItemTouchHelper.SimpleCallback;

        session = new Session(this);

    }
    public static Session getSession() {
        return session;
    }
}
