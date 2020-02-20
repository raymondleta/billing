
package com.poolafrica.billing.mpesa.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CallbackMetadata {

    @SerializedName("Item")
    private List<Item> item;

    public CallbackMetadata(List<Item> item) {
        this.item = item;
    }

    public CallbackMetadata() {
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

}
