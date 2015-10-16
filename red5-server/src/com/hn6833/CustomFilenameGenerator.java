package com.hn6833;

import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IStreamFilenameGenerator;


public class CustomFilenameGenerator implements IStreamFilenameGenerator {
    public String path = "streams/";
    public boolean resolvesAbsolutePath;

    public String generateFilename(IScope scope, String name, GenerationType type) {
        return this.generateFilename(scope, name, null, type);
    }

    public String generateFilename(IScope scope, String name, String extension, GenerationType type) {
        String filename = path + name;
        if (extension != null) {
            filename += extension;
        }
        return filename;
    }

    public boolean resolvesToAbsolutePath() {
        return resolvesAbsolutePath;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAbsolutePath(boolean absolute) {
        this.resolvesAbsolutePath = absolute;
    }
}
