<template>
    <div class="hello">
        <h1> websocket 消息推送测试：{{data}}</h1>


    </div>
<!--    <div class="roomStyle">-->
<!--        <br>欢迎使用<strong>VueTest</strong>极简聊天室：<br/><br/>-->
<!--        <textarea id="content" v-model="content" cols="60" rows="30" readonly="readonly"></textarea><br>-->
<!--        <input type="text" v-model="message">-->
<!--        <button type="button" @click="websocketsend()">发送消息</button>-->
<!--        <br/><br/>-->
<!--&lt;!&ndash;        用户：<input type="text" v-model="user">&ndash;&gt;-->
<!--&lt;!&ndash;        <button @click="joinRoom()">加入群聊</button>&ndash;&gt;-->
<!--&lt;!&ndash;        <button @click="exitRoom()">退出群聊</button>&ndash;&gt;-->
<!--    </div>-->
</template>

<script>
    export default {
        name: 'HelloWorld',
        data () {
            return {
                data:0,
                timeout: 28 * 1000,//30秒一次心跳
                timeoutObj: null,//心跳心跳倒计时
                serverTimeoutObj: null,//心跳倒计时
                timeoutnum: null,//断开 重连倒计时
                websocket: null,
                user: '',
                message: '',
                content: '',

            }
        },
        created () {
            // 初始化websocket
            this.initWebSocket()
        },
        methods:{
            initWebSocket () {
                // alert("你已经再聊天室");
                let url = 'ws://192.168.1.8:8084/websocket/testsocket'
                this.websocket = new WebSocket(url)
                // 连接错误
                this.websocket.onerror = this.setErrorMessage

                // 连接成功
                this.websocket.onopen = this.setOnopenMessage

                // 收到消息的回调
                this.websocket.onmessage = this.setOnmessageMessage

                // 连接关闭的回调
                this.websocket.onclose = this.setOncloseMessage

                // 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
                window.onbeforeunload = this.onbeforeunload
            },
            reconnect () { // 重新连接
                if(this.lockReconnect) return;
                this.lockReconnect = true;
                //没连接上会一直重连，设置延迟避免请求过多
                this.timeoutnum && clearTimeout(this.timeoutnum);
                this.timeoutnum = setTimeout(() => {
                    //新连接
                    this.initWebSocket();
                    this.lockReconnect = false;
                }, 5000);
            },
            reset () { // 重置心跳
                // 清除时间
                clearTimeout(this.timeoutObj);
                clearTimeout(this.serverTimeoutObj);
                // 重启心跳
                this.start();
            },
            start () { // 开启心跳
                this.timeoutObj && clearTimeout(this.timeoutObj);
                this.serverTimeoutObj && clearTimeout(this.serverTimeoutObj);
                this.timeoutObj = setTimeout(() => {
                    // 这里发送一个心跳，后端收到后，返回一个心跳消息，
                    if (this.websocket && this.websocket.readyState == 1) { // 如果连接正常
                        this.websocketsend('heartbeat');
                    } else { // 否则重连
                        this.reconnect();
                    }
                    this.serverTimeoutObj = setTimeout(() => {
                        //超时关闭
                        this.websocket.close();
                    }, this.timeout);

                }, this.timeout)
            },
            setOnmessageMessage (event) {
                let obj = JSON.parse(event.data);
                console.log("obj",obj)
                switch(obj.type) {
                    case 'heartbeat':
                        //收到服务器信息，心跳重置
                        this.reset();
                        break;
                    case 'sendMessage':
                        this.data = obj.data
                        console.log("接收到的服务器消息：",obj.data)
                }

            },
            setErrorMessage () {
                //重连
                this.reconnect();
                console.log("WebSocket连接发生错误" + '   状态码：' + this.websocket.readyState)
            },
            setOnopenMessage () {
                //开启心跳
                this.start();
                console.log("WebSocket连接成功" + '   状态码：' + this.websocket.readyState)
            },
            setOncloseMessage () {
                //重连
                this.reconnect();
                console.log( "WebSocket连接关闭" + '   状态码：' + this.websocket.readyState)
            },
            onbeforeunload () {
                this.closeWebSocket();
            },
            //websocket发送消息
            websocketsend(messsage) {
                // alert(messsage);
                this.websocket.send(messsage+"11")
            },
            closeWebSocket() { // 关闭websocket
                this.websocket.close()
            },
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    /*h1, h2 {*/
    /*    font-weight: normal;*/
    /*}*/
    /*ul {*/
    /*    list-style-type: none;*/
    /*    padding: 0;*/
    /*}*/
    /*li {*/
    /*    display: inline-block;*/
    /*    margin: 0 10px;*/
    /*}*/
    /*a {*/
    /*    color: #42b983;*/
    /*}*/
    .roomStyle{
        text-align: center;
        background-color: rgba(15, 161, 230, 0.35);
        margin: 0 auto;
        border: 1px solid #000;
        width: 600px;
        height: 650px
    }

</style>
