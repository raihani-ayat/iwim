package com.example.iwim.ui.login;

/**
 * Class exposing authenticated com.example.iwim.data.com.example.iwim.ui.slideshow.user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
