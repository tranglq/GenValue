package trang.method;

import java.io.File;
import java.io.FileFilter;

public class FolderFile implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (!pathname.isFile()) {
            return false;
        }

        if (pathname.isDirectory()) {
            return true;
        }

        return false;
    }
}
