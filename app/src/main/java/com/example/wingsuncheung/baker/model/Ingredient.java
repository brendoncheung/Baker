package com.example.wingsuncheung.baker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;

@Data
@Parcel
public class Ingredient {

    @SerializedName("quantity") @Expose Double quantity;
    @SerializedName("measure") @Expose String measure;
    @SerializedName("ingredient") @Expose String ingredient;

}
