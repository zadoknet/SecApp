package zadok.jct.SecApp.Data;

import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;

public interface IParcelDataSource {


    //1.
    public void getUserParcelList(String mail, NotifyDataChange notifyDataChange);

    //2.
    public void confirmMessenger_Receiver(Parcel parcel);

    //3.
    public void changeToAccepted_Reciver(Parcel parcel);

    //4.
    public void getMessegerParcelList(double distance, String mail, NotifyDataChange<List<Parcel>> notifyDataChange);

    //5.
    public void offerShipping_Messenger(Parcel parcel);


    public interface NotifyDataChange<T> {
        void onDataChanged(T obj);

        void onFailure(Exception exception);
    }
}
