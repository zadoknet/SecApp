package zadok.jct.SecApp.Data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;

public class ParcelDataSource implements IParcelDataSource {
    final String TAG="ZAODK";

    //********************Define the connection to firebase*******************
    static DatabaseReference parcelsRef;
    static List<Parcel> parcelsList;
    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelsRef = database.getReference("Parcels");
        parcelsList = new ArrayList<>();

    }
    //**********************************************************************8
    NotifyDataChange<List<Parcel>> notifyDataChange_Receiver=null;
    NotifyDataChange<List<Parcel>> notifyDataChange_Messenger=null;

    //******************CONSTRUTOR***********************************
    public ParcelDataSource()
    {
        notifyToChildList();
    }
    //***********************************************************************
    //***1*****
    @Override
    public void getUserParcelList(String mail, NotifyDataChange notifyDataChange) {
    //todo: delete the mail address???
    //define the notify the run in function notifyToChildList
    notifyDataChange_Receiver=notifyDataChange;
    }
    //***4***
    @Override
    public void getMessegerParcelList(double distance, String mail,NotifyDataChange notifyDataChange) {
    //todo: delete the mail address???
    //define the notify the run in function notifyToChildList
    notifyDataChange_Messenger=notifyDataChange;
    }

    @Override
    public void confirmMessenger_Receiver(Parcel parcel) {
        updateParcel(parcel);
    }

    @Override
    public void changeToAccepted_Reciver(Parcel parcel) {
        updateParcel(parcel);
    }

    @Override
    public void offerShipping_Messenger(Parcel parcel) {
        updateParcel(parcel);
    }

    private void updateParcel(final Parcel parcel)
    {
        //todo: pay attention how to ensure that the removing happen before the set
        parcelsRef.child(parcel.getParcelId()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i(TAG,"remove "+parcel+"success");
                parcelsRef.child(parcel.getParcelId()).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i(TAG,"update"+parcel+"success");
                    }
                });
            }
        });

    }
    private void notifyToChildList()
    {
        ChildEventListener parcelRefChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Parcel parcel=dataSnapshot.getValue(Parcel.class);
                String id=dataSnapshot.getKey();
                parcel.setParcelId(id);

                parcelsList.add(parcel);

                if(notifyDataChange_Receiver!=null)
                    notifyDataChange_Messenger.onDataChanged(parcelsList);
                if(notifyDataChange_Messenger!=null)
                    notifyDataChange_Receiver.onDataChanged(parcelsList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Parcel parcel=dataSnapshot.getValue(Parcel.class);
                String id=dataSnapshot.getKey();
                parcel.setParcelId(id);
                //todo: delete the old parcel from the list by remove if (I need to learn the predicate)
                //parcelsList.removeIf()
                parcelsList.add(parcel);

                if(notifyDataChange_Receiver!=null)
                    notifyDataChange_Messenger.onDataChanged(parcelsList);
                if(notifyDataChange_Messenger!=null)
                    notifyDataChange_Receiver.onDataChanged(parcelsList);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Parcel parcel=dataSnapshot.getValue(Parcel.class);
                String id=dataSnapshot.getKey();
                parcel.setParcelId(id);
                //todo: delete the old parcel from the list by remove if (I need to learn the predicate)
                //parcelsList.removeIf()

                if(notifyDataChange_Receiver!=null)
                    notifyDataChange_Messenger.onDataChanged(parcelsList);
                if(notifyDataChange_Messenger!=null)
                    notifyDataChange_Receiver.onDataChanged(parcelsList);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        parcelsRef.addChildEventListener(parcelRefChildEventListener);
    }


}
