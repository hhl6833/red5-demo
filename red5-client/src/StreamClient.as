package {
public class StreamClient {
    public function StreamClient() {
    }

    public function onMetaData(info:Object):void {
        for (var n:* in info) {
            trace(n + ":" + info[n]);
        }
    }

    public function onPlayStatus(info:Object):void {
        for (var n:* in info) {
            trace(n + ":" + info[n]);
        }
    }
}
}
