package Database;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ModelClasses.DataModelClass;

public class MarvelViewModel extends ViewModel {

    private final Repository repository;

    public MarvelViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<DataModelClass> getVolumesResponseLiveData() {
        return repository.getdata();
    }
}
