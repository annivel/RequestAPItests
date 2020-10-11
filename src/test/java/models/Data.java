package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private AccountIfo accountIfo;

    public AccountIfo getAccountIfo() {
        return accountIfo;
    }

    public void setAccountIfo(AccountIfo accountIfo) {
        this.accountIfo = accountIfo;
    }
}
