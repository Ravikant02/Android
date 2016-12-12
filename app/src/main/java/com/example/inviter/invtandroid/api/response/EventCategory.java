package com.example.inviter.invtandroid.api.response;

import java.util.List;

/**
 * Created by Inwiter on 28/03/16.
 */
public class EventCategory {

    public List<Data> data;

    public class Data
    {
            private String name;
            private String categoryColor;

            public String getCategoryColor() {
                return categoryColor;
            }

            public void setCategoryColor(String categoryColor) {
                this.categoryColor = categoryColor;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
    }


}
