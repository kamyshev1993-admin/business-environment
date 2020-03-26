package main.java.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.InvalidPathException;

public class ResourceFactory {

    public synchronized static String stringFromFileBy(String path) {
        String scriptString = null;
        File scriptFile;
        try {
            scriptFile = new File(ResourceFactory.class.getClassLoader().getResource(path).toURI());
        } catch (Exception e) {
            throw new InvalidPathException("Can not locate File for resource path = " + path, e.getMessage());
        }
        try {
            scriptString = FileUtils.readFileToString(scriptFile, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scriptString;
    }
}
