package com.example.inviter.invtandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.response.eventslibrary.UserEvent;
import com.example.inviter.invtandroid.core.InviterCore;

import java.util.List;

/**
 * Created by Ravikant on 12/12/16.
 */

public class EventsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<UserEvent> events;
    public EventsAdapter (Context context, List<UserEvent> events){
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return this.events.size();
    }

    @Override
    public Object getItem(int i) {
        return this.events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder ;
        if(view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.event_details_layout, null, false);
            viewHolder.txtEventTitle = (TextView)view.findViewById(R.id.txtEventTitle);
            viewHolder.txtEventFullDate = (TextView)view.findViewById(R.id.txtFullDate);
            viewHolder.txtEventDate = (TextView)view.findViewById(R.id.txtDate);
            viewHolder.txtEventVenue = (TextView)view.findViewById(R.id.txtVenue);
            viewHolder.txtRsvpYes = (TextView)view.findViewById(R.id.txtRsvpYes);
            viewHolder.txtRsvpNo = (TextView)view.findViewById(R.id.txtRsvpNo);
            viewHolder.txtRsvpMaybe = (TextView)view.findViewById(R.id.txtRsvpMayBe);
            viewHolder.txtVidoDuration = (TextView)view.findViewById(R.id.txtVideoDuration);
            viewHolder.imgPlay = (ImageView) view.findViewById(R.id.imgPlay);
            viewHolder.imgShare = (ImageView) view.findViewById(R.id.imgShare);
            viewHolder.imgVideoThumb = (ImageView) view.findViewById(R.id.imgTop);
            viewHolder.progressBarRsvpYes = (ProgressBar) view.findViewById(R.id.circularProgressRsvpYes);
            viewHolder.progressBarRsvpNo = (ProgressBar) view.findViewById(R.id.circularProgressRsvpNo);
            viewHolder.progressBarRsvpMayBe = (ProgressBar) view.findViewById(R.id.circularProgressRsvpMayBe);
            viewHolder.relativeLayoutEventDetails = (RelativeLayout) view.findViewById(R.id.relativeLayoutEventDetails);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)view.getTag();
        }

        final UserEvent event = events.get(i);
        if (event==null) return null;

        if (event.getEventInfo().getEventType().equalsIgnoreCase("0")) viewHolder.relativeLayoutEventDetails.setVisibility(View.GONE);
        viewHolder.txtEventTitle.setText(event.getEventInfo().getEventTitle());
        viewHolder.txtEventVenue.setText(event.getEventInfo().getEventVenue());
        viewHolder.txtEventDate.setText(InviterCore.getShortDate(event.getEventInfo().getEventStartDate()));
        viewHolder.txtRsvpYes.setText(event.getRsvpCount().getYes()+"");
        viewHolder.txtRsvpNo.setText(event.getRsvpCount().getNo()+"");
        viewHolder.txtRsvpMaybe.setText(event.getRsvpCount().getMayBe()+"");
        viewHolder.txtVidoDuration.setText(event.getEventInfo().getEventVideoLength());
        // viewHolder.txtEventFullDate.setText(event.getEventInfo().getEventStartDate()+","+event.getEventInfo().getEventStartTime());
        viewHolder.txtEventFullDate.setText(event.getEventInfo().getEventStartDate()+", "+ InviterCore.getTimeWithString(event.getEventInfo().getEventStartTime()));

        int rsvpYesGuests = (event.getRsvpCount().getYes() * 100) / event.getRsvpCount().getTotalGuests();
        int rsvpNoGuests = (event.getRsvpCount().getNo() * 100) / event.getRsvpCount().getTotalGuests();
        int rsvpMaybeGuests = (event.getRsvpCount().getMayBe() * 100) / event.getRsvpCount().getTotalGuests();

        viewHolder.progressBarRsvpYes.setProgress(rsvpYesGuests);
        viewHolder.progressBarRsvpNo.setProgress(rsvpNoGuests);
        viewHolder.progressBarRsvpMayBe.setProgress(rsvpMaybeGuests);
        viewHolder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, event.getEventInfo().getShareURL());
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        // viewHolder.title.setTag(categories.get(position).getType());

        return view;
    }

    private static class ViewHolder{
        private TextView txtEventTitle;
        private TextView txtEventFullDate;
        private TextView txtEventDate;
        private TextView txtEventVenue;
        private TextView txtRsvpYes;
        private TextView txtRsvpNo;
        private TextView txtRsvpMaybe;
        private TextView txtVidoDuration;
        private ImageView imgPlay;
        private ImageView imgShare;
        private ImageView imgVideoThumb;
        private ProgressBar progressBarRsvpYes;
        private ProgressBar progressBarRsvpNo;
        private ProgressBar progressBarRsvpMayBe;
        private RelativeLayout relativeLayoutEventDetails;
    }
}
