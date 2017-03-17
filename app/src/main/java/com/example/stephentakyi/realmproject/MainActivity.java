package com.example.stephentakyi.realmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to create an instance of the realmObject
        //you call this anytime you need to use realm
        Realm realm = Realm.getDefaultInstance();

        //to get if a user is logged in
        User user = realm.where(User.class).findFirst();

        User userObject = new User();
        userObject.id = "0001";
        userObject.age = 23;
        userObject.name = "Nana Kofi";
        userObject.sessionId = 123;

        //to begin the saving of the user
        //any realm action must be done within the " beginTransaction" method and the "commitTransaction" method
        realm.beginTransaction();

        //to save or to update if there is already a user in the database with similar details
        realm.copyToRealmOrUpdate(userObject);

        //it end the whole action that is required to do
        //once this method is used it ends the realm action
        realm.commitTransaction();

    }
}
