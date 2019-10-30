package indonesia.angarsalabs.itcjavaapi;

import java.util.List;

import indonesia.angarsalabs.itcjavaapi.model.EventsItem;

public interface JadwalListener {
    void onSuccess(List<EventsItem> items);
    void onFailed(String msg);
}
