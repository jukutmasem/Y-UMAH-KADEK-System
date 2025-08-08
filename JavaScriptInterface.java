// File: src/main/java/com/yourpackage/name/JavaScriptInterface.java

package com.yourpackage.name; // Ganti dengan nama paket Anda

import android.content.Context;
import android.os.Build;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class JavaScriptInterface {
    WebView webView;
    Context context;

    JavaScriptInterface(Context c, WebView view) {
        this.context = c;
        this.webView = view;
    }

    @JavascriptInterface
    public void printDocument() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
            String jobName = "Struk Kasir";
            PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);
            printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
        }
    }
}