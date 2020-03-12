package zadok.jct.SecApp.UI;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
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
import zadok.jct.SecApp.UI.ViewModels.RegisteredParcelsViewModel;
import zadok.jct.SecApp.Utils.RegisteredParcelAdapter;

import static android.content.Context.MODE_PRIVATE;

public class RegisteredParcelsFragment extends Fragment {
//*****************adapter
    private ListView lv;
    private RegisteredParcelAdapter customeAdapter;
    private List<Parcel> parcelModelArrayList;
//*************************************************



    private RegisteredParcelsViewModel mViewModel;
    Button firstButton;
    SharedPreferences sharedPreferences;

    public static RegisteredParcelsFragment newInstance() {

        return new RegisteredParcelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.registered_parcels_fragment, container, false);

        mViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(RegisteredParcelsViewModel.class);
//************************************ADAPTER
        lv=(ListView)view.findViewById(R.id.listView);

//************************************

        //***********define the observer
        mViewModel.getMuteableParcelList().observe((LifecycleOwner) getActivity(), new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                Toast.makeText(getActivity(),"parcels",Toast.LENGTH_LONG).show();
                parcelModelArrayList=parcels;
                //*******************adapter
                customeAdapter=new RegisteredParcelAdapter(getActivity(),parcelModelArrayList);
                lv.setAdapter(customeAdapter);
                


                //*******************************************
            }
        });
        //*******define the notify
        //todo: change to the appropriate mail address
        sharedPreferences= getActivity().getSharedPreferences("USER DETAILS",MODE_PRIVATE);
        mViewModel.getUserParcelList("zadoknet@gmail.com");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(RegisteredParcelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
