package Netty.netty_in_action.part_1.byte_level_operation;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class ByteBuf_Slice {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in action rocks!", utf8);
        ByteBuf sliced = buf.slice(2, 14);
        System.out.println(sliced.toString(utf8));
        buf.setByte(0, (byte)'J');
        System.out.println("buf: " + buf.toString(utf8));
        System.out.println("sliced: " + sliced.toString(utf8));
//        assert buf.getByte(0) == sliced.getByte(0);
    }
}
