package zadok.jct.SecApp.UI;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zadok.jct.SecApp.R;

public class RegisteredParcelsFragment extends Fragment {

    private RegisteredParcelsViewModel mViewModel;

    public static RegisteredParcelsFragment newInstance() {
        return new RegisteredParcelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registered_parcels_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegisteredParcelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
