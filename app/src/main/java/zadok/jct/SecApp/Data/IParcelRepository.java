package zadok.jct.SecApp.Data;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;

public interface IParcelRepository {

    //1.
    public void getUserParcelList(String mail);
    //2.
    public void confirmMessenger_Receiver(Parcel parcel);
    //3.
    public void changeToAccepted_Reciver(Parcel parcel);

    //4.
    public void getMessegerParcelList(double distance, String mail);

    //5.
    public void offerShipping_Messenger(Parcel parcel);


    public MutableLiveData<List<Parcel>> getMuteableParcelList_Messenger();
    public MutableLiveData<List<Parcel>> getMuteableParcelList_Receiver();
}

