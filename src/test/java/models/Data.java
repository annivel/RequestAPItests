package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private AccountIfo data;

    public AccountIfo getData() {
        return data;
    }

    public void setData(AccountIfo data) {
        this.data = data;
    }
}
