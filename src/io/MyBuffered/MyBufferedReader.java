package io.MyBuffered;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader {
    private Reader reader;

    public MyBufferedReader(Reader reader) {
        this.reader = reader;
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch = reader.read()) != -1) {
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public void close() throws IOException {
        this.reader.close();
    }
}
