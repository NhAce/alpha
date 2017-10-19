package Netty.netty_in_action.part_1.byte_level_operation;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class ByteBuf_Copy {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        ByteBuf copied = buf.copy(0,14);
        System.out.println("copy 1: " + copied.toString(utf8));
        buf.setByte(0,(byte)'J');
        System.out.println("buf: " + buf.toString(utf8));
        System.out.println("copy 2: " + copied.toString(utf8));

    }
}
