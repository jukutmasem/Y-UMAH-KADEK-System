// Contoh di dalam metode onCreate() di MainActivity.java
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
// ... (import lainnya)

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Sesuaikan dengan nama layout Anda

        myWebView = (WebView) findViewById(R.id.webview); // Sesuaikan dengan ID WebView di layout XML Anda
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        // PENTING: Menghubungkan antarmuka JavaScript dan Android
        myWebView.addJavascriptInterface(new JavaScriptInterface(this, myWebView), "Android");

        // Memuat file HTML lokal dari folder assets
        myWebView.loadUrl("file:///android_asset/index.html");
    }
}