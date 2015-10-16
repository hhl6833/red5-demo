<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>测试</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <script type='text/javascript' src='jquery1.11.3.js'></script>
        <script type='text/javascript' src='jwplayer.js'></script>
    </head>
    <body>
        <div id="container"></div>
        <input type="button" class="player-play" value="播放"/>
        <input type="button" class="player-stop" value="停止"/>
        <input type="button" class="player-status" value="取得状态"/>
        <input type="button" class="player-current" value="当前播放秒数"/>
        <input type="button" class="player-goto" value="转到第30秒播放"/>
        <input type="button" class="player-length" value="视频时长(秒)"/>
        <script type="text/javascript">
            var thePlayer;
            $(function () {
                thePlayer = jwplayer('container').setup({
                    'flashplayer': 'player.swf',
                    'file': 'b.mp4',
                    'streamer': 'rtmp://localhost/red5-server',
                    'controlbar': 'bottom',
                    'width': '848',
                    'height': '360'
                });

                //播放 暂停
                $('.player-play').click(function () {
                    if (thePlayer.getState() != 'PLAYING') {
                        thePlayer.play(true);
                        this.value = '暂停';
                    } else {
                        thePlayer.play(false);
                        this.value = '播放';
                    }
                });

                //停止
                $('.player-stop').click(function () {
                    thePlayer.stop();
                });

                //获取状态
                $('.player-status').click(function () {
                    var state = thePlayer.getState();
                    var msg;
                    switch (state) {
                        case 'BUFFERING':
                            msg = '加载中';
                            break;
                        case 'PLAYING':
                            msg = '正在播放';
                            break;
                        case 'PAUSED':
                            msg = '暂停';
                            break;
                        case 'IDLE':
                            msg = '停止';
                            break;
                    }
                    alert(msg);
                });

                //获取播放进度
                $('.player-current').click(function () {
                    alert(thePlayer.getPosition());
                });

                //跳转到指定位置播放
                $('.player-goto').click(function () {
                    if (thePlayer.getState() != 'PLAYING') {    //若当前未播放，先启动播放器
                        thePlayer.play();
                    }
                    thePlayer.seek(15); //从指定位置开始播放(单位：秒)
                });

                //获取视频长度
                $('.player-length').click(function () {
                    alert(thePlayer.getDuration());
                });
            });
        </script>
    </body>
</html>
