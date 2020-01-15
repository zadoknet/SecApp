package zadok.jct.SecApp.UI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import zadok.jct.SecApp.Data.IParcelRepository;
import zadok.jct.SecApp.Data.ParcelRepository;
import zadok.jct.SecApp.Entities.Parcel;

public class FriendsParcelsViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    IParcelRepository repository=ParcelRepository.getInstance();
    public MutableLiveData<List<Parcel>> getMuteableParcelList()
    {
        return repository.getMuteableParcelList_Messenger();
    }

}
