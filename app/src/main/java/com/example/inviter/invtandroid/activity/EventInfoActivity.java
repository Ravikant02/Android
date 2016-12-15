package com.example.inviter.invtandroid.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
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
import com.example.inviter.invtandroid.config.AppConfig;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventInfoActivity extends AppCompatActivity{

    @Bind(R.id.btnNext) ImageView btnNext;
    @Bind(R.id.txtEventTitle) EditText txteventTitle;

    Boolean click = true;
    int ACTIVITY_REQUEST_CODE = 1;
    public static String venue;
    private GoogleMap googleMap;
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

        createEvent = CreateEvent.getInstance();
        if(!createEvent.getEventTitle().equals(""))
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


                if (!createEvent.getEventStartDate().equals("")){
                    btnNext.setVisibility(View.VISIBLE);
                    startDate.setText(createEvent.getEventStartDate()+ " "
                            + createEvent.getEventStartTime());
                }
                if(!createEvent.getEventEndDate().equals("")){
                    endDate.setText(createEvent.getEventEndDate()+" "
                            +createEvent.getEventEndTime());
                }

                fragmentLayout = (LinearLayout) dateLayout.findViewById(R.id.fragmentLayout);
                fragmentLayout.setVisibility(View.GONE);

                try {
                    if (googleMap == null) {
                        /*googleMap = ((MapFragment) getFragmentManager().
                                findFragmentById(R.id.map)).getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(GoogleMap gMap) {
                                googleMap = gMap;
                            }
                        });*/
                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        if (!createEvent.getEventVenue().equals("")) {
                            getLocationValues(createEvent.getEventVenue());
                            googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
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
            googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
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
            //
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
        /*CreateEventJSON createEventJSONObject = CreateEventJSON.getInstance();
        createEventJSONObject.eventDetails.eventStartDate = startDate.getText().toString().trim().split(" ")[0];// startDateTime[0];
        createEventJSONObject.eventDetails.eventStartTime = startDate.getText().toString().trim().split(" ")[1];
        createEventJSONObject.eventDetails.eventScheduledDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        createEventJSONObject.eventDetails.eventScheduledTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        if (endDate.getText().toString().equals(""))
        {
            createEventJSONObject.eventDetails.eventEndDate = "0000-00-00";
            createEventJSONObject.eventDetails.eventEndTime = "00:00:00";
        }
        else {
            createEventJSONObject.eventDetails.eventEndDate = endDate.getText().toString().trim().split(" ")[0];// endDateTime[0];
            createEventJSONObject.eventDetails.eventEndTime = endDate.getText().toString().trim().split(" ")[1];

        }
        createEventJSONObject.eventDetails.eventTitle = eventTitle.getText().toString().trim();
        createEventJSONObject.eventDetails.eventVenue = venue;
        //Toast.makeText(getApplicationContext(), venue, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);*/

    }

    private void LocationDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.location_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button btnDone = (Button) dialog.findViewById(R.id.btnDone);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) dialog.findViewById(R.id.autoCompleteTextView);
        if (!createEvent.getEventVenue().isEmpty()) autoCompleteTextView.setText(createEvent.getEventVenue());
        dialog.setCancelable(false);
        dialog.show();
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                autoCompleteTextView.setAdapter(new GooglePlacesAutocompleteAdapter(EventInfoActivity.this, R.layout.locations_list));
                autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        createEvent.setEventVenue((String) adapterView.getItemAtPosition(i));
                    }
                });
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

    class GooglePlacesAutocompleteAdapter extends ArrayAdapter implements Filterable {
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
