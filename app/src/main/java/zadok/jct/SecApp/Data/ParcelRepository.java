package zadok.jct.SecApp.Data;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;

public class ParcelRepository implements IParcelRepository {

    //***********************Define this class as a singleton class***************
    private static ParcelRepository parcelRepository_instance=null;
    private static ParcelRepository getInstance()
    {
        if(parcelRepository_instance==null)
            parcelRepository_instance=new ParcelRepository();
        return parcelRepository_instance;
    }
    //************************************************************

    IParcelDataSource parcelDataSource=new ParcelDataSource();
    MutableLiveData<List<Parcel>> muteableParcelList_Receiver=new MutableLiveData<>();
    MutableLiveData<List<Parcel>> muteableParcelList_Messenger=new MutableLiveData<>();
    private ParcelRepository(){

    }

    //****1***
    @Override
    public void getUserParcelList(String mail) {
        parcelDataSource.getUserParcelList(mail, new IParcelDataSource.NotifyDataChange() {
            @Override
            public void onDataChanged(Object obj) {
                List<Parcel> parcelList=(List<Parcel>)obj;
                //todo: create the predicate
                parcelList.removeIf();
                muteableParcelList_Receiver.postValue(parcelList);

            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
    }

    @Override
    public void getMessegerParcelList(double distance, String mail) {
        parcelDataSource.getUserParcelList(mail, new IParcelDataSource.NotifyDataChange() {
            @Override
            public void onDataChanged(Object obj) {
                List<Parcel> parcelList=(List<Parcel>)obj;
                //todo: create the predicate
                parcelList.removeIf();
                muteableParcelList_Receiver.postValue(parcelList);

            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
    }
}
