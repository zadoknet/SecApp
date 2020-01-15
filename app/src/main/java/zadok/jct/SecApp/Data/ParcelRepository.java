package zadok.jct.SecApp.Data;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.common.util.Predicate;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

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

    //*************MutaableLiveDate  fields****************************************8
    IParcelDataSource parcelDataSource=new ParcelDataSource();
    private MutableLiveData<List<Parcel>> muteableParcelList_Receiver=new MutableLiveData<>();
    private MutableLiveData<List<Parcel>> muteableParcelList_Messenger=new MutableLiveData<>();

    public MutableLiveData<List<Parcel>> getMuteableParcelList_Receiver() {
        return muteableParcelList_Receiver;
    }

    public MutableLiveData<List<Parcel>> getMuteableParcelList_Messenger() {
        return muteableParcelList_Messenger;
    }
//***********************************************************************************************


    private ParcelRepository(){

    }

    //****1***
    @Override
    public void getUserParcelList(final String mail) {
        parcelDataSource.getUserParcelList(mail, new IParcelDataSource.NotifyDataChange() {
            @Override
            public void onDataChanged(Object obj) {
                List<Parcel> parcelList=(List<Parcel>)obj;
                Iterator itr = parcelList.iterator();
                while (itr.hasNext())
                {
                    Parcel parcel = (Parcel) itr.next();
                    if (NotOwnedToReceiver(parcel)&&Accepted(parcel))
                        itr.remove();
                }
                muteableParcelList_Receiver.postValue(parcelList);

            }

            private boolean Accepted(Parcel parcel) {
                return(Parcel.ParcelStatus.ACCEPTED==parcel.getStatus());
            }

            private boolean NotOwnedToReceiver(Parcel parcel) {
                return !(mail==parcel.getMail());
            }

            private boolean notConfirmed(Parcel parcel) {
                return true;
            }

            private boolean ownedToTheReceiver(Parcel parcel) {
                return true;
            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
    }
    //***2
    @Override
    public void confirmMessenger_Receiver(Parcel parcel) {
        parcelDataSource.confirmMessenger_Receiver(parcel);
    }
    //***3
    @Override
    public void changeToAccepted_Reciver(Parcel parcel) {
        parcelDataSource.changeToAccepted_Reciver(parcel);
    }

    //***4
    @Override
    public void getMessegerParcelList(double distance, String mail) {
        parcelDataSource.getUserParcelList(mail, new IParcelDataSource.NotifyDataChange() {
            @Override
            public void onDataChanged(Object obj) {
                List<Parcel> parcelList=(List<Parcel>)obj;
                //todo: create the predicate
                Iterator itr = parcelList.iterator();
                while (itr.hasNext())
                {
                    Parcel parcel = (Parcel) itr.next();
                    if (bigDistance(parcel)&&Confirmed(parcel))
                        itr.remove();
                }
                muteableParcelList_Receiver.postValue(parcelList);

            }

            private boolean bigDistance(Parcel parcel) {
                //todo: implement this
                return true;

            }

            private boolean Confirmed(Parcel parcel) {
                return(Parcel.ParcelStatus.ON_THE_WAY==parcel.getStatus()
                        || Parcel.ParcelStatus.ACCEPTED==parcel.getStatus()); }

            @Override
            public void onFailure(Exception exception) {

            }
        });
    }

    @Override
    public void offerShipping_Messenger(Parcel parcel) {
        parcelDataSource.offerShipping_Messenger(parcel);
    }
}
