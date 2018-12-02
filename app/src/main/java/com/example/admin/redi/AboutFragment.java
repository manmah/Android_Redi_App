package com.example.admin.redi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class AboutFragment extends Fragment {

    private WebView webViewRedi;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        webViewRedi = view.findViewById(R.id.webViewRedi);
        webViewRedi.getSettings().setJavaScriptEnabled(true);
        webViewRedi.loadUrl("https://www.redi-school.org/mission");

        return view;
    }
}
