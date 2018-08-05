package com.example.wingsuncheung.baker.model;

import com.example.wingsuncheung.baker.model.Ingredient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

import lombok.Data;
@Data
@Parcel
public class Bake {
    @SerializedName("id") @Expose Integer id;
    @SerializedName("name") @Expose String name;
    @SerializedName("ingredients") @Expose List<Ingredient> ingredients = null;
    @SerializedName("steps") @Expose List<Step> steps = null;
    @SerializedName("servings") @Expose Integer servings;
    @SerializedName("image") @Expose String image;
}
