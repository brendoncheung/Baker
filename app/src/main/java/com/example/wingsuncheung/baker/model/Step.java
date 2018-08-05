package com.example.wingsuncheung.baker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;

@Data
@Parcel
public class Step {

    @SerializedName("id") @Expose Integer id;
    @SerializedName("shortDescription") @Expose String shortDescription;
    @SerializedName("description") @Expose String description;
    @SerializedName("videoURL") @Expose String videoURL;
    @SerializedName("thumbnailURL") @Expose String thumbnailURL;
}
