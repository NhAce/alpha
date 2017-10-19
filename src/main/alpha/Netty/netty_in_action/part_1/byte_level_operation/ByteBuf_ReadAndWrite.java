package Netty.netty_in_action.part_1.byte_level_operation;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class ByteBuf_ReadAndWrite {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println("buf capacity: " + buf.capacity());
        System.out.println( buf.readBytes(20).toString(utf8));
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println("writerIndex: " + buf.writerIndex());
        buf.writeByte((byte)'?');
        System.out.println("buf capacity: " + buf.capacity());
        System.out.println(buf.toString(utf8));
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println("writerIndex: " + buf.writerIndex());
        System.out.println("maxcapacity: " + buf.maxCapacity());
        System.out.println("hasArray: " + buf.hasArray());
        System.out.println("readableBytes: " + buf.readableBytes());
        System.out.println("writableBytes: " + buf.writableBytes());
    }
}
