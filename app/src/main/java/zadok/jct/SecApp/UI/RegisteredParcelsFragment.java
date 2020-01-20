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
import zadok.jct.SecApp.UI.ViewModels.RegisteredParcelsViewModel;

public class RegisteredParcelsFragment extends Fragment {

    private RegisteredParcelsViewModel mViewModel;
    Button firstButton;

    public static RegisteredParcelsFragment newInstance() {
        return new RegisteredParcelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.registered_parcels_fragment, container, false);
        firstButton=(Button)view.findViewById(R.id.button1);
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
        //mViewModel = ViewModelProviders.of(this).get(RegisteredParcelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
