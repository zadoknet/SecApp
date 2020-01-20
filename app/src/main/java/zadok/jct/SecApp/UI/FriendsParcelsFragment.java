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

import zadok.jct.SecApp.R;
import zadok.jct.SecApp.UI.ViewModels.FriendsParcelsViewModel;

public class FriendsParcelsFragment extends Fragment {

    private FriendsParcelsViewModel mViewModel;

    public static FriendsParcelsFragment newInstance() {
        return new FriendsParcelsFragment();
    }
    Button firstButton;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.friends_parcels_fragment, container, false);
        firstButton=(Button)view.findViewById(R.id.button2);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"butttooooooooon",Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = ViewModelProviders.of(this).get(FriendsParcelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
