package com.example.inviter.invtandroid.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
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
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
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
            viewHolder.progressBarRsvpNo = (ProgressBar) view.findViewById(R.id.circularProgressRsvpMayBe);
            viewHolder.relativeLayoutEventDetails = (RelativeLayout) view.findViewById(R.id.relativeLayoutEventDetails);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)view.getTag();
        }

        UserEvent event = events.get(i);
        if (event==null) return null;

        if (event.eventInfo.eventType.equalsIgnoreCase("0")) viewHolder.relativeLayoutEventDetails.setVisibility(View.GONE);
        viewHolder.txtEventTitle.setText(event.eventInfo.eventTitle);
        viewHolder.txtEventVenue.setText(event.eventInfo.eventVenue);
        viewHolder.txtEventDate.setText(event.eventInfo.eventStartDate);
        viewHolder.txtRsvpYes.setText(event.rsvpCount.yes+"");
        viewHolder.txtRsvpNo.setText(event.rsvpCount.no+"");
        viewHolder.txtRsvpMaybe.setText(event.rsvpCount.mayBe+"");
        viewHolder.txtVidoDuration.setText(event.eventInfo.eventVenue);
        viewHolder.txtEventFullDate.setText(event.eventInfo.eventVenue);

        int rsvpYesGuests = (event.rsvpCount.yes * 100) / event.rsvpCount.totalGuests;
        int rsvpNoGuests = (event.rsvpCount.no * 100) / event.rsvpCount.totalGuests;
        int rsvpMaybeGuests = (event.rsvpCount.mayBe * 100) / event.rsvpCount.totalGuests;

        viewHolder.progressBarRsvpYes.setProgress(rsvpYesGuests);
        viewHolder.progressBarRsvpNo.setProgress(rsvpNoGuests);
        viewHolder.progressBarRsvpMayBe.setProgress(rsvpMaybeGuests);
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
