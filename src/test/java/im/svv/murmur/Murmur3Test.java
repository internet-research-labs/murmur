package im.svv.murmur;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.math.BigInteger;

public class Murmur3Test {

  @Test public void testTrivial() {
    assertTrue(true);
  }

  @Test public void testByteBuffer() {
    byte[] bytes = { 0xa, 0xf, 0xa, 0x1 };
    ByteBuffer buffer = ByteBuffer.wrap(bytes);
  }

  @Test public void testMurmur3Trivial() throws Exception {
    byte[] bytes_01 = { (byte) 0xaa, 0xf, 0xa, 0x1, 0xa, 0xf, 0xa, 0x1 };
    byte[] bytes_02 = { 'r', 'e', 'd', 'd', 'e', 'a', 'd', '1' };
    byte[] bytes_03 = { 'r', 'e', 'd', 'd', 'e', 'a', 'd', '1' };
    byte[] bytes_04 = { 'w', 'h', 'a', 't', 'e', 'v', 'e', 'r' };

    long[] result = new long[2];
    ByteBuffer buffer;
    
    buffer = ByteBuffer.wrap(bytes_01);
    result = Murmur3.murmur3(buffer, 8, 10);

    buffer = ByteBuffer.wrap(bytes_02);
    result = Murmur3.murmur3(buffer, 8, 10);

    buffer = ByteBuffer.wrap(bytes_03);
    result = Murmur3.murmur3(buffer, 8, 10);

    buffer = ByteBuffer.wrap(bytes_04);
    result = Murmur3.murmur3(buffer, 8, 10);

    result = Murmur3.murmur3(23, 10);
    result = Murmur3.murmur3(23L, 10);
    result = Murmur3.murmur3("whatever", 10);
  }
}
