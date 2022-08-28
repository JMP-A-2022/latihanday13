package com.fitrizuyinanurazizah.latihanday13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.widget.TextView;

import com.fitrizuyinanurazizah.latihanday13.model.Session;

public class MainActivity extends AppCompatActivity implements TransactionAdapter.OnItemTransactionListener {
    TextView welcomeText;
    TextView totalText;
    private Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeText = findViewById(R.id.welcome_text);
        totalText = findViewById(R.id.tx_total);

        RecyclerView rvResult = findViewById(R.id.rv_result);

        session = Application.getSession();

        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onTransactionClicked(int index, SurfaceControl.Transaction item) {
        welcomeText.setText(String.format("Welcome %s", account.getName()));
        totalText.setText(String.valueOf(account.getBalance()));

        adapter = new TransactionAdapter(account.getTransactions(), this);
        transactionsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        transactionsView.setLayoutManager(layoutManager);

        Intent intent = new Intent(this, SaveActivity.class);
        intent.putExtra(TRANSACTION_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
        return true;

        else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
    }
}