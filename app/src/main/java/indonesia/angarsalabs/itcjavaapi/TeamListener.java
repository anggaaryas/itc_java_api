package indonesia.angarsalabs.itcjavaapi;

import java.util.List;

import indonesia.angarsalabs.itcjavaapi.model.TeamsItem;

public interface TeamListener {
    void onSuccess(List<TeamsItem> items);
    void onFailed(String msg);
}
