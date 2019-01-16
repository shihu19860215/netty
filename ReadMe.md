demo1:helloworld

demo2:拆包
demo3:粘包

demo4:解决拆包
    发送数据加入System.getProperty("line.separator")结尾
    使用 BaseServerHandler LineBasedFrameDecoder(2048)可以设置最大接收大小,2048个字节中必须有结束符，否则报错
    使用 BaseServerHandler LineBasedFrameDecoder(1024)真实数据大于1024，在遇到结束符时，总长度大于1024,报错
demo5:解决粘包
    FixedLengthFrameDecoder 固定长度分割
demo6:固定符号分割
demo7:自定义传输协议长度
demo8:google protoc 传输
demo9:心跳测试demo
demo10:断线重连
        
        
        
        
        
        