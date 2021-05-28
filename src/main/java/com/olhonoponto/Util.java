package com.olhonoponto;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author halle
 */
public class Util {

    public void storeImageIntoFS() {
        try {
            Connection.Response resultImageResponse = Jsoup.connect("").execute();
            String url = this.getClass().getClassLoader().getResource("/template").getPath();
            try (FileOutputStream out = new FileOutputStream(new java.io.File(url))) {
                out.write(resultImageResponse.bodyAsBytes());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
