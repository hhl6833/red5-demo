package com.hn6833;

import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IStreamFilenameGenerator;


public class CustomFilenameGenerator implements IStreamFilenameGenerator {
    public String recordPath = "recordedStreams/";
    public String playbackPath = "videoStreams/";
    public boolean resolvesAbsolutePath;

    public String generateFilename(IScope scope, String name, GenerationType type) {
        return generateFilename(scope, name, null, type);
    }

    public String generateFilename(IScope scope, String name, String extension, GenerationType type) {
        String filename;
        if (type == GenerationType.RECORD) {
            filename = recordPath + name;
        } else {
            filename = playbackPath + name;
        }
        if (extension != null) {
            // add the extension
            filename += extension;
        }
        return filename;
    }

    public boolean resolvesToAbsolutePath() {
        return resolvesAbsolutePath;
    }

    public void setRecordPath(String path) {
        recordPath = path;
    }

    public void setPlaybackPath(String path) {
        playbackPath = path;
    }

    public void setAbsolutePath(boolean absolute) {
        resolvesAbsolutePath = absolute;
    }
}