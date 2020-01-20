package zadok.jct.SecApp.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;
import zadok.jct.SecApp.R;
import zadok.jct.SecApp.UI.ViewModels.FriendsParcelsViewModel;


public class FriendsParcelsFragment extends Fragment {

    FriendsParcelsViewModel mViewModel;

    public static FriendsParcelsFragment newInstance() {
        return new FriendsParcelsFragment();
    }
    Button firstButton;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel= ViewModelProviders.of((FragmentActivity) getActivity()).get(FriendsParcelsViewModel.class);
        // mViewModel = ViewModelProviders.of(this).get(FriendsParcelsViewModel.class);
        final View view=inflater.inflate(R.layout.friends_parcels_fragment, container, false);
        firstButton=(Button)view.findViewById(R.id.button2);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"butttooooooooon",Toast.LENGTH_LONG).show();

            }
        });
        //**************define the obsever**************
        mViewModel.getMuteableParcelList().observe((LifecycleOwner) getActivity(), new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                Toast.makeText(getActivity(),"parcels",Toast.LENGTH_LONG).show();
            }
        });
        //***********turn on the notify*******************
        //todo: change the mail address to the appropriate address and also on the distance
        mViewModel.getFrinetList(12,"zadoknet@gmail.com");
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // mViewModel = ViewModelProviders.of(androidx.fragment.app.Fragment.instantiate(this)).get(FriendsParcelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
