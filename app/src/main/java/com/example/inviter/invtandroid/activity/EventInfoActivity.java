package com.example.inviter.invtandroid.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.response.createevent.CreateEvent;
import com.example.inviter.invtandroid.api.response.eventslibrary.EventInfo;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.Loggers;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventInfoActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Bind(R.id.btnNext) ImageView btnNext;
    @Bind(R.id.txtEventTitle) EditText txteventTitle;

    Boolean click = true;
    int ACTIVITY_REQUEST_CODE = 1;
    public static String venue;
    private GoogleMap gMap;
    double lat= 0.0, lng= 0.0;
    LinearLayout fragmentLayout;
    public ImageView btnLocation;
    String[] items;
    private CreateEvent createEvent;
    EditText startDate;
    EditText endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        ButterKnife.bind(this);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnNext.setVisibility(View.GONE);
        txteventTitle.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);

        createEvent = CreateEvent.getInstance();
        if(createEvent.getEventTitle()!=null)
            txteventTitle.setText(createEvent.getEventTitle());

        txteventTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, final KeyEvent event) {
                LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
                LinearLayout dateLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.date_layout, null);

                startDate = (EditText) dateLayout.findViewById(R.id.txtStartDate);
                endDate = (EditText) dateLayout.findViewById(R.id.txtEndDate);
                final TextView endDateLbl = (TextView) dateLayout.findViewById(R.id.lblEndDate);
                btnLocation = (ImageView) dateLayout.findViewById(R.id.btnLocation);

                startDate.setInputType(InputType.TYPE_NULL);
                endDate.setInputType(InputType.TYPE_NULL);


                if (createEvent.getEventStartDate()!=null){
                    btnNext.setVisibility(View.VISIBLE);
                    startDate.setText(createEvent.getEventStartDate()+ " "
                            + createEvent.getEventStartTime());
                }
                if(createEvent.getEventEndDate()!=null){
                    endDate.setText(createEvent.getEventEndDate()+" "
                            +createEvent.getEventEndTime());
                }

                fragmentLayout = (LinearLayout) dateLayout.findViewById(R.id.fragmentLayout);
                fragmentLayout.setVisibility(View.GONE);

                try {
                    if (gMap == null) {
                        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                        mapFragment.getMapAsync(EventInfoActivity.this);
                        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        if (createEvent.getEventVenue()!=null) {
                            getLocationValues(createEvent.getEventVenue());
                            gMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
                            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
                            fragmentLayout.setVisibility(View.VISIBLE);
                            btnLocation.setVisibility(View.GONE);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                startDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventDateTimeDialogBuilder(R.string.select_event_start_date, startDate, "");
                        if (startDate.length() >= 0) btnNext.setVisibility(View.VISIBLE);
                        else btnNext.setVisibility(View.GONE);
                    }
                });

                endDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventDateTimeDialogBuilder(R.string.select_event_end_date, endDate,
                                startDate.getText().toString().split(" ")[0]);

                    }
                });

                endDateLbl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*if (click) {
                            endDate.setVisibility(View.VISIBLE);
                            endDateLbl.setCompoundDrawablesWithIntrinsicBounds(R.drawable.minus_icon,
                                    0, 0, 0);
                            click = false;
                        } else {
                            endDate.setVisibility(View.GONE);
                            endDateLbl.setCompoundDrawablesWithIntrinsicBounds(R.drawable.plus_icon,
                                    0, 0, 0);
                            click = true;
                        }*/
                    }
                });

                btnLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*Intent intent = new Intent(EventInfoActivity.this,
                                EventVenuePickerActivity.class);
                        intent.putExtra("venue", venue);
                        startActivityForResult(intent, ACTIVITY_REQUEST_CODE);*/
                        locationDialog();
                    }
                });

                mainLayout.addView(dateLayout);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null)
        {
            venue = data.getStringExtra(venue);
            getLocationValues(venue);
            gMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
            fragmentLayout.setVisibility(View.VISIBLE);
            btnLocation.setVisibility(View.GONE);
        }
    }

    private void getLocationValues(String address)
    {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocationName(address , 1);
            if (addresses.size() > 0)
            {
                lat = addresses.get(0).getLatitude();
                lng = addresses.get(0).getLongitude();

            }
        }
        catch (Exception ex){
            Loggers.error("MAP ERROR==="+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void eventDateTimeDialogBuilder(int dialogTitle, final EditText editText,
                                           final String eventSelectedStartDate)
    {
        Calendar currentDate = Calendar.getInstance();
        int mYear = currentDate.get(Calendar.YEAR);
        int mMonth = currentDate.get(Calendar.MONTH);
        int mDay = currentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog datePicker = new DatePickerDialog(EventInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                final int eventYear = year;
                final int eventMonth = monthOfYear + 1;
                final int eventDay = dayOfMonth;

                final TimePickerDialog timePicker = new TimePickerDialog(EventInfoActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String format;
                        if (hourOfDay == 0) {
                            hourOfDay += 12;
                            format = "AM";
                        } else if (hourOfDay == 12) {
                            format = "PM";
                        } else if (hourOfDay > 12) {
                            hourOfDay -= 12;
                            format = "PM";
                        } else {
                            format = "AM";
                        }
                        editText.setText(new StringBuilder().append(eventYear)
                                .append("-").append(eventMonth).append("-")
                                .append(eventDay).append(" ").append(hourOfDay).append(":")
                                .append(minute).append(":00").append(" ").append(format));
                    }
                }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, false);
                timePicker.setTitle("Select Event Time");
                timePicker.show();
            }

        }, mYear, mMonth, mDay);
        datePicker.setTitle(dialogTitle);
        datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1);

        /*if (!eventSelectedStartDate.equals("")) {
            Calendar tmpDate = Calendar.getInstance();
            tmpDate.add(tmpDate.DATE, Integer.valueOf(eventSelectedStartDate.split("-")[2]));
            tmpDate.add(tmpDate.MONTH, Integer.valueOf(eventSelectedStartDate.split("-")[1]));
            tmpDate.add(tmpDate.YEAR, Calendar.YEAR -1);
            datePicker.getDatePicker().setMinDate(tmpDate.getTimeInMillis());
        }*/
        datePicker.show();
    }

    @OnClick(R.id.btnNext)
    public void btnNextClick() {
        CreateEvent createEvent = CreateEvent.getInstance();
        createEvent.setEventStartDate(startDate.getText().toString().trim().split(" ")[0]);
        createEvent.setEventStartTime(startDate.getText().toString().trim().split(" ")[1]);
        if (endDate.getText().toString().equals("")) {
            createEvent.setEventEndDate("0000-00-00");
            createEvent.setEventEndTime("00:00:00");
        }
        else {
            createEvent.setEventEndDate(endDate.getText().toString().trim().split(" ")[0]);// endDateTime[0];
            createEvent.setEventEndTime(endDate.getText().toString().trim().split(" ")[1]);
        }
        createEvent.setEventTitle(txteventTitle.getText().toString().trim());
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }

    private void locationDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.location_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button btnDone = (Button) dialog.findViewById(R.id.btnDone);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) dialog.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
        autoCompleteTextView.setAdapter(new GooglePlacesAutocompleteAdapter(EventInfoActivity.this, R.layout.locations_list));
        if (createEvent.getEventVenue()!=null) autoCompleteTextView.setText(createEvent.getEventVenue());
        dialog.setCancelable(false);
        dialog.show();
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (autoCompleteTextView.getText().toString().trim().isEmpty()) return;
                createEvent.setEventVenue(autoCompleteTextView.getText().toString().trim());
                getLocationValues(createEvent.getEventVenue());
                gMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
                fragmentLayout.setVisibility(View.VISIBLE);
                btnLocation.setVisibility(View.GONE);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    public static ArrayList autocomplete(String input) {

        ArrayList resultList = null;
        List<EventLocation> eventLocations = null;
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(AppConfig.PLACES_API_BASE + AppConfig.TYPE_AUTOCOMPLETE
                    + AppConfig.OUT_JSON);
            sb.append("?key=" + AppConfig.API_KEY);
            //sb.append("&components=country:gr");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));
            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            return resultList;
        } catch (IOException e) {
            return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        try {
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");
            resultList = new ArrayList(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
            }
        } catch (JSONException e) {
            //
        }
        return resultList;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
    }

    private class GooglePlacesAutocompleteAdapter extends ArrayAdapter implements Filterable {
        private ArrayList resultList;
        private List<EventLocation> eventLocations;
        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }
        @Override
        public int getCount() {
            //return eventLocations.size();
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            //return eventLocations.get(index);
            //return resultList.get(index);
            return resultList.get(index).toString();
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        // Retrieve the autocomplete results.
                        resultList = autocomplete(constraint.toString());
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();

                        /*eventLocations = autocomplete(constraint.toString());
                        filterResults.values = eventLocations;
                        filterResults.count = eventLocations.size();*/
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }

    static class EventLocation{
        public String placeName;
        public String placeID;

        public String getPlaceName(){
            return this.placeName;
        }

        public void setPlaceName(String placeName)
        {
            this.placeName = placeName;
        }

        public String getPlaceID(){
            return this.placeName;
        }

        public void setPlaceID(String placeID)
        {
            this.placeID = placeID;
        }
    }

}
