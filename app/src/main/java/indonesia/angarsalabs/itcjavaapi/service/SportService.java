package indonesia.angarsalabs.itcjavaapi.service;

import java.util.ArrayList;
import java.util.List;

import indonesia.angarsalabs.itcjavaapi.JadwalListener;
import indonesia.angarsalabs.itcjavaapi.TeamListener;
import indonesia.angarsalabs.itcjavaapi.model.EventsItem;
import indonesia.angarsalabs.itcjavaapi.model.JadwalResponse;
import indonesia.angarsalabs.itcjavaapi.model.TeamResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportService {
    private Retrofit retrofit = null;

    public SportAPI getAPI(){
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(SportAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(SportAPI.class);
    }

    public void getJadwal(final JadwalListener listener){
        getAPI().getJadwal().enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                JadwalResponse data = response.body();

                if(data != null && data.getEvents() != null){
                    listener.onSuccess(data.getEvents());
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getTeamInfo(String team, final TeamListener listener){
        getAPI().getTeam(team).enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                TeamResponse teamResponse = response.body();
                if(teamResponse != null && teamResponse.getTeams() != null){
                    listener.onSuccess(teamResponse.getTeams());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                    listener.onFailed(t.getMessage());
            }
        });
    }
}
