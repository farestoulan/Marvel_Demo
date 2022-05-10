package ModelClasses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

@GET("/v1/public/characters?limit=20&ts=1&apikey=c78f40bb1c616599c702d91d22e35aea&hash=a7dec653688d4d0a0893ed07021ceaac")
Call<DataModelClass> getPhoto();
}
