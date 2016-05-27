package com.example.mvpdemo.model;

/**
 * Created by pratyush on 4/5/16.
 */
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DDGOPhoto implements Parcelable {

    public static final String DDGO_BASE_URL = "https://safe.duckduckgo.com/";
    public static final String DDGO_PARAMETER_URL = "/i.js?q=%@&ia=images&kp=1";

    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<>();

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return The query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }


    public DDGOPhoto() {
    }

    protected DDGOPhoto(Parcel in) {
        next = in.readString();
        query = in.readString();
        if (in.readByte() == 0x01) {
            results = new ArrayList<>();
            in.readList(results, Result.class.getClassLoader());
        } else {
            results = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(next);
        dest.writeString(query);
        if (results == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(results);
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<DDGOPhoto> CREATOR = new Creator<DDGOPhoto>() {
        @Override
        public DDGOPhoto createFromParcel(Parcel in) {
            return new DDGOPhoto(in);
        }

        @Override
        public DDGOPhoto[] newArray(int size) {
            return new DDGOPhoto[size];
        }
    };

    @Override
    public String toString() {
        return "DDGOPhoto{" +
                "next='" + next + '\'' +
                ", query='" + query + '\'' +
                ", results=" + results +
                '}';
    }
}