package indonesia.angarsalabs.itcjavaapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import indonesia.angarsalabs.itcjavaapi.model.EventsItem;
import indonesia.angarsalabs.itcjavaapi.model.TeamsItem;
import indonesia.angarsalabs.itcjavaapi.service.SportService;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.VH> {
    private List<EventsItem> items;

    public EventAdapter(List<EventsItem> items){
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final VH holder, int position) {
        EventsItem item = items.get(position);

        holder.tvHome.setText(item.getStrHomeTeam());
        holder.tvAway.setText(item.getStrAwayTeam());
        holder.tvDate.setText(item.getStrDate());

        new SportService().getTeamInfo(item.getStrAwayTeam(), new TeamListener() {
            @Override
            public void onSuccess(List<TeamsItem> items) {
                Picasso.get().load(items.get(0).getStrTeamBadge()).fit().into(holder.ivAway);
            }

            @Override
            public void onFailed(String msg) {

            }
        });

        new SportService().getTeamInfo(item.getStrHomeTeam(), new TeamListener() {
            @Override
            public void onSuccess(List<TeamsItem> items) {
                Picasso.get().load(items.get(0).getStrTeamBadge()).fit().into(holder.ivHome);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView tvAway, tvHome, tvDate;
        ImageView ivHome, ivAway;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvAway = itemView.findViewById(R.id.tv_away);
            tvHome = itemView.findViewById(R.id.tv_home);
            tvDate = itemView.findViewById(R.id.tv_date);

            // TODO: GAmbar
            ivAway = itemView.findViewById(R.id.iv_away);
            ivHome = itemView.findViewById(R.id.iv_home);
        }
    }
}
