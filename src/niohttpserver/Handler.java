package niohttpserver;

import java.io.*;
import java.nio.channels.*;

public interface Handler {
    public void handle(SelectionKey key) throws IOException;
}