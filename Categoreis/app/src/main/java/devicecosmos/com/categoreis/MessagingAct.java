package devicecosmos.com.categoreis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MessagingAct extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/t28.html");
    }
}
