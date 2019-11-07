package indonesia.angarsalabs.itcjavaapi.service;

import indonesia.angarsalabs.itcjavaapi.model.JadwalResponse;
import indonesia.angarsalabs.itcjavaapi.model.TeamResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportAPI {
    static final String URL_BASE = "https://www.thesportsdb.com/";

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<JadwalResponse> getJadwal();

    @GET("api/v1/json/1/searchteams.php")
    Call<TeamResponse> getTeam(@Query("t") String team);

}
