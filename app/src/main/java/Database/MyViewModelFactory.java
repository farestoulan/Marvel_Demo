package Database;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private final Repository repository;

    public MyViewModelFactory(Repository repository) {
        this.repository =repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MarvelViewModel.class)) {
            return (T) new  MarvelViewModel(repository);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }

    }
}
